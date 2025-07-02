# Mini Sistema de Gestão de Transportadora com JPA/Hibernate
Feito para estudos de persistência com JPA/Hibernate e padrões de acesso a dados!

Este projeto implementa a camada de persistência de um pequeno sistema de gestão para transportadoras usando Java Persistence API (JPA) e Hibernate. Desenvolvido como atividade acadêmica Nathalia Andrade Froz (IFMA/Prof Joao Carlos Pinheiro) o sistema gerencia clientes, cidades e fretes, com cálculo automático de valores baseado em peso e taxas regionais.

## Principais recursos:
- Cadastro de clientes, cidades e fretes
- Cálculo automático de valores de frete (peso × valor fixo + taxa)
- Listagem de fretes por cliente
- Operações CRUD com DAO genérico e especializado
- Mapeamento ORM com relacionamentos 1:N e N:1

## Tecnologias:

- Java 24+
- JPA (Jakarta Persistence 3.1)
- Hibernate ORM 7.0
- MySQL 8.0
- Maven

## Estrutura do projeto:

- model/: Entidades JPA (Cliente, Cidade, Frete)

- dao/: Camada de acesso a dados com padrão DAO

- Testes funcionais por operação

- Configuração via persistence.xml

## Como funciona:

- Cadastra clientes e cidades

- Associa fretes a clientes existentes

- Calcula valores automaticamente

- Consulta fretes por id

  

https://github.com/user-attachments/assets/6100fb74-2568-4d0d-94b5-92ee997fab34



