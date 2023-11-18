package com.example.healthyfoods.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "public", name = "subgrupo")
public class Subgrupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_subgrupo")
    private Long idSubgrupo;

    @Column(name = "desc_subgrupo")
    private String descSubgrupo;

    @Column(name = "id_cad_impressora")
    private Long idCadImpressora;

    @Column(name = "id_grupo")
    private Long idGrupo;

    @Column(name = "status_subgrupo")
    private Long statusSubgrupo;

    @ManyToOne
    @JoinColumn(name = "id_grupo", insertable = false, updatable = false)
    private Grupo grupos;
}
