import java.io.*;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FileSame {
    public static void main(String[] args) {

        //파일 객체생성
        File android1 = new File("C:/Android_logo.png");
        File android2 = new File("C:/Android_logo2.png");
        String result;

        try {
            //SHA-256 다이제스트 객체
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            //파일로부터 스트림 읽기
            InputStream in1 = new FileInputStream(android1);
            InputStream in2 = new FileInputStream(android2);

            //해쉬변환된 문자열 담을 객체생성
            StringBuilder sb = new StringBuilder();


            //데이터를 담을 바이트배열
            byte[] imageByte1 = new byte[1024];
            byte[] imageByte2 = new byte[1024];

            //인풋스트림의 데이터를 바이트배열에 담음
            in1.read(imageByte1);
            in2.read(imageByte2);

            //이미지1 해쉬문자열 변환
            md.digest(imageByte1);
            for (byte data : imageByte1) {
                sb.append(Integer.toString((data & 0xff) + 0x100, 16));
            }
            result = sb.toString();
            System.out.println("해쉬변환된 문자열1 : " + result);

            sb.delete(0,sb.length());
            //이미지2 해쉬문자열 변환
            md.digest(imageByte2);
            for (byte data : imageByte2) {
                sb.append(Integer.toString((data & 0xff) + 0x100, 16));
            }

            //변환된 문자열 출력

            System.out.println("해쉬변환된 문자열2 : " + sb);

            //변환된 문자열이 같다면
            if (result.equals(sb.toString()))
                System.out.println("해쉬값 : 같음");
            else
                System.out.println("해쉬값 : 다름");


        } catch (NoSuchAlgorithmException | IOException e) {
            e.printStackTrace();
        }

        //파일의 크기
        long size1 = android1.length();
        long size2 = android2.length();

        //파일의 크기 출력
        System.out.println("파일1 사이즈 : " + size1);
        System.out.println("파일2 사이즈 : " + size2);

        if (size1 == size2)
            System.out.println("사이즈 : 같음");
        else
            System.out.println("사이즈 : 다름");
    }
}
