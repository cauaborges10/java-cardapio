import java.util.List;

public class Pedido {
    private int idPedido;
    private Cliente cliente;
    private List<Produto> produtos;
    private StatusPedido status;

    public Pedido(int idPedido, Cliente cliente, List<Produto> produtos) {
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.produtos = produtos;
        this.status = StatusPedido.EM_ESPERA;
    }

    public int pegarIdPedido() {
        return idPedido;
    }

    public Cliente pegarCliente() {
        return cliente;
    }

    public List<Produto> pegarProdutos() {
        return produtos;
    }

    public StatusPedido pegarStatus() {
        return status;
    }

    public void definirStatus(StatusPedido status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pedido #").append(idPedido).append("\n");
        sb.append("Cliente: ").append(cliente.pegarNome()).append("\n");
        sb.append("Produtos:\n");

        for (Produto produto : produtos) {
            sb.append(" - ").append(produto.pegarNome()).append("\n");
        }

        sb.append("Status: ").append(status);
        return sb.toString();
    }
}
