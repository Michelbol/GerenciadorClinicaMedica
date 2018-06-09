/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinicamedica.mensagens;

import clinicamedica.consulta.Consulta;
import clinicamedica.pessoas.Paciente;
import java.util.Date;
import java.util.List;

/**
 *
 * @author miche
 */
public interface EnviarMensagem {
    
    public static void enviarSMS(List<Consulta> lista_consulta){
        Date dataAtual = new Date(System.currentTimeMillis());
        
        for(Consulta c: lista_consulta){
            if (c.getDataHora().getDay()==dataAtual.getDay()+1){
                SMS sms = new SMS();
                sms.setMensagem("Aviso! Amanhã o paciente " + c.getPaciente().getNome() + " possui uma consulta marcada, favor ligar para a clinica e confirmar a consulta.");
                sms.setCelular(c.getPaciente().getCelular());
                sms.enviarSms();
            }
        }
    }
    
    public static void enviarEmail(List<Consulta> lista_consulta){
        Date dataAtual = new Date(System.currentTimeMillis());
        
        for(Consulta c: lista_consulta){
            if (c.getDataHora().getDay()==dataAtual.getDay()+1){
                Email email = new Email();
                email.setMensagem("Aviso! Amanhã o paciente " + c.getPaciente().getNome() + " possui uma consulta marcada, favor ligar para a clinica e confirmar a consulta.");
                email.setEmail(c.getPaciente().getEmail());
                email.enviarSms();    
            }
        }
    }

}
