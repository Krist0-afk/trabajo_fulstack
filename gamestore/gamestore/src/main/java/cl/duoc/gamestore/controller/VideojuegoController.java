package cl.duoc.gamestore.controller;
import cl.duoc.gamestore.model.Videojuego;
import cl.duoc.gamestore.service.VideojuegoService;
import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name="Videojuego",description = "Operaciones de un CRU para la API  de videjuegos")
@RestController
@RequestMapping("/api/videojuegos")
public class VideojuegoController {


    private final VideojuegoService service;
    public VideojuegoController(VideojuegoService service){
        this.service=service;
    }

    @Operation(summary = "obtener todos los videjuegos de la base de datos", description = "Devuelve una lista de todos los videojuegos almacenados")
    @ApiResponse(responseCode = "200",description = "Consulta exitosa")
    @ApiResponse
    //Buscar GET
    @GetMapping
    public List<Videojuego> getAll(){
        return service.findAll();
    }

    @Operation(summary = "Crear un nuevo Videojuego", description = "Agrega un nuevo videojuego a la base de datos ")
    @ApiResponses({
         @ApiResponse(responseCode = "200",description = "juego creado de forma exitosa"),
         @ApiResponse(responseCode = "400",description = "Fallo en la consulta")
    })
    //Guardar POST
    @PostMapping
    public Videojuego create(@RequestBody Videojuego v){
        return service.save(v);
    }
    //Eliminar DELETE
    @DeleteMapping ("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
