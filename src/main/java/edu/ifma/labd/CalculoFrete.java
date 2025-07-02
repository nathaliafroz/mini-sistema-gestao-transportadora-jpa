package edu.ifma.labd;

import edu.ifma.labd.dao.FreteDAO;
import edu.ifma.labd.model.Frete;

import java.util.Scanner;

public class CalculoFrete {
    private static final Double VALOR_FIXO = 10.0;

    public static void main(String[] args) {
        // 1. Listar fretes disponíveis
        System.out.println("===== FRETES DISPONÍVEIS =====");
        new ListarTodosFretes().main(null);  // Reusa a classe de listagem

        // 2. Solicitar ID correto
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nDigite o ID do frete para recálculo: ");
        Long freteId = scanner.nextLong();

        // 3. Buscar com relacionamentos
        FreteDAO freteDAO = new FreteDAO();
        Frete frete = freteDAO.findByIdWithRelations(freteId);

        if (frete == null) {
            System.out.println("Frete com ID " + freteId + " não encontrado!");
            return;
        }

        // 4. Recalcular e exibir
        System.out.println("\n===== ANTES DO RECÁLCULO =====");
        exibirDetalhes(frete);

        frete.calcularValorFrete(VALOR_FIXO);
        freteDAO.update(frete);

        System.out.println("\n===== APÓS RECÁLCULO =====");
        exibirDetalhes(frete);
    }

    private static void exibirDetalhes(Frete frete) {
        System.out.println("ID: " + frete.getId());
        System.out.println("Código: " + frete.getCodigo());
        System.out.println("Descrição: " + frete.getDescricao());
        System.out.println("Peso: " + frete.getPesoTotal() + " kg");

        if (frete.getCidade() != null) {
            System.out.println("Cidade: " + frete.getCidade().getNome() +
                    " (Taxa: R$ " + frete.getCidade().getTaxaEntrega() + ")");
        } else {
            System.out.println("Cidade: N/A");
        }

        System.out.println("Valor fixo por kg: R$ " + VALOR_FIXO);
        System.out.println("Valor frete: R$ " + frete.getValorFrete());
        System.out.println("--------------------------------");
    }
}