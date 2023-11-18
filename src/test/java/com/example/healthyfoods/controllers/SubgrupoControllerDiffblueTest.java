package com.example.healthyfoods.controllers;

import com.example.healthyfoods.entities.Grupo;
import com.example.healthyfoods.entities.Subgrupo;
import com.example.healthyfoods.services.impl.SubgrupoServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {SubgrupoController.class})
@ExtendWith(SpringExtension.class)
class SubgrupoControllerDiffblueTest {
    @Autowired
    private SubgrupoController subgrupoController;

    @MockBean
    private SubgrupoServiceImpl subgrupoServiceImpl;

    /**
     * Method under test: {@link SubgrupoController#buscarSubgrupoPorId(Long)}
     */
    @Test
    void testBuscarSubgrupoPorId() throws Exception {
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
        when(subgrupoServiceImpl.buscarSubgrupoPorId(Mockito.<Long>any())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/subgrupos/{id}", 1L);
        MockMvcBuilders.standaloneSetup(subgrupoController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"idSubgrupo\":1,\"descSubgrupo\":\"Desc Subgrupo\",\"idCadImpressora\":1,\"idGrupo\":1,\"statusSubgrupo\":1,"
                                        + "\"grupos\":{\"idGrupo\":1,\"descGrupo\":\"Desc Grupo\",\"idImpressora\":1,\"pedeobsGrupo\":1,\"statusGrupo\":1,"
                                        + "\"onlineGrupo\":1,\"imagemGrupo\":[65],\"subGrupos\":[]}}"));
    }

    /**
     * Method under test: {@link SubgrupoController#buscarSubgrupoPorId(Long)}
     */
    @Test
    void testBuscarSubgrupoPorId2() throws Exception {
        Optional<Subgrupo> emptyResult = Optional.empty();
        when(subgrupoServiceImpl.buscarSubgrupoPorId(Mockito.<Long>any())).thenReturn(emptyResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/subgrupos/{id}", 1L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(subgrupoController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    /**
     * Method under test: {@link SubgrupoController#atualizarSubgrupo(Long, Subgrupo)}
     */
    @Test
    void testAtualizarSubgrupo() throws Exception {
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
        when(subgrupoServiceImpl.atualizarSubgrupo(Mockito.<Long>any(), Mockito.<Subgrupo>any())).thenReturn(subgrupo);

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
        String content = (new ObjectMapper()).writeValueAsString(subgrupo2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/subgrupos/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(subgrupoController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"idSubgrupo\":1,\"descSubgrupo\":\"Desc Subgrupo\",\"idCadImpressora\":1,\"idGrupo\":1,\"statusSubgrupo\":1,"
                                        + "\"grupos\":{\"idGrupo\":1,\"descGrupo\":\"Desc Grupo\",\"idImpressora\":1,\"pedeobsGrupo\":1,\"statusGrupo\":1,"
                                        + "\"onlineGrupo\":1,\"imagemGrupo\":[65],\"subGrupos\":[]}}"));
    }
}
