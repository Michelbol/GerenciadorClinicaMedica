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
public class Paciente extends Pessoa{
    private TipoConvenio tipoconvenio;
    private boolean isFumante;
    private boolean isAlcolatra;
    private boolean isColesterol;
    private boolean isDiabetico;
    private String doencasCardiacas;
    private String cirurgias;
    private String alergias;

    public TipoConvenio getTipoconvenio() {
        return tipoconvenio;
    }

    public void setTipoconvenio(TipoConvenio tipoconvenio) {
        this.tipoconvenio = tipoconvenio;
    }

    public boolean isIsFumante() {
        return isFumante;
    }

    public void setIsFumante(boolean isFumante) {
        this.isFumante = isFumante;
    }

    public boolean isIsAlcolatra() {
        return isAlcolatra;
    }

    public void setIsAlcolatra(boolean isAlcolatra) {
        this.isAlcolatra = isAlcolatra;
    }

    public boolean getColesterol() {
        return isColesterol;
    }

    public void setIsColesterol(boolean isColesterol) {
        this.isColesterol = isColesterol;
    }

    public boolean isIsDiabetico() {
        return isDiabetico;
    }

    public void setIsDiabetico(boolean isDiabetico) {
        this.isDiabetico = isDiabetico;
    }

    public String getDoencasCardiacas() {
        return doencasCardiacas;
    }

    public void setDoencasCardiacas(String doencasCardiacas) {
        this.doencasCardiacas = doencasCardiacas;
    }

    public String getCirurgias() {
        return cirurgias;
    }

    public void setCirurgias(String cirurgias) {
        this.cirurgias = cirurgias;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public Paciente(TipoConvenio tipoconvenio, boolean isFumante, boolean isAlcolico, boolean colesterol, boolean isDiabetico, String doencasCardiacas, String cirurgias, String alergias, String nome, String sobrenome, String cpf, String rg, Date dataNascimento, Endereco endereco, Telefone residencial, Telefone celular, String email) {
        super(nome, sobrenome, cpf, rg, dataNascimento, endereco, residencial, celular, email);
        this.tipoconvenio = tipoconvenio;
        this.isFumante = isFumante;
        this.isAlcolatra = isAlcolico;
        this.isColesterol = colesterol;
        this.isDiabetico = isDiabetico;
        this.doencasCardiacas = doencasCardiacas;
        this.cirurgias = cirurgias;
        this.alergias = alergias;
    }

    @Override
    public String toString() {
        return "Paciente{" + "tipoconvenio=" + tipoconvenio + ", isFumante=" + isFumante + ", isAlcolico=" + isAlcolatra + ", colesterol=" + isColesterol + ", isDiabetico=" + isDiabetico + ", doencasCardiacas=" + doencasCardiacas + ", cirurgias=" + cirurgias + ", alergias=" + alergias + ", Pessoa: " +super.toString()+'}';
    }

    public Paciente() {
    }
    
    public List<Paciente> povoarPacientes(){
        List<Paciente> pacientes = new ArrayList();
        Paciente p = new Paciente();
        p.setNome("Michel");
        p.setSobrenome("Bolzon");
        p.setResidencial(new Telefone("55", "44", "3028", "2998"));
        p.setRg("7.778.003-53");
        p.setCelular(new Telefone("55", "44", "99824", "6655"));
        p.setCpf("123.232.345-12");
        p.setDataNascimento(new Date("11/10/1995"));
        p.setEmail("michel_ra83558@gmail.com");
        p.setEndereco(new Endereco(new Cidade("Maringá", "PR", "Brasil"), "Travessa Ruboso", "8956", "Zona 03"));
        p.setTipoconvenio(TipoConvenio.Particular);
        p.setIsFumante(false);
        p.setIsAlcolatra(false);
        p.setIsColesterol(false);
        p.setIsDiabetico(false);
        p.setDoencasCardiacas("Não possui");
        p.setCirurgias("Não fez");
        p.setAlergias("Não possui");
        pacientes.add(p);
        p = new Paciente();
        p.setNome("João");
        p.setSobrenome("Vitor malvestio");
        p.setResidencial(new Telefone("55", "44", "3669", "6655"));
        p.setRg("9.996.220-78");
        p.setCelular(new Telefone("55", "44", "99654", "2233"));
        p.setCpf("321.356.785-51");
        p.setDataNascimento(new Date("21/01/1997"));
        p.setEmail("joao_ra8899@gmail.com");
        p.setEndereco(new Endereco(new Cidade("Londrina", "PR", "Brasil"), "Av Brasil", "3256", "Zona 07"));
        p.setTipoconvenio(TipoConvenio.PlanoDeSaude);
        p.setIsFumante(true);
        p.setIsAlcolatra(true);
        p.setIsColesterol(true);
        p.setIsDiabetico(true);
        p.setDoencasCardiacas("Possui arritmia");
        p.setCirurgias("Fez recentemente uma para implante de aparelo para controlar arritmia");
        p.setAlergias("Possui intolerância a lactose");
        pacientes.add(p);
        return pacientes;
    }
}
