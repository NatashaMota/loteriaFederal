package org.domain;

public class ApostaLoteriaFederal extends ABSAposta {


    private final static int MENOR_NUMERO = 1;
    private final static int MAIOR_NUMERO = 60;

    public ApostaLoteriaFederal(Jogador jogador) {
        super(MENOR_NUMERO, MAIOR_NUMERO, jogador);
    }
}
