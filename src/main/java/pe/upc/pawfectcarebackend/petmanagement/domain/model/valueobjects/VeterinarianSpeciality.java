package pe.upc.pawfectcarebackend.petmanagement.domain.model.valueobjects;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Specialities of veterinarians in the veterinary clinic")
public enum VeterinarianSpeciality {
    @Schema(description = "General Medicine")
    GENERAL_MEDICINE,

    @Schema(description = "Veterinary Surgery")
    VETERINARY_SURGERY,

    @Schema(description = "Veterinary Pathology")
    VETERINARY_PATHOLOGY,

    @Schema(description = "Veterinary Radiology")
    VETERINARY_RADIOLOGY,

    @Schema(description = "Veterinary Nutrition")
    VETERINARY_NUTRITION,

    @Schema(description = "Veterinary Behavior")
    VETERINARY_BEHAVIOR,

    @Schema(description = "Veterinary Ophthalmology")
    VETERINARY_OPHTHALMOLOGY,

    @Schema(description = "Veterinary Dermatology")
    VETERINARY_DERMATOLOGY,

    @Schema(description = "Veterinary Cardiology")
    VETERINARY_CARDIOLOGY,

    @Schema(description = "Veterinary Oncology")
    VETERINARY_ONCOLOGY,

    @Schema(description = "Veterinary Neurology")
    VETERINARY_NEUROLOGY,

    @Schema(description = "Veterinary Orthopedics")
    VETERINARY_ORTHOPEDICS,

    @Schema(description = "Veterinary Physiotherapy")
    VETERINARY_PHYSIOTHERAPY,

    @Schema(description = "Emergency and Critical Care")
    EMERGENCY_AND_CRITICAL_CARE
}