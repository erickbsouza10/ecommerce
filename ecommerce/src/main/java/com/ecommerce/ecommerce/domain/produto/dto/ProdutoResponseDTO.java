package com.ecommerce.ecommerce.domain.produto.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ProdutoResponseDTO(
        Long id,
        String uuid,
        String nome,
        String descricao,
        BigDecimal preco,
        BigDecimal precoPromocional,
        Boolean emPromocao,
        Integer estoque,
        String imagemUrl,
        LocalDateTime createdAt
) {
}