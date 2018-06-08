/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinicamedica.consulta;

import clinicamedica.pessoas.Paciente;
import clinicamedica.pessoas.TipoUsuario;
import clinicamedica.pessoas.Usuario;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author miche
 */
public class Consulta {
    private Date dataHora;
    private Usuario medico;
    private Paciente paciente;
    private TipoConsulta tipo;

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public Usuario getMedico() {
        return medico;
    }

    public void setMedico(Usuario medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public TipoConsulta getTipo() {
        return tipo;
    }

    public void setTipo(TipoConsulta tipo) {
        this.tipo = tipo;
    }

    public Consulta(Date dataHora, Usuario medico, Paciente paciente, TipoConsulta tipo) {
        this.dataHora = dataHora;
        this.medico = medico;
        this.paciente = paciente;
        this.tipo = tipo;
    }

    public Consulta() {
    }

    @Override
    public String toString() {
        return "Consulta{" + "dataHora=" + dataHora + ", medico=" + medico + ", paciente=" + paciente + ", tipo=" + tipo + '}';
    }
    
    public void menuConsulta(List<Consulta> lista_consultas, List<Usuario> lista_usuarios, List<Paciente> lista_pacientes){
        boolean sair = false;
            int opcao = 0;
            while (!sair) {
                try {
                    System.out.println("=====================================");
                    System.out.println("Estamos em 'Cadastro de Consultas', o que deseja fazer?");
                    System.out.println("01 - Marcar Consulta");
                    System.out.println("02 - Alterar Consulta");
                    System.out.println("03 - Desmarcar Consulta");
                    System.out.println("04 - Voltar para Menu Medico");
                    Scanner lerOpcao = new Scanner(System.in);
                    opcao = lerOpcao.nextInt();
                    if (opcao == 4) {
                        sair = true;
                        break;
                    }
                    if (opcao < 4 && opcao > 0) {
                        if (opcao == 1) {
                            lista_consultas.add(menuMarcarConsulta(lista_usuarios, lista_pacientes));
                        } else if (opcao == 2) {
                            alterarConsulta(lista_consultas, lista_usuarios, lista_pacientes);
                        } else if (opcao == 3) {
                            removerConsulta(lista_consultas);
                        }
                    } else {
                        throw new IndexOutOfBoundsException();
                    }
                } catch (IndexOutOfBoundsException | InputMismatchException e) {
                    System.out.println("========================================================");
                    System.out.println("Você não digitou um das opções acima!");
                    System.out.println("========================================================");
                } catch (Exception e) {
                    System.out.println("Erro não esperado: " + e);
                }
            }
    }
    
    public Consulta menuMarcarConsulta(List<Usuario> lista_usuarios, List<Paciente> lista_pacientes){
        boolean sair = false;
            int opcao = 0;
            Consulta c = new Consulta();
            while (!sair) {
                try {
                    System.out.println("=====================================");
                    System.out.println("Estamos em Marcar Consulta, preencha as informações abaixo e após isso escolha a opção '04 - Salvar' para salvarmos a Consulta");
                    System.out.println("01 - Data/Hora");
                    System.out.println("02 - Médico");
                    System.out.println("03 - Paciente");
                    System.out.println("04 - Tempo Duração");
                    System.out.println("05 - Salvar");
                    System.out.println("06 - Cancelar");
                    Scanner lerOpcao = new Scanner(System.in);
                        opcao = lerOpcao.nextInt();
                        if (opcao == 6) {
                            return null;
                        }
                        c = menuSalvarAtributo(opcao, c, lista_usuarios, lista_pacientes);
                        System.out.println("p:" + c.toString());
                        if (opcao == 5) {
                            return c;
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
    
    public void alterarConsulta(List<Consulta> lista_consultas, List<Usuario> lista_usuarios, List<Paciente> lista_pacientes){
        boolean sair = false;
        String opcao = "";
        while (!sair) {
            try {
                System.out.println("=====================================");
                System.out.println("Estamos em 'Alterar Consulta Médica', digite o número da consulta que você deseja alterar");
                System.out.println("Ou digite 'Sair' para sair");
                int i = 0;
                for (Consulta c : lista_consultas) {
                    System.out.println("Numero: " + i + " Horário Consulta: " + c.getDataHora()+" Médico: "+ c.getMedico().getNome()+" Paciente: "+c.getPaciente().getNome());
                    i += 1;
                }
                Scanner lerOpcao = new Scanner(System.in);
                opcao = lerOpcao.nextLine();
                if (opcao.equals("Sair")) {
                    sair = true;
                } else {
                    menuAlteracoesConsulta(lista_consultas.get(Integer.parseInt(opcao)), lista_usuarios, lista_pacientes);
                }
            } catch (IndexOutOfBoundsException | InputMismatchException | NumberFormatException e) {
                System.out.println("========================================================");
                System.out.println("Você não digitou um das opções acima!");
                System.out.println("========================================================");
            }
        }
    }
    
    public Consulta menuAlteracoesConsulta(Consulta c, List<Usuario> lista_usuarios, List<Paciente> lista_pacientes){
        boolean sair = false;
            int opcao = 0;            
            while (!sair) {
                try {
                    System.out.println("=====================================");
                    System.out.println("Estamos em Alterações de Consultas Médicas, altere as informações que deseja e após isso escolha a opção '05 - Salvar' para gravarmos o Consulta");
                    System.out.println("01 - Data/Hora");
                    System.out.println("02 - Medico");
                    System.out.println("03 - Paciente");
                    System.out.println("04 - Tipo");
                    System.out.println("05 - Salvar");
                    System.out.println("06 - Cancelar");
                    Scanner lerOpcao = new Scanner(System.in);
                    opcao = lerOpcao.nextInt();
                    Consulta con = menuAtualizarAtributo(opcao, c, lista_usuarios, lista_pacientes);
                    if (opcao == 06) {
                        return null;
                    }
                    if (opcao == 05) {
                        return con;
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
    
    public Consulta menuAtualizarAtributo(int i, Consulta c, List<Usuario> lista_usuarios, List<Paciente> lista_pacientes){
        Scanner lerOpcao = new Scanner(System.in);
        switch (i) {
            case 1:
                    System.out.println("========================================================");
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                    System.out.println("A data anterior é: " + sdf.format(c.getDataHora()));
                    System.out.println("Digite a Data e Hora da Consulta: dd/mm/yyyy HH:mm");
                    System.out.println("========================================================");
                    String data = lerOpcao.nextLine();
                    c.setDataHora(stringToDateTime(data));
                    break;
                case 2:
                    System.out.println("========================================================");
                    System.out.println("O médico anterior: " + c.getMedico());
                    System.out.println("Digite o numero do médico para seleciona-lo");
                    int aux = 0;
                    for(Usuario u : lista_usuarios){
                        if(u.getTipo() == TipoUsuario.Medico){ 
                            System.out.println("Numero: "+aux+" Nome: "+u.getNome());
                        }
                        aux++;
                    }
                    System.out.println("========================================================");
                    c.setMedico(lista_usuarios.get(lerOpcao.nextInt()));
                    break;
                case 3:
                    System.out.println("========================================================");
                    System.out.println("O paciente anterior: " + c.getPaciente());
                    System.out.println("Digite o numero do médico para seleciona-lo");
                    int cont = 0;
                    for(Paciente p : lista_pacientes){
                            System.out.println("Numero: "+cont+" Nome: "+p.getNome());
                            cont++;
                    }
                    System.out.println("========================================================");
                    c.setPaciente(lista_pacientes.get(lerOpcao.nextInt()));
                    break;
                case 4:
                    System.out.println("========================================================");
                    System.out.println("o tipo anterior da consulta é: " + c.getTipo());
                    System.out.println("Tipo da Consulta digite 1 - Normal ou 2 - Retorno");
                    System.out.println("========================================================");
                    int tipoConsulta = lerOpcao.nextInt();
                    c.setTipo((tipoConsulta == 1) ? TipoConsulta.Normal : TipoConsulta.Retorno);
                    break;
        }
        return c;
    }
    
    public void removerConsulta(List<Consulta> lista_consultas){
        boolean sair = false;
        String opcao = "";
        while (!sair) {
            try {
                System.out.println("=====================================");
                System.out.println("Estamos em 'Alterar Consulta Médica', digite o número da consulta que você deseja alterar");
                System.out.println("Ou digite 'Sair' para sair");
                int i = 0;
                for (Consulta c : lista_consultas) {
                    System.out.println("Numero: " + i + " Horário Consulta: " + c.getDataHora()+" Médico: "+ c.getMedico().getNome()+" Paciente: "+c.getPaciente().getNome());
                    i += 1;
                }
                Scanner lerOpcao = new Scanner(System.in);
                opcao = lerOpcao.nextLine();
                if (opcao.equals("Sair")) {
                    sair = true;
                } else {
                    lista_consultas.remove(Integer.parseInt(opcao));
                }
            } catch (IndexOutOfBoundsException | InputMismatchException | NumberFormatException e) {
                System.out.println("========================================================");
                System.out.println("Você não digitou um das opções acima!");
                System.out.println("========================================================");
            }
        }
    }
    
    public Consulta menuSalvarAtributo(int i, Consulta c, List<Usuario> lista_usuarios, List<Paciente> lista_pacientes) {
            Scanner lerOpcao = new Scanner(System.in);
            switch (i) {
                case 1:
                    System.out.println("========================================================");
                    System.out.println("Digite a Data e Hora da Consulta: dd/mm/yyyy hh:mm");
                    System.out.println("========================================================");
                    String data = lerOpcao.nextLine();
                    c.setDataHora(stringToDateTime(data));
                    break;
                case 2:
                    System.out.println("========================================================");
                    System.out.println("Escolha o médico:");
                    System.out.println("Digite o numero do médico para seleciona-lo");
                    int aux = 0;
                    for(Usuario u : lista_usuarios){
                        if(u.getTipo() == TipoUsuario.Medico){
                            System.out.println("Numero: "+aux+" Nome: "+u.getNome());
                        }
                        aux +=1;
                    }
                    System.out.println("========================================================");
                    c.setMedico(lista_usuarios.get(lerOpcao.nextInt()));
                    break;
                case 3:
                    System.out.println("========================================================");
                    System.out.println("Escolha o Paciente:");
                    System.out.println("Digite o numero do paciente para seleciona-lo");
                    int aux1 = 0;
                    for(Paciente p : lista_pacientes){
                        System.out.println("Numero: "+aux1+" Nome: "+p.getNome());
                        aux1 +=1;
                    }
                    System.out.println("========================================================");
                    c.setPaciente(lista_pacientes.get(lerOpcao.nextInt()));
                    break;
                case 4:
                    System.out.println("========================================================");
                    System.out.println("Tipo da Consulta digite 1 - Normal ou 2 - Retorno");
                    System.out.println("========================================================");
                    int tipoConsulta = lerOpcao.nextInt();
                    c.setTipo((tipoConsulta == 1) ? TipoConsulta.Normal : TipoConsulta.Retorno);
                    break;
            }
            System.out.println(c.toString());
            return c;
        }
    
    public Date stringToDateTime(String data) {
        System.out.println("Data: "+data);
        String[] dateTime = data.split(" ");
        System.out.println("DataTime: "+dateTime);
        String[] date = dateTime[0].split("/");
        System.out.println("date: "+date);
        String[] time = dateTime[1].split(":");
        System.out.println("Time: "+time);
        int dia = Integer.parseInt(date[0]);
        int mes = Integer.parseInt(date[1]) - 1;
        int ano = Integer.parseInt(date[2]);
        int hora = Integer.parseInt(time[0]);
        int minuto = Integer.parseInt(time[1]);
        if (ano > 99) {
            ano = ano - 1900;
        }
        if (ano < 50) {
            ano = ano + 2000;
        }
        Date dt = new Date(ano, mes, dia, hora, minuto);
        System.out.println(dt.toString());
        return dt;
    }
}
