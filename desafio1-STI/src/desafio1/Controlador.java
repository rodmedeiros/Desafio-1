package desafio1;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
/**
 *
 * @author rodrigo
 */
public class Controlador {
    //Imprime na tela o Cabeçalho
    public static void iniciar(ArrayList<Aluno> alunos){
        System.out.println("UNIVERSIDADE FEDERAL FLUMINENSE\n"+
                            "STI - "
                            +"Bem vindo ao assitente de criação do UffMail!!!\n"
                            );
        Controlador.verificaMatricula(alunos);
        }
    //método para a leitura da matrícula do aluno   
    public static String lerMatricula(){
        Scanner teclado = new Scanner(System.in);
        String entrada = teclado.next();
        return entrada;
    }
    //verifica se a matrícula é válida
    public static void verificaMatricula(ArrayList<Aluno> alunos){
        System.out.print("\nPor favor, digite sua matrícula: ");
        String matStr = lerMatricula();
        Aluno aux = new Aluno();
        for (Aluno aluno : alunos) {
            if(aluno.getMatricula().equalsIgnoreCase(matStr)){
                aux = aluno;                    
            }
        }
        if (aux.getMatricula()!= null){
            verificaAtivo(aux, alunos);
        } else {
            System.out.println("\nMatrícula Inválida!!!");
            verificaMatricula(alunos); 
        }
    }
    //verifica se a matrícula passada por parâmetro está ativa
    private static void verificaAtivo(Aluno aux, ArrayList<Aluno> alunos) {
        
        if (aux.getStatus().equalsIgnoreCase("ativo")){
            verificaUffMail(aux, alunos);
        } else {
            System.out.println("\nO aluno não possui cadastro ativo!");
            verificaMatricula(alunos);
        }
    }
    //verifica se o aluno já possui uffmail
    private static void verificaUffMail(Aluno aux, ArrayList<Aluno> alunos) {
        if (aux.getUffMail().contains("@")){
            System.out.println("\nO aluno já possui Uffmail cadastrado!");
            Controlador.verificaMatricula(alunos);
        } else {
            GeradorUffmail.MenuOpcoes(aux);
        }
    }
}

    
    
    

