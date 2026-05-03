package com.ecommerce.ecommerce.domain.produto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository repository;

    public Produto criar(Produto produto) {
        return repository.save(produto);
    }

    public List<Produto> listar() {
        return repository.findAll();
    }

    public Produto buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Produto não encontrado"));
    }

    public Produto atualizar(Long id, Produto dados) {

        Produto produto = buscarPorId(id);

        produto.setNome(dados.getNome());
        produto.setPreco(dados.getPreco());
        produto.setDescricao(dados.getDescricao());
        produto.setPrecoPromocional(dados.getPrecoPromocional());
        produto.setEmPromocao(dados.getEmPromocao());
        produto.setEstoque(dados.getEstoque());
        produto.setImagemUrl(dados.getImagemUrl());

        return repository.save(produto);
    }

    public void deletar(Long id) {
        Produto produto = buscarPorId(id);
        repository.delete(produto);
    }
}