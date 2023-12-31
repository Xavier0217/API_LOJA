package com.loja;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

public class TabelaProdutos {

    List<Produto> produtos = new ArrayList<>();

    public TabelaProdutos() {
        Produto caneta = new Produto(1, "Caneta BIC", "Caneta BIC cor azul", 1.99);
        Produto borracha = new Produto(2, "Borracha branca", "Borracha branca comum", 3.99);
        Produto lapis = new Produto(3, "Lápis Faber Castell", "Lápis Faber Castell comum", 2.99);
        Produto apontador = new Produto(4, "Apontador", "Apontador comum com reservatório", 7.99);
        Produto caderno = new Produto(5, "Caderno espiral", "Caderno espiral de 96 folhas", 15.99);
        Produto corretivo = new Produto(6, "Corretivo", "Corretivo em fita", 9.99);
        Produto canetinha = new Produto(7, "Canetinha", "Kit Canetinhas hidrográficas 12 unidade", 29.99);
        Produto lapisDeCor = new Produto(8, "Lápis de cor", "Kit Lápis de cor 30 unidades", 39.99);

        this.produtos.add(caneta);
        this.produtos.add(borracha);
        this.produtos.add(lapis);
        this.produtos.add(apontador);
        this.produtos.add(caderno);
        this.produtos.add(corretivo);
        this.produtos.add(canetinha);
        this.produtos.add(lapisDeCor);
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
    public List<Produto> buscarTodosOsProdutos() {
        return this.getProdutos();
    }

    public Produto bucarProdutoPeloId(int produtoId) {
        Produto produtoProcurado = null;
        for (Produto p: this.produtos) {
            if (p.getId() == produtoId) {
                produtoProcurado = p;
                break;
            }
        }
        return produtoProcurado;
    }

    public Produto cadastrarNovoProduto(Produto novoProduto) {
        int ultimoIndex = this.produtos.size() - 1;
        Produto ultimoProduto = this.produtos.get(ultimoIndex);
        int proximoId = ultimoProduto.getId() + 1;

        novoProduto.setId(proximoId);
        this.produtos.add(novoProduto);
        return novoProduto;
    }

    public void atualizarProduto(int produtoId, Produto produtoAtualizar) {
        Produto produtoProcurado = this.bucarProdutoPeloId(produtoId);
        if (produtoProcurado != null) {
            produtoProcurado.setNome(produtoAtualizar.getNome());
            produtoProcurado.setDescricao(produtoAtualizar.getDescricao());
            produtoProcurado.setValorUnitario(produtoAtualizar.getValorUnitario());
        }
    }

    public void removerproduto(int produtoId) {
        Produto produtoRemover = this.bucarProdutoPeloId(produtoId);
        this.produtos.remove((produtoRemover));
    }
}
