package com.example.healthyfoods.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "public", name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "estado")
    private String estado;

    @Column(name = "razao_cliente")
    private String razaoCliente;

    @Column(name = "fantasia_cliente")
    private String fantasiaCliente;

    @Column(name = "taxa_entrega_cliente")
    private String taxaEntregaCliente;

    @Column(name = "id_bairro")
    private String idBairro;

    @Column(name = "end_cliente")
    private String endCliente;

    @Column(name = "num_cliente")
    private String numCliente;

    @Column(name = "complemento_cliente")
    private String complementoCliente;

    @Column(name = "bairro_cliente")
    private String bairroCliente;

    @Column(name = "fone1_cliente")
    private String fone1Cliente;

    @Column(name = "cep_cliente")
    private String cepCliente;

}
