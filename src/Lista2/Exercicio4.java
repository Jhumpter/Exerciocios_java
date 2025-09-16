package Lista2;

import java.util.Scanner;

/*
Banco

Construa um programa para simulação de um banco que manipula contas, responsável pela criação das contas e suas operações.
Crie a classe "Conta" com os atributos privados numeroConta (int), nomeCliente (String), saldo (double) e senha (int).
Considere que o banco não oferece limite ao cliente e não realiza operações de saque ou transfência caso não tenha valor
suficiente no saldo (ou seja, a conta não ficará negativa). A classe Conta deve ter um metodo construtor considerando
todos os atributos e os metodos getters considerando os atributos numeroConta, nomeCliente e saldo. No metodo get para
retornar o saldo, considere primeiro uma verificação da senha conforme o valor recebido por parâmetro. Além destes metodos,
a classe Conta também deve conter três metodos públicos com retornos do tipo boolean, sendo um metodo para sacar um valor
da conta, um metodo para depositar um valor na conta e um metodo para fazer a transferência entre duas contas, com as seguintes funcionalidades:
O metodo para fazer saque da conta deve receber dois argumentos, o valor do saque (double) e a senha da conta (int).
O metodo deve retirar o valor da conta considerando o atributo saldo, caso o valor seja maior do que zero, menor que o
saldo atual e a senha seja válida (retorno true); caso contrário, o retorno é falso.
O metodo para fazer depósito na conta deve receber dois argumentos, o valor do depósito (double) e a senha da conta (int).
O metodo deve adicionar o valor na conta considerando o atributo saldo, caso o valor seja maior do que zero e a senha seja
válida (retorno true); caso contrário, o retorno é falso.
O metodo para fazer transferência entre contas deve receber três argumentos: o valor da transferência (double), a senha
da conta (int) e a conta2 que receberá a transferência (objeto do tipo Conta). O metodo deve retirar o valor da conta
considerando o atributo saldo e adicionar o valor na conta2, caso o valor seja maior do que zero, menor que o saldo atual
e a senha seja válida (retorno true); caso contrário, o retorno é falso.
Crie a classe Banco (classe principal) e instancie dois objetos do tipo conta (conta1 e conta2) usando o construtor para
inicializar os valores da conta, considerando os dados de entrada pelo teclado. Em seguida, o usuário da conta1 poderá
escolher entre cinco opções de operação (int): visualizar saldo, sacar valor, depositar valor, transferência entre contas
e sair do sistema. Considere a possibilidade de o usuário fazer repetidas operações enquanto não sair do sistema
(usar estrutura de repetição). Considere as seguintes funcionalidades para cada opção de operação:
visualizar saldo: solicite a senha da conta e acesse o metodo da classe Conta para retornar o saldo caso a senha esteja
correta; caso contrário apresentar a mensagem "senha incorreta";
sacar valor: solicite o valor do saque e senha da conta, e acesse o metodo da classe Conta para sacar; apresente a mensagem
"saque realizado" ou "saque não realizado" de acordo com o retorno do metodo;
depositar valor: solicite o valor do depósito e senha da conta, e acesse o metodo da classe Conta para depositar;
apresente a mensagem "depósito realizado" ou "depósito não realizado" de acordo com o retorno do metodo;
transferência entre contas: solicite o nome do cliente que  usuário deseja fazer a transferência de dinheiro; verifique
se o nome do cliente é o mesmo do objeto da conta2 usando o metodo de retorno do nome do cliente; se os nomes forem
diferentes, apresentar uma mensagem "nenhum usuário encontrado"; caso contrário solicite o valor da transferência e senha
da conta, e acesse o metodo da classe Conta para transferir; apresente a mensagem "transferência realizada" ou
"transferência não realizada" de acordo com o retorno do metodo;
sair do sistema: finalize o programa.
Entrada:
As duas primeiras linhas são informações de duas contas, uma em cada linha. Cada conta tem quatro valores separados por
espaço: número da conta (int), senha da conta (int), nome do cliente (String - apenas o primeiro nome), saldo inicial
de abertura da conta (double). A próxima linha é um valor inteiro (de 1 a 5) que corresponde a opção do menu que o
cliente deseja realizar (não é necessário validar a entrada). Enquanto o valor 5 não for informado, serão solicitadas
as entradas de acordo com cada opção. A opção 1 tem apenas uma entrada, que é a senha da conta1 (int). A opção 2 tem
duas entradas separadas por espaço, que são o valor do saque (double) e a senha da conta1 (int). A opção 3 tem duas
entradas separadas por espaço, que são o valor do depósito (double) e a senha da conta1 (int). A opção 4 tem duas linhas
de entrada. Na primeira linha, o nome do cliente para a transferência (String). Se o nome estiver correto, serão
solicitados dois valores separados por espaço na linha seguinte, que são o valor da transferência (double) e a senha da
conta1 (int). A opção 5 não tem nenhuma entrada.

Saída:
Para a opção 1, a saída é um valor double com duas casas decimais ou a mensagem "senha incorreta" dependendo do retorno
do metodo. Para as opções 2, 3 e 4, a saída é uma mensagem conforme apresentada no enunciado do problema. Para a opção 5
não tem nenhuma saída.

Objetivos de estudo:

Comunicação entre dois objetos da mesma classe;
Considere testes fora do Coderunner para analisar outros exemplos e a criação de vetor para armazenar vários objetos do
tipo conta e a definição e utilização de um atributo limite para a classe Conta).
 */
class Conta{
    private int numeroConta;
    private String nomeCliente;
    private double saldo;
    private int senha;

    public Conta(int numeroConta, String nomeCliente, double saldo, int senha){
        this.numeroConta = numeroConta;
        this.nomeCliente = nomeCliente;
        this.saldo = saldo;
        this.senha = senha;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public double getSaldo(int senha) {
        if(this.senha==senha)
            return  saldo;
        return -1;
    }

    public boolean sacar(double valor, int senha){
        if(this.senha==senha && valor>0 && valor<saldo){
            saldo -= valor;
            return true;
        }
        return false;
    }

    public boolean depositar(double valor, int senha){
        if(this.senha==senha && valor>0){
            saldo += valor;
            return true;
        }
        return false;
    }

    public boolean transferir(double valor, int senha, Conta destino){
        if(this.senha==senha && valor>0 && valor<saldo){
            saldo -= valor;
            destino.saldo += valor;
            return true;
        }
        return false;
    }
}
public class Exercicio4 {
    public static void main(String[] args) {
        //Declarando contas
        Scanner scanner = new Scanner(System.in);
        int numConta1 = scanner.nextInt();
        int senha1 = scanner.nextInt();
        String nomeCliente1 = scanner.next();
        double saldo1 = scanner.nextDouble();
        Conta conta1 = new Conta(numConta1, nomeCliente1, saldo1, senha1);

        int numConta2 = scanner.nextInt();
        int senha2 = scanner.nextInt();
        String nomeCliente2 = scanner.next();
        double saldo2 = scanner.nextDouble();
        String limpaBuffer2 = scanner.nextLine();
        Conta conta2 = new Conta(numConta2, nomeCliente2, saldo2, senha2);
    /*
    Operações
    1- Ver saldo
    2- Saque
    3- Depósito
    4- Transferência
    5- Sair
     */
        int entrada = 0;
        int senha;
        double valor;
        while (entrada!=5) {
            entrada = scanner.nextInt();
            switch (entrada) {
                case 1:
                    senha = scanner.nextInt();
                    double saldo = conta1.getSaldo(senha);
                    if (saldo > 0)
                        System.out.printf("%.2f\n", saldo);
                    else
                        System.out.println("senha incorreta");
                    break;
                case 2:
                    valor = scanner.nextDouble();
                    senha = scanner.nextInt();
                    if (conta1.sacar(valor, senha))
                        System.out.println("saque realizado");
                    else
                        System.out.println("saque não realizado");
                    break;
                case 3:
                    valor = scanner.nextDouble();
                    senha = scanner.nextInt();
                    if (conta1.depositar(valor, senha))
                        System.out.println("depósito realizado");
                    else
                        System.out.println("depósito não realizado");
                    break;
                case 4:
                    String nome = scanner.next();
                    if (nome.equals(conta2.getNomeCliente())) {
                        valor = scanner.nextDouble();
                        senha = scanner.nextInt();
                        if (conta1.transferir(valor, senha, conta2))
                            System.out.println("transferência realizada");
                        else
                            System.out.println("transferência não realizada");
                    }else
                        System.out.println("nenhum usuário encontrado");
                    break;
            }
        }
    }
}
