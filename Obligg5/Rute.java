public abstract class Rute{
    int rad;
    int kolonne;
    Rute nord;
    Rute syd;
    Rute vest;
    Rute oest;
    Labyrint lab;

    Rute(int rad, int kolonne, Labyrint lab){
        this.rad = rad;
        this.kolonne = kolonne;
        this.lab = lab;
        nord = lab.getRute(rad-2, kolonne-1);
        syd = lab.getRute(rad, kolonne-1);
        vest = lab.getRute(rad-1, kolonne-2);
        oest = lab.getRute(rad-1, kolonne);
    }



    abstract char tilTegn();

}
