package lab.epam.olavr.dao;

public class RoleDB  implements IEntity {

	public static enum RoleDBQueries {
		INSERT("INSERT INTO coffee.Role (RoleId, RoleName) VALUES (%s, %s);"),
		// login is a unique identifier
		GET_BY_ID("SELECT RoleId, RoleName FROM coffee.Role WHERE RoleId = '%s';"), 
		GET_BY_FIELD("SELECT RoleId, RoleName FROM coffee.Role WHERE %s = '%s';"), 
		GET_ALL("SELECT RoleId, RoleName FROM coffee.Role;"), 
		UPDATE_BY_FIELD("UPDATE coffee.Role SET %s = '%s';"),
		DELETE_BY_ID("DELETE coffee.Role WHERE RoleId = '%s';");
		// DELETE_USER_BY_PARTIAL_LOGIN("DELETE dbo.Users WHERE Login LIKE
		// '%s%%';");
		private String query;

		private RoleDBQueries(String query) {
			this.query = query;
		}

		@Override
		public String toString() {
			return query;
		}
	}

	private Long RoleId;
	private String RoleName;
	
	
	public RoleDB(Long RoleId, String RoleName) {
		super();
		this.RoleId = RoleId;
		this.RoleName = RoleName;
	}


	public Long getRoleId() {
		return RoleId;
	}


	public void setRoleId(Long  RoleId) {
		this.RoleId = RoleId;
	}


	public String getRoleName() {
		return RoleName;
	}


	public void setRoleName(String RoleName) {
		this.RoleName = RoleName;
	}



	@Override
	public Long getId() {
		return getRoleId();
	}


	
}
