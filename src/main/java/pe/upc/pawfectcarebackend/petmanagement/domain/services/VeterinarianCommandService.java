package pe.upc.pawfectcarebackend.petmanagement.domain.services;

import pe.upc.pawfectcarebackend.petmanagement.domain.model.aggregates.Veterinarian;
import pe.upc.pawfectcarebackend.petmanagement.domain.model.commands.CreateVeterinarianCommand;
import pe.upc.pawfectcarebackend.petmanagement.domain.model.commands.UpdateVeterinarianCommand;

import java.util.Optional;

public interface VeterinarianCommandService {
    Optional<Veterinarian> handle(UpdateVeterinarianCommand command);
    Long handle(CreateVeterinarianCommand command);
}
