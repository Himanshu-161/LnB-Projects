package Services;

import Exceptions.InsufficientBalanceException;
import Exceptions.InvalidAmountException;
import POJO.AccountDetails;

public interface BankAccount {
    public void init(AccountDetails accountDetails);

    public void deposit(double amount) throws InvalidAmountException;

    public void withdraw(double amount) throws InvalidAmountException, InsufficientBalanceException;

    public void balanceEnquiry();

    public void moneyTransfer(long account, double amount)throws InvalidAmountException, InsufficientBalanceException;

}
