package org.util;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
public class Sorteador {

    private int numeroMin;
    private int numeroMax;

    public Sorteador(int numeroMin, int numeroMax){
        this.numeroMin = numeroMin;
        this.numeroMax = numeroMax;
    }

    public Set<Integer> sortearNumerosInteiroDistintos(int quantidadeNumeros){
        Set<Integer> numerosSorteados = new HashSet<>();
        while(numerosSorteados.size() < quantidadeNumeros){
            numerosSorteados.add(sortearNumeroInteiro());
        }
        return numerosSorteados;
    }

    public int sortearNumeroInteiro() {
        Random random = new Random();
        return random.nextInt(getNumeroMin(), getNumeroMax()+1);
    }

    public int  getNumeroMin(){

        return this.numeroMin;
    }

    public int getNumeroMax(){

        return this.numeroMax;
    }
}