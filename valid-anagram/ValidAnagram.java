import java.util.Arrays;

public class ValidAnagram {
    public static void main(String [] args) {
        System.out.println(isAnagram("anagram", "nagaram")); // true
        System.out.println(isAnagram("car", "rat"));         // false
        System.out.println(isAnagram("./)$123a", "a123./)$")); // true
        System.out.println(isAnagramUnicodeSupport("a😊b", "b😊a")); // true
        System.out.println(isAnagramUnicodeSupport("こんにちは", "はこんにち")); // true
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        
        Arrays.sort(sChars);
        Arrays.sort(tChars);

        return Arrays.equals(sChars, tChars);
    }

    public static boolean isAnagramUnicodeSupport(String s, String t) {
        if (s.codePointCount(0, s.length()) != t.codePointCount(0, t.length())) {
            return false;
        }

        int[] sCodePoints = s.codePoints().sorted().toArray();
        int[] tCodePoints = t.codePoints().sorted().toArray();

        return Arrays.equals(sCodePoints, tCodePoints);
    }
}
