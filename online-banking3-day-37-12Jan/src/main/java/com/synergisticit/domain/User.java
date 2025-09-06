package com.synergisticit.domain;


import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@AllArgsConstructor
//@ToString
@Getter
@Setter
@Entity
@Table(name="user")
public class User {
	
	@Id // primary key
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NotNull
    private Long userId;
    
	@NotEmpty
	@Column(name="name")
    String username;
    
	@NotEmpty
    String password;
    
	public List<Role> getRoles() {
		return roles;
	}



	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}



	@Email
	@NotEmpty
    String email;
	
	
    
    public Long getUserId() {
		return userId;
	}



	public void setUserId(Long userId) {
		this.userId = userId;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	@ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(
    	name = "user_role",
    	joinColumns = {@JoinColumn(name="user_id")},
    	inverseJoinColumns = {@JoinColumn(name="role_id")}
    
    		
    		)
     List<Role> roles = new ArrayList<>();
    
    
    
    
    
}
