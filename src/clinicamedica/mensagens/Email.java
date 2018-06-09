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
public class Email {
    private String mensagem;
    private String email;

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void enviarSms(){
        System.out.println("Enviado Email para o email: " + this.email);
    }
    
}
