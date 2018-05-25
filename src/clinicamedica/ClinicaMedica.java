/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinicamedica;

import clinicamedica.consulta.Consulta;
import clinicamedica.pessoas.Paciente;
import clinicamedica.pessoas.Pessoa;
import clinicamedica.pessoas.TipoConvenio;
import clinicamedica.pessoas.TipoUsuario;
import clinicamedica.pessoas.Usuario;
import clinicamedica.pessoas.atributos.compostos.Cidade;
import clinicamedica.pessoas.atributos.compostos.Endereco;
import clinicamedica.pessoas.atributos.compostos.Telefone;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author miche
 */
public class ClinicaMedica {

    static List<Paciente> lista_pacientes = new ArrayList();
    static List<Consulta> lista_consultas = new ArrayList();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        logar();
    }

    public static void logar() {
        Usuario usuarioLogado = new Usuario();
        List<Usuario> usuarios = usuarioLogado.povoarUsuarios();
        int opcao;
        while (usuarioLogado.getId() <= 0) {
            try {
                Scanner tipoUsuario = new Scanner(System.in);
                int i = 0;
                for (Usuario u : usuarios) {
                    System.out.println(i + " - " + u.getNome() + "\n");
                    i += 1;
                }
                System.out.println("Digite o numero do usuário abaixo: \n");
                opcao = tipoUsuario.nextInt();
                usuarioLogado = usuarios.get(opcao);
                System.out.println("Usuario Logado: " + usuarioLogado.toString());
            } catch (IndexOutOfBoundsException | InputMismatchException e) {
                System.out.println("========================================================");
                System.out.println("Você não digitou um dos usuários acima!");
                System.out.println("========================================================");
            } catch (Exception e) {
                System.out.println("Erro não esperado: " + e);
            }
        }
        menu(usuarioLogado);
    }

    public static void menuSecretaria(Usuario u) {
        boolean sair = false;
        int opcao = 0;
        while (!sair) {
            try {
                Scanner lerOpcao = new Scanner(System.in);
                System.out.println("O que deseja fazer?\n");
                System.out.println("01 - Cadastro de Pacientes");
                System.out.println("02 - Cadastro de Consultas");
                System.out.println("03 - Relatórios de Consultas");
                System.out.println("04 - Sair do Sistema");
                opcao = lerOpcao.nextInt();
                if (opcao == 4) {
                    sair = true;
                    break;
                }
                if (opcao > 0 && opcao <= 3) {
                    switch (opcao) {
                        case 1:
                            menuPaciente(u);
                            break;
                        case 2:
                            menuConsulta();
                            break;
                        case 3:
                            relatoriosConsultas();
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

    public static void menuMedico() {

    }

    public static void menu(Usuario u) {
        if (u.getTipo() == TipoUsuario.Medico) {
            menuMedico();
        } else {
            menuSecretaria(u);
        }
    }

    public static void menuPaciente(Usuario u) {
        boolean sair = false;
        int opcao = 0;
        while (!sair) {
            try {
                System.out.println("=====================================");
                System.out.println("Estamos em 'Cadastro de Pacientes', o que deseja fazer?");
                System.out.println("01 - Cadastrar Paciente");
                System.out.println("02 - Alterar Paciente");
                System.out.println("03 - Remover Paciente");
                System.out.println("04 - Voltar para Menu Secretária");
                Scanner lerOpcao = new Scanner(System.in);
                opcao = lerOpcao.nextInt();
                if (opcao == 4) {
                    sair = true;
                    break;
                }
                if (opcao < 4 && opcao > 0) {
                    if (opcao == 1) {
                        cadastrarPaciente(u);
                    } else if (opcao == 2) {
                        alterarPaciente(u);
                    } else if (opcao == 3) {
                        removerPaciente();
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

    public static boolean cadastrarPaciente(Usuario u) {
        boolean sair = false;
        int opcao = 0;
        Paciente p = new Paciente();
        while (!sair) {
            try {
                System.out.println("=====================================");
                System.out.println("Estamos em Cadastrar Paciente, preencha as informações abaixo e após isso escolha a opção '18 - Salavar' para gravarmos o Paciente");
                System.out.println("01 - Nome");
                System.out.println("02 - Sobrenome");
                System.out.println("03 - Cpf");
                System.out.println("04 - Rg");
                System.out.println("05 - Data de Nascimento");
                System.out.println("06 - Endereco");
                System.out.println("07 - Residencial");
                System.out.println("08 - Celular");
                System.out.println("09 - Email");
                System.out.println("10 - Tipoconvenio");
                if (u.getTipo() == TipoUsuario.Medico) {
                    System.out.println("11 - é Fumante?");
                    System.out.println("12 - é Alcolico?");
                    System.out.println("13 - Colesterol");
                    System.out.println("14 - é Diabetico?");
                    System.out.println("15 - Doencas Cardiacas");
                    System.out.println("16 - Cirurgias");
                    System.out.println("17 - Alergias");
                }
                System.out.println("18 - Salvar");
                System.out.println("19 - Cancelar");
                Scanner lerOpcao = new Scanner(System.in);
                opcao = lerOpcao.nextInt();
                p = salvarAtributo(opcao, p);
                System.out.println("p:" + p.toString());
                if (opcao == 19) {
                    return false;
                }
                if (opcao == 18) {
                    lista_pacientes.add(p);
                    sair = true;
                }
            } catch (IndexOutOfBoundsException | InputMismatchException e) {
                System.out.println("========================================================");
                System.out.println("Você não digitou um das opções acima!");
                System.out.println("========================================================");
            } catch (Exception e) {
                System.out.println("Erro não esperado: " + e);
                return false;
            }
        }
        return true;
    }

    public static void menuConsulta() {
        System.out.println("Não implementado");
    }

    public static void relatoriosConsultas() {
        System.out.println("Não implementado");
    }

    public static Paciente salvarAtributo(int i, Paciente p) {
        Scanner lerOpcao = new Scanner(System.in);
        switch (i) {
            case 1:
                System.out.println("========================================================");
                System.out.println("Digite o nome:");
                System.out.println("========================================================");
                p.setNome(lerOpcao.next());
                break;
            case 2:
                System.out.println("========================================================");
                System.out.println("Digite o sobrenome:");
                System.out.println("========================================================");
                p.setSobrenome(lerOpcao.next());
                break;
            case 3:
                System.out.println("========================================================");
                System.out.println("Digite o cpf:");
                System.out.println("========================================================");
                p.setCpf(lerOpcao.next());
                break;
            case 4:
                System.out.println("========================================================");
                System.out.println("Digite o rg:");
                System.out.println("========================================================");
                p.setRg(lerOpcao.next());
                break;
            case 5:
                System.out.println("========================================================");
                System.out.println("Digite a data de nascimento('utilize dd/mm/yyy'):");
                System.out.println("========================================================");
                String data = lerOpcao.next();
                p.setDataNascimento(stringToDate(data));
//                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//                System.out.println(sdf.format(p.getDataNascimento()));
                break;
            case 6:
                Endereco e = new Endereco();
                Cidade c = new Cidade();
                System.out.println("========================================================");
                System.out.println("Digite o logradouro:");
                System.out.println("========================================================");
                e.setLogradouro(lerOpcao.nextLine());
                System.out.println("========================================================");
                System.out.println("Digite o Numero:");
                System.out.println("========================================================");
                e.setNumero(lerOpcao.nextLine());
                System.out.println("========================================================");
                System.out.println("Digite o bairro:");
                System.out.println("========================================================");
                e.setBairro(lerOpcao.nextLine());
                System.out.println("========================================================");
                System.out.println("Digite o estado:");
                System.out.println("========================================================");
                c.setEstado(lerOpcao.nextLine());
                System.out.println("========================================================");
                System.out.println("Digite a cidade:");
                System.out.println("========================================================");
                c.setCidade(lerOpcao.nextLine());
                c.setPais("Brasil");
                e.setCidade(c);
                p.setEndereco(e);
                break;
            case 7:
                System.out.println("========================================================");
                System.out.println("Digite o telefone residencial: Formato: +55 (DD) ####-####");
                System.out.println("========================================================");
                String telefone = lerOpcao.nextLine();
                Telefone t = new Telefone();
                t = t.StringToTelefone(telefone);
                p.setResidencial(t);
                break;
            case 8:
                System.out.println("========================================================");
                System.out.println("Digite o telefone celular: Formato: +55 (DD) ####-####");
                System.out.println("========================================================");
                String celular = lerOpcao.nextLine();
                Telefone tcelular = new Telefone();
                tcelular = tcelular.StringToTelefone(celular);
                p.setCelular(tcelular);
                break;
            case 9:
                System.out.println("========================================================");
                System.out.println("Digite o e-mail:");
                System.out.println("========================================================");
                p.setEmail(lerOpcao.nextLine());
                break;
            case 10:
                System.out.println("========================================================");
                System.out.println("Digite o tipo do convenio: 1 - Particular ou 2 - PlanoDeSaude");
                System.out.println("========================================================");
                int tipoconvenio = lerOpcao.nextInt();
                p.setTipoconvenio((tipoconvenio == 1) ? TipoConvenio.Particular : TipoConvenio.PlanoDeSaude);
                break;
            case 11:
                System.out.println("========================================================");
                System.out.println("É fumante? 1 - Sim ou 2 - Não");
                System.out.println("========================================================");
                int fumante = lerOpcao.nextInt();
                p.setIsFumante(fumante == 1);
                break;
            case 12:
                System.out.println("========================================================");
                System.out.println("Consume Bebidas Alcoolicas? 1 - Sim ou 2 - Não");
                System.out.println("========================================================");
                int alcolatra = lerOpcao.nextInt();
                p.setIsAlcolatra(alcolatra == 1);
                break;
            case 13:
                System.out.println("========================================================");
                System.out.println("Tem colesterol alto? 1 - Sim ou 2 - Não");
                System.out.println("========================================================");
                int colesterol = lerOpcao.nextInt();
                p.setIsAlcolatra(colesterol == 1);
                break;
            case 14:
                System.out.println("========================================================");
                System.out.println("É diabético? 1 - Sim ou 2 - Não");
                System.out.println("========================================================");
                int diabetico = lerOpcao.nextInt();
                p.setIsDiabetico(diabetico == 1);
                break;
            case 15:
                System.out.println("========================================================");
                System.out.println("Se possuir doenças cardiacas descreva, caso contrário digite 'Não possuo'?");
                System.out.println("========================================================");
                p.setDoencasCardiacas(lerOpcao.nextLine());
                break;
            case 16:
                System.out.println("========================================================");
                System.out.println("Se fez cirurgias descreva, caso contrário digite 'Não fiz'?");
                System.out.println("========================================================");
                p.setCirurgias(lerOpcao.nextLine());
                break;
            case 17:
                System.out.println("========================================================");
                System.out.println("Se tem alergias descreva, caso contrário digite 'Não tenho'?");
                System.out.println("========================================================");
                p.setAlergias(lerOpcao.nextLine());
                break;
        }
        System.out.println(p.toString());
        return p;
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

    public static void alterarPaciente(Usuario u) {
        boolean sair = false;
        String opcao = "";
        while (!sair) {
            try {
                System.out.println("=====================================");
                System.out.println("Estamos em 'Alterar Paciente', digite o número do paciente que você deseja alterar");
                System.out.println("Ou digite 'Sair' para sair");
                int i = 0;
                for (Paciente p : lista_pacientes) {
                    System.out.println("Numero: " + i + "Paciente: " + p.getNome());
                    i += 1;
                }
                Scanner lerOpcao = new Scanner(System.in);
                opcao = lerOpcao.nextLine();
                if (opcao.equals("Sair")) {
                    sair = true;
                } else {
                    alteracoesPaciente(Integer.parseInt(opcao), u);
                }
            } catch (IndexOutOfBoundsException | InputMismatchException | NumberFormatException e) {
                System.out.println("========================================================");
                System.out.println("Você não digitou um das opções acima!");
                System.out.println("========================================================");
            }
        }
    }

    private static boolean alteracoesPaciente(int i, Usuario u) {
        boolean sair = false;
        int opcao = 0;
        Paciente p = new Paciente();
        while (!sair) {
            try {
                System.out.println("=====================================");
                System.out.println("Estamos em Alterações de Pacientes, altere as informações que deseja e após isso escolha a opção '18 - Salvar' para gravarmos o Paciente");
                System.out.println("01 - Nome");
                System.out.println("02 - Sobrenome");
                System.out.println("03 - Cpf");
                System.out.println("04 - Rg");
                System.out.println("05 - Data de Nascimento");
                System.out.println("06 - Endereco");
                System.out.println("07 - Residencial");
                System.out.println("08 - Celular");
                System.out.println("09 - Email");
                System.out.println("10 - Tipoconvenio");
                if (u.getTipo() == TipoUsuario.Medico) {
                    System.out.println("11 - é Fumante?");
                    System.out.println("12 - é Alcolico?");
                    System.out.println("13 - Colesterol");
                    System.out.println("14 - é Diabetico?");
                    System.out.println("15 - Doencas Cardiacas");
                    System.out.println("16 - Cirurgias");
                    System.out.println("17 - Alergias");
                }
                System.out.println("18 - Salvar");
                System.out.println("19 - Cancelar");
                Scanner lerOpcao = new Scanner(System.in);
                opcao = lerOpcao.nextInt();
                if (opcao == 19) {
                    return false;
                }
                p = atualizarAtributo(opcao, i);
                if (opcao == 18) {
                    lista_pacientes.remove(i);
                    lista_pacientes.add(p);
                    sair = true;
                }
            } catch (IndexOutOfBoundsException | InputMismatchException e) {
                System.out.println("========================================================");
                System.out.println("Você não digitou um das opções acima!");
                System.out.println("========================================================");
            } catch (Exception e) {
                System.out.println("Erro não esperado: " + e);
                return false;
            }
        }
        return true;
    }

    public static Paciente atualizarAtributo(int i, int indexPac) {
        Paciente p = lista_pacientes.get(indexPac);
        Scanner lerOpcao = new Scanner(System.in);
        switch (i) {
            case 1:
                System.out.println("========================================================");
                System.out.println("O nome anterior era: " + p.getNome());
                System.out.println("Digite o nome:");
                System.out.println("========================================================");
                p.setNome(lerOpcao.next());
                break;
            case 2:
                System.out.println("========================================================");
                System.out.println("O sobrenome anterior era: " + p.getSobrenome());
                System.out.println("Digite o sobrenome:");
                System.out.println("========================================================");
                p.setSobrenome(lerOpcao.next());
                break;
            case 3:
                System.out.println("========================================================");
                System.out.println("O cpf anterior era: " + p.getCpf());
                System.out.println("Digite o cpf:");
                System.out.println("========================================================");
                p.setCpf(lerOpcao.next());
                break;
            case 4:
                System.out.println("========================================================");
                System.out.println("O rg anterior era: " + p.getRg());
                System.out.println("Digite o rg:");
                System.out.println("========================================================");
                p.setRg(lerOpcao.next());
                break;
            case 5:
                System.out.println("========================================================");
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                System.out.println("A data de nascimento anterior era: " + sdf.format(p.getDataNascimento()));
                System.out.println("Digite a data de nascimento('utilize dd/mm/yyy'):");
                System.out.println("========================================================");
                String data = lerOpcao.next();
                p.setDataNascimento(stringToDate(data));
                break;
            case 6:
                Endereco e = p.getEndereco();
                Cidade c = e.getCidade();
                System.out.println("========================================================");
                System.out.println("O logradouro anterior era: " + e.getLogradouro());
                System.out.println("Digite o logradouro e o número:");
                System.out.println("========================================================");
                e.setLogradouro(lerOpcao.nextLine());
                System.out.println("========================================================");
                System.out.println("O numero anterior era: " + e.getNumero());
                System.out.println("Digite o Numero:");
                System.out.println("========================================================");
                e.setNumero(lerOpcao.next());
                System.out.println("========================================================");
                System.out.println("O bairro anterior era: " + e.getBairro());
                System.out.println("Digite o bairro:");
                System.out.println("========================================================");
                e.setBairro(lerOpcao.nextLine());
                System.out.println("========================================================");
                System.out.println("O estado anterior era: " + c.getEstado());
                System.out.println("Digite o estado:");
                System.out.println("========================================================");
                c.setEstado(lerOpcao.nextLine());
                System.out.println("========================================================");
                System.out.println("A cidade anterior era: " + c.getEstado());
                System.out.println("Digite a cidade:");
                System.out.println("========================================================");
                c.setCidade(lerOpcao.nextLine());
                c.setPais("Brasil");
                e.setCidade(c);
                p.setEndereco(e);
                break;
            case 7:
                System.out.println("========================================================");
                System.out.println("O telefone residencial anterior era: " + p.getResidencial());
                System.out.println("Digite o telefone residencial: Formato: ++55 (DD) ####-####");
                System.out.println("========================================================");
                String telefone = lerOpcao.nextLine();
                Telefone t = new Telefone();
                t = t.StringToTelefone(telefone);
                p.setResidencial(t);
                break;
            case 8:
                System.out.println("========================================================");
                System.out.println("O telefone celular anterior era: " + p.getCelular());
                System.out.println("Digite o telefone celular: Formato: ++55 (DD) ####-####");
                System.out.println("========================================================");
                String celular = lerOpcao.nextLine();
                Telefone tcelular = new Telefone();
                tcelular.StringToTelefone(celular);
                p.setCelular(tcelular);
                break;
            case 9:
                System.out.println("========================================================");
                System.out.println("O email anterior era: " + p.getEmail());
                System.out.println("Digite o e-mail:");
                System.out.println("========================================================");
                p.setEmail(lerOpcao.nextLine());
                break;
            case 10:
                System.out.println("========================================================");
                System.out.println("O tipo do convenio anterior era: " + p.getTipoconvenio());
                System.out.println("Digite o tipo do convenio: 1 - Particular ou 2 - PlanoDeSaude");
                System.out.println("========================================================");
                int tipoconvenio = lerOpcao.nextInt();
                p.setTipoconvenio((tipoconvenio == 1) ? TipoConvenio.Particular : TipoConvenio.PlanoDeSaude);
                break;
            case 11:
                System.out.println("========================================================");
                System.out.println("Antes era: " + ((p.isIsFumante()) ? "sim" : "não"));
                System.out.println("É fumante? 1 - Sim ou 2 - Não");
                System.out.println("========================================================");
                int fumante = lerOpcao.nextInt();
                p.setIsFumante(fumante == 1);
                break;
            case 12:
                System.out.println("========================================================");
                System.out.println("Antes era: " + ((p.isIsAlcolatra()) ? "sim" : "não"));
                System.out.println("Consume Bebidas Alcoolicas? 1 - Sim ou 2 - Não");
                System.out.println("========================================================");
                int alcolatra = lerOpcao.nextInt();
                p.setIsAlcolatra(alcolatra == 1);
                break;
            case 13:
                System.out.println("========================================================");
                System.out.println("Antes era: " + ((p.getColesterol()) ? "sim" : "não"));
                System.out.println("Tem colesterol alto? 1 - Sim ou 2 - Não");
                System.out.println("========================================================");
                int colesterol = lerOpcao.nextInt();
                p.setIsColesterol(colesterol == 1);
                break;
            case 14:
                System.out.println("========================================================");
                System.out.println("Antes era: " + ((p.isIsDiabetico()) ? "sim" : "não"));
                System.out.println("É diabético? 1 - Sim ou 2 - Não");
                System.out.println("========================================================");
                int diabetico = lerOpcao.nextInt();
                p.setIsDiabetico(diabetico == 1);
                break;
            case 15:
                System.out.println("========================================================");
                System.out.println("As doenças cardiacas anterior era: " + p.getDoencasCardiacas());
                System.out.println("Se possuir doenças cardiacas descreva, caso contrário digite 'Não possuo'?");
                System.out.println("========================================================");
                p.setDoencasCardiacas(lerOpcao.nextLine());
                break;
            case 16:
                System.out.println("========================================================");
                System.out.println("anterior as informações de cirurgia eram: " + p.getCirurgias());
                System.out.println("Se fez cirurgias descreva, caso contrário digite 'Não fiz'?");
                System.out.println("========================================================");
                p.setCirurgias(lerOpcao.nextLine());
                break;
            case 17:
                System.out.println("========================================================");
                System.out.println("As alergias anteriores era: " + p.getAlergias());
                System.out.println("Se tem alergias descreva, caso contrário digite 'Não tenho'?");
                System.out.println("========================================================");
                p.setAlergias(lerOpcao.nextLine());
                break;
        }
        return p;
    }

    public static boolean removerPaciente() {
        boolean sair = false;
        String opcao = "";
        while (!sair) {
            try {
                System.out.println("=====================================");
                System.out.println("Estamos em 'Remover Paciente', digite o número do paciente que você deseja remover");
                System.out.println("Ou digite 'Sair' para sair");
                int i = 0;
                for (Paciente p : lista_pacientes) {
                    System.out.println("Numero: " + i + "Paciente: " + p.getNome());
                    i += 1;
                }
                Scanner lerOpcao = new Scanner(System.in);
                opcao = lerOpcao.nextLine();
                if (opcao.equals("Sair")) {
                    sair = true;
                } else {
                    lista_pacientes.remove(Integer.parseInt(opcao));
                    return true;
                }
            } catch (IndexOutOfBoundsException | InputMismatchException | NumberFormatException e) {
                System.out.println("========================================================");
                System.out.println("Você não digitou um das opções acima!");
                System.out.println("========================================================");
            }
        }
        return true;
    }
}
