package com.infitry.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.infitry.user.entity.User;

/**
 * @since 2020. 3. 31.
 * @author leesw
 * @mail leesw504@gmail.com
 * @description : 유저 리파지토리
 */
public interface UserRepository extends JpaRepository<User, Long> {
	
	  @Query("SELECT u FROM User u WHERE u.id = :id") 
      User findUserById(@Param("id") String id);
}
