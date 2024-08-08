package Poo.Locadora;

// PessoaJuridica.java
public class PessoaJuridica extends Cliente {
    private String cnpj;
    private String nomeRepresentante;

    public PessoaJuridica(String nome, String telefone, String endereco, String cnpj, String nomeRepresentante) {
        super(nome, telefone, endereco);
        this.cnpj = cnpj;
        this.nomeRepresentante = nomeRepresentante;
    }

    @Override
    public boolean podeAlugar() {
        return true;
    }

    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    public String getNomeRepresentante() {
        return nomeRepresentante;
    }
    public void setNomeRepresentante(String nomeRepresentante) {
        this.nomeRepresentante = nomeRepresentante;
    }
}

