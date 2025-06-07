package pe.upc.pawfectcarebackend.feedback.domain.model.aggregates;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import pe.upc.pawfectcarebackend.feedback.domain.model.commands.CreateReviewCommand;
import pe.upc.pawfectcarebackend.petmanagement.domain.model.aggregates.Veterinarian;
import pe.upc.pawfectcarebackend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

@Getter
@Entity
public class Review extends AuditableAbstractAggregateRoot<Review> {
    private String content;
    private Integer rating;

    @Setter
    @Getter
    @ManyToOne
    @JoinColumn(name = "veterinarian_id")
    private Veterinarian veterinarian;

    public Review() {
        this.content = "";
        this.rating = 1;
    }

    public Review(CreateReviewCommand command) {
        this();
        this.content = command.content();
        this.rating = command.rating();
    }

    public Review updateInformation(String content, Integer rating) {
        this.content = content;
        this.rating = rating;
        return this;
    }
}
