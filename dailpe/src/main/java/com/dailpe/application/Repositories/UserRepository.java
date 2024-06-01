package com.dailpe.application.Repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dailpe.application.Models.User;

import jakarta.transaction.Transactional;


@Repository
public interface UserRepository  extends JpaRepository<User,java.lang.String>{
    
    @Transactional
    @Query("SELECT u FROM User u")
    public List<User> findAllUsers(Pageable page);
    
    public List<User> findByUserIdOrMobileNumber(String userId,String mob);
}
