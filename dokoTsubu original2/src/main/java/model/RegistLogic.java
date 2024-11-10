package model;

import dao.AccountsDAO;

public class RegistLogic {
	public boolean execute(Account account) {
		AccountsDAO dao = new AccountsDAO();
		boolean bo = dao.create(account);
		return bo;
	}
}
