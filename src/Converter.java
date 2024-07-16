import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.Set;

public class Converter {

    private String apikey;
    private Boolean validApiKey;
    private final ApiComm apiComm;
    private SuppCodesInfo codes;
    private final Gson gson;

    public Converter() {
        this.apikey = null;
        this.validApiKey = false;
        this.codes = null;
        this.apiComm = new ApiComm();
        this.gson = new Gson();
    }

    public Boolean isApiKeyValid() {
        return this.validApiKey;
    }

    public void validateApiKey(String apikey) {
        JsonObject jsonObject = apiComm.requestData(apikey);
        String result = jsonObject.get("result").getAsString();
        if (result.equals("success")) {
            this.apikey = apikey;
            this.validApiKey = true;
            this.codes = gson.fromJson(jsonObject, SuppCodesInfo.class);
        }
    }

    private Double retrieveConversionRate(String codeFrom, String codeTo) {
        JsonObject response = apiComm.requestData(this.apikey, codeFrom, codeTo);
        return response.get("conversion_rate").getAsDouble();
    }

    public void convertFromTo(String codeFrom, String codeTo, Double amount) {
        Double conversionRate = retrieveConversionRate(codeFrom, codeTo);
        double total = amount * conversionRate;
        System.out.println();
        System.out.println("El valor actual del cambio entre monedas es:\n1 " + codeFrom + " --> " + conversionRate + " " + codeTo);
        System.out.println(amount + " " + codeFrom + " equivalen a  " + total + " " + codeTo);
        System.out.println();
    }

    public Set<String> returnCodes() {
        if (this.codes != null){
            return this.codes.codes().keySet();
        }
        return null;
    }

    public void showCodes() {
        Set<String> codes = returnCodes();
        codes.forEach(c -> System.out.println(c + ": " + this.codes.codes().get(c)));
    }

}

