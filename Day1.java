public class Day1 {
    static String str = "madam";
    public static void main(String[] args) {
        System.out.println(isPalindrome(str));
    }
    public static boolean isPalindrome(String str){
        String reversedStr = new StringBuilder(str).reverse().toString();
        return str.equals(reversedStr);
    }
}
