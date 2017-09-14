package ch.collen.registryservice;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by cyril on 13/09/17.
 */
@RepositoryRestResource(path = "caisse")
public interface CaisseRestRepository extends PagingAndSortingRepository<Caisse, Long> {
}
