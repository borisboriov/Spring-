package spring.demo.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring.demo.spring.entities.Authorities;

@Repository
public interface RoleRepository extends CrudRepository<Authorities, Long> {
}
