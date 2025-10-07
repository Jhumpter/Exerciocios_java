/*
Construa um programa que valide senhas fornecidas pelo usuário. O programa deve utilizar uma classe chamada ValidarSenha
para verificar se uma senha contém pelo menos uma letra maiúscula. A classe deve conter um metodo chamado verificarMaiusculas(),
que recebe uma senha como parâmetro e verifica se há pelo menos um caractere maiúsculo. Caso a senha não contenha nenhuma
letra maiúscula, o metodo deve lançar uma exceção do tipo IllegalArgumentException indicando argumento inválido com a mensagem:
"Erro: a senha deve conter pelo menos uma letra maiúscula".
No metodo main, o programa deve: solicitar que o usuário informe uma senha; criar um objeto da classe ValidarSenha; chamar
o metodo verificarMaiusculas(); se a senha for válida (possuir pelo menos uma letra maiúscula), apresentar a mensagem:
"Senha válida". Caso ocorra a exceção, capturar e apresentar a mensagem de erro. O programa deve continuar solicitando uma
nova senha até que uma válida seja informada.

Dica:

IllegalArgumentException é uma exceção fornecida pelo Java que indica que um metodo recebeu um argumento inválido. Você
pode lançá-la com a palavra-chave throw seguida de uma nova instância. Em combinação com try-catch, você pode capturar a
exceção e tratar o erro de forma controlada, evitando que o programa termine abruptamente.
*/
package Lista3;
import java.util.Scanner;

class ValidarSenha {
    static public void verificarMaiusculas(String senha){
        char[] caracteres = senha.toCharArray();
        for (char caractere : caracteres){
            if (Character.isUpperCase(caractere)){
                return;
            }
        }
        throw new IllegalArgumentException();
    }
}

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean senhaValida = false;
        while (!senhaValida) {
            try {
                String senha = scanner.nextLine();
                ValidarSenha.verificarMaiusculas(senha);
                System.out.println("Senha válida");
                senhaValida = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: a senha deve conter pelo menos uma letra maiúscula");
            }
        }
    }
}
