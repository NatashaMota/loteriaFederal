package org.util;
import java.util.HashSet;
import java.util.Set;

public class Volante {
    private int maiorNumero;
    private int menorNumero;
    private boolean[] volante;

    public Volante(int menorNumero, int maiorNumero) {

        this.maiorNumero = maiorNumero;
        this.menorNumero = menorNumero;
        this.volante = new boolean[maiorNumero];
    }

    private void manipularVolante(int numero) {
        if (isNumeroValido(numero)) {
            this.volante[numero - 1] = true;
        } else {
            throw new IllegalArgumentException("Número inválido.");
        }
    }

    public void marcarNumeros(Set<Integer> numeros){
        for (int numero: numeros) {
            this.manipularVolante(numero);
        }
    }

    public Set<Integer> getNumerosMarcados(){
        Set<Integer> numerosMarcados = new HashSet<>();
        int numero = menorNumero;
        while (numero <= maiorNumero) {
            if (this.volante[numero-1]) {
                numerosMarcados.add(numero);
            }
            numero++;
        }
        return numerosMarcados;
    }

    private boolean isNumeroValido(int numero) {
        return numero <= maiorNumero && numero >= menorNumero;
    }

    public boolean isNumeroMarcado(int numero) {
        if (isNumeroValido(numero)) {
            return this.volante[numero - 1];
        }
        return false;
    }
}
