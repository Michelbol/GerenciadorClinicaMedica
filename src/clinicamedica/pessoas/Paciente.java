/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinicamedica.pessoas;

import clinicamedica.pessoas.atributos.compostos.Endereco;
import clinicamedica.pessoas.atributos.compostos.Telefone;
import java.util.Date;

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
    
}
