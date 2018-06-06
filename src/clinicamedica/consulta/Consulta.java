/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinicamedica.consulta;

import clinicamedica.pessoas.Paciente;
import clinicamedica.pessoas.TipoUsuario;
import clinicamedica.pessoas.Usuario;
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
    
    
    public void menuConsulta(List<Consulta> lista_consultas, List<Usuario> lista_usuarios){
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
                            lista_consultas.add(menuMarcarConsulta(lista_usuarios));
                        } else if (opcao == 2) {
                            alterarConsulta(lista_consultas, lista_usuarios);
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
    
    public Consulta menuMarcarConsulta(List<Usuario> lista_usuarios){
        boolean sair = false;
            int opcao = 0;
            Consulta c = new Consulta();
            while (!sair) {
                try {
                    System.out.println("=====================================");
                    System.out.println("Estamos em Marcar Consulta, preencha as informações abaixo e após isso escolha a opção '04 - Salvar' para salvarmos a Consulta");
                    System.out.println("01 - Data/Hora");
                    System.out.println("02 - Médico");
                    System.out.println("03 - Tempo Duração");
                    System.out.println("04 - Salvar");
                    System.out.println("05 - Cancelar");
                    Scanner lerOpcao = new Scanner(System.in);
                        opcao = lerOpcao.nextInt();
                        if (opcao == 5) {
                            return null;
                        }
                        c = menuSalvarAtributo(opcao, c, lista_usuarios);
                        System.out.println("p:" + c.toString());
                        if (opcao == 4) {
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
    
    public void alterarConsulta(List<Consulta> lista_consultas, List<Usuario> lista_usuarios){
        
    }
    
    public void removerConsulta(List<Consulta> lista_consultas){
        
    }
    
    public Consulta menuSalvarAtributo(int i, Consulta c, List<Usuario> lista_usuarios) {
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
                    for(Usuario u : lista_usuarios){
                        if(u.getTipo() == TipoUsuario.Medico){
                            System.out.println("Numero: "+u.getId()+" Nome: "+u.getNome());
                        }
                    }
                    System.out.println("========================================================");
                    c.setMedico(lista_usuarios.get(lerOpcao.nextInt()));
                    break;
                case 3:
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
