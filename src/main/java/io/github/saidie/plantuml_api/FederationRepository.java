package io.github.saidie.plantuml_api;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface FederationRepository extends PagingAndSortingRepository<Federation, IdpId> {
}
