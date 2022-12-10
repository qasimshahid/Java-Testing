
public class LinkedListReversal {

    // structure of items in list
    class Node {
        // each node knows "next" node
        Node next;
        // and stores a value
        int data;

        // constructor for nodes
        Node(int d) {
            data = d;
        }
    }

    // beginning of the list, initially empty
    public Node first = null;

    void insert(int d) {
        if (first == null) {
            first = new Node(d);
            return;
        } else {
            Node newNode = new Node(d);
            Node iterate = first;
            while (iterate != null) {
                if (iterate.next == null) {
                    iterate.next = newNode;
                    return;
                }
                iterate = iterate.next;
            }
        }
    }

    int pop() {
        Node iterate = first;
        int returnval = -666;

        while (iterate != null) {
            if (iterate.next == null) {
                returnval = iterate.data;
                first = null;
                return returnval;
            }

            if (iterate.next.next == null) {
                returnval = iterate.next.data;
                iterate.next = null;
                return returnval;
            }
            iterate = iterate.next;
        }
        return returnval;
    }

    void reverseStack() {
        LinkedListReversal stack = new LinkedListReversal();
        Node iterate = first;
        while (iterate != null) {
            stack.insert(iterate.data);
            iterate = iterate.next;
        }
        first = null;
        int pop = stack.pop();
        while (pop != -666) {
            insert(pop);
            pop = stack.pop();
        }

    }

    void reverseIterative() {
        Node prev = null;
        Node iterate = first;
        while (iterate != null) {
            Node temp = iterate.next;
            if (temp == null) {
                first = iterate;
            }
            iterate.next = prev;
            prev = iterate;
            iterate = temp;


        }
    }

    void reverseRecursive(Node head, Node prev) {
        if (head == null) {
            first = prev;
            return;
        } else {
            Node temp = head.next;
            head.next = prev;
            prev = head;
            reverseRecursive(temp, head);

        }
    }

    void reverseRecursive2(Node head) {
        if (head.next == null) {
            first = head;
            return;
        }
        reverseRecursive2(head.next);
        Node temp = head.next;
        temp.next = head;
        head.next = null;

    }

    Node reverseRecursive3(Node head) {
        if (head == null) {
            return head;
        }

        if (head.next == null) {
            first = head;
            return head;
        }

        Node temp = reverseRecursive3(head.next);
        head.next.next = head;
        head.next = null;
        return temp;


    }

    void printRecursive(Node head) {
        if (head == null) {
            return;
        } else {
            System.out.println(head.data);
            printRecursive(head.next);

        }
    }

    void printReverseRecurisve(Node head) {
        if (head == null) {
            return;
        }
        printReverseRecurisve(head.next);
        System.out.println(head.data);
    }


    // use a loop to print all
    public void printAll() {
        // a while loop also can work
        for (Node current = first;
             current != null;
             current = current.next) {
            System.out.println(current.data);
        }
    }

    public static void main(String[] args) {
        LinkedListReversal mc = new LinkedListReversal();
        mc.insert(1);
        mc.insert(2);
        mc.insert(3);
        mc.insert(4);
        mc.insert(5);
        mc.printRecursive(mc.first);
        System.out.println("\n");
        mc.printReverseRecurisve(mc.first);

    }
}