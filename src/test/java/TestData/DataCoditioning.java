package TestData;

import Pojo.Request.LoginRequest;
import Pojo.Request.TokenGeneratorRequest;

public class DataCoditioning {

    public static TokenGeneratorRequest PayLoadForTokenGeneration(String guId, String platFormName){

        TokenGeneratorRequest tokenGeneratorRequest=new TokenGeneratorRequest();
        tokenGeneratorRequest.setgUID(guId);
        tokenGeneratorRequest.setPlatformName(platFormName);
        return tokenGeneratorRequest;
    }

    public static LoginRequest PayloadForLoginRequest(String country, String surname, String mobileNo, String smartCardNo){
        LoginRequest loginRequest=new LoginRequest();
        loginRequest.setCountry(country);
        loginRequest.setSurname(surname);
        loginRequest.setMobileNumber(mobileNo);
        loginRequest.setSmartCardNumber(smartCardNo);
        return loginRequest;
    }
}
