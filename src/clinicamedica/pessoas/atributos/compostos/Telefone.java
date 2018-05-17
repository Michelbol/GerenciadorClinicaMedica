/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinicamedica.pessoas.atributos.compostos;

/**
 *
 * @author miche
 */
public class Telefone {
    private String codigoPais;
    private String codigoEstado;
    private String prefixo;
    private String sufixo;

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    public String getCodigoEstado() {
        return codigoEstado;
    }

    public void setCodigoEstado(String codigoEstado) {
        this.codigoEstado = codigoEstado;
    }

    public String getPrefixo() {
        return prefixo;
    }

    public void setPrefixo(String prefixo) {
        this.prefixo = prefixo;
    }

    public String getSufixo() {
        return sufixo;
    }

    public void setSufixo(String sufixo) {
        this.sufixo = sufixo;
    }

    public Telefone(String codigoPais, String codigoEstado, String prefixo, String sufixo) {
        this.codigoPais = codigoPais;
        this.codigoEstado = codigoEstado;
        this.prefixo = prefixo;
        this.sufixo = sufixo;
    }

    @Override
    public String toString() {
        return "Telefone{" + "codigoPais=" + codigoPais + ", codigoEstado=" + codigoEstado + ", prefixo=" + prefixo + ", sufixo=" + sufixo + '}';
    }
    
}
