package cl.duoc.gamestore.service;

import cl.duoc.gamestore.model.Videojuego;
import cl.duoc.gamestore.repository.VideojuegoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VideojuegoService {
    //instancia del repo
    private VideojuegoRepository repo;
    //Constructor
    public VideojuegoService(VideojuegoRepository repo){
        this.repo = repo;
    }
    //Buscartodo GET
    public List<Videojuego> findAll(){
        return repo.findAll();
    }
    //Guardar //POST
    public Videojuego save(Videojuego v){
        return repo.save(v);
    }
    //Eliminar Delete
    public void delete(Long id){
        repo.deleteById(id);
    }
}
