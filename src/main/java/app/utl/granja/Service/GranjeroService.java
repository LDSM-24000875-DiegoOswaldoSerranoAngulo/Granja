package app.utl.granja.Service;




import app.utl.granja.Entities.Granjero;
import app.utl.granja.Exception.ResourceNotFoundException;
import app.utl.granja.Repository.GranjeroRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GranjeroService implements BaseService<Granjero> {

    private final GranjeroRepository granjeroRepository;

    public GranjeroService(GranjeroRepository granjeroRepository) {
        this.granjeroRepository = granjeroRepository;
    }

    @Override
    public List<Granjero> findAll() {
        return granjeroRepository.findAll();
    }

    @Override
    @Transactional
    public Granjero findById(Long id) {
        return granjeroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Granjero", id));
    }

    @Override
    @Transactional
    public Granjero save(Granjero granjero) {
        return granjeroRepository.save(granjero);
    }

    @Override
    public Granjero update(Long id, Granjero g) {
        Granjero granjero = granjeroRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Granjero", id));

        granjero.setNombre(g.getNombre());
        granjero.setPago(g.getPago());
        granjero.setRol_trabajo(g.getRol_trabajo());

        return granjeroRepository.save(granjero);
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}

