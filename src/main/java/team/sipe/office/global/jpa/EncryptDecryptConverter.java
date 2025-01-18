package team.sipe.office.global.jpa;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Optional;

@Component
@Converter
public class EncryptDecryptConverter implements AttributeConverter<String, String> {

    private static final String CIPHER_TRANSFORMATION = "AES/ECB/PKCS5Padding";
    private static final String ALGORITHM = "AES";
    private static final int BEGIN_INDEX = 0;
    private static final int KEY_SIZE = 16;

    private final String secretKey;
    private final SecretKeySpec secretKeySpec;
    private final Cipher encryptCipher;
    private final Cipher decryptCipher;

    public EncryptDecryptConverter(@Value("${office.secret-key}") String secretKey) {
        if (secretKey.length() != KEY_SIZE) {
            throw new IllegalArgumentException("스크릿 키 사이즈는 " + KEY_SIZE + " 이어야 합니다.");
        }
        this.secretKey = secretKey;
        this.secretKeySpec = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), ALGORITHM);
        this.encryptCipher = createCipher(Cipher.ENCRYPT_MODE, secretKeySpec);
        this.decryptCipher = createCipher(Cipher.DECRYPT_MODE, secretKeySpec);
    }

    private Cipher createCipher(final int mode, final Key key) {
        try {
            final Cipher cipher = Cipher.getInstance(CIPHER_TRANSFORMATION);
            cipher.init(mode, key);
            return cipher;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException e) {
            throw new RuntimeException("Failed to initialize cipher", e);
        }
    }

    @Override
    public String convertToDatabaseColumn(final String attribute) {
        return Optional.ofNullable(attribute)
                .map(this::encrypt)
                .orElse(null);
    }

    @Override
    public String convertToEntityAttribute(final String dbData) {
        return Optional.ofNullable(dbData)
                .map(this::decrypt)
                .orElse(null);
    }

    private String encrypt(final String plainText) {
        try {
            final byte[] encryptedData = cipherOperation(encryptCipher, plainText.getBytes());
            return Base64.getEncoder().encodeToString(encryptedData);
        } catch (Exception e) {
            throw new RuntimeException("Encryption failed", e);
        }
    }

    private String decrypt(final String encryptedText) {
        try {
            final byte[] decodedData = Base64.getDecoder().decode(encryptedText);
            final byte[] decryptedData = cipherOperation(decryptCipher, decodedData);
            return new String(decryptedData);
        } catch (Exception e) {
            throw new RuntimeException("Decryption failed", e);
        }
    }

    private byte[] cipherOperation(final Cipher cipher, final byte[] input) {
        try {
            return cipher.doFinal(input);
        } catch (IllegalBlockSizeException | BadPaddingException e) {
            throw new RuntimeException("Cipher operation failed", e);
        }
    }
}