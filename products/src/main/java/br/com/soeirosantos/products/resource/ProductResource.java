package br.com.soeirosantos.products.resource;

import br.com.soeirosantos.products.domain.entity.Product;
import br.com.soeirosantos.products.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductResource {

	private final ProductService productService;

	public ProductResource(ProductService productService) {
		this.productService = productService;
	}

	@PostMapping
	ResponseEntity<?> post(@RequestBody Product product) {
		product = productService.save(product);
		return ResponseEntity.ok(product);
	}

	@GetMapping
	List<?> list() {
		return productService.list();
	}

	@GetMapping("/{id}")
	ResponseEntity<?> get(@PathVariable Long id) {
		return ResponseEntity.ok(productService.findById(id));
	}

}
