package org.domain;

import org.util.Sorteador;
import org.util.Volante;
import java.util.Set;

public abstract class ABSAposta {

    private Volante volanteAposta;
    private Jogador jogador;
    private boolean finalizado;

    public ABSAposta(int menorValor, int maiorValor, Jogador jogador) {
        this.volanteAposta = new Volante(menorValor, maiorValor);
        this.jogador = jogador;
        this.finalizado = false;
    }

    public void fazerAposta(Set<Integer> numeros){
        if(!this.finalizado){
            this.volanteAposta.marcarNumeros(numeros);
            this.finalizarApostar();
        }
    }

    public Jogador getJogador() {

        return jogador;
    }

    public Set<Integer> getNumerosApostados(){

        return this.volanteAposta.getNumerosMarcados();
    }

    public int quantidadeNumerosApostados(){

        return this.volanteAposta.getNumerosMarcados().size();
    }

    private void finalizarApostar(){

        this.finalizado = true;
    }
}