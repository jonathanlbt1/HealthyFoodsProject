package com.example.healthyfoods.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    private String cidade;
    private String estado;
    private String razaoCliente;
    private String fantasiaCliente;
    private String taxaEntregaCliente;
    private String idBairro;
    private String endCliente;
    private String numCliente;
    private String complementoCliente;
    private String bairroCliente;
    private String fone1Cliente;
    private String cepCliente;



}
