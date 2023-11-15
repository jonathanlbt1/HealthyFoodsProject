package com.example.healthyfoods.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProduto;

    private String descProduto;
    private String vendaProduto;

    @Lob
    private Byte[] imageProduto;

    private Long idUnidade;
    private String descUnidade;

}
