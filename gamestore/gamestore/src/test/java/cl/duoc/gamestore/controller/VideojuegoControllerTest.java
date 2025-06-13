package cl.duoc.gamestore.controller;

import cl.duoc.gamestore.model.Videojuego;
import cl.duoc.gamestore.service.VideojuegoService;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

//Anotación que indica que solo probará el videjuegoController
@WebMvcTest(VideojuegoController.class)
public class VideojuegoControllerTest {
    //Crear hhtp pra poder realizar pruebas unitarias injectar
    @Autowired
    private MockMvc mockMvc;

    //simulacion del servicio para evitar acceder a datos reales
    @MockitoBean
    private VideojuegoService service;

    //ObjectMapper comvierte los datos de json a texto y vise versa
    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    @DisplayName("Testing Controller 1 - obtener todo")
    void testGetAll() throws Exception {
        //1 simular con mockito un dato fake
        when(service.findAll()).thenReturn(List.of(new Videojuego(1L, "Tetris","PC")));
        //2.-Ejecutar una peticion get falsa
        mockMvc.perform(get("/api/videojuegos"))
                //lo que esperamos en esa peticion
                .andExpect(status().isOk())//codigo 200
        //4.- verificacion  que el primer elemento JSON sea el juego Tetris
                .andExpect(jsonPath("$[0].nombre").value("Tetris"));
    }
    //POST
    @Test
    @DisplayName("Testing controller 2-Guardar POST")
    void testPost() throws Exception {

        Videojuego v = new Videojuego( null, "Bubsy","SEGA Genesis");

        //2 Simular con mockito el guardar este videojuego y me devuelve uno con el ud ya asignado
        when(service.save(any())).thenReturn(new Videojuego(1L,"Bubsy","SEGA Genesis"));
            //3
        mockMvc.perform(post("/api/videojuegos")
                .contentType("application/json")// indicar que el contenido es JSON
                .content(mapper.writeValueAsString(v)))//convertimos el obejto JSON
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Bubsy"));




    }

    @Test
    @DisplayName("Testing controller 3 -DELETE")
    void testDelete() throws Exception {
        //1 simular una peticion delete s
        doNothing().when(service).delete (1L);

        //2 .- Ejecutar esa peticion delete
        mockMvc.perform(delete("/api/videojuegos/1"))
                // 3 esperemos un estado 200
                .andExpect(status().isOk());

    }


}
