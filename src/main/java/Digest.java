import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Digest {
    public static void main(String[] args) {
        try {
            String str = "Hello";
            StringBuilder sb = new StringBuilder();
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[]  bytes = md.digest(str.getBytes());
            for (byte data : bytes){
                sb.append(Integer.toString((data & 0xff) + 0x100, 16)).substring(1);
            }
            System.out.println("해싱된 문자열 : "+sb);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
