/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinicamedica.pessoas;

import clinicamedica.ClinicaMedica;
import clinicamedica.pessoas.atributos.compostos.Cidade;
import clinicamedica.pessoas.atributos.compostos.Endereco;
import clinicamedica.pessoas.atributos.compostos.Telefone;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author miche
 */
public class Usuario extends Pessoa{
    private int id;
    private TipoUsuario tipo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }

    public Usuario(int id, TipoUsuario tipo, String nome, String sobrenome, String cpf, String rg, Date dataNascimento, Endereco endereco, Telefone residencial, Telefone celular, String email) {
        super(nome, sobrenome, cpf, rg, dataNascimento, endereco, residencial, celular, email);
        this.id = id;
        this.tipo = tipo;
    }

    public Usuario() {
    }
    
    public List<Usuario> povoarUsuarios(){
        List<Usuario> usuarios = new ArrayList();
        Usuario u = new Usuario();
        u.setId(1);
        u.setNome("José");
        u.setSobrenome("da Silva");
        u.setResidencial(new Telefone("55", "44", "3028", "2998"));
        u.setRg("7.778.003-53");
        u.setTipo(TipoUsuario.Medico);
        u.setCelular(new Telefone("55", "44", "99824", "6655"));
        u.setCpf("123.232.345-12");
        u.setDataNascimento(new Date("11/10/1995"));
        u.setEmail("michel_ra83558@gmail.com");
        u.setEndereco(new Endereco(new Cidade("Maringá", "PR", "Brasil"), "Travessa Ruboso", "8956", "Zona 03"));
        usuarios.add(u);
        u = new Usuario();
        u.setId(2);
        u.setNome("Maria");
        u.setSobrenome("de Oliveira");
        u.setResidencial(new Telefone("55", "44", "3228", "9963"));
        u.setRg("9.996.220-78");
        u.setTipo(TipoUsuario.Secretaria);
        u.setCelular(new Telefone("55", "44", "99654", "2233"));
        u.setCpf("321.356.785-51");
        u.setDataNascimento(new Date("21/01/1997"));
        u.setEmail("joao_ra8899@gmail.com");
        u.setEndereco(new Endereco(new Cidade("Londrina", "PR", "Brasil"), "Av Brasil", "3256", "Zona 07"));
        usuarios.add(u);
        return usuarios;
    }
    
    public Usuario logar(){
        Usuario usuarioLogado = new Usuario();
        List<Usuario> usuarios = this.povoarUsuarios();
        int opcao;
        while(usuarioLogado.getId() <= 0){
            try{
                Scanner tipoUsuario = new Scanner(System.in);
                int i = 0;
                for(Usuario u: usuarios){
                    System.out.println(i + " - "+ u.getNome() +"\n");
                    i += 1;
                }           
                System.out.println("Digite o numero do usuário abaixo: \n");
                opcao = tipoUsuario.nextInt();
                usuarioLogado = usuarios.get(opcao);            
                System.out.println("Usuario Logado: "+ usuarioLogado.toString());
            }catch(IndexOutOfBoundsException | InputMismatchException e){
                System.out.println("========================================================");
                System.out.println("Você não digitou um dos usuários acima!");
                System.out.println("========================================================");
            }catch(Exception e){
                System.out.println("Erro não esperado: " + e);
            }
            ClinicaMedica.limpatela();
        }
        return usuarioLogado;
    } 
    
    public void menuSecretaria(){
        boolean sair = false;
        int opcao = 0;
        while(!sair){
            try{
                Scanner lerOpcao = new Scanner(System.in);
                System.out.println("O que deseja fazer?\n");
                System.out.println("01 - Cadastro de Pacientes");
                System.out.println("02 - Cadastro de Consultas");
                System.out.println("03 - Relatórios de Consultas");
                System.out.println("04 - Sair do Sistema");
                opcao = lerOpcao.nextInt();
                if(opcao == 4){
                    sair = true;
                    break;
                }
                if(opcao > 0 && opcao <= 3){
                    switch (opcao) {
                        case 1:
                            this.menuPaciente();
                            break;
                        case 2:
                            this.menuConsulta();
                            break;
                        case 3:
                            this.relatoriosConsultas();
                            break;
                    }
                }else{
                    throw new IndexOutOfBoundsException();
                }
            }catch(IndexOutOfBoundsException | InputMismatchException e){
                System.out.println("========================================================");
                System.out.println("Você não digitou um das opções!");
                System.out.println("========================================================");
            }catch(Exception e){
                System.out.println("Erro não esperado: " + e);
            }
            ClinicaMedica.limpatela();
        }
    }
    
    public void menuMedico(){
        
    }
    
    public void menu(){
        if(this.getTipo() == TipoUsuario.Medico){
            this.menuMedico();
        }else{
            this.menuSecretaria();
        }
    }
    
    public void menuPaciente(){
        boolean sair = false;
        int opcao = 0;
        while(!sair){
            try{
                System.out.println("=====================================");
                System.out.println("Estamos em 'Cadastro de Pacientes', o que deseja fazer?");
                System.out.println("01 - Cadastrar Paciente");
                System.out.println("02 - Alterar Paciente");
                System.out.println("03 - Remover Paciente");
                System.out.println("04 - Voltar para Menu Secretária");
                Scanner lerOpcao = new Scanner(System.in);
                opcao = lerOpcao.nextInt();
                if(opcao == 4 ){
                    sair = true;
                    break;
                }
                if(opcao < 4 && opcao > 0){
                    if(opcao == 1){
                        cadastrarPaciente();
                    }
                }else{
                    throw new IndexOutOfBoundsException();
                }
            }catch(IndexOutOfBoundsException | InputMismatchException e){
                System.out.println("========================================================");
                System.out.println("Você não digitou um das opções acima!");
                System.out.println("========================================================");
            }catch(Exception e){
                System.out.println("Erro não esperado: " + e);
            }
            ClinicaMedica.limpatela();
        }
    }
    
    public void cadastrarPaciente(){
        try{
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
            if(this.getTipo() == TipoUsuario.Medico){
                System.out.println("11 - é Fumante?");
                System.out.println("12 - é Alcolico?");
                System.out.println("13 - Colesterol");
                System.out.println("14 - é Diabetico?");
                System.out.println("15 - Doencas Cardiacas");
                System.out.println("16 - Cirurgias");
                System.out.println("17 - Alergias");
            }
        System.out.println("18 - Salvar");
        }catch(IndexOutOfBoundsException | InputMismatchException e){
                System.out.println("========================================================");
                System.out.println("Você não digitou um das opções acima!");
                System.out.println("========================================================");
//            escolhaValida = false;
        }catch(Exception e){
            System.out.println("Erro não esperado: " + e);
//            escolhaValida = false;
        }
    }
    
    public void menuConsulta(){
        System.out.println("Não implementado");
    }
    
    public void relatoriosConsultas(){
        System.out.println("Não implementado");
    }
}
