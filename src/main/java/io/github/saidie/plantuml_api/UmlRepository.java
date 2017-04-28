package io.github.saidie.plantuml_api;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface UmlRepository extends PagingAndSortingRepository<Uml, Long> {
}
