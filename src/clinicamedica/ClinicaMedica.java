/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinicamedica;

import clinicamedica.pessoas.TipoUsuario;
import clinicamedica.pessoas.Usuario;
import clinicamedica.pessoas.atributos.compostos.Cidade;
import clinicamedica.pessoas.atributos.compostos.Endereco;
import clinicamedica.pessoas.atributos.compostos.Telefone;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author miche
 */
public class ClinicaMedica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Usuario usuarioLogado = new Usuario();
        usuarioLogado.setTipo(usuarioLogado.menuTipoUsuario());
    }
    
    
    public ArrayList<Usuario> usuariosPrevistos(){
        Usuario u = new Usuario();
        u.setId(1);
        u.setNome("José");
        u.setSobrenome("da Silva");
        u.setResidencial(new Telefone("55", "44", "3028", "2998"));
        u.setRg("7.778.003-53");
        u.setTipo(TipoUsuario.Medico);
        u.setCelular(new Telefone("55", "44", "99824", "6655"));
        u.setCpf("123.232.345-12");
        u.setDataNascimento(new Date("11/10/1995"));
        u.setEmail("michel_ra83558@gmail.com");
        u.setEndereco(new Endereco(new Cidade("Maringá", "PR", "Brasil"), "Travessa Ruboso", "8956", "Zona 03"));
        return null;
    }
}
