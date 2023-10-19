package Pojo.Response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TokenGeneratorResponse {

    @JsonProperty("Token")
    public String token;
    @JsonProperty("ExpiryPeriodInMinutes")
    public int expiryPeriodInMinutes;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getExpiryPeriodInMinutes() {
        return expiryPeriodInMinutes;
    }

    public void setExpiryPeriodInMinutes(int expiryPeriodInMinutes) {
        this.expiryPeriodInMinutes = expiryPeriodInMinutes;
    }
}
