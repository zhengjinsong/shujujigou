package zjs.sjjg;

/**
 * @author: ZhegnJinSong
 * @description: 泛型，树型结构中的节点元素
 * @date: 2024/1/22 9:21
 */
public class Tree<T> {
    T t;
    Tree<T> lightTree;
    Tree<T> leftTree;

    Tree(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public Tree<T> getLightTree() {
        return lightTree;
    }

    public void setLightTree(Tree<T> lightTree) {
        this.lightTree = lightTree;
    }

    public Tree<T> getLeftTree() {
        return leftTree;
    }

    public void setLeftTree(Tree<T> leftTree) {
        this.leftTree = leftTree;
    }
}
