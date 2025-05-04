public class Cliente {
    private int idCliente;
    private String nome;
    private String telefone;

    public Cliente(int idCliente, String nome, String telefone) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.telefone = telefone;
    }

    public int pegarIdCliente() {
        return idCliente;
    }

    public void definirIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String pegarNome() {
        return nome;
    }

    public void definirNome(String nome) {
        this.nome = nome;
    }

    public String pegarTelefone() {
        return telefone;
    }

    public void definirTelefone(String telefone) {
        this.telefone = telefone;
    }
}
