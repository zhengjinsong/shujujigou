package zjs.rb_tree;

/**
 * <h3>
 *     红黑树的实现,博客:https://www.cnblogs.com/qzlzzz/p/15395010.html
 * </h3>
 * @author qzlzzz
 * @since 2021/10/12
 * @version 1.0
 */
public class RedBlackBST<Key extends Comparable<Key>,Value> {
    
        
    private Node root;//根节点

    //<父结点>指向自己<子结点>的链接是红色的
    private static final boolean RED = true;

    //<父结点>指向自己<子结点>的链接是黑色的
    private static final boolean BLACK = false;

    /**
     * <p>红黑树的结点定义</p>
     * @author qzlzzz
     */
    private class Node{
        
        private boolean color;//指向该结点的链接的颜色
        
        private Key key;//键
        
        private Value value;//值
        
        private Node left,right;//该结点指向左结点的链接和右结点的链接
        
        private int n;//该子树的结点树

        public Node(Key key,Value value,boolean color,int n){
            this.key = key;
            this.value = value;
            this.color = color;
            this.n = n;
        }
    }
    
}