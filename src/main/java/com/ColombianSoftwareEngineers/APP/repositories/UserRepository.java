package com.ColombianSoftwareEngineers.APP.repositories;

import com.ColombianSoftwareEngineers.APP.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByAuth0idUser(String auth0id);
}
