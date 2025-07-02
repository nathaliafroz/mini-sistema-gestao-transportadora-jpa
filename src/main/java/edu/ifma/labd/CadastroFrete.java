package edu.ifma.labd;

import edu.ifma.labd.dao.FreteDAO;
import edu.ifma.labd.dao.GenericDAO;
import edu.ifma.labd.model.Cidade;
import edu.ifma.labd.model.Cliente;
import edu.ifma.labd.model.Frete;

public class CadastroFrete {
    private static final Double VALOR_FIXO = 10.0;

    public static void main(String[] args) {

        GenericDAO<Cliente> clienteDAO = new GenericDAO<>(Cliente.class);
        Cliente cliente = clienteDAO.findById(11L);


        GenericDAO<Cidade> cidadeDAO = new GenericDAO<>(Cidade.class);
        Cidade cidade = cidadeDAO.findById(11L);

        Frete frete = new Frete();
        frete.setCodigo("JUN-2025-228");
        frete.setDescricao("Mesa");
        frete.setPesoTotal(2.0);
        frete.setCliente(cliente);
        frete.setCidade(cidade);
        frete.calcularValorFrete(VALOR_FIXO);

        FreteDAO freteDAO = new FreteDAO();
        freteDAO.create(frete);

        System.out.println("Frete cadastrado:");
        System.out.println("Código: " + frete.getCodigo());
        System.out.println("Valor: R$ " + frete.getValorFrete());
    }
}