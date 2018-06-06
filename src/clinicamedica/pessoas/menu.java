/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinicamedica.pessoas;

import clinicamedica.consulta.Consulta;
import java.util.List;

/**
 *
 * @author miche
 */
public interface menu {
    
    public abstract void menu(List<Paciente> lista_pacientes, List<Consulta> lista_consultas, List<Usuario> lista_usuarios);
    
    public abstract void menuPaciente(List<Paciente> li);
    
    public abstract Paciente menuCadastrarPaciente();
    
    public abstract Paciente menuAlteracoesPaciente(Paciente p);
    
    public abstract Paciente menuSalvarAtributo(int i, Paciente p);
    
    public abstract Paciente menuAtualizarAtributo(int i, Paciente p);
}
