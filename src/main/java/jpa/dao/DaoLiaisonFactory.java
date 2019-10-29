package jpa.dao;

public class DaoLiaisonFactory {
	private static DaoLiaison singleton = null;

	
	public static DaoLiaison getInstance() { //creer une seule fois et garde le mme jusqua la fin, evite re crer une instance de DAO, meme sil bouffe pas de ressource autant garder le mm
		if (singleton == null) {
			singleton = new DaoLiaisonJpaImpl();
		}
		return singleton;
	}
}
