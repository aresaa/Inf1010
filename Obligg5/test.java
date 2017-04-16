import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class test{
    public static void main(String[] args) {
        File fil = new File("in.txt");
        int rader;
        int kolonner;
        char[][] line = null;
        try{
            Scanner scan = new Scanner(fil);
                rader = scan.nextInt();
                kolonner = scan.nextInt();
                line = new char[rader][kolonner];
                int i = 0;
                while(scan.hasNext()){
                    line[i] = scan.next().toCharArray();
                    i++;
            }
        }
        catch(FileNotFoundException e){}

        for(char[] c: line){
            String out ="";
            for (char e: c){
                out += e;
            }
            System.out.println(out);
        }
        try{
            Labyrint test = Labyrint.lesFraFil(fil);
            System.out.println(test);
        }
        catch(FileNotFoundException e){
            System.out.println(e);
        }
    }
}
