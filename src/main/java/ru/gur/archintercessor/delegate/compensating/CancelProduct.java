package ru.gur.archintercessor.delegate.compensating;

import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;
import ru.gur.archintercessor.Interection.CrudShotRestClient;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CancelProduct implements JavaDelegate {

    private final CrudShotRestClient restClient;

    @Override
    public void execute(DelegateExecution delegateExecution) {
        restClient.deleteProduct((UUID) delegateExecution.getVariable("productId"));
    }
}
