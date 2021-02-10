import java.util.Random;
import java.util.Scanner;

public class Lesson3_2 {

        public static void main(String[] args){
            String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
            String mainWord = makeWord(words);
            System.out.println("Слово загаданно: ###############");
            char[] mainArray = divideWord(mainWord);
            String userWord = "default";
            char[] common = new char[0];
            //System.out.println(mainWord);
            while (userWord!=mainWord){
                userWord = inputUserWord();
                char[] userArray = divideWord(userWord);
                common = compareWord(mainArray, userArray);
                System.out.println(common);
            }
        }
        public static String makeWord(String[] words)  {
            Random random = new Random();
            int i = random.nextInt(words.length+1);
            return words[i];
        }
        public static char[] divideWord(String word){
            char[] charArray = new char[word.length()];
            for (int i = 0; i < word.length(); i++){
                charArray[i] = word.charAt(i);
            }
            return charArray;
        }
        public static String inputUserWord(){
            Scanner input = new Scanner(System.in);
            System.out.print("Ввод предполагаемого слова: ");
            return input.next();
        }
        public static char[] compareWord(char[] mainArray, char[] userArray){
            int length;
            char[] common = new char[mainArray.length];
            if (mainArray.length<userArray.length) length = mainArray.length;
            else length = userArray.length;
            for (int i = 0; i < length; i++) {
                if (mainArray[i]==userArray[i])
                    common[i] = mainArray[i];
                }
            return common;
        }
        public static void showMainWord(char[] common){

        }

}
