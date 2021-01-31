# GittiGidiyor


NOT: Uygulamayı çalıştırmadan önce src/test/java/resources/user sınıfının içerisine email ve password değerleri girilmelidir


Selenium Web Otomasyon
- www.gittigidiyor.com sitesi açılır.
- Ana sayfanın açıldığı kontrol edilir. Siteye login olunur
- Login işlemi kontrol edilir.
- Arama kutucuğuna bilgisayar kelimesi girilir.
- Arama sonuçları sayfasından 2.sayfa açılır.
- 2.sayfanın açıldığı kontrol edilir.
- Sonuca göre sergilenen ürünlerden rastgele bir ürün seçilir.
- Seçilen ürün sepete eklenir.
- Ürün sayfasındaki fiyat ile sepette yer alan ürün fiyatının doğruluğu karşılaştırılır.
- Adet arttırılarak ürün adedinin 2 olduğu doğrulanır.
- Ürün sepetten silinerek sepetin boş olduğu kontrol edilir.


#Kullanılan Araçlar

1)Selenium<br>
2)JUnit<br>
3)Log4j<br>
4)Bir Java IDE si (Ben Intelij kullanıyorum)<br>
5)Maven project<br>


#Yüzeysel olarak Ortam Kurulumu (Maven Projesi için)

  *Selenium<br>
  pom.xml dosyasına bağımlılıkları ekliyoruz<br>
  kullanacağımız tarayıcının driverını resource klasörüne atıyoruz<br>
  testi yürüttüğümüz sınıfta driverın yolunu belirtiyoruz<br>
  
  *JUnit<br>
  pom.xml dosyasına bağımlılıkları ekliyoruz
  
  *Log4j<br>
  pom.xml dosyasına bağımlılıkları ekliyoruz<br>
  resource dosyasının içerisine log2j.proprties dosyasını oluşturup içerisine rootlogger ve gerekli appenderları tanımlıyoruz<br>
  log mesajı kullanacağımız bütün classlarda logger nesnedi oluşturuyoruz<br>
  
__________________________________________________________________________________________________________________________
 test/java içerisine pages paketi oluşturup içerisine uygulamada kullanacağımız sayfaların classlarını  ve içerisinde kullanacağımız elemanları ve metodları tanımlıyoruz 
 (isterseniz base class oluşturup  Inheritance ilişki kullanılabilir)
