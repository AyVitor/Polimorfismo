package Poo.Locadora;

// Main.java
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Locadora locadora = new Locadora("Locadora X", "Rua Y", "123456789");
        Scanner scanner = new Scanner(System.in);
        int option;

        
         do {
            System.out.println("\nSistema de Locadora de Veículos");
            System.out.println("1. Cadastrar Novo Veículo");
            System.out.println("2. Cadastrar Cliente");
            System.out.println("3. Realizar Empréstimo");
            System.out.println("4. Finalizar Empréstimo");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Consumes the newline

            switch (option) {
                case 1:
                    cadastrarVeiculo(scanner, locadora);
                    break;
                case 2:
                    cadastrarCliente(scanner, locadora);
                    break;
                case 3:
                    realizarEmprestimo(scanner, locadora);
                    break;
                case 4:
                    finalizarEmprestimo(scanner, locadora);
                    break;
                case 5:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (option != 5);

        scanner.close();
    }

    private static void cadastrarVeiculo(Scanner scanner, Locadora locadora) {
        System.out.println("\n--- Cadastrar Novo Veículo ---");
        System.out.println("Escolha o tipo de veículo:");
        System.out.println("1. Popular");
        System.out.println("2. SUV");
        System.out.println("3. Luxo");
        int tipoVeiculo = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Placa: ");
        String placa = scanner.nextLine();
        System.out.print("Ano: ");
        int ano = scanner.nextInt();
        System.out.print("Valor da Locação: ");
        double valorLocacao = scanner.nextDouble();
        System.out.print("Valor da Multa: ");
        double valorMulta = scanner.nextDouble();

        switch (tipoVeiculo) {
            case 1:
                System.out.print("Possui ar-condicionado (true/false): ");
                boolean arCondicionado = scanner.nextBoolean();
                Veiculo popular = new Popular(marca, modelo, placa, ano, valorLocacao, valorMulta, arCondicionado);
                locadora.cadastrarVeiculo(popular);
                break;
            case 2:
                System.out.print("Tamanho do porta-malas: ");
                int tamanhoPortaMalas = scanner.nextInt();
                scanner.nextLine(); 
                System.out.print("Tipo de tração: ");
                String tipoTracao = scanner.nextLine();
                System.out.print("Tipo de combustível: ");
                String tipoCombustivel = scanner.nextLine();
                Veiculo suv = new SUV(marca, modelo, placa, ano, valorLocacao, valorMulta, tamanhoPortaMalas, tipoTracao, tipoCombustivel);
                locadora.cadastrarVeiculo(suv);
                break;
            case 3:
                System.out.print("Número de airbags: ");
                int numeroAirbags = scanner.nextInt();
                System.out.print("Tamanho do porta-malas: ");
                int tamanhoPortaMalasLuxo = scanner.nextInt();
                System.out.print("Possui GPS integrado (true/false): ");
                boolean gpsIntegrado = scanner.nextBoolean();
                Veiculo luxo = new Luxo(marca, modelo, placa, ano, valorLocacao, valorMulta, numeroAirbags, tamanhoPortaMalasLuxo, gpsIntegrado);
                locadora.cadastrarVeiculo(luxo);
                break;
            default:
                System.out.println("Tipo de veículo inválido!");
                return;
        }
        System.out.println("Veículo cadastrado com sucesso!");
    }

    private static void cadastrarCliente(Scanner scanner, Locadora locadora) {
        System.out.println("\n--- Cadastrar Cliente ---");
        System.out.println("Escolha o tipo de cliente:");
        System.out.println("1. Pessoa Física");
        System.out.println("2. Pessoa Jurídica");
        int tipoCliente = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();

        switch (tipoCliente) {
            case 1:
                System.out.print("CPF: ");
                String cpf = scanner.nextLine();
                Cliente pessoaFisica = new PessoaFisica(nome, telefone, endereco, cpf);
                locadora.cadastrarCliente(pessoaFisica);
                break;
            case 2:
                System.out.print("CNPJ: ");
                String cnpj = scanner.nextLine();
                System.out.print("Nome do Representante: ");
                String nomeRepresentante = scanner.nextLine();
                Cliente pessoaJuridica = new PessoaJuridica(nome, telefone, endereco, cnpj, nomeRepresentante);
                locadora.cadastrarCliente(pessoaJuridica);
                break;
            default:
                System.out.println("Tipo de cliente inválido!");
                return;
        }
        System.out.println("Cliente cadastrado com sucesso!");
    }

    private static void realizarEmprestimo(Scanner scanner, Locadora locadora) {
        System.out.println("\n--- Realizar Empréstimo ---");
        System.out.print("Nome do cliente: ");
        String nomeCliente = scanner.nextLine();

        Cliente cliente = locadora.getClientes().stream()
                .filter(c -> c.getNome().equalsIgnoreCase(nomeCliente))
                .findFirst()
                .orElse(null);

        if (cliente == null) {
            System.out.println("Cliente não encontrado!");
            return;
        }

        System.out.print("Placa do veículo: ");
        String placaVeiculo = scanner.nextLine();

        Veiculo veiculo = locadora.getVeiculosDisponiveis().stream()
                .filter(v -> v.getPlaca().equalsIgnoreCase(placaVeiculo))
                .findFirst()
                .orElse(null);

        if (veiculo == null) {
            System.out.println("Veículo não encontrado ou já alugado!");
            return;
        }

        locadora.realizarEmprestimo(cliente, veiculo);
        System.out.println("Empréstimo realizado com sucesso!");
    }

    private static void finalizarEmprestimo(Scanner scanner, Locadora locadora) {
        System.out.println("\n--- Finalizar Empréstimo ---");
        System.out.print("Nome do cliente: ");
        String nomeCliente = scanner.nextLine();

        Emprestimo emprestimo = locadora.getEmprestimos().stream()
                .filter(e -> e.getClass().getName().equalsIgnoreCase(nomeCliente))
                .findFirst()
                .orElse(null);

        if (emprestimo == null) {
            System.out.println("Empréstimo não encontrado!");
            return;
        }

        locadora.finalizarEmprestimo(emprestimo);
        System.out.println("Empréstimo finalizado com sucesso!");
    }
}


