package TaskIntern;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static String getDomain(String email) {
        int i = 0;
        for (; i < email.length(); i++) {
            if (email.charAt(i) == '@') {
                break;
            }
        }
        return email.substring(i + 1);
    }

    public static void sendmail(String email) {
        System.out.println(email);
    }

    public static void solution(String[] emails, int n) {
        Map<String, String> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String email = emails[i];
            String domain = getDomain(email);
            if (!mp.containsKey(domain)) {
                mp.put(domain, email);
            } else {
                String oldemail = mp.get(domain);
                if (oldemail.compareTo(email) > 0) {
                    mp.put(domain, email);
                }
            }
        }
        for (Map.Entry<String, String> entry : mp.entrySet()) {
            sendmail(entry.getValue());
        }
    }

    public static void main(String[] args) {
        String[] emails = {"ghi@hotmail.com", "def@yahoo.com", "ghi@gmail.com",
                "abc@channelier.com", "abc@hotmail.com", "def@hotmail.com", "abc@gmail.com", "abc@yahoo.com",
                "def@channelier.com", "jkl@hotmail.com", "ghi@yahoo.com", "def@gmail.com"};
        int n = emails.length;
        solution(emails, n);
    }
}