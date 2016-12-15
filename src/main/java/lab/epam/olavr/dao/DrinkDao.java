package lab.epam.olavr.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import lab.epam.olavr.dao.DrinkDB.DrinkDBQueries;
import lab.epam.olavr.exception.GeneralCustomException;

public class DrinkDao extends ADao<DrinkDB> {
	private static volatile DrinkDao instance = null;
	public static final Logger log = Logger.getLogger(DrinkDao.class);  
	private DrinkDao() {
		super();
		init();
	}

	public static DrinkDao get() {
		if (instance == null) {
			synchronized (DrinkDao.class) {
				if (instance == null) {
					instance = new DrinkDao();
				}
			}
		}
		return instance;
	}

	void init() {
		for (DrinkDBQueries drinkDBQueries : DrinkDBQueries.values()) {
			sqlQueries.put(drinkDBQueries.name(), drinkDBQueries);
		}
	}

	protected DrinkDB createInstance(String[] args) {
		return new DrinkDB(Long.parseLong(args[0] == null ? "0" : args[0]), args[1] == null ? new String() : args[1],
				Double.parseDouble(args[2] == null ? "0" : args[2]));
	}

	protected String[] getFields(DrinkDB entity) {
		String[] fields = new String[3];
		fields[0] = entity.getDrinkId().toString();
		fields[1] = entity.getDrinkName();
		fields[2] = entity.getPrice().toString();
		return fields;
	}

	public DrinkDB getDrinkDBById(Long id) {
		return getByFieldName("drinkId", id.toString()).get(0);
	}

	public Map<IngredientDB, Double> getDrinkExpenses(Long id) {
		Statement statement = null;
		ResultSet resultSet = null;
		Map<IngredientDB, Double> totals = new HashMap<>();
		String query = "SELECT i.ingredientId,SUM(r.amount) FROM coffee.ingredient i,coffee.recipe r "
				+ "WHERE i.ingredientId=r.ingredientId AND drinkId=%s GROUP BY ingredientId;";
		Long i = -1L;
		Double total = 0.0;
		try {
			statement = ConnectionUtils.get().getConnection().createStatement();
			resultSet = statement.executeQuery(String.format(query, id));
			if (resultSet.next()) {
				;
			} else {
				throw new GeneralCustomException(String.format(EMPTY_RESULTSET, query));	
			}
			;

			do {
				i = resultSet.getLong(1);
				total = resultSet.getDouble(2);
				System.out.println(i + " " + total + " " + IngredientDao.get().getIngredientDBById(id).hashCode());
				totals.put(IngredientDao.get().getIngredientDBById(i), total);
			} while (resultSet.next());
		} catch (SQLException e) {
			throw new GeneralCustomException(DATABASE_READING_ERROR, e);
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (Exception ex) {
					log.warn("Database error: Drink");
				}
			}
			if (statement != null) {
				try {
					statement.close();
				} catch (Exception ex) {
					log.warn("Database error:Drink");
				}
			}
		}
		return totals;
	}


}
