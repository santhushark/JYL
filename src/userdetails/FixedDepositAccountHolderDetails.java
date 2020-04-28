package userdetails;

public class FixedDepositAccountHolderDetails {
    private String name;
    private String aadharNumber;
    private String panNumber;
    private String userName;
    private String password;
    private String accountType;
    private String accountNumber;
    private Boolean isAccountActivated;
    private int fixedDepositTenure;
    private final int FIXED_DEPOSIT_RATE_OF_INTEREST = 10;
    private double fixedDeposit;

    public FixedDepositAccountHolderDetails() {
        this.name = null;
        this.aadharNumber = null;
        this.panNumber = null;
        this.userName = null;
        this.password = null;
        this.accountType = "FIXEDDEPOSIT";
        this.accountNumber = null;
        this.isAccountActivated = false;
        this.fixedDepositTenure = 0;
        this.fixedDeposit = 0;
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

//    public void setAccountType(String accountType) {
//        this.accountType = accountType;
//    }

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

    public int getFixedDepositTenure() {
        return fixedDepositTenure;
    }

    public void setFixedDepositTenure(int fixedDepositTenure) {
        this.fixedDepositTenure = fixedDepositTenure;
    }

    public int getFIXED_DEPOSIT_RATE_OF_INTEREST() {
        return FIXED_DEPOSIT_RATE_OF_INTEREST;
    }

    public double getFixedDeposit() {
        return fixedDeposit;
    }

    public void setFixedDeposit(double fixedDeposit) {
        this.fixedDeposit = fixedDeposit;
    }
}
