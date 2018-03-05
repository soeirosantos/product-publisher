package br.com.soeirosantos.products.domain.repository;

import br.com.soeirosantos.products.domain.entity.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

public interface ProductElasticSearchRepository extends ElasticsearchCrudRepository<Product, String> { }
