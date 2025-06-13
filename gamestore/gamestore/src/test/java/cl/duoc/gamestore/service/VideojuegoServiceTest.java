package cl.duoc.gamestore.service;

import cl.duoc.gamestore.model.Videojuego;
import cl.duoc.gamestore.repository.VideojuegoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

//Librerías para usar mockito
import org.mockito.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*; //Mocks Simular inserciones, datos de listas etc.


public class VideojuegoServiceTest {
    //Creando una instancia de Mocks=Simular para poder iyectarlas donde sea necesario
    @InjectMocks
    private VideojuegoService service;
    //Creando un mock del repositorio //objeto simulado
    @Mock
    private VideojuegoRepository repo;

    //Constructor para inicializar test antes de cada prueba
    public VideojuegoServiceTest(){

        //Abre e inializa los mocks anotados con @Mock y @InjectMocks
        MockitoAnnotations.openMocks(this);
    }
    @Test
    @DisplayName("Testing 1 - FindAll Service")
    void testFindAll(){
        //Simular la creación de un objeto de videojuego
        when(repo.findAll()).thenReturn(List.of(new Videojuego(1L,"Sonic Pinball","SEGA Genesis")));
        //Llamar al metodo de servicio que sera probado
        List<Videojuego> resultado =  service.findAll();
        //Verificacion
        assertEquals(1, resultado.size());
    }
}
