import java.util.LinkedList;

public class TreeOrderTraversal {

    int data;
    public TreeOrderTraversal lc;
    public TreeOrderTraversal rc;

    public TreeOrderTraversal(int d, TreeOrderTraversal l, TreeOrderTraversal r) {
        this.data = d;
        this.lc = l;
        this.rc = r;
    }

    static void inOrder(TreeOrderTraversal node) {
        if (node== null) {
            return;
        }
        inOrder(node.lc);
        System.out.print(node.data + " ");
        inOrder(node.rc);
    }


    static void PreOrder(TreeOrderTraversal node) {
        if (node== null) {
            return;
        }
        System.out.print(node.data + " ");
        PreOrder(node.lc);
        PreOrder(node.rc);
    }

    static void PostOrder(TreeOrderTraversal node) {
        if (node== null) {
            return;
        }
        PostOrder(node.lc);
        PostOrder(node.rc);
        System.out.print(node.data + " ");
    }

    static void BFS(TreeOrderTraversal node) {
        LinkedList<TreeOrderTraversal> queue = new LinkedList<>();
        queue.addFirst(node);
        while (!queue.isEmpty()) {
            TreeOrderTraversal a = queue.removeFirst();
            System.out.print(a.data + " ");
            if (a.lc != null) {
                queue.addLast(a.lc);
            }
            if (a.rc != null) {
                queue.addLast(a.rc);
            }
        }
    System.out.println();

    }


    public static void main(String[] args) {

        TreeOrderTraversal root = new TreeOrderTraversal(10, null, null);
        root.lc = new TreeOrderTraversal(5, null, null);
        root.rc = new TreeOrderTraversal(20, null, null);
        root.lc.lc = new TreeOrderTraversal(2, null, null);
        root.lc.rc = new TreeOrderTraversal(8, new TreeOrderTraversal(6, null, null), new TreeOrderTraversal(9, null, null));
        root.rc.lc = new TreeOrderTraversal(11, null, null);
        root.rc.rc = new TreeOrderTraversal(50, null, null);


        TreeOrderTraversal.inOrder(root);
        System.out.println("\n");
        TreeOrderTraversal.PreOrder(root);
        System.out.println("\n");
        TreeOrderTraversal.PostOrder(root);
        System.out.println("\n");
        TreeOrderTraversal.BFS(root);


    }
}
