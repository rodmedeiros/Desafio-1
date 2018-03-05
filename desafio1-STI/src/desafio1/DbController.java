package desafio1;

/**
 *
 * @author rodrigo
 */

import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class DbController {
    
    public static ArrayList CarregaCsv() throws IOException { //utilização de método estático, pois o 
            String caminho = "C:\\Users\\rodrigo\\desafio1/alunos.csv";//mesmo será chamado através da classe e não do objeto.
            FileReader arq = new FileReader(caminho);//classe que irá tratar o arquivo como leitura.
            BufferedReader leitorCsv = new BufferedReader(arq);//Buffer do arquivo de leitura passado.
            String linha = leitorCsv.readLine();//leitura da linha.
            ArrayList<Aluno> alunos = new ArrayList<>();//criação do arrayList com objetos da classe aluno.
                while ((linha = leitorCsv.readLine()) != null) {//criação dos objetos Aluno e inserção
                    String aux[] = linha.split(",");            //no ArrayList.
                    Aluno aluno = new Aluno();
                    aluno.setNome(aux[0]);
                    aluno.setMatricula(aux[1]);
                    aluno.setTelefone(aux[2]);
                    aluno.setEmail(aux[3]);
                    aluno.setUffMail(aux[4]);
                    aluno.setStatus(aux[5]);
                    alunos.add(aluno);
                }
            leitorCsv.close();
            return alunos;
    } 
    //método para gravação/atualização do arquivo csv
    public static boolean gravarCsv(ArrayList<Aluno> alunos){
        try {
            String caminho = "C:\\Users\\rodrigo\\desafio1/alunos2.csv";
            FileWriter writer = new FileWriter(caminho);//criação do arquivo a ser gravado
                for(Aluno aluno : alunos)  //gravação linha por linha
                        writer.write(
                        aluno.getNome()+","+aluno.getMatricula()+","+
                        aluno.getTelefone()+","+aluno.getEmail()+","+
                        aluno.getUffMail()+","+aluno.getStatus()+"\n");  
                writer.close();
                System.out.println("Email salvo com sucesso!");
                 return true;
        } catch(IOException e){
            System.out.println("Não foi possível gravar seu arquivo!\n"
                                + "erro:"+e);
            return false;
        }
    }
}
 
