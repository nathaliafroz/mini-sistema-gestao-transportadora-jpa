package edu.ifma.labd;

import edu.ifma.labd.dao.GenericDAO;
import edu.ifma.labd.model.Cliente;

public class CadastroCliente {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setNome("Transportes Maranhão");
        cliente.setEndereco("Rua das Palmeiras, 456");
        cliente.setTelefone("(98) 3232-1212");

        GenericDAO<Cliente> clienteDAO = new GenericDAO<>(Cliente.class);
        clienteDAO.create(cliente);

        System.out.println("Cliente cadastrado com ID: " + cliente.getId());
    }
}