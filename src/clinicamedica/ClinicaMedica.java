/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinicamedica;

import clinicamedica.consulta.Consulta;
import clinicamedica.pessoas.Paciente;
import clinicamedica.pessoas.Usuario;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author miche
 */
public class ClinicaMedica {

    static List<Paciente> lista_pacientes = new ArrayList();
    static List<Consulta> lista_consultas = new ArrayList();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        logar();
    }

    public static void logar() {
        Usuario usuarioLogado = new Usuario();
        List<Usuario> usuarios = usuarioLogado.povoarUsuarios();
        lista_pacientes = new Paciente().povoarPacientes();
        int opcao;
        while (usuarioLogado.getId() <= 0) {
            try {
                Scanner tipoUsuario = new Scanner(System.in);
                int i = 0;
                for (Usuario u : usuarios) {
                    System.out.println(i + " - " + u.getNome() + "\n");
                    i += 1;
                }
                System.out.println("Digite o numero do usuário abaixo: \n");
                opcao = tipoUsuario.nextInt();
                usuarioLogado = usuarios.get(opcao);
                System.out.println("Usuario Logado: " + usuarioLogado.toString());
            } catch (IndexOutOfBoundsException | InputMismatchException e) {
                System.out.println("========================================================");
                System.out.println("Você não digitou um dos usuários acima!");
                System.out.println("========================================================");
            } catch (Exception e) {
                System.out.println("Erro não esperado: " + e);
            }
        }
        usuarioLogado.getTipo().menu(lista_pacientes, lista_consultas);
    }    
}
