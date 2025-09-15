package Lista1;

import java.util.Scanner;

public class Exercicio7 {
    /*
    Siglas da internet (Java)

Atualmente, as mensagens em redes sociais contêm várias siglas. No entanto, muitas pessoas ainda não as conhecem e isso dificulta a comunicação. Faça um programa que apresenta a tradução das siglas da internet em uma frase informada pelo usuário. O programa deve manter um dicionário de siglas com os seus significados correspondentes, que serão cadastrados previamente. Utilize a classe principal para resolver o problema.

Entrada:

A primeira linha de entrada corresponde a um número inteiro, num > 0, que determina a quantidade de siglas que serão cadastradas. As próximas n linhas consistem de várias sequências de uma sigla da internet e o seu significado, ambas correspondem a uma única palavra, separadas por espaço, com todas as letras minúsculas. A próxima linha deverá ser uma string com uma frase informada pelo usuário. Considere que todas as pontuações estarão separadas por um espaço.

Saída:

No final, o programa deve apresentar a frase informada pelo usuário com as siglas da internet traduzidas de acordo com os seus significados cadastrados no dicionário. Considere a apresentação da frase sem nenhuma modificação caso a sigla não for encontrada no dicionário.

Dica:
Use o charset "UTF-8" ou "ISO-8859-1" como argumento no construtor do Scanner para armazenar os caracteres com acento.

Estudo:

- Uso da classe String
- Uso de array
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] giria;
        giria = new String[n];
        String[] traducao;
        traducao = new String[n];
        scanner.nextLine();
        for (int i=0;i<n;i++) {
            giria[i] = scanner.next();
            traducao[i] = scanner.next();
            scanner.nextLine();
        }
        String palavra = "";
        while (scanner.hasNext()) {
            boolean traduzido = false;
            palavra = scanner.next();
            for(int i=0;i<n;i++){
                if(palavra.equalsIgnoreCase(giria[i])){
                    traduzido = true;
                    System.out.print(traducao[i]);
                }
            }
            if(!traduzido)
                System.out.print(palavra);
            System.out.print(" ");
        }
    }
}