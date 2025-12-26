import java.util.HashMap;
import java.util.Map;

public class EncodeAndDecodeTinyURL {
    Map<Integer,String> database = new HashMap<>();
    int idCounter = 1;

    String base62Chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private String encodeBase62(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(base62Chars.charAt(n % 62));
            n = n / 62;
        }
        return sb.reverse().toString();
    }

    private int decodeBase62(String shortUrl) {
        int id = 0;
        for (int i = 0; i < shortUrl.length(); i++) {
            int val = base62Chars.indexOf(shortUrl.charAt(i));
            id = id * 62 + val;
        }
        return id;
    }

    public String encode(String longUrl) {
        int id = idCounter++;
        database.put(id,longUrl);
        String code = encodeBase62(id);
        return "http://tinyurl.com/" + code;
    }

    public String decode(String shortUrl) {
        String code = shortUrl.replace("http://tinyurl.com/", "");
        int id = decodeBase62(code);
        return database.get(id);
    }
}

