package desafio1;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author rodrigo
 */
public class Main {
 
    public static void main(String[] args) {
        
        
        try {////tratamento do erro de entrada do método CarregaCsv
            //Chamada do método carregaCsv e inserção de coleção de objetos
            //em arrayList
            ArrayList<Aluno> alunos = DbController.CarregaCsv();
            Controlador.iniciar(alunos);
            DbController.gravarCsv(alunos);
        } catch (IOException e) {
           System.out.println("Erro: verifique o arquivo de entrada!");
        }
    }   
}
