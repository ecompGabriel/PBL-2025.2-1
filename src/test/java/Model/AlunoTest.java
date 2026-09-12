package Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AlunoTest {

    private Aluno aluno;
    private Endereco endereco;

    @BeforeEach
    void setUp() {
        endereco = new Endereco("Rua Teste", "Bairro Teste", "12345-000", "TesteCity", "TS");
        aluno = new Aluno("Criança Teste", "01/01/2015", endereco, "Tester");
    }

    @Test
    void testConstrutorEGettersIniciais() {
        // Verifica se o construtor inicializou os valores corretamente
        assertEquals("Criança Teste", aluno.getNome());
        assertEquals("01/01/2015", aluno.getDataNascimento());
        assertEquals(endereco, aluno.getEndereco());
        assertEquals("Tester", aluno.getNaturalidade());

        // Verifica se os objetos de associação estão nulos, como esperado
        assertNull(aluno.getResponsavel());
        assertNull(aluno.getProfessorPai());

        // Verifica se as listas foram inicializadas e estão vazias
        assertNotNull(aluno.getTurmas());
        assertTrue(aluno.getTurmas().isEmpty());
        assertNotNull(aluno.getBoletins());
        assertTrue(aluno.getBoletins().isEmpty());
    }

    @Test
    void testSetters() {
        // Testa o setNaturalidade
        aluno.setNaturalidade("Brasileira");
        assertEquals("Brasileira", aluno.getNaturalidade());

        // Testa o setResponsavel
        Responsavel responsavel = new Responsavel("Responsável Teste", "02/02/1990", endereco, "1111-1111");
        aluno.setResponsavel(responsavel);
        assertEquals(responsavel, aluno.getResponsavel());

        // Testa o setProfessorPai
        Professor professorPai = new Professor("Professor Pai Teste", "03/03/1985", endereco, "Doutorado", "2222-2222");
        aluno.setProfessorPai(professorPai);
        assertEquals(professorPai, aluno.getProfessorPai());

        // Importante: O teste agora não verifica se setResponsavel anula professorPai (ou vice-versa).
        // Essa regra de negócio foi movida para o Controller e deve ser testada lá.
        assertNotNull(aluno.getResponsavel());
        assertNotNull(aluno.getProfessorPai());
    }
}