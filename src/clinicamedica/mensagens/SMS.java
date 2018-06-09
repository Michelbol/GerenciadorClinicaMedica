/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinicamedica.mensagens;

import clinicamedica.pessoas.atributos.compostos.Telefone;

/**
 *
 * @author joaov
 */
public class SMS {
    private String mensagem;
    private Telefone celular;

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Telefone getCelular() {
        return celular;
    }

    public void setCelular(Telefone celular) {
        this.celular = celular;
    }
    
    public void enviarSms(){
        System.out.println("Enviado SMS para o numero: " + celular);
    }
    
}
