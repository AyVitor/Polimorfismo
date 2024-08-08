package Poo.Locadora;

// Luxo.java
public class Luxo extends Veiculo {
    private int numeroAirbags;
    private int tamanhoPortaMalas;
    private boolean gpsIntegrado;
    private static final int RENOVACOES_GRATIS = 5;

    public Luxo(String marca, String modelo, String placa, int ano, double valorLocacao, double valorMulta, int numeroAirbags, int tamanhoPortaMalas, boolean gpsIntegrado) {
        super(marca, modelo, placa, ano, valorLocacao, valorMulta);
        this.numeroAirbags = numeroAirbags;
        this.tamanhoPortaMalas = tamanhoPortaMalas;
        this.gpsIntegrado = gpsIntegrado;
    }

    @Override
    public double calcularValorTotal(int renovacoes) {
        int renovacoesCobradas = Math.max(0, renovacoes - RENOVACOES_GRATIS);
        return valorLocacao + (renovacoesCobradas * valorMulta);
    }
public int getNumeroAirbags() {
    return numeroAirbags;
}
public void setNumeroAirbags(int numeroAirbags) {
    this.numeroAirbags = numeroAirbags;
}
public int getTamanhoPortaMalas() {
    return tamanhoPortaMalas;
}
public void setTamanhoPortaMalas(int tamanhoPortaMalas) {
    this.tamanhoPortaMalas = tamanhoPortaMalas;
}
public boolean getGpsIntegrado(){
    return gpsIntegrado;

}
public boolean setGpsIntegrado(boolean gpsIntegrado) {
    this.gpsIntegrado = gpsIntegrado;
    return true;
}
}

