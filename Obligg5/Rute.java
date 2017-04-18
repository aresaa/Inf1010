public abstract class Rute{
    private int rad;
    private int kolonne;
    private Rute[] omegn = new Rute[4]; //array for nord/syd/vest/oest, i den rekkefoelgen
    private Labyrint lab;
    private boolean paaVeien = false;

    Rute(int rad, int kolonne, Labyrint lab){
        this.rad = rad;
        this.kolonne = kolonne;
        this.lab = lab;
    }

    public void omegnInitialisering(){
        omegn[0] = lab.getRute(rad-2, kolonne-1);   //nord
        omegn[1] = lab.getRute(rad, kolonne-1);     //syd
        omegn[2] = lab.getRute(rad-1, kolonne-2);  //vest
        omegn[3] = lab.getRute(rad-1, kolonne);    //oest
    }

    public void finnUtvei(){
        gaa("", this);
    }

    public void gaa(String sti, Rute fra){

        if (!paaVeien && (this instanceof HvitRute) ){
            if (this instanceof Aapning){
                sti += "("+kolonne+","+rad+")";
                lab.leggTilUtvei(sti);
            }
            else{
                paaVeien = true;
                sti += "("+kolonne+","+rad+") --> ";
    //            System.out.println(sti);
                for (Rute r: omegn){
                //    System.out.println(r);
                    if (r!= null && r != fra){
                        r.gaa(sti, this);
                    }
                }
                paaVeien = false;
            }
        }
        else {

        }
    }


    abstract char tilTegn();

}
