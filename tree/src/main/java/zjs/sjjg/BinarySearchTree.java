package zjs.sjjg;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinarySearchTree {
    public static Tree buildTree() {
        Tree<Integer> parent = new Tree<>(8);
        Tree<Integer> child1_left = new Tree<>(4);
        Tree<Integer> child1_right = new Tree<>(12);
        Tree<Integer> child2_left_left = new Tree<>(2);
        Tree<Integer> child2_left_right = new Tree<>(6);
        Tree<Integer> child2_right_left = new Tree<>(10);
        Tree<Integer> child2_right_right = new Tree<>(14);
        child2_right_right.setLightTree(new Tree<>(16));
        parent.setLeftTree(child1_left);
        child1_left.setLeftTree(child2_left_left);
        child1_left.setLightTree(child2_left_right);
        parent.setLightTree(child1_right);
        child1_right.setLeftTree(child2_right_left);
        child1_right.setLightTree(child2_right_right);
        return parent;
    }

    /**
     * @param
     * @author: ZhegnJinSong
     * @description: 二叉搜索树查找节点
     * @date: 2024/2/2 17:17
     */
    public static Tree<Integer> findValTree(Tree<Integer> root, Integer val) {
        if (root == null) return null;
        Tree<Integer> node = root;
        while (node != null) {
            if (node.getT() > val) {
                node = node.leftTree;
            } else if (node.getT() < val) {
                node = node.lightTree;
            } else {
                break;
            }
        }
        return node;
    }

    /**
     * @param
     * @author: ZhegnJinSong
     * @description: 二叉搜索树新增节点
     * @date: 2024/2/2 16:52
     */
    public static void addTreeNode(Tree<Integer> root, Tree<Integer> node) {
        if (root == null) {
            root = node;
            return;
        }
        Integer val = node.getT();
        Tree<Integer> cur = root, pre = null;
        while (cur != null) {
            if (cur.getT() > val) {
                pre = cur;
                cur = cur.leftTree;
            } else if (cur.getT() < val) {
                pre = cur;
                cur = cur.lightTree;
            } else break;
        }
        if (pre.getT() > val) {
            pre.leftTree = node;
        } else if (pre.getT() < val) {
            pre.lightTree = node;
        }
    }


    /**
     * @author: ZhegnJinSong
     * @description: 树形结构，广度遍历
     * @date: 2024/1/23 9:11
     */
    public static List<String> guangDu(Tree<String> parent) {
        Deque<Tree> deque = new ArrayDeque<>();
        List<String> list = new ArrayList<>();
        deque.add(parent);
        while (!deque.isEmpty()) {
            Tree poll = deque.poll();
            list.add(poll.getT().toString());
            if (poll.getLeftTree() != null)
                deque.add(poll.getLeftTree());
            if (poll.getLightTree() != null)
                deque.add(poll.getLightTree());
        }
        return list;
    }

    /**
     * @return
     * @author: ZhegnJinSong
     * @description: 二叉搜索树中序遍历
     * @date: 2024/2/7 9:45
     */
    public static void zhongXu(Tree<String> parent, List<String> list) {
        if (parent == null) return;
        zhongXu(parent.getLeftTree(), list);
        list.add(parent.getT());
        zhongXu(parent.getLightTree(), list);
    }

    /**
     * @param root 树形结构
     * @param val  要删除的变量值
     * @return
     * @author: ZhegnJinSong
     * @description: 删除树形结构的节点，删除可分三中情况如下所示
     * 1.被删除的节点度为0：可直接删除
     * 2.被删除的节点度为1：删除节点的左或者右子树代替被删除节点
     * 3.被删除的节点度为2：左子树的最右的叶子节点，右子树的最左叶子节点
     * @date: 2024/2/6 14:17
     */
    public static void remove(Tree<Integer> root, Integer val) {
        //先找到要删除的节点和删除节点的父节点
        if (root == null) return;
        Tree<Integer> cur = root, pre = null;
        while (cur != null) {
            if (cur.getT() == val) break;
            else if (cur.getT() > val) {
                pre = cur;
                cur = cur.getLeftTree();
            } else {
                pre = cur;
                cur = cur.getLightTree();
            }
        }
        //未找到要删除的节点直接返回
        if (cur == null) return;
        //处理被删除节点的度为0或者1时
        if (cur.getLeftTree() == null || cur.getLightTree() == null) {
            Tree<Integer> child = cur.getLeftTree() != null ? cur.getLightTree() : cur.getLightTree();
            if (cur != root) {
                if (pre.getLeftTree() == cur) {
                    pre.setLeftTree(child);
                } else {
                    pre.setLightTree(child);
                }
            } else {
                root = child;
            }
        } else {
            //要删除的节点的度为2时，找删除节点的右子树的最左叶子节点
            Tree<Integer> tmp = cur.getLightTree();
            while (tmp.getLeftTree() != null) {
                tmp = tmp.getLeftTree();
            }
            //关键，递归调用删除替换删除节点的节点
            remove(root, tmp.getT());
            cur.setT(tmp.getT());
        }

    }


}
