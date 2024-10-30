public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama")); // true
        System.out.println(isPalindrome("race a car")); // false
        System.out.println(isPalindrome(" ")); // true
    }

    public static boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        
        StringBuilder cleaned = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                cleaned.append(c);
            }
        }
    
        String cleanedStr = cleaned.toString();
        String reversedStr = cleaned.reverse().toString();
    
        return cleanedStr.equalsIgnoreCase(reversedStr);
    }
}