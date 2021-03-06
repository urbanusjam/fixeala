package ar.com.urbanusjam.fixeala.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;


@Entity
@Table(name="user")
public class User implements UserDetails {
	
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_user")
    private Long id;
  
    @Column(name="username", unique=true)
    private String username;
    
    @Column(name="password")
    private String password;
    
    @Column(name="email")
    private String email;
    
    @Column(name="first_name")
    private String nombre;
    
    @Column(name="last_name")
    private String apellido;
      
    @Column(name="city_of_residence")
    private String city;  
    
    @Column(name="province_of_residence")
    private String province;
           
    @Column(name="enabled")
    private boolean enabled;
    
    @Column(name="registration_date")
    private Date registrationDate;
    
    @Column(name="last_login_date")
    private Date lastLoginDate;
    
    @Column(name="last_password_change_date")
    private Date lastPasswordChangeDate;
    
    @Column(name="closed_account_date")
    private Date closedAccountDate;
    
    @Transient
    private boolean accountNonExpired;

    @Transient
    private boolean accountNonLocked;

    @Transient
    private boolean credentialsNonExpired;

//	@Transient
//	private Collection<GrantedAuthority> grantedAuthorities;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "user_role",
	         joinColumns = @JoinColumn(name = "id_user"),
	         inverseJoinColumns = @JoinColumn(name = "id_role"))
    private Collection<Authority> roles;  
    

	//Constructors
	public User() { }
    
    public User(String username) {
    	this.username = username;
    }

    public User(String username, String password, String email, boolean enabled, Collection<Authority> roles) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.enabled = enabled;
        this.roles =  roles;
    }

    public User(String username, String password, boolean enabled, boolean accountNonExpired, boolean accountNonLocked, 
    		boolean credentialsNonExpired, Collection<Authority> roles) {
    	
        if (((username == null) || "".equals(username)) || (password == null)) {
            throw new IllegalArgumentException("Cannot pass null or empty values to constructor");
        }
        
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
        this.roles =  roles;
    }
    
    
      
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return this.password;
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
		
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public boolean isEnabled() {
        return this.enabled;
    }
    
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    
	public void setRoles(Collection<Authority> roles) {
		this.roles = roles;
	}	

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public Date getLastPasswordChangeDate() {
		return lastPasswordChangeDate;
	}

	public void setLastPasswordChangeDate(Date lastPasswordChangeDate) {
		this.lastPasswordChangeDate = lastPasswordChangeDate;
	}

	public Date getClosedAccountDate() {
		return closedAccountDate;
	}

	public void setClosedAccountDate(Date closedAccountDate) {
		this.closedAccountDate = closedAccountDate;
	}

	public boolean isAccountNonExpired() { 
    	return this.accountNonExpired;
    }
    
    public void setAccountNonExpired(boolean accountNonExpired) { 
    	this.accountNonExpired = accountNonExpired;
    }

    public boolean isAccountNonLocked() { 
    	return this.accountNonLocked;
    }
    
    public void setAccountNonLocked(boolean accountNonLocked) { 
    	this.accountNonLocked = accountNonLocked; 
    }

    public boolean isCredentialsNonExpired() {
    	return this.credentialsNonExpired;
    }
    
    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
    	this.credentialsNonExpired = credentialsNonExpired; 
    }

//	public boolean hasRole(String role, Collection<GrantedAuthority> authorities) {
//       boolean hasRole = false;
//       
//       for (GrantedAuthority grantedAuthority : authorities) {
//    	   hasRole = grantedAuthority.getAuthority().equals(role);
//           break;
//       }       
//     
//        return hasRole;
//    }
    
    public boolean hasRole(String role, Collection<Authority> authorities) {
        boolean hasRole = false;
        
        for (Authority authority : authorities) {
     	   hasRole = authority.getAuthority().equals(role);
            break;
        }       
      
         return hasRole;
     }
    
//    public boolean hasSingleRole(String role, Collection<GrantedAuthority> authorities) {
//        boolean hasRole = false;        
//        if(authorities.size() == 1){
//        	for (GrantedAuthority grantedAuthority : authorities) {
//          	     hasRole = grantedAuthority.getAuthority().equals(role);              
//             }  
//        }               
//        return hasRole;        
//     }
    
    public boolean hasSingleRole(String role, Collection<Authority> authorities) {
        boolean hasRole = false;        
        if(authorities.size() == 1){
        	for (Authority authority : authorities) {
          	     hasRole = authority.getAuthority().equals(role);              
             }  
        }               
        return hasRole;        
     }
    
    
    public void setGrantedAuthorities(List<Authority> roles) {
        List<Authority> listOfAuthorities = new ArrayList<Authority>();
        for (Authority role : roles) {
            listOfAuthorities.add(new Authority(role.getAuthority()));
        }
        this.roles = (Collection<Authority>) listOfAuthorities;
    }
    
	public Collection<Authority> getRoles() {
		return roles;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	
   
}