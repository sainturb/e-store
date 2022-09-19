package miu.edu.payment.service;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import miu.edu.payment.client.OrderClient;
import miu.edu.payment.client.ShipmentClient;
import miu.edu.payment.dto.PaymentRequestDTO;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class RestService {
    private final OrderClient orderClient;
    private final ShipmentClient shipmentClient;
    public void shipToAddress(PaymentRequestDTO paymentRequest) {
        shipmentClient.ship(paymentRequest.getAddress());
    }

    public void orderStatus(String orderNumber, String status, String reason) {
        Map<String, Object> body = new HashMap<>();
        if (Objects.nonNull(reason)) {
            body.put("reason", reason);
        }
        orderClient.updateStatus(orderNumber, status, body);
    }

}
