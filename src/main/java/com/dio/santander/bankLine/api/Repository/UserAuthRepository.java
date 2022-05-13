package com.dio.santander.bankLine.api.Repository;

import com.dio.santander.bankLine.api.Model.UserAuthentication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface UserAuthRepository extends JpaRepository<UserAuthentication, Long> {

    public Optional<UserAuthentication> findByUserName(String userName);

}
