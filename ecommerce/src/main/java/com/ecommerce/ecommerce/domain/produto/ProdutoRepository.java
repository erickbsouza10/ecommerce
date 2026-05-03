package com.ecommerce.ecommerce.domain.produto;

import com.ecommerce.ecommerce.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}

