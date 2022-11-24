package org.util;

import java.util.Set;

public class Sorteio {
    private Set<Integer> numerosSorteados;

    private Sorteador sorteador;

    public Sorteio(int menorNumero, int maiorNumero, int quantidadeNumerosSorteados) {
        this.sorteador = new Sorteador(menorNumero, maiorNumero);
        this.gerarSorteio(quantidadeNumerosSorteados);
    }

    private void gerarSorteio(int quantidadeNumerosSorteados) {
        numerosSorteados = this.sorteador.sortearNumerosInteiroDistintos(quantidadeNumerosSorteados);
    }

    public Set<Integer> getNumerosSorteio() {

        return this.numerosSorteados;
    }
}