package team.sipe.office.global.jpa;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EncryptDecryptConverterTest {

    private static final String SECRET_KEY = "abcdefghijkmnopq";

    @Test
    void convertToDatabaseColumn() {
        final EncryptDecryptConverter encryptDecryptConverter = new EncryptDecryptConverter(SECRET_KEY);
        final String encode = encryptDecryptConverter.convertToDatabaseColumn("password");
        final String decode = encryptDecryptConverter.convertToEntityAttribute(encode);

        assertEquals("password", decode);
    }
}
