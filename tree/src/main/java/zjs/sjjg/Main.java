package zjs.sjjg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main1(String[] args) {
//        Department department = new Department();
//        department.setCode("1001");
//        department.setName("父节点");
//        Tree<Department> parent = new Tree<>(department);
//        parent.setLeftTree(new Tree<Department>(new Department("左节点","1002")));
//        parent.setLightTree(new Tree<Department>(new Department("右节点","1002")));
//链表存储二叉树，实现广度，深度
        Tree tree = LinkedTreeUtil.buildTree();
        List<String> list = LinkedTreeUtil.guangDu(tree);
        for (String str : list) {
            System.out.println(str);
        }
        System.out.println(tree);

        LinkedTreeUtil.qianxu(tree);

        System.out.println("...................");
        LinkedTreeUtil.zhongxu(tree);

        System.out.println("...................");
        LinkedTreeUtil.houxu(tree);

        System.out.println("............");

        List list1 = LinkedTreeUtil.treeTOList(tree);

        //用数组存储树形结构
        System.out.println("............");
        Integer[] aryyTree = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        ArryTreeUtil arryTreeUtil = new ArryTreeUtil(Arrays.asList(aryyTree));
        arryTreeUtil.qianxu(0);
        System.out.println("............");
        arryTreeUtil.zhongxu(0);
        System.out.println("............");
        arryTreeUtil.houxu(0);
        System.out.println("............");
        arryTreeUtil.cengxu();
        System.out.println("............");
        arryTreeUtil.qian1();
        System.out.println("............");
        arryTreeUtil.zhognxu1();
        System.out.println("............");
        arryTreeUtil.houxu1();
    }

    /**
     * @author: ZhegnJinSong
     * @description: 二叉搜索树
     * @date: 2024/2/2 17:22
     */
    public static void main2(String[] args) {
        Tree tree = BinarySearchTree.buildTree();
        Tree valTree = BinarySearchTree.findValTree(tree, 10);
        System.out.println(valTree.getT());
        BinarySearchTree.addTreeNode(tree, new Tree<>(15));
        List list = BinarySearchTree.guangDu(tree);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    /**
     * @author: ZhegnJinSong
     * @description: 测试二叉树的删除
     * @date: 2024/2/6 15:00
     */
    public static void main(String[] args) {
        Tree tree = BinarySearchTree.buildTree();
        List list = BinarySearchTree.guangDu(tree);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        //删除叶子节点16,删除度为1的14，删除度为2的节点12
        BinarySearchTree.remove(tree, 12);
        list = BinarySearchTree.guangDu(tree);
        System.out.println("删除后.....");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("遍历中序.....");
        List<String> list1 = new ArrayList<>();
        BinarySearchTree.zhongXu(tree, list1);
        for (int i = 0; i < list1.size(); i++) {
            System.out.println(String.valueOf(list1.get(i)));
        }
    }
}