package Lista1;
import java.util.Scanner;
/*
         Peso Ideal (Java)

        Segundo uma tabela médica, o peso ideal de uma pessoa está relacionado com a sua altura e com o seu sexo. Implemente um programa que receba como entradas a altura (A) e o sexo (S); a seguir ele calcula e imprime o peso ideal dessa pessoa, considerando:

        A não pode ser menor ou igual a zero, neste caso, a mensagem "Entrada inválida!", deverá ser impressa na tela;
        Caso o sexo seja inválido, ou seja, S diferente de 'm' e 'f', a mensagem "Entrada inválida!", deverá ser impressa na tela;
        Se S = 'm' (masculino), peso_ideal = (72.7 x A) - 58;
        Se S = 'f' (feminino), peso_ideal = (62.1 x A) - 44.7.
        Entrada:

        Uma entrada do tipo float para a altura (em metros), que deve ser maior que zero, e uma entrada do tipo char para o sexo, sendo que o primeiro caracter deve ser 'm' (maculino) ou 'f' (feminino).

        Saída:

        Uma saída que corresponde ao peso ideal (em kg), que é um float com 1 casa decimal apenas.

        Dica:

        O metodo charAt(0) pode ser utilizado para considerar o primeiro caractere informado na entrada pelo usuário.

        A instrução "<entrada>.nextLine();" pode ser utilizada entre a leitura de um valor do tipo númerico e um valor do tipo char/String para remover um caractere/espaço do buffer do teclado. Outra opção é utilizar as classes de tipo numérico, como Integer, Long, Float, Double. Exemplo:
        <numero> = Integer.parseInt(<str1>);
        <numero> = Long.parseLong(<str1>);
        <numero> = Float.parseFloat(<str1>);
        <numero> = Double.parseDouble(<str1>);

        Estudo:

        - Dados de entrada do tipo caractere
        - Estruturas condicionais
         */
public class Exercicio1 {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        String valor = entrada.nextLine();
        float altura = Float.parseFloat(valor);
        String palavra = entrada.nextLine();
        char sexo = palavra.charAt(0);
        if (altura <= 0){
            System.out.println("Entrada inválida!");
        } else {
            if(sexo == 'm'){
                float pesoIdeal = 72.7f*altura -58.0f;
                System.out.printf("%.1f kg",pesoIdeal);
            } else if (sexo == 'f'){
                float pesoIdeal = 62.1f*altura -44.7f;
                System.out.printf("%.1f kg",pesoIdeal);
            } else {
                System.out.println("Entrada inválida!");
            }
        }
        entrada.close();
    }
}
