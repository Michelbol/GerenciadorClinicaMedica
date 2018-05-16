/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinicamedica;

/**
 *
 * @author miche
 */
public enum TipoConsulta {
    Normal(60), Retorno(30);
    
    int tempo;

    private TipoConsulta(int tempo) {
        this.tempo = tempo;
    }
    
}
