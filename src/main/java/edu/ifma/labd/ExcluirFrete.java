package edu.ifma.labd;

import edu.ifma.labd.dao.FreteDAO;

public class ExcluirFrete {
    public static void main(String[] args) {
        FreteDAO freteDAO = new FreteDAO();
        freteDAO.delete(1L); // Substitua pelo ID do frete incorreto
        System.out.println("Frete excluído com sucesso!");
    }
}