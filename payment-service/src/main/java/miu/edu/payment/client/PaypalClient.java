package miu.edu.payment.client;

import miu.edu.payment.dto.PaymentRequestDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@FeignClient(name = "paypal-service", url = "${paypal-service.ribbon.listOfServers}")
public interface PaypalClient {
    @PostMapping("/api/pay")
    void checkout(@RequestBody PaymentRequestDTO body);

    @GetMapping("/api/test")
    void test();
}
