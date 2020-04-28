package userdetails;

public class CurrentAccountHolderDetails {

    private String name;
    private String aadharNumber;
    private String panNumber;
    private String userName;
    private String password;
    private String accountType;
    private String accountNumber;
    private Boolean isAccountActivated;
    private double accountBalance;

    public CurrentAccountHolderDetails(){
        this.name = null;
        this.aadharNumber = null;
        this.panNumber = null;
        this.userName = null;
        this.password = null;
        this.accountType = "CURRENT";
        this.accountNumber = null;
        this.isAccountActivated = false;
        this.accountBalance = 0;
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

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }
}
