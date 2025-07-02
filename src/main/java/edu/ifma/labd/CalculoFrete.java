package edu.ifma.labd;

import edu.ifma.labd.dao.FreteDAO;
import edu.ifma.labd.model.Frete;

import java.util.List;
import java.util.Scanner;

public class CalculoFrete {
    private static final Double VALOR_FIXO = 10.0;

    public static void main(String[] args) {
        // 1. Listar todos os fretes disponíveis
        FreteDAO freteDAO = new FreteDAO();
        List<Frete> todosFretes = freteDAO.findAll();

        if (todosFretes.isEmpty()) {
            System.out.println("Nenhum frete cadastrado!");
            return;
        }

        System.out.println("===== FRETES DISPONÍVEIS =====");
        for (Frete f : todosFretes) {
            System.out.println("ID: " + f.getId() + " | Código: " + f.getCodigo());
        }

        // 2. Pedir ao usuário para escolher um ID
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nDigite o ID do frete para recálculo: ");
        long idEscolhido = scanner.nextLong();

        // 3. Buscar o frete pelo ID escolhido
        Frete frete = freteDAO.findById(idEscolhido);

        if (frete == null) {
            System.out.println("Frete com ID " + idEscolhido + " não encontrado!");
            return;
        }



        // 4. Exibir detalhes ANTES do cálculo
        System.out.println("\n===== ANTES DO RECÁLCULO =====");
        exibirDetalhes(frete);

        // 5. Recalcular e atualizar
        frete.calcularValorFrete(VALOR_FIXO);
        freteDAO.update(frete);

        // 6. Exibir detalhes DEPOIS do cálculo
        System.out.println("\n===== APÓS RECÁLCULO =====");
        exibirDetalhes(frete);
    }

    private static void exibirDetalhes(Frete frete) {
        System.out.println("Código: " + frete.getCodigo());
        System.out.println("Descrição: " + frete.getDescricao());
        System.out.println("Peso: " + frete.getPesoTotal() + " kg");

        if (frete.getCidade() != null) {
            System.out.println("Cidade: " + frete.getCidade().getNome());
            System.out.println("Taxa da cidade: R$ " + frete.getCidade().getTaxaEntrega());
        } else {
            System.out.println("Cidade: Não associada");
        }

        System.out.println("Valor fixo por kg: R$ " + VALOR_FIXO);
        System.out.println("Valor frete: R$ " + frete.getValorFrete());
    }
}