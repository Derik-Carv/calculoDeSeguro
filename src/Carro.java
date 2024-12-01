public class Carro extends Veiculo implements Manutencao {
    private String tipo = "";
    private int ccld;
    private int valorPortas = 0;
    private String detalhes = "";
    private int total = 0;
    private int valorCc;
    private int portas = 0;

    int cc[] = new int[]{
            40000, //1200cc
            60000, //1300cc
            100000,//1800cc
            200000,//2500cc
            300000,//3000cc
            500000,//4000cc+
    };

    public Carro(int portas, int ccld, String marca, String modelo, String cor, String placa, double valor, int ano, double km) {
        super(marca, modelo, cor, placa, valor, ano, km);
        this.tipo = "Carro";
        this.portas = portas;
        this.ccld = ccld;
        setCilidradas(ccld);
    }

    /**
     * calcula o valor das cilindradas
     */
    public void setCilidradas(int ccld) {
        if (ccld <= 1200) {
            valorCc = cc[0];
        } else if (ccld >= 1300 && ccld < 1800) {
            valorCc = cc[1];
        } else if (ccld >= 1800 && ccld < 2500) {
            valorCc = cc[2];
        } else if (ccld >= 2500 && ccld < 3000) {
            valorCc = cc[3];;
        } else if (ccld >= 3000 && ccld < 4000) {
            valorCc = cc[4];
        } else if (ccld >= 4000) {
            valorCc = cc[5];
        } else {
            System.out.println("Cilindrada não precificada.");
        }
    }

    /**
     * calcula o valor das portas
     */
    public int getValorPortas() {
        return this.portas * 2000;
    }

    public int getValorCilindradas() {
        return valorCc;
    }

    private int getCc(){return this.ccld;}

    public String getTipo(){ return this.tipo; }

    // metodos da interface
    @Override

    public String detalhesVeiculo() {
        return "\nDetalhes do veículo: \nTipo: " + getTipo() + "\nValor portas: " + this.getValorPortas() + "\n" + super.getCaracteristica() + "\nCilindradas: " + this.getCc();
    }

    @Override

    public double valorManutencao(){
        return ((this.portas + this.valorCc + super.getValorManutencao()) / 1000);
    }

    @Override

    public String realizarManutencao() {
        return "Manutenção realizada com sucesso!";
    }

    @Override

    public String veiculoSelecionado() {
        return getTipo() + ": " + getModelo();
    }
}
