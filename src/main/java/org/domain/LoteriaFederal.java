package org.domain;

import org.util.Sorteio;

import java.util.*;

public class LoteriaFederal {

    private final static int MENOR_NUMERO = 1;
    private final static int MAIOR_NUMERO = 60;
    private final static int QUANTIDADE_NUMEROS_POR_SORTEIO = 6;

    private Set<ABSAposta> apostas;
    private Sorteio Sorteio;
    private boolean finalizado;

    public LoteriaFederal() {
        this.apostas = new HashSet<>();
        this.Sorteio = new Sorteio(MENOR_NUMERO, MAIOR_NUMERO, QUANTIDADE_NUMEROS_POR_SORTEIO);
        this.finalizado = false;
    }

    public void addAposta(ABSAposta ABSAposta){

            this.apostas.add(ABSAposta);
    }

    public List<ABSAposta> getApostas(){

        return apostas.stream().toList();
    }

    public int quantidadeAposta(){

        return this.apostas.size();
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

    public List<ABSAposta> getApostasVencedoras(){
        List<ABSAposta> apostasVencedoras = new ArrayList<>();
        for(ABSAposta ABSAposta : this.apostas) {
            if (this.isApostaVencedora(ABSAposta)) {
                apostas.add(ABSAposta);
            }
        }
        return apostasVencedoras;
    }

    public boolean temGanhador(){
        return !verificarGanhadores().isEmpty();
    }

    public List<Jogador> verificarGanhadores(){
        List<Jogador> ganhadores = new ArrayList<Jogador>();
        for(ABSAposta ABSAposta : getApostasVencedoras()){
            ganhadores.add(ABSAposta.getJogador());
        }
        return ganhadores;
    }

    private boolean isApostaVencedora(ABSAposta ABSAposta){
        if(isFinalizado()) {
            return false;
        }
        return this.Sorteio.getNumerosSorteio().contains(ABSAposta.getNumerosApostados());
    }
}