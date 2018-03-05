package br.com.soeirosantos.products.client;

import br.com.soeirosantos.products.domain.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
@Slf4j
public class ProductPublishingClient {

	private final RestTemplate restTemplate;

	public ProductPublishingClient(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public void publish(Product product) {
		try {
			//TODO service discovery
			restTemplate.postForEntity("http://localhost:8280/publishing/products", product, Product.class);

		} catch (HttpClientErrorException e) {
			String message = "Error publishing changes for product " + product.getId();
			log.error(message);
			//TODO: Specialize exception
			throw new RuntimeException(message, e);
		}
	}

}
