package br.com.soeirosantos.products.listener;

import br.com.soeirosantos.products.domain.entity.Product;
import br.com.soeirosantos.products.indexer.ProductIndexer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaProductIndexListener {

	private final ProductIndexer productIndexer;

	public KafkaProductIndexListener(ProductIndexer productIndexer) {
		this.productIndexer = productIndexer;
	}

	@KafkaListener(topics = "products")
	public void processProduct(Product product) {
		productIndexer.index(product);
		log.info("Product indexed to ElasticSearch ID: {}", product.getId());
	}

}
