package Lista1;
import java.util.Scanner;
public class Exercicio3 {
    /*
    Cálculo do IPTU (Java)

Uma empresa contratou você para fazer um programa que calcule os valores do IPTU de imóveis de uma determinada cidade, conforme o tipo do loteamento e a área dos mesmos. Deverão ser considerados apenas dois tipos de loteamento: 1 e 2. Para cada tipo de loteamento, se a área do imóvel for menor que 200 m2, efetua-se um cálculo de IPTU; se for maior ou igual a 200 m2, efetua-se outro cálculo de IPTU. A tabela abaixo mostra como o cálculo deve ser efetuado para cada caso.

Tipo de loteamento | 0 < área < 200 m2 | Área ≥ 200 m2
1                    IPTU = ÁREA × 1,0   IPTU = ÁREA x 1,2
2                    IPTU = ÁREA × 1,1   IPTU = ÁREA x 1,3

Implemente um programa que leia o tipo de um loteamento e a área do mesmo e apresente o valor do IPTU de um determinado imóvel, calculado conforme a tabela acima. Caso o valor do tipo de loteamento e/ou a área do imóvel forem inválidos, uma mensagem de entrada inválida deve ser impressa na tela.

Entrada:

O programa necessita de duas entradas do tipo inteiro para representar o tipo de loteamento e a área do imóvel em m2. O tipo de loteamento deve conter o valor 1 ou 2 e a área do imóvel deve ser maior que zero, caso contrário as entradas são inválidas.

Saída:

A saída é o valor do IPTU calculado de acordo com o tipo de loteamento e área do imóvel, que é um float com duas casas decimais.

Estudo:

- Estruturas condicionais aninhadas
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int valor1 = scanner.nextInt();
        float valor2 = scanner.nextInt();
        float iptu;
        if(valor1<=0||valor2<=0||valor1>2){
            System.out.println("Entrada inválida!");
        }else if(valor1==1){
            if(valor2<200){
                iptu = valor2;
            }else{
                iptu = valor2*1.2f;
            }
            System.out.printf("%.2f",iptu);
        }else if(valor1==2){
            if(valor2<200){
                iptu = valor2*1.1f;
            }else{
                iptu = valor2*1.3f;
            }
            System.out.printf("%.2f",iptu);
        }
        scanner.close();
    }
}
