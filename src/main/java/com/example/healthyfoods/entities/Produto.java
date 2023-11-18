package com.example.healthyfoods.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "public", name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Long idProduto;

    @Column(name = "desc_produto")
    private String descProduto;

    @Column(name = "venda_produto")
    private String vendaProduto;

    @Column(name = "imagem_produto")
    private Byte[] imageProduto;

    @Column(name = "id_unidade")
    private Long idUnidade;

    @Column(name = "desc_unidade")
    private String descUnidade;

}
