package io.github.saidie.plantuml_api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import io.github.saidie.plantuml_api.model.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
}
