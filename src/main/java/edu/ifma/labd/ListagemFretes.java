package edu.ifma.labd;

import edu.ifma.labd.dao.FreteDAO;
import edu.ifma.labd.model.Frete;

import java.util.List;
import java.util.Scanner;

public class ListagemFretes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Solicita ID do cliente
        System.out.print("Digite o ID do cliente: ");
        Long clienteId = scanner.nextLong();

        // 2. Busca fretes no banco
        FreteDAO freteDAO = new FreteDAO();
        List<Frete> fretes = freteDAO.findByCliente(clienteId);

        // 3. Verifica resultados
        if (fretes.isEmpty()) {
            System.out.println("Nenhum frete encontrado para o cliente ID " + clienteId);
            return;
        }

        // 4. Exibe resultados
        System.out.println("\n===== FRETES DO CLIENTE ID " + clienteId + " =====");
        System.out.printf("%-10s | %-20s | %-10s | %-10s%n",
                "Código", "Descrição", "Peso (kg)", "Valor R$");
        System.out.println("---------------------------------------------------");

        fretes.forEach(frete -> {
            System.out.printf("%-10s | %-20s | %-10.2f | %-10.2f%n",
                    frete.getCodigo(),
                    frete.getDescricao(),
                    frete.getPesoTotal(),
                    frete.getValorFrete());
        });
    }
}