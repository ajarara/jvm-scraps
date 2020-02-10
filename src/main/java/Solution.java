import java.util.ArrayList;
import java.util.List;

public class Solution {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        if (strs == null) {
            return null;
        }
        if (strs.isEmpty()) {
            return "";
        }
        final StringBuilder out = new StringBuilder();
        strs.forEach(s -> {
            out.append(s.length());
            out.append("|");
            out.append(s);
        });
        return out.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) throws Exception {
        if (s == null) {
            return null;
        }
        if (s.isEmpty()) {
            return new ArrayList<>();
        }
        final List<String> out = new ArrayList<>();
        int start = 0;
        int sentinel = s.indexOf('|');
        while (sentinel != -1) {
            if (sentinel == s.length() - 1) {
                out.add("");
                break;
            }
            int numToRead = Integer.valueOf(s.substring(start, sentinel));
            out.add(s.substring(sentinel + 1, sentinel + 1 + numToRead));
            start = sentinel + 1 + numToRead;
            sentinel = s.indexOf('|', start);
        }
        return out;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));