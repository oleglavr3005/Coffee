package lab.epam.olavr.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lab.epam.olavr.dao.AccountDB;
import lab.epam.olavr.dao.AccountDao;
import lab.epam.olavr.dao.DrinkDB;
import lab.epam.olavr.dao.DrinkDao;
import lab.epam.olavr.dao.IngredientDB;
import lab.epam.olavr.dao.IngredientDao;
import lab.epam.olavr.model.Order;

//TODO class order drink+Ingredients 
public class OrderService {
	public static Double getValue(DrinkDB drink, List<IngredientDB> ingrs, List<String> amounts) {
		if (ingrs.size() != amounts.size()) {
			throw new RuntimeException("Invalid parameters");

		} else {
			Double value = drink.getPrice();
			for (int i = 0; i < ingrs.size(); i++) {
				value += ingrs.get(i).getPrice() * Integer.parseInt(amounts.get(i));
			}

			return (double) value;
		}
	}

	public static Double getValue(Order order) {

		Double value = order.getDrink().getPrice();
		for (IngredientDB ingr : order.getIngredients().keySet()) {
			value += ingr.getPrice() * order.getIngredients().get(ingr);
		}
		return value;
	}

	public static Map<IngredientDB, Double> calcExpenses(DrinkDB drink, List<IngredientDB> ingrs,
			List<String> amounts) {
		if (ingrs.size() != amounts.size()) {
			throw new IllegalArgumentException("Invalid arguments");
		}

		HashMap<IngredientDB, Double> expenses = (HashMap<IngredientDB, Double>) DrinkDao.get()
				.getDrinkExpenses(drink.getId());
		for (int i = 0; i < ingrs.size(); i++) {
			IngredientDB currIngr = ingrs.get(i);
			if (expenses.containsKey(currIngr)) {
				expenses.put(currIngr, expenses.get(currIngr) + Double.parseDouble(amounts.get(i)));
			} else {
				expenses.put(currIngr, Double.parseDouble(amounts.get(i)));
			}
		}
		System.out.println("Expenses" + expenses);
		return expenses;

	}
	public static Map<IngredientDB, Double> calcExpenses(Order order) {
		HashMap<IngredientDB, Double> expenses = (HashMap<IngredientDB, Double>) DrinkDao.get()
				.getDrinkExpenses(order.getDrink().getId());
		for (IngredientDB ingr : order.getIngredients().keySet()) {
			if (expenses.containsKey(ingr)) {
				expenses.put(ingr, expenses.get(ingr) +  order.getIngredients().get(ingr));
			} else {
				expenses.put(ingr, new Double(order.getIngredients().get(ingr)));
			}
		}
		System.out.println("Expenses" + expenses);
		return expenses;

	}

	public static void finishOrder(Order order) {
		//decrease sum on account
		AccountDB account=AccountDao.get().getByFieldName("user", order.getUser().getLogin()).get(0);
		Double amount=account.getAmount();
		Long id=account.getAccountId();
		AccountDao.get().updateAmount(amount-OrderService.getValue(order),id );
		
		//decrease amounts of ingredients
		List<IngredientDB> ingredients= IngredientDao.get().getAll(); 
		Map<IngredientDB, Double>totalExpenses=OrderService.calcExpenses(order);
		for (IngredientDB ingr:ingredients){
			Double expenses=totalExpenses.get(ingr);
			id=ingr.getIngredientId();
			IngredientDao.get().updateAmount(ingr.getAmount()-expenses,id );
		}

		
	}
}
