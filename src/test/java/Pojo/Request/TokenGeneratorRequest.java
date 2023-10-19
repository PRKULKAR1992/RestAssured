package Pojo.Request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TokenGeneratorRequest {

    @JsonProperty("PlatformName")
    public String platformName;
    @JsonProperty("GUID")
    public String gUID;
    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getgUID() {
        return gUID;
    }

    public void setgUID(String gUID) {
        this.gUID = gUID;
    }
}
