package io.github.saidie.plantuml_api;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Federation {
    @EmbeddedId
    private IdpId id;

    @NotNull
    @ManyToOne
    private Account account;
}
