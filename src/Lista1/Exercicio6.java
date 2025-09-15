package Lista1;

import java.util.Scanner;

public class Exercicio6 {
    /*
    Corretor ortográfico (Java)

Às vezes podemos digitar palavras com ortografia incorreta. Isso pode ocorrer quando não conhecemos a ortografia correta, então a "melhor suposição" é considerada. Em outros casos, é porque transpomos duas letras, por exemplo, "copmutador" em vez de "computador". Também há outros casos como digitar duas letras acidentalmente ou digitar  uma tecla próxima em vez daquela desejada. Faça um programa de verificador ortográfico, considerando os erros de transposições de duas letras. Utilize a classe principal para resolver o problema. O programa deve conter as seguintes funcionalidades na classe principal:

manter um array de strings, que serão inseridas pelo usuário;
solicitar que o usuário insira uma palavra;
pesquisar essa palavra no array de strings;
se a palavra estiver no array, o programa deve apresentar "palavra correta";
se a palavra não estiver no array, o programa deve apresentar "palavra incorreta" e apresentar outra palavra do array que pode ser a palavra que o usuário pensou em digitar, de acordo com todas as possíveis transposições;
se nenhuma palavra próxima a digitada for encontrada no array, o programa deve apresentar "nenhuma sugestão";
tentar todas as transposições simples de letras adjacentes na sequência para procurar a palavra no array.
Exemplo: "ypthon", "ptyhon", "pyhton", "pytohn", "pythno" => "python?"
Entrada:

A primeira linha de entrada corresponde a um número inteiro, num > 0, que determina a quantidade de palavras que serão cadastradas. As próximas n linhas consistem em palavras (strings), uma por linha, com todas as letras minúsculas. A próxima linha deverá ser uma palavra (string) informada pelo usuário, com todas as letras minúsculas.

Saída:

Na primeira linha, se a palavra estiver no array a saída deve ser "palavra correta" ou se a palavra não estiver no array a saída deve ser "palavra incorreta". No segundo caso, de acordo com as transposições (simples e de letras adjacentes) na sequência, somente a primeira palavra encontrada na lista seguida de "?" deve ser apresentada na próxima linha como sugestão ou a mensagem "nenhuma sugestão", caso nenhuma alteração da palavra de acordo com as transposições (simples e de letras adjacentes) for encontrada no array.


Estudo:

- Uso da classe String e StringBuilder em Java
- Uso de array em Java
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] dicionario;
        dicionario = new String[n];
        scanner.nextLine();
        for (int i=0;i<n;i++) {
            dicionario[i] = scanner.nextLine();
        }
        String palavra = scanner.nextLine();
        boolean encontrado = false;
        boolean transpostos = false;
        String transposicao = "";
        for (int i=0;i<n;i++) {
            if(palavra.equals(dicionario[i])){
                System.out.println("palavra correta");
                encontrado = true;
                break;
            }
            int avaliador = 0;
            int tamanho = palavra.length();
            if(tamanho == dicionario[i].length()&&(palavra.charAt(0)==dicionario[i].charAt(0)||(palavra.charAt(tamanho-1)==dicionario[i].charAt(tamanho-1)))){
                if(palavra.charAt(0)==dicionario[i].charAt(0))
                    avaliador++;
                for(int j=1;j<palavra.length();j++){
                    if(palavra.charAt(j)==dicionario[i].charAt(j))
                        avaliador++;
                    else{
                        if(palavra.charAt(j)==dicionario[i].charAt(j-1)&&palavra.charAt(j-1)==dicionario[i].charAt(j)){
                            avaliador+=2;
                        }
                    }
                }
                if(avaliador>=palavra.length()){
                    transpostos = true;
                    transposicao = dicionario[i];
                    break;
                }
            }
        }
        if(!encontrado){
            System.out.println("palavra incorreta");
            if(transpostos)
                System.out.println(transposicao+"?");
            else
                System.out.println("nenhuma sugestão");
        }
    }
}
