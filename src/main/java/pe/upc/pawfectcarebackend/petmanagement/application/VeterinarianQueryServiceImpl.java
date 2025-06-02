package pe.upc.pawfectcarebackend.petmanagement.application;



import org.springframework.stereotype.Service;
import pe.upc.pawfectcarebackend.petmanagement.domain.model.aggregates.Veterinarian;
import pe.upc.pawfectcarebackend.petmanagement.domain.model.queries.GetAllVeterinariansBySpecialityQuery;
import pe.upc.pawfectcarebackend.petmanagement.domain.model.queries.GetAllVeterinariansQuery;
import pe.upc.pawfectcarebackend.petmanagement.domain.model.queries.GetVeterinariansByIdQuery;
import pe.upc.pawfectcarebackend.petmanagement.domain.services.VeterinarianQueryService;
import pe.upc.pawfectcarebackend.petmanagement.infrastructure.persistence.jpa.repositories.VeterinarianRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VeterinarianQueryServiceImpl implements VeterinarianQueryService {
    private final VeterinarianRepository veterinarianRepository;
    public VeterinarianQueryServiceImpl(VeterinarianRepository veterinarianRepository) {
        this.veterinarianRepository = veterinarianRepository;
    }

    @Override
    public Optional<Veterinarian> handle(GetVeterinariansByIdQuery query) {
        return veterinarianRepository.findById(query.veterinarianId());
    }

    @Override
    public List<Veterinarian> handle(GetAllVeterinariansQuery query) {
        return veterinarianRepository.findAll();
    }

    @Override
    public List<Veterinarian> handle(GetAllVeterinariansBySpecialityQuery query) {
        return veterinarianRepository.findAllByVeterinarianSpeciality(query.speciality());
    }


}
