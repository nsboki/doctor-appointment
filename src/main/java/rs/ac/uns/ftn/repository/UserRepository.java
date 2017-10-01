package rs.ac.uns.ftn.repository;

import org.springframework.data.repository.CrudRepository;

import rs.ac.uns.ftn.entity.User;

public interface UserRepository extends CrudRepository<User, Long>{

}
