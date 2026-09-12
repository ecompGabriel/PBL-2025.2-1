package Controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SistemaControllerTest {

    private SistemaController sistemaController;

    @BeforeEach
    void setUp() {
        sistemaController = new SistemaController();
    }

    @Test
    @DisplayName("Deve iniciar com o ano letivo de 2025")
    void deveIniciarEm2025() {
        assertEquals(2025, sistemaController.getAnoLetivoAtual());
    }

    @Test
    @DisplayName("Deve avançar para o próximo ano letivo")
    void deveAvancarAnoLetivo() {
        sistemaController.avancarAnoLetivo();
        assertEquals(2026, sistemaController.getAnoLetivoAtual());
    }

    @Test
    @DisplayName("Deve fornecer instâncias não nulas dos controllers")
    void deveFornecerControllers() {
        assertNotNull(sistemaController.getAlunoController());
        assertNotNull(sistemaController.getProfessorController());
        assertNotNull(sistemaController.getResponsavelController());
        assertNotNull(sistemaController.getTurmaController());
    }
}