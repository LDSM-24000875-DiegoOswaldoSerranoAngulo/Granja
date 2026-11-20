package app.utl.granja.Controller;

import app.utl.granja.Entities.Granjero;
import app.utl.granja.Service.GranjeroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/granjeros")

public class GranjeroController {

    private final GranjeroService granjeroService;

    public GranjeroController(GranjeroService granjeroService) {
        this.granjeroService = granjeroService;
    }

    @GetMapping("")
    public ResponseEntity<List<Granjero>> getAll() {
        List<Granjero> granjeros = granjeroService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(granjeros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Granjero> getById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(granjeroService.findById(id));
    }

    @PostMapping("")
    public ResponseEntity<Granjero> create(@RequestBody Granjero granjeroDelUsuario) {
        Granjero granjeroCreadoParaDevolver = granjeroService.save(granjeroDelUsuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(granjeroCreadoParaDevolver);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Granjero> update(@PathVariable Long id, @RequestBody Granjero granjero) {

        Granjero granjeroActualizado = granjeroService.update(id, granjero);
        return ResponseEntity.status(HttpStatus.OK).body(granjeroActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        granjeroService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}

