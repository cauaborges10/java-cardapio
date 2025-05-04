public class Funcionario {
    private int idFuncionario;
    private String nome;

    public Funcionario(int idFuncionario, String nome) {
        this.idFuncionario = idFuncionario;
        this.nome = nome;
    }

    public int pegarIdFuncionario() {
        return idFuncionario;
    }

    public String pegarNome() {
        return nome;
    }

    public void atualizarStatusPedido(Pedido pedido, StatusPedido novoStatus) {
        System.out.println("Funcionário " + nome + " atualizou o status do Pedido #" +
                pedido.pegarIdPedido() + " para " + novoStatus);
        pedido.definirStatus(novoStatus);
    }
}
