package Poo.Locadora;


public class Emprestimo {
    private Cliente cliente;
    private Veiculo veiculo;
    private int renovacoes;

    public Emprestimo(Cliente cliente, Veiculo veiculo) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.renovacoes = 0;
    }

    public void renovar() {
        renovacoes++;
    }

    public double finalizar() {
        double valorTotal = veiculo.calcularValorTotal(renovacoes);
        if (cliente instanceof PessoaFisica) {
            ((PessoaFisica) cliente).setEmprestimoAtivo(false);
        }
        return valorTotal;
    }

    public Veiculo getVeiculo() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getVeiculo'");
    }

    // Getters and Setters...
}

