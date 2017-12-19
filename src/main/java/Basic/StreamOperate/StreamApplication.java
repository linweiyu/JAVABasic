package Basic.StreamOperate;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class StreamApplication {

    public static void Example() throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        char c;
        do {
            c = (char) (bufferedReader.read());
            System.out.println(c);
        }while (c != 'q');
    }


    public static void main(String[] args){
//        try{
//            Example();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
        File file = new File("parent");
        file.mkdir();
    }


}
