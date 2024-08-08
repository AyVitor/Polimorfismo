package Poo.Locadora;

import java.util.ArrayList;
import java.util.List;

public class Locadora {
    private String nome;
    private String endereco;
    private String telefone;
    private List<Veiculo> veiculosDisponiveis;
    private List<Cliente> clientes;
    private List<Emprestimo> emprestimos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Veiculo> getVeiculosDisponiveis() {
        return veiculosDisponiveis;
    }

    public void setVeiculosDisponiveis(List<Veiculo> veiculosDisponiveis) {
        this.veiculosDisponiveis = veiculosDisponiveis;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }

   

    public Locadora(String nome, String endereco, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.veiculosDisponiveis = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.emprestimos = new ArrayList<>();

    }

    public void cadastrarVeiculo(Veiculo veiculo) {
        veiculosDisponiveis.add(veiculo);
    }

    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void realizarEmprestimo(Cliente cliente, Veiculo veiculo) {
        if (cliente.podeAlugar() && veiculosDisponiveis.contains(veiculo)) {
            emprestimos.add(new Emprestimo(cliente, veiculo));
            veiculosDisponiveis.remove(veiculo);
            if (cliente instanceof PessoaFisica) {
                ((PessoaFisica) cliente).setEmprestimoAtivo(true);
            }
        }
    }

    public void finalizarEmprestimo(Emprestimo emprestimo) {
        double valorTotal = emprestimo.finalizar();
        System.out.println("Valor total do empréstimo: R$" + valorTotal);
        veiculosDisponiveis.add(emprestimo.getVeiculo());
    }
}


