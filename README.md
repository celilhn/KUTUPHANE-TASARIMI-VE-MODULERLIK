# KUTUPHANE-TASARIMI-VE-MODULERLIK
Yazdığım programda “Kisiler.tx” dosyasından T.C. no ile Imei no okunması için pattern ve matcher oluşturulmuştur. Kütüphane içindeki sınıflar modüler bir şekilde oluşturulmaya çalışılmıştır. Her fonksiyon kendine ait görevi yerine getirmektedir.

Oluşturduğum yazılımdaki menüden 1 seçeneği seçildiğinde RASTGELEKISIURET kütüphanesinde “Kisi”
sınıfından “KisiOlustur” fonksiyonu çağırılır. Fonksiyon “RastgeleKisi” sınıfı kullanılarak “random_isimler.txt”
dosyasından rastgele isim seçer. Ardından rastgele yaş atanır. Telefon numarası için ise “Telefon” sınıfından
fonksiyon çağırılır ve geçerli telefon numarası oluşturulur. T.C. no üretmek için “KimlikNo” sınıfı kurallara bağlı
kalınacak şekilde kullanılır. Son olarak Imei no kurallara bağlı kalınacak şekilde oluşturulur ve “Kisiler.txt”
dosyasına yazılır. 2 seçeneği seçildiğinde ise “Kisiler.txt” dosyası satır satır okunur ve T.C. no ile Imei no için
doğrulama rakamları fonksiyonlar yardımı ile oluşturulur. Dosyadaki T.C. no ve Imei no ile oluşturulan rakamlar
kontrol edilir. Kaç adet geçerli ve geçersiz T.C. no ile Imei no varsa ekrana yazılır. 3 seçeneği ile çıkış sağlanır.

