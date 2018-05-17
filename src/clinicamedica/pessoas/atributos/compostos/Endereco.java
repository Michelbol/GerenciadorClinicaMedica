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
public class Endereco {
    private Cidade cidade;
    private String endereco;
    private String numero;
    private String bairro;

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Endereco(Cidade cidade, String endereco, String numero, String bairro) {
        this.cidade = cidade;
        this.endereco = endereco;
        this.numero = numero;
        this.bairro = bairro;
    }

    @Override
    public String toString() {
        return "Endereco{" + "cidade=" + cidade + ", endereco=" + endereco + ", numero=" + numero + ", bairro=" + bairro + '}';
    }
    
}
