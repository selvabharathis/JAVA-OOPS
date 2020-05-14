package generics;
import java.util.LinkedList;
import java.util.Queue;// interface extends collection
import java.util.Stack;// a class extends vector
public class GenericsClass<D> {
    LinkedList<D> queue;
    public GenericsClass(){
        queue = new LinkedList();
    }
    public boolean isEmpty(){
        return queue.isEmpty();
    }
    public int size(){
        return queue.size();
    }
    public void enqueue(D n){
        queue.add(n);
    }
    public D dequeue(){
        return queue.remove(0);
    }
    public D peek(){
        return queue.get(0);
    }
    public static void main(String s[]){
        GenericsClass stringQueue = new GenericsClass();
        stringQueue.enqueue("hi");
        stringQueue.enqueue("there");
        System.out.println(stringQueue.dequeue()+" ");
        System.out.println(stringQueue.dequeue()+".");
        
        GenericsClass numberQueue = new GenericsClass();
        numberQueue.enqueue(5);
        numberQueue.enqueue(7);
        System.out.println(numberQueue.dequeue()+" ");
        System.out.println(numberQueue.dequeue()+".");
    }
}
