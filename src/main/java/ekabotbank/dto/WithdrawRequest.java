package ekabotbank.dto;

public class WithdrawRequest {
    private double amount;

    public WithdrawRequest(double amount) {
        this.amount = amount;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
}
