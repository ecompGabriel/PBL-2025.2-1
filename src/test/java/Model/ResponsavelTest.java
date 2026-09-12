package Model;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ResponsavelTest {

    @Test
    void testConstrutorGettersAndSetters() {
        // 1. Preparação (Arrange)
        Endereco endereco = new Endereco("Rua R", "Bairro R", "CEP R", "Cidade R", "ER");
        Responsavel responsavel = new Responsavel("Sra. Maria", "20/08/1988", endereco, "123456789");

        // 2. Ação e Verificação (Act & Assert) - Construtor e Getters
        assertEquals("Sra. Maria", responsavel.getNome());
        assertEquals("123456789", responsavel.getTelefone());
        assertNotNull(responsavel.getDependentes());
        assertTrue(responsavel.getDependentes().isEmpty());

        // 3. Ação e Verificação (Act & Assert) - Setters
        responsavel.setTelefone("987654321");
        assertEquals("987654321", responsavel.getTelefone());

        List<Aluno> novaListaDependentes = new ArrayList<>();
        Aluno dependente = new Aluno("Filha da Resp", "25/09/2012", endereco, "Brasileira");
        novaListaDependentes.add(dependente);

        responsavel.setDependentes(novaListaDependentes);
        assertEquals(1, responsavel.getDependentes().size());
        assertTrue(responsavel.getDependentes().contains(dependente));
        assertEquals(novaListaDependentes, responsavel.getDependentes());
    }
}