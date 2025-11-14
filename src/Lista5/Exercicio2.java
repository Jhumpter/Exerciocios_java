package Lista5;
/*Empresa


Uma empresa tem quatro tipos de funcionários: chefes, vendedores, operários e horistas. Cada um desses funcionários ganha
 seus salários de acordo com as seguintes regras:

Chefe: salário fixo;
Vendedor: salário fixo + comissão x quantidade de vendas;
Operario: valor por produção x quantidade produzida;
Horista: valor por hora x total de horas trabalhadas.
Faça um programa de acordo com o diagrama de classes abaixo. A superclasse Funcionario deve incluir os campos privados
nome, dataNascimento e salario. As subclasses devem conter os atributos necessários de acordo com o tipo de funcionário.
Considere o construtor de cada subclasse para calcular e alterar o salário de acordo as regras mencionadas acima. Criar
também uma classe FolhaPagamento, com um metodo para mostrar a folha de pagamento da empresa de acordo o nome e a
cidade da empresa, o mês do pagamento e os dados de cada funcionário,
considerando as informações específicas de acordo com o tipo de Funcionário (subclasse).
Objetivos de estudo:
Herança e polimorfismo: o uso da palavra-chave instanceof*/
import java.util.Scanner;

//Classes
class FolhaPagamento{
    public void mostrarPagamentos(String nome, String cidade,String mes,Funcionario[] funcionarios){
        System.out.printf("""
                Nome da Empresa: %s
                Endereço: %s
                Mês: %s
                """,nome,cidade,mes);
        for(Funcionario funcionario:funcionarios){
            System.out.print(funcionario.toString());
        }
    }
}
class Funcionario{
    private String nome;
    private String dataNascimento;
    private float salario;
    public Funcionario(){    }
    public Funcionario(String nome,String dataNascimento,float salario){
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
    @Override
    public String toString(){
        return String.format("""
        
                Nome: %s
                Data de Nascimento: %s
                Salário: R$%.1f""",nome,dataNascimento,salario);
    }
}

class Chefe extends Funcionario{
    private String departamento;
    public Chefe(){}
    public Chefe(String nome,String dataNascimento,float salario,String departamento){
        super(nome,dataNascimento,salario);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    @Override
    public String toString(){
        return super.toString()+String.format("""
        
                Departamento: %s
                Cargo: chefe
                """, departamento);
    }
}

class Vendedor extends Funcionario{
    private float comissaoVenda;
    private int numeroVendas;
    public Vendedor(){
        super();
    }
    public Vendedor(String nome,String dataNascimento,float salario,float comissaoVenda,int numeroVendas){
        super(nome,dataNascimento,salario+(comissaoVenda*numeroVendas));
        this.comissaoVenda = comissaoVenda;
        this.numeroVendas = numeroVendas;
    }

    public float getComissaoVenda() {
        return comissaoVenda;
    }

    public void setComissaoVenda(float comissaoVenda) {
        this.comissaoVenda = comissaoVenda;
    }

    public int getQuatidadeVendas() {
        return numeroVendas;
    }

    public void setQuatidadeVendas(int numeroVendas) {
        this.numeroVendas = numeroVendas;
    }
    @Override
    public String toString(){
        return super.toString()+String.format("""
        
                Cargo: vendedor
                Comissão por Venda: R$%.1f
                Número de vendas: %d
                """,comissaoVenda,numeroVendas);
    }
}

class Operario extends Funcionario{
    private float valorProducao;
    private int quantidadeProduzida;
    public Operario(){
        super();
    }
    public Operario(String nome,String dataNascimento,float salario,float valorProducao,int quantidadeProduzida){
        super(nome,dataNascimento,valorProducao*quantidadeProduzida);
        this.valorProducao = valorProducao;
        this.quantidadeProduzida = quantidadeProduzida;
    }

    public float getValorProducao() {
        return valorProducao;
    }

    public void setValorProducao(float valorProducao) {
        this.valorProducao = valorProducao;
    }

    public int getQuantidadeProduzida() {
        return quantidadeProduzida;
    }

    public void setQuantidadeProduzida(int quantidadeProduzida) {
        this.quantidadeProduzida = quantidadeProduzida;
    }
    @Override
    public String toString(){
        return super.toString()+String.format("""
        
                Cargo: Operário
                Valor por Produção: R$%.1f
                Quantidade produzida: %d
                """,valorProducao,quantidadeProduzida);
    }
}

class Horista extends Funcionario{
    private float valorHora;
    private int totalHoras;
    public Horista(){
        super();
    }
    public Horista(String nome,String dataNascimento,float salario,float valorHora,int totalHoras){
        super(nome,dataNascimento,valorHora*totalHoras);
        this.valorHora = valorHora;
        this.totalHoras = totalHoras;
    }

    public float getValorHora() {
        return valorHora;
    }

    public void setValorHora(float valorHora) {
        this.valorHora = valorHora;
    }

    public int getTotalHoras() {
        return totalHoras;
    }

    public void setTotalHoras(int totalHoras) {
        this.totalHoras = totalHoras;
    }
    @Override
    public String toString(){
        return super.toString()+String.format("""
        
                Cargo: horista
                Valor por Hora: R$%.1f
                Total de horas: %d
                """,valorHora,totalHoras);
    }
}
//Classe principal
public class Exercicio2 {
    private Funcionario funcionario;
    private FolhaPagamento folhaPagamento;
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        Funcionario[] funcionarios = new Funcionario[4];

        String nome = entrada.next();
        String cidade = entrada.next();
        String mes = entrada.next();

        funcionarios[0] = new Chefe(entrada.next(), entrada.next(), entrada.nextFloat(), entrada.next());
        funcionarios[1] = new Vendedor(entrada.next(), entrada.next(), entrada.nextFloat(), entrada.nextFloat(), entrada.nextInt());
        funcionarios[2] = new Operario(entrada.next(), entrada.next(), entrada.nextFloat(), entrada.nextFloat(), entrada.nextInt());
        funcionarios[3] = new Horista(entrada.next(), entrada.next(), entrada.nextFloat(), entrada.nextFloat(), entrada.nextInt());

        FolhaPagamento folha = new FolhaPagamento();
        folha.mostrarPagamentos(nome, cidade, mes, funcionarios);

    }

}
