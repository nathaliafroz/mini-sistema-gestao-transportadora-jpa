package edu.ifma.labd;

import edu.ifma.labd.dao.GenericDAO;
import edu.ifma.labd.model.Cidade;

public class CadastroCidade {
    public static void main(String[] args) {
        Cidade cidade = new Cidade();
        cidade.setNome("Sao Paulo");
        cidade.setEstado("SP");
        cidade.setTaxaEntrega(12.0);

        GenericDAO<Cidade> cidadeDAO = new GenericDAO<>(Cidade.class);
        cidadeDAO.create(cidade);

        System.out.println("Cidade cadastrada com ID: " + cidade.getId());
    }
}