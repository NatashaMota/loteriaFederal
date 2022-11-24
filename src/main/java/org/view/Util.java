package org.view;

import java.util.Scanner;

public class Util {
    private Scanner scanner = new Scanner(System.in);

    public void exibirMensagem(String mensagem){
        
        System.out.println(mensagem);
    }

    public int lerInteger(){
        
        return scanner.nextInt();
    }

    public String lerString(){
        
        return scanner.next();
    }
}
