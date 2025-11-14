package Lista5;
/*
Sites de relacionamento

Em sites de relacionamento, é possível categorizar contatos pessoais em subtipos, tais como: família, amigos e colegas
de trabalho. Faça um programa de acordo com o diagrama de classes abaixo, contendo:

A superclasse chamada Contato, que deve ser ABSTRATA, com os atributos nome, apelido, email e aniversario. Considere o
construtor para inicializar todos os atributos e os seus getters e setters. Acrescente nesta superclasse o metodo public
String imprimirBasico(), que imprime o conteúdo básico dos contatos (todos os atributos descritos anteriormente).
A seguir defina um metodo  ABSTRATO imprimirContato(), que será então implementado nas subclasses de acordo com suas
especialidades. Chame o metodo imprimirBasico() dentro dos métodos de imprimirContato() das subclasses;
A classe Amigos, subclasse da classe Contato, que possui também o atributo grau, que descreve o grau de amizade desse
contato (1 = melhor amigo; 2 = amigo; 3 = conhecido). Considere o construtor para inicializar os atributos;
A classe Familia, subclasse da classe Contato, que possui também o atributo parentesco, que descreve o tipo de parentesco
desse contato (ex.: pai, irmão, mãe, etc.). Considere o construtor para inicializar os atributos;
A classe ColegasDeTrabalho, subclasse da classe Contato, que possui também o atributo tipo, que descreve o tipo desse
contato no trabalho (ex.: chefe, colega, etc.). Considere o construtor para inicializar os atributos;
A classe UsoContatos, contendo o metodo main(). Nesta classe principal defina uma lista de objetos Contatos. Em seguida,
 considere um MENU para executar as seguintes operações:
1-Inserir um contato: especificação do subtipo (1 = Amigo; 2 = Família; 3 = Colega de trabalho) e então requerendo os seus
campos (atributos da classe Contato e da subclasse de acordo com o subtipo informado);
2-Imprimir todos os contatos da lista;
3-Imprimir somente os familiares;
4-Imprimir somente os amigos;
5-Imprimir somente os colegas de trabalho;
6-Imprimir os melhores amigos (atributo grau == 1), os irmãos (atributo parentesco.equals("irmão")) e os COLEGAS de
trabalho (atributo tipo.equals("colega"));
7-Imprimir os dados de um único contato, escolhido pelo índice da lista;
8-Encerrar o programa.
Entrada:

O primeiro valor de entrada corresponde a uma determina operação do menu identificada por um inteiro de 1 a 8.  Este valor
será solicitado n vezes até o valor 8 ser informado para o encerramento do programa. Caso a operação informada for 1, um
segundo valor inteiro na mesma linha, separado por espaço, será informado, que corresponde ao subtipo 1, 2 ou 3,
representando os contatos Amigo, Familia ou ColegasDeTrabalho, respectivamente. Na próxima linha, serão informados os
valores correspondentes à classe Contato e a sua subclasse de acordo com o subtipo informado. Caso a operação do menu for
entre 2 e 6, não haverá nenhuma entrada. Caso a operação do menu seja o valor 7, na próxima linha será solicitado o índice
da lista que se deseja ter acesso.

Saída:

A saída corresponde aos atributos da classe contato e da sua subclasse de acordo com a operação informada do menu, um
atributo por linha. A saída deve ser acompanha pelos textos de acordo com os exemplos abaixo.

Dica:
ArrayList<Tipo> nomeObjeto = new ArrayList<>();


Objetivos de estudo:
Classe e metodo abstratos e Polimorfismo: sobreposição*/

import java.util.ArrayList;
import java.util.Scanner;

abstract class Contato{
    protected String nome;
    protected String apelido;
    protected String email;
    protected String aniversario;
    public Contato(String nome, String apelido, String email, String aniversario){
        this.nome = nome;
        this.apelido = apelido;
        this.email = email;
        this.aniversario = aniversario;
    }
    public void imprimirBasico(){
        System.out.printf("""
                Nome: %s
                Apelido: %s
                Email: %s
                Aniversário: %s
                """,nome,apelido,email,aniversario);
    }
    abstract void imprimirContato();
}
class Amigo extends Contato{
    protected int grau;
    public Amigo(String nome,String apelido,String email,String aniversario,int grau){
        super(nome,apelido,email,aniversario);
        this.grau = grau;
    }
    public void imprimirContato(){
        imprimirBasico();
        String nomeGrau;
        if(grau==1)
            nomeGrau = "Melhor Amigo";
        else if(grau==2)
            nomeGrau = "Amigo";
        else
            nomeGrau = "Conhecido";
        System.out.printf("""
                Grau: %s
                """,nomeGrau);
    }
    public int getGrau() {
        return grau;
    }
}
class Familia extends Contato{
    protected String parentesco;
    public Familia(String nome,String apelido,String email,String aniversario,String parentesco){
        super(nome,apelido,email,aniversario);
        this.parentesco = parentesco;
    }
    public void imprimirContato(){
        imprimirBasico();
        System.out.printf("""
                Parentesco: %s
                """,parentesco);
    }

    public String getParentesco() {
        return parentesco;
    }
}
class ColegasDeTrabalho extends Contato{
    protected String tipo;
    public ColegasDeTrabalho(String nome,String apelido,String email,String aniversario,String tipo){
        super(nome,apelido,email,aniversario);
        this.tipo = tipo;
    }
    public void imprimirContato(){
        imprimirBasico();
        System.out.printf("""
                Relacionamento de trabalho: %s
                """,tipo);
    }

    public String getTipo() {
        return tipo;
    }
}



public class Exercicio3 {
    static <T extends Contato> void imprimeLista(ArrayList<T> lista){
        for(Contato contato:lista){
            contato.imprimirContato();
        }
    }
    public static void main(String[] args) {
        ArrayList<Amigo> amigos = new ArrayList<>();
        ArrayList<Familia> familiares = new ArrayList<>();
        ArrayList<ColegasDeTrabalho> colegas = new ArrayList<>();
        ArrayList<Contato> contatos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int escolha = scanner.nextInt();
        while (escolha != 8){
            switch (escolha){
                case 1:
                    switch (scanner.nextInt()){
                        case 1:
                            scanner.nextLine();
                            String[] infoAmigo = scanner.nextLine().split(" ");
                            amigos.add(new Amigo(infoAmigo[0],infoAmigo[1],infoAmigo[2],infoAmigo[3],Integer.parseInt(infoAmigo[4])));
                            contatos.add(new Amigo(infoAmigo[0],infoAmigo[1],infoAmigo[2],infoAmigo[3],Integer.parseInt(infoAmigo[4])));
                            break;
                        case 2:
                            scanner.nextLine();
                            String[] infoFaFamilia = scanner.nextLine().split(" ");
                            familiares.add(new Familia(infoFaFamilia[0],infoFaFamilia[1],infoFaFamilia[2],infoFaFamilia[3],infoFaFamilia[4]));
                            contatos.add(new Familia(infoFaFamilia[0],infoFaFamilia[1],infoFaFamilia[2],infoFaFamilia[3],infoFaFamilia[4]));
                            break;
                        case 3:
                            scanner.nextLine();
                            String[] infoColega = scanner.nextLine().split(" ");
                            colegas.add(new ColegasDeTrabalho(infoColega[0],infoColega[1],infoColega[2],infoColega[3],infoColega[4]));
                            contatos.add(new ColegasDeTrabalho(infoColega[0],infoColega[1],infoColega[2],infoColega[3],infoColega[4]));
                            break;
                    }
                    break;
                case 2:
                    imprimeLista(contatos);
                    break;
                case 3:
                    imprimeLista(familiares);
                    break;
                case 4:
                    imprimeLista(amigos);
                    break;
                case 5:
                    imprimeLista(colegas);
                    break;
                case 6:
                    for(Amigo amigo:amigos){
                        if (amigo.getGrau()==1)
                            amigo.imprimirContato();
                    }
                    for(Familia familiar:familiares){
                        if (familiar.getParentesco().equals("irmão"))
                            familiar.imprimirContato();
                    }
                    for (ColegasDeTrabalho colega:colegas){
                        if (colega.getTipo().equals("colega"))
                            colega.imprimirContato();
                    }
                    break;
                case 7:
                    contatos.get(scanner.nextInt()-1).imprimirContato();
                    break;
                default:
                    break;
            }
            escolha = scanner.nextInt();
        }

    }
}
