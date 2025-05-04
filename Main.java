import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int idPedidoAtual = 1001;
        int idClienteAtual = 101;

        // Criando cardápio
        List<Produto> cardapio = Arrays.asList(
                new Produto(1, "X-Salada", "Pão macio, hambúrguer bovino, queijo, alface, tomate e maionese."),
                new Produto(2, "X-Bacon", "Hambúrguer suculento com queijo derretido, tiras crocantes de bacon, alface, tomate e maionese."),
                new Produto(3, "Misto Quente", "Pão de forma tostado com recheio de presunto e queijo derretido."),
                new Produto(4, "Cachorro-Quente", "Pão macio com salsicha, ketchup, mostarda, milho, batata palha e maionese."),
                new Produto(5, "Porção de Iscas de Peixe", "Iscas de peixe empanadas e fritas. Servidas com limão e molho tártaro."),
                new Produto(6, "Batata Frita", "Porção de batatas crocantes e douradas."),
                new Produto(7, "Água Mineral (500ml)", "Opção leve e refrescante. Com ou sem gás."),
                new Produto(8, "Refrigerante Lata (350ml)", "Diversos sabores para refrescar seu lanche."),
                new Produto(9, "Suco Natural", "Sucos preparados na hora com frutas frescas."),
                new Produto(10, "Milkshake (300ml)", "Cremoso e gelado, sabores chocolate, morango e baunilha.")
        );

        Funcionario funcionario = new Funcionario(201, "Carlos Souza");

        while (true) {
            System.out.println("\n=== NOVO PEDIDO ===");

            System.out.print("Digite seu nome: ");
            String nomeCliente = scanner.nextLine();

            System.out.print("Digite seu telefone: ");
            String telefone = scanner.nextLine();

            Cliente cliente = new Cliente(idClienteAtual++, nomeCliente, telefone);

            // Exibir cardápio
            System.out.println("\n=== CARDÁPIO ===");
            for (Produto produto : cardapio) {
                System.out.println(produto.pegarIdProduto() + ". " + produto.pegarNome() + " - " + produto.pegarDescricao());
            }

            // Coletar produtos
            List<Produto> produtosSelecionados = new ArrayList<>();
            System.out.println("\nDigite os números dos produtos desejados (digite 0 para finalizar):");
            while (true) {
                System.out.print("Produto #: ");
                int escolha = scanner.nextInt();
                scanner.nextLine(); // consumir quebra de linha
                if (escolha == 0) break;

                Optional<Produto> escolhido = cardapio.stream()
                        .filter(p -> p.pegarIdProduto() == escolha)
                        .findFirst();

                if (escolhido.isPresent()) {
                    produtosSelecionados.add(escolhido.get());
                    System.out.println("Adicionado: " + escolhido.get().pegarNome());
                } else {
                    System.out.println("Produto inválido. Tente novamente.");
                }
            }

            if (produtosSelecionados.isEmpty()) {
                System.out.println("Nenhum produto selecionado. Pedido cancelado.");
            } else {
                Pedido pedido = new Pedido(idPedidoAtual++, cliente, produtosSelecionados);
                System.out.println("\nPedido realizado com sucesso:");
                System.out.println(pedido);

                funcionario.atualizarStatusPedido(pedido, StatusPedido.PREPARANDO);
                funcionario.atualizarStatusPedido(pedido, StatusPedido.PRONTO);
            }

            System.out.print("\nDeseja realizar outro pedido? (s/n): ");
            String resposta = scanner.nextLine().trim().toLowerCase();
            if (!resposta.equals("s")) {
                System.out.println("Encerrando o sistema de pedidos. Obrigado!");
                break;
            }
        }

        scanner.close();
    }
}
