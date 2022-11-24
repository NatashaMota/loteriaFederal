package org.domain;

public class Jogador {

    private CPF cpf;
    private ABSAposta ABSAposta;

    public Jogador(String cpf) {

        this.setCpf(cpf);
    }

    public ABSAposta getAposta() {

        return ABSAposta;
    }

    public void setAposta(ABSAposta ABSAposta) {

        this.ABSAposta = ABSAposta;
    }

    public CPF getCpf() {

        return cpf;
    }

    public void setCpf(String cpf) {

        this.cpf = new CPF(cpf);
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "cpf=" + cpf +
                '}';
    }
}
