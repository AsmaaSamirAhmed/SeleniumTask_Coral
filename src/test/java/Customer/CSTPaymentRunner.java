package Customer;

import BasesTest.TestBase;
import BasesTest.TestBase1;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features="src/test/java/Customer/CSTPayment.feature"
,glue= {"Customer"}
,plugin= {"json:target/jsonReports/cucumber-report.json"})

public class CSTPaymentRunner extends TestBase
{
}


