package br.com.pucminas.tcc.ms.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query("select u from User u join fetch u.profile where u.id = :id")
    Optional<User> findByIdFetchProfile(Long id);

}
