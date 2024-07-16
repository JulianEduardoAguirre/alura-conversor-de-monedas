import java.time.LocalDateTime;

public class Transaction {
    private static int counter = 0;
    private int transactionNumber;
    private String baseCurrency;
    private String targetCurrency;
    private Double baseAmount;
    private LocalDateTime createdOn;

    public Transaction(String baseCurrency, String targetCurrency, Double baseAmount) {
        this.baseCurrency = baseCurrency;
        this.targetCurrency = targetCurrency;
        this.baseAmount = baseAmount;
        this.createdOn = LocalDateTime.now();
        this.transactionNumber = ++counter;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public String getTargetCurrency() {
        return targetCurrency;
    }

    public void setTargetCurrency(String targetCurrency) {
        this.targetCurrency = targetCurrency;
    }

    public Double getBaseAmount() {
        return baseAmount;
    }

    public void setBaseAmount(Double baseAmount) {
        this.baseAmount = baseAmount;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    @Override
    public String toString() {
        return "T" + transactionNumber + ": "+
                "baseCurrency='" + baseCurrency + '\'' +
                ", targetCurrency='" + targetCurrency + '\'' +
                ", baseAmount=" + baseAmount +
                ", createdOn=" + createdOn;
    }
}
