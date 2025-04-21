package jino.week03;

public class J_25트리순회 {


    // The main method must be in a class named "Main".

        public static void main(String[] args) throws Exception {
            int [] node = new int []{1,2,3,4,5,6,7};
            System.out.println(preOrder(node , 0).trim());
            System.out.println(inOrder(node , 0).trim());
            System.out.println(postOrder(node , 0).trim());
        }
        private static String preOrder(int[] nodes , int index){
            if(index >= nodes.length){
                return "";
            }
            return nodes[index] +" "+
                    preOrder(nodes, (2 * index) +1)+
                    preOrder(nodes, (2 * index) +2);

        }
        private static String inOrder(int[] nodes , int index){
            if(index >= nodes.length){
                return "";
            }
            return inOrder(nodes, (2 * index) +1) +
                    nodes[index] +" "+
                    inOrder(nodes, (2 * index) +2);

        }
        private static String postOrder(int[] nodes , int index){
            if(index >= nodes.length){
                return "";
            }
            return postOrder(nodes, (2 * index) +2) +
                    postOrder(nodes, (2 * index) +1) +
                    nodes[index]+" ";
        }

}
