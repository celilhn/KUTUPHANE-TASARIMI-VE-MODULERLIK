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

public class KimlikNo {

    int[] TcDogrulama = new int[2];
    int TcIslem;
    Random rnd = new Random();

    String TcNoUret() {
        String TcNo;
        int tcRakam;
        int[] TcDizi = new int[9];

        tcRakam = rnd.nextInt(8);
        TcNo = "" + (tcRakam + 1);
        TcDizi[0] = (tcRakam + 1);
        for (int i = 0; i < 8; i++) {
            tcRakam = rnd.nextInt(10);
            TcNo += tcRakam;
            TcDizi[i + 1] = tcRakam;
        }
        TcNoDogrulamaUret(TcDizi);
        TcNo += TcDogrulama[0] + "" + TcDogrulama[1];
        return TcNo;
    }

    void TcNoDogrulamaUret(int[] Tc) {
        TcIslem = (((Tc[0] + Tc[2] + Tc[4] + Tc[6] + Tc[8]) * 7) - (Tc[1] + Tc[3] + Tc[5] + Tc[7])) % 10;
        TcDogrulama[0] = TcIslem;
        for (int i = 0; i < 9; i++) {
            TcIslem += Tc[i];
        }
        TcDogrulama[1] = TcIslem % 10;
    }

    boolean TcNoKontrolEt(String tcNo) {

        int[] tcKontrol = new int[tcNo.length()];
        for (int i = 0; i < (tcNo.length() - 1); i++) {
            tcKontrol[i] = Character.digit(tcNo.charAt(i), 10);
        }
        TcNoDogrulamaUret(tcKontrol);

        return tcKontrol[9] == TcDogrulama[0] && tcKontrol[10] == TcDogrulama[1];
    }
}
