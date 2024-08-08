package Poo.Locadora;

// PessoaFisica.java
public class PessoaFisica extends Cliente {
    private String cpf;
    private boolean possuiEmprestimoAtivo;

    public PessoaFisica(String nome, String telefone, String endereco, String cpf) {
        super(nome, telefone, endereco);
        this.cpf = cpf;
        this.possuiEmprestimoAtivo = false;
    }

    @Override
    public boolean podeAlugar() {
        return !possuiEmprestimoAtivo;
    }

    public void setEmprestimoAtivo(boolean status) {
        this.possuiEmprestimoAtivo = status;
    }

   public String getCpf() {
       return cpf;
   }
   public void setCpf(String cpf) {
       this.cpf = cpf;
   }
   
}
