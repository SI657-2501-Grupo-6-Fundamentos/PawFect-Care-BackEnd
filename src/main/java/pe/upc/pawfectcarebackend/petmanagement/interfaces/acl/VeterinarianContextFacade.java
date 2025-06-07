package pe.upc.pawfectcarebackend.petmanagement.interfaces.acl;

import org.springframework.stereotype.Service;
import pe.upc.pawfectcarebackend.petmanagement.domain.model.aggregates.Veterinarian;
import pe.upc.pawfectcarebackend.petmanagement.domain.model.queries.GetVeterinariansByIdQuery;
import pe.upc.pawfectcarebackend.petmanagement.domain.services.VeterinarianQueryService;

import java.util.Optional;

@Service
public class VeterinarianContextFacade {
    private final VeterinarianQueryService veterinarianQueryService;


    public VeterinarianContextFacade( VeterinarianQueryService veterinarianQueryService) {
        this.veterinarianQueryService = veterinarianQueryService;
    }

    public Optional<Veterinarian> fetchVeterinarianById(Long Id) {
        var getVeterinariansByIdQuery = new GetVeterinariansByIdQuery(Id);
        return veterinarianQueryService.handle(getVeterinariansByIdQuery);
    }
}
