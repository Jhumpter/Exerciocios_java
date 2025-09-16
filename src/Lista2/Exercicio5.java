package Lista2;
/*
Escreva, compile e analise as classes Circulo e TestaCirculo fora do CodeRunner. Teste a criação de objetos da classe
Circulo executando a classe TestaCirculo.
Modifique a classe TestaCirculo de acordo com as seguintes instruções:
Crie um vetor de 3 objetos Circulo, considerando o construtor da classe;
Declare outra referência do tipo Circulo[ ];
Copie a referência do primeiro vetor para o segundo;
Crie um terceiro vetor do tipo Circulo de tamanho 3;
Copie os objetos do primeiro vetor para o terceiro;
Altere os valores de raio para os objetos do primeiro vetor;
Imprima os valores x, y e  raio de cada objeto para os três vetores.
Entrada:
Três linhas, cada linha corresponde à um objeto do tipo círculo, que possui três valores (int) separados por espaço,
que são o x, o y e o raio (instrução 1). Em seguida, três valores inteiros, um valor em cada linha, que representam
valores de raios para cada objeto do tipo Circulo (instrução 6).

Saída:
Três vetores, cada vetor é apresentado em quatro linhas. A primeira linha um texto com a identificação do vetor,
conforme a mensagem do exemplo, e as próximas linhas são os valores (int) dos objetos, um objeto em cada linha.
Para cada objeto, são apresentados os valores x, y e raio, separados por espaço.

Objetivos de estudo:

Criação e manipulação de vetores de objetos. Analise os resultados;
Considere testes fora do coderunner para analisar outros exemplos.
 */
import java.util.Scanner;

class Circulo{
    private int x,y,raio;
    public static final double PI = 3.14159;
    public Circulo(int x, int y, int raio){
        this.x = x;
        this.y = y;
        this.raio = raio;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRaio() {
        return raio;
    }

    public void setRaio(int raio) {
        this.raio = raio;
    }
    public double circunferencia(){
        return 2 * PI * raio;
    }
}

public class Exercicio5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int raio1 = scanner.nextInt();

        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        int raio2 = scanner.nextInt();

        int x3 = scanner.nextInt();
        int y3 = scanner.nextInt();
        int raio3 = scanner.nextInt();

        Circulo circulo1 = new Circulo(x1,y1,raio1);
        Circulo circulo2 = new Circulo(x2,y2,raio2);
        Circulo circulo3 = new Circulo(x3,y3,raio3);

        Circulo[] circulos1 = {circulo1, circulo2, circulo3};
        Circulo[] circulos2 = circulos1;
        Circulo[] circulos3 = new Circulo[3];
        circulos3[0] = new Circulo(x1,y1,raio1);
        circulos3[1] = new Circulo(x2,y2,raio2);
        circulos3[2] = new Circulo(x3,y3,raio3);

        int new_raio1 = scanner.nextInt();
        int new_raio2 = scanner.nextInt();
        int new_raio3 = scanner.nextInt();
        circulos1[0].setRaio(new_raio1);
        circulos1[1].setRaio(new_raio2);
        circulos1[2].setRaio(new_raio3);

        System.out.println("vetor1:");
        for(int i = 0;i<3;i++){
            System.out.printf("%d %d %d\n", circulos1[i].getX(),circulos1[i].getY(),circulos1[i].getRaio());
        }
        System.out.println("vetor2:");
        for(int i = 0;i<3;i++){
            System.out.printf("%d %d %d\n", circulos2[i].getX(),circulos2[i].getY(),circulos2[i].getRaio());
        }
        System.out.println("vetor3:");
        for(int i = 0;i<3;i++){
            System.out.printf("%d %d %d\n", circulos3[i].getX(),circulos3[i].getY(),circulos3[i].getRaio());
        }
    }
}
