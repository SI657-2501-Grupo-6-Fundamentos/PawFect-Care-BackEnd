package pe.upc.pawfectcarebackend.petmanagement.domain.model.aggregates;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import pe.upc.pawfectcarebackend.petmanagement.domain.model.commands.CreatePetCommand;
import pe.upc.pawfectcarebackend.petmanagement.domain.model.commands.CreateVeterinarianCommand;
import pe.upc.pawfectcarebackend.petmanagement.domain.model.valueobjects.VeterinarianSpeciality;
import pe.upc.pawfectcarebackend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

@Getter
@Entity
public class Veterinarian extends AuditableAbstractAggregateRoot<Veterinarian> {
    private String fullName;
    private String phoneNumber;
    private String email;
    private String dni;
    @Enumerated(EnumType.STRING)
    private VeterinarianSpeciality veterinarianSpeciality;

    public Veterinarian() {
        this.fullName = "";
        this.phoneNumber = "";
        this.dni = "";
        this.email = "";
        this.veterinarianSpeciality = VeterinarianSpeciality.GENERAL_MEDICINE;
    }

    public Veterinarian(CreateVeterinarianCommand createVeterinarianCommand) {
        this.fullName = createVeterinarianCommand.fullName();
        this.phoneNumber = createVeterinarianCommand.phoneNumber();
        this.email = createVeterinarianCommand.email();
        this.dni = createVeterinarianCommand.dni();
        this.veterinarianSpeciality = VeterinarianSpeciality.valueOf(createVeterinarianCommand.veterinarianSpeciality());
    }

    public Veterinarian updateInformation(String fullName, String phoneNumber, String email, String dni, VeterinarianSpeciality veterinarianSpeciality) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.dni = dni;
        this.veterinarianSpeciality = veterinarianSpeciality;
        return this;
    }
}
