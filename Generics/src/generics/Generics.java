package generics;

public class Generics {
    public static <E,T> E[] printArray(E[] array,T b){    // generics wont work with primitive data type, you need to use classes
        for(E element : array){
            System.out.print(element+" ");
        }
        System.out.println();
        return array;
    }
    public static void main(String[] args) {
        Integer[] intArray1,intArray3;
        Integer[] intArray2 = new Integer[4];
        intArray3 = printArray(intArray2,10);
        Integer[] intArray4 = {5,2,9,1,3};
        String[] shoppingList = {"bananas","apples","pears"};
        intArray2[0] = 10;
        intArray2[1] = 8;
        intArray2[2] = 5;
        intArray2[3] = 10;
        printArray(intArray2,"abc");
        printArray(intArray3,"tom");
        printArray(intArray4,'c');
        printArray(shoppingList,20);
    } 
}
