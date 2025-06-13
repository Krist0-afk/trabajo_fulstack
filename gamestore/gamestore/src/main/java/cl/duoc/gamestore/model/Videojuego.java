package cl.duoc.gamestore.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Videojuego {
    @Schema(description = "ID autoguardado con IDENTITY", example ="1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "Nombre del videojuego", example ="Bubsy")
    private String nombre;

    @Schema(description = "Nombre de la plataforma del videojuego", example ="Sega Genesis")
    private String plataforma;

    @Schema(description = "Cantidad de videojuegos en bodega", example ="20")
    private int stock;
}
