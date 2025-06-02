package pe.upc.pawfectcarebackend.feedback.domain.model.aggregates;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import pe.upc.pawfectcarebackend.petmanagement.domain.model.aggregates.Veterinarian;
import pe.upc.pawfectcarebackend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

@Getter
@Entity
public class Review extends AuditableAbstractAggregateRoot<Review> {
    private String content;
    private int rating;

    /*
    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "veterinarian_id")
    @NotNull
    @JsonIgnore
    private Veterinarian veterinarian;*/

    public Review() {
        this.content = "";
        this.rating = 0;
    }

    public Review(String content, int rating) {
        this.content = content;
        this.rating = rating;
    }

    public Review updateReview(String content, int rating) {
        this.content = content;
        this.rating = rating;
        return this;
    }
}
