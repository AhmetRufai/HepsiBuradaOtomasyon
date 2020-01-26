# HepsiBuradaOtomasyon
Hepsiburada Websitesinde Otmasyon Çalışması

Otomasyonun hazırlanışında Java, Gradle, IntejijIDEA, Selenium, Cucumber, TestNG ve WebDriverElement gibi teknoloji,kütüphane ve araçlar kullanılmıştır.

İlk olarak Cucumber dosyasında senaryolar oluşturulmuş. Browser seçimi ve Login işlemleri bir senaryoda diğer işlemler ise 2.senaryoda gerçekleştirilmiştir.

Otomasyon Chrome ve Firefox browser'larında çalışacak şekilde hazırlanmıştır. Hangi browser ile çalışacağı Cucumber'dan parametrik olarak gönderilmektedir.

Websitesinde bulunan tüm değişkenler Varialbles sınıfı altında tanımlanarak bütün değişkenler bu sınıftan kullanılmıştır. Böylece websitesi üzerinde herhangi
bir değişiklik olduğunda otomasyon suitinde düzeltmeler yapmak kolay olacaktır. Sık kullanılan methodlar kodun okunabilirliğini artırmak için CommandMethods
sayfasında tanımlanmıştır.

Otomasyon suiti içerisinde yapılan işlemler şöyledir;
* Cucumber senaryolarında belirtilen browser ile hepsiburada sayfası yüklenilmiştir
* Sayfanın doğru yüklenip yüklenemediği kontrol edilmiştir
* Login işlemi gerçekleştirmek için Giriş paneline tıklanmıştır
* Giriş panelinin yüklenip yüklenemediği test edilmiştir
* Cucumber dosayasında parametrik olarak alınan login bilgileri ile giriş yapılmıştır
* Giriş işleminin başarı olup olmadığı kontrol edilmiştir
* Kitap, Film, Müzik, Hobi tabına tıklanılarak Kitap bölümünden Roman kategorisi seçilmiştir
* Seçilen kategori sayfasının yüklenip yüklenemediği kontrol edilmiştir
* Listenin ilk kitabına tıklanılmıştır.
* Seçilen kitap sayfasının yüklenip yüklenemediği kontrol edilmiştir
* Sepetteki eleman sayısı get edilmiştir
* Sepete kitap eklenilmiştir
* Sepete eklenme işleminin başarı olduğuna dair bir panel açılıp kapandı. Bu panelin görünür belirli bir süre sonra tekrar görünmez olduğu doğrulanmıştır
* Sepetteki eleman sayısı tektardan get edilerek sayının arttığı doğrulanmıştır
* Sepete tılanılarak sipariş verme sayfasına gidilmiştir
* Sayfanın yüklendiği doğrulanmıştır
* Ödeme sayfasına ilerlenilmiş ve bu sayfanın doğru yüklendiği test edilmiştir
* Ödeme seçeneği olarak Havale->Akbank-> Sipariş Sonrası Havale seçenekleri seçilerek ürün siparişi verilmiştir
* Ürün sipariş vermenin başarı olduğuna dair mesaj panelinin geldiği doğrulanmıştır
* Hesabım tabından Siparişlerim linkine tıklanmıştır
* Sipariş sayfasının yüklendiği test edilmiştir
* Siparişi verilen ürüne tıklanılarak İptal butonuna tıklanılmıştır
* İptal sebebi olarak Vazgeçtim seçeneği seçilmiş ve sipariş iptal edilmiştir


Not1: Otomasyon suitinin çalışır durumda olduğunu göstermek için ekran videosu alınılarak proje dosyasının içerisine eklenmiştir(Otomasyonuncalisirhali.m4v)

Not2: Gönderilmiş olan çalışma dosyasındaki 1.ve 2.çalışmalar sözel bilgiler olduğu için aynı dosyanın içerisine yazılarak proje dosaysına eklenmiştir(Hepsiburada Case Study_QA Çalışma (Payment) (1))
