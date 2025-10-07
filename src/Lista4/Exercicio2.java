/*
Desenvolvimento de Projetos

A empresa DevSoft Engenharia está desenvolvendo um sistema de gestão de projetos de software, com base na modelagem
orientada a objetos, conforme o diagrama de classe  UML fornecido abaixo .
O sistema deve ser implementado em Java com os seguintes requisitos e regras de negócio:

Requisitos

A empresa possui:

Engenheiros cadastrados (responsáveis pelos projetos).

Funcionários cadastrados (alocados nas tarefas dos projetos).

Projetos de software em diferentes fases (planejamento, desenvolvimento, finalizado).

Tarefas atribuídas a funcionários, que compõem o escopo de cada projeto.

Para cada projeto, devem ser registrados:

Nome do projeto

Status do projeto (planejamento, em desenvolvimento, finalizado etc.)

Data de início (formato: dd/MM/yyyy)

Data de fim (opcional, se finalizado)

Engenheiro responsável (relacionamento unidirecional)

Lista de tarefas associadas ao projeto

Para cada tarefa, devem ser registrados:

Descrição

Data da execução

Quantidade de horas estimadas ou gastas

Funcionário responsável (relacionamento unidirecional)

Regras de Negócio

Tarefas só podem existir dentro de um projeto (composição).

A quantidade de horas deve ser positiva, conforme a validação interna no metodo setQtdeHoras( ).

Um projeto pode ter nenhuma ou várias tarefas.

Um funcionário pode estar vinculado a tarefas de diferentes projetos.

Um engenheiro pode ser responsável por vários projetos ou nenhum.

Cada projeto possui métodos específicos para:

Adicionar tarefas com os dados da execução, adicionarTarefa( ).

Calcular o total de horas acumuladas no projeto, calcularHorasTotal( ).

Filtrar tarefas por data ou por funcionário, getTarefasPorData( ) e getTarefasPorFuncionario( ).
Mostrar um resumo do projeto, incluindo engenheiro responsável, quantidade de tarefas e total de horas, mostrarProjeto( ).

Objetivo do Exercício:

Com base no diagrama de classes e na classe principal fornecidos , o aluno deverá:

Compreender os relacionamentos entre classes (Engenheiro, Projeto, Tarefa, Funcionário).
Analisar o uso de composição, encapsulamento, validação, construtores, métodos de busca e cálculos.
Avaliar e estender o código com novos projetos, novas funcionalidades ou validações adicionais.
Simular cenários realistas de projetos de desenvolvimento de software, reforçando os conceitos de orientação a objetos.
Criar exemplos de uso, testando diferentes situações (tarefas em dias diferentes, funcionários em mais de um projeto,
resumos por projeto).
Garantir a consistência dos dados: evitar registros duplicados e garantir que todas as tarefas estejam associadas a um
projeto e a um funcionário válido.
*/
package Lista4;

import java.util.List;
import java.util.ArrayList;

class Engenheiro {
    private String nome;
    private String crea;

    public Engenheiro(String nome, String crea){
        this.nome = nome;
        this.crea = crea;
    }

    public String getNome() {
        return nome;
    }
}

class Funcionario {
    private String cargo;
    private String nome;

    public Funcionario(String nome, String cargo){
        this.cargo = cargo;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}

class Tarefa {
    private String descricao;
    private String data;
    private float qtdeHoras;
    private Funcionario funcionario;
    private Projeto projeto;

    public void setQtdeHoras(float qtdeHoras) {
        this.qtdeHoras = qtdeHoras;
    }

    public String getData() {
        return data;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public String getDescricao() {
        return descricao;
    }

    public float getQtdeHoras() {
        return qtdeHoras;
    }

    public Tarefa(String descricao, String data, int qtdeHoras, Funcionario funcionario){
        this.descricao = descricao;
        this.data = data;
        this.qtdeHoras = qtdeHoras;
        this.funcionario = funcionario;
    }

}

class Projeto {
    private String nome;
    private String status;
    private String dataInicio;
    private String dataFim;
    private Engenheiro engenheiro;
    private List<Tarefa> tarefas = new ArrayList<>();

    public Projeto(String nome, String status, String dataInicio, String dataFim, Engenheiro engenheiro) {
        this.nome = nome;
        this.status = status;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.engenheiro = engenheiro;
    }

    public void adicionarTarefa(String descricao,String data,int horas,Funcionario funcionario){
        tarefas.add(new Tarefa(descricao,data,horas,funcionario));
    }
    public int calcularHorasTotal(){
        int horasTotal = 0;
        for(Tarefa tarefa:tarefas)
            horasTotal+=(int)tarefa.getQtdeHoras();
        return horasTotal;
    }
    public List<Tarefa> getTarefasPorData(String data){
        List<Tarefa> tarefasPorData = new ArrayList<>();
        for(Tarefa tarefa:tarefas){
            if (tarefa.getData().equals(data))
                tarefasPorData.add(tarefa);
        }
        return tarefasPorData;
    }
    public List<Tarefa> getTarefasPorFuncionario(Funcionario funcionario){
        List<Tarefa> tarefasPorFuncionario = new ArrayList<>();
        for(Tarefa tarefa:tarefas){
            if (tarefa.getFuncionario().equals(funcionario))
                tarefasPorFuncionario.add(tarefa);
        }
        return tarefasPorFuncionario;
    }
    public void mostrarProjeto(){
        if(dataFim==null)
            dataFim = "em aberto";
        System.out.printf("""
                ------ PROJETO ------
                Nome: %s
                Status: %s
                Início: %s
                Término: %s
                Engenheiro Responsável: %s
                Total de Tarefas: %d
                Horas Totais: %d
                
                """,nome,status,dataInicio,dataFim,engenheiro.getNome(),tarefas.size(),calcularHorasTotal());

    }
    public String getNome() {
        return nome;
    }
}

public class Exercicio2 {
    public static void main(String[] args) {

        //Engenheiros
        Engenheiro eng1 = new Engenheiro("Mariana Lopes", "DF001122");
        Engenheiro eng2 = new Engenheiro("Roberto Silva", "SP334455");
        Engenheiro eng3 = new Engenheiro("Fernanda Alves", "RJ556677");

        //Funcionários
        Funcionario func1 = new Funcionario("Lucas", "Desenvolvedor");
        Funcionario func2 = new Funcionario("Juliana", "Analista de Sistemas");
        Funcionario func3 = new Funcionario("Paulo", "Engenheiro de Software");
        Funcionario func4 = new Funcionario("Renata", "Testadora");

        //Lista geral de projetos
        List<Projeto> projetos = new ArrayList<>();

        //Projetos
        Projeto projeto1 = new Projeto("Sistema de Controle Acadêmico", "Em desenvolvimento", "01/05/2025", null, eng1);
        projeto1.adicionarTarefa("Modelagem de dados", "02/05/2025", 5, func2);
        projeto1.adicionarTarefa("Backend", "03/05/2025", 8, func1);
        projeto1.adicionarTarefa("Integração", "04/05/2025", 6, func2);
        projetos.add(projeto1);

        Projeto projeto2 = new Projeto("Aplicativo de Saúde", "Planejamento", "05/05/2025", null, eng2);
        projeto2.adicionarTarefa("Requisitos", "05/05/2025", 4, func3);
        projeto2.adicionarTarefa("Protótipo", "06/05/2025", 7, func4);
        projetos.add(projeto2);

        Projeto projeto3 = new Projeto("Plataforma de E-commerce", "Finalizado", "01/04/2025", "30/04/2025", eng1);
        projeto3.adicionarTarefa("API de produtos", "10/04/2025", 6, func1);
        projeto3.adicionarTarefa("Testes automatizados", "15/04/2025", 5, func4);
        projetos.add(projeto3);

        //Exibir todos os projetos
        for (Projeto projeto : projetos) {
            projeto.mostrarProjeto();
            System.out.println();
        }

        //Buscar tarefas de Juliana
        System.out.println("Tarefas de " + func2.getNome());
        for (Projeto projeto : projetos) {
            for (Tarefa tarefa : projeto.getTarefasPorFuncionario(func2)) {
                System.out.println("Projeto: " + projeto.getNome());
                System.out.println("Nome da Tarefa: " + tarefa.getDescricao() + ", Data: " + tarefa.getData());
                System.out.println();
            }
        }

        //Buscar tarefas por data
        String dataBusca = "06/05/2025";
        System.out.println("Tarefas na data " + dataBusca);
        for (Projeto projeto : projetos) {
            for (Tarefa tarefa : projeto.getTarefasPorData(dataBusca)) {
                System.out.println("Projeto: " + projeto.getNome());
                System.out.println("Nome da Tarefa: " + tarefa.getDescricao() + ", Funcionário: " + tarefa.getFuncionario().getNome());
                System.out.println();
            }
        }

    }
}
