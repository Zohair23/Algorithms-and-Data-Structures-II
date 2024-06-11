public class LinkedList {
    
    private Link first; // ref to first link
    
    public LinkedList(){ // constructor
        first = null; // no links on list yet
    }

    public boolean isEmpty(){ // true if list is empty
        return (first==null);
    }

    public void insertHead(String data){ // make new link
        Link newLink = new Link(data);
        newLink.next = first; // newLink --> old first
        first = newLink; // first --> newLink
    }

    public Link removeHead() { // delete first item
        // (assumes list not empty)
        Link temp = first; // save reference to link
        first = first.next; // delete it: first-->old next
        return temp; // return deleted link
    }
        
}