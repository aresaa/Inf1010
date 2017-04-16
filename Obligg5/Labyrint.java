/*
*@author Are S. Aamot aresaa
*
*/


import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Labyrint{
    private Rute[][] labyrint;
    private int rader;
    private int kolonner;

    static Labyrint lesFraFil(File fil) throws FileNotFoundException{
        int rader;
        int kolonner;
        char[][] lab;
        Scanner scan = new Scanner(fil);
        rader = scan.nextInt();
        kolonner = scan.nextInt();
        lab = new char[rader][kolonner];
        int i = 0;
        while(scan.hasNext()){
            lab[i] = scan.next().toCharArray();
            i++;
        }

        return new Labyrint(rader, kolonner, lab);
    }

    private Labyrint(int rader, int kolonner, char[][] lab){
        this.rader = rader;
        this.kolonner = kolonner;
        labyrint = new Rute[rader][kolonner];
        for (int i=0; i<rader; i++){
            for (int j = 0; j< kolonner; j++){

                if(lab[i][j]=='.'){
                    if (i==0 || j==0 || i==(rader-1) || j == (kolonner-1)){
                        labyrint[i][j] = new Aapning(i+1, j+1, this);
                    }
                    else{
                        labyrint[i][j] = new HvitRute(i+1, j+1, this);
                    }
                }
                else if (lab[i][j]=='#'){
                    labyrint[i][j] = new SortRute(i+1, j+1, this);
                }

            }
        }
    }
    public int getRader(){
        return rader;
    }

    public int getKolonner(){
        return kolonner;
    }

    public Rute getRute(int rad, int kolonne){
        if(rad<0 || kolonne<0 || rad>=rader || kolonne >= kolonner){
            return null;
        }
        return labyrint[rad][kolonne];
    }

    public String toString(){
        String out = new String("");
        for (int i = 0; i<rader; i++){
            for (int j = 0; j< kolonner; j++){
                if (labyrint[i][j] instanceof HvitRute){
                    out +=" ";
                }
                else{
                    out +="#";
                }
            }
        out+="\n";
        }
        return out;
    }

}
