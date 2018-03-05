package br.com.soeirosantos.products.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "product")
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {

	@Id
	private String id;

	private String version;

	private String name;

	private String description;

	private String price;

}
