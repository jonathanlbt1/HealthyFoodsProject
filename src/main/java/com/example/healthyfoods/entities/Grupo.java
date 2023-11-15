package com.example.healthyfoods.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGrupo;

    private String descGrupo;
    private Long idImpressora;
    private Long pedeobsGrupo;
    private Long statusGrupo;
    private Long onlineGrupo;

    @Lob
    private Byte[] imagemGrupo;

    @OneToMany(mappedBy = "idGrupo")
    private List<SubGrupo> subGrupos;

}
