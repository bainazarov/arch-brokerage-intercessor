package ru.gur.archintercessor.Interection;

import org.springframework.http.ResponseEntity;
import ru.gur.archintercessor.Interection.request.CreateProductRequest;

import java.util.UUID;

public interface CrudShotRestClient {
    UUID createProduct(CreateProductRequest request);

    ResponseEntity<Void> deleteProduct(UUID id);
}
