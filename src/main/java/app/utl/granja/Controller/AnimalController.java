package app.utl.granja.Controller;

import app.utl.granja.Entities.Animal;
import app.utl.granja.Service.AnimalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/animales")

public class AnimalController {

    private final AnimalService animalService;

    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping("")
    public ResponseEntity<List<Animal>> getAll() {
        List<Animal> animales = animalService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(animales);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Animal> getById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(animalService.findById(id));
    }

    @PostMapping("")
    public ResponseEntity<Animal> create(@RequestBody Animal animalDelUsuario) {
        Animal animalCreadoParaDevolver = animalService.save(animalDelUsuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(animalCreadoParaDevolver);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Animal> update(@PathVariable Long id, @RequestBody Animal animal) {

        Animal animalActualizado = animalService.update(id, animal);
        return ResponseEntity.status(HttpStatus.OK).body(animalActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        animalService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
