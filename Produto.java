public class Produto {
    private int idProduto;
    private String nome;
    private String descricao;

    public Produto(int idProduto, String nome, String descricao) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.descricao = descricao;
    }

    public int pegarIdProduto() {
        return idProduto;
    }

    public String pegarNome() {
        return nome;
    }

    public String pegarDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return nome + " - " + descricao;
    }
}
