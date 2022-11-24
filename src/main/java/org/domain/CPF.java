package org.domain;
import java.util.regex.PatternSyntaxException;

public class CPF {

    private String cpf;

    public CPF(String cpf) {
        this.setCpf(cpf);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (cpf.matches("^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$")){
            this.cpf = cpf;
        } else {
            throw new IllegalArgumentException("O CPF " + cpf +" está inválido.");
        }
    }

    @Override
    public String toString() {
        return "CPF{" +
                "cpf='" + cpf + '\'' +
                '}';
    }
}
