/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinicamedica.pessoas;

import clinicamedica.pessoas.atributos.compostos.Endereco;
import clinicamedica.pessoas.atributos.compostos.Telefone;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author miche
 */
public class Pessoa {
    private String nome;
    private String sobrenome;
    private String cpf;
    private String rg;
    private Date dataNascimento;
    private Endereco endereco;
    private Telefone residencial;
    private Telefone celular;
    private String email;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Telefone getResidencial() {
        return residencial;
    }

    public void setResidencial(Telefone residencial) {
        this.residencial = residencial;
    }

    public Telefone getCelular() {
        return celular;
    }

    public void setCelular(Telefone celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + ", sobrenome=" + sobrenome + ", cpf=" + cpf + ", rg=" + rg + ", dataNascimento=" + dataNascimento + ", endereco=" + endereco + ", residencial=" + residencial + ", celular=" + celular + ", email=" + email + '}';
    }

    public Pessoa(String nome, String sobrenome, String cpf, String rg, Date dataNascimento, Endereco endereco, Telefone residencial, Telefone celular, String email) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.residencial = residencial;
        this.celular = celular;
        this.email = email;
    }

    public Pessoa() {
    }  
    
}
