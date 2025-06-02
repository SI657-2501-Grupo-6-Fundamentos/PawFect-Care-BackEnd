package pe.upc.pawfectcarebackend.petmanagement.interfaces.rest.transform;

import pe.upc.pawfectcarebackend.petmanagement.domain.model.aggregates.Veterinarian;
import pe.upc.pawfectcarebackend.petmanagement.interfaces.rest.resources.VeterinarianResource;

public class VeterinarianResourceFromEntityAssembler {
    public static VeterinarianResource toResourceFromEntity(Veterinarian entity) {
        return new VeterinarianResource(
                entity.getId(),
                entity.getFullName(),
                entity.getPhoneNumber(),
                entity.getEmail(),
                entity.getDni(),
                entity.getVeterinarianSpeciality());
    }
}
