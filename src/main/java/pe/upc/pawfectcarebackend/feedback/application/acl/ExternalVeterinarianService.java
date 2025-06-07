package pe.upc.pawfectcarebackend.feedback.application.acl;

import org.springframework.stereotype.Service;
import pe.upc.pawfectcarebackend.petmanagement.domain.model.aggregates.Veterinarian;
import pe.upc.pawfectcarebackend.petmanagement.interfaces.acl.VeterinarianContextFacade;

import java.util.Optional;

@Service
public class ExternalVeterinarianService {
    private final VeterinarianContextFacade veterinarianContextFacade;
    
    public ExternalVeterinarianService(VeterinarianContextFacade veterinarianContextFacade) {
        this.veterinarianContextFacade = veterinarianContextFacade;
    }
    public Optional<Veterinarian> fetchVeterinarianById(Long id) {
        var veterinarian = veterinarianContextFacade.fetchVeterinarianById(id);
        return veterinarian;
    }
}
