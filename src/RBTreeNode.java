public class RBTreeNode {

    public int data;
    public RBTreeNode left;
    public RBTreeNode right;
    public boolean isBlack;

    public RBTreeNode(int d, boolean a) {
        this.data = d;
        this.isBlack = a;
    }

    static int countRedLeaf(RBTreeNode rNode) {
        if (rNode == null) {
            return 0;
        }
        else if (rNode.left == null && rNode.right == null && rNode.isBlack == false) {
            return 1;
        }
        else if (rNode.left == null && rNode.right == null && rNode.isBlack == true) {
            return 0;
        }
        int sum = countRedLeaf(rNode.left) + countRedLeaf(rNode.right);
        return sum;
    }

    public static void main(String[] args) {
        // not an actual redblack tree, just testing for countRedLeaf.
        RBTreeNode root = new RBTreeNode(10, true);
        RBTreeNode a = new RBTreeNode(8, true);
        RBTreeNode b = new RBTreeNode(13, true);
        RBTreeNode c = new RBTreeNode(5, true);
        RBTreeNode d = new RBTreeNode(9, true);
        RBTreeNode e = new RBTreeNode(6, false);
        RBTreeNode f = new RBTreeNode(18, true);
        RBTreeNode g = new RBTreeNode(15, false);
        RBTreeNode h = new RBTreeNode(22, false);
        h.right = new RBTreeNode(50, false);
        h.left = new RBTreeNode(30, false);

        root.left = a;
        root.right = b;
        a.left = c;
        a.right = d;
        c.right = e;
        b.right = f;
        f.left = g;
        f.right = h;
        System.out.println(countRedLeaf(root));
    }
}
