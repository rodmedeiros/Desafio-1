
        
package desafio1;

/**
 *
 * @author rodrigo
 */
public class Aluno {
    private String nome;
    private String matricula;
    private String telefone;
    private String email;
    private String uffMail;
    private String status;
    
    public Aluno(String nome, String matricula, String telefone, String email, String uffMail, String status) {
        this.nome = nome;
        this.matricula = matricula;
        this.telefone = telefone;
        this.email = email;
        this.uffMail = uffMail;
        this.status = status;
    }

    public Aluno() {
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUffMail() {
        return uffMail;
    }

    public void setUffMail(String uffmail) {
        this.uffMail = uffmail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
        
}    

    