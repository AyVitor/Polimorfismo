package Poo.Locadora;

// Cliente.java (Abstract Class)
public abstract class Cliente {
    protected String nome;
    protected String telefone;
    protected String endereco;

    public Cliente(String nome, String telefone, String endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
    }

    public abstract boolean podeAlugar();

    public String getNome() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNome'");
    }

    // Getters and Setters...
}

