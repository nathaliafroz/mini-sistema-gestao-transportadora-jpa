package edu.ifma.labd.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
public @Data class Frete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;
    private String descricao;
    private Double pesoTotal;
    private Double valorFrete;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "cidade_id", nullable = false)
    private Cidade cidade;

    // Metodo para calcular o valor do frete
    public void calcularValorFrete(Double valorFixo) {
        if (pesoTotal == null || cidade == null || cidade.getTaxaEntrega() == null) {
            throw new IllegalStateException("Dados incompletos para cálculo do frete");
        }
        this.valorFrete = (pesoTotal * valorFixo) + cidade.getTaxaEntrega();
    }


}