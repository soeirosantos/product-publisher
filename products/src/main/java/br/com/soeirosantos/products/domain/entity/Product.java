package br.com.soeirosantos.products.domain.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Data
public class Product {

	@Id
	@GeneratedValue
	private Long id;

	@Version
	private Long version;

	@NotBlank
	private String name;

	private String description;

	@NotNull
	private BigDecimal price;

}
