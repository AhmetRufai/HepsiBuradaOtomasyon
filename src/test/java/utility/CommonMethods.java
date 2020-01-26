package utility;
/*
Sık kullanılan methotlar okunulabilirliğin artırılması ve herhangi bir değişiklik yapılabilmesine esneklik sağlayabilmesi
için bu sınıf içerisinde tanımlanmıştır.
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class CommonMethods {
    WebDriver driver;
    private WebDriverWait wait;

    //Constructor
    public CommonMethods(WebDriver driver) {
        this.driver = Variables.driver;
        wait = new WebDriverWait(driver, 20);
    }

    //Gönderilen web elementin görünür olmasını bekler
    public void waitVisibility(By elementBy) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
    }

    //Gönderilen web elementin mevcut olmasını bekler
    public void waitPresence(By elementBy) {
        wait.until(ExpectedConditions.presenceOfElementLocated(elementBy));
    }

    //Gönderilen web elementin tıklanabilir olmasını bekler
    public void waitClickable(By elementBy) {
        wait.until(ExpectedConditions.elementToBeClickable(elementBy));
    }

    /* Sepete ürün eklendiğinde bir pencere görünüyor ve ardından kayboluyor. Bu pencerenin görünür ve ardından tekrar görünmez
    olması bu metot ile test edilmiştir. */
    public void waitInvisibilityWithoutText(By elementBy) {
        waitPresence(elementBy);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(elementBy));
    }

    //önderilen web elemente tıklanmasını sağlar
    public void clickWithFindElement(By elementBy) {
        waitVisibility(elementBy);
        Variables.driver.findElement(elementBy).click();
    }

    //Bir web elemente text girilmesini sağlar
    public void writeText(By elementBy, String text) {
        waitVisibility(elementBy);
        Variables.driver.findElement(elementBy).sendKeys(text);
    }

    //Bir web elementin text'ini almayı sağlar
    public String readText(By elementBy) {
        waitVisibility(elementBy);
        return Variables.driver.findElement(elementBy).getText();
    }

    //Bir elementin içerisinde beklenilen text'in olup olmadığı doğrulanır
    public void assertEquals(By elementBy, String expectedText) {
        waitVisibility(elementBy);
        Assert.assertEquals(readText(elementBy), expectedText);
    }

    /* Sepete ürün eklenmeden önce sepetteki elemanların sayısı ile eklendikten sonraki eleman sayıları karşılaştırılır.
    Bu metot sayesinde eklendi olarak görüdğümüz ürünün sepete gerçekten eklenmiş olduğu doğrulanır */
    public void isTheProductAddedToTheCart(int beforoAddingCount, int afterAddingCount) {
        int mDifference = afterAddingCount - beforoAddingCount;
        if (mDifference > 0) {
            System.out.println("Sepete urun ekleme islemi basariyla gerceklesmistir");
        } else {
            Assert.fail("\n" + "Urun sepete eklenmis olmasina ragmen sepetteki urun sayisi artmadi !!!" + "\n");
        }
    }
//Bir işlem yapıldıktan sonra yeni sayfada belirtilen web element aranır. Bu metot ile doğru sayfada olunup olunmadığı doğrulanır
    public void isItTheRightPage(By elementBy) {
        try {
            waitClickable(elementBy);
            System.out.println("Sayfa basariyla yuklendi");
        } catch (Exception e) {
            Assert.fail("\n" + "Sayfa yuklenemedi veya farkli bir sayfa yuklendi !!!" + "\n" + e);
        }
    }
/*Bir işlem yapıldıktan sonra yeni sayfada belirtilen bir web elementdeki bir text'i arar.
 Bu metot ile doğru sayfada olunup olunmadığı doğrulanır */
    public void amISeeTheTextInTheElement(By elementBy, String expectedText) {
        try {
            assertEquals(elementBy, expectedText);
            System.out.println("Beklenilen sayfa basariyla yuklendi");
        } catch (Exception e) {
            Assert.fail("\n" + "Sayfa yuklenemedi veya farkli bir sayfa yuklendi !!!" + "\n" + e);
        }
    }
/* Bir sayfanın içerisinde belirtilen text'i arar. Bu metot ile sayfa yüklenemmiş veya farklı bir sayfa yüklenmiş olma ihtimalleri
* test edilir */
    public void amISeeTheTextOnThePage(String expectedText) {
        WebElement body = Variables.driver.findElement(By.tagName("body"));
        String bodyText = body.getText();
        boolean IsThere = bodyText.contains(expectedText);
        if (IsThere) {
            System.out.println("Beklenilen sayfa basariyla yuklendi");
        } else {
            Assert.fail("\n" + "Sayfa yuklenemedi veya farkli bir sayfa yuklendi !!!" + "\n");
        }
    }
}