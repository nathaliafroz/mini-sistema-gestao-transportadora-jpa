package edu.ifma.labd;

import edu.ifma.labd.dao.FreteDAO;
import edu.ifma.labd.model.Frete;

import java.util.List;

public class ListarTodosFretes {
    public static void main(String[] args) {
        FreteDAO freteDAO = new FreteDAO();
        List<Frete> fretes = freteDAO.findAll();

        System.out.println("===== TODOS OS FRETES =====");
        System.out.printf("%-5s | %-15s | %-20s | %-10s | %-10s%n",
                "ID", "Código", "Descrição", "Peso (kg)", "Valor R$");
        System.out.println("---------------------------------------------------------------");

        for (Frete frete : fretes) {
            System.out.printf("%-5d | %-15s | %-20s | %-10.2f | %-10.2f%n",
                    frete.getId(),
                    frete.getCodigo(),
                    frete.getDescricao(),
                    frete.getPesoTotal(),
                    frete.getValorFrete());
        }
    }
}