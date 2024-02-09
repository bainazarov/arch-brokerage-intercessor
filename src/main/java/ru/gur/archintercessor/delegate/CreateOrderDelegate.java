package ru.gur.archintercessor.delegate;

import lombok.RequiredArgsConstructor;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;
import ru.gur.archintercessor.Interection.CrudShotRestClient;
import ru.gur.archintercessor.Interection.request.Categories;
import ru.gur.archintercessor.Interection.request.CreateProductRequest;

import java.math.BigDecimal;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CreateOrderDelegate implements JavaDelegate {

    private final CrudShotRestClient restClient;

    @Override
    public void execute(DelegateExecution delegateExecution) {
        try {
            final UUID orderId = restClient.createProduct(CreateProductRequest.builder()
                    .article("12345321")
                    .name("Рыбка")
                    .description("Безумно вкусный")
                    .categories(Categories.FISH)
                    .price(BigDecimal.valueOf(50.00))
                    .quantity(10)
                    .build());

            delegateExecution.setVariable("productId", orderId);
        } catch (Exception e) {
            throw new BpmnError("123");
        }
    }
}
