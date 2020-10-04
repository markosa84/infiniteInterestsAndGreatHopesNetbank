package hu.ak_akademia.iigh.db.entity;

public class UserStatus {

	private Long id;
	private String name;

	private UserStatus(Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private Long id;
		private String name;

		private Builder() {
		}

		public Builder withId(Long id) {
			this.id = id;
			return this;
		}

		public Builder withName(String name) {
			this.name = name;
			return this;
		}

		public UserStatus build() {
			return new UserStatus(this);
		}
	}

}
