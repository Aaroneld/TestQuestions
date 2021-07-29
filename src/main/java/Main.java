import java.util.*;

public class Main {

    public static boolean isBalanced(String s){

        String lastHalf = s.substring(s.length() / 2 );
        int index = 0;

        if(s.length() % 2 != 0){
            return false;
        }

        ArrayDeque<Character> stringStack = new ArrayDeque<>();

        for(int i = 0; i < s.length() /2; i++){
            stringStack.offerFirst(s.charAt(i));
        }

        while(!stringStack.isEmpty()){
            char c = stringStack.pollFirst();
            switch (lastHalf.charAt(index)){
                case ')':
                    if(c != '('){
                        return false;
                    }
                    break;
                case '}':
                    if(c != '{'){
                        return false;
                    }
                    break;
                case ']':
                    if(c != '['){
                        return false;
                    }
                    break;
                default:
                    System.out.println("you shouldn't be here");
            }
            index++;
        }

        return true;
    }

    public static String revWords(String s){
        String[] stringArray = s.split(" ");
        String reversedWord = "";

        for(int i = stringArray.length - 1; i >= 0; i--){
            reversedWord += (stringArray[i] + " ");
        }

        return reversedWord;
    }

    public static boolean isPal(String s){
        String lastHalf = s.substring(s.length() / 2 );
        int index = 0;

        if(s.length() % 2 != 0){
            return false;
        }

        ArrayDeque<Character> stringStack = new ArrayDeque<>();

        for(int i = 0; i < s.length() /2; i++){
            stringStack.offerFirst(s.charAt(i));
        }

        while (!stringStack.isEmpty()){
            char c = stringStack.pollFirst();
            if(c != lastHalf.charAt(index)){
                return false;
            }
            index++;
        }

        return true;
    }

    public static HashMap<String, Integer> countLetters(String s){
        String[] strArr = s.split("");
        HashMap<String, Integer> letterCount = new HashMap<>();

        for(String str: strArr){
            if(letterCount.keySet().contains(str)){
                letterCount.put(str, letterCount.get(str) + 1);
            }else {
                letterCount.put(str, 1);
            }
        }

        return letterCount;
    }

    public static boolean isAnagram(String a, String b){
        ArrayList<String> stringList = new ArrayList<>(Arrays.asList(a.split("")));

        if(a.length() != b.length()){
            return false;
        }

        for(int i = 0; i < b.length(); i++){
            if(!stringList.contains(String.valueOf(b.charAt(i)))){
                System.out.println("inside loop");
                return false;
            }
            stringList.remove(stringList.indexOf(String.valueOf(b.charAt(i))));
        }

        return true;
    }

    public static String removeDup(String s){
        HashMap<Character, Boolean> existingLetters = new HashMap<>();
        String deDuppedString = "";

        for(int i = 0; i < s.length(); i++){
            if(!Optional.ofNullable(existingLetters.get(s.charAt(i))).isPresent()){
                deDuppedString += s.charAt(i);
                existingLetters.put(s.charAt(i), true);
            }
        }

        return deDuppedString;
    }

    public static ArrayList<String> reverseElements(String... stringArr){
        ArrayList<String> reversedList = new ArrayList<>();

        for(int i = stringArr.length - 1; i >= 0; i--){
            reversedList.add(stringArr[i]);
        }

        return reversedList;
    }

    public static int max(int... nums){
        int max = Integer.MIN_VALUE;

        for(int num: nums){
            if(num > max){
                max = num;
            }
        }

        return max;
    }

    public static int min(int... nums){
        int min = Integer.MAX_VALUE;

        for(int num: nums){
            if(num < min){
                min = num;
            }
        }

        return min;
    }

    public static void main(String[] args){
//        Balanced string	"- isBalanced(""[{()}]"") -> TRUE
//                - isBalanced(""[({(})]"") -> FALSE"
        String balancedString = "[{()}]";
        String unbalancedString = "[({(})]";

        System.out.println(isBalanced(balancedString));
        System.out.println(isBalanced(unbalancedString));

//        Reverse words	- revWords("Hello Infostretch") -> Infostretch Hello

        System.out.println(revWords("Hello Infostretch"));

//        Palindrome (String or number)	"- isPal(""anna"") -> true
//                - isPal(""Infostretch"") -> false
//                - isPalNum(1001) -> true
//                - isPalNum(13) -> false"

        System.out.println(isPal("Infostretch"));
        System.out.println(isPal("1001"));
        System.out.println(isPal("13"));

//  Count the occurrence of each character with help of map	- countLetters("abc") -> {{'a', 1}, {'b', 1}, {'c', 1}}

        System.out.println(countLetters("aaabbccxsd"));

//        Two string anagram	"- isAnagram(""abc"", ""bca"") -> true
//                - isAnagram(""abc"", ""ccb"") -> false"
        System.out.println(isAnagram("abc", "bca"));
        System.out.println(isAnagram("abc", "ccb"));

//        Remove duplicates char from a string	"- removeDup(""hello"")  -> ""helo""
//                - removeDup(""apple"")  -> ""aple"""

        System.out.println(removeDup("hello"));
        System.out.println(removeDup("apple"));


//Reverse elements	"- Input : 1, 2, 3, 4, 5
//- Output :5, 4, 3, 2, 1"

        System.out.println(reverseElements("1", "2", "3", "4", "5").toString());

//Max/min number from an array	"- max({4, 781, 8, 99, 103}) -> 781
//- min({1, 2, 3, 4, 5}) -> 1"

        System.out.println(max(4, 781, 8, 99, 103));
        System.out.println(min(1, 2, 3, 4, 5));


//Array that sum is equal to the given int	- sum({7, 7, 4, 3, 8}, 7)  -> {4, 3}


//Remove Duplicate elements  from ArrayList	"- Input: [2, 3, 5, 7, 7, 11]
//- Output: [2, 3, 5, 7, 11]"


//Sorting ArrayList


//Converting ArrayList to Set



//How to update a linked list ?


//How to get elements of a LinkedList?


//Explain the difference between file structure & storage structure.


//"How to separate digits of an int number? Print each digit on the new line.
//Given: 1234"	"Expected result:
//1
//2
//3
//4"

//Structure of JSON object?


//Write a class for parsing JSON in java.
    }
}
