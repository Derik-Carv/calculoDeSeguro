import java.time.LocalDate;

abstract class Veiculo {
    protected String caracteristica;
    protected String avaliacao;
    protected String marca;
    protected String modelo;
    protected String cor;
    protected String placa;
    protected double valor;
    protected int ano;
    protected double km;
    LocalDate data = LocalDate.now();
    int anoAtual = data.getYear();

    public Veiculo(String marca, String modelo, String cor, String placa, double valor, int ano, double km) {
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.placa = placa;
        this.valor = valor;
        this.ano = ano;
        this.km = km;
    }

    //setters
    public void setMarca(String marca) { this.marca = marca;}

    public void setModelo(String modelo) { this.modelo = modelo; }

    public void setCor(String cor) { this.cor = cor; }

    public void setPlaca(String placa) { this.placa = placa; }

    public void setValor(double valor) { this.valor = valor;
        this.valor = (this.valor * 20) / 100 ;
    }

    public void setAno(int ano) { this.ano = ano;
        this.ano -= anoAtual;
    }

    public void setKm(double km) { this.km = km;
        this.km /= 4;
    }

    //getters
    public String getMarca() { return this.marca; }

    public String getModelo() {return this.modelo; }

    public String getCor() { return this.cor; }

    public String getPlaca() { return this.placa; }

    public double getValor() { return this.valor; }

    public int getAno() { return this.ano; }

    public double getKm() { return this.km; }

    public String getCaracteristica() {
        return "Caracteristicas do veículo: " + "\nMarca: " + this.marca + "\nModelo: " + this.modelo + "\nCor: " + this.cor + "\nPlaca: " + this.placa;
    }

    public double getValorManutencao() {
        return this.getAno() * (this.getValor() / this.getKm());
    }

    // metodos da interface
    public abstract String detalhesVeiculo();

    protected double valorManutencao() {return 0;};

    public String realizarManutencao() {
        return null;
    }

    public abstract String veiculoSelecionado();
}
