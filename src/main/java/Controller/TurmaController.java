package Controller;

import Model.Professor;
import Model.Turma;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TurmaController {

    private Map<Long, Turma> turmas = new HashMap<>();
    private long proximoId = 1;

    public Turma criar(String serie, int anoLetivo, Professor professorRegente) {
        Turma turma = new Turma(serie, anoLetivo, professorRegente);
        turmas.put(proximoId, turma);
        proximoId++;
        return turma;
    }

    public Turma buscarPorId(long id) {
        return turmas.get(id);
    }

    public Turma buscarPorSerieEAno(String serie, int anoLetivo) {
        for (Turma turma : turmas.values()) {
            if (turma.getSerie().equalsIgnoreCase(serie) && turma.getAnoLetivo() == anoLetivo) {
                return turma;
            }
        }
        return null;
    }

    public List<Turma> listarTodas() {
        return new ArrayList<>(turmas.values());
    }

    public List<Turma> buscarPorAno(int anoLetivo) {
        return turmas.values().stream()
                .filter(t -> t.getAnoLetivo() == anoLetivo)
                .collect(Collectors.toList());
    }

    public boolean atualizar(long id, String serie, int anoLetivo, Professor professorRegente) {
        Turma turmaParaAtualizar = turmas.get(id);
        if (turmaParaAtualizar != null) {
            turmaParaAtualizar.setSerie(serie);
            turmaParaAtualizar.setAnoLetivo(anoLetivo);
            turmaParaAtualizar.setProfessorRegente(professorRegente);
            return true;
        }
        return false;
    }

    public boolean excluir(long id) {
        return turmas.remove(id) != null;
    }
}