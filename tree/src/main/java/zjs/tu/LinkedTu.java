package zjs.tu;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class LinkedTu {
    private static Map<Vertex, List<Vertex>> vertexListMap = new HashMap<>();

    // 添加所有顶点和边
    public static void addGraphAdjList(Vertex[][] edges) {
        for (Vertex[] edge : edges) {
            addVertex(edge[0]);
            addVertex(edge[1]);
            addEdge(edge[0], edge[1]);
        }
    }

    /**
     * @Description: 添加节点
     * @param: v1 顶点1
     * @param: v2 顶点2
     * @return: void
     * @Author: ZhengJinSong
     * @Date: 2024/2/24 19:08
     */
    public static void addEdge(Vertex v1, Vertex v2) {
        if (!vertexListMap.containsKey(v1) || !vertexListMap.containsKey(v2) || v1 == v2) {
            throw new IllegalArgumentException();
        }
        //添加边
        vertexListMap.get(v1).add(v2);
        vertexListMap.get(v2).add(v1);
    }

    /**
     * @Description: 添加顶点元素
     * @param: vertex 图的顶点元素
     * @Author: ZhengJinSong
     * @Date: 2024/2/24 19:03
     */
    public static void addVertex(Vertex vertex) {
        if (vertexListMap.containsKey(vertex))
            return;
        // 在邻接表中添加一个新链表
        vertexListMap.put(vertex, new ArrayList<Vertex>());
    }

    /* 打印邻接表 */
    public static void print() {
        System.out.println("邻接表 =");
        for (Map.Entry<Vertex, List<Vertex>> pair : vertexListMap.entrySet()) {
            List<Integer> tmp = new ArrayList<>();
            for (Vertex vertex : pair.getValue())
                tmp.add(vertex.val);
            System.out.println(pair.getKey().val + ": " + tmp + ",");
        }
    }

    /**
     * @Description: 删除连个顶点的边
     * @param: v1 顶点1
     * @param: 2 顶点2
     * @return:
     * @Author: ZhengJinSong
     * @Date: 2024/2/24 19:52
     */
    public static void deleteEdge(Vertex v1, Vertex v2) {
        if (!vertexListMap.containsKey(v1) || !vertexListMap.containsKey(v2) || v1 == v2) {
            throw new IllegalArgumentException();
        }
        vertexListMap.get(v1).remove(v2);
        vertexListMap.get(v2).remove(v1);
    }

    /**
     * @Description:移除顶点
     * @param: v1 要移除的顶点
     * @return:
     * @Author: ZhengJinSong
     * @Date: 2024/2/24 19:57
     */
    public static void deleteVertex(Vertex v1) {
        if (!vertexListMap.containsKey(v1)) {
            throw new IllegalArgumentException();
        }
        vertexListMap.remove(v1);
        for (Map.Entry<Vertex, List<Vertex>> vertexListEntry : vertexListMap.entrySet()) {
            vertexListEntry.getValue().remove(v1);
        }
    }

    /**
     * @Description: 邻接表广度遍历
     * @param: vertexListMap 图的邻接表表示
     * @param: vertex 顶点
     * @return:
     * @Author: ZhengJinSong
     * @Date: 2024/2/24 22:19
     */
    public static List<Vertex> graphBFS(Map<Vertex, List<Vertex>> vertexListMap, Vertex vertex) {
        List<Vertex> res = new ArrayList<>();
        Set<Vertex> visited = new HashSet<>();
        Queue<Vertex> queue = new LinkedList<>();
        visited.add(vertex);
        queue.offer(vertex);
        while (!queue.isEmpty()) {
            Vertex verTmp = queue.poll();
            res.add(verTmp);
            for (Vertex vertex1 : vertexListMap.get(verTmp)) {
                if (visited.contains(vertex1)) {
                    continue;
                }
                queue.add(vertex1);
                visited.add(vertex1);
            }
        }
        return res;
    }

    /**
     * @Description:
     * @param: null
     * @return:
     * @Author: ZhengJinSong
     * @Date: 2024/2/24 23:25
     */
    public static List<Vertex> graphDFS(Map<Vertex, List<Vertex>> vertexListMap, Vertex vertex) {
        List<Vertex> res = new ArrayList<>();
        Set<Vertex> visited = new HashSet<>();
        dfs(vertexListMap, vertex, visited, res);
        return res;
    }

    public static void dfs(Map<Vertex, List<Vertex>> vertexListMap, Vertex vertex, Set<Vertex> visited, List<Vertex> res) {
        res.add(vertex);
        visited.add(vertex);
        for (Vertex vertex1 : vertexListMap.get(vertex)) {
            if (visited.contains(vertex1)) {
                continue;
            }
            dfs(vertexListMap, vertex1, visited, res);
        }
    }

    public static void main(String[] args) {
        //构建顶点
        List<Vertex> vertex = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            vertex.add(new Vertex(i));
            addVertex(vertex.get(i - 1));
        }
        //构建边
        addEdge(vertex.get(0), vertex.get(1));
        addEdge(vertex.get(0), vertex.get(2));
        addEdge(vertex.get(1), vertex.get(2));
        addEdge(vertex.get(1), vertex.get(3));
        addEdge(vertex.get(1), vertex.get(4));
        addEdge(vertex.get(2), vertex.get(3));
        addEdge(vertex.get(3), vertex.get(4));
        print();
        //删除边
        System.out.println("删除3,4的边");
        deleteEdge(vertex.get(2), vertex.get(3));
        print();
        //删除顶点
        System.out.println("删除顶点0");
        deleteVertex(vertex.get(0));
        print();
        //广度遍历
        List<Vertex> vertices = graphBFS(vertexListMap, vertex.get(1));
        for (Vertex vertex1 : vertices) {
            System.out.println(vertex1.getVal());
        }
        System.out.println("深度遍历.............");
        List<Vertex> vertices1 = graphDFS(vertexListMap, vertex.get(1));
        for (Vertex vertex1 : vertices1) {
            System.out.println(vertex1.getVal());
        }
    }
}
