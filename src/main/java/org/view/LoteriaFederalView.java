package org.view;


import org.controllers.LoteriaFederalController;
import org.domain.ABSAposta;
import org.domain.ApostaLoteriaFederal;
import org.domain.LoteriaFederal;

public class LoteriaFederalView {

    private Util util = new Util();
    private LoteriaFederalController controller = new LoteriaFederalController();

    public void criarJogo(){
        controller.criarJogo();
        util.exibirMensagem("Jogo Criado!");
    }

    public String lerCPF() {
        util.exibirMensagem("Digite o cpf");
        return util.lerString();
    }

    public void exibirJogos(){
        util.exibirMensagem("Jogos:");
        util.exibirMensagem(controller.exibirJogos());
    }

    public void fazerAposta(){
        exibirJogos();
        util.exibirMensagem("Digite o numero do jogo para apostar.");
        int chaveJogo = util.lerInteger();
        controller.fazerAposta(chaveJogo, lerCPF());
        util.exibirMensagem("Aposta criada!");
    }

    public void menuPrincipal(){
        util.exibirMensagem("1 - Criar jogo loteria\n2 - Fazer aposta aleatoria\nop: ");

        int op = util.lerInteger();
        if (op == 1){
            criarJogo();
        } else if(op == 2){
            fazerAposta();
        } else {
            util.exibirMensagem("Opção inválida");
        }
    }
}