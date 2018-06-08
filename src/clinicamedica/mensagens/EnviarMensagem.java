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
public interface EnviarMensagem {
    
    public void enviarMensagem(Paciente p);
    
    public boolean verificarNecessidade(Consulta c);
}
