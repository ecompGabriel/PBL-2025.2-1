package View;

import Controller.SistemaController;
import java.util.Scanner;

/**
 * Ponto de entrada do sistema escolar.
 * Apresenta um menu simples para consultar o resumo do sistema
 * e avançar o ano letivo.
 */
public class Main {

    public static void main(String[] args) {
        SistemaController sistema = new SistemaController();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            exibirMenu(sistema);
            opcao = lerOpcao(scanner);

            switch (opcao) {
                case 1 -> exibirResumo(sistema);
                case 2 -> sistema.avancarAnoLetivo();
                case 0 -> System.out.println("Encerrando o sistema.");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void exibirMenu(SistemaController sistema) {
        System.out.println("\n=== Sistema Escolar ===");
        System.out.println("Ano letivo: " + sistema.getAnoLetivoAtual());
        System.out.println("1 - Exibir resumo");
        System.out.println("2 - Avançar ano letivo");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static int lerOpcao(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Digite um número válido: ");
            scanner.nextLine();
        }
        int opcao = scanner.nextInt();
        scanner.nextLine();
        return opcao;
    }

    private static void exibirResumo(SistemaController sistema) {
        int alunos = sistema.getAlunoController().listarTodos().size();
        int professores = sistema.getProfessorController().listarTodos().size();
        int responsaveis = sistema.getResponsavelController().listarTodos().size();
        int turmas = sistema.getTurmaController().listarTodas().size();

        System.out.println("\n--- Resumo ---");
        System.out.println("Alunos: " + alunos);
        System.out.println("Professores: " + professores);
        System.out.println("Responsáveis: " + responsaveis);
        System.out.println("Turmas: " + turmas);
    }
}
