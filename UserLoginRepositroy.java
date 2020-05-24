package com.account.dao;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.account.model.Login;

public interface UserLoginRepositroy extends JpaRepository<Login, Long> {

}
