/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinicamedica;

import java.util.Date;

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
}
