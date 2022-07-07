package Json;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

     @RunWith(Cucumber.class) 
     @CucumberOptions(plugin = {"pretty", "html:target/Destination"})
     
public class JsonTestRunner{
}

