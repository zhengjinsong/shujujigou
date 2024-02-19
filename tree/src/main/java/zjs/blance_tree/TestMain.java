package zjs.blance_tree;

public class TestMain {
    public static void main(String[] args) {
        rightRotate();
        testBuild();
    }

    //测试左偏树，右旋
    private static void rightRotate() {
        TreeNode root = new TreeNode(4);
        TreeNode root_left = new TreeNode(3);
        TreeNode root_right = new TreeNode(5);
        TreeNode root_left_left = new TreeNode(1);
        TreeNode root_left_left_left = new TreeNode(0);
        root.setLeft(root_left);
        root.setRight(root_right);
        root_left.setLeft(root_left_left);
        root_left_left.setLeft(root_left_left_left);
        int i = Avl_tree_util.setTreeHeight(root, true);
        TreeNode rotate = Avl_tree_util.rotate(root);
        System.out.println(rotate.val);
    }

    //测试构建节点

    private static void testBuild() {
        TreeNode root = new TreeNode(4);
        TreeNode treeNode = Avl_tree_util.insertHelper(root, 3);
        TreeNode treeNode1 = Avl_tree_util.insertHelper(treeNode, 5);
        Avl_tree_util.insertHelper(root,6);
        System.out.println(treeNode1);
    }
}
