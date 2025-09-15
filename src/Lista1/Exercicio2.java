package Lista1;
import java.util.Scanner;
public class Exercicio2 {
    /*
    Consumo de energia elétrica (Java)

A conta de energia elétrica de consumidores residenciais de uma cidade é calculada do seguinte modo, onde o consumo é dado em kilowatts (kw):

Se o consumo é de até 500 kw, a tarifa é de R$ 0,02 por unidade.
Se o consumo é maior que 500 kw, mas não excede 1000 kw, a tarifa é de R$ 0,10 para os 500 primeiros kw e de R$ 0,05 para cada kw excedente a 500.
Se o consumo é maior que 1000 kw, a tarifa é de R$ 0,35 para os 1000 primeiros kw e de R$ 0,10 para cada kw excedente a 1000.
Em toda conta, é cobrada uma taxa básica de serviço de R$ 5,00, independentemente da quantidade de energia consumida.
Implemente um programa que leia o consumo de energia elétrica de uma residência e imprima a sua conta de energia.

Entrada:

Uma entrada do tipo float que corresponde ao consumo de energia elétrica (em kilowatts). O programa deve considerar que o valor fornecido para o consumo de energia será um valor inteiro positivo, não sendo necessário fazer nenhuma validação dos dados de entrada.

Saída:

Três saídas do tipo float com duas casas decimais. A primeira corresponde ao custo da energia de acordo com o consumo. A segunda saída é o valor fixo referente a taxa básica de serviço. A terceira saída é o valor total a pagar de acordo com o consumo e a taxa básica de serviço. Todas as saídas devem ser apresentadas em uma única linha separadas por um espaço.

Estudo:

- Estruturas condicionais
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float consumo = scanner.nextFloat();
        float preco;
        if (consumo<=500){
            preco = consumo*0.02f;
        }else if (consumo<=1000){
            preco = 500*0.1f+(consumo-500)*0.05f;
        }else{
            preco = 1000*0.35f+(consumo-1000)*0.1f;
        }
        float taxa = 5;
        System.out.printf("%.2f %.2f %.2f", preco, taxa, preco+taxa);
        scanner.close();
    }
}
