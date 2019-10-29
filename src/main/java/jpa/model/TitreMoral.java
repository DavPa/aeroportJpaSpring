package jpa.model;

public enum TitreMoral {
	SA("societe_anonyme"), SARL("societe_responsabilite_limitee"), EURL("entreprise_unipersonnelle");

private String label;
	
	private TitreMoral(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}

}
