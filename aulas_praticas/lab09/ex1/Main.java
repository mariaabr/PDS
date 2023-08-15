//Iterator

import java.util.*;

public class Main{
    public static void main(String[] args) {

        VectorGeneric<Integer> vector = new VectorGeneric<>();

        for(int i=0; i<10; i++)
            vector.addElem(i);

        Iterator<Integer> vecit = vector.Iterator();
            while(vecit.hasNext())
                System.out.println("index: " + vecit.next());

        ListIterator<Integer> veclit = vector.listIterator();
            while(veclit.hasNext())
                System.out.println("index: " + veclit.next() + "\n" + "next index >> " + veclit.nextIndex());

    }
}
