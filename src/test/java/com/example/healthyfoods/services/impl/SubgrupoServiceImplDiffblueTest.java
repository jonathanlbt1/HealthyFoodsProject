package com.example.healthyfoods.services.impl;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.healthyfoods.entities.Grupo;
import com.example.healthyfoods.entities.Subgrupo;
import com.example.healthyfoods.repositories.SubgrupoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {SubgrupoServiceImpl.class})
@ExtendWith(SpringExtension.class)
class SubgrupoServiceImplDiffblueTest {
    @MockBean
    private SubgrupoRepository subgrupoRepository;

    @Autowired
    private SubgrupoServiceImpl subgrupoServiceImpl;

    /**
     * Method under test: {@link SubgrupoServiceImpl#salvarSubgrupo(Subgrupo)}
     */
    @Test
    void testSalvarSubgrupo() {
        Grupo grupos = new Grupo();
        grupos.setDescGrupo("Desc Grupo");
        grupos.setIdGrupo(1L);
        grupos.setIdImpressora(1L);
        grupos.setImagemGrupo(new Byte[]{'A'});
        grupos.setOnlineGrupo(1L);
        grupos.setPedeobsGrupo(1L);
        grupos.setStatusGrupo(1L);
        grupos.setSubGrupos(new ArrayList<>());

        Subgrupo subgrupo = new Subgrupo();
        subgrupo.setDescSubgrupo("Desc Subgrupo");
        subgrupo.setGrupos(grupos);
        subgrupo.setIdCadImpressora(1L);
        subgrupo.setIdGrupo(1L);
        subgrupo.setIdSubgrupo(1L);
        subgrupo.setStatusSubgrupo(1L);
        when(subgrupoRepository.save(Mockito.<Subgrupo>any())).thenReturn(subgrupo);

        Grupo grupos2 = new Grupo();
        grupos2.setDescGrupo("Desc Grupo");
        grupos2.setIdGrupo(1L);
        grupos2.setIdImpressora(1L);
        grupos2.setImagemGrupo(new Byte[]{'A'});
        grupos2.setOnlineGrupo(1L);
        grupos2.setPedeobsGrupo(1L);
        grupos2.setStatusGrupo(1L);
        grupos2.setSubGrupos(new ArrayList<>());

        Subgrupo subgrupo2 = new Subgrupo();
        subgrupo2.setDescSubgrupo("Desc Subgrupo");
        subgrupo2.setGrupos(grupos2);
        subgrupo2.setIdCadImpressora(1L);
        subgrupo2.setIdGrupo(1L);
        subgrupo2.setIdSubgrupo(1L);
        subgrupo2.setStatusSubgrupo(1L);
        Subgrupo actualSalvarSubgrupoResult = subgrupoServiceImpl.salvarSubgrupo(subgrupo2);
        verify(subgrupoRepository).save(Mockito.<Subgrupo>any());
        assertSame(subgrupo, actualSalvarSubgrupoResult);
    }

    /**
     * Method under test: {@link SubgrupoServiceImpl#salvarSubgrupo(Subgrupo)}
     */
    @Test
    void testSalvarSubgrupo2() {
        when(subgrupoRepository.save(Mockito.<Subgrupo>any())).thenThrow(new RuntimeException("foo"));

        Grupo grupos = new Grupo();
        grupos.setDescGrupo("Desc Grupo");
        grupos.setIdGrupo(1L);
        grupos.setIdImpressora(1L);
        grupos.setImagemGrupo(new Byte[]{'A'});
        grupos.setOnlineGrupo(1L);
        grupos.setPedeobsGrupo(1L);
        grupos.setStatusGrupo(1L);
        grupos.setSubGrupos(new ArrayList<>());

        Subgrupo subgrupo = new Subgrupo();
        subgrupo.setDescSubgrupo("Desc Subgrupo");
        subgrupo.setGrupos(grupos);
        subgrupo.setIdCadImpressora(1L);
        subgrupo.setIdGrupo(1L);
        subgrupo.setIdSubgrupo(1L);
        subgrupo.setStatusSubgrupo(1L);
        assertThrows(RuntimeException.class, () -> subgrupoServiceImpl.salvarSubgrupo(subgrupo));
        verify(subgrupoRepository).save(Mockito.<Subgrupo>any());
    }

    /**
     * Method under test: {@link SubgrupoServiceImpl#listarSubgrupos()}
     */
    @Test
    void testListarSubgrupos() {
        ArrayList<Subgrupo> subgrupoList = new ArrayList<>();
        when(subgrupoRepository.findAll()).thenReturn(subgrupoList);
        List<Subgrupo> actualListarSubgruposResult = subgrupoServiceImpl.listarSubgrupos();
        verify(subgrupoRepository).findAll();
        assertTrue(actualListarSubgruposResult.isEmpty());
        assertSame(subgrupoList, actualListarSubgruposResult);
    }

    /**
     * Method under test: {@link SubgrupoServiceImpl#listarSubgrupos()}
     */
    @Test
    void testListarSubgrupos2() {
        when(subgrupoRepository.findAll()).thenThrow(new RuntimeException("foo"));
        assertThrows(RuntimeException.class, () -> subgrupoServiceImpl.listarSubgrupos());
        verify(subgrupoRepository).findAll();
    }

    /**
     * Method under test: {@link SubgrupoServiceImpl#buscarSubgrupoPorId(Long)}
     */
    @Test
    void testBuscarSubgrupoPorId() {
        Grupo grupos = new Grupo();
        grupos.setDescGrupo("Desc Grupo");
        grupos.setIdGrupo(1L);
        grupos.setIdImpressora(1L);
        grupos.setImagemGrupo(new Byte[]{'A'});
        grupos.setOnlineGrupo(1L);
        grupos.setPedeobsGrupo(1L);
        grupos.setStatusGrupo(1L);
        grupos.setSubGrupos(new ArrayList<>());

        Subgrupo subgrupo = new Subgrupo();
        subgrupo.setDescSubgrupo("Desc Subgrupo");
        subgrupo.setGrupos(grupos);
        subgrupo.setIdCadImpressora(1L);
        subgrupo.setIdGrupo(1L);
        subgrupo.setIdSubgrupo(1L);
        subgrupo.setStatusSubgrupo(1L);
        Optional<Subgrupo> ofResult = Optional.of(subgrupo);
        when(subgrupoRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);
        Optional<Subgrupo> actualBuscarSubgrupoPorIdResult = subgrupoServiceImpl.buscarSubgrupoPorId(1L);
        verify(subgrupoRepository).findById(Mockito.<Long>any());
        assertTrue(actualBuscarSubgrupoPorIdResult.isPresent());
        assertSame(ofResult, actualBuscarSubgrupoPorIdResult);
    }

    /**
     * Method under test: {@link SubgrupoServiceImpl#buscarSubgrupoPorId(Long)}
     */
    @Test
    void testBuscarSubgrupoPorId2() {
        when(subgrupoRepository.findById(Mockito.<Long>any())).thenThrow(new RuntimeException("foo"));
        assertThrows(RuntimeException.class, () -> subgrupoServiceImpl.buscarSubgrupoPorId(1L));
        verify(subgrupoRepository).findById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link SubgrupoServiceImpl#atualizarSubgrupo(Long, Subgrupo)}
     */
    @Test
    void testAtualizarSubgrupo() {
        Grupo grupos = new Grupo();
        grupos.setDescGrupo("Desc Grupo");
        grupos.setIdGrupo(1L);
        grupos.setIdImpressora(1L);
        grupos.setImagemGrupo(new Byte[]{'A'});
        grupos.setOnlineGrupo(1L);
        grupos.setPedeobsGrupo(1L);
        grupos.setStatusGrupo(1L);
        grupos.setSubGrupos(new ArrayList<>());

        Subgrupo subgrupo = new Subgrupo();
        subgrupo.setDescSubgrupo("Desc Subgrupo");
        subgrupo.setGrupos(grupos);
        subgrupo.setIdCadImpressora(1L);
        subgrupo.setIdGrupo(1L);
        subgrupo.setIdSubgrupo(1L);
        subgrupo.setStatusSubgrupo(1L);
        Optional<Subgrupo> ofResult = Optional.of(subgrupo);

        Grupo grupos2 = new Grupo();
        grupos2.setDescGrupo("Desc Grupo");
        grupos2.setIdGrupo(1L);
        grupos2.setIdImpressora(1L);
        grupos2.setImagemGrupo(new Byte[]{'A'});
        grupos2.setOnlineGrupo(1L);
        grupos2.setPedeobsGrupo(1L);
        grupos2.setStatusGrupo(1L);
        grupos2.setSubGrupos(new ArrayList<>());

        Subgrupo subgrupo2 = new Subgrupo();
        subgrupo2.setDescSubgrupo("Desc Subgrupo");
        subgrupo2.setGrupos(grupos2);
        subgrupo2.setIdCadImpressora(1L);
        subgrupo2.setIdGrupo(1L);
        subgrupo2.setIdSubgrupo(1L);
        subgrupo2.setStatusSubgrupo(1L);
        when(subgrupoRepository.save(Mockito.<Subgrupo>any())).thenReturn(subgrupo2);
        when(subgrupoRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        Grupo grupos3 = new Grupo();
        grupos3.setDescGrupo("Desc Grupo");
        grupos3.setIdGrupo(1L);
        grupos3.setIdImpressora(1L);
        grupos3.setImagemGrupo(new Byte[]{'A'});
        grupos3.setOnlineGrupo(1L);
        grupos3.setPedeobsGrupo(1L);
        grupos3.setStatusGrupo(1L);
        grupos3.setSubGrupos(new ArrayList<>());

        Subgrupo novoSubgrupo = new Subgrupo();
        novoSubgrupo.setDescSubgrupo("Desc Subgrupo");
        novoSubgrupo.setGrupos(grupos3);
        novoSubgrupo.setIdCadImpressora(1L);
        novoSubgrupo.setIdGrupo(1L);
        novoSubgrupo.setIdSubgrupo(1L);
        novoSubgrupo.setStatusSubgrupo(1L);
        Subgrupo actualAtualizarSubgrupoResult = subgrupoServiceImpl.atualizarSubgrupo(1L, novoSubgrupo);
        verify(subgrupoRepository).findById(Mockito.<Long>any());
        verify(subgrupoRepository).save(Mockito.<Subgrupo>any());
        assertSame(subgrupo2, actualAtualizarSubgrupoResult);
    }

    /**
     * Method under test: {@link SubgrupoServiceImpl#atualizarSubgrupo(Long, Subgrupo)}
     */
    @Test
    void testAtualizarSubgrupo2() {
        Grupo grupos = new Grupo();
        grupos.setDescGrupo("Desc Grupo");
        grupos.setIdGrupo(1L);
        grupos.setIdImpressora(1L);
        grupos.setImagemGrupo(new Byte[]{'A'});
        grupos.setOnlineGrupo(1L);
        grupos.setPedeobsGrupo(1L);
        grupos.setStatusGrupo(1L);
        grupos.setSubGrupos(new ArrayList<>());

        Subgrupo subgrupo = new Subgrupo();
        subgrupo.setDescSubgrupo("Desc Subgrupo");
        subgrupo.setGrupos(grupos);
        subgrupo.setIdCadImpressora(1L);
        subgrupo.setIdGrupo(1L);
        subgrupo.setIdSubgrupo(1L);
        subgrupo.setStatusSubgrupo(1L);
        Optional<Subgrupo> ofResult = Optional.of(subgrupo);
        when(subgrupoRepository.save(Mockito.<Subgrupo>any())).thenThrow(new RuntimeException("foo"));
        when(subgrupoRepository.findById(Mockito.<Long>any())).thenReturn(ofResult);

        Grupo grupos2 = new Grupo();
        grupos2.setDescGrupo("Desc Grupo");
        grupos2.setIdGrupo(1L);
        grupos2.setIdImpressora(1L);
        grupos2.setImagemGrupo(new Byte[]{'A'});
        grupos2.setOnlineGrupo(1L);
        grupos2.setPedeobsGrupo(1L);
        grupos2.setStatusGrupo(1L);
        grupos2.setSubGrupos(new ArrayList<>());

        Subgrupo novoSubgrupo = new Subgrupo();
        novoSubgrupo.setDescSubgrupo("Desc Subgrupo");
        novoSubgrupo.setGrupos(grupos2);
        novoSubgrupo.setIdCadImpressora(1L);
        novoSubgrupo.setIdGrupo(1L);
        novoSubgrupo.setIdSubgrupo(1L);
        novoSubgrupo.setStatusSubgrupo(1L);
        assertThrows(RuntimeException.class, () -> subgrupoServiceImpl.atualizarSubgrupo(1L, novoSubgrupo));
        verify(subgrupoRepository).findById(Mockito.<Long>any());
        verify(subgrupoRepository).save(Mockito.<Subgrupo>any());
    }

    /**
     * Method under test: {@link SubgrupoServiceImpl#atualizarSubgrupo(Long, Subgrupo)}
     */
    @Test
    void testAtualizarSubgrupo3() {
        Optional<Subgrupo> emptyResult = Optional.empty();
        when(subgrupoRepository.findById(Mockito.<Long>any())).thenReturn(emptyResult);

        Grupo grupos = new Grupo();
        grupos.setDescGrupo("Desc Grupo");
        grupos.setIdGrupo(1L);
        grupos.setIdImpressora(1L);
        grupos.setImagemGrupo(new Byte[]{'A'});
        grupos.setOnlineGrupo(1L);
        grupos.setPedeobsGrupo(1L);
        grupos.setStatusGrupo(1L);
        grupos.setSubGrupos(new ArrayList<>());

        Subgrupo novoSubgrupo = new Subgrupo();
        novoSubgrupo.setDescSubgrupo("Desc Subgrupo");
        novoSubgrupo.setGrupos(grupos);
        novoSubgrupo.setIdCadImpressora(1L);
        novoSubgrupo.setIdGrupo(1L);
        novoSubgrupo.setIdSubgrupo(1L);
        novoSubgrupo.setStatusSubgrupo(1L);
        assertThrows(RuntimeException.class, () -> subgrupoServiceImpl.atualizarSubgrupo(1L, novoSubgrupo));
        verify(subgrupoRepository).findById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link SubgrupoServiceImpl#deletarSubgrupo(Long)}
     */
    @Test
    void testDeletarSubgrupo() {
        doNothing().when(subgrupoRepository).deleteById(Mockito.<Long>any());
        subgrupoServiceImpl.deletarSubgrupo(1L);
        verify(subgrupoRepository).deleteById(Mockito.<Long>any());
    }

    /**
     * Method under test: {@link SubgrupoServiceImpl#deletarSubgrupo(Long)}
     */
    @Test
    void testDeletarSubgrupo2() {
        doThrow(new RuntimeException("foo")).when(subgrupoRepository).deleteById(Mockito.<Long>any());
        assertThrows(RuntimeException.class, () -> subgrupoServiceImpl.deletarSubgrupo(1L));
        verify(subgrupoRepository).deleteById(Mockito.<Long>any());
    }
}
