package it.engineering.webapp.constraint;

public enum MyConstraint {
	MANUFACTURER_PIB_NUMBER("Pib is not a number"), 
	MANUFACTURER_CID_NUMBER("Cid is not a number"),
	MANUFACTURER_EMPTY_FIELD("Field is empty");

	private final String desc;

	private MyConstraint(String desc) {
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

}
