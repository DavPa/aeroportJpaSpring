package jpa.dao;

public class DaoClientFactory {
	private static DaoClient daoClient = null;

	public static DaoClient getInstance() {
		if (daoClient == null) {
			daoClient = new DaoClientJpacImpl();
		}
		return daoClient;
	}
}
