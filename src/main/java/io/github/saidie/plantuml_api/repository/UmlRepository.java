package io.github.saidie.plantuml_api.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import io.github.saidie.plantuml_api.model.Uml;

@RepositoryRestResource
public interface UmlRepository extends PagingAndSortingRepository<Uml, Long> {
}
