public class MoreQuestions {


    public static String runLengthEncode(String s){

        int count = 1;
        char currentChar = s.charAt(0);
        String encodedString = "";

        for(int i = 1; i < s.length() ; i++){
            if(s.charAt(i) != currentChar){
                System.out.println("here " + i);
                encodedString += (String.valueOf(currentChar) + String.valueOf(count));
                count = 1;
                currentChar = s.charAt(i);
            }
            else {
                count++;
            }
        }

        encodedString += String.valueOf(currentChar) + String.valueOf(count);

        return encodedString;
    }

    public static void main(String[] args){
        System.out.println(runLengthEncode("aaacccwwaaddww"));
    }
}
