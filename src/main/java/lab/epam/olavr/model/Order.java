package lab.epam.olavr.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lab.epam.olavr.dao.DrinkDB;
import lab.epam.olavr.dao.DrinkDao;
import lab.epam.olavr.dao.IngredientDB;
import lab.epam.olavr.dao.UserDB;
import lab.epam.olavr.service.OrderService;

public class Order {
	private UserDB user;
	private DrinkDB drink;
	private Map<IngredientDB, Integer> ingredients;

	public Order(UserDB user, DrinkDB drink, Map<IngredientDB, Integer> ingredients) {
		super();
		this.user=user;
		this.drink = drink;
		this.ingredients = ingredients;
	}

	public Order(UserDB user,DrinkDB drink, List<IngredientDB> ingrs, List<String> amounts) {
		super();
		this.user=user;
		this.drink = drink;
		this.ingredients = new HashMap<>();
		if (ingrs.size() != amounts.size()) {
			throw new IllegalArgumentException("Invalid arguments");
		}
		for (int i = 0; i < ingrs.size(); i++) {

			ingredients.put(ingrs.get(i), Integer.parseInt(amounts.get(i)));
		}
	}

	public DrinkDB getDrink() {
		return drink;
	}

	public void setDrink(DrinkDB drink) {
		this.drink = drink;
	}

	public Map<IngredientDB, Integer> getIngredients() {
		return ingredients;
	}

	public void setIngredients(Map<IngredientDB, Integer> ingredients) {
		this.ingredients = ingredients;
	}

	public UserDB getUser() {
		return user;
	}

	public void setUser(UserDB user) {
		this.user = user;
	}
	public Double getSum() {
		return OrderService.getValue(this);
	}
}
