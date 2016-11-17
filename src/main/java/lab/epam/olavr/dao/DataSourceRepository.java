package lab.epam.olavr.dao;

import java.sql.Driver;
import java.sql.SQLException;

import lab.epam.olavr.exception.GeneralCustomException;

public final class DataSourceRepository {

	private final static String FAILED_JDBC_DRIVER = "Failed to Create JDBC Driver";
	private static volatile DataSourceRepository instance = null;

	private DataSourceRepository() {
	}

	public static DataSourceRepository get() {
		if (instance == null) {
			synchronized (DataSourceRepository.class) {
				if (instance == null) {
					instance = new DataSourceRepository();
				}
			}
		}
		return instance;
	}
	
	public DataSource getConnectorMySqlLocalHost() {
		Driver jdbcDriver;
		try {
			jdbcDriver = new com.mysql.jdbc.Driver();
		} catch (SQLException e) {
            throw new GeneralCustomException(FAILED_JDBC_DRIVER, e);
		}
        return new DataSource(jdbcDriver,
                "jdbc:mysql://localhost:3306?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");
    }

}
