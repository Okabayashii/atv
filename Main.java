import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        HashMap<Integer, Produto> produtos = new HashMap<>();

        int opcao;

        do {
            System.out.println("\n-Menu-");
            System.out.println("1 -Cadastrar produto-");
            System.out.println("2 -Buscar produto por código-");
            System.out.println("3 -Sair-");
            System.out.print("Escolha uma opção:");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            if (opcao == 1) {
                System.out.print("Digite o código do produto: ");
                int codigo = scanner.nextInt();
                scanner.nextLine();

                if (produtos.containsKey(codigo)) {
                    System.out.println("Já existe um produto com esse código.");
                } else {
                    System.out.print("Digite o nome do produto: ");
                    String nome = scanner.nextLine();

                    System.out.print("Digite o preço do produto: ");
                    double preco = scanner.nextDouble();

                    Produto novo = new Produto(codigo, nome, preco);
                    produtos.put(codigo, novo);
                    System.out.println("Produto cadastrado com sucesso!");
                }
            }

            else if (opcao == 2) {
                System.out.print("Digite o código do produto: ");
                int codigoBusca = scanner.nextInt();

                Produto encontrado = produtos.get(codigoBusca);

                if (encontrado != null) {
                    System.out.println("\nProduto encontrado:");
                    encontrado.mostrar();
                } else {
                    System.out.println("Produto não encontrado.");
                }
            }

            else if (opcao == 3) {
                System.out.println("Saindo do sistema...");
            }

            else {
                System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 3);

        scanner.close();
    }
}
