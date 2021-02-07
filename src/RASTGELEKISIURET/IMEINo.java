/**
 *
 * @author Cem CAKIRCA cem.cakirca@ogr.sakarya.edu.tr
 * @since 02.04.2018
 * <p>
 * KUTUPHANE TASARIMI VE MODULERLIK
 * </p>
 */
package RASTGELEKISIURET;

import java.util.Random;

public class IMEINo {

    int[] IMEINO = new int[16];
    int ImeiDogrulama;
    Random rnd = new Random();
    int no, konum = 1, ciftler = 0, tekler = 0;

    String ImeiNoUret() {
        String ImeiNo = "";

        for (int i = 0; i < 14; i++) {
            no = rnd.nextInt(10);
            IMEINO[i] = no;
            ImeiNo += no;
        }
        ImeiNoDogrulamaUret(IMEINO);

        ImeiNo += ImeiDogrulama;
        return ImeiNo;
    }

    void ImeiNoDogrulamaUret(int[] Imei) {

        while (konum != 15) {
            if ((Imei[konum] * 2) > 9) {
                tekler += ((Imei[konum] * 2) % 10) + 1;
            } else {
                tekler += (Imei[konum] * 2);
            }
            ciftler += Imei[konum - 1];

            konum = konum + 2;
        }
        if (((ciftler + tekler) % 10) != 0) {
            ImeiDogrulama = 10 - ((ciftler + tekler) % 10);
        } else {
            ImeiDogrulama = 0;
        }
        konum = 1;
        ciftler = 0;
        tekler = 0;
    }

    boolean ImeiNoKontrolEt(String IMEINo) {

        int[] ImeiKontrol = new int[IMEINo.length() - 1];
        for (int i = 0; i < (IMEINo.length() - 1); i++) {
            ImeiKontrol[i] = Character.digit(IMEINo.charAt(i), 10);

        }
        ImeiNoDogrulamaUret(ImeiKontrol);
        return ImeiDogrulama == ImeiKontrol[14];
    }
}
