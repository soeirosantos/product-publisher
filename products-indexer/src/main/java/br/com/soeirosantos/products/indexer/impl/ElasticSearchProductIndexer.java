package br.com.soeirosantos.products.indexer.impl;

import br.com.soeirosantos.products.domain.entity.Product;
import br.com.soeirosantos.products.domain.repository.ProductElasticSearchRepository;
import br.com.soeirosantos.products.indexer.ProductIndexer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
class ElasticSearchProductIndexer implements ProductIndexer {

	private final ProductElasticSearchRepository productElasticSearchRepository;

	ElasticSearchProductIndexer(ProductElasticSearchRepository productElasticSearchRepository) {
		this.productElasticSearchRepository = productElasticSearchRepository;
	}

	@Override
	public void index(Product product) {
		try {

			//TODO: Error handling and tracing
			productElasticSearchRepository.save(product);

		} catch (Exception e) {
			log.error("Error indexing product to ElasticSearch", e);
		}
	}
}
