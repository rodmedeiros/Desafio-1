package desafio1;

/**
 *
 * @author rodrigo
 */

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

class GeradorUffmail {
    //metodo principal para a chamada dos outros métodos da classe
    //e controle de exceções.
    public static void MenuOpcoes(Aluno aluno){
        HashMap<Integer,String> mapeado = geraOpcoes(aluno);
        String escolhido = "";
        try{//tratamento do erro de entrada incompatível
            escolhido = criaEmail(mapeado);
            String senha = criaSenha();
            aluno.setUffMail(escolhido);//grava o uffmail escolhido no cadastro do aluno
            enviaSms(aluno.getTelefone());
        } catch (InputMismatchException e) {
            System.out.println("\nEntrada inválida!!!\n");
            System.out.print("Por vavor, digite opção válida!\n");
            MenuOpcoes(aluno);
        } 
    }
    //o método cria as opções de emails e hashmap delas
    public static HashMap<Integer,String> geraOpcoes(Aluno aluno){
        String nome[] = divideNome(aluno);//chamada do método divideNome
        String dominioAluno = "@id.uff.br";//possibilidade de criação de outros
        String aux="";                     //domínios e msm um método para sua escolha.
        String primeiroNome=nome[0];
        HashMap <Integer, String> mapaEmails = new HashMap<>();
        //mapeando os emails
        mapaEmails.put(1, (aux = (nome[0] + "_" + nome[1]+dominioAluno).toLowerCase()));
        mapaEmails.put(2, (aux  = (nome[0].charAt(0) + nome[1]+dominioAluno).toLowerCase()));
        mapaEmails.put(3, (aux = (nome[2] + nome[1]+dominioAluno).toLowerCase()));
        mapaEmails.put(4, (nome[0]+"."+nome[2]+dominioAluno).toLowerCase());
        imprimeEmails(mapaEmails,primeiroNome);
        return mapaEmails;
    }
    //método para dividir o nome do aluno em partes para serem usadas
    //para criar as opções de uffmails
    public static String[] divideNome(Aluno aluno){
        String aux = aluno.getNome();
        String nomes[] = aluno.getNome().split(" ");
        return nomes;
    }  
    //método responsável por imprimir as opções de emails
    private static void imprimeEmails(HashMap<Integer, String> mapaEmails, String primeiroNome) {
        System.out.println(primeiroNome + ", por favor escolha uma das opções abaixo para o seu UFFMail:\n");
        for (Map.Entry<Integer, String> linha : mapaEmails.entrySet()) {
            System.out.println(linha.getKey() + "-" + linha.getValue());
        }
    }
    //lê o valor da entrada de escolha
    public static int lerValor() throws InputMismatchException{//método para a leitura da matrícula do aluno
        Scanner teclado = new Scanner(System.in);
        int entrada = teclado.nextInt();
        return entrada;
    }
    //recebe o valor da entrada e "cria" o email escolhido
    private static String criaEmail(HashMap<Integer, String> mapaEmails) throws InputMismatchException{
            int entrada = lerValor();
            //Scanner teclado = new Scanner(System.in);
            //int entrada = teclado.nextInt();
            String escolhido = mapaEmails.get(entrada);
            if(escolhido==null){
                System.out.println("\nA entrada não é valida!!!\n");
                System.out.print("Por vavor, digite opção válida: ");
                criaEmail(mapaEmails);
            }else{
                System.out.println("A criação de seu e-mail ("+escolhido+") será feita nos próximos minutos.");
            }
            return escolhido;
    }
    //método de criação de senha
    private static String criaSenha(){
        UUID uuid = UUID.randomUUID();
        String senha = (uuid.toString()).substring(0,6);
        return senha;
    }
    //método para o envio de senha ao usuário
    private static void enviaSms(String tel) {
       System.out.println("Um SMS foi enviado para " +tel+ " com a sua senha de acesso");
    }
}   
    
    

