package lab.epam.olavr.dao;

public class AccountDB  implements IEntity {

	public static enum AccountDBQueries {
		INSERT("INSERT INTO coffee.Account (accountId,amount,user) VALUES (%s,%s,'%s');"),
		// login is a unique identifier
		GET_BY_ID("SELECT AccountId, amount,user FROM coffee.Account WHERE AccountId = '%s';"), 
		GET_BY_FIELD("SELECT AccountId, amount,user FROM coffee.Account WHERE %s = '%s';"), 
		GET_ALL("SELECT AccountId, amount,user FROM coffee.Account;"), 
		UPDATE_BY_FIELD("UPDATE coffee.Account SET %s = '%s';"),
		UPDATE_AMOUNT("UPDATE coffee.Account SET amount=%s WHERE AccountId =%s;"),
		DELETE_BY_ID("DELETE coffee.Account WHERE AccountId = %s;");
		// DELETE_USER_BY_PARTIAL_LOGIN("DELETE dbo.Users WHERE Login LIKE
		// '%s%%';");
		private String query;

		private AccountDBQueries(String query) {
			this.query = query;
		}

		@Override
		public String toString() {
			return query;
		}
	}

	private Long accountId;
	private Double amount;
	private String user;
	
	public AccountDB(Long accountId, Double amount,String user) {
		super();
		this.accountId = accountId;
		this.amount = amount;
		this.user=user;
	}



	public Long getAccountId() {
		return accountId;
	}


	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}


	@Override
	public Long getId() {
		return getAccountId();
	}

	public void setUser(String user) {
		this.user=user;
	}

	public String getUser() {
		return user;
	}


	
}
