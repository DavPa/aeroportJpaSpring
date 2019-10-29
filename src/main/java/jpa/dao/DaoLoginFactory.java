package jpa.dao;

public class DaoLoginFactory {
	private static DaoLogin daoLogin = null;

	public static DaoLogin getInstance() {
		if (daoLogin == null) {
			daoLogin = new DaoLoginJpacImpl();
		}
		return daoLogin;
	}
}
