package app.utl.granja.Repository;

import app.utl.granja.Entities.Granjero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GranjeroRepository extends JpaRepository<Granjero, Long> {
}