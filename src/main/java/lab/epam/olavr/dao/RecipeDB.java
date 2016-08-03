package lab.epam.olavr.dao;

public class RecipeDB  implements IEntity {

	public static enum RecipeDBQueries {
		INSERT("INSERT INTO Coffee.Recipe (drinkId, ingredientId,amount) VALUES (%s, %s, %s);"),
		// login is a unique identifier
		GET_BY_ID("SELECT drinkId, ingredientId,amount FROM Coffee.Recipe WHERE RecipeId = '%s' AND  ingredientId= '%s';"), 
		GET_BY_FIELD("SELECT RecipeId, RecipeName,price FROM Coffee.Recipe WHERE %s = '%s';"), 
		GET_ALL("SELECT RecipeId, RecipeName,price FROM Coffee.Recipe;"), 
		UPDATE_BY_FIELD("UPDATE Coffee.Recipe SET %s = '%s';"),
		DELETE_BY_ID("DELETE Coffee.Recipe WHERE RecipeId = '%s' AND  ingredientId= '%s';");
		// DELETE_USER_BY_PARTIAL_LOGIN("DELETE dbo.Users WHERE Login LIKE
		// '%s%%';");
		private String query;

		private RecipeDBQueries(String query) {
			this.query = query;
		}

		@Override
		public String toString() {
			return query;
		}
	}

	private Long drinkId;
	private Long ingredientId;
	private Double amount;
	
	
	
	public RecipeDB(Long drinkId, Long ingredientId, Double amount) {
		super();
		this.drinkId = drinkId;
		this.ingredientId = ingredientId;
		this.amount = amount;
	}
	@Override
	public Long getId() {
		return getDrinkId();
	}
	public Long getDrinkId() {
		return drinkId;
	}
	public void setDrinkId(Long drinkId) {
		this.drinkId = drinkId;
	}
	public Long getIngredientId() {
		return ingredientId;
	}
	public void setIngredientId(Long ingredientId) {
		this.ingredientId = ingredientId;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	
	

}
