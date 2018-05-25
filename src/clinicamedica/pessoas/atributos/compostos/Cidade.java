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
public class Cidade {
    private String cidade;
    private String estado;
    private String pais;

    public Cidade() {
    }
    
    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Cidade(String cidade, String estado, String pais) {
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Cidade{" + "cidade=" + cidade + ", estado=" + estado + ", pais=" + pais + '}';
    }
    
}
