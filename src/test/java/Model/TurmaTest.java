package Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class TurmaTest {

    private Turma turma;
    private Professor professor;
    private Endereco endereco;

    @BeforeEach
    void setUp() {
        // Prepara objetos comuns que serão usados em múltiplos testes
        endereco = new Endereco("Rua Padrão", "Centro", "44000-000", "Feira de Santana", "BA");
        professor = new Professor("Prof. Silva", "10/10/1980", endereco, "Licenciatura", "75999998888");
        turma = new Turma("5ª Série", 2025, professor);
    }

    @Test
    void testConstrutorEGettersIniciais() {
        // Verifica se os valores passados no construtor foram atribuídos corretamente
        assertEquals("5ª Série", turma.getSerie());
        assertEquals(2025, turma.getAnoLetivo());
        assertEquals(professor, turma.getProfessorRegente());

        // Verifica se as listas foram inicializadas e estão vazias
        assertNotNull(turma.getAlunos());
        assertTrue(turma.getAlunos().isEmpty());
        assertNotNull(turma.getBoletins());
        assertTrue(turma.getBoletins().isEmpty());
    }

    @Test
    void testSetters() {
        // Testa os setters para os atributos simples
        turma.setSerie("6ª Série");
        assertEquals("6ª Série", turma.getSerie());

        turma.setAnoLetivo(2026);
        assertEquals(2026, turma.getAnoLetivo());

        // Testa o setter para um objeto associado (Professor)
        Professor novoProfessor = new Professor("Profa. Souza", "05/05/1985", endereco, "Pedagogia", "75988887777");
        turma.setProfessorRegente(novoProfessor);
        assertEquals(novoProfessor, turma.getProfessorRegente());

        // Testa o setter para a lista de Alunos
        List<Aluno> novaListaAlunos = new ArrayList<>();
        Aluno aluno = new Aluno("Joana", "03/03/2012", endereco, "Feirense");
        novaListaAlunos.add(aluno);
        turma.setAlunos(novaListaAlunos);

        assertEquals(novaListaAlunos, turma.getAlunos());
        assertEquals(1, turma.getAlunos().size());
        assertTrue(turma.getAlunos().contains(aluno));

        // Testa o setter para a lista de Boletins
        List<Boletim> novaListaBoletins = new ArrayList<>();
        Boletim boletim = new Boletim(aluno, turma, 2025, 8.0, 9.5, 10.0);
        novaListaBoletins.add(boletim);
        turma.setBoletins(novaListaBoletins);

        assertEquals(novaListaBoletins, turma.getBoletins());
        assertEquals(1, turma.getBoletins().size());
        assertTrue(turma.getBoletins().contains(boletim));
    }
}