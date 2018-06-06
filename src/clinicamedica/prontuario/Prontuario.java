/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinicamedica.prontuario;

import clinicamedica.pessoas.Paciente;
import clinicamedica.pessoas.Usuario;
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

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
    public Paciente getMedico() {
        return paciente;
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
    
    public Prontuario() {
        
    }
    
    public Prontuario(Paciente paciente, String sintomas, String diagnostico, String prescricao) {
        this.paciente = paciente;
        this.sintomas = sintomas;
        this.diagnostico = diagnostico;
        this.prescricao = prescricao;
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
                System.out.println("05 - Salvar Prontuario");
                System.out.println("06 - Cancelar");
                Scanner lerOpcao = new Scanner(System.in);
                opcao = lerOpcao.nextInt();
                prontuario = menuSalvarAtributo(opcao, prontuario, li_paciente);
                if (opcao == 6) {
                     return null;
                }
                if (opcao == 5) {
                    prontuario.setMedico(usuarioLogado);
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

    @Override
    public String toString() {
        return "Prontuario{" + "Paciente=" + paciente + ", Medico=" + medico + ", sintomas=" + sintomas + ", diagnostico=" + diagnostico + ", prescricao=" + prescricao + '}';
    }
    
}
