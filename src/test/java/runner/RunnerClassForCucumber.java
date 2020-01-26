package runner;
/*Bu sınıf, Cucumber framework'ü için gerekli olan bir runner sınıfıdır*/

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterSuite;
import utility.Variables;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/feature/Hepsiburada.feature"}, glue = {"scenarios"})


public class RunnerClassForCucumber extends AbstractTestNGCucumberTests {

    // Butun testler tamamlandıktan sonra driver'ın ilgili sekmesi kapatılır.
    @AfterSuite
    public void teardown() {
        Variables.driver.close();
    }
}
