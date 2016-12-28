package lab.epam.olavr.dao;


import java.util.List;

import lab.epam.olavr.dao.DrinkDB.DrinkDBQueries;
import lab.epam.olavr.dao.RecipeDB.RecipeDBQueries;


public class RecipeDao extends ADao<RecipeDB> {
	private static volatile RecipeDao instance = null;

	private RecipeDao() {
		super();
		//init();
	}

	public static RecipeDao get() {
		if (instance == null) {
			synchronized (DrinkDao.class) {
				if (instance == null) {
					instance = new RecipeDao();
				}
			}
		}
		return instance;
	}

	void init() {
		for (RecipeDBQueries recipeDBQueries : RecipeDBQueries.values()) {
			sqlQueries.put(recipeDBQueries.name(), recipeDBQueries);
		}
	}

	protected RecipeDB createInstance(String[] args) {
		return new RecipeDB(
				Long.parseLong(args[0] == null ? "0" : args[0]),
				Long.parseLong(args[1] == null ? "0" : args[1]),
				Double.parseDouble(args[2] == null ? "0" : args[2])
				);
	}

	protected String[] getFields(RecipeDB entity) {
		String[] fields = new String[3];
		fields[0] = entity.getDrinkId().toString();
		fields[1] = entity.getIngredientId().toString();
		fields[2] = entity.getAmount().toString();
		return fields;
	}

	public RecipeDB  getRecipeDBById(Long drinkId,Long ingredientId) {
		
		List<RecipeDB> list=getByFieldName("recipeId", drinkId.toString());
		for (RecipeDB r:list){
			if (r.getIngredientId().equals(ingredientId))
				return r;
		}
		return null;
	}
}
