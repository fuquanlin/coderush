package cn.fql.coderush.structure;

import java.util.LinkedList;

/**
 * Created by fuquanlin on 2016/11/23.
 */
public class GraphScan {
    public static LinkedList vertexList;//存储点的链表
    public static int[][] edges;//邻接矩阵，用来存储边
    public static int numOfEdges;//边的数目
    public static boolean[] isVisited;

    //得到结点的个数
    public static int getNumOfVertex() {
        return vertexList.size();
    }

    //得到边的数目
    public static int getNumOfEdges() {
        return numOfEdges;
    }

    //返回结点i的数据
    public static Object getValueByIndex(int i) {
        return vertexList.get(i);
    }


    //插入结点
    public static void insertVertex(Object vertex) {
        vertexList.add(vertexList.size(),vertex);
    }

    //插入结点
    public static void insertEdge(int v1,int v2,int weight) {
        edges[v1][v2]=weight;
        numOfEdges++;
    }


    public static void main(String[] args) {
        int n=8,e=9;//分别代表结点个数和边的数目

        edges=new int[n][n];
        vertexList=new LinkedList();
        numOfEdges=e;

        String labels[]={"1","2","3","4","5","6","7","8"};//结点的标识
        for(String label:labels) {
            insertVertex(label);//插入结点
        }
        //插入九条边
        insertEdge(0, 1, 1);
        insertEdge(0, 2, 1);
        insertEdge(1, 3, 1);
        insertEdge(1, 4, 1);
        insertEdge(3, 7, 1);
        insertEdge(4, 7, 1);
        insertEdge(2, 5, 1);
        insertEdge(2, 6, 1);
        insertEdge(5, 6, 1);
        insertEdge(1, 0, 1);
        insertEdge(2, 0, 1);
        insertEdge(3, 1, 1);
        insertEdge(4, 1, 1);
        insertEdge(7, 3, 1);
        insertEdge(7, 4, 1);
        insertEdge(6, 2, 1);
        insertEdge(5, 2, 1);
        insertEdge(6, 5, 1);


        isVisited = new boolean[n];
        System.out.println("深度优先搜索序列为：");
        depthFirstSearch();
        System.out.println();
        isVisited = new boolean[n];
        System.out.println("广度优先搜索序列为：");
        broadFirstSearch();

    }



    //得到第一个邻接结点的下标
    public static int getFirstNeighbor(int index) {
        for(int j=0;j<vertexList.size();j++) {
            if (edges[index][j]>0) {
                return j;
            }
        }
        return -1;
    }

    //根据前一个邻接结点的下标来取得下一个邻接结点
    public static int getNextNeighbor(int v1,int v2) {
        for (int j=v2+1;j<vertexList.size();j++) {
            if (edges[v1][j]>0) {
                return j;
            }
        }
        return -1;
    }

    //私有函数，深度优先遍历
    private static void depthFirstSearch(boolean[] isVisited,int  i) {
        //首先访问该结点，在控制台打印出来
        System.out.print(getValueByIndex(i)+"  ");
        //置该结点为已访问
        isVisited[i]=true;

        int w=getFirstNeighbor(i);//
        while (w!=-1) {
            if (!isVisited[w]) {
                depthFirstSearch(isVisited,w);
            }
            w=getNextNeighbor(i, w);
        }
    }

    //对外公开函数，深度优先遍历，与其同名私有函数属于方法重载
    public static void depthFirstSearch() {
        for(int i=0;i<getNumOfVertex();i++) {
            //因为对于非连通图来说，并不是通过一个结点就一定可以遍历所有结点的。
            if (!isVisited[i]) {
                depthFirstSearch(isVisited,i);
            }
        }
    }

    //私有函数，广度优先遍历
    private static void broadFirstSearch(boolean[] isVisited,int i) {
        int u,w;
        LinkedList queue=new LinkedList();

        //访问结点i
        System.out.print(getValueByIndex(i)+"  ");
        isVisited[i]=true;
        //结点入队列
        queue.addLast(i);
        while (!queue.isEmpty()) {
            u=((Integer)queue.removeFirst()).intValue();
            w=getFirstNeighbor(u);
            while(w!=-1) {
                if(!isVisited[w]) {
                    //访问该结点
                    System.out.print(getValueByIndex(w)+"  ");
                    //标记已被访问
                    isVisited[w]=true;
                    //入队列
                    queue.addLast(w);
                }
                //寻找下一个邻接结点
                w=getNextNeighbor(u, w);
            }
        }
    }

    //对外公开函数，广度优先遍历
    public static void broadFirstSearch() {
        for(int i=0;i<getNumOfVertex();i++) {
            if(!isVisited[i]) {
                broadFirstSearch(isVisited, i);
            }
        }
    }
}
