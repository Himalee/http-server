import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RequestHandler {
   public String read(InputStream inputStream) throws IOException {
       InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
       BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
       return bufferedReader.readLine();
   }
}
