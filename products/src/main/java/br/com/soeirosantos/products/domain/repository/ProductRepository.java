package br.com.soeirosantos.products.domain.repository;

import br.com.soeirosantos.products.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> { }
