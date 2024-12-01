public class Moto extends Veiculo implements Manutencao {
        private String tipo = "";
        private int ccld = 0;
        private String seguro = "";
        private String detalhes = "";
        private int total = 0;
        public int valorCc;

        int cc[] = new int[]{
                1000,   //150cc
                15000,  //300cc
                25000,  //500cc
                60000, //1000cc
                80000,//1000cc++
        };

        public Moto(int ccld, String marca, String modelo, String cor, String placa, double valor, int ano, double km) {
                super(marca, modelo, cor, placa, valor, ano, km);
                this.tipo = "Moto";
                this.ccld = ccld;
                setCilidradas(this.ccld);
        }

        /**
         * calcula o valor das cilindradas
         */
        public void setCilidradas(int ccld) {
                if (ccld <= 150) {
                        valorCc = cc[0];
                } else if (ccld > 150 && ccld <= 300) {
                        valorCc = cc[1];
                } else if (ccld > 300 && ccld <= 500) {
                        valorCc = cc[2];;
                } else if (ccld > 500 && ccld <= 1000) {
                        valorCc = cc[3];
                } else if (ccld > 1000) {
                        valorCc = cc[4];
                } else {
                        System.out.println("Cilindrada não precificada.");
                }
        }

        public int getValorCilindradas() {
                return valorCc;
        }

        private int getCc(){return this.ccld;}

        public String getTipo() {return this.tipo;}

        // metodos da interface
        @Override

        public String detalhesVeiculo() {
                return "\nDetalhes do veículo: \nTipo: " +getTipo()+ "\n" + super.getCaracteristica() + "\nCilindradas: " + this.getCc();
        }

        @Override

        public double valorManutencao(){
                return ((this.valorCc += super.valorManutencao()) / 100) ;
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
