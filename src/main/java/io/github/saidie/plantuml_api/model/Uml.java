package io.github.saidie.plantuml_api.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Uml {
    @Id
    @GeneratedValue
    private long id;

    @Lob @Basic(fetch=FetchType.LAZY)
    @Column(nullable = false, columnDefinition="TEXT")
    private String content;
}
