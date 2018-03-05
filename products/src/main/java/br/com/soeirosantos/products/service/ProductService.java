package br.com.soeirosantos.products.service;

import br.com.soeirosantos.products.client.ProductPublishingClient;
import br.com.soeirosantos.products.domain.entity.Product;
import br.com.soeirosantos.products.domain.repository.ProductRepository;
import br.com.soeirosantos.products.exception.ProductNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

	private final ProductRepository productRepository;
	private final ProductPublishingClient productPublishingClient;

	public ProductService(ProductRepository productRepository, ProductPublishingClient productPublishingClient) {
		this.productRepository = productRepository;
		this.productPublishingClient = productPublishingClient;
	}

	public Product save(Product product) {
		product = productRepository.save(product);
		//TODO Error handling and tracing
		productPublishingClient.publish(product);
		return product;
	}

	public List<Product> list() {
		return productRepository.findAll();
	}

	public Product findById(Long id) {
		Optional<Product> optionalProduct = productRepository.findById(id);
		return optionalProduct.orElseThrow(ProductNotFoundException::new);
	}
}
