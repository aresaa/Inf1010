public class Utvei implements Comparable<Utvei>{
    String utvei;
    Utvei(String utvei){
        this.utvei = utvei;
    }

    public int compareTo(Utvei otherUtvei){
        return this.utvei.length()-otherUtvei.toString().length();
    }

    public String toString(){
        return utvei;
    }

}
