package io.github.saidie.plantuml_api;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class IdpId implements Serializable {
    @NotNull
    @Enumerated(EnumType.STRING)
    private FederationType type;

    @NotNull
    @Column(nullable = false)
    private String id;

    public enum FederationType {
        TWITTER
    }
}
