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

        util.exibirMensagem("Digite o cpf:");
        return util.lerString();
    }

    public void exibirJogos(){
        util.exibirMensagem("Jogos:");
        util.exibirMensagem(controller.exibirJogos());
    }

    public void fazerApostaAleatoria(){
        exibirJogos();
        util.exibirMensagem("Digite o número do jogo para apostar:");
        int chaveJogo = util.lerInteger();
        controller.fazerAposta(chaveJogo, lerCPF());
        util.exibirMensagem("Aposta criada!");
    }

    private void exibirNumeroApostas(){
        exibirJogos();
        util.exibirMensagem("Digite o número do jogo: ");
        int chave = util.lerInteger();
        util.exibirMensagem("O número de apostas é " + controller.getNumeroApostas(chave));
    }

    private void exibirValorPremio(){
        exibirJogos();
        util.exibirMensagem("Digite o número do jogo: ");
        int chave = util.lerInteger();
        util.exibirMensagem("O valor do prêmio é " + String.format("%.2f", controller.getValorPremio(chave)));
    }

    private void gerenciarJogos() {
        util.exibirMensagem("============ MENU GERENCIAR JOGOS ============");
        util.exibirMensagem("1 - Número apostas\n2 - Valor prêmio\n3 - Quantidade apostas vencedoras\n4 - Fazer sorteio\n");
        int op = util.lerInteger();
        if(op == 1){
            this.exibirNumeroApostas();
        } else if (op == 2){
            exibirValorPremio();
        } else if (op == 3){
            exibirNumeroApostasVencedoras();
        } else if (op == 4){
            exibirNumerosSorteados();
        }

    }

    private void exibirNumerosSorteados() {
        exibirJogos();
        util.exibirMensagem("Digite o número do jogo: ");
        int chave = util.lerInteger();
        System.out.println("Jogo Finalizado!");
        System.out.println("Os numeros do sorteio são: " + controller.numerosSorteio(chave));
    }

    private void exibirNumeroApostasVencedoras() {
        exibirJogos();
        util.exibirMensagem("Digite o número do jogo: ");
        int chave = util.lerInteger();
        util.exibirMensagem("O número de apostas vencedoras é: " + controller.quantidadeApostasVencedoras(chave));
    }

    public void menuPrincipal(){
        util.exibirMensagem("============ MENU PRINCIPAL ============");
        util.exibirMensagem("1 - Criar jogo loteria\n2 - Fazer aposta aleatória\n3 - Gerenciar jogos\nop: ");

        int op = util.lerInteger();
        if (op == 1){
            criarJogo();
        } else if(op == 2) {
            fazerApostaAleatoria();
        } else if(op == 3){
            gerenciarJogos();
        } else {
            util.exibirMensagem("Opção inválida.");
        }
    }
}