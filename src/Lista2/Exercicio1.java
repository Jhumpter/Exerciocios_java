package Lista2;

import java.util.Scanner;
/*Emergência

No Brasil, serviços de emergência como SAMU (Serviço de Atendimento Móvel de Urgência – 192), Corpo de Bombeiros
(193) e Polícia Militar (190) atendem chamados da população em situações críticas. Esses serviços são fundamentais para
 garantir respostas rápidas a incidentes que envolvem riscos à vida, à segurança pública ou ao patrimônio.
Crie uma classe em Java chamada Emergencia que represente os dados de uma ocorrência registrada em um sistema de
atendimento a emergências públicas. Considere a orientação a objetos para modelar os atributos relevantes de uma emergência,
permitindo a entrada de dados, o armazenamento desses dados e a exibição das informações da ocorrência.

A classe contém apenas atributos públicos (nome do chamador - String, telefone do chamador - String, local da emergência
 - String, data e hora do relato  - String, natureza da emergência - String, tipo de resposta - String, status da resposta
 - String, chamada de celular - String, coordenadas GPS - boolean), sem necessidade de encapsulamento ou construtor.
 A classe deve conter um metodo mostrarEmergencias() que imprime todos os dados informados para o registro da emergência.
 Os dados de entrada devem ser obtidos diretamente no código da classe principal, simulando um registro feito por um
 atendente de emergência, sendo possível registrar várias emergências simultâneas.

Entrada:
A primeira entrada corresponde a um número inteiro indicando a quantidade de emergências que serão registradas.
As próximas entradas são as informações de entrada para cada emergência:

Nome do chamador - String;
Telefone do chamador - String;
Local da emergência - String;
Data e hora do relato (dd/MM/yyyy HH:mm) - String;
Natureza da emergência - String;
Tipo de resposta (ambulância, bombeiros, polícia, etc.) - String;
Status da resposta (pendente, a caminho, concluído) - String;
A chamada foi feita de um celular? (sim/não) - String;
Informe as coordenadas GPS - String (apenas para a resposta "sim" na entrada anterior).

Saída:
Para cada emergência registrada, o metodo mostrarEmergencias() deverá exibir todos os dados da ocorrência um por linha.

Objetivos de estudo:

Classes e objetos
Array de objetos*/
class Emergencia{
    private String nome;
    private String telefone;
    private String localEmergencia;
    private String dataHora;
    private String natureza;
    private String tipoResposta;
    private String statusResposta;
    private String porCelular;
    private String coordenadas;
    public Emergencia(String nome,String telefone,String localEmergencia,String dataHora,String natureza,String tipoResposta,String statusResposta,String porCelular,String coordenadas){
        this.nome = nome;
        this.telefone = telefone;
        this.localEmergencia = localEmergencia;
        this.dataHora = dataHora;
        this.natureza = natureza;
        this.tipoResposta = tipoResposta;
        this.statusResposta = statusResposta;
        this.porCelular = porCelular;
        this.coordenadas = coordenadas;
    }
    public Emergencia(String nome,String telefone,String localEmergencia,String dataHora,String natureza,String tipoResposta,String statusResposta,String porCelular){
        this.nome = nome;
        this.telefone = telefone;
        this.localEmergencia = localEmergencia;
        this.dataHora = dataHora;
        this.natureza = natureza;
        this.tipoResposta = tipoResposta;
        this.statusResposta = statusResposta;
        this.porCelular = porCelular;
    }
    public void mostrarEmergencias(){
        System.out.println("Nome do Chamador: " + this.nome);
        System.out.println("Telefone: " + this.telefone);
        System.out.println("Local da Emergência: " + this.localEmergencia);
        System.out.println("Data/Hora do Relato: " + this.dataHora);
        System.out.println("Natureza da Emergência: " + this.natureza);
        System.out.println("Tipo de Resposta: " + this.tipoResposta);
        System.out.println("Status da Resposta: " + this.statusResposta);
        System.out.println("Chamada via celular: " + this.porCelular);
        if(this.porCelular.equalsIgnoreCase("sim"))
            System.out.println("Coordenadas GPS: " + this.coordenadas);
        System.out.println("");
    }
}

public class Exercicio1{  //use modificador de acesso (public) apenas para a classe principal

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Emergencia[] emergencias = new Emergencia[n];
        scanner.nextLine();
        for(int i =0;i<n;i++){

            String nome = scanner.nextLine();
            String telefone = scanner.nextLine();
            String localEmergencia = scanner.nextLine();
            String dataHora = scanner.nextLine();
            String natureza = scanner.nextLine();
            String tipoResposta = scanner.nextLine();
            String statusResposta = scanner.nextLine();
            String porCelular = scanner.nextLine();
            if(porCelular.equalsIgnoreCase("sim")){
                porCelular = "Sim";
                String coordenadas = scanner.nextLine();
                emergencias[i] = new Emergencia(nome,telefone,localEmergencia,dataHora,natureza,tipoResposta,statusResposta,porCelular,coordenadas);
            }else{
                porCelular = "Não";
                emergencias[i] = new Emergencia(nome,telefone,localEmergencia,dataHora,natureza,tipoResposta,statusResposta,porCelular);
            }

        }
        for(int i =0;i<n;i++){
            int j = i;
            j++;
            System.out.println("Emergência #" + j);
            System.out.println("");
            System.out.println("--- Informações da Emergência ---");
            System.out.println("");
            emergencias[i].mostrarEmergencias();
        }
    }

}
