package utility;
/* Web sitesinde bulunana Id'ler, XPath'ler,linktext'ler ve birçoğu bu sınıfta toplu olarak tutulmuştur. Web sitesinde kodsal bir
 bir değişiklik yapıldığında otomasyon paketinden de kolay bir şekilde düzeltilebilmesi için böyle bir yöntem izlenmiştir */

import org.openqa.selenium.WebDriver;

public class Variables {
    public static WebDriver driver;
    public String productSearchId = "productSearch";
    public String loginButtonId = "myAccount";
    public String loginLinkId = "login";
    public String emailTextBoxId = "email";
    public String passwordTextBoxId = "password";
    public String submitButtonCssSelector = ".btn-login-submit";
    public String userNameCssSelector = "a.login.user-name";
    public String userName = "tester tester";
    public String bookCategoryId = "kitap-muzik-film-hobi";
    public String bookTypeLinkText = "Roman";
    public String relatedCategoryPage = "Roman Kitaplar";
    public String firstProductXPath = "//*/li[1]/div/a";
    public String addToCartId = "addToCart";
    public String successMessageNotificationId = "notification";
    public String productCountInTheCardId = "cartItemCount";
    public String theCardId = "shoppingCart";
    public String completeShoppingButtonClassName = "cart-proceed-container";
    public String keepPayingButtonClassName = "proceed-container";
    public String ATextOnTheDeliveryInformationPage = "Teslimat Bilgileri";
    public String anIdOnThePaymentPage = "payment-container";
    public String bankSelectionXPathForAkbank = "//*[@id=\"payment-type-2\"]/div/ul/li[1]";
    public String withoutInternetBankingCssSelector = ".eft-button.iban-eft";
    public String paymentMethodForHavaleXPath = "//div/div/div[3]/a";
    public String continueWithoutInternetBankingButtonCssSelector = ".btn.long";
    public String confirmOrderButtonCssSelector = "button.btn.btn-primary.full";
    public String myAccountId = "MyAccount";
    public String myOrdersXPath = "//*[@id=\"myAccount\"]//li[1]/a";
    public String myOrderPageClassName = "order-block";
    public String detailsOfTheFirstOrderXPath = "//*[@id=\"root\"]//div[5]/div/div[1]/div";
    public String cancelOrderButtonClassName = "action-button-group";
    public String cancelReasonSelectBoxXPath = "//*[@class=\"cancel-line-item\"]//label/div[1]";
    public String reasonForCancelingBackOutSelectBoxItemXPath = "//*[@class=\"selectbox-result__list\"]//li[3]";
    public String cancelSelectedProductsCssSelector = "button.hb-button.hb-button--primary";
    public String cancellationSuccessfulMessageCssSelector = ".alert-inner-bar.alert-inner-bar--success";
}