package com.example.healthyfoods.controllers;

import com.example.healthyfoods.entities.Grupo;
import com.example.healthyfoods.services.impl.GrupoServiceImpl;
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

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {GrupoController.class})
@ExtendWith(SpringExtension.class)
class GrupoControllerDiffblueTest {
    @Autowired
    private GrupoController grupoController;

    @MockBean
    private GrupoServiceImpl grupoServiceImpl;

    /**
     * Method under test: {@link GrupoController#listarGrupos()}
     */
    @Test
    void testListarGrupos() throws Exception {
        when(grupoServiceImpl.listarGrupos()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/grupos");
        MockMvcBuilders.standaloneSetup(grupoController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link GrupoController#listarGrupos()}
     */
    @Test
    void testListarGrupos2() throws Exception {
        when(grupoServiceImpl.listarGrupos()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/grupos");
        requestBuilder.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(grupoController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link GrupoController#buscarGrupoPorId(Long)}
     */
    @Test
    void testBuscarGrupoPorId() throws Exception {
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
        when(grupoServiceImpl.buscarGrupoPorId(Mockito.<Long>any())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/grupos/{id}", 1L);
        MockMvcBuilders.standaloneSetup(grupoController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"idGrupo\":1,\"descGrupo\":\"Desc Grupo\",\"idImpressora\":1,\"pedeobsGrupo\":1,\"statusGrupo\":1,\"onlineGrupo"
                                        + "\":1,\"imagemGrupo\":[65],\"subGrupos\":[]}"));
    }

    /**
     * Method under test: {@link GrupoController#buscarGrupoPorId(Long)}
     */
    @Test
    void testBuscarGrupoPorId2() throws Exception {
        Optional<Grupo> emptyResult = Optional.empty();
        when(grupoServiceImpl.buscarGrupoPorId(Mockito.<Long>any())).thenReturn(emptyResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/grupos/{id}", 1L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(grupoController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    /**
     * Method under test: {@link GrupoController#atualizarGrupo(Long, Grupo)}
     */
    @Test
    void testAtualizarGrupo() throws Exception {
        Grupo grupo = new Grupo();
        grupo.setDescGrupo("Desc Grupo");
        grupo.setIdGrupo(1L);
        grupo.setIdImpressora(1L);
        grupo.setImagemGrupo(new Byte[]{'A'});
        grupo.setOnlineGrupo(1L);
        grupo.setPedeobsGrupo(1L);
        grupo.setStatusGrupo(1L);
        grupo.setSubGrupos(new ArrayList<>());
        when(grupoServiceImpl.atualizarGrupo(Mockito.<Long>any(), Mockito.<Grupo>any())).thenReturn(grupo);

        Grupo grupo2 = new Grupo();
        grupo2.setDescGrupo("Desc Grupo");
        grupo2.setIdGrupo(1L);
        grupo2.setIdImpressora(1L);
        grupo2.setImagemGrupo(new Byte[]{'A'});
        grupo2.setOnlineGrupo(1L);
        grupo2.setPedeobsGrupo(1L);
        grupo2.setStatusGrupo(1L);
        grupo2.setSubGrupos(new ArrayList<>());
        String content = (new ObjectMapper()).writeValueAsString(grupo2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/grupos/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(grupoController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"idGrupo\":1,\"descGrupo\":\"Desc Grupo\",\"idImpressora\":1,\"pedeobsGrupo\":1,\"statusGrupo\":1,\"onlineGrupo"
                                        + "\":1,\"imagemGrupo\":[65],\"subGrupos\":[]}"));
    }

    /**
     * Method under test: {@link GrupoController#deletarGrupo(Long)}
     */
    @Test
    void testDeletarGrupo() throws Exception {
        doNothing().when(grupoServiceImpl).deletarGrupo(Mockito.<Long>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/grupos/{id}", 1L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(grupoController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    /**
     * Method under test: {@link GrupoController#deletarGrupo(Long)}
     */
    @Test
    void testDeletarGrupo2() throws Exception {
        doNothing().when(grupoServiceImpl).deletarGrupo(Mockito.<Long>any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/grupos/{id}", 1L);
        requestBuilder.characterEncoding("Encoding");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(grupoController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNoContent());
    }

    /**
     * Method under test: {@link GrupoController#criarGrupo(Grupo)}
     */
    @Test
    void testCriarGrupo() throws Exception {
        when(grupoServiceImpl.listarGrupos()).thenReturn(new ArrayList<>());

        Grupo grupo = new Grupo();
        grupo.setDescGrupo("Desc Grupo");
        grupo.setIdGrupo(1L);
        grupo.setIdImpressora(1L);
        grupo.setImagemGrupo(new Byte[]{'A'});
        grupo.setOnlineGrupo(1L);
        grupo.setPedeobsGrupo(1L);
        grupo.setStatusGrupo(1L);
        grupo.setSubGrupos(new ArrayList<>());
        String content = (new ObjectMapper()).writeValueAsString(grupo);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/grupos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(grupoController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }
}
