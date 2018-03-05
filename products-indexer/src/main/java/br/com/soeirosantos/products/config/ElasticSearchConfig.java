package br.com.soeirosantos.products.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories("br.com.soeirosantos.products.domain.repository")
public class ElasticSearchConfig {

}
