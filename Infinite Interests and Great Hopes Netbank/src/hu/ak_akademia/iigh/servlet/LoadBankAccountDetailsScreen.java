package hu.ak_akademia.iigh.servlet;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.ak_akademia.iigh.BankAccountStatus;
import hu.ak_akademia.iigh.BankAccountType;
import hu.ak_akademia.iigh.db.dao.BankAccountDao;
import hu.ak_akademia.iigh.db.dao.BankAccountStatusDao;
import hu.ak_akademia.iigh.db.dao.BankAccountTypeDao;
import hu.ak_akademia.iigh.db.dao.TransactionDao;
import hu.ak_akademia.iigh.db.entity.BankAccount;
import hu.ak_akademia.iigh.db.entity.Transaction;
import hu.ak_akademia.iigh.db.preparedstatementwriter.bankaccount.GetBankAccountByBankAccountNumberPreparedStatementWriter;
import hu.ak_akademia.iigh.db.preparedstatementwriter.bankaccountstatus.GetBankAccountStatusByIdPreparedStatementWriter;
import hu.ak_akademia.iigh.db.preparedstatementwriter.bankaccounttype.GetBankAccountTypeByIdPreparedStatementWriter;
import hu.ak_akademia.iigh.db.preparedstatementwriter.transaction.GetLastTransactionTimestampByBankAccountNumberPreparedStatementWriter;
import hu.ak_akademia.iigh.db.resultsetreader.bankaccount.FullBankAccountResultSetReader;
import hu.ak_akademia.iigh.db.resultsetreader.bankaccountstatus.FullBankAccountStatusResultSetReader;
import hu.ak_akademia.iigh.db.resultsetreader.bankaccounttype.FullBankAccountTypeResultSetReader;
import hu.ak_akademia.iigh.db.resultsetreader.transaction.TransactionTimestampResultSetReader;
import hu.ak_akademia.iigh.db.sqlbuilder.bankaccount.GetBankAccountByBankAccountNumberSqlBuilder;
import hu.ak_akademia.iigh.db.sqlbuilder.bankaccountstatus.GetBankAccountStatusByIdSqlBuilder;
import hu.ak_akademia.iigh.db.sqlbuilder.bankaccounttype.GetBankAccountTypeByIdSqlBuilder;
import hu.ak_akademia.iigh.db.sqlbuilder.transaction.GetLastTransactionTimestampByBankAccountNumberSqlBuilder;
import hu.ak_akademia.iigh.dto.BankAccountDetailsDto;

public class LoadBankAccountDetailsScreen extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bankAccountNumber = request.getParameter("bankAccountNumber");
		BankAccount bankAccount = BankAccount.builder()
				.withBankAccountNumber(bankAccountNumber)
				.build();
		BankAccountDao bankAccountDao = new BankAccountDao(new GetBankAccountByBankAccountNumberSqlBuilder(), new GetBankAccountByBankAccountNumberPreparedStatementWriter(),
				new FullBankAccountResultSetReader());
		List<BankAccount> results = bankAccountDao.retrieve(bankAccount);
		BankAccount result = results.get(0);

		TransactionDao transactionDao = new TransactionDao(new GetLastTransactionTimestampByBankAccountNumberSqlBuilder(),
				new GetLastTransactionTimestampByBankAccountNumberPreparedStatementWriter(bankAccountNumber), new TransactionTimestampResultSetReader());
		List<Transaction> transactions = transactionDao.retrieve(null);
		String lastTransactionTimestamp = transactions.isEmpty() ? "Nincs ilyen"
				: transactions.get(0)
						.getTransactionDate()
						.format(DateTimeFormatter.ofPattern("yyyy. MM. dd. hh:mm:ss"));

		BankAccountStatus bankAccountStatus = result.getBankAccountStatus();
		BankAccountStatusDao bankAccountStatusDao = new BankAccountStatusDao(new GetBankAccountStatusByIdSqlBuilder(), new GetBankAccountStatusByIdPreparedStatementWriter(),
				new FullBankAccountStatusResultSetReader());
		List<hu.ak_akademia.iigh.db.entity.BankAccountStatus> bankAccountStatusResults = bankAccountStatusDao
				.retrieve(new hu.ak_akademia.iigh.db.entity.BankAccountStatus(bankAccountStatus.getBankAccountStatusId(), null, null));

		BankAccountType bankAccountType = result.getBankAccountType();
		BankAccountTypeDao bankAccountTypeDao = new BankAccountTypeDao(new GetBankAccountTypeByIdSqlBuilder(), new GetBankAccountTypeByIdPreparedStatementWriter(),
				new FullBankAccountTypeResultSetReader());
		List<hu.ak_akademia.iigh.db.entity.BankAccountType> bankAccountTypeResults = bankAccountTypeDao
				.retrieve(new hu.ak_akademia.iigh.db.entity.BankAccountType(bankAccountType.getBankAccountTypeId(), null));

		BankAccountDetailsDto bankAccountDetailsDto = BankAccountDetailsDto.builder()
				.withBankAccountNumber(result.getBankAccountNumber())
				.withAliasName(result.getAliasName())
				.withCurrentBalance(result.getCurrentBalance())
				.withCurrencyType(result.getCurrencyType())
				.withBankAccountStatus(bankAccountStatusResults.get(0)
						.getDisplayName())
				.withBankAccountType(bankAccountTypeResults.get(0)
						.getName())
				.withLastTransactionTimestamp(lastTransactionTimestamp)
				.build();
		request.setAttribute("bankAccountDetailsDto", bankAccountDetailsDto);
		request.getRequestDispatcher("bankAccountDetails.jsp")
				.forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}