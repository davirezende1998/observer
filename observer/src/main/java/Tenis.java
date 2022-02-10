import java.util.Observable;

public class Tenis extends Observable{
    private String tamanho;
    private String cor;
    private String nome;

    public Tenis(String tamanho, String nome, String cor) {
        this.tamanho = tamanho;
        this.cor = cor;
        this.nome = nome;
    }

    public void atualizarEstoque() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        String retorno = "Tênis " + nome + ", cor " + cor + ", tamanho " + tamanho;
        return retorno;
    }
}