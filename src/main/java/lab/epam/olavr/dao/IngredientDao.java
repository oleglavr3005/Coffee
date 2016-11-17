package lab.epam.olavr.dao;

import java.sql.SQLException;
import java.sql.Statement;

import lab.epam.olavr.dao.IngredientDB.IngredientDBQueries;
import lab.epam.olavr.exception.GeneralCustomException;


public class IngredientDao extends ADao<IngredientDB> {
	private static volatile IngredientDao instance = null;

	private IngredientDao() {
		super();
		init();
	}

	public static IngredientDao get() {
		if (instance == null) {
			synchronized (IngredientDao.class) {
				if (instance == null) {
					instance = new IngredientDao();
				}
			}
		}
		return instance;
	}

	void init() {
		for (IngredientDBQueries IngredientDBQueries : IngredientDBQueries.values()) {
			sqlQueries.put(IngredientDBQueries.name(), IngredientDBQueries);
		}
	}

	protected IngredientDB createInstance(String[] args) {
		return new IngredientDB(
				Long.parseLong(args[0] == null ? "0" : args[0]),
				args[1] == null ? new String()  : args[1],
				Double.parseDouble(args[2] == null ? "0" : args[2]),
				Double.parseDouble(args[3] == null ? "0" : args[3]),
				Double.parseDouble(args[4] == null ? "0" : args[4])
				);
	}

	protected String[] getFields(IngredientDB entity) {
		String[] fields = new String[5];
		fields[0] = entity.getIngredientId().toString();
		fields[1] = entity.getIngredientName();
		fields[2] = entity.getAmount().toString();
		fields[3] = entity.getMaxAmount().toString();
		fields[4] = entity.getPrice().toString();
		return fields;
	}

	public IngredientDB  getIngredientDBById(Long id) {
		return getByFieldName("ingredientId", id.toString()).get(0);
	}

	public boolean updateAmount(Double sum, Long id) {
        boolean result = false;
        Statement statement = null;
        String query = sqlQueries.get("UPDATE_AMOUNT").toString();
        if (query == null) {
            throw new GeneralCustomException(String.format(QUERY_NOT_FOUND,
                    "UPDATE_BY_FIELD"));
//            throw new RuntimeException(String.format(QUERY_NOT_FOUND,
//                    "UPDATE_BY_FIELD"));
        }
        try {
            statement = ConnectionUtils.get().getConnection().createStatement();
            // TODO Use statement.executeUpdate
            result = statement.execute(String.format(query,sum, id));
        } catch (SQLException e) {
            throw new GeneralCustomException(DATABASE_READING_ERROR, e);
//            throw new RuntimeException(DATABASE_READING_ERROR, e);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (Exception ex) {
                    // TODO Warning
                }
            }
        }
        // TODO result must be return if delete Ok
        return result;
    }


	// TODO DELETE Method
	// public boolean deleteById(Long id) {
	// return super.deleteById(id);
	// }

}