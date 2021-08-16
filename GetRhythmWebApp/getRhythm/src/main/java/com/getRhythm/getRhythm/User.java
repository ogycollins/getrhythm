package com.getRhythm.getRhythm;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;  
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.AssertFalse;
import javax.persistence.JoinColumn;

import org.springframework.beans.factory.annotation.Autowired;

import com.sun.istack.NotNull;


@Entity // This tells Hibernate to make a table out of this class

@Table(name="user")
public class User {
	
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer id;

  @Column(nullable = false, unique = true)
  private String username;
  
  @Column(nullable = false, unique = true)
  private String password;
  
  @Column(nullable = false)
  private String dob;

  @Column(nullable = false)
  private String name;
 
  @Column(nullable = false, unique = true)
  private String email;
  
  @Column(nullable = false)
  private int progress = 1;
  
  @Column(nullable = false)
  private boolean enabled;
  
  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinTable(
          name = "users_roles",
          joinColumns = @JoinColumn(name = "user_id"),
          inverseJoinColumns = @JoinColumn(name = "role_id")
          )
  private Set<Role> roles = new HashSet<>();
  

  public Set<Role> getRoles() {
	return roles;
}

public void setRoles(Set<Role> roles) {
	this.roles = roles;
}

public Integer getId() {
    return id;
  }
  
  public String getName() {
    return name;
  }
  
  public String getUsername() {
	    return username;
	  }
  
  public String getPassword() {
	    return password;
	  }
  
  public String getDOB() {
	    return dob;
	  }
  
  public String getEmail() {
	    return email;
	  }
  
  public Integer getProgress() {
	    return progress;
	  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }


  public void setEmail(String email) {
    this.email = email;
  }
  
  public void setPassword(String password) {
	    this.password = password;
	  }

  public void setUsername(String username) {
    this.username = username;
  }
  
  public void setDOB(String dob) {
	    this.dob = dob;
	  }

  public void setProgress(int progress) {
    this.progress = progress;
  }

public boolean isEnabled() {
	return enabled;
}

public void setEnabled(boolean enabled) {
	this.enabled = enabled;
}
  
  
}
