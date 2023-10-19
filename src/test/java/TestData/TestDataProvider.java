package TestData;

import org.testng.annotations.DataProvider;

public class TestDataProvider {

    @DataProvider(name = "data-provider")
    public Object[][] dpMethod(){
        return new Object[][] {{"Sierra Leone","BANGURA","","4264001345"}, {"Kenya","SERENA","","4113015950"}};
    }
}
