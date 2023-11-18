package com.example.healthyfoods.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Table(schema = "public", name = "grupos")
public class Grupos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGrupo;

    @Column(name = "desc_grupo")
    private String descGrupo;

    @Column(name = "id_impressora")
    private Long idImpressora;

    @Column(name = "pedeobs_grupo")
    private Long pedeobsGrupo;

    @Column(name = "status_grupo")
    private Long statusGrupo;

    @Column(name = "online_grupo")
    private Long onlineGrupo;

    @Column(name = "imagem_grupo")
    private Byte[] imagemGrupo;

    @OneToMany(mappedBy = "idGrupo")
    private List<Subgrupo> subGrupos;

}
