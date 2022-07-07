package FlightBooking;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/Destination",
		                            "json:target/Destination",
		                            "junit:target/Destination"},
                 glue={"stepDefinition"},
                 features = "src\\test\\java\\")               
public class PhpTestRunner {

}
