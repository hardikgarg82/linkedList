import java.util.Scanner;

import sun.security.mscapi.CSignature.NONEwithRSA;

public class linkedList {
    Node head;
    static class Node//Node Class
    {
        int data;
        Node next;
        Node(int d)//Constructor of Node Class
        {
            data = d;
            next = null;
        }
    }
    public static linkedList insert(linkedList list, int data)//adds data to the Linked List(at the end of the list)
    {
        Node newNode = new Node(data);
        newNode.next = null;
        if(list.head == null)
            list.head = newNode;
        else
        {
            Node last = list.head;
            while(last.next!=null)
            {
                last = last.next;
            }
            last.next = newNode;
        }
        return list;
    }
    public void printList()//prints the Linked List
    {
        Node n = head;
        while(n!=null)
        {
            System.out.print(n.data+" ");
            n = n.next;
        }
    }

    public void push(int data)//inserts the value at the head of the list
    {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }
    public void deleteNode(int key)
    {
        Node temp = head, prev = null;
        if(temp!=null && temp.data == key)//if key is in head node
        {
            head = temp.next;
            return;
        }
        while(temp!=null && temp.data!=key)
        {
            prev = temp;
            temp = temp.next;
        }
        if(temp == null)
            return;
        prev.next = temp.next;//unlink the key
    }
    public void insertAfter(Node prevNode, int data)// method to insert after a given node
    {
        if(prevNode == null)
        {
            System.out.println("Previous Node is empty, Error!!");
            return;
        }
        Node newNode = new Node(data);

        newNode.next = prevNode.next;
        prevNode.next = newNode;
    }
    public int getCountRec(Node node)//recursive count method 2
    {
        if(node==null)
            return 0;
         return 1 + getCountRec(node.next);
    }
    public int getCount()//recursive count method 1
    {
        return getCountRec(head);
    }
    public void swapNodes(int x, int y)//swap two nodes
    {
        if(x==y)
            return;
        Node prevX=null, currX=head;

        while(currX!=null && currX.data!=x)
        {
            prevX=currX;
            currX=currX.next;
        }
        Node prevY=null, currY=head;

        while(prevY!=null && currY.data!=y)
        {
            prevY=currY;
            currY=currY.next;
        }

        if(currX==null || currY==null)
            return;

        if(prevX!=null)
            prevX.next=currY;
        else
            head=currY;
        
        if(prevY!=null)
            prevY.next=currX;
        else
            head=currX;
        
        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
    }
    public Node reverse(Node head)
    {
        if(head==null||head.next==null)
            return head;
        
        Node rest = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return rest;
    }
    public static void main(String[] args)
    {
        int n;
        Scanner sc = new Scanner(System.in);
        linkedList list = new linkedList();
        System.out.println("Enter how many values you want to store in the linked list");
        n = sc.nextInt();
        while(n!=0)
        {
            int data = sc.nextInt();
            list = insert(list, data);
            n--;
        }
        System.out.println("Enter your choice of action to perform: ");
        int x = 10;
        while(x!=-1)
        {
            System.out.println("Press 1 and enter to add value at the head of the linked list");
            System.out.println("Press 2 and enter to delete a key/value from the linked list");
            System.out.println("Press 3 and enter to print the linked list");
            System.out.println("Press 4 and enter to insert at a given node");
            System.out.println("Press 5 and enter to count the length of the linked list");
            System.out.println("Press 6 and enter to swap two elements of the linked list");
            System.out.println("Press 7 and enter to reverse the linked list");
            System.out.println("Press -1 to exit the action selection");
            x = sc.nextInt();
            int y;
            switch(x)
            {
                case 1:{
                    System.out.println("Enter the value to be inserted at the head: ");
                    y = sc.nextInt();
                    list.push(y);
                }
                break;
                case 2:{
                    System.out.println("Enter the element to be deleted: ");
                    y = sc.nextInt();
                    list.deleteNode(y);
                }
                break;
                case 3:{
                    list.printList();
                }
                break;
                case 4:{
                    System.out.println("Enter the position after which you want to enter the data: ");
                    int position = sc.nextInt();
                    System.out.println("Enter the data you want to enter: ");
                    int d = sc.nextInt();
                    Node j = new Node(0);
                    Node temp = list.head;
                    for(int i=0;i<position;i++)
                    {
                        j = temp.next;
                        temp = temp.next;
                    }
                    list.insertAfter(j, d);
                }
                break;
                case 5:{
                    int length = list.getCount();
                    System.out.println(length);
                }
                break;
                case 6:{
                    System.out.println("Enter the nodes you want to swap");
                    System.out.println("Node 1: ");
                    int n1 = sc.nextInt();
                    System.out.println("Node 2: ");
                    int n2 = sc.nextInt();
                    list.swapNodes(n1, n2);
                }
                break;
                case 7:{
                    System.out.println("The reversed list is: ");
                    list.head = list.reverse(list.head);
                    list.printList();
                }
                break;
                default:{
                    System.out.println("Entered input does not matches the given options, please run the program again");
                }
            }
        }
        sc.close();
    }
}