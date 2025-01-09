import java.util.ArrayList;
import java.util.Scanner;

class Cliente {
    private final String nome;
    private final String cpf;
    private final String endereco;
    private final String telefone;

    // Construtor
    public Cliente(String nome, String cpf, String endereco, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    // Exibe as informações do cliente
    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Endereço: " + endereco);
        System.out.println("Telefone: " + telefone);
    }
}

class SistemaCadastroClientes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Cliente> clientes = new ArrayList<>();

        int opcao = 0;

        while (opcao != 4) {
            System.out.println("\n=== Sistema de Cadastro de Clientes ===");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Listar Clientes Cadastrados");
            System.out.println("3. Buscar Cliente por Nome");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  // Limpar o buffer de entrada

            switch (opcao) {
                case 1:
                    // Cadastrar cliente
                    System.out.print("Digite o nome do cliente: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o CPF do cliente: ");
                    String cpf = scanner.nextLine();
                    System.out.print("Digite o endereço do cliente: ");
                    String endereco = scanner.nextLine();
                    System.out.print("Digite o telefone do cliente: ");
                    String telefone = scanner.nextLine();

                    Cliente cliente = new Cliente(nome, cpf, endereco, telefone);
                    clientes.add(cliente);
                    System.out.println("Cliente cadastrado com sucesso!");
                    break;

                case 2:
                    // Listar clientes cadastrados
                    if (clientes.isEmpty()) {
                        System.out.println("Nenhum cliente cadastrado.");
                    } else {
                        System.out.println("\nLista de Clientes Cadastrados:");
                        for (Cliente cli : clientes) {
                            cli.exibirInformacoes();
                            System.out.println("-----------------------------");
                        }
                    }
                    break;

                case 3:
                    // Buscar cliente por nome
                    System.out.print("Digite o nome do cliente para buscar: ");
                    String nomeBusca = scanner.nextLine();
                    Cliente clienteEncontrado = buscarClientePorNome(clientes, nomeBusca);

                    if (clienteEncontrado != null) {
                        clienteEncontrado.exibirInformacoes();
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;

                case 4:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }

    // Método auxiliar para buscar cliente pelo nome
    private static Cliente buscarClientePorNome(ArrayList<Cliente> clientes, String nome) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nome)) {
                return cliente;
            }
        }
        return null; // Retorna null caso não encontre o cliente
    }
}
