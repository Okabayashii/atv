public class Produto {
    int id;
    String descricao;
    double valor;

    public Produto(int id, String descricao, double valor) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
    }

    public void exibir() {
        System.out.println("Código: " + id);
        System.out.println("Nome: " + descricao);
        System.out.println("Preço: R$ " + valor);
    }
}
