/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinicamedica.pessoas;

import clinicamedica.pessoas.atributos.compostos.Cidade;
import clinicamedica.pessoas.atributos.compostos.Endereco;
import clinicamedica.pessoas.atributos.compostos.Telefone;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
}
