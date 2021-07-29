import java.util.Arrays;

class HashMapImplementation {

    String[][] map = new String[4][0];
    float loadFactor = .75f;
    int load = 0;

    HashMapImplementation() {}

    HashMapImplementation(int initialCapacity, float loadFactor){
        map = new String[initialCapacity][0];
    }

    public void put(String key, String value){

        int hash = 0;

        for(int i = 0; i < key.length(); i++){
            hash = hash + key.charAt(i) * 2069;
        }

        hash %= map.length - 1;

        if(map[hash].length == 0){
            load++;
        }

        map[hash] = new String[map[hash].length + 1];
        map[hash][map[hash].length - 1] = value;

        if(load >= map.length * loadFactor){
            String[][] newMap = new String[map.length * 2][0];

            for(int i = 0; i < map.length; i++){
                newMap[i] = map[i];
            }

            map = newMap;
        }
    }

    public String get(String key){

        int hash = 0;

        for(int i = 0; i < key.length(); i++){
            hash = hash + key.charAt(i) * 2069;
        }

        hash %= map.length - 1;

        String s = "";
            for(String str: map[hash]){
                s += str + " ";
            }

        return s;
    }

    @Override
    public String toString() {
        String s = "";
        for(String[] str: map){
            for(String ss: str){
                s += ss + " ";
            }
            s += "\n";
        }
        s += "load factor " + loadFactor + "size: " + map.length;
        return  s;
    }
}

public class HashMapFun {

    public static void main(String[] args){
        HashMapImplementation hashMapImplementation = new HashMapImplementation();
        hashMapImplementation.put("Apples", "Are Mine");
        hashMapImplementation.put("Oranges", "Are Yours");
        hashMapImplementation.put("turnips", "Are Nobodies");
        hashMapImplementation.put("carrots", "Are precious");
        System.out.println(hashMapImplementation);
        System.out.println(hashMapImplementation.get("Apples"));
    }

}
