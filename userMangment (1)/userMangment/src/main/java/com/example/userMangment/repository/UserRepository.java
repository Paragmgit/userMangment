package com.example.userMangment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.userMangment.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

}
