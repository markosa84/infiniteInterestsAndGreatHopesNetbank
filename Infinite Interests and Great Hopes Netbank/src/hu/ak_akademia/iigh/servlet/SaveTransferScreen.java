package hu.ak_akademia.iigh.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.ak_akademia.iigh.db.dao.BankAccountDao;
import hu.ak_akademia.iigh.db.dao.TransactionDao;
import hu.ak_akademia.iigh.db.entity.BankAccount;
import hu.ak_akademia.iigh.db.entity.Transaction;
import hu.ak_akademia.iigh.db.preparedstatementwriter.bankaccount.GetBankAccountByBankAccountNumberPreparedStatementWriter;
import hu.ak_akademia.iigh.db.preparedstatementwriter.bankaccount.UpdateBankAccountCurrentBalancePreparedStatementWriter;
import hu.ak_akademia.iigh.db.preparedstatementwriter.transaction.CreateTransactionPreparedStatementWriter;
import hu.ak_akademia.iigh.db.resultsetreader.bankaccount.FullBankAccountResultSetReader;
import hu.ak_akademia.iigh.db.sqlbuilder.bankaccount.GetBankAccountByBankAccountNumberSqlBuilder;
import hu.ak_akademia.iigh.db.sqlbuilder.bankaccount.UpdateBankAccountCurrentBalanceSqlBuilder;
import hu.ak_akademia.iigh.db.sqlbuilder.transaction.CreateTransactionSqlBuilder;

public class SaveTransferScreen extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String bankAccountNumber = request.getParameter("bankAccountNumber");
		String toBankAccountNumber = request.getParameter("toBankAccountNumber");
		String beneficiaryName = request.getParameter("beneficiaryName");
		String amountAsString = request.getParameter("amount");
		String transactionComment = request.getParameter("transactionComment");

		Long amount = Long.parseLong(amountAsString);

		BankAccountDao queryBankAccountDao = new BankAccountDao(new GetBankAccountByBankAccountNumberSqlBuilder(), new GetBankAccountByBankAccountNumberPreparedStatementWriter(),
				new FullBankAccountResultSetReader());
		BankAccount fromBankAccount = queryBankAccountDao.retrieve(BankAccount.builder()
				.withBankAccountNumber(bankAccountNumber)
				.build())
				.get(0);
		BankAccount toBankAccount = queryBankAccountDao.retrieve(BankAccount.builder()
				.withBankAccountNumber(toBankAccountNumber)
				.build())
				.get(0);

		Map<String, String> validationErrors = new HashMap<>();
		if (fromBankAccount.getCurrentBalance() < amount) {
			validationErrors.put("amountTooMuch", "Nincs elég fedezet.");
		}
		// TODO többi validációt is el kell végezni

		if (validationErrors.isEmpty()) {
			Transaction transaction = Transaction.builder()
					.withFromBankAccountNumber(bankAccountNumber)
					.withToBankAccountNumber(toBankAccountNumber)
					.withBeneficiaryName(beneficiaryName)
					.withAmount(amount)
					.withTransactionComment(transactionComment)
					.build();
			fromBankAccount.setCurrentBalance(fromBankAccount.getCurrentBalance() - amount);
			toBankAccount.setCurrentBalance(toBankAccount.getCurrentBalance() + amount);
			TransactionDao transactionDao = new TransactionDao(new CreateTransactionSqlBuilder(), new CreateTransactionPreparedStatementWriter());
			BankAccountDao updateBankAccountDao = new BankAccountDao(new UpdateBankAccountCurrentBalanceSqlBuilder(), new UpdateBankAccountCurrentBalancePreparedStatementWriter());
			// ezt a 3 műveletet egy adatbázis tranzakció keretén belül lenne érdemes
			// végrehajtani
			transactionDao.create(transaction);
			updateBankAccountDao.update(fromBankAccount);
			updateBankAccountDao.update(toBankAccount);
			response.sendRedirect("userHome.jsp?message=successfulTransfer");
		} else {
			request.setAttribute("validationErrors", validationErrors);
			request.getRequestDispatcher("transfer.jsp")
					.forward(request, response);
		}

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}