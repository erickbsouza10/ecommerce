package com.ecommerce.ecommerce.domain.produto;

import com.ecommerce.ecommerce.domain.produto.dto.ProdutoRequestDTO;
import com.ecommerce.ecommerce.domain.produto.dto.ProdutoResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService service;

    @PostMapping
    public ProdutoResponseDTO criar(
            @RequestBody ProdutoRequestDTO dto
    ) {

        Produto produto = Produto.builder()
                .uuid(UUID.randomUUID().toString())
                .nome(dto.nome())
                .descricao(dto.descricao())
                .preco(dto.preco())
                .precoPromocional(dto.precoPromocional())
                .emPromocao(dto.emPromocao())
                .estoque(dto.estoque())
                .imagemUrl(dto.imagemUrl())
                .createdAt(LocalDateTime.now())
                .build();

        Produto salvo = service.criar(produto);

        return toResponse(salvo);
    }

    @GetMapping
    public List<ProdutoResponseDTO> listar() {
        return service.listar()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @GetMapping("/{id}")
    public ProdutoResponseDTO buscarPorId(
            @PathVariable Long id
    ) {
        return toResponse(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ProdutoResponseDTO atualizar(
            @PathVariable Long id,
            @RequestBody ProdutoRequestDTO dto
    ) {

        Produto dados = Produto.builder()
                .nome(dto.nome())
                .descricao(dto.descricao())
                .preco(dto.preco())
                .precoPromocional(dto.precoPromocional())
                .emPromocao(dto.emPromocao())
                .estoque(dto.estoque())
                .imagemUrl(dto.imagemUrl())
                .build();

        Produto atualizado =
                service.atualizar(id, dados);

        return toResponse(atualizado);
    }

    @DeleteMapping("/{id}")
    public String deletar(
            @PathVariable Long id
    ) {
        service.deletar(id);
        return "Produto removido com sucesso";
    }

    private ProdutoResponseDTO toResponse(
            Produto produto
    ) {
        return new ProdutoResponseDTO(
                produto.getId(),
                produto.getUuid(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getPreco(),
                produto.getPrecoPromocional(),
                produto.getEmPromocao(),
                produto.getEstoque(),
                produto.getImagemUrl(),
                produto.getCreatedAt()
        );
    }
}