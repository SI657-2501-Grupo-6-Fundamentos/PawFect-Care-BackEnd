package pe.upc.pawfectcarebackend.petmanagement.domain.model.queries;

import pe.upc.pawfectcarebackend.petmanagement.domain.model.valueobjects.VeterinarianSpeciality;

public record GetAllVeterinariansBySpecialityQuery(VeterinarianSpeciality speciality) {
}
