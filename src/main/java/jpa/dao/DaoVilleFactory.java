package jpa.dao;

public class DaoVilleFactory {
	private static DaoVille singleton = null;

	
	public static DaoVille getInstance() { 
		if (singleton == null) {
			singleton = new DaoVilleJpaImpl();
		}
		return singleton;
	}
}
