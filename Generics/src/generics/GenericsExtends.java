package generics;


public class GenericsExtends {
    public static <T extends Comparable <T>> T findMax(T a,T b){
        int n = a.compareTo(b); // if n=-ve a is smaller, if n=0 a and b are equal, if n=+ve a is greater
        if(n<0)
            return b;
        else
            return a;
    }
    public static void main(String args[]){
        System.out.println(findMax(2,3));
        System.out.println(findMax(2.0,3.0));
        System.out.println(findMax('a','b'));
        System.out.println(findMax("hello","there"));
    }
    
}
