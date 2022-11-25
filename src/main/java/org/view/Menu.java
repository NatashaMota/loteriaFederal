package org.view;

import org.controllers.LoteriaFederalController;

public class Menu {

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

    private void exibirNumeroApostas(){
        exibirJogos();
        util.exibirMensagem("Digite o numero do jogo: ");
        int chave = util.lerInteger();
        util.exibirMensagem("O numero de apostas é " + controller.getNumeroApostas(chave));
    }

    private void exibirValorPremio(){
        exibirJogos();
        util.exibirMensagem("Digite o numero do jogo: ");
        int chave = util.lerInteger();
        util.exibirMensagem("O valor do premio é " + String.format("%.2f", controller.getValorPremio(chave)));
    }

    private void gerenciarJogos() {
        util.exibirMensagem("============ MENU GERENCIAR JOGOS ============");
        util.exibirMensagem("1 - Numeros apostas\n2 - Valor premio\n3 - Quantidade apostas vencedoras");
        int op = util.lerInteger();
        if(op == 1){
            this.exibirNumeroApostas();
        } else if (op == 2){
            exibirValorPremio();
        } else if (op == 3){
            exibirNumeroApostasVencedoras();
        }

    }

    private void exibirNumeroApostasVencedoras() {
        exibirJogos();
        util.exibirMensagem("Digite o numero do jogo: ");
        int chave = util.lerInteger();
        util.exibirMensagem("O numero de apostas vencedoras é: " + controller.quantidadeApostasVencedoras(chave));
    }

    public void menuPrincipal(){
        util.exibirMensagem("============ MENU PRINCIPAL ============");
        util.exibirMensagem("1 - Criar jogo loteria\n2 - Fazer aposta aleatoria\n3 - Gerenciar jogos\nop: ");

        int op = util.lerInteger();
        if (op == 1){
            criarJogo();
        } else if(op == 2) {
            fazerAposta();
        } else if(op == 3){
            gerenciarJogos();
        } else {
            util.exibirMensagem("Opção inválida");
        }
    }
}