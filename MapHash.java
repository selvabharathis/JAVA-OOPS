package doodleblue10_12_19;
import java.util.*;
/**
 *
 * @author Selvabharathi S
 * THEORY
 *      1) it stores the data in (key,value) pair.
 *      2) to access the data we should know the key.
 *      3) it is also called as hashing, which is a technique that allow us to
 *         convert large string to small string that represent the same string.
 *      4) it does not allow duplicate keys.
 *      5) hash map internally contain an array of node. they are. int hash, k key, v value, node next.
 *      6) it provide 4 constructor and all are public.
 *          HashMap(): It is the default constructor which creates an instance of HashMap with initial capacity 16 and load factor 0.75.
 *          HashMap(int initial capacity): It creates a HashMap instance with specified initial capacity and load factor 0.75.
 *          HashMap(int initial capacity, float loadFactor): It creates a HashMap instance with specified initial capacity and specified load factor.
 *          HashMap(Map map): It creates instance of HashMap with same mappings as specified map.
 *      7) it allow null value and null keys.
 */
public class MapHash
{
    public static void main(String args[])
    {
     Map<String, Integer> myHash = new HashMap<>();
     myHash.put("selva",1);//adding data with key value pair
     myHash.put("alegu",2);
     myHash.put("krishna",103);
     System.out.println(myHash.size());//gives the size of the hashmap.
     System.out.println(myHash);//print all key value pair
     myHash.clear();// clear all pairs.
     System.out.println(myHash);
    }
}
