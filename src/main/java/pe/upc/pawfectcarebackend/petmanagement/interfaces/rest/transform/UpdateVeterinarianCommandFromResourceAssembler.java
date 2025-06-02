package pe.upc.pawfectcarebackend.petmanagement.interfaces.rest.transform;

import pe.upc.pawfectcarebackend.petmanagement.domain.model.commands.UpdateVeterinarianCommand;
import pe.upc.pawfectcarebackend.petmanagement.interfaces.rest.resources.UpdateVeterinarianResource;

public class UpdateVeterinarianCommandFromResourceAssembler {
    public static UpdateVeterinarianCommand toCommandFromResource(Long veterinarianId, UpdateVeterinarianResource resource) {
        return new UpdateVeterinarianCommand(
                veterinarianId,
                resource.fullName(),
                resource.phoneNumber(),
                resource.email(),
                resource.dni(),
                resource.speciality());
    }
}
