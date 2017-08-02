import java.util.*;

public class Collections {
    public static void main(String[] args) {
        //Array
        /* immutable collection - size is defined at creation.
         * Features:
         * - can access items from index directly
         * - fast collection because its immutable
         * 
         * Limitations:
         * - we cant add new items or remove existing items*/
        int[] numArr = {1, 2, 3, 4, 5, 7, 8, 9};
        int someNum = numArr[5];

        
        /*Mutable collections*/

        //Lists
        /* collection with ability to add or remove item*/

        /*ArrayList Features:
        * - can access items from index like Array
        * - can add items to end of list
        * - insert items at index
        * - remove items by value/index*/
        List<String> stringList = new ArrayList<>();
        stringList.add("hello");
        stringList.add("Im");
        stringList.add("a");
        stringList.add("List");
        
        //remove item
        stringList.remove("hello"); //by item
        stringList.remove(1); //by index

        //Queue
        /* collection obeying FIFO rules (First In First Out)
        * Features:
        * - add item at the tail of the queue
        * - remove/poll the item at the head of queue*/
        Queue<Integer> myQueue = new ArrayDeque<>();
        myQueue.add(10);
        myQueue.add(100);
        myQueue.add(32);
        myQueue.add(8);

        int num1 = myQueue.poll();//10, get the first item that was added to Queue

        //Stack
        /* collection obeying LIFO rules (Last In First Out)
        * Features:
        * - Push item at the top of stack
        * - Pop item at the top of stack if not empty(otherwise exception)*/
        Stack<String> myStack = new Stack<>();
        myStack.push("first");
        myStack.push("second");
        myStack.push("third");
        myStack.push("forth");

        String bullet = myStack.pop(); // forth, get last item that was pushed to Stack

        //Set
        /* collection that holds only unique values
         * Feautes:
         * - Add items to collection, but it works only if item(or items) is not already exists in the collection.
         * - Remove items from collection*/
        Set<Boolean> myBooleanSet = new HashSet<>();//not organized
        myBooleanSet.add(true);
        myBooleanSet.add(false);
        myBooleanSet.add(true);
        myBooleanSet.add(true);

        int size = myBooleanSet.size();//2, because duplicated values won't be added to Set

        //Map
        /* Collection of Key/Value pairs, where each key is uniqe (just like in Set collection)
         * Featues:
         * - Put key value pair in collection. if key is aleady exists, replace the old value with new one
         * - Access items from key (similar to ArrayList but with key instead of index)
         * - Remove items from key (similar to ArrayList but with key instead of index)
         */
        Map<String, Object> myMap = new HashMap<>(); //not organized
        
        //put new item
        myMap.put("name", "gal");
        myMap.put("isMale", true);
        myMap.put("age", 18);
        myMap.put("height", 1.82);
        myMap.put("weight", 85.2);
        
        //access values by key
        String name = (String) myMap.get("name");
        int age = (int) myMap.get("age");
        
        //remove item
        myMap.remove("name");
        
        //Map iteration - running on alll pair of the map
        for (Map.Entry entry : myMap.entrySet()) {
            System.out.println(entry);
        }

    }
}
