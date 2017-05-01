package io.github.saidie.plantuml_api;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue
    private long id;

    @NotNull
    @Column(nullable = false)
    private String username;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Federation> federations;
}
