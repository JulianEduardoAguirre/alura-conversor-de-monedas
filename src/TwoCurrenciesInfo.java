import com.google.gson.annotations.SerializedName;

public record TwoCurrenciesInfo(
        @SerializedName("base_code")
        String baseCode,
        @SerializedName("target_code")
        String targetCode,
        @SerializedName("conversion_rate")
        Double conversionRate
) {
}
