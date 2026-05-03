package com.ecommerce.ecommerce.domain.produto;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "produtos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String uuid;

    private String nome;

    @Column(length = 1000)
    private String descricao;

    private BigDecimal preco;

    private BigDecimal precoPromocional;

    private Boolean emPromocao;

    private Integer estoque;

    private String imagemUrl;

    private LocalDateTime createdAt;
}