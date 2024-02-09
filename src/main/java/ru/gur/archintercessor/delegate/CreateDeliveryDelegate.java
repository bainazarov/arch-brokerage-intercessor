package ru.gur.archintercessor.delegate;

import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;
import ru.gur.archintercessor.Interection.DeliveryStub;
import ru.gur.archintercessor.Interection.PaymentStub;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CreateDeliveryDelegate implements JavaDelegate {

    private final DeliveryStub deliveryStub;

    @Override
    public void execute(DelegateExecution delegateExecution) {

        try {

            var test = deliveryStub.createDelivery((UUID) delegateExecution.getVariable("productId"));
            System.out.println(test);
        } catch (Exception e) {
            throw new BpmnError("123");
        }
    }
}
