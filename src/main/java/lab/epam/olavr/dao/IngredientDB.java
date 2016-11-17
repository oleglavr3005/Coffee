package lab.epam.olavr.dao;

public class IngredientDB  implements IEntity {

	public static enum IngredientDBQueries {
		INSERT("INSERT INTO Coffee.Ingredient (IngredientId, IngredientName,amount,maxAmount,price) VALUES (%s, '%s', %s, %s, %s);"),
		// login is a unique identifier
		GET_BY_ID("SELECT IngredientId, IngredientName,amount,maxAmount,price FROM Coffee.Ingredient WHERE IngredientId = '%s';"), 
		GET_BY_FIELD("SELECT IngredientId, IngredientName,amount,maxAmount,price FROM Coffee.Ingredient WHERE %s = '%s';"), 
		GET_ALL("SELECT IngredientId, IngredientName,amount,maxAmount,price FROM Coffee.Ingredient;"), 
		UPDATE_AMOUNT("UPDATE coffee.Ingredient SET amount=%s WHERE IngredientId =%s;"),
		UPDATE_BY_FIELD("UPDATE Coffee.Ingredient SET %s = '%s';"),
		DELETE_BY_ID("DELETE FROM Coffee.Ingredient WHERE IngredientId = '%s';");
		// DELETE_USER_BY_PARTIAL_LOGIN("DELETE dbo.Users WHERE Login LIKE
		// '%s%%';");
		private String query;

		private IngredientDBQueries(String query) {
			this.query = query;
		}

		@Override
		public String toString() {
			return query;
		}
	}

	private Long IngredientId;
	private String IngredientName;
	private Double amount;
	
	private Double maxAmount;
	private Double price;
	
	
	


	public Long getIngredientId() {
		return IngredientId;
	}


	public void setIngredientId(Long  IngredientId) {
		this.IngredientId = IngredientId;
	}


	public String getIngredientName() {
		return IngredientName;
	}


	public void setIngredientName(String IngredientName) {
		this.IngredientName = IngredientName;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getAmount() {
		return amount;
	}


	public void setAmount(Double amount) {
		this.amount = amount;
	}


	public Double getMaxAmount() {
		return maxAmount;
	}


	public void setMaxAmount(Double maxAmount) {
		this.maxAmount = maxAmount;
	}



	public IngredientDB(Long ingredientId, String ingredientName, Double amount, Double maxAmount, Double price) {
		super();
		IngredientId = ingredientId;
		IngredientName = ingredientName;
		this.amount = amount;
		this.maxAmount = maxAmount;
		this.price = price;
	}


	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return getIngredientId();
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((IngredientId == null) ? 0 : IngredientId.hashCode());
		result = prime * result + ((IngredientName == null) ? 0 : IngredientName.hashCode());
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((maxAmount == null) ? 0 : maxAmount.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IngredientDB other = (IngredientDB) obj;
		if (IngredientId == null) {
			if (other.IngredientId != null)
				return false;
		} else if (!IngredientId.equals(other.IngredientId))
			return false;
		if (IngredientName == null) {
			if (other.IngredientName != null)
				return false;
		} else if (!IngredientName.equals(other.IngredientName))
			return false;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (maxAmount == null) {
			if (other.maxAmount != null)
				return false;
		} else if (!maxAmount.equals(other.maxAmount))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		return true;
	}


	
}
