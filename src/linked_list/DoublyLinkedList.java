package linked_list;

public class DoublyLinkedList {
    Node head;
    int size;

    public class Node{
        Object val;
        Node prev;
        Node next;

        public Node(Object val){
            this.val = val;
        }
    }


    public void add(Object val){
        if(head == null){
          head = new Node(val);
        }else{
          Node temp = head;
          while(temp!= null && temp.next != null){
            temp = temp.next;
          }
          
          Node newNode = new Node(val);
          newNode.prev = temp;
          temp.next = newNode;
        }
        size++;
    }

     public void addAtHead(Object val){

        if(head == null){
          head = new Node(val);
        }else{
            Node newNode = new Node(val);
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void addAtIndex(Object val,int index){
      if(index < 0 || index > size)
        return;
      else if(index == 0)
        addAtHead(val);
      else if(index == size)
        add(val);
      else{
           int counter = 0;
           Node temp = head;
         while(counter < index){
            counter++;
            temp = temp.next;
         }
         
            Node newNode = new Node(val);
            Node next = temp.next;
            
            temp.next = newNode;
            newNode.prev = temp;
            newNode.next = next;
            size++;
        }
    }

    public void deleteAtIndex(int index){
        if(index < 0 || index > size || size == 0)
            return ;
        else {
            int counter = 0;
            Node temp = head;
            while (counter < index - 1){
                temp = temp.next;
                counter++;
            }
            temp.next = temp.next.next;
            temp.next.prev = temp;
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
            DoublyLinkedList list = new DoublyLinkedList();
            list.add(10);
            list.add(20);
            list.add(30);
            System.out.println(list);

            System.out.println("************Add Node(1) at Head *****************");      
            list.addAtHead(1);
            System.out.println(list);

            System.out.println("************Add Node(2) at index 2 *****************");      
            list.addAtIndex(2,2);
            System.out.println(list);

            System.out.println("************Add Node at index 2 *****************");      
            list.deleteAtIndex(2);
            System.out.println(list);

            
         }
}   
