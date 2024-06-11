public class Stack{
    
    private LinkedList list;
    
    public Stack(){ // constructor
        list = new LinkedList();
    }
    
    public void push(String data){ // put item on top of stack
        list.insertHead(data);
    }

    public String pop(){ // take item from top of stack
        return list.removeHead().data;
    }
}
    