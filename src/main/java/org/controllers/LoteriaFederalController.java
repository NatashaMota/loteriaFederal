package org.controllers;

import org.domain.ABSAposta;
import org.domain.ApostaLoteriaFederal;
import org.domain.Jogador;
import org.domain.LoteriaFederal;

import java.util.*;

public class LoteriaFederalController {

    private Map<Integer, LoteriaFederal> jogos = new HashMap<>();

    public void fazerAposta(int chave, String cpf){
        LoteriaFederal jogo = jogos.get(chave);
        ABSAposta ABSAposta = new ApostaLoteriaFederal(criarUsuario(cpf));
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
}
