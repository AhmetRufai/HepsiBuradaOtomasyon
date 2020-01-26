package scenarios;
/*Bu sayfada Hepsiburada sitesinden bir kitap sepete eklenilerek Havale yöntemi ile sipariş verilir. Ardından verilen
sipariş iptal edilir*/

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import utility.CommonMethods;
import utility.Variables;

import java.util.concurrent.TimeUnit;

public class BuyAndCancelProduct {
    Variables variables = new Variables();
    CommonMethods commonMethods = new CommonMethods(Variables.driver);
    private By userNameCssSelector = By.cssSelector(variables.userNameCssSelector);
    private By bookCategoryId = By.id(variables.bookCategoryId);
    private By bookTypeLinkText = By.linkText(variables.bookTypeLinkText);
    private By firstProductXPath = By.xpath(variables.firstProductXPath);
    private By addToCartId = By.id(variables.addToCartId);
    private By successMessageNotificationId = By.id(variables.successMessageNotificationId);
    private By productCountInTheCardId = By.id(variables.productCountInTheCardId);
    private By theCardId = By.id(variables.theCardId);
    private By completeShoppingButtonClassName = By.className(variables.completeShoppingButtonClassName);
    private By keepPayingButtonClassName = By.className(variables.keepPayingButtonClassName);
    private By anIdOnThePaymentPage = By.id(variables.anIdOnThePaymentPage);
    private By bankSelectionXPathForAkbank = By.xpath(variables.bankSelectionXPathForAkbank);
    private By withoutInternetBankingCssSelector = By.cssSelector(variables.withoutInternetBankingCssSelector);
    private By paymentMethodForHavaleXPath = By.xpath(variables.paymentMethodForHavaleXPath);
    private By continueWithoutInternetBankingButtonCssSelector = By.cssSelector(variables.continueWithoutInternetBankingButtonCssSelector);
    private By confirmOrderButtonCssSelector = By.cssSelector(variables.confirmOrderButtonCssSelector);
    private By myAccountId = By.id(variables.myAccountId);
    private By myOrdersXPath = By.xpath(variables.myOrdersXPath);
    private By myOrderPageClassName = By.className(variables.myOrderPageClassName);
    private By detailsOfTheFirstOrderXPath = By.xpath(variables.detailsOfTheFirstOrderXPath);
    private By cancelOrderButtonClassName = By.className(variables.cancelOrderButtonClassName);
    private By cancelReasonSelectBoxXPath = By.xpath(variables.cancelReasonSelectBoxXPath);
    private By reasonForCancelingBackOutSelectBoxItemXPath = By.xpath(variables.reasonForCancelingBackOutSelectBoxItemXPath);
    private By cancelSelectedProductsCssSelector = By.cssSelector(variables.cancelSelectedProductsCssSelector);
    private By cancellationSuccessfulMessageCssSelector = By.cssSelector(variables.cancellationSuccessfulMessageCssSelector);

    @When("^Add a book to cart$")
    public void addABookToCart() {//Kitaplar tabından roman kategorisinden bir kitap sepete eklenmektedir
        commonMethods.amISeeTheTextInTheElement(userNameCssSelector, variables.userName);
        commonMethods.clickWithFindElement(bookCategoryId);
        commonMethods.clickWithFindElement(bookTypeLinkText);
        commonMethods.waitVisibility(firstProductXPath);
        commonMethods.amISeeTheTextOnThePage(variables.relatedCategoryPage);
        commonMethods.clickWithFindElement(firstProductXPath);
        commonMethods.isItTheRightPage(addToCartId);
        int mProductCountInTheCardBeforeAdding = Integer.parseInt(commonMethods.readText(productCountInTheCardId));
        commonMethods.clickWithFindElement(addToCartId);
        commonMethods.waitInvisibilityWithoutText(successMessageNotificationId);
        int mProductCountInTheCardAfterAdding = Integer.parseInt(commonMethods.readText(productCountInTheCardId));
        commonMethods.isTheProductAddedToTheCart(mProductCountInTheCardBeforeAdding, mProductCountInTheCardAfterAdding);
    }

    @Then("^Buy the product with the Havale option$")//Havale ödeme seçeneği ile sepete eklenen kitap sipariş verilir.
    public void buyTheProductWithTheHavaleOption() throws InterruptedException {
        commonMethods.clickWithFindElement(theCardId);
        commonMethods.isItTheRightPage(completeShoppingButtonClassName);
        commonMethods.clickWithFindElement(completeShoppingButtonClassName);
        commonMethods.waitVisibility(keepPayingButtonClassName);
        commonMethods.amISeeTheTextOnThePage(variables.ATextOnTheDeliveryInformationPage);
        commonMethods.clickWithFindElement(keepPayingButtonClassName);
        commonMethods.isItTheRightPage(anIdOnThePaymentPage);
        Thread.sleep(300);
        commonMethods.clickWithFindElement(paymentMethodForHavaleXPath);
        Thread.sleep(300);
        commonMethods.clickWithFindElement(bankSelectionXPathForAkbank);
        commonMethods.clickWithFindElement(keepPayingButtonClassName);
        commonMethods.isItTheRightPage(withoutInternetBankingCssSelector);
        commonMethods.clickWithFindElement(withoutInternetBankingCssSelector);
        commonMethods.isItTheRightPage(continueWithoutInternetBankingButtonCssSelector);
        commonMethods.clickWithFindElement(continueWithoutInternetBankingButtonCssSelector);
        commonMethods.isItTheRightPage(confirmOrderButtonCssSelector);
        Thread.sleep(300);
        commonMethods.clickWithFindElement(confirmOrderButtonCssSelector);
    }

    @Then("^Cancel purchased product$")//Sipariş verililen kitabın siparişi iptal edilmektedir.
    public void cancelPurchasedProduct() throws InterruptedException {
        commonMethods.clickWithFindElement(myAccountId);
        commonMethods.clickWithFindElement(myOrdersXPath);
        commonMethods.isItTheRightPage(myOrderPageClassName);
        commonMethods.clickWithFindElement(detailsOfTheFirstOrderXPath);
        commonMethods.isItTheRightPage(cancelOrderButtonClassName);
        Thread.sleep(300);
        commonMethods.clickWithFindElement(cancelOrderButtonClassName);
        commonMethods.isItTheRightPage(cancelReasonSelectBoxXPath);
        commonMethods.clickWithFindElement(cancelReasonSelectBoxXPath);
        commonMethods.clickWithFindElement(reasonForCancelingBackOutSelectBoxItemXPath);
        Variables.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        commonMethods.clickWithFindElement(cancelSelectedProductsCssSelector);
        commonMethods.isItTheRightPage(cancellationSuccessfulMessageCssSelector);
    }
}
