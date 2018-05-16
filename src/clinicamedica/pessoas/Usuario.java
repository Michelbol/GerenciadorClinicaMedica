/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinicamedica.pessoas;

import clinicamedica.pessoas.atributos.compostos.Endereco;
import clinicamedica.pessoas.atributos.compostos.Telefone;
import java.util.Date;
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
    
    public TipoUsuario menuTipoUsuario(){
        String opcao = "";
        System.out.println(opcao);
        while(opcao.length() <= 0){
            try{
            Scanner tipoUsuario = new Scanner(System.in);
            System.out.println("Por gentileza, digite o que você é(Atenção para os números maiúsculos e minusculos):\n"
                        + "-> Medico\n"
                        + "-> Secretaria\n");
            opcao = tipoUsuario.next();
            return TipoUsuario.valueOf(opcao);
            }catch(IllegalArgumentException e){
                System.out.println("========================================================");
                System.out.println("Você não digitou um dos tipos acima!");
                System.out.println("========================================================");
                opcao = "";
            }catch(Exception e){
                System.out.println("Erro não esperado: " + e);
            }
        }
        return null;
    }
}
