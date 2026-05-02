package com.ecommerce.ecommerce.domain.user.dto;

public record UserResponseDTO (
        Long id,
        String nome,
        String username,
        String email
){
}
