package Model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PessoaTest {

    @Test
    void testConstrutorEGetters() {
        Endereco endereco = new Endereco("Rua A", "Bairro B", "12345-678", "Cidade C", "Estado D");
        Pessoa pessoa = new Pessoa("João da Silva", "01/01/1990", endereco);

        assertEquals("João da Silva", pessoa.getNome());
        assertEquals("01/01/1990", pessoa.getDataNascimento());
        assertEquals(endereco, pessoa.getEndereco());
    }

    @Test
    void testSetters() {
        Endereco endereco1 = new Endereco("Rua 1", "Bairro 1", "11111-111", "Cidade 1", "E1");
        Endereco endereco2 = new Endereco("Rua 2", "Bairro 2", "22222-222", "Cidade 2", "E2");
        Pessoa pessoa = new Pessoa("Nome Antigo", "10/10/2000", endereco1);

        pessoa.setNome("Nome Novo");
        pessoa.setDataNascimento("12/12/2012");
        pessoa.setEndereco(endereco2);

        assertEquals("Nome Novo", pessoa.getNome());
        assertEquals("12/12/2012", pessoa.getDataNascimento());
        assertEquals(endereco2, pessoa.getEndereco());
    }
}