package app.utl.granja.Service;





import app.utl.granja.Entities.Animal;
import app.utl.granja.Exception.ResourceNotFoundException;
import app.utl.granja.Repository.AnimalRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService implements BaseService<Animal> {

    private final AnimalRepository animalRepository;

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @Override
    public List<Animal> findAll() {
        return animalRepository.findAll();
    }

    @Override
    @Transactional
    public Animal findById(Long id) {
        return animalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Animal no encontrado ",id));
    }

    @Override
    @Transactional
    public Animal save(Animal animal) {
        return animalRepository.save(animal);
    }

    @Override
    public Animal update(Long id, Animal a) {
        Animal animal = animalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No encontrado",id));

        animal.setTipo_animal(a.getTipo_animal());
        animal.setPeso(a.getPeso());
        animal.setAños(a.getAños());

        return animalRepository.save(animal);
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}


