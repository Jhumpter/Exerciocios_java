package Lista5;
/*Tipos de Veículos

Implemente um programa em Java com base no conceito de herança, com base no diagrama de classes descrito a seguir.
O programa deve conter uma superclasse chamada Veiculo, nela deve conter os atributos protegidos Placa (String),
Quantidade de Portas (int), Preço (float). Faça os métodos gets e sets para cada atributo, e dois construtores para a
inicialização dos atributos da classe, um para a inicialização de todos os atributos com valores default e outro para a
inicialização recebendo todos os argumentos de acordo com os atributos. Faça a subclasse carro, com o atributo privado
cor (String) e os métodos getter, setter e  construtores, como descritos anteriormente. Crie a subclasse moto, com o
atributo privado Quantidade de Cilindradas (int) e os métodos getter, setter e construtores, como descritos anteriormente.

Objetivos de estudo:
Herança e polimorfismo: o uso das palavras-chave extends e super, o modificador protected, sobreposição e sobrecarga*/

import java.util.Scanner;

//Classe Veiculo
class Veiculo{
    protected String placa;
    protected int numeroPortas;
    protected float preco;
    public Veiculo(){

    }
    public Veiculo(String placa,int numeroPortas,float preco){
        this.placa = placa;
        this.numeroPortas = numeroPortas;
        this.preco = preco;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getNumeroPortas() {
        return numeroPortas;
    }

    public void setNumeroPortas(int numeroPortas) {
        this.numeroPortas = numeroPortas;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return String.format("Placa: %s Número de portas: %d Preço: R$%.1f",placa,numeroPortas,preco);
    }
}

//Classe Carro
class Carro extends Veiculo{
    private String cor;
    public Carro(){
        super();
    }

    public Carro(String placa,int numeroPortas,float preco,String cor){
        super(placa,numeroPortas,preco);
        this.cor = cor;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public String toString() {
        return super.toString()+" Cor: "+cor;
    }
}

//Classe Moto
class Moto extends Veiculo{
    private int qtdeCilindradas;
    public Moto(){
        super();
    }

    public Moto(String placa,int numeroPortas,float preco,int qtdeCilindradas){
        super(placa,numeroPortas,preco);
        this.qtdeCilindradas = qtdeCilindradas;
    }

    public int getQtdeCilindradas() {
        return qtdeCilindradas;
    }

    public void setQtdeCilindradas(int qtdeCilindradas) {
        this.qtdeCilindradas = qtdeCilindradas;
    }

    @Override
    public String toString() {
        return super.toString()+" Quantidade de cilindradas: "+qtdeCilindradas;
    }
}


//Classe Principal
public class Exercicio1 {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        Veiculo veiculo = new Veiculo();
        veiculo.setPlaca(entrada.next());
        veiculo.setNumeroPortas(entrada.nextInt());
        veiculo.setPreco(entrada.nextFloat());
        Carro carro = new Carro(entrada.next(), entrada.nextInt(), entrada.nextFloat(), entrada.next());
        Moto moto = new Moto(entrada.next(), entrada.nextInt(), entrada.nextFloat(), entrada.nextInt());

        System.out.println(veiculo);
        System.out.println(carro);
        System.out.println(moto);

    }

}
