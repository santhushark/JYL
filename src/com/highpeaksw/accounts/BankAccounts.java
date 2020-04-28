package com.highpeaksw.accounts;

import com.highpeaksw.customer.BankCustomer;

abstract public class BankAccounts {

    abstract public boolean initCreateAccount(BankCustomer customerInstance);
    abstract public String getAccountType();
    abstract public int getAccountNumber();
    abstract public String getUserName();
    abstract public String getPassword();
    abstract public double getAccountBalance();
    abstract public void setAccountBalance(double money);
    abstract public boolean isAccountActivated();
    abstract public void setAccountActivated(boolean accountActivated);
    abstract public double getRecurringDepositAmt();
    abstract public void setRecurringDepositAmt(double recurringDepositAmt);
    abstract public int getTenure();
    abstract public void setTenure(int Tenure);
}
