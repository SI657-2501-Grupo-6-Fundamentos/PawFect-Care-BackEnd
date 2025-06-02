package pe.upc.pawfectcarebackend.petmanagement.interfaces.rest.transform;

import pe.upc.pawfectcarebackend.petmanagement.domain.model.commands.CreateVeterinarianCommand;
import pe.upc.pawfectcarebackend.petmanagement.interfaces.rest.resources.CreateVeterinarianResource;

public class CreateVeterinarianCommandFromResourceAssembler {
    public static CreateVeterinarianCommand toCommandFromResource(CreateVeterinarianResource resource) {
        return new CreateVeterinarianCommand(
                resource.fullName(),
                resource.phoneNumber(),
                resource.email(),
                resource.dni(),
                resource.speciality());
    }
}
