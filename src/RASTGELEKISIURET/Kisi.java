/**
 *
 * @author Cem CAKIRCA cem.cakirca@ogr.sakarya.edu.tr
 * @since 02.04.2018
 * <p>
 * KUTUPHANE TASARIMI VE MODULERLIK
 * </p>
 */
package RASTGELEKISIURET;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Kisi {

    String tcNo, isim, telNo, IMEINo, kisi;
    int yas;

    RastgeleKisi rk = new RastgeleKisi();
    Telefon tl = new Telefon();
    KimlikNo kn = new KimlikNo();

    public void KisiOlustur(int adet) throws IOException {
        for (int i = 0; i < adet; i++) {
            isim = rk.RastgeleIsim();
            yas = rk.RandYas();
            telNo = tl.TelefonNoUret();
            tcNo = kn.TcNoUret();
            IMEINo = tl.TelefonImeiUret();
            KisiYazdir();
        }
    }

    public void KisiYazdir() throws IOException {
        kisi = tcNo + " " + isim + " " + yas + " " + telNo + " (" + IMEINo + ")";
        String konumDosya = System.getProperty("user.dir");
        konumDosya = konumDosya + "\\Kisiler.txt";
        konumDosya = konumDosya.replaceAll("\"", "\\\\");

        File KisiDosyasi = new File(konumDosya);
        FileWriter DosyaEkleme = new FileWriter(KisiDosyasi, true);
        try (BufferedWriter ekle = new BufferedWriter(DosyaEkleme)) {
            ekle.write(kisi);
            ekle.newLine();
        }
    }

    public void KisiKontrolEt() throws FileNotFoundException, IOException {
        int satirKonumu = 1, gecersizTc = 0, gecersizImei = 0;
        String konumDosya = System.getProperty("user.dir");
        konumDosya = konumDosya + "\\Kisiler.txt";
        konumDosya = konumDosya.replaceAll("\"", "\\\\");

        Pattern TcNoBul = Pattern.compile("[0-9]+\\s");
        Pattern ImeiBul = Pattern.compile("(\\()(.*)");

        Matcher TcEsle;
        Matcher ImeiEsle;

        String satir;
        try (FileReader fr = new FileReader(konumDosya); BufferedReader br = new BufferedReader(fr)) {
            while ((satir = br.readLine()) != null) {
                TcEsle = TcNoBul.matcher(satir);
                ImeiEsle = ImeiBul.matcher(satir);
                if (TcEsle.find()) {
                    if (!kn.TcNoKontrolEt(TcEsle.group())) {
                        gecersizTc++;
                    }
                }
                if (ImeiEsle.find()) {
                    if (!tl.TelefonImeiKontrolEt(ImeiEsle.group(2).replace("\\)", ""))) {
                        gecersizImei++;
                    } else {
                    }
                }
                satirKonumu++;
            }
        }
        System.out.println("T.C. Kimlik Kontrol\n" + ((satirKonumu - 1) - gecersizTc) + " Gecerli\n" + gecersizTc + " Gecersiz");
        System.out.println("IMEI Kontrol\n" + ((satirKonumu - 1) - gecersizImei) + " Gecerli\n" + gecersizImei + " Gecersiz");

    }
}
