/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinicamedica.mensagens;

import clinicamedica.consulta.Consulta;
import clinicamedica.pessoas.Paciente;

/**
 *
 * @author miche
 */
public class EnviarSms implements EnviarMensagem{

    @Override
    public void enviarMensagem(Paciente p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean verificarNecessidade(Consulta c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
