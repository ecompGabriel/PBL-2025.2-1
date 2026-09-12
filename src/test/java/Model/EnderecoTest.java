package Model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EnderecoTest {

    @Test
    void testConstrutorEGetters() {
        Endereco endereco = new Endereco("Rua Principal", "Centro", "44001-100", "Feira de Santana", "BA");

        assertEquals("Rua Principal", endereco.getRua());
        assertEquals("Centro", endereco.getBairro());
        assertEquals("44001-100", endereco.getCep());
        assertEquals("Feira de Santana", endereco.getCidade());
        assertEquals("BA", endereco.getEstado());
    }

    @Test
    void testSetters() {
        Endereco endereco = new Endereco("Rua Antiga", "Bairro Velho", "00000-000", "Cidade Velha", "XX");

        endereco.setRua("Rua Nova");
        endereco.setBairro("Bairro Novo");
        endereco.setCep("11111-111");
        endereco.setCidade("Cidade Nova");
        endereco.setEstado("NN");

        assertEquals("Rua Nova", endereco.getRua());
        assertEquals("Bairro Novo", endereco.getBairro());
        assertEquals("11111-111", endereco.getCep());
        assertEquals("Cidade Nova", endereco.getCidade());
        assertEquals("NN", endereco.getEstado());
    }
}