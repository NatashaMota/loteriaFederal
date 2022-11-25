package org.controllers;

import org.domain.ABSAposta;
import org.domain.ApostaLoteriaFederal;
import org.domain.Jogador;
import org.domain.LoteriaFederal;
import org.util.Sorteador;

import java.util.*;

public class LoteriaFederalController {

    private Map<Integer, LoteriaFederal> jogos = new HashMap<>();
    Sorteador sorteador = new Sorteador(1, 60);

    public void fazerAposta(int chave, String cpf){
        LoteriaFederal jogo = jogos.get(chave);
        ABSAposta aposta = new ApostaLoteriaFederal(criarUsuario(cpf));
        aposta.fazerAposta(sorteador.sortearNumerosInteiroDistintos(6));
        jogo.addAposta(aposta);
    }

    public String exibirJogos(){
        String jogosCriados = "";
        for (int chave: this.jogos.keySet()){
            jogosCriados += chave + " - " + (jogos.get(chave).isFinalizado() ? "finalizada" : "Ativo") + "\n";
        }
        return jogosCriados;
    }

    public void criarJogo(){

        this.jogos.put(this.jogos.size()+1, new LoteriaFederal());
    }

    public Jogador criarUsuario(String cpf) {
        return new Jogador(cpf);
    }

    public int getNumeroApostas(int chave) {

        return this.jogos.get(chave).quantidadeAposta();
    }

    public double getValorPremio(int chave) {

        return this.jogos.get(chave).quantidadeAposta() * 6.00;
    }

    public int quantidadeApostasVencedoras(int chave) {
        LoteriaFederal jogo = this.jogos.get(chave);
        if(jogo.isFinalizado()){
            return jogo.getApostasVencedoras().size();
        }
        return 0;
    }
}