package com.example.healthyfoods.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Base64;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Produto {

    private String descProduto;
    private Integer idProduto;
    private String vendaProduto;
    private Base64 imageProduto;
    private Integer idUnidade;
    private String descUnidade;

}
