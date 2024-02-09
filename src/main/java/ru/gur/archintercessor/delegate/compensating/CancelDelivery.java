package ru.gur.archintercessor.delegate.compensating;

import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;
import ru.gur.archintercessor.Interection.DeliveryStub;
import ru.gur.archintercessor.Interection.PaymentStub;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CancelDelivery implements JavaDelegate {

    private final DeliveryStub deliveryStub;

    @Override
    public void execute(DelegateExecution delegateExecution) {
        deliveryStub.deleteDelivery((UUID) delegateExecution.getVariable("productId"));
    }
}
