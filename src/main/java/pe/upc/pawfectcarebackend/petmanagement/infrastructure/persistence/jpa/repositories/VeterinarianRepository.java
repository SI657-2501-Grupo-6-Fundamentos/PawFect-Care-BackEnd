package pe.upc.pawfectcarebackend.petmanagement.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.upc.pawfectcarebackend.petmanagement.domain.model.aggregates.Veterinarian;
import pe.upc.pawfectcarebackend.petmanagement.domain.model.valueobjects.VeterinarianSpeciality;

import java.util.List;

@Repository
public interface VeterinarianRepository extends JpaRepository<Veterinarian, Long> {
    boolean existsById(Long id);
    boolean existsByDni(String dni);
    List<Veterinarian> findAllByVeterinarianSpeciality(VeterinarianSpeciality veterinarianSpeciality);
}
