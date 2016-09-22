package lab.epam.olavr.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import lab.epam.olavr.dao.UserDB.UserDBQueries;
import lab.epam.olavr.exception.GeneralCustomException;


public class UserDao extends ADao<UserDB> {
	private static volatile UserDao instance = null;
	public static final Logger log = Logger.getLogger(UserDao.class);  
	private UserDao() {
		super();
		init();
	}

	public static UserDao get() {
		if (instance == null) {
			synchronized (UserDao.class) {
				if (instance == null) {
					instance = new UserDao();
				}
			}
		}
		return instance;
	}

	void init() {
		for (UserDBQueries userDBQueries : UserDBQueries.values()) {
			sqlQueries.put(userDBQueries.name(), userDBQueries);
		}
	}

	protected UserDB createInstance(String[] args) {
		return new UserDB(
				args[0] == null ? "0" : args[0],
				args[1] == null ? new String() : args[1],
				args[2] == null ? new String() : args[2],
				args[3] == null ? new String() : args[3],
				args[4] == null ? new String() : args[4],
				Long.parseLong(args[5] == null ? "0" : args[5]));
	}

	protected String[] getFields(UserDB entity) {
		String[] fields = new String[6];
		fields[0] = entity.getLogin();
		fields[1] = entity.getPassword();
		fields[2] = entity.getFirstname();
		fields[3] = entity.getLastname();
		fields[4] = entity.getEmail();
		fields[5] = entity.getRoleId().toString();
		return fields;
	}

	public UserDB getUserDBByLogin(String login) {
		for (UserDB userDB : getByFieldName("Login", login)) {
			System.out.println("  getLogin = " + userDB.getLogin()+
				"  getFirstname = " + userDB.getFirstname()+
				"  getLastname = " + userDB.getLastname()
				);
		}
		return getByFieldName("Login", login).get(0);
	}
	public Boolean existsUser(String login) {
		try {
			getByFieldName("login",login);
		}
		catch (GeneralCustomException e){
			if (e.getMessage().contains(EMPTY_RESULTSET.substring(0,EMPTY_RESULTSET.indexOf('%'))))
				return false;
		}
		return true;
	}
	// TODO DELETE Method
	// public boolean deleteById(Long id) {
	// return super.deleteById(id);
	// }

	public boolean updatePassword(String login, String password) {
		boolean result = false;
        Statement statement = null;
        String query = sqlQueries.get("UPDATE_PASSWORD").toString();
        if (query == null) {
            throw new GeneralCustomException(String.format(QUERY_NOT_FOUND,
                    "UPDATE_PASSWORD"));
        }
        try {
            statement = ConnectionUtils.get().getConnection().createStatement();
            result = statement.execute(String.format(query,password, login));
        } catch (SQLException e) {
            throw new GeneralCustomException(DATABASE_READING_ERROR, e);

        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (Exception ex) {
                	log.warn("Database error: User");
                }
            }
        }
        return result;
    }


}
