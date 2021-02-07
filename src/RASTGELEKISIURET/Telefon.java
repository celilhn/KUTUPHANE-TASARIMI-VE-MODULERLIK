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

public class Telefon {

    int[] TelNolar = {0, 3, 4, 5};
    int[] UygunTelNolar = {1, 5, 6, 7};
    int[] UygunTelNolar2 = {2, 3, 4, 5, 9};

    IMEINo in = new IMEINo();
    Random rnd = new Random();

    String ImeiNo,telImeiNo;
    
    String TelefonNoUret() {
        String TelNo;

        int no;
        
        TelNo = "05";
        no = rnd.nextInt(TelNolar.length);
        TelNo += TelNolar[no];
        if (no == 0) {
            no = rnd.nextInt(UygunTelNolar.length);
            TelNo += UygunTelNolar[no];
        } else if (no == 5) {
            no = rnd.nextInt(UygunTelNolar2.length);
            TelNo += UygunTelNolar2[no];
        }

        for (int i = 0; i < 8; i++) {
            no = rnd.nextInt(10);
            TelNo += no;
        }
        
        return TelNo;
    }
    
    String TelefonImeiUret()
    {
        ImeiNo = in.ImeiNoUret();
        return ImeiNo;
    }
    
    boolean TelefonImeiKontrolEt(String ImeiNoTel)
    {
        telImeiNo = ImeiNoTel;
        return in.ImeiNoKontrolEt(telImeiNo);
    }
}
