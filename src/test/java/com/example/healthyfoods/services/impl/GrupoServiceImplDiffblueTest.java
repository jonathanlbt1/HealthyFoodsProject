package com.example.healthyfoods.services.impl;

import com.example.healthyfoods.entities.Grupos;
import com.example.healthyfoods.entities.Subgrupo;
import com.example.healthyfoods.repositories.GrupoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ContextConfiguration(classes = {GrupoServiceImpl.class})
@ExtendWith(SpringExtension.class)
class GrupoServiceImplDiffblueTest {
    @MockBean
    private GrupoRepository grupoRepository;

    @Autowired
    private GrupoServiceImpl grupoServiceImpl;

    /**
     * Method under test: {@link GrupoServiceImpl#novoGrupo(Grupos)}
     */
    @Test
    void testNovoGrupo() {
        Grupos grupo = new Grupos();
        grupo.setDescGrupo("Desc Grupo");
        grupo.setIdGrupo(1L);
        grupo.setIdImpressora(1L);
        grupo.setImagemGrupo(new Byte[]{'A'});
        grupo.setOnlineGrupo(1L);
        grupo.setPedeobsGrupo(1L);
        grupo.setStatusGrupo(1L);
        grupo.setSubGrupos(new ArrayList<>());
        Grupos actualNovoGrupoResult = grupoServiceImpl.novoGrupo(grupo);
        assertEquals("Desc Grupo", actualNovoGrupoResult.getDescGrupo());
        assertEquals(1L, actualNovoGrupoResult.getIdImpressora().longValue());
        assertEquals(1L, actualNovoGrupoResult.getOnlineGrupo().longValue());
        assertEquals(1L, actualNovoGrupoResult.getStatusGrupo().longValue());
        assertTrue(actualNovoGrupoResult.getSubGrupos().isEmpty());
        assertArrayEquals(new Byte[]{'A'}, actualNovoGrupoResult.getImagemGrupo());
    }

    /**
     * Method under test: {@link GrupoServiceImpl#novoGrupo(Grupos)}
     */
    @Test
    void testNovoGrupo2() {
        Grupos grupo = mock(Grupos.class);
        when(grupo.getImagemGrupo()).thenReturn(new Byte[]{'A'});
        when(grupo.getIdImpressora()).thenReturn(1L);
        when(grupo.getOnlineGrupo()).thenReturn(1L);
        when(grupo.getStatusGrupo()).thenReturn(1L);
        when(grupo.getDescGrupo()).thenReturn("Desc Grupo");
        when(grupo.getSubGrupos()).thenReturn(new ArrayList<>());
        doNothing().when(grupo).setDescGrupo(Mockito.<String>any());
        doNothing().when(grupo).setIdGrupo(Mockito.<Long>any());
        doNothing().when(grupo).setIdImpressora(Mockito.<Long>any());
        doNothing().when(grupo).setImagemGrupo(Mockito.<Byte[]>any());
        doNothing().when(grupo).setOnlineGrupo(Mockito.<Long>any());
        doNothing().when(grupo).setPedeobsGrupo(Mockito.<Long>any());
        doNothing().when(grupo).setStatusGrupo(Mockito.<Long>any());
        doNothing().when(grupo).setSubGrupos(Mockito.<List<Subgrupo>>any());
        grupo.setDescGrupo("Desc Grupo");
        grupo.setIdGrupo(1L);
        grupo.setIdImpressora(1L);
        grupo.setImagemGrupo(new Byte[]{'A'});
        grupo.setOnlineGrupo(1L);
        grupo.setPedeobsGrupo(1L);
        grupo.setStatusGrupo(1L);
        grupo.setSubGrupos(new ArrayList<>());
        Grupos actualNovoGrupoResult = grupoServiceImpl.novoGrupo(grupo);
        verify(grupo).getDescGrupo();
        verify(grupo).getIdImpressora();
        verify(grupo).getImagemGrupo();
        verify(grupo).getOnlineGrupo();
        verify(grupo, atLeast(1)).getStatusGrupo();
        verify(grupo).getSubGrupos();
        verify(grupo).setDescGrupo(Mockito.<String>any());
        verify(grupo).setIdGrupo(Mockito.<Long>any());
        verify(grupo).setIdImpressora(Mockito.<Long>any());
        verify(grupo).setImagemGrupo(Mockito.<Byte[]>any());
        verify(grupo).setOnlineGrupo(Mockito.<Long>any());
        verify(grupo).setPedeobsGrupo(Mockito.<Long>any());
        verify(grupo).setStatusGrupo(Mockito.<Long>any());
        verify(grupo).setSubGrupos(Mockito.<List<Subgrupo>>any());
        assertEquals("Desc Grupo", actualNovoGrupoResult.getDescGrupo());
        assertEquals(1L, actualNovoGrupoResult.getIdImpressora().longValue());
        assertEquals(1L, actualNovoGrupoResult.getOnlineGrupo().longValue());
        assertEquals(1L, actualNovoGrupoResult.getStatusGrupo().longValue());
        assertTrue(actualNovoGrupoResult.getSubGrupos().isEmpty());
        assertArrayEquals(new Byte[]{'A'}, actualNovoGrupoResult.getImagemGrupo());
    }

    /**
     * Method under test: {@link GrupoServiceImpl#lerUmGrupo(Integer)}
     */
    @Test
    void testLerUmGrupo() {
        Grupos grupo = new Grupos();
        grupo.setDescGrupo("Desc Grupo");
        grupo.setIdGrupo(1L);
        grupo.setIdImpressora(1L);
        grupo.setImagemGrupo(new Byte[]{'A'});
        grupo.setOnlineGrupo(1L);
        grupo.setPedeobsGrupo(1L);
        grupo.setStatusGrupo(1L);
        grupo.setSubGrupos(new ArrayList<>());
        Optional<Grupos> ofResult = Optional.of(grupo);
        when(grupoRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
        Grupos actualLerUmGrupoResult = grupoServiceImpl.lerUmGrupo(1);
        verify(grupoRepository).findById(Mockito.<Integer>any());
        assertSame(grupo, actualLerUmGrupoResult);
    }

    /**
     * Method under test: {@link GrupoServiceImpl#atualizarGrupo(Integer)}
     */
    @Test
    void testAtualizarGrupo() {
        Grupos grupo = new Grupos();
        grupo.setDescGrupo("Desc Grupo");
        grupo.setIdGrupo(1L);
        grupo.setIdImpressora(1L);
        grupo.setImagemGrupo(new Byte[]{'A'});
        grupo.setOnlineGrupo(1L);
        grupo.setPedeobsGrupo(1L);
        grupo.setStatusGrupo(1L);
        grupo.setSubGrupos(new ArrayList<>());
        Optional<Grupos> ofResult = Optional.of(grupo);
        when(grupoRepository.findById(Mockito.<Integer>any())).thenReturn(ofResult);
        Grupos actualAtualizarGrupoResult = grupoServiceImpl.atualizarGrupo(1);
        verify(grupoRepository).findById(Mockito.<Integer>any());
        assertEquals("Desc Grupo", actualAtualizarGrupoResult.getDescGrupo());
        assertEquals(1L, actualAtualizarGrupoResult.getIdImpressora().longValue());
        assertEquals(1L, actualAtualizarGrupoResult.getOnlineGrupo().longValue());
        assertEquals(1L, actualAtualizarGrupoResult.getStatusGrupo().longValue());
        assertTrue(actualAtualizarGrupoResult.getSubGrupos().isEmpty());
        assertArrayEquals(new Byte[]{'A'}, actualAtualizarGrupoResult.getImagemGrupo());
    }

    /**
     * Method under test: {@link GrupoServiceImpl#deletarGrupo(Integer)}
     */
    @Test
    void testDeletarGrupo() {
        doNothing().when(grupoRepository).deleteById(Mockito.<Integer>any());
        grupoServiceImpl.deletarGrupo(1);
        verify(grupoRepository).deleteById(Mockito.<Integer>any());
    }
}
