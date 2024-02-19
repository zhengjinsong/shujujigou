package zjs.blance_tree;

public class Avl_tree_util {


    /**
     * @param node 节点
     * @return 节点高度
     * @author: ZhegnJinSong
     * @description: 获取节点高度
     * @date: 2024/2/7 10:11
     */
    public static int height(TreeNode node) {
        // 空节点高度为 -1 ，叶节点高度为 0
        return node == null ? -1 : node.height;
    }

    /**
     * @param node 节点
     * @return void
     * @author: ZhegnJinSong
     * @description: 更新节点高度
     * @date: 2024/2/7 10:13
     */
    public static void updateHeight(TreeNode node) {
        // 节点高度等于最高子树高度 + 1
        node.height = Math.max(height(node.left), height(node.right)) + 1;
    }

    /**
     * @param node 节点
     * @return int 平衡因子
     * @author: ZhegnJinSong
     * @description: 获取节点的平衡因子
     * @date: 2024/2/7 10:17
     */
    public static int balanceFactor(TreeNode node) {
        // 空节点平衡因子为 0
        if (node == null) return 0;
        // 节点平衡因子 = 左子树高度 - 右子树高度
        return height(node.left) - height(node.right);
    }

    /**
     * @param node 节点
     * @return void
     * @author: ZhegnJinSong
     * @description: 右旋，从根节点开始向下遍历，判断每个节点的平衡因子是否在[-1,1]范围内，平衡因子=左子树-右子树:
     * 若平衡因子<-1则说明该节点为失衡节点，偏向左边，需要右旋
     * 若平衡因子>1则说明该节点为失衡节点，偏向右边，需要右旋
     * @date: 2024/2/7 11:17
     */
    public static TreeNode rightRotate(TreeNode node) {
        TreeNode child = node.left;
        TreeNode grandChild = child.right;
        child.right = node;
        node.left = grandChild;
        updateHeight(node);
        updateHeight(child);
        return child;
    }

    /**
     * @param node 节点
     * @return void
     * @author: ZhegnJinSong
     * @description: 左旋，从根节点开始向下遍历，判断每个节点的平衡因子是否在[-1,1]范围内，平衡因子=左子树-右子树:
     * 若平衡因子<-1则说明该节点为失衡节点，偏向左边，需要右旋
     * 若平衡因子>1则说明该节点为失衡节点，偏向右边，需要右旋
     * @date: 2024/2/7 11:17
     */
    public static TreeNode leftRotate(TreeNode node) {
        TreeNode child = node.right;
        TreeNode grandChild = child.left;
        child.left = node;
        node.right = grandChild;
        updateHeight(node);
        updateHeight(child);
        return child;
    }

    /**
     * @param node 节点
     * @return void
     * @author: ZhegnJinSong
     * @description: 旋转造操作方法
     * @date: 2024/2/8 14:08
     */

    public static TreeNode rotate(TreeNode node) {
        //获取失衡的节点的平衡因子
        int balanceFactor = balanceFactor(node);
        //如果平衡因子大于1说明为左偏树，确定是左偏树而后判断左偏树如何旋转
        if (balanceFactor > 1) {
            if (balanceFactor(node.left) >= 0) {
                //失衡节点平衡因子>1,并且左子树平衡因子>=0，需要进行右旋
                return rightRotate(node);
            } else {
                //失衡节点平衡因子>1,并且左子树平衡因子<0，需要先左旋在右旋
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }
        //如果平衡因子<-1说明为右偏树，确定是右偏树而后判断右偏树如何旋转
        if (balanceFactor < -1) {
            if (balanceFactor(node.right) > 0) {
                //如果失衡节点的右子节点的平衡因子>0,则需要先右旋在左旋
                node.right = rightRotate(node.right);
                return leftRotate(node);
            } else {
                return leftRotate(node);
            }
        }
        //无需旋转，为平衡搜索树
        return node;
    }

    /**
     * @param node 节点
     * @param flag 递归调用标识，true代表外部调用，false代表递归的内部调用，解决根节点设置高度返回多1的问题
     * @return 树的高度
     * @author: ZhegnJinSong
     * @description: 构建树的高度
     * @date: 2024/2/8 15:10
     */
    public static int setTreeHeight(TreeNode node, boolean flag) {
        if (node == null) return 0;
        int letHeight = setTreeHeight(node.left, false);
        int rightHeight = setTreeHeight(node.right, false);
        node.setHeight(Math.max(letHeight, rightHeight));
        if (flag) {
            return Math.max(letHeight, rightHeight);
        }
        return Math.max(letHeight, rightHeight) + 1;
    }

    /**
     * @param node 需要调整的树
     * @param val  需要插入的节点值
     * @return TreeNode 调整后平衡的树
     * @author: ZhegnJinSong
     * @description: 插入元素并且重新构建平衡树
     * @date: 2024/2/8 17:29
     */
    public static TreeNode insertHelper(TreeNode node, int val) {
        if (node == null) return new TreeNode(val);
        if (node.val > val) {
            node.left = insertHelper(node.left, val);
        } else if (node.val < val) {
            node.right = insertHelper(node.right, val);
        } else {
            //相同节点直接返回
            return node;
        }
        updateHeight(node);
        node = rotate(node);
        return node;
    }

    /**
     * @param node 需要调整的树
     * @param val  需要删除的节点元素值
     * @author: ZhegnJinSong
     * @description: 删除节点并调整节点高度和重新构建平衡二叉搜索树9+-
     * @date: 2024/2/8 17:38
     */
    public static TreeNode removeHelper(TreeNode node, int val) {
        if (node == null) return null;
        if (node.val > val) {
            node.left = removeHelper(node.left, val);
        } else if (node.val < val) {
            node.right = removeHelper(node.right, val);
        } else {
            if (node.left == null || node.right == null) {
                TreeNode child = node.left != null ? node.left : node.right;
                // 子节点数量 = 0 ，直接删除 node 并返回
                if (child == null)
                    return null;
                    // 子节点数量 = 1 ，直接删除 node
                else
                    node = child;
            } else {
                // 子节点数量 = 2 ，则将中序遍历的下个节点删除，并用该节点替换当前节点
                TreeNode temp = node.right;
                while (temp.left != null) {
                    temp = temp.left;
                }
                node.right = removeHelper(node.right, temp.val);
                node.val = temp.val;
            }
        }
        updateHeight(node);
        node = rotate(node);
        return node;
    }
}
