import java.io.*;
import java.lang.*;
import java.util.*;

public class Demoo{

        //selects the vertex which has the least weight edge of all unselected vertices.
 static int selectMinVertex(int[] value, boolean[] setMST){
  int minimum = Integer.MAX_VALUE;
  int vertex = 0;
  for(int i = 0; i < value.length; i++){
   if(setMST[i] == false && value[i] < minimum) {
    vertex = i;
    minimum = value[i];
   }
  }
  return vertex;
 }

        //Print the minimum spanning tree
 static void printMst(int[] parent, int[][] graph){
  System.out.println("Src.\tDest.\tWeight\n");
  String[] arr={"Nagpur" ,  "Mumbai" , "Hyderabad" , "Chennai" , "Kolkata" , "Lucknow" , "Jaipur" };

  //OTHER TEST CASES
  // String[] arr={"Nagpur" ,  "Pune" , "Hyderabad" , "Amritsar" , "Kolkata" , "Lucknow" , "Jaipur" };
  // String[] arr={"Nashik" ,  "Mumbai" , "Chandigarh" , "Chennai" , "Kolkata" , "Bhopal" , "Jaipur" };

  for(int i = 1; i < parent.length; i++){
   System.out.println(arr[i] + "\t\t" + "---->" + "\t\t" + arr[parent[i]] + "\t\t" + "---->" + "\t\t" + graph[i][parent[i]] + "\n");
  }
 }

 static void findMST(int graph[][]){
  int V = graph.length;
  int[] parent = new int[V];
  int[] value = new int[V];
  boolean[] setMST = new boolean[V];
  for(int i = 0; i < V; i++){
   value[i] = Integer.MAX_VALUE;
  }

  parent[0] = -1;
  value[0] = 0;

                //Iterate through all the vertices of the graph
  for(int i = 0; i < V-1; i++){

                      


    int U = selectMinVertex(value, setMST);
    setMST[U] = true;

                        /** 
                         Add newly added vertex as the parent of all the vertices 
                         it connects to except those that are already chosen. 
                         This would help us print the tree later.
                        */

   for(int j = 0; j < V; j++){
    if(graph[U][j] != 0 && setMST[j] == false && graph[U][j] < value[j]){
     value[j] = graph[U][j];
     parent[j] = U;
    }
   }
  }
  printMst(parent, graph);
 }


 public static void main(String[] args) {
                
            // This is the adjacency matrix representation of graph 
  
            int[][] graph = {
                {0, 836, 500, 1126, 1121, 773, 945},
                {836, 0, 710, 1342, 1939, 1379, 1155},
                {500, 710, 0, 626, 1482, 1277, 1447},
                {1126, 1342, 626, 0, 1662, 1900, 2070},
                {1121, 1939, 1482, 1662, 0, 1010, 1578},
                {773, 1379, 1277, 1900, 1010, 0, 571},
                         {945, 1155, 1447, 2070, 1578, 571, 0},

      // OTHER TEST CASES
    /* int[][] graph = {
   {0, 636, 500, 1500, 1121, 773, 945},
   {636, 0, 710, 1791, 1939, 1379, 1155},
   {500, 561, 0, 2000, 1482, 1277, 1447},
   {1500, 1142, 626, 0, 1662, 1900, 2070},
   {1121, 1739, 1482, 2008, 0, 1010, 1578},
   {773, 1179, 1277, 1001, 1010, 0, 571},
            {945, 955, 1447, 647, 1578, 571, 0},  
             */     
            
             
             /*  int[][] graph = {
                {0, 165, 1470, 1126, 1121, 611, 945},
                {165, 0, 1618, 1342, 1939, 776, 1155},
                {1470, 1618, 0, 626, 1482, 1036, 1447},
                {1378, 1342, 2452, 0, 1662, 1474, 2070},
                {1783, 1939, 1803, 1662, 0, 1429, 1578},
                {611, 1379, 1036, 1900, 1010, 0, 571},
                         {945, 1155, 1447, 2070, 1578, 571, 0}, */
  };
  findMST(graph);
 }
}
