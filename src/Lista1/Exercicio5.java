package Lista1;

import java.util.Scanner;

public class Exercicio5 {
    /*
    Operações de venda (Java)

Uma loja de materiais de construção precisa de um programa para registrar as suas vendas e controlar o seu estoque. Faça um programa que permita o cadastro de N produtos no estoque da loja. Para cada produto, considere o nome e a quantidade do produto no estoque. Depois do cadastro do estoque, o programa deve registrar as vendas até a palavra "fim" ser informada. Para cada venda, o programa deve solicitar o nome do produto e verificar se o produto existe no estoque. Caso o nome do produto não seja encontrado no estoque, o programa deve apresentar o nome do produto seguido pela mensagem "produto não encontrado". Caso contrário, o programa deve solicitar a quantidade de unidades do determinado produto, apresentar as informações da venda (nome do produto e quantidade), e remover do estoque a quantidade vendida do determinado produto. Ao finalizar as vendas, o programa deve apresentar cada produto do estoque (nome do produto e quantidade). Utilize a classe principal para resolver o problema.

Entrada:

A primeira linha de entrada consiste em um inteiro positivo N > 0, que é quantidade de produtos a serem cadastrados no estoque da loja. As próximas N linhas consistem, cada uma, do nome do produto (uma string sem espaço) e a quantidade de produtos no estoque (um valor inteiro positivo).

Em seguida, de acordo com uma quantidade não determinada de operações de venda, deve ser solicitado o nome do produto (uma string sem espaço) até a palavra "fim" ser informada. Para cada nome do produto encontrado no estoque, a quantidade (um valor inteiro positivo) desejada do produto deve ser solicitada em uma nova linha. Considere que esta quantidade sempre será menor ou igual a quantidade do estoque (não é preciso fazer validação).

Saída:

Para cada produto da venda encontrado no estoque, o programa deve apresentar, em uma mesma linha, o nome do produto (uma string) e a quantidade da venda (valor inteiro). Caso o produto não seja encontrado no estoque, o nome do produto deve ser apresentado seguido da mensagem "produto não encontrado". Em seguida, o programa deve apresentar as informações (nome e quantidade) de todos os produtos do estoque após as operações de venda, considerando um produto em cada linha.

Dica:

A instrução "<entrada>.nextLine();" pode ser utilizada entre a leitura de um valor do tipo numérico e um valor do tipo char/String para remover um caractere/espaço do buffer do teclado. Outra opção é utilizar as classes de tipo numérico, como Integer, Long, Float, Double. Exemplo:
<numero> = Integer.parseInt(<str1>);
<numero> = Long.parseLong(<str1>);
<numero> = Float.parseFloat(<str1>);
<numero> = Double.parseDouble(<str1>);

Estudo:
- Uso da classe String
- Uso de array
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int qtde = scanner.nextInt();
        String[] produtos;
        produtos = new String[qtde];
        int[] qtde_produtos;
        qtde_produtos = new int[qtde];
        for (int i=0;i<qtde;i++) {
            String produto = scanner.next();
            int estoque = scanner.nextInt();
            produtos[i] = produto;
            qtde_produtos[i] = estoque;
        }
        String produto_solicitado = "";
        int qtde_solicitada = 0;
        int indice = -1;
        while (true) {
            produto_solicitado = scanner.next();
            boolean encontrado = false;
            if (produto_solicitado.equals("fim"))
                break;
            for (int i=0;i<qtde && !encontrado;i++){
                if (produtos[i].equals(produto_solicitado)){
                    indice = i;
                    encontrado = true;
                }
            }
            if (encontrado){
                qtde_solicitada = scanner.nextInt();
                qtde_produtos[indice] -= qtde_solicitada;
                System.out.println(produto_solicitado + " " + qtde_solicitada);
            }
            else
                System.out.println(produto_solicitado + " produto não encontrado");
        }
        for (int i = 0;i<qtde;i++) {
            System.out.println(produtos[i] + " " + qtde_produtos[i]);
        }
    }
}
