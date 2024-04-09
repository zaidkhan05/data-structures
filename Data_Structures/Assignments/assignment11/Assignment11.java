import java.util.*;
interface Graph<V>{
    public int getSize();
    public java.util.List<V> getVertices();
    public V getVertex(int index);
    public int getIndex(V v);
    public java.util.List<Integer> getNeighbors(int index);
    public int getDegree(int v);
    public void printEdges();
    public void clear();
    public boolean addVertex(V vertex);
    public boolean addEdge(int u, int v);
    public AbstractGraph<V>.Tree dfs(int v);
    public AbstractGraph<V>.Tree bfs(int v);
}

abstract class AbstractGraph<V> implements Graph<V>{
    protected List<V> vertices = new ArrayList<>();
    protected List<List<Edge>> neighbors = new ArrayList<>();
    protected AbstractGraph(){

    }
    protected AbstractGraph(V[] vertices, int[][] edges){
        for(int i = 0; i < vertices.length; i++){
            addVertex(vertices[i]);
        }
        createAdjacencyLists(edges, vertices.length);
    }
    protected AbstractGraph(List<V> vertices, List<Edge> edges){
        for(int i = 0; i < vertices.size(); i++){
            addVertex(vertices.get(i));
        }
        createAdjacencyLists(edges, vertices.size());
    }
    protected AbstractGraph(List<Edge> edges, int numberOfVertices){
        for(int i = 0; i < numberOfVertices; i++){
            addVertex((V)(new Integer(i)));
        }
        createAdjacencyLists(edges, numberOfVertices);
    }
    protected AbstractGraph(int[][] edges, int numberOfVertices){
        for(int i = 0; i < numberOfVertices; i++){
            addVertex((V)(new Integer(i)));
        }
        createAdjacencyLists(edges, numberOfVertices);
    }
    private void createAdjacencyLists(int[][] edges, int numberOfVertices){
        for(int i = 0; i < edges.length; i++){
            addEdge(edges[i][0], edges[i][1]);
        }
    
    }
    private void createAdjacencyLists(List<Edge> edges, int numberOfVertices){
        for(Edge edge : edges){
            addEdge(edge.u, edge.v);
        }
    }

    @Override
    public int getSize(){
        return vertices.size();
    }
    @Override
    public List<V> getVertices(){
        return vertices;
    }
    @Override
    public V getVertex(int index){
        return vertices.get(index);
    }
    @Override
    public int getIndex(V v){
        return vertices.indexOf(v);
    }
    @Override
    public List<Integer> getNeighbors(int index){
        List<Integer> result = new ArrayList<>();
        for(Edge e : neighbors.get(index)){
            result.add(e.v);
        }
        return result;
    }
    @Override
    public int getDegree(int v){
        return neighbors.get(v).size();
    }
    @Override
    public void printEdges(){
        for(int u = 0; u < neighbors.size(); u++){
            System.out.print("Vertex " + u + ": ");
            for(Edge e : neighbors.get(u)){
                System.out.print("(" + u + ", " + e.v + ") ");
            }
            System.out.println();
        }
    }
    @Override
    public void clear(){
        vertices.clear();
        neighbors.clear();
    }
    @Override
    public boolean addVertex(V vertex){
        if(!vertices.contains(vertex)){
            vertices.add(vertex);
            neighbors.add(new ArrayList<Edge>());
            return true;
        }
        else{
            return false;
        }
    }
    protected boolean addEdge(Edge e){
        if(e.u < 0 || e.u > getSize() - 1){
            throw new IllegalArgumentException("No such index: " + e.u);
        }
        if(e.v < 0 || e.v > getSize() - 1){
            throw new IllegalArgumentException("No such index: " + e.v);
        }
        if(!neighbors.get(e.u).contains(e)){
            neighbors.get(e.u).add(e);
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean addEdge(int u, int v){
        return addEdge(new Edge(u, v));
    }
    
    public static class Edge{
        public int u;
        public int v;
        public Edge(int u, int v){
            this.u = u;
            this.v = v;
        }
        public boolean equals(Object o){
            return u == ((Edge)o).u && v == ((Edge)o).v;
        }
    }
    @Override
    public Tree dfs(int v){
        List<Integer> searchOrder = new ArrayList<>();
        int[] parent = new int[vertices.size()];
        for(int i = 0; i < parent.length; i++){
            parent[i] = -1;
        }
        boolean[] isVisited = new boolean[vertices.size()];
        dfs(v, parent, searchOrder, isVisited);
        return new Tree(v, parent, searchOrder);
    }
    private void dfs(int v, int[] parent, List<Integer> searchOrder, boolean[] isVisited){
        searchOrder.add(v);
        isVisited[v] = true;
        for(Edge e : neighbors.get(v)){
            if(!isVisited[e.v]){
                parent[e.v] = v;
                dfs(e.v, parent, searchOrder, isVisited);
            }
        }
    }
    @Override
    public Tree bfs(int v){
        List<Integer> searchOrder = new ArrayList<>();
        int[] parent = new int[vertices.size()];
        for(int i = 0; i < parent.length; i++){
            parent[i] = -1;
        }
        java.util.LinkedList<Integer> queue = new java.util.LinkedList<>();
        boolean[] isVisited = new boolean[vertices.size()];
        queue.offer(v);
        isVisited[v] = true;
        while(!queue.isEmpty()){
            int u = queue.poll();
            searchOrder.add(u);
            for(Edge e : neighbors.get(u)){
                if(!isVisited[e.v]){
                    queue.offer(e.v);
                    parent[e.v] = u;
                    isVisited[e.v] = true;
                }
            }
        }
        return new Tree(v, parent, searchOrder);
    }

    public class Tree{
        private int root;
        private int[] parent;
        private List<Integer> searchOrder;
        public Tree(int root, int[] parent, List<Integer> searchOrder){
            this.root = root;
            this.parent = parent;
            this.searchOrder = searchOrder;
        }
        public int getRoot(){
            return root;
        }
        public int getParent(int v){
            return parent[v];
        }
        public List<Integer> getSearchOrder(){
            return searchOrder;
        }
        public int getNumberOfVerticesFound(){
            return searchOrder.size();
        }
        public List<V> getPath(int index){
            ArrayList<V> path = new ArrayList<>();
            do{
                path.add(vertices.get(index));
                index = parent[index];
            }while(index != -1);
            return path;
        }
        public void printPath(int index){
            List<V> path = getPath(index);
            System.out.print("A path from " + vertices.get(root) + " to " + vertices.get(index) + ": ");
            for(int i = path.size() - 1; i >= 0; i--){
                System.out.print(path.get(i) + " ");
            }
        }
        public void printTree(){
            System.out.println("Root is: " + vertices.get(root));
            System.out.print("Edges: ");
            for(int i = 0; i < parent.length; i++){
                if(parent[i] != -1){
                    System.out.print("(" + vertices.get(parent[i]) + ", " + vertices.get(i) + ") ");
                }
            }
            System.out.println();
        }
    }
}

class UnweightedGraph<V> extends AbstractGraph<V>{
    public UnweightedGraph(){
    }
    public UnweightedGraph(V[] vertices, int[][] edges){
        super(vertices, edges);
    }
    public UnweightedGraph(List<V> vertices, List<Edge> edges){
        super(vertices, edges);
    }
    public UnweightedGraph(List<Edge> edges, int numberOfVertices){
        super(edges, numberOfVertices);
    }
    public UnweightedGraph(int[][] edges, int numberOfVertices){
        super(edges, numberOfVertices);
    }
}

class UnweightedGraphWithNonrecursiveDFS<V> extends UnweightedGraph<V>{
    public UnweightedGraphWithNonrecursiveDFS(){
    }
    public UnweightedGraphWithNonrecursiveDFS(V[] vertices, int[][] edges){
        super(vertices, edges);
    }
    public UnweightedGraphWithNonrecursiveDFS(List<V> vertices, List<Edge> edges){
        super(vertices, edges);
    }
    public UnweightedGraphWithNonrecursiveDFS(List<Edge> edges, int numberOfVertices){
        super(edges, numberOfVertices);
    }
    public UnweightedGraphWithNonrecursiveDFS(int[][] edges, int numberOfVertices){
        super(edges, numberOfVertices);
    }
    @Override
    public Tree dfs(int v){
        List<Integer> searchOrder = new ArrayList<>();
        int[] parent = new int[vertices.size()];
        for(int i = 0; i < parent.length; i++){
            parent[i] = -1;
        }
        boolean[] isVisited = new boolean[vertices.size()];
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        stack.push(v);
        while(!stack.isEmpty()){
            int u = stack.pop();
            if(!isVisited[u]){
                searchOrder.add(u);
                isVisited[u] = true;
                for(Edge e : neighbors.get(u)){
                    if(!isVisited[e.v]){
                        stack.push(e.v);
                        parent[e.v] = u;
                    }
                }
            }
        }
        return new Tree(v, parent, searchOrder);
    }
}


public class Assignment11 {
    //test dfs
    public static void main(String[] args){
        String[] vertices = {"Seattle", "San Francisco", "Los Angeles", "Denver", "Kansas City", "Chicago", "Boston", "New York", "Atlanta", "Miami", "Dallas", "Houston"};
        int[][] edges = {
            {0, 1}, {0, 3}, {0, 5},
            {1, 0}, {1, 2}, {1, 3},
            {2, 1}, {2, 3}, {2, 4}, {2, 10},
            {3, 0}, {3, 1}, {3, 2}, {3, 4}, {3, 5},
            {4, 2}, {4, 3}, {4, 5}, {4, 7}, {4, 8}, {4, 10},
            {5, 0}, {5, 3}, {5, 4}, {5, 6}, {5, 7},
            {6, 5}, {6, 7},
            {7, 4}, {7, 5}, {7, 6}, {7, 8},
            {8, 4}, {8, 7}, {8, 9}, {8, 10}, {8, 11},
            {9, 8}, {9, 11},
            {10, 2}, {10, 4}, {10, 8}, {10, 11},
            {11, 8}, {11, 9}, {11, 10}
        };
        Graph<String> graph = new UnweightedGraphWithNonrecursiveDFS<>(vertices, edges);
        AbstractGraph<String>.Tree dfs = graph.dfs(5);
        dfs.printTree();
        System.out.println("Search order: " + dfs.getSearchOrder());
        for(int i = 0; i < vertices.length; i++){
            System.out.print("Path for " + vertices[i] + ": ");
            dfs.printPath(i);
            System.out.println();
        }

    }
    
}
