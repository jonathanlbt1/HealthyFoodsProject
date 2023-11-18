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
    private Long idSubgrupo;

    private String descSubgrupo;
    private Long idCadImpressora;
    private Long idGrupo;
    private Long statusSubgrupo;

    @ManyToOne
    @JoinColumn(name = "group_id_grupo")
    private Grupos group;
}
