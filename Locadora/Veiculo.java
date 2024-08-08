package Poo.Locadora;

// Vehicle.java (Abstract Class)
public abstract class Veiculo {
    protected String marca;
    protected String modelo;
    protected String placa;
    protected int ano;
    protected double valorLocacao;
    protected double valorMulta;

    public Veiculo(String marca, String modelo, String placa, int ano, double valorLocacao, double valorMulta) {
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.ano = ano;
        this.valorLocacao = valorLocacao;
        this.valorMulta = valorMulta;
    }

    public abstract double calcularValorTotal(int renovacoes);

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public double getValorLocacao() {
        return valorLocacao;
    }
    public void setValorLocacao(double valorLocacao) {
        this.valorLocacao = valorLocacao;
    }
    public double getValorMulta() {
        return valorMulta;
    }public void setValorMulta(double valorMulta) {
        this.valorMulta = valorMulta;
    }
}

