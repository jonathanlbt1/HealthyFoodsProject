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
@Table(schema = "public", name = "produtos")
public class Produtos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProduto;

    @Column(name = "desc_produto")
    private String descProduto;

    @Column(name = "venda_produto")
    private String vendaProduto;

    @Column(name = "image_produto")
    private Byte[] imageProduto;

    @Column(name = "id_unidade")
    private Long idUnidade;

    @Column(name = "desc_unidade")
    private String descUnidade;

}
