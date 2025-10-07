/*
Sistema de Gestão de Chamados de Táxi

A empresa de táxis "Rota DF" deseja um sistema de gestão de chamados de táxi baseado em modelagem orientada a objetos,
conforme o diagrama de classes UML fornecido abaixo.
O sistema deve ser implementado em Java, atendendo aos seguintes requisitos e regras de negócio:

Requisitos

A empresa possui veículos, motoristas e clientes cadastrados.

Os chamados feitos pelos clientes podem ser de dois tipos:

Corrida: deslocamento dentro do Distrito Federal (Plano Piloto ou cidades-satélites).

Viagem: deslocamento para outras cidades fora do DF.

Para cada chamado, devem ser registrados:
Código de identificação do chamado (incrementado sequencialmente para cada chamado)
Data do chamado (formato: "dd/MM/yyyy")
Tipo do chamado (corrida ou viagem)
Origem e destino
Horário de partida
Horário de chegada (quando o chamado for finalizado)
Quilometragem inicial
Quilometragem final (quando o chamado for finalizada)
Valor total (calculado com base na distância e no tipo de chamado)
Veículo utilizado (relacionamento unidirecional)
Motorista responsável (relacionamento unidirecional)
Cliente atendido (relacionamento unidirecional)
Regras de Negócio

Os chamados podem ser criados com todos os dados (chamado já finalizado) ou com dados parciais (por exemplo, apenas
horário de partida e quilometragem inicial), sendo finalizados posteriormente por meio do metodo finalizarChamado( ),
que recebe horário de chegada e quilometragem final.

A distância é calculada pela diferença entre a quilometragem final e a inicial, utilizando o metodo calcularDistancia( ).
O valor total do chamado é calculado automaticamente com base no tipo, por meio do metodo calcularValorTotal( ):
Corrida: R$ 3,59 por kmViagem: R$ 6,51 por kmOs dados de hora de chegada, distância e valor total do chamado só são exibidos
pelo metodo mostrarChamado( ) se o chamado estiver finalizado, conforme verificação do metodo isFinalizado( ).
Consistência dos dados:Um cliente pode solicitar nenhum ou vários chamados no mesmo dia, um por vez.Um mesmo veículo pode
atender nenhum ou vários chamados no mesmo dia, desde que os horários não se sobreponham.Um mesmo motorista pode realizar
    nenhum ou vários chamados por dia, respeitando horários e uso do veículo.

Objetivo do Exercício:

Com base no diagrama de classes e na classe principal fornecidos , o aluno deverá:


Compreender a estrutura do sistema e os relacionamentos entre as classes.

Observar o uso de enumerações, encapsulamento, métodos acessores e modificadores, construtores sobrecarregados e métodos
de cálculo e controle de estado dos objetos.

Analisar as possíveis quebras de encapsulamento, por exemplo para os atributos codigoChamado e valorTotal.

Realizar possíveis alterações, melhorias ou adições de chamados, mantendo a consistência dos dados e lógica de negócio
em novos testes.
*/
package Lista4;

import java.util.ArrayList;
import java.util.List;

class Cliente {
    private String cpf;
    private String nome;

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public Cliente(String cpf, String nome){
        this.cpf = cpf;
        this.nome = nome;
    }
}

class Motorista {
    private String nome;
    private String cnh;

    public Motorista(String nome, String cnh){
        this.nome = nome;
        this.cnh = cnh;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public String getCnh() {
        return cnh;
    }

    public String getNome() {
        return nome;
    }
}

class Veiculo {
    private String modelo;
    private String placa;

    public Veiculo(String modelo, String placa){
        this.modelo = modelo;
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}

enum TipoChamado {
    CORRIDA,VIAGEM
}

class Chamado {
    private static int contadorChamados = 100;
    private int codigoChamado;
    private TipoChamado tipo;
    private String data;
    private String origem;
    private String destino;
    private String horaPartida;
    private String horaChegada;
    private double kmInicial;
    private double kmFinal;
    private double valorTotal;
    private Veiculo veiculo;
    private Motorista motorista;
    private Cliente cliente;

    public Chamado(TipoChamado tipo, String data, String origem, String destino, String horaPartida,
                   String horaChegada, double kmInicial, double kmFinal, Veiculo veiculo, Motorista motorista, Cliente cliente){
        this.tipo = tipo;
        this.data = data;
        this.origem = origem;
        this.destino = destino;
        this.horaPartida = horaPartida;
        this.horaChegada = horaChegada;
        this.kmInicial = kmInicial;
        this.kmFinal = kmFinal;
        this.veiculo = veiculo;
        this.motorista = motorista;
        this.cliente = cliente;
    }
    public Chamado(TipoChamado tipo, String data, String origem, String destino, String horaPartida,
                   double kmInicial, Veiculo veiculo, Motorista motorista, Cliente cliente){
        this.tipo = tipo;
        this.data = data;
        this.origem = origem;
        this.destino = destino;
        this.horaPartida = horaPartida;
        this.kmInicial = kmInicial;
        this.veiculo = veiculo;
        this.motorista = motorista;
        this.cliente = cliente;
    }

    public void finalizarChamado(String horaChegada, double kmFinal){
        this.horaChegada = horaChegada;
        this.kmFinal = kmFinal;
    }
    private boolean isFinalizado(){
        return horaChegada!=null && kmFinal != 0;
    }
    private double calcularDistancia(){
        return kmFinal-kmInicial;
    }
    private double calcularValorTotal(){
        if (tipo == TipoChamado.CORRIDA){
            return calcularDistancia()*3.59;
        }
        return calcularDistancia()*6.51;
    }
    public void mostrarChamado(){
        if (isFinalizado()){
            System.out.printf("""
                    Chamado: %d
                    Data: %s
                    Tipo: %s
                    Cliente: %s (CPF: %s)
                    Motorista: %s (CNH: %s)
                    Veículo: %s (Placa: %s)
                    Origem: %s
                    Destino: %s
                    Partida: %s
                    Chegada: %s
                    Distância: %.1f km
                    Valor total: R$ %.2f
                    """, Chamado.contadorChamados,data,tipo,cliente.getNome(),cliente.getCpf(),
                    motorista.getNome(),motorista.getCnh(),veiculo.getModelo(),veiculo.getPlaca(),origem,destino,
                    horaPartida,horaChegada,calcularDistancia(),calcularValorTotal());
        }else{
            System.out.printf("""
                    Chamado: %d
                    Data: %s
                    Tipo: %s
                    Cliente: %s (CPF: %s)
                    Motorista: %s (CNH: %s)
                    Veículo: %s (Placa: %s)
                    Origem: %s
                    Destino: %s
                    Partida: %s
                    Chegada: Aguardando finalização...
                    """, Chamado.contadorChamados,data,tipo,cliente.getNome(),cliente.getCpf(),
                    motorista.getNome(),motorista.getCnh(),veiculo.getModelo(),veiculo.getPlaca(),origem,destino,horaPartida);
        }
        contadorChamados++;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }
}

public class Exercicio1 {
    public static void main(String[] args) {

        Cliente cliente1 = new Cliente("12345678901", "João");
        Cliente cliente2 = new Cliente("98765432100", "Maria");
        Cliente cliente3 = new Cliente("55544433322", "Carlos");

        Motorista motorista1 = new Motorista("Carlos Silva", "1234567890");
        Motorista motorista2 = new Motorista("José Souza", "0987654321");
        Motorista motorista3 = new Motorista("Ana Costa", "1122334455");

        Veiculo veiculo1 = new Veiculo("Fiat Uno", "ABC1D23");
        Veiculo veiculo2 = new Veiculo("Volkswagen Gol", "XYZ9A87");
        Veiculo veiculo3 = new Veiculo("Chevrolet Onix", "LMN5P32");

        //Alterações no cliente1:
        cliente1.setNome("João da Silva Santos");

        //Informações sobre o nome do motorista2
        System.out.println("Motorista 2: " + motorista2.getNome() + "\n");

        //Informações sobre o veículo3
        System.out.println("Veículo 3: Modelo: " + veiculo3.getModelo() + ", Placa: " + veiculo3.getPlaca()+"\n");

        List<Chamado> chamados = new ArrayList<>();

        //Corrida - finalizada
        Chamado chamado1 = new Chamado(TipoChamado.CORRIDA, "01/05/2025", "Setor Comercial Sul",
                "Asa Norte", "14:00", "14:30", 1234, 1241, veiculo3,
                motorista3, cliente3);
        chamados.add(chamado1);

        //Corrida - não finalizada
        Chamado chamado2 = new Chamado(TipoChamado.CORRIDA, "01/05/2025", "Asa Norte",
                "Praça dos Três Poderes", "15:00", "15:20", 1242, 1251,
                veiculo3, motorista3, cliente1);
        chamados.add(chamado2);

        //Viagem - finalizada
        Chamado chamado3 = new Chamado(TipoChamado.VIAGEM, "01/05/2025", "Asa Sul", "Formosa",
                "15:30", "17:00", 2000, 2075, veiculo1, motorista1, cliente2);
        chamados.add(chamado3);

        //Corrida - não finalizada
        Chamado chamado4 = new Chamado(TipoChamado.CORRIDA, "05/05/2025", "Taguatinga",
                "Shopping Conjunto Nacional", "13:00", 3050, veiculo1, motorista1, cliente2);
        chamados.add(chamado4);

        //Corrida - não finalizada
        Chamado chamado5 = new Chamado(TipoChamado.CORRIDA, "05/05/2025", "Estádio Mané Garrincha",
                "Shopping ParkShopping", "12:00", 1000, veiculo2, motorista1, cliente1);
        chamados.add(chamado5);

        //Alteração do chamado5
        chamado5.setMotorista(motorista3);

        //Viagem - não finalizada
        Chamado chamado6 = new Chamado(TipoChamado.VIAGEM, "05/05/2025", "Cruzeiro", "Planaltina",
                "11:00", 1270, veiculo3, motorista2, cliente3);
        chamados.add(chamado6);

        //Finalizando o chamado6
        chamado6.finalizarChamado("12:10", 1315);

        for (Chamado chamado : chamados) {
            chamado.mostrarChamado();
            System.out.println();
        }
    }
}
