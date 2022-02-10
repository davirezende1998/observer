import java.util.Observable;
import java.util.Observer;

public class Cliente implements Observer {
    private String nome;
    private String ultimaNotificacao;

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void manifestarInteresse(Tenis tenis) {
        tenis.addObserver(this);
    }

    public void update(Observable tenis, Object arg1) {
        this.ultimaNotificacao = "Prezado(a) " + this.nome + ", o produto " + tenis.toString() + ", está disponível!";
    }
}