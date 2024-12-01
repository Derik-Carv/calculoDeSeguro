import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        boolean parar = false;
        Locale ptBr = new Locale("pt", "BR");
        Scanner scan = new Scanner(System.in);
        ArrayList<Veiculo> veiculos = new ArrayList<>();

        /**
         * desenvolvido por @Derik-Carv on Github;
         * os dados ficticios da frota foram gerados por IA, mais especificamente o ChatGPT;
         * todos os calculos foram pensados de forma com que o resultado seja próxima do valor médio real,
         * porém, os meios de calculo são inventados, sem nenhum padrão ou calculo especulado por alguma instituição.
         */

        // criando array list para base de dados de veiculos;
        veiculos.add(new Carro(4, 3000, "Toyota", "Corolla", "Preto", "ABC-1234", 75000, 2020, 30000));
        veiculos.add(new Carro(4, 3000, "Honda", "Civic", "Branco", "DEF-5678", 85000, 2021, 25000));
        veiculos.add(new Carro(4, 3000, "Ford", "Fusion", "Cinza", "GHI-9101", 90000, 2019, 40000));
        veiculos.add(new Carro(4, 3000, "Chevrolet", "Onix", "Vermelho", "JKL-1213", 60000, 2022, 10000));
        veiculos.add(new Carro(4, 3000, "Volkswagen", "Jetta", "Azul", "MNO-1415", 95000, 2018, 50000));

        veiculos.add(new Moto(1000,"Yamaha", "R1", "Azul", "PQR-1617", 70000.0, 2021, 15000));
        veiculos.add(new Moto(500,"Honda", "CB 500", "Preto", "STU-1819", 30000.0, 2020, 20000));
        veiculos.add(new Moto(1340,"Suzuki", "Hayabusa", "Branca", "VWX-2021", 80000.0, 2019, 10000));
        veiculos.add(new Moto(998,"Kawasaki", "Ninja ZX-10R", "Verde", "YZA-2324", 75000.0, 2022, 5000));
        veiculos.add(new Moto(1103,"Ducati", "Panigale V4", "Vermelha", "BCD-2526", 100000.0, 2021, 8000));

        while (!parar) {
            System.out.println("\nBem vindo ao software de manutenção preventiva!\nSelecione as opções abaixo para prosseguir:\n01. Consultar Frota.\n02. Calcular valor da Manutenção.\n03. Realizar Manutenção.\n00. Sair.");
            int opcao = scan.nextInt();

            // loopings para verificar conteúdo dos veículos;
            for (Veiculo veiculo : veiculos) {
                if (opcao == 1) {
                    System.out.println(veiculo.detalhesVeiculo());
                }
                if (opcao == 2) {
                    // transformando double para formato de moeda real brasileira
                    System.out.println("Valor de " + veiculo.veiculoSelecionado());
                    String real = NumberFormat.getCurrencyInstance(ptBr).format(veiculo.valorManutencao());
                    System.out.println("Calculando valor da manutenção...\n" + real);
                }
                if (opcao == 3) {
                    // printando manutenção
                    System.out.println("Realizando manutenção em " + veiculo.veiculoSelecionado() + "\n" + veiculo.realizarManutencao());
                }
            }
            if (opcao == 0) {
                // finaliza o programa
                parar = true;
            }
        }

    }
}