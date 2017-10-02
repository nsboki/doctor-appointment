package ftn.repository;

import org.springframework.data.repository.CrudRepository;

import ftn.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
