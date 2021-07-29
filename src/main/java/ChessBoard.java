import java.util.*;
import java.util.HashMap;

class Board {
    int size;
    int[] locationOfPiece = new int[2];
    int count = 0;

    Board(int size, int[] locationOfPiece){
        this.size = size;
        this.locationOfPiece = locationOfPiece;
    }

    public Board(int size) {
        this.size = size;
        setRandomPosition();
    }

     public int getSize() {
         return size;
     }

     public void setSize(int size) {
         this.size = size;
     }

     public int[] getLocationOfPiece() {
         return locationOfPiece;
     }

     public void setLocationOfPiece(int[] locationOfPiece) {
         this.locationOfPiece = locationOfPiece;
     }

     public void setRandomPosition(){
        Random random = new Random();
        locationOfPiece[0] = random.ints(0, size).findFirst().getAsInt();
        locationOfPiece[1] = random.ints(0, size).findFirst().getAsInt();
    }


}

class Bishop {

    int[] position = new int[2];
    Board board;
    HashMap<String, ArrayList<int[]>> graph = new HashMap<>();
    HashMap<String, Integer> distances = new HashMap<>();

    public Bishop(int[] position, Board board) {
        this.position = position;
        this.board = board;
    }

    public Bishop(Board board) {
        this.board = board;
        setRandomPosition();
    }

    public int[] getPosition() {
        return position;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setRandomPosition(){
        Random random = new Random();
        position[0] = random.ints(0, board.getSize()).findFirst().getAsInt();
        position[1] = random.ints(0, board.getSize()).findFirst().getAsInt();
    }

    public ArrayList<int[]> getMoveSet(int[] position){

        ArrayList<int[]> moveSet = new ArrayList<>();
        for(int i = 1; i < board.getSize(); i++){
            if(position[0] - i >= 0 && position[1] + i < board.getSize()){
                moveSet.add(new int[]{position[0] - i, position[1] + i});
            }
            if(position[0] + i < board.getSize() && position[1] + i < board.getSize()){
                moveSet.add(new int[]{position[0] + i, position[1] + i});
            }

            if(position[0] + i < board.getSize() && position[1] - i >= 0){
                moveSet.add(new int[]{position[0] + i, position[1] - i});
            }

            if(position[0] - i >= 0 && position[1] - i >= 0){
                moveSet.add(new int[]{position[0] - i, position[1] - i});
            }
        }

        return moveSet;
    }

    public void getGraph(){
        ArrayList<int[]> moveSet = getMoveSet(position);
        graph.put(position[0] + ", " + position[1], moveSet);

        for(int[] move: moveSet){
            getGraph(move);
        }
    }

    public void getGraph(int[] position){
        ArrayList<int[]> moveSet = getMoveSet(position);
        graph.put(position[0] + ", " + position[1], moveSet);

        for(int[] move: moveSet){
            if(Optional.ofNullable(graph.get(move[0] + ", " + move[1])).isPresent()){
                continue;
            }
            getGraph(move);
        }

    }

    public void printGraph(){

        for(String position : graph.keySet()){
            System.out.print(position + ": {");
            for(int[] move : graph.get(position)){
                System.out.print("[");
                System.out.print( move[0] + ", " + move[1]);
                System.out.print("]");
            }
            System.out.println("}");
        }
    }

    public void generateInitialDistanceMap(){
        for(String pos : graph.keySet()){
            if(!pos.equals(getPosition()[0] + ", " + getPosition()[1])){
                distances.put(pos, Integer.MAX_VALUE);
            } else {
                distances.put(pos, 0);
            }
        }

        System.out.println(distances.toString());
    }

    public void getAllDistances(){
        ArrayList<int[]> moveSet = getMoveSet(position);
        for(int[] move: moveSet){
                distances.put(move[0] + ", " + move[1], 1);
                getAllDistances(move, 1);
        }
    }

    public void getAllDistances(int[] move, int distance){
        ArrayList<int[]> moveSet = getMoveSet(move);

        for (int[] additionalMove: moveSet){
            if(distances.get(additionalMove[0] + ", " + additionalMove[1]) > distance + 1){
                distances.put(additionalMove[0] + ", " + additionalMove[1], distance + 1);
                getAllDistances(additionalMove, distance + 1);
            }
        }
    }

    public void printDistances(){

        for(String pos: distances.keySet()){
            System.out.println(pos + ": " + distances.get(pos));
        }
    }

    public String getMinimumMovesToPiece(){
        if(distances.keySet().contains(board.locationOfPiece[0] + ", " + board.locationOfPiece[1])){
            return String.valueOf(distances.get(board.locationOfPiece[0] + ", " + board.locationOfPiece[1]));
        }
        return "Not able to move there";
    }
}

public class ChessBoard {

    public static void main(String[] args){
        Board board = new Board(4);
        Bishop bishop = new Bishop(board);
        System.out.println(Arrays.toString(board.getLocationOfPiece()));
        System.out.println(Arrays.toString(bishop.getPosition()));
        bishop.getGraph();
        bishop.generateInitialDistanceMap();
        bishop.getAllDistances();
        bishop.printDistances();
        System.out.println(bishop.getMinimumMovesToPiece());
    }
}
