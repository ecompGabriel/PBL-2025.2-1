package Controller;

import Model.Endereco;
import Model.Professor;
import Model.Turma;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TurmaControllerTest {

    private TurmaController turmaController;
    private Professor professorRegente;

    @BeforeEach
    void setUp() {
        turmaController = new TurmaController();
        Endereco end = new Endereco("Rua", "Bairro", "00000-000", "Cidade", "TS");
        professorRegente = new Professor("Prof. Regente", "01/01/1980", end, "Letras", "123456789");
    }

    @Test
    @DisplayName("Deve criar uma nova turma")
    void deveCriarTurma() {
        turmaController.criar("5º Ano A", 2025, professorRegente);
        assertEquals(1, turmaController.listarTodas().size());
    }

    @Test
    @DisplayName("Deve buscar uma turma pelo ID")
    void deveBuscarTurmaPeloId() {
        turmaController.criar("6º Ano B", 2025, professorRegente);
        Turma encontrada = turmaController.buscarPorId(1L);
        assertNotNull(encontrada);
        assertEquals("6º Ano B", encontrada.getSerie());
    }

    @Test
    @DisplayName("Deve buscar uma turma pela série e ano")
    void deveBuscarTurmaPelaSerieEAno() {
        turmaController.criar("7º Ano C", 2024, professorRegente);
        Turma encontrada = turmaController.buscarPorSerieEAno("7º Ano C", 2024);
        assertNotNull(encontrada);
        assertEquals(2024, encontrada.getAnoLetivo());
    }
}