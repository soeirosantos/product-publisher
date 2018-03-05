package br.com.soeirosantos.products.indexer;

import br.com.soeirosantos.products.domain.entity.Product;
import org.springframework.stereotype.Component;

@Component
public interface ProductIndexer {

	void index(Product product);

}
