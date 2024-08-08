package Poo.Locadora;

// Popular.java
public class Popular extends Veiculo {
    private boolean arCondicionado;
    private int RenovacaoGratis = 1;

    public Popular(String marca, String modelo, String placa, int ano, double valorLocacao, double valorMulta, boolean arCondicionado) {
        super(marca, modelo, placa, ano, valorLocacao, valorMulta);
        this.arCondicionado = arCondicionado;
    }

    @Override
    public double calcularValorTotal(int renovacoes) {
        int renovacoesCobradas = Math.max(0, renovacoes - RenovacaoGratis);
        return valorLocacao + (renovacoesCobradas * valorMulta);
    }

    public boolean setArCondicionado(boolean arCondicionado) {
        if (this.arCondicionado= false);
        return false;
        else(this.arCondicionado = true);
        return true;
        
    }
}

