package br.com.soeirosantos.products.resource;

import br.com.soeirosantos.products.domain.entity.Product;
import br.com.soeirosantos.products.publisher.ProductPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/publishing/products")
@Slf4j
public class ProductPublishingResource {

	private final ProductPublisher productPublisher;

	public ProductPublishingResource(ProductPublisher productPublisher) {
		this.productPublisher = productPublisher;
	}

	@PostMapping
	ResponseEntity<?> post(@Valid @RequestBody Product product) {
		try {
			productPublisher.publish(product);
			return ResponseEntity.ok(product);
		} catch (Exception e) {
			log.error("Error publishing product", e);
			// TODO: create custom response error message
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}
