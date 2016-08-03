package lab.epam.olavr.dao;

import lab.epam.olavr.dao.RoleDB.RoleDBQueries;

public class RoleDao extends ADao<RoleDB> {
	private static volatile RoleDao instance = null;

	private RoleDao() {
		super();
		init();
	}

	public static RoleDao get() {
		if (instance == null) {
			synchronized (RoleDao.class) {
				if (instance == null) {
					instance = new RoleDao();
				}
			}
		}
		return instance;
	}

	void init() {
		for (RoleDBQueries RoleDBQueries : RoleDBQueries.values()) {
			sqlQueries.put(RoleDBQueries.name(), RoleDBQueries);
		}
	}

	protected RoleDB createInstance(String[] args) {
		return new RoleDB(
				Long.parseLong(args[0] == null ? "0" : args[0]),
				args[1] == null ? new String()  : args[1]
				);
	}

	protected String[] getFields(RoleDB entity) {
		String[] fields = new String[2];
		fields[0] = entity.getRoleId().toString();
		fields[1] = entity.getRoleName();
		return fields;
	}

	public RoleDB  getRoleDBById(Long id) {
		return getByFieldName("roleId", id.toString()).get(0);
	}



	// TODO DELETE Method
	// public boolean deleteById(Long id) {
	// return super.deleteById(id);
	// }

}
