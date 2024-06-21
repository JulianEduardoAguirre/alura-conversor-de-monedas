import com.google.gson.annotations.SerializedName;

import java.time.LocalDateTime;
import java.util.Map;

public record CurrencyInfo(
        @SerializedName("base_code")
        String baseCode,
        @SerializedName("conversion_rates")
        Map<String, Double> conversionRates
//        @SerializedName("time_last_update_utc")
//        LocalDateTime date
) {

}
