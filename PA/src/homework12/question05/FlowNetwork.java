package homework12.question05;

/**
 * Created by Bhanu on 26/04/2016.
 */
public class FlowNetwork{

    /**
     * The Src.
     */
    public int src, /**
     * The Sink.
     */
    sink, /**
     * The Num vertices.
     */
    numVertices;
    /**
     * The Capacities.
     */
    //edge capacities, edge flows, vertex neighbors
    public int[][] capacities, /**
     * The Flows.
     */
    flows, /**
     * The Neighb list.
     */
    neighbList;
    /**
     * The Excess.
     */
    public int[] excess, /**
     * The Height.
     */
    height;

    /**
     * Instantiates a new Flow network.
     *
     * @param n      the n
     * @param source the source
     * @param snk    the snk
     * @param caps   the caps
     */
/*
    * @param n an int representing the total number of vertices in this FlowNetwork
    * @param source an int identifying the unique source id
    * @param snk an int identifying the unique sink id
    * @param caps a 2-dimensional int array of edge capacities
    */
    public FlowNetwork(int n, int source, int snk, int[][] caps){
        numVertices = n;
        src = source;
        sink = snk;
        capacities = caps;
        flows = new int[n][n];
        excess = new int[n];
        height = new int[n];
        neighbList = buildNeighborList(n, caps);
    }
    private int[][] buildNeighborList(int n, int[][] caps){
        int[] numNeighbs = new int[n];//temp array
        int[][] tempNeighbList = new int[n][];//create jagged neighbor array from edge capacities
        //first count number of neighbors for each vertex
        for(int i=0;i<caps.length;i++){
            for(int j=0;j<caps[i].length;j++){
                if(caps[i][j] > 0){
                    numNeighbs[i]++;
                    numNeighbs[j]++;
                }
            }
        }
        //allocate capacities
        for(int i=0; i<numNeighbs.length;i++){
            tempNeighbList[i] = new int[numNeighbs[i]];
        }
        int[] counter = new int[n];//temp array
        //store neighbors of each vertex
        for(int i=0;i<caps.length;i++){
            for(int j=0;j<caps[i].length;j++){
                if(caps[i][j] > 0){
                    tempNeighbList[i][counter[i]] = j;
                    tempNeighbList[j][counter[j]] = i;
                    counter[i]++;
                    counter[j]++;
                }
            }
        }
        return tempNeighbList;
    }
}