package hu.ak_akademia.iigh.servlet;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hu.ak_akademia.iigh.db.dao.BankAccountTypeDao;
import hu.ak_akademia.iigh.db.dao.UserDao;
import hu.ak_akademia.iigh.db.entity.BankAccountType;
import hu.ak_akademia.iigh.db.entity.User;
import hu.ak_akademia.iigh.db.preparedstatementwriter.EmptyPreparedStatementWriter;
import hu.ak_akademia.iigh.db.resultsetreader.bankaccounttype.FullBankAccountTypeResultSetReader;
import hu.ak_akademia.iigh.db.resultsetreader.user.FullUserResultSetReader;
import hu.ak_akademia.iigh.db.sqlbuilder.bankaccounttype.GetAllBankAccountTypesSqlBuilder;
import hu.ak_akademia.iigh.db.sqlbuilder.user.GetClientUsersSqlBuilder;
import hu.ak_akademia.iigh.dto.ClientDto;

public class LoadCreateBankAccountScreen extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao userDao = new UserDao(new GetClientUsersSqlBuilder(), new EmptyPreparedStatementWriter<>(), new FullUserResultSetReader());
		List<User> clients = userDao.retrieve(null);
		List<ClientDto> clientDtos = clients.stream()
				.map(user -> ClientDto.builder()
						.withLoginName(user.getLoginName())
						.withDisplayName(String.format("%s %s", user.getLastName(), user.getFirstName()))
						.build())
				.collect(Collectors.toUnmodifiableList());
		request.setAttribute("clients", clientDtos);

		BankAccountTypeDao bankAccountTypeDao = new BankAccountTypeDao(new GetAllBankAccountTypesSqlBuilder(), new EmptyPreparedStatementWriter<>(), new FullBankAccountTypeResultSetReader());
		List<BankAccountType> bankAccountTypes = bankAccountTypeDao.retrieve(null);
		request.setAttribute("bankAccountTypes", bankAccountTypes);

		request.getRequestDispatcher("createBankAccount.jsp")
				.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}