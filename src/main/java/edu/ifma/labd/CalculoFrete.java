package edu.ifma.labd;

import edu.ifma.labd.dao.FreteDAO;
import edu.ifma.labd.model.Frete;

public class CalculoFrete {
    private static final Double VALOR_FIXO = 10.0;

    public static void main(String[] args) {
        // 1. Recupera um frete existente do banco de dados
        FreteDAO freteDAO = new FreteDAO();
        Frete frete = freteDAO.findById(1L); // Supondo ID 1 (deve ser um ID existente)

        // 2. Recalcula o valor (demonstrando a lógica de negócio)
        frete.calcularValorFrete(VALOR_FIXO);

        // 3. Atualiza o frete no banco (opcional, conforme requisitos)
        freteDAO.update(frete);

        // 4. Exibe os detalhes do cálculo
        System.out.println("===== DETALHES DO CÁLCULO =====");
        System.out.println("Frete: " + frete.getCodigo());
        System.out.println("Peso: " + frete.getPesoTotal() + " kg");
        System.out.println("Taxa da cidade (" + frete.getCidade().getNome() + "): R$ " + frete.getCidade().getTaxaEntrega());
        System.out.println("Valor fixo por kg: R$ " + VALOR_FIXO);
        System.out.println("--------------------------------");
        System.out.println("Valor total recalculado: R$ " + frete.getValorFrete());
    }
}