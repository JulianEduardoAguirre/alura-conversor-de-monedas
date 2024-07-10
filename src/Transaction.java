import java.time.LocalDateTime;

public class Transaction {
    private static int counter = 0;

    private int transactionNumber;
    private String baseCurrency;
    private String targetCurrency;
    private Double baseAmount;
//    private Double convertedAmount;
//    private Double conversionRate;
    private LocalDateTime createdOn;

    public Transaction(String baseCurrency, String targetCurrency, Double baseAmount) {
        this.baseCurrency = baseCurrency;
        this.targetCurrency = targetCurrency;
        this.baseAmount = baseAmount;
//        this.convertedAmount = convertedAmount;
//        this.conversionRate = conversionRate;
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

//    public Double getConvertedAmount() {
//        return convertedAmount;
//    }
//
//    public void setConvertedAmount(Double convertedAmount) {
//        this.convertedAmount = convertedAmount;
//    }
//
//    public Double getConversionRate() {
//        return conversionRate;
//    }
//
//    public void setConversionRate(Double conversionRate) {
//        this.conversionRate = conversionRate;
//    }

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
//                ", convertedAmount=" + convertedAmount +
//                ", conversionRate=" + conversionRate +
                ", createdOn=" + createdOn;
    }
}
