package com.ecommerce.ecommerce.domain.user.dto;

public record RegisterDTO(
        String nome,
        String username,
        String email,
        String senha
) {
}
