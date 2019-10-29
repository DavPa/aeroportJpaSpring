package jpa.model;

public enum TitrePhysique {
	MR("monsieur"), MME("madame"), MLLE("mademoiselle");
	
	private String label;
	
	private TitrePhysique(String label) {
		this.label = label;
	}
	
	public String getLabel() {
		return label;
	}

}
