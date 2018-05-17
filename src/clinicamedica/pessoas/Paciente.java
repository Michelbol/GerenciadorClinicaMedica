/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinicamedica.pessoas;

import clinicamedica.pessoas.atributos.compostos.Endereco;
import clinicamedica.pessoas.atributos.compostos.Telefone;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author miche
 */
public class Paciente extends Pessoa{
    private TipoConvenio tipoconvenio;
    private boolean isFumante;
    private boolean isAlcolico;
    private String colesterol;
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

    public boolean isIsAlcolico() {
        return isAlcolico;
    }

    public void setIsAlcolico(boolean isAlcolico) {
        this.isAlcolico = isAlcolico;
    }

    public String getColesterol() {
        return colesterol;
    }

    public void setColesterol(String colesterol) {
        this.colesterol = colesterol;
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

    public Paciente(TipoConvenio tipoconvenio, boolean isFumante, boolean isAlcolico, String colesterol, boolean isDiabetico, String doencasCardiacas, String cirurgias, String alergias, String nome, String sobrenome, String cpf, String rg, Date dataNascimento, Endereco endereco, Telefone residencial, Telefone celular, String email) {
        super(nome, sobrenome, cpf, rg, dataNascimento, endereco, residencial, celular, email);
        this.tipoconvenio = tipoconvenio;
        this.isFumante = isFumante;
        this.isAlcolico = isAlcolico;
        this.colesterol = colesterol;
        this.isDiabetico = isDiabetico;
        this.doencasCardiacas = doencasCardiacas;
        this.cirurgias = cirurgias;
        this.alergias = alergias;
    }

    @Override
    public String toString() {
        return "Paciente{" + "tipoconvenio=" + tipoconvenio + ", isFumante=" + isFumante + ", isAlcolico=" + isAlcolico + ", colesterol=" + colesterol + ", isDiabetico=" + isDiabetico + ", doencasCardiacas=" + doencasCardiacas + ", cirurgias=" + cirurgias + ", alergias=" + alergias + '}';
    }

    public Paciente() {
    }
    
}
