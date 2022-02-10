import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {
    @Test
    void deveAvisarCliente() {
        Tenis tenis = new Tenis("42", "Nike Air Max", "azul");
        Cliente cliente = new Cliente("Davi");
        cliente.manifestarInteresse(tenis);
        tenis.atualizarEstoque();
        assertEquals("Prezado(a) Davi, o produto Tênis Nike Air Max, cor azul, tamanho 42, está disponível!", cliente.getUltimaNotificacao());
    }

    @Test
    void deveAvisarClientes() {
        Tenis tenis = new Tenis("42", "Nike Air Max", "azul");
        Cliente cliente1 = new Cliente("Davi");
        cliente1.manifestarInteresse(tenis);
        Cliente cliente2 = new Cliente("Marco Antônio");
        cliente2.manifestarInteresse(tenis);
        tenis.atualizarEstoque();
        assertEquals("Prezado(a) Davi, o produto Tênis Nike Air Max, cor azul, tamanho 42, está disponível!", cliente1.getUltimaNotificacao());
        assertEquals("Prezado(a) Marco Antônio, o produto Tênis Nike Air Max, cor azul, tamanho 42, está disponível!", cliente2.getUltimaNotificacao());
    }

    @Test
    void naoDeveAvisarCliente() {
        Tenis tenis = new Tenis("42", "Nike Air Max", "azul");
        Cliente cliente = new Cliente("Davi");
        tenis.atualizarEstoque();
        assertEquals(null, cliente.getUltimaNotificacao());
    }

    @Test
    void deveAvisarApenasUmCliente() {
        Tenis tenis1 = new Tenis("42", "Nike Air Max", "azul");
        Cliente cliente1 = new Cliente("Davi");
        cliente1.manifestarInteresse(tenis1);
        Tenis tenis2 = new Tenis("41", "Adidas Ultraboost", "branco");
        Cliente cliente2 = new Cliente("Marco Antônio");
        cliente2.manifestarInteresse(tenis2);
        tenis1.atualizarEstoque();
        assertEquals("Prezado(a) Davi, o produto Tênis Nike Air Max, cor azul, tamanho 42, está disponível!", cliente1.getUltimaNotificacao());
        assertEquals(null, cliente2.getUltimaNotificacao());
    }
}