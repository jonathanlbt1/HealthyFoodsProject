package com.example.healthyfoods.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    private String cidade;
    private String estado;
    private Integer idCliente;
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
