package com.example.healthyfoods.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.healthyfoods.entities.Grupos;
import com.example.healthyfoods.entities.Subgrupo;
import com.example.healthyfoods.repositories.SubGrupoRepository;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {SubGrupoServiceImpl.class})
@ExtendWith(SpringExtension.class)
class SubGrupoServiceImplDiffblueTest {
    @MockBean
    private SubGrupoRepository subGrupoRepository;

    @Autowired
    private SubGrupoServiceImpl subGrupoServiceImpl;

    /**
     * Method under test: {@link SubGrupoServiceImpl#novoSubgrupo(Subgrupo)}
     */
    @Test
    void testNovoSubgrupo() {
        Grupos group = new Grupos();
        group.setDescGrupo("Desc Grupo");
        group.setIdGrupo(1L);
        group.setIdImpressora(1L);
        group.setImagemGrupo(new Byte[]{'A'});
        group.setOnlineGrupo(1L);
        group.setPedeobsGrupo(1L);
        group.setStatusGrupo(1L);
        group.setSubGrupos(new ArrayList<>());

        Subgrupo subgrupo = new Subgrupo();
        subgrupo.setDescSubgrupo("Desc Subgrupo");
        subgrupo.setGroup(group);
        subgrupo.setIdCadImpressora(1L);
        subgrupo.setIdGrupo(1L);
        subgrupo.setIdSubgrupo(1L);
        subgrupo.setStatusSubgrupo(1L);
        Subgrupo actualNovoSubgrupoResult = subGrupoServiceImpl.novoSubgrupo(subgrupo);
        assertEquals("Desc Subgrupo", actualNovoSubgrupoResult.getDescSubgrupo());
        assertEquals(1L, actualNovoSubgrupoResult.getIdCadImpressora().longValue());
        assertEquals(1L, actualNovoSubgrupoResult.getIdGrupo().longValue());
        assertEquals(1L, actualNovoSubgrupoResult.getStatusSubgrupo().longValue());
    }

    /**
     * Method under test: {@link SubGrupoServiceImpl#novoSubgrupo(Subgrupo)}
     */
    @Test
    void testNovoSubgrupo2() {
        Grupos group = new Grupos();
        group.setDescGrupo("Desc Grupo");
        group.setIdGrupo(1L);
        group.setIdImpressora(1L);
        group.setImagemGrupo(new Byte[]{'A'});
        group.setOnlineGrupo(1L);
        group.setPedeobsGrupo(1L);
        group.setStatusGrupo(1L);
        group.setSubGrupos(new ArrayList<>());
        Subgrupo subgrupo = mock(Subgrupo.class);
        when(subgrupo.getIdCadImpressora()).thenReturn(1L);
        when(subgrupo.getIdGrupo()).thenReturn(1L);
        when(subgrupo.getStatusSubgrupo()).thenReturn(1L);
        when(subgrupo.getDescSubgrupo()).thenReturn("Desc Subgrupo");
        doNothing().when(subgrupo).setDescSubgrupo(Mockito.<String>any());
        doNothing().when(subgrupo).setGroup(Mockito.<Grupos>any());
        doNothing().when(subgrupo).setIdCadImpressora(Mockito.<Long>any());
        doNothing().when(subgrupo).setIdGrupo(Mockito.<Long>any());
        doNothing().when(subgrupo).setIdSubgrupo(Mockito.<Long>any());
        doNothing().when(subgrupo).setStatusSubgrupo(Mockito.<Long>any());
        subgrupo.setDescSubgrupo("Desc Subgrupo");
        subgrupo.setGroup(group);
        subgrupo.setIdCadImpressora(1L);
        subgrupo.setIdGrupo(1L);
        subgrupo.setIdSubgrupo(1L);
        subgrupo.setStatusSubgrupo(1L);
        Subgrupo actualNovoSubgrupoResult = subGrupoServiceImpl.novoSubgrupo(subgrupo);
        verify(subgrupo).getDescSubgrupo();
        verify(subgrupo).getIdCadImpressora();
        verify(subgrupo).getIdGrupo();
        verify(subgrupo).getStatusSubgrupo();
        verify(subgrupo).setDescSubgrupo(Mockito.<String>any());
        verify(subgrupo).setGroup(Mockito.<Grupos>any());
        verify(subgrupo).setIdCadImpressora(Mockito.<Long>any());
        verify(subgrupo).setIdGrupo(Mockito.<Long>any());
        verify(subgrupo).setIdSubgrupo(Mockito.<Long>any());
        verify(subgrupo).setStatusSubgrupo(Mockito.<Long>any());
        assertEquals("Desc Subgrupo", actualNovoSubgrupoResult.getDescSubgrupo());
        assertEquals(1L, actualNovoSubgrupoResult.getIdCadImpressora().longValue());
        assertEquals(1L, actualNovoSubgrupoResult.getIdGrupo().longValue());
        assertEquals(1L, actualNovoSubgrupoResult.getStatusSubgrupo().longValue());
    }

    /**
     * Method under test: {@link SubGrupoServiceImpl#lerUmSubgrupo(Integer)}
     */
    @Test
    void testLerUmSubgrupo() {
        Grupos group = new Grupos();
        group.setDescGrupo("Desc Grupo");
        group.setIdGrupo(1L);
        group.setIdImpressora(1L);
        group.setImagemGrupo(new Byte[]{'A'});
        group.setOnlineGrupo(1L);
        group.setPedeobsGrupo(1L);
        group.setStatusGrupo(1L);
        group.setSubGrupos(new ArrayList<>());

        Subgrupo subGrupo = new Subgrupo();
        subGrupo.setDescSubgrupo("Desc Subgrupo");
        subGrupo.setGroup(group);
        subGrupo.setIdCadImpressora(1L);
        subGrupo.setIdGrupo(1L);
        subGrupo.setIdSubgrupo(1L);
        subGrupo.setStatusSubgrupo(1L);
        Optional<Subgrupo> ofResult = Optional.of(subGrupo);
        when(subGrupoRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
        Subgrupo actualLerUmSubgrupoResult = subGrupoServiceImpl.lerUmSubgrupo(1);
        verify(subGrupoRepository).findById(Mockito.<Integer>any());
        assertSame(subGrupo, actualLerUmSubgrupoResult);
    }

    /**
     * Method under test: {@link SubGrupoServiceImpl#atualizarSubgrupo(Integer)}
     */
    @Test
    void testAtualizarSubgrupo() {
        Grupos group = new Grupos();
        group.setDescGrupo("Desc Grupo");
        group.setIdGrupo(1L);
        group.setIdImpressora(1L);
        group.setImagemGrupo(new Byte[]{'A'});
        group.setOnlineGrupo(1L);
        group.setPedeobsGrupo(1L);
        group.setStatusGrupo(1L);
        group.setSubGrupos(new ArrayList<>());

        Subgrupo subGrupo = new Subgrupo();
        subGrupo.setDescSubgrupo("Desc Subgrupo");
        subGrupo.setGroup(group);
        subGrupo.setIdCadImpressora(1L);
        subGrupo.setIdGrupo(1L);
        subGrupo.setIdSubgrupo(1L);
        subGrupo.setStatusSubgrupo(1L);
        Optional<Subgrupo> ofResult = Optional.of(subGrupo);
        when(subGrupoRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
        Subgrupo actualAtualizarSubgrupoResult = subGrupoServiceImpl.atualizarSubgrupo(1);
        verify(subGrupoRepository).findById(Mockito.<Integer>any());
        assertEquals("Desc Subgrupo", actualAtualizarSubgrupoResult.getDescSubgrupo());
        assertEquals(1L, actualAtualizarSubgrupoResult.getIdCadImpressora().longValue());
        assertEquals(1L, actualAtualizarSubgrupoResult.getIdGrupo().longValue());
        assertEquals(1L, actualAtualizarSubgrupoResult.getStatusSubgrupo().longValue());
    }

    /**
     * Method under test: {@link SubGrupoServiceImpl#deletarSubgrupo(Integer)}
     */
    @Test
    void testDeletarSubgrupo() {
        doNothing().when(subGrupoRepository).deleteById(Mockito.<Integer>any());
        subGrupoServiceImpl.deletarSubgrupo(1);
        verify(subGrupoRepository).deleteById(Mockito.<Integer>any());
    }
}
