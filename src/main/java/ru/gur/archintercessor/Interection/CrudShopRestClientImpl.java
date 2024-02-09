package ru.gur.archintercessor.Interection;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import ru.gur.archintercessor.Interection.request.CreateProductRequest;

import java.util.UUID;

@Component
@RequiredArgsConstructor
@Slf4j
public class CrudShopRestClientImpl implements CrudShotRestClient {

    private final RestTemplate exchangeRateRestTemplate;

    @Override
    public UUID createProduct(final CreateProductRequest request) {
        try {
            log.info("Делаем вызов на создание продукта из сервиса CrudShop ");

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<CreateProductRequest> httpEntity = new HttpEntity<>(request, headers);

            return exchangeRateRestTemplate.postForObject("/my-app/products",
                    httpEntity, UUID.class);
        } catch (Exception e) {
            log.error("Ошибка создание продукта из сервиса CrudShop: " + e.getMessage());
            return null;
        }
    }

    @Override
    public ResponseEntity<Void> deleteProduct(final UUID id) {
        try {
            log.info("Делаем вызов на удаление продукта из сервиса CrudShop ");

            HttpHeaders headers = new HttpHeaders();
            HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
            String url = UriComponentsBuilder.fromPath("/my-app/products")
                    .pathSegment(id.toString())
                    .build()
                    .toString();

            return exchangeRateRestTemplate.exchange(url,
                    HttpMethod.DELETE, requestEntity, Void.class);
        } catch (Exception e) {
            log.error("Ошибка удаление продукта из сервиса CrudShop: " + e.getMessage());
            return null;
        }
    }
}
