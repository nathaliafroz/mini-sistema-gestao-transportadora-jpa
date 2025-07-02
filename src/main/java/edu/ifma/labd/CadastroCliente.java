package edu.ifma.labd;

import edu.ifma.labd.dao.GenericDAO;
import edu.ifma.labd.model.Cliente;

public class CadastroCliente {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setNome("Carlos");
        cliente.setEndereco("Rua Azul");
        cliente.setTelefone("(98) 2345- 7869");

        GenericDAO<Cliente> clienteDAO = new GenericDAO<>(Cliente.class);
        clienteDAO.create(cliente);

        System.out.println("Cliente cadastrado com ID: " + cliente.getId());
    }
}