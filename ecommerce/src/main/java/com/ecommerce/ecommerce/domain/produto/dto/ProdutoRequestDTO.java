package com.ecommerce.ecommerce.domain.produto.dto;

import java.math.BigDecimal;

public record ProdutoRequestDTO(
        String nome,
        String descricao,
        BigDecimal preco,
        BigDecimal precoPromocional,
        Boolean emPromocao,
        Integer estoque,
        String imagemUrl
) {
}