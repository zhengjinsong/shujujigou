package zjs.sjjg;

import java.util.ArrayList;
import java.util.List;

public class ArryTreeUtil {
    List<Integer> arryTree;

    public ArryTreeUtil(List<Integer> list) {
        this.arryTree = list;
    }

    /**
     * @param
     * @return 二叉树数组表示的长度
     * @author: ZhegnJinSong
     * @description: 返回数组的长度
     * @date: 2024/2/2 10:20
     */
    public int size() {
        return arryTree.size();
    }

    /* 获取索引为 i 节点的值 */
    public Integer val(int i) {
        // 若索引越界，则返回 null ，代表空位
        if (i < 0 || i >= size())
            return null;
        return arryTree.get(i);
    }

    /* 获取索引为 i 节点的左子节点的索引 */
    public Integer left(int i) {
        return 2 * i + 1;
    }

    /* 获取索引为 i 节点的右子节点的索引 */
    public Integer right(int i) {
        return 2 * i + 2;
    }

    /* 获取索引为 i 节点的父节点的索引 */
    public Integer parent(int i) {
        return (i - 1) / 2;
    }

    /* 前序遍历 */
    public void qianxu(int i) {
        Integer val = val(i);
        if (val == null) return;
        System.out.println(val);
        qianxu(left(i));
        qianxu(right(i));
    }

    /* 中序遍历 */
    public void zhongxu(int i) {
        Integer val = val(i);
        if (val == null) return;
        zhongxu(left(i));
        System.out.println(val);
        zhongxu(right(i));
    }


    /* 后序遍历 */
    public void houxu(int i) {
        Integer val = val(i);
        if (val == null) return;
        houxu(left(i));
        houxu(right(i));
        System.out.println(val);
    }

    /* 后序遍历 */
    public void cengxu() {
        for (int i = 0; i < arryTree.size(); i++) {
            System.out.println(val(i));
        }
    }

    /* 深度优先遍历 */
    private  void def(int index, String flag, List<Integer> list) {
        Integer val = val(index);
        if (val == null) return;
        if (flag.equals("pre"))
            list.add(val);
        def(left(index), flag, list);
        if (flag.equals("in"))
            list.add(val);
        def(right(index), flag, list);
        if ("post".equals(flag))
            list.add(val);
    }

    /* 前序1 */
    public void qian1() {
        List list = new ArrayList();
        def(0, "pre", list);
        for (int i = 0; i < arryTree.size(); i++) {
            System.out.println(val(i));
        }
    }

    /* 中序1 */
    public void zhognxu1() {
        List list = new ArrayList();
        def(0, "in", list);
        for (int i = 0; i < arryTree.size(); i++) {
            System.out.println(val(i));
        }
    }

    /* 后序1 */
    public void houxu1() {
        List list = new ArrayList();
        def(0, "post", list);
        for (int i = 0; i < arryTree.size(); i++) {
            System.out.println(val(i));
        }
    }
}
