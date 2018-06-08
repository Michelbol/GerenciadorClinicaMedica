/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinicamedica.prontuario;

import clinicamedica.pessoas.Paciente;
import clinicamedica.pessoas.Usuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author miche
 */
public class Prontuario {
    private Paciente paciente;
    private Usuario medico;
    private String sintomas;
    private String diagnostico;
    private String prescricao;
    private Date data;

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
    public Usuario getMedico() {
        return medico;
    }

    public void setMedico(Usuario medico) {
        this.medico = medico;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getPrescricao() {
        return prescricao;
    }

    public void setPrescricao(String prescricao) {
        this.prescricao = prescricao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    
    public Prontuario() {
        
    }

    public static Prontuario menuCadastrarProntuario(String acao, Prontuario prontuario,List<Paciente> li_paciente, Usuario usuarioLogado){
        boolean sair = false;
        int opcao = 0;

        while (!sair) {
            try {
                System.out.println("=====================================");
                System.out.println("Estamos em " + acao + " o Prontuario, preencha as informações abaixo e após isso escolha a opção '05 - Salavar' para gravarmos o Prontuario");
                
                System.out.println("01 - Paciente");
                System.out.println("02 - Sintomas");
                System.out.println("03 - Diagnostico");
                System.out.println("04 - Prescrição");
                System.out.println("05 - Data");
                System.out.println("06 - Salvar Prontuario");
                System.out.println("07 - Cancelar");
                Scanner lerOpcao = new Scanner(System.in);
                opcao = lerOpcao.nextInt();
                prontuario = menuSalvarAtributo(opcao, prontuario, li_paciente);
                if (opcao == 7) {
                     return null;
                }
                if (opcao == 6) {
                    if ("Cadastrar".equals(acao)) prontuario.setMedico(usuarioLogado);
                    return prontuario;
                }
            } catch (IndexOutOfBoundsException | InputMismatchException e) {
                System.out.println("========================================================");
                System.out.println("Você não digitou um das opções acima!");
                System.out.println("========================================================");
            } catch (Exception e) {
                System.out.println("Erro não esperado: " + e);
                return null;
            }
        }
        return null;
    }
    
    public static void alterarProntuario(List<Prontuario> li_prontuario, List<Paciente> li_paciente,Usuario usuarioLogado){
        boolean sair = false;
        String opcao = "";
        while (!sair) {
            try {
                System.out.println("=====================================");
                System.out.println("Estamos em 'Alterar Prontuario', digite o número do prontuario que você deseja alterar");
                System.out.println("Ou digite 'Sair' para sair");
                int i = 0;
                for (Prontuario prontuario : li_prontuario) {
                    System.out.println(i+1 + " - " + prontuario.toString());
                    i++;
                }
                Scanner lerOpcao = new Scanner(System.in);
                opcao = lerOpcao.nextLine();
                if (opcao.toLowerCase().equals("sair")) {
                    sair = true;
                } else {
                    menuCadastrarProntuario("Alterar",li_prontuario.get(Integer.parseInt(opcao)-1),li_paciente,usuarioLogado);
                }
            } catch (IndexOutOfBoundsException | InputMismatchException | NumberFormatException e) {
                System.out.println("========================================================");
                System.out.println("Você não digitou um das opções acima!");
                System.out.println("========================================================");
            }
        }
    }
    
    public static Prontuario menuSalvarAtributo(int i, Prontuario prontuario, List<Paciente> li_paciente) {
            int j = 0;
            Scanner lerOpcao = new Scanner(System.in);
            switch (i) {
                case 1:
                    System.out.println("========================================================");
                    System.out.println("Digite o número de um Paciente: ");
                    for (Paciente paciente : li_paciente) {
                        System.out.println("Numero: " + j + " - Paciente: " + paciente.getNome());
                        j++;
                    }
                    System.out.println("========================================================");
                    prontuario.setPaciente(li_paciente.get(lerOpcao.nextInt()));
                    break;
                case 2:
                    System.out.println("========================================================");
                    System.out.println("Digite os Sintomas do Paciente:");
                    System.out.println("========================================================");
                    prontuario.setSintomas(lerOpcao.nextLine());
                    break;
                case 3:
                    System.out.println("========================================================");
                    System.out.println("Digite o Diagnostico do Paciente:");
                    System.out.println("========================================================");
                    prontuario.setDiagnostico(lerOpcao.nextLine());
                    break;
                case 4:
                    System.out.println("========================================================");
                    System.out.println("Digite a Prescrição do Paciente:");
                    System.out.println("========================================================");
                    prontuario.setPrescricao(lerOpcao.nextLine());
                    break;
                case 5:
                    System.out.println("========================================================");
                    System.out.println("Digite a Data da Consulta:");
                    System.out.println("========================================================");
                    String data = lerOpcao.next();
                    prontuario.setData(stringToDate(data));                    
                    break;
            }
            System.out.println(prontuario.toString());
            return prontuario;
        }

    public static void removerProntuario(List<Prontuario> li){
        boolean sair = false;
        String opcao = "";
        while (!sair) {
            try {
                System.out.println("=====================================");
                System.out.println("Estamos em 'Remover Prontuario', digite o número do prontuario que você deseja remover");
                System.out.println("Ou digite 'Sair' para sair");
                int i = 0;
                for (Prontuario prontuario : li) {
                    System.out.println("Numero: " + (i+1) + " - Paciente: " + prontuario.toString());
                    i++;
                }
                Scanner lerOpcao = new Scanner(System.in);
                opcao = lerOpcao.nextLine();
                if (opcao.toLowerCase().equals("sair")) {
                    sair = true;
                } else {
                    li.remove(Integer.parseInt(opcao)-1); 
                }
            } catch (IndexOutOfBoundsException | InputMismatchException | NumberFormatException e) {
                System.out.println("========================================================");
                System.out.println("Você não digitou um das opções acima!");
                System.out.println("========================================================");
            }
        }
    }
    
    public static void menuRelatorioProntuario(List<Prontuario> lista_prontuario){
        boolean sair = false;
        int opcao = 0;
        while (!sair) {
            try {
                Scanner lerOpcao = new Scanner(System.in);
                System.out.println("Qual relatório você deseja gerar: \n");
                System.out.println("01 - Receita");
                System.out.println("02 - Atestado");
                System.out.println("03 - Declaração de Acompanhamento");
                System.out.println("04 - Clientes atendidos no mês");
                System.out.println("05 - Voltar para Menu do Médico");
                opcao = lerOpcao.nextInt();
                if (opcao == 5) {
                    sair = true;
                    break;
                }
                if (opcao > 0 && opcao <= 5) {
                    switch (opcao) {
                        case 1:
                            Prontuario.menuEscolherProntuarioRelatorio(lista_prontuario,"Receita");
                            break;
                        case 2:
                            Prontuario.menuEscolherProntuarioRelatorio(lista_prontuario,"Atestado");
                            break;
                        case 3:
                            Prontuario.menuEscolherProntuarioRelatorio(lista_prontuario,"Acompanhamento");                              
                            break;
                        case 4:
                            Prontuario.gerarRelatorioAtendidosMes(lista_prontuario);                              
                            break;
                    }
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (IndexOutOfBoundsException | InputMismatchException e) {
                System.out.println("========================================================");
                System.out.println("Você não digitou um das opções!");
                System.out.println("========================================================");
            } catch (Exception e) {
                System.out.println("Erro não esperado: " + e);
            }
        }
    }
    
    public static void menuEscolherProntuarioRelatorio(List<Prontuario> lista_prontuario, String tipo){
        boolean sair = false;
        String tempo = "";
        String opcao = "";
        while (!sair) {
            try {
                System.out.println("=====================================");
                System.out.println("Estamos em 'Gerar " + tipo + "', digite o número do prontuario que você deseja gerar " + tipo);
                System.out.println("Ou digite 'Sair' para sair");
                int i = 0;
                for (Prontuario prontuario : lista_prontuario) {
                    System.out.println(i+1 + " - " + prontuario.toString());
                    i++;
                }
                Scanner lerOpcao = new Scanner(System.in);
                opcao = lerOpcao.nextLine();
                if (opcao.toLowerCase().equals("sair")) {
                    sair = true;
                } else {
                    if ("Atestado".equals(tipo)){
                        System.out.println("========================================================");
                        System.out.println("Digite o tempo do atestado com a unidade de medida:");
                        System.out.println("========================================================");
                        tempo = lerOpcao.nextLine();
                    }
                    gerarRelatorio(lista_prontuario.get(Integer.parseInt(opcao)-1),tipo,tempo);
                }
            } catch (IndexOutOfBoundsException | InputMismatchException | NumberFormatException e) {
                System.out.println("========================================================");
                System.out.println("Você não digitou um das opções acima!");
                System.out.println("========================================================");
            }
        }
    }
    
    public static void gerarRelatorio (Prontuario prontuario,String tipo, String tempo){
        if ("Receita".equals(tipo)){
            System.out.println("========================================================");
            System.out.println("======================= Receita ========================");
            System.out.println("========================================================");
            System.out.println("Paciente.........: " + prontuario.getPaciente().getNome());
            System.out.println("Prescrição Medica: " + prontuario.getPrescricao());
            System.out.println("Medico...........: " + prontuario.getMedico().getNome());
            System.out.println("========================================================");    
        }
        if ("Atestado".equals(tipo)){
            System.out.println("========================================================");
            System.out.println("======================= Atestado ========================");
            System.out.println("========================================================");
            System.out.println("O paciente " + prontuario.getPaciente().getNome() + " estará incapacitado durante " + (tempo.equals("")?"tempo indeterminado":tempo) + " por causa do diagnostico " + prontuario.getDiagnostico());
            System.out.println("Assinatura Médico: " + prontuario.getMedico().getNome());
            System.out.println("========================================================");    
        }
        if ("Acompanhamento".equals(tipo)){
            System.out.println("========================================================");
            System.out.println("============= Declaração de Acompanhamento =============");
            System.out.println("========================================================");
            System.out.println("O paciente " + prontuario.getPaciente().getNome() + " está sobre acompanhamento médico do diagnostico " + prontuario.getDiagnostico() + " pelo médico " + prontuario.getMedico().getNome());
            System.out.println("========================================================");    
        }
    }
    
    public static void gerarRelatorioAtendidosMes(List<Prontuario> lista_prontuario){
        List<Paciente> lista_paciente = new ArrayList();
        Date dataAtual = new Date(System.currentTimeMillis());
        int mesUm = dataAtual.getMonth();
        System.out.println("========================================================");
        System.out.println("============== Clientes Atendidos no Mês ===============");
        System.out.println("========================================================");
        for (Prontuario prontuario : lista_prontuario) {
            if (mesUm == (prontuario.getData().getMonth() ) &&
                !lista_paciente.contains(prontuario.getPaciente())){
                lista_paciente.add(prontuario.getPaciente());
                System.out.println(prontuario.getPaciente().getNome());
            }
        }
        System.out.println("========================================================");
    }

    @Override
    public String toString() {
        return "Prontuario{" + "Paciente=" + paciente + ", Medico=" + medico + ", sintomas=" + sintomas + ", diagnostico=" + diagnostico + ", prescricao=" + prescricao + '}';
    }
    
    public static Date stringToDate(String data) {
        String[] g = data.split("/");
        int dia = Integer.parseInt(g[0]);
        int mes = Integer.parseInt(g[1]) - 1;
        int ano = Integer.parseInt(g[2]);
        if (ano > 99) {
            ano = ano - 1900;
        }
        if (ano < 50) {
            ano = ano + 2000;
        }
        Date dt = new Date(ano, mes, dia);
        System.out.println(dt.toString());
        return dt;
    }
    
}
