import java.util.HashMap;
import java.util.Map;

class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("(]"));
    }

    public static boolean isValid(String s) {
        Map<String, String> openCloseBracesMap = new HashMap<String, String>() {
            {
                put("{", "}");
                put("[", "]");
                put("(", ")");
            }
        };
        if (s.isEmpty() || s.length() % 2 != 0) {
            return false;
        }

        char[] psk = new char[s.length()];
        for (int i = s.length() - 1; i >= 0; --i) {
            char currElement = s.charAt(i);
            if (openCloseBracesMap.containsKey(String.valueOf(currElement))) {
                psk[i] = currElement;
                char closeBraces = openCloseBracesMap.get(String.valueOf(currElement)).charAt(0);
                for (int j = i + 1; j < s.length(); ++j) {
                    if(psk[j] == '\u0000') {
                        psk[j] = closeBraces;
                        break;
                    }
                }
            }
        }
        return String.valueOf(psk).equals(s) ? true : false;
    }
}