package br.com.soeirosantos.products.publisher.impl;

import br.com.soeirosantos.products.domain.entity.Product;
import br.com.soeirosantos.products.publisher.ProductPublisher;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
class KafkaProductPublisher implements ProductPublisher {

	private final KafkaTemplate kafkaTemplate;

	KafkaProductPublisher(KafkaTemplate kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	@Override
	public void publish(Product product) {
		kafkaTemplate.send("products", product);
	}
}
