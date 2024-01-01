package linked_list;


public class SinglyLinkedList {
    Node head;
    int size;

    public class Node{
        Object val;
        Node next;

        Node(Object val){
            this.val = val;
        }
    }

    public Object get(int index) {
        if(index >= size)
            return -1;
        int counter = 0;
        Node temp = head;
        while(counter < index) {
            counter++;
            temp = temp.next;
        }
        return temp.val;
    }

    public void addAtHead(Object val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void add(Object val) {
        Node newNode = new Node(val);
        
        if(head != null) {
            Node temp = head;
           
            while(temp != null && temp.next != null){
             temp = temp.next;
            }

            temp.next = newNode;

        }else{
            addAtHead(val);
        }
        size++;
    }

    public void addAtIndex(Object val, int index){
        if(index > size || index < 0)
    		return;

        if(index == 0){
        	addAtHead(val);
        }
        else if(index == size){
            add(val);
        }
        else {
        	int counter = 0;
        	Node temp = head;
        	
            while(counter < index) {
        		temp = temp.next;
        		counter++;
        	}

        	Node newNode = new Node(val);
        	Node next = temp.next;
        	temp.next = newNode;
        	newNode.next = next;
        	size++;
        }
    }

    public void deleteAtIndex(int index) {
        if(index >= size)
        	return;

        if(index == 0) {
        	head = head.next;
        	size--;
        }else {
        	int counter = 0;
        	Node temp = head;

        	while(counter < index - 1) {
        		counter++;
        		temp = temp.next;
        	}

        	temp.next = temp.next.next;
        	size--;
        }
    }
    public String toString(){
        if(head == null){
            return "";
        }else{
            StringBuilder str = new StringBuilder();
             
            Node temp = head;
             while(temp != null){
                 str.append(temp.val);
                 str.append("-->");
                 temp = temp.next;
             }

            return str.toString();
        }
    }

    public static void main(String[] args){
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        
        System.out.println("************Add Node(1) at Head *****************");      
        list.addAtHead(1);
        System.out.println(list);
        
        System.out.println("************Add Node(2) at Index 2 *****************"); 
        list.addAtIndex(2, 1);
        System.out.println(list);
        
        System.out.println("************Deleting node at index 3*****************");
        list.deleteAtIndex(7);
        System.out.println(list);
    }
}
