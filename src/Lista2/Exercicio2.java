package Lista2;
import java.util.Scanner;
/*
Formas

Crie uma classe “Retangulo” que represente as propriedades e comportamentos de um retângulo.  A classe de utilizar o
construtor padrão e conter dois atributos privados do tipo int, "comprimento" e "largura", configurados inicialmente
com o valor padrão 1. A classe deve conter dois métodos públicos e com retorno do tipo int, um para calcular e retornar
o perímetro de um retângulo (2 * (comprimento + largura)) e o outro para calcular e retornar a área de um retângulo
(comprimento * largura). A classe Retangulo deve conter também métodos setters e getters para os atributos comprimento
e largura. Os métodos setters, antes de atribuir os novos valores aos atributos, também devem verificar se os valores de
comprimento e largura são, cada um, números inteiros maiores que 0 e menores que 20, caso contrário não faz a atribuição.

Crie uma classe chamada “Formas” (classe Principal) que será responsável por instanciar dois objetos do tipo Retangulo.
Considere a chamada dos métodos setters para alterar os valores dos atributos comprimento e largura para cada objeto de
acordo com as informações de entrada. Em seguida, use os métodos getters para apresentar os valores dos atributos de
cada um desses objetos e também os métodos para calcular e apresentar os seus perímetros e áreas.

Entrada:
Duas linhas contendo dois números inteiros cada (separados por espaço), representando o comprimento e a largura de um retângulo (nesta ordem).

Saída:
Duas linhas de saída. Cada linha contém quatro valores inteiros (separados por espaço)  representando informações de um
objeto do tipo Retangulo, que são o comprimento, a largura, o perímetro e área (nesta ordem), considerando os métodos getters.

Objetivos de estudo:

Inicializar um atributo com um valor padrão;
Criar vários objetos;
Trabalhar com atributos privados (declaração);
Acessar atributos privados na classe principal;
Analisar o comportamento da chamada dos métodos (considere o teste de outros exemplos fora do coderunner).
 */
class Retangulo{
    private int comprimento;
    private int largura;

    public Retangulo(){
        this.comprimento = 1;
        this.largura = 1;
    }

    public int calculaPerimetro(){
        return 2*(comprimento+largura);
    }

    public int calculaArea(){
        return comprimento*largura;
    }

    public void setComprimento(int valor){
        if(valor>0 && valor<20)
            comprimento = valor;
    }

    public void setLargura(int valor){
        if(valor>0 && valor<20)
            largura = valor;
    }

    public int getComprimento(){
        return comprimento;
    }

    public int getLargura(){
        return largura;
    }
}
public class Exercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for(int i = 0;i<2;i++){
            int comp = scanner.nextInt();
            int lar = scanner.nextInt();
            Retangulo retangulo = new Retangulo();
            retangulo.setComprimento(comp);
            retangulo.setLargura(lar);
            System.out.printf("%d %d %d %d\n",retangulo.getComprimento(), retangulo.getLargura(),retangulo.calculaPerimetro(),retangulo.calculaArea());
        }
    }
}
