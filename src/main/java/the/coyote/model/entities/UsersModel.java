package the.coyote.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class UsersModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotNull
	private String email;
	
	@NotBlank
	private String password;
	
	@NotBlank
	private String cpf;
	
/*****************************************************************************/
	
	public UsersModel() {
		
	}
	
	public UsersModel(String email, String password, String cpf) {
		super();
		this.email = email;
		this.password = password;
		this.cpf = cpf;
	}
	
	
/*****************************************************************************/
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

/*****************************************************************************/
	
	@Override
	public String toString() {
		return "Users [id=" + id + ", email=" + email + ", password=" + password + ", cpf=" + cpf + "]";
	}
	
}
