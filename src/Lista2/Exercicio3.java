package Lista2;
import java.util.Scanner;
/*
Conversão de Temperaturas

Crie uma classe “Temperatura” que conterá um atributo privado de temperatura (double) e quatro métodos:
um metodo construtor para a inicialização do valor do atributo, um metodo toString para exibir o valor do atributo,
um metodo para a conversão entre graus Celsius e Fahrenheit (temperatura * 9.0 / 5.0 + 32) e um metodo para a
conversão entre graus Fahrenheit e Celsius ((temperatura - 32) * 5.0 / 9.0). Os métodos de conversão
armazenam no atributo da classe a temperatura atual convertida e não retorna nada.

Crie a classe “Converte” (classe principal), que instancia um objeto da classe “Temperatura” com o valor inicial de
temperatura em Celsius informado pelo usuário. Em seguida, acesse o metodo para converter a temperatura do objeto
Fahrenheit  e a exiba usando o metodo toString. Depois converta para Celsius usando o metodo correspondente
e a exiba novamente usando o metodo toString.
Entrada:
Um valor de entrada do tipo double, que representa uma temperatura em Celsius.

Saída:
Duas linhas de saída. Na primeira linha, um valor double, que corresponde a temperatura em Fahrenheit e na segunda
linha um valor double em Celsius. Ambos os resultados devem ser apresentados com acompanhamento de texto conforme o exemplo.

Objetivos de estudo:

Inicializar um atributo utilizando construtor;
Alterar o valor de um atributo por meio dos métodos da classe;
Usar o metodo toString para apresentar os valores de um objeto em forma de texto;
Analisar o comportamento da chamada dos métodos.
 */
class Temperatura{
    private double temperatura;

    public Temperatura(double temperatura){
        this.temperatura = temperatura;
    }

    public String toString(){
        return Double.toString(temperatura);
    }

    public double toFahrenheit(){
        return temperatura * 9.0 / 5.0 + 32;
    }

    public double toCelsius(){
        return (temperatura - 32) * 5.0 / 9.0;
    }
}
public class Exercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double entrada = scanner.nextDouble();
        Temperatura temperatura = new Temperatura(entrada);
        System.out.printf("temperatura: %.1f graus fahrenheit\n",temperatura.toFahrenheit());
        System.out.printf("temperatura: %.1f graus celsius\n",entrada);
    }
}
