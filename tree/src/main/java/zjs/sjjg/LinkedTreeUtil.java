package zjs.sjjg;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LinkedTreeUtil<T> {

    public static Tree buildTree() {
        Tree<String> parent = new Tree<>("root");
        Tree<String> child1_left = new Tree<>("child1_left");
        Tree<String> child1_right = new Tree<>("child1_right");
        Tree<String> child2_left_left = new Tree<>("child2_left_left");
        Tree<String> child2_left_right = new Tree<>("child2_left_right");
        Tree<String> child2_right_left = new Tree<>("child2_right_left");
        Tree<String> child2_right_right = new Tree<>("child2_right_right");
        parent.setLeftTree(child1_left);
        child1_left.setLeftTree(child2_left_left);
        child1_left.setLightTree(child2_left_right);
        parent.setLightTree(child1_right);
        child1_right.setLeftTree(child2_right_left);
        child1_right.setLightTree(child2_right_right);
        return parent;
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
            if (poll.lightTree != null)
                deque.add(poll.getLeftTree());
            if (poll.getLightTree() != null)
                deque.add(poll.getLightTree());
        }
        return list;
    }


    /**
     * @author: ZhegnJinSong
     * @description: 前序
     * @date: 2024/1/25 8:56
     */
    public static void qianxu(Tree<String> parent) {
        if (parent == null) return;
        System.out.println(parent.getT());
        qianxu(parent.getLeftTree());
        qianxu(parent.getLightTree());
    }


    /**
     * @author: ZhegnJinSong
     * @description: 中序
     * @date: 2024/1/25 8:56
     */
    public static void zhongxu(Tree<String> parent) {
        if (parent == null) return;
        zhongxu(parent.getLeftTree());
        System.out.println(parent.getT());
        zhongxu(parent.getLightTree());
    }

    /**
     * @author: ZhegnJinSong
     * @description: 中序
     * @date: 2024/1/25 8:56
     */
    public static void houxu(Tree<String> parent) {
        if (parent == null) return;
        zhongxu(parent.getLeftTree());
        zhongxu(parent.getLightTree());
        System.out.println(parent.getT());
    }

    /**
     * @author: ZhegnJinSong
     * @description: 二叉树的数组表现，二叉树的数组表示形式只适合于满二叉树，非满二叉树需要用特殊标识标记为空的节点，造成空间上的浪费。
     * @date: 2024/1/26 8:57
     */
    public static List<Tree> treeTOList(Tree<String> tree) {
        Deque<Tree> deque = new ArrayDeque<>();
        deque.add(tree);
        List<Tree> list = new ArrayList<>();
        while (!deque.isEmpty()) {
            Tree poll = deque.poll();
            list.add(poll);
            if (poll.lightTree != null)
                deque.add(poll.getLeftTree());
            if (poll.getLightTree() != null)
                deque.add(poll.getLightTree());
        }
        return list;
    }

    /**
     * @param null
     * @return
     * @author: ZhegnJinSong
     * @description: 构建二叉搜索树
     * @date: 2024/1/30 9:05
     */
    public  static  void buildBriTree(){

    }

}
