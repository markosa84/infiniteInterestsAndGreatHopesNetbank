package hu.ak_akademia.iigh.dto;

public class TransactionHistoryDto {

	private Long transactionId;
	private String transactionDate;
	private Long amount;
	private String currencyType;

	private TransactionHistoryDto(Builder builder) {
		this.transactionId = builder.transactionId;
		this.transactionDate = builder.transactionDate;
		this.amount = builder.amount;
		this.currencyType = builder.currencyType;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public Long getAmount() {
		return amount;
	}

	public String getCurrencyType() {
		return currencyType;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private Long transactionId;
		private String transactionDate;
		private Long amount;
		private String currencyType;

		private Builder() {
		}

		public Builder withTransactionId(Long transactionId) {
			this.transactionId = transactionId;
			return this;
		}

		public Builder withTransactionDate(String transactionDate) {
			this.transactionDate = transactionDate;
			return this;
		}

		public Builder withAmount(Long amount) {
			this.amount = amount;
			return this;
		}

		public Builder withCurrencyType(String currencyType) {
			this.currencyType = currencyType;
			return this;
		}

		public TransactionHistoryDto build() {
			return new TransactionHistoryDto(this);
		}
	}

}
