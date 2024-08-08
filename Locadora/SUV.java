package Poo.Locadora;

// SUV.java
public class SUV extends Veiculo {
    private int tamanhoPortaMalas;
    private String tipoTracao;
    private String tipoCombustivel;
    private int RenovacaoGratis = 3;

    public SUV(String marca, String modelo, String placa, int ano, double valorLocacao, double valorMulta, int tamanhoPortaMalas, String tipoTracao, String tipoCombustivel) {
        super(marca, modelo, placa, ano, valorLocacao, valorMulta);
        this.tamanhoPortaMalas = tamanhoPortaMalas;
        this.tipoTracao = tipoTracao;
        this.tipoCombustivel = tipoCombustivel;
    }

    @Override
    public double calcularValorTotal(int renovacoes) {
        int renovacoesCobradas = Math.max(0, renovacoes - RenovacaoGratis );
        return valorLocacao + (renovacoesCobradas * valorMulta);
    }

public int getTamanhoPortaMalas() {
    return tamanhoPortaMalas;
}
public void setTamanhoPortaMalas(int tamanhoPortaMalas) {
    this.tamanhoPortaMalas = tamanhoPortaMalas;
}
public String getTipoTracao() {
    return tipoTracao;
    
}
public void setTipoTracao(String tipoTracao) {
    this.tipoTracao = tipoTracao;
}
public String getTipoCombustivel() {
    return tipoCombustivel;
}
public void setTipoCombustivel(String tipoCombustivel) {
    this.tipoCombustivel = tipoCombustivel;
}
}



