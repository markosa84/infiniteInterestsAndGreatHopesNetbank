package hu.ak_akademia.iigh.db.entity;

public class BankAccountType {

	private Long id;
	private String name;

	public BankAccountType(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
