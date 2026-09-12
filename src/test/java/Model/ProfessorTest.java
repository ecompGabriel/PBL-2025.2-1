package Model;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ProfessorTest {

    @Test
    void testConstrutorGettersAndSetters() {
        // 1. Preparação (Arrange)
        Endereco endereco = new Endereco("Rua P", "Bairro P", "CEP P", "Cidade P", "EP");
        Professor professor = new Professor("Prof. Carlos", "10/05/1985", endereco, "Matemática", "987654321");

        // 2. Ação e Verificação (Act & Assert) - Construtor e Getters
        assertEquals("Prof. Carlos", professor.getNome());
        assertEquals("Matemática", professor.getFormacao());
        assertEquals("987654321", professor.getTelefone());
        assertNotNull(professor.getDependentes());
        assertTrue(professor.getDependentes().isEmpty());

        // 3. Ação e Verificação (Act & Assert) - Setters
        professor.setFormacao("Física");
        assertEquals("Física", professor.getFormacao());

        professor.setTelefone("111222333");
        assertEquals("111222333", professor.getTelefone());

        List<Aluno> novaListaDependentes = new ArrayList<>();
        Aluno dependente = new Aluno("Filho do Prof", "15/06/2011", endereco, "Brasileira");
        novaListaDependentes.add(dependente);

        professor.setDependentes(novaListaDependentes);
        assertEquals(1, professor.getDependentes().size());
        assertTrue(professor.getDependentes().contains(dependente));
        assertEquals(novaListaDependentes, professor.getDependentes());
    }
}