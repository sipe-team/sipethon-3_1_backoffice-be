package team.sipe.office.modules.attendance.infrastructure.qrcode;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "qrCodeClient", url = "https://api.qrserver.com/v1/create-qr-code/")
public interface QrCodeGenerateClient {

    @GetMapping
    byte[] generateQrCode(@RequestParam("size") String size, @RequestParam("data") String data);
}
