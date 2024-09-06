import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArray = br.readLine().trim().split(" ");
        
        if(strArray.length == 1 && strArray[0].isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(strArray.length);
        }
    }
}