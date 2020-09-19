package hu.ak_akademia.iigh.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.ak_akademia.iigh.db.dao.BankAccountDao;
import hu.ak_akademia.iigh.db.entity.BankAccount;
import hu.ak_akademia.iigh.db.entity.User;
import hu.ak_akademia.iigh.db.preparedstatementwriter.GetBankAccountsForUserPreparedStatementWriter;
import hu.ak_akademia.iigh.db.resultsetreader.FullBankAccountResultSetReader;
import hu.ak_akademia.iigh.db.sqlbuilder.GetBankAccountsForUserSqlBuilder;

public class LoadBankAccountsScreen extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User loggedInUser = (User) request.getSession()
				.getAttribute("loggedInUser");
		BankAccountDao bankAccountDao = new BankAccountDao(new GetBankAccountsForUserSqlBuilder(), new GetBankAccountsForUserPreparedStatementWriter(), new FullBankAccountResultSetReader());
		List<BankAccount> bankAccounts = bankAccountDao.retrieve(new BankAccount(loggedInUser.getLoginName()));
		request.setAttribute("bankAccounts", bankAccounts);
		request.getRequestDispatcher("bankAccounts.jsp")
				.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}