package br.com.soeirosantos.products.domain.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class Product {

	private Long id;

	private Long version;

	@NotBlank
	private String name;

	private String description;

	@NotNull
	private BigDecimal price;

}
