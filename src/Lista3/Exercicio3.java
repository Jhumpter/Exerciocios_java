/*
Validação de Depósito

Construa um programa que represente uma conta bancária. O programa deve utilizar uma classe chamada Conta, contendo os
atributos agencia, numero e saldo. O saldo deve iniciar com 0.0. A classe deve fornecer o metodo depositaPersonalizado,
que recebe um valor do tipo double como parâmetro e realiza a operação de depósito, mas com as seguintes validações:

se o valor for menor ou igual a zero, deve ser lançada uma exceção personalizada (não-verificada) chamada
DepositoInvalidoException com a mensagem "Valor inválido para depósito".
se o valor for maior que o limite de depósito permitido (constante de valor 10000.00), deve ser lançada a mesma exceção,
mas com a mensagem "Valor acima do limite permitido de 10000.00".
No metodo main, o programa deve: ler os dados da conta (agência e número) e o valor a ser depositado; criar um objeto da
classe Conta; tentar realizar a operação de depósito dentro de um bloco try-catch. caso o depósito seja bem-sucedido,
apresente a mensagem "Depósito realizado com sucesso." Se ocorrer erro, capturar a exceção e exibir a mensagem
"Erro: <mensagem da exceção>". No bloco finally, exibir sempre uma mensagem informando o valor e o saldo final: se o
depósito foi válido: "Valor X.XX depositado na conta. Novo saldo: Y.YY"; se o depósito foi inválido:
"Valor X.XX incorreto. Saldo atual: Y.YY".

Dica:

A linguagem Java já possui várias exceções pré-definidas. Porém, é possível criar exceções personalizadas, que são classes
que herdam de alguma exceção existente (Exception). Quando você herda de RuntimeException, a exceção é considerada
não-verificada (unchecked), ou seja, o compilador não exige que você trate explicitamente com try-catch. Para lançar uma
exceção personalizada, utilize a palavra-chave throw junto com uma nova instância da sua classe de exceção.
*/
package Lista3;
import java.util.Scanner;

//Crie a exceção personalizada (não-verificada) para depósito inválido aqui
class DepositoInvalidoException extends RuntimeException {
    public DepositoInvalidoException(String mensagem) {
        super(mensagem);
    }
}

//Classe Conta
class Conta {
    private int agencia;
    private int numero;
    private double saldo;
    private double LIMITE_DEPOSITO = 10000;
    public Conta(int agencia, int numero){
        this.agencia = agencia;
        this.numero = numero;
        saldo = 0.0;
    }
    public void depositoPersonalizado(double valor) throws DepositoInvalidoException {
        if(valor<0){
            throw new DepositoInvalidoException("Valor inválido para depósito");
        }else if(valor>LIMITE_DEPOSITO){
            throw new DepositoInvalidoException("Valor acima do limite permitido de 10000.00");
        }else{
            saldo += valor;
        }
    }
    public double getSaldo(){
        return saldo;
    }
    public double getLIMITE_DEPOSITO(){
        return LIMITE_DEPOSITO;
    }
}

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double valor = 0;
        Conta conta = null;
        try {
            int agencia = scanner.nextInt();
            int numero = scanner.nextInt();
            conta = new Conta(agencia, numero);
            valor = scanner.nextDouble();
            conta.depositoPersonalizado(valor);
            System.out.println("Depósito realizado com sucesso.");
            System.out.printf("Valor %.2f depositado na conta. Novo saldo: %.2f", valor, conta.getSaldo());
        } catch (DepositoInvalidoException e) {
            System.out.println("Erro: " + e.getMessage());
            System.out.printf("Valor %.2f incorreto. Saldo atual: %.2f", valor, conta.getSaldo());

        } finally {
            scanner.close();
        }
    }
}
