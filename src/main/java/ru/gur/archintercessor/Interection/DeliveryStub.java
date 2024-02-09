package ru.gur.archintercessor.Interection;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class DeliveryStub {

    public String createDelivery(UUID orderId) {
        return "Доставка на ваш заказ успешно создана " + orderId;
    }

    public String deleteDelivery (UUID orderId) {
        return "Доставка на ваш заказ успешна отменена " + orderId;
    }
}
