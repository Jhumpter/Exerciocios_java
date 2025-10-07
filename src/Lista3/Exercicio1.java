package Lista3;/*
Cálculo de Produtividade

Implemente um programa que calcule a produtividade de um funcionário, definida como a razão entre a quantidade de peças
produzidas e o número de horas trabalhadas. O programa deve utilizar uma classe chamada Lista3.Funcionario, que contenha os
atributos para representar o nome do funcionário (nomeFuncionario), a quantidade de peças produzidas (qtdeFuncionario)
e a quantidade de horas trabalhadas (horasTrabalhadas). A classe deve possuir um metodo chamado calcularProdutividade(),
que retorne a produtividade como o resultado da divisão entre qtdeProducao e horasTrabalhadas. Caso o valor de
horasTrabalhadas seja igual a zero, o metodo lançará uma exceção do tipo ArithmeticException, que deverá ser tratada
na classe principal.

No metodo main, o programa deve: ler o nome do funcionário (String), a quantidade de peças produzidas (int) e as horas
trabalhadas (int); criar um objeto da classe Lista3.Funcionario; e chamar o metodo calcularProdutividade(); A apresentação da
produtividade deve ter o seguinte formato: "Produtividade: X peças por hora". Se ocorrer divisão por zero, apresente a
mensagem: "Erro: horas trabalhadas não podem ser zero". Para qualquer outro erro inesperado, apresente a mensagem: "Erro inesperado".

Dica:

Para tratar exceções em Java, utiliza-se a estrutura try-catch. O bloco try envolve o código que pode gerar um erro em
tempo de execução (exceção). O bloco catch captura e trata esse erro de forma controlada, evitando que o programa seja
encerrado de forma abrupta.

No Java, a classe Exception é a superclasse de todas as exceções. Para erros matemáticos, como a divisão inteira por zero,
a linguagem já disponibiliza a exceção ArithmeticException, que pode ser tratada diretamente com um bloco try-catch.
*/
import java.util.Scanner;

class Funcionario {
    private String nomeFuncionario;
    private int qtdeProducao;
    private int horasTrabalhadas;
    public Funcionario(String nomeFuncionario, int qtdeProducao, int horasTrabalhadas){
        this.nomeFuncionario = nomeFuncionario;
        this.qtdeProducao = qtdeProducao;
        this.horasTrabalhadas = horasTrabalhadas;
    }
    public int calcularProdutividade(){
        return qtdeProducao/horasTrabalhadas;
    }
}

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        try {
            String nome = entrada.nextLine();
            int producao = entrada.nextInt();
            int horas = entrada.nextInt();
            Funcionario funcionario = new Funcionario(nome, producao, horas);
            int produtividade = funcionario.calcularProdutividade();
            System.out.printf("Produtividade: %d peças por hora\n", produtividade);
        } catch (ArithmeticException e) {
            System.out.println("Erro: horas trabalhadas não podem ser zero.");
        } catch (Exception e) {
            System.out.println("Erro inesperado");
        }
    }
}