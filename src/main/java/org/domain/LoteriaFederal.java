package org.domain;

import org.util.Sorteio;

import java.util.*;

public class LoteriaFederal {

    private final static int MENOR_NUMERO = 1;
    private final static int MAIOR_NUMERO = 60;
    private final static int QUANTIDADE_NUMEROS_POR_SORTEIO = 6;

    private Set<ABSAposta> ABSApostas;
    private Sorteio Sorteio;
    private boolean finalizado;

    public LoteriaFederal() {
        this.ABSApostas = new HashSet<>();
        this.Sorteio = new Sorteio(MENOR_NUMERO, MAIOR_NUMERO, QUANTIDADE_NUMEROS_POR_SORTEIO);
        this.finalizado = false;
    }

    public void addAposta(ABSAposta ABSAposta){
            this.ABSApostas.add(ABSAposta);
    }

    public List<ABSAposta> getApostas(){

        return ABSApostas.stream().toList();
    }

    public int quantidadeAposta(){

        return this.ABSApostas.size();
    }

    private void finalizarJogo(){

        this.finalizado = true;
    }

    public boolean isFinalizado() {

        return finalizado;
    }

    public Set<Integer> revelarNumerosSorteio(){
        this.finalizarJogo();
        return this.Sorteio.getNumerosSorteio();
    }
}
