package lab.epam.olavr.dao;

import java.sql.Date;

public class UserDB implements IEntity {

	public static enum UserDBQueries {
		INSERT("INSERT INTO coffee.user (login, password,fname,lname,email,roleId) VALUES ('%s', '%s', '%s', '%s', '%s', %s);"),
		// login is a unique identifier
		GET_BY_ID("SELECT login, password,fname,lname,email,roleId FROM coffee.user WHERE login = '%s';"), 
		GET_BY_FIELD("SELECT login, password,fname,lname,email,roleId FROM coffee.user WHERE %s = '%s';"), 
		GET_ALL("SELECT login, password,fname,lname,email,roleId FROM coffee.user;"), 
		UPDATE_BY_FIELD("UPDATE coffee.user SET %s = '%s';"),
		UPDATE_PASSWORD("UPDATE coffee.user SET password = '%s' WHERE login='%s';"),
		DELETE_BY_ID("DELETE FROM coffee.user WHERE login = '%s';");
		
		private String query;

		private UserDBQueries(String query) {
			this.query = query;
		}

		@Override
		public String toString() {
			return query;
		}
	}

	private String email;
	private String firstname;
	private String lastname;
	private String login;
	private String password;
	private Long roleId;
	
	public UserDB( String login, String password, String firstname, String lastname, String email,Long roleId
			) {
		super();
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.login = login;
		this.password = password;
		this.roleId = roleId;
	}

	// setters - - - - -

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	

	// getters - - - - -

	public String getEmail() {
		return email;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public Long getRoleId() {
		return roleId;
	}

	public Long getId() {
		return null;
	}


}
