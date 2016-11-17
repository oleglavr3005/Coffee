package lab.epam.olavr.dao;


public class DrinkDB  implements IEntity {

	public static enum DrinkDBQueries {
		INSERT("INSERT INTO coffee.drink (drinkId, drinkName,price) VALUES (%s, '%s', %s);"),
		// login is a unique identifier
		GET_BY_ID("SELECT drinkId, drinkName,price FROM coffee.drink WHERE drinkId = '%s';"), 
		GET_BY_FIELD("SELECT drinkId, drinkName,price FROM coffee.drink WHERE %s = '%s';"), 
		GET_ALL("SELECT drinkId, drinkName,price FROM coffee.drink;"), 
		UPDATE_BY_FIELD("UPDATE coffee.drink SET %s = '%s';"),
		DELETE_BY_ID("DELETE coffee.drink WHERE drinkId = '%s';");
		// DELETE_USER_BY_PARTIAL_LOGIN("DELETE dbo.Users WHERE Login LIKE
		// '%s%%';");
		private String query;

		private DrinkDBQueries(String query) {
			this.query = query;
		}

		@Override
		public String toString() {
			return query;
		}
	}

	private Long drinkId;
	private String drinkName;
	private Double price;
	
	
	public DrinkDB(Long drinkId, String drinkName, Double price) {
		super();
		this.drinkId = drinkId;
		this.drinkName = drinkName;
		this.price = price;
	}


	public Long getDrinkId() {
		return drinkId;
	}


	public void setDrinkId(Long  drinkId) {
		this.drinkId = drinkId;
	}


	public String getDrinkName() {
		return drinkName;
	}


	public void setDrinkName(String drinkName) {
		this.drinkName = drinkName;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	@Override
	public Long getId() {
		return getDrinkId();
	}


	
}
