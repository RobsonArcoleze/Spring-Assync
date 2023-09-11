package br.com.robson.completablefeatureimplementation.repositories;

import br.com.robson.completablefeatureimplementation.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
