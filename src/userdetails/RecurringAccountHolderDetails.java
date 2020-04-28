package userdetails;

public class RecurringAccountHolderDetails {
    private String name;
    private String aadharNumber;
    private String panNumber;
    private String userName;
    private String password;
    private String accountType;
    private String accountNumber;
    private Boolean isAccountActivated;
    private int recurringDepositTenure;
    private final int RECURRING_DEPOSIT_RATE_OF_INTEREST = 10;
    private double recurringDepositAmt;
    private double currentRecurringDeposit;

    public RecurringAccountHolderDetails() {
        this.name = null;
        this.aadharNumber = null;
        this.panNumber = null;
        this.userName = null;
        this.password = null;
        this.accountType = "RECURRINGDEPOSIT";
        this.isAccountActivated = false;
        this.recurringDepositTenure = 0;
        this.recurringDepositAmt = 0;
        this.currentRecurringDeposit = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        System.out.println("YOUR ACCOUNT NUMBER IS :"+accountNumber);
        this.accountNumber = accountNumber;
    }

    public Boolean getAccountActivated() {
        return isAccountActivated;
    }

    public void setAccountActivated(Boolean accountActivated) {
        isAccountActivated = accountActivated;
    }

    public int getRecurringDepositTenure() {
        return recurringDepositTenure;
    }

    public void setRecurringDepositTenure(int recurringDepositTenure) {
        this.recurringDepositTenure = recurringDepositTenure;
    }

    public int getRECURRING_DEPOSIT_RATE_OF_INTEREST() {
        return RECURRING_DEPOSIT_RATE_OF_INTEREST;
    }

    public double getRecurringDepositAmt() {
        return recurringDepositAmt;
    }

    public void setRecurringDepositAmt(double recurringDepositAmt) {
        this.recurringDepositAmt = recurringDepositAmt;
    }

    public double getCurrentRecurringDeposit() {
        return currentRecurringDeposit;
    }

    public void setCurrentRecurringDeposit(double currentRecurringDeposit) {
        this.currentRecurringDeposit = currentRecurringDeposit;
    }
}
