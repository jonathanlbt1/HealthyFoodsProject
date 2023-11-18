package com.example.healthyfoods.services.impl;

import com.example.healthyfoods.entities.Grupo;
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
     * Method under test: {@link GrupoServiceImpl#salvarGrupo(Grupo)}
     */
    @Test
    void testSalvarGrupo() {
        Grupo grupo = new Grupo();
        grupo.setDescGrupo("Desc Grupo");
        grupo.setIdGrupo(1L);
        grupo.setIdImpressora(1L);
        grupo.setImagemGrupo(new Byte[]{'A'});
        grupo.setOnlineGrupo(1L);
        grupo.setPedeobsGrupo(1L);
        grupo.setStatusGrupo(1L);
        grupo.setSubGrupos(new ArrayList<>());
        when(grupoRepository.save(Mockito.<Grupo>any())).thenReturn(grupo);

        Grupo grupo2 = new Grupo();
        grupo2.setDescGrupo("Desc Grupo");
        grupo2.setIdGrupo(1L);
        grupo2.setIdImpressora(1L);
        grupo2.setImagemGrupo(new Byte[]{'A'});
        grupo2.setOnlineGrupo(1L);
        grupo2.setPedeobsGrupo(1L);
        grupo2.setStatusGrupo(1L);
        grupo2.setSubGrupos(new ArrayList<>());
        Grupo actualSalvarGrupoResult = grupoServiceImpl.salvarGrupo(grupo2);
        verify(grupoRepository).save(Mockito.<Grupo>any());
        assertSame(grupo, actualSalvarGrupoResult);
    }

    /**
     * Method under test: {@link GrupoServiceImpl#salvarGrupo(Grupo)}
     */
    @Test
    void testSalvarGrupo2() {
        when(grupoRepository.save(Mockito.<Grupo>any())).thenThrow(new RuntimeException("foo"));

        Grupo grupo = new Grupo();
        grupo.setDescGrupo("Desc Grupo");
        grupo.setIdGrupo(1L);
        grupo.setIdImpressora(1L);
        grupo.setImagemGrupo(new Byte[]{'A'});
        grupo.setOnlineGrupo(1L);
        grupo.setPedeobsGrupo(1L);
        grupo.setStatusGrupo(1L);
        grupo.setSubGrupos(new ArrayList<>());
        assertThrows(RuntimeException.class, () -> grupoServiceImpl.salvarGrupo(grupo));
        verify(grupoRepository).save(Mockito.<Grupo>any());
    }

    /**
     * Method under test: {@link GrupoServiceImpl#listarGrupos()}
     */
    @Test
    void testListarGrupos() {
        ArrayList<Grupo> grupoList = new ArrayList<>();
        when(grupoRepository.findAll()).thenReturn(grupoList);
        List<Grupo> actualListarGruposResult = grupoServiceImpl.listarGrupos();
        verify(grupoRepository).findAll();
        assertTrue(actualListarGruposResult.isEmpty());
        assertSame(grupoList, actualListarGruposResult);
    }

    /**
     * Method under test: {@link GrupoServiceImpl#listarGrupos()}
     */
    @Test
    void testListarGrupos2() {
        when(grupoRepository.findAll()).thenThrow(new RuntimeException("foo"));
        assertThrows(RuntimeException.class, () -> grupoServiceImpl.listarGrupos());
        verify(grupoRepository).findAll();
    }

    /**
     * Method under test: {@link GrupoServiceImpl#buscarGrupoPorId(Long)}
     */
    @Test
    void testBuscarGrupoPorId() {
        Grupo grupo = new Grupo();
        grupo.setDescGrupo("Desc Grupo");
        grupo.setIdGrupo(1L);
        grupo.setIdImpressora(1L);
        grupo.setImagemGrupo(new Byte[]{'A'});
        grupo.setOnlineGrupo(1L);
        grupo.setPedeobsGrupo(1L);
        grupo.setStatusGrupo(1L);
        grupo.setSubGrupos(new ArrayList<>());
        Optional<Grupo> ofResult = Optional.of(grupo);
        when(grupoRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        Optional<Grupo> actualBuscarGrupoPorIdResult = grupoServiceImpl.buscarGrupoPorId(1L);
        verify(grupoRepository).findById(Mockito.<Long>any());
        assertTrue(actualBuscarGrupoPorIdResult.isPresent());
        assertSame(ofResult, actualBuscarGrupoPorIdResult);
    }

    /**
     * Method under test: {@link GrupoServiceImpl#buscarGrupoPorId(Long)}
     */
    @Test
    void testBuscarGrupoPorId2() {
        when(grupoRepository.findById(Mockito.<Long>any())).thenThrow(new RuntimeException("foo"));
        assertThrows(RuntimeException.class, () -> grupoServiceImpl.buscarGrupoPorId(1L));
        verify(grupoRepository).findById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link GrupoServiceImpl#atualizarGrupo(Long, Grupo)}
     */
    @Test
    void testAtualizarGrupo() {
        Grupo grupo = new Grupo();
        grupo.setDescGrupo("Desc Grupo");
        grupo.setIdGrupo(1L);
        grupo.setIdImpressora(1L);
        grupo.setImagemGrupo(new Byte[]{'A'});
        grupo.setOnlineGrupo(1L);
        grupo.setPedeobsGrupo(1L);
        grupo.setStatusGrupo(1L);
        grupo.setSubGrupos(new ArrayList<>());
        Optional<Grupo> ofResult = Optional.of(grupo);

        Grupo grupo2 = new Grupo();
        grupo2.setDescGrupo("Desc Grupo");
        grupo2.setIdGrupo(1L);
        grupo2.setIdImpressora(1L);
        grupo2.setImagemGrupo(new Byte[]{'A'});
        grupo2.setOnlineGrupo(1L);
        grupo2.setPedeobsGrupo(1L);
        grupo2.setStatusGrupo(1L);
        grupo2.setSubGrupos(new ArrayList<>());
        when(grupoRepository.save(Mockito.<Grupo>any())).thenReturn(grupo2);
        when(grupoRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        Grupo novoGrupo = new Grupo();
        novoGrupo.setDescGrupo("Desc Grupo");
        novoGrupo.setIdGrupo(1L);
        novoGrupo.setIdImpressora(1L);
        novoGrupo.setImagemGrupo(new Byte[]{'A'});
        novoGrupo.setOnlineGrupo(1L);
        novoGrupo.setPedeobsGrupo(1L);
        novoGrupo.setStatusGrupo(1L);
        novoGrupo.setSubGrupos(new ArrayList<>());
        Grupo actualAtualizarGrupoResult = grupoServiceImpl.atualizarGrupo(1L, novoGrupo);
        verify(grupoRepository).findById(Mockito.<Long>any());
        verify(grupoRepository).save(Mockito.<Grupo>any());
        assertSame(grupo2, actualAtualizarGrupoResult);
    }

    /**
     * Method under test: {@link GrupoServiceImpl#atualizarGrupo(Long, Grupo)}
     */
    @Test
    void testAtualizarGrupo2() {
        Grupo grupo = new Grupo();
        grupo.setDescGrupo("Desc Grupo");
        grupo.setIdGrupo(1L);
        grupo.setIdImpressora(1L);
        grupo.setImagemGrupo(new Byte[]{'A'});
        grupo.setOnlineGrupo(1L);
        grupo.setPedeobsGrupo(1L);
        grupo.setStatusGrupo(1L);
        grupo.setSubGrupos(new ArrayList<>());
        Optional<Grupo> ofResult = Optional.of(grupo);
        when(grupoRepository.save(Mockito.<Grupo>any())).thenThrow(new RuntimeException("foo"));
        when(grupoRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        Grupo novoGrupo = new Grupo();
        novoGrupo.setDescGrupo("Desc Grupo");
        novoGrupo.setIdGrupo(1L);
        novoGrupo.setIdImpressora(1L);
        novoGrupo.setImagemGrupo(new Byte[]{'A'});
        novoGrupo.setOnlineGrupo(1L);
        novoGrupo.setPedeobsGrupo(1L);
        novoGrupo.setStatusGrupo(1L);
        novoGrupo.setSubGrupos(new ArrayList<>());
        assertThrows(RuntimeException.class, () -> grupoServiceImpl.atualizarGrupo(1L, novoGrupo));
        verify(grupoRepository).findById(Mockito.<Long>any());
        verify(grupoRepository).save(Mockito.<Grupo>any());
    }

    /**
     * Method under test: {@link GrupoServiceImpl#atualizarGrupo(Long, Grupo)}
     */
    @Test
    void testAtualizarGrupo3() {
        Optional<Grupo> emptyResult = Optional.empty();
        when(grupoRepository.findById(Mockito.<Long>any())).thenReturn(emptyResult);

        Grupo novoGrupo = new Grupo();
        novoGrupo.setDescGrupo("Desc Grupo");
        novoGrupo.setIdGrupo(1L);
        novoGrupo.setIdImpressora(1L);
        novoGrupo.setImagemGrupo(new Byte[]{'A'});
        novoGrupo.setOnlineGrupo(1L);
        novoGrupo.setPedeobsGrupo(1L);
        novoGrupo.setStatusGrupo(1L);
        novoGrupo.setSubGrupos(new ArrayList<>());
        assertThrows(RuntimeException.class, () -> grupoServiceImpl.atualizarGrupo(1L, novoGrupo));
        verify(grupoRepository).findById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link GrupoServiceImpl#deletarGrupo(Long)}
     */
    @Test
    void testDeletarGrupo() {
        doNothing().when(grupoRepository).deleteById(Mockito.<Long>any());
        grupoServiceImpl.deletarGrupo(1L);
        verify(grupoRepository).deleteById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link GrupoServiceImpl#deletarGrupo(Long)}
     */
    @Test
    void testDeletarGrupo2() {
        doThrow(new RuntimeException("foo")).when(grupoRepository).deleteById(Mockito.<Long>any());
        assertThrows(RuntimeException.class, () -> grupoServiceImpl.deletarGrupo(1L));
        verify(grupoRepository).deleteById(Mockito.<Long>any());
    }
}
