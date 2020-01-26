package scenarios;
/* Bu sınıfta Cucumber tarafından parametre olarak gönderilen browser'a göre ilgili browser'ın yüklenmesi
sağlanmaktadır. Kullanılan WebDriverManager kütüphanesi sayesinde otomatik olarak ilgili browser internetten
bulunarak indirilip kurulmaktadır. Kütüphane aramayı ingilizce olarak yaptığı için javanın dili runtime'da
ingilizceye dönüştürülmüştür.
    Ayrıca bu sınıfın diğer metotundan yine Cucumber'dan parametrik olarak gönderilen bilgilere göre Login işlemi
gerçekleştirilmektedir. Her yeni sayfa için doğru sayfanın yüklenip yüklenmediği kontrol edilmektedir.

    */

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import utility.CommonMethods;
import utility.Variables;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class SelectBrowserAndLogin {
    Variables variables = new Variables();
    CommonMethods commonMethods;
    private By productSearchId = By.id(variables.productSearchId);
    private By loginButtonId = By.id(variables.loginButtonId);
    private By loginLinkId = By.id(variables.loginLinkId);
    private By emailTextBoxId = By.id(variables.emailTextBoxId);
    private By passwordTextBoxId = By.id(variables.passwordTextBoxId);
    private By submitButtonCssSelector = By.cssSelector(variables.submitButtonCssSelector);

    static {//Java dili runtime'da ingilizceye dönüştürülmektedir.
        Locale.setDefault(new Locale("en", "EN"));
    }

    @When("^I have opened \"([^\"]*)\" with \"([^\"]*)\" browser$")
    public void iHaveOpenedWithBrowser(String baseUrl, String browser) {

        if (browser.toLowerCase().contains("chrome")) {
            WebDriverManager.chromedriver().arch32().setup();
            //Chrome'da çıkan bildirim kapatılmaktadır
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("profile.default_content_setting_values.notifications", 2);
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", prefs);
            Variables.driver = new ChromeDriver(options);
        } else if (browser.toLowerCase().contains("firefox")) {
            WebDriverManager.firefoxdriver().arch32().setup();
            Variables.driver = new FirefoxDriver();
        } else {
            System.out.println("Gecerli bir browser ismi giriniz(chrome veya firefox)");
            System.exit(-1);
        }
        Variables.driver.get(baseUrl);
        commonMethods = new CommonMethods(Variables.driver);
        Variables.driver.manage().window().maximize();//Pencere full ekran yapılmaktadır
        commonMethods.isItTheRightPage(productSearchId);
    }

    @Then("^sign in as \"([^\"]*)\" and \"([^\"]*)\"$")
    public void signInAsAnd(String email, String password) {
        commonMethods.clickWithFindElement(loginButtonId);
        commonMethods.clickWithFindElement(loginLinkId);
        commonMethods.isItTheRightPage(emailTextBoxId);
        commonMethods.writeText(emailTextBoxId, email);
        commonMethods.writeText(passwordTextBoxId, password);
        commonMethods.clickWithFindElement(submitButtonCssSelector);
    }
}