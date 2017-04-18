import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class test{
    public static void main(String[] args) {
        File fil = new File("5.in");
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
            //System.out.println(out);
        }
        try{
            Labyrint test = Labyrint.lesFraFil(fil);
            System.out.println(test);
//            Stabel<String> utveier =  test.finnUtveiFra(10, 10);
//            for (String c: utveier){
//                System.out.println(c);
//            }
//    /        System.out.print(utveier[0]);

        }
        catch(FileNotFoundException e){
            System.out.println(e);
        }
    }
}
