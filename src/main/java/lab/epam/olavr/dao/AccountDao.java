package lab.epam.olavr.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import lab.epam.olavr.dao.AccountDB.AccountDBQueries;
import lab.epam.olavr.exception.GeneralCustomException;
import lab.epam.olavr.servlets.AddIngredients;

public class AccountDao extends ADao<AccountDB> {
	private static volatile AccountDao instance = null;
	public static final Logger log = Logger.getLogger(AccountDao.class);  
	private AccountDao() {
		super();
		init();
	}

	public static AccountDao get() {
		if (instance == null) {
			synchronized (AccountDao.class) {
				if (instance == null) {
					instance = new AccountDao();
				}
			}
		}
		return instance;
	}

	void init() {
		for (AccountDBQueries AccountDBQueries : AccountDBQueries.values()) {
			sqlQueries.put(AccountDBQueries.name(), AccountDBQueries);
		}
	}

	protected AccountDB createInstance(String[] args) {
		return new AccountDB(
				Long.parseLong(args[0] == null ? "0" : args[0]),
				Double.parseDouble(args[1] == null ? "0" : args[1]),
				args[2] == null ? "0" : args[2]
				);
	}

	protected String[] getFields(AccountDB entity) {
		String[] fields = new String[3];
		fields[0] = entity.getAccountId().toString();
		fields[1] = entity.getAmount().toString();
		fields[2] = entity.getUser();
		return fields;
	}

	public AccountDB  getAccountDBById(Long id) {
		return getByFieldName("accountId", id.toString()).get(0);
	}

	public Long getMaxId(){
	        Statement statement = null;
	        ResultSet resultSet = null;
	        String query = "SELECT MAX(accountID) FROM coffee.account;";
	        String[] queryResult;
	        Long i=-1L;
	       
	        try {
	            statement = ConnectionUtils.get().getConnection().createStatement();
	            resultSet = statement.executeQuery(query);
	            if (resultSet.next()) {
	            	i=resultSet.getLong(1);
	            } else {
	                throw new GeneralCustomException(String.format(EMPTY_RESULTSET,
	                        query));
	            }
	        } catch (SQLException e) {
	            throw new GeneralCustomException(DATABASE_READING_ERROR, e);
	        } finally {
	            if (resultSet != null) {
	                try {
	                    resultSet.close();
	                } catch (Exception ex) {
	                    log.warn("Database error: Account");
	                }
	            }
	            if (statement != null) {
	                try {
	                    statement.close();
	                } catch (Exception ex) {
	                	 log.warn("Database error: Account");
	                }
	            }
	        }
	        return i;
	}
	
	public boolean updateAmount(Double sum, Long id) {
        boolean result = false;
        Statement statement = null;
        String query = sqlQueries.get("UPDATE_AMOUNT").toString();
        if (query == null) {
            throw new GeneralCustomException(String.format(QUERY_NOT_FOUND,
                    "UPDATE_BY_FIELD"));
        }
        try {
            statement = ConnectionUtils.get().getConnection().createStatement();
          
            result = statement.execute(String.format(query,sum, id));
        } catch (SQLException e) {
            throw new GeneralCustomException(DATABASE_READING_ERROR, e);
//            throw new RuntimeException(DATABASE_READING_ERROR, e);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (Exception ex) {
                	 log.warn("Database error: Account");
                }
            }
        }
   
        return result;
    }

}
