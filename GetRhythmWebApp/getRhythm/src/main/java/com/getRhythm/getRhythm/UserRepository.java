package com.getRhythm.getRhythm;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.data.jpa.repository.Query; 

// Auto-implemented by Spring into a Bean called userRepository


public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT u FROM User u WHERE u.username = ?1")
    public User findByUsername(String username);
    
    @Query("SELECT u FROM User u WHERE u.name = ?1")
    public User findByName(String name);
 
    public boolean existsUserByUsername(String username);

	public boolean existsUserByEmail(String email);

    
}


