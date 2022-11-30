package com.rrozdoce.hotelapi.domain.repositories;

import com.rrozdoce.hotelapi.domain.entities.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findByUsername(String username);
}
