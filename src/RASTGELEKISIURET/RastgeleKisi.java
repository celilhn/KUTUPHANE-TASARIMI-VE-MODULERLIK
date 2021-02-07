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
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class RastgeleKisi {

    Random rnd = new Random();

    int randSayi() {
        int sayi;
        sayi = rnd.nextInt(3001);
        return sayi;
    }

    int RandYas() {
        int yas;
        yas = rnd.nextInt(100);
        if (yas == 0) {
            yas = 1;
        }
        return yas;
    }

    String RastgeleIsim() throws IOException {
        int sayi = randSayi();
        String isim = "";
        String konumDosya = System.getProperty("user.dir");
        konumDosya = konumDosya + "\\random_isimler.txt";
        konumDosya = konumDosya.replaceAll("\"", "\\\\");

        String satir;
        FileReader in = new FileReader(konumDosya);

        try (BufferedReader br = new BufferedReader(in)) {
            for (int i = 0; i < sayi; i++) {
                if ((satir = br.readLine()) != null && i == (sayi - 1)) {
                    isim = satir;
                }
            }
        }
        return isim;
    }
}
