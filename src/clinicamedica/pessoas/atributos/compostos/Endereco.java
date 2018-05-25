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
    private String logradouro;
    private String numero;
    private String bairro;

    public Endereco() {
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
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
        this.logradouro = endereco;
        this.numero = numero;
        this.bairro = bairro;
    }

    @Override
    public String toString() {
        return "Endereco{" + "cidade=" + cidade + ", endereco=" + logradouro + ", numero=" + numero + ", bairro=" + bairro + '}';
    }
    
}
