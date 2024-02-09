package ru.gur.archintercessor.Interection;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class PaymentStub {

    public String createPayment(UUID orderId) {
        return "Ваш заказ успешно оплачен " + orderId;
    }

    public String deletePayment (UUID orderId) {
        return "Ваш заказ успешно отменен " + orderId;
    }
}
