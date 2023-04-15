package br.com.lojinha;

import br.com.lojinha.enums.Tamanho;
import br.com.lojinha.pojo.ItemIncluso;
import br.com.lojinha.pojo.Produto;

import java.util.ArrayList;
import java.util.List;

public class LojinhaApp {
    public static void main(String[] args) {
        //String joias = "100gr de Ouro 50k";
        //int minhaIdade =26;
        //double meuSalario = 29500.99;
        //boolean minhaResposta = true;


        Produto meuProduto = new Produto("Nestlé", Tamanho.MEDIO);

        meuProduto.setNome("Mateus Neres");
        meuProduto.setValor(1);


        List<ItemIncluso> itensInclusos = new ArrayList<>();

        ItemIncluso primeiroItemIncluso = new ItemIncluso("Controle", 2);
        itensInclusos.add(primeiroItemIncluso);

        ItemIncluso segundoItemIncluso = new ItemIncluso("Jogo", 3);
        itensInclusos.add(segundoItemIncluso);

        ItemIncluso terceiroItemIncluso = new ItemIncluso("Cabo de Energia", 2);
        itensInclusos.add(terceiroItemIncluso);

        meuProduto.setItensInclusos(itensInclusos);


        System.out.println(meuProduto.getTamanho());
        System.out.println(meuProduto.getValor());
        System.out.println(meuProduto.getMarca());


        for (ItemIncluso itemAtual : meuProduto.getItensInclusos()){
            System.out.println(itemAtual.getNome());
            System.out.println(itemAtual.getQuantidade());
        }

        System.out.println("Acabaram-se os itens");
    }
}
