package Lista1;

import java.util.Scanner;

public class Exercicio4 {
    /*
    Controle de acesso de pessoas (Java)

No próximo final de semana ocorrerá a festa da Computação da UnB. O ingresso masculino será de R$ 12,50 e o feminino será de R$ 7,40. Um calouro ficou encarregado de operar um programa na portaria para controlar o acesso das pessoas à festa. O programa é executado da seguinte forma:

Quando chega um homem na festa, ele digita 'h'.
Quando chega uma mulher na festa ele digita 'm'.
Quando o calouro quiser encerrar a entrada de dados ele digita 'q'.
O calouro não tem noção de quantas pessoas irão à festa. No momento que a entrada de dados for encerrada, o programa calcula quanto foi arrecadado com os ingressos masculinos e com os ingressos femininos. Também é calculado o total arrecadado.

Entrada:

A entrada será um char, que poderá identificar quem chegou à festa, um homem ('h') ou uma mulher ('m') ou encerrar a entrada de dados ('q').  A entrada de dados será solicita enquanto não for informado o valor 'q'. Não é necessário a validação dos dados de entrada.

Saída:

Cinco saídas apresentadas em duas linhas. Na primeira linha, a quantidade de homens que chegaram à festa é apresentada e na sequência a quantidade de mulheres, separadas por espaço. Na segunda linha, também separados por espaço, na seguinte ordem: o valor arrecadado com os ingressos masculinos, o valor arrecadado com os ingressos femininos e o arrecadamento total, com duas casas decimais.

Dica:

O metodo charAt(0) pode ser utilizado para considerar o primeiro caractere informado na entrada pelo usuário.

Estudo:

- Dados de entrada do tipo caractere
- Estruturas de repetição
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char sexo = 'a';
        int homens = 0;
        int mulheres = 0;
        while (sexo!='q') {
            String entrada = scanner.nextLine();
            sexo = entrada.charAt(0);
            if (sexo == 'h'){
                homens++;
            }
            else if (sexo == 'm'){
                mulheres++;
            }


        }
        System.out.println(homens + " " + mulheres);
        float total_h = homens*12.5f;
        float total_m = mulheres*7.4f;
        System.out.printf("%.2f %.2f %.2f", total_h, total_m, total_h+total_m);
    }
}
