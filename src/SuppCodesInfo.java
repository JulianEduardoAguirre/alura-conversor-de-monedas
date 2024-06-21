import com.google.gson.annotations.SerializedName;

import java.util.Map;

public record SuppCodesInfo(
        @SerializedName("supported_codes")
        Map<String, String> codes
){}
