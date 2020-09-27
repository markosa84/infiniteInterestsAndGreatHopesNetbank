package hu.ak_akademia.iigh.db.entity;

public class BankAccountStatus {

	private Long id;
	private String name;
	private String displayName;

	public BankAccountStatus(Long id, String name, String displayName) {
		this.id = id;
		this.name = name;
		this.displayName = displayName;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDisplayName() {
		return displayName;
	}

}
