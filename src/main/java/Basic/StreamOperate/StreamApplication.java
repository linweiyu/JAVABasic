package Basic.StreamOperate;


import java.io.*;
import java.util.Date;
import java.util.Scanner;

public class StreamApplication {

    public static void Example() throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        char c;
        do {
            c = (char) (bufferedReader.read());
            System.out.println(c);
        }while (c != 'q');
    }

    public static void StandardInput(){
        Scanner scanner = new Scanner(System.in);
        String input;
        do{
            input = scanner.nextLine();
            System.out.println(input);
        }while(!input.equalsIgnoreCase("end"));
    }

    public static void CommunicateBetweenThreads(){
        try{
            final PipedOutputStream outputStream = new PipedOutputStream();
            final PipedInputStream inputStream = new PipedInputStream(outputStream);

            Thread thread = new Thread(new Runnable() {
                public void run() {
                    try{
                        outputStream.write("Hello, It's from pip".getBytes());
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            });
            Thread thread1 = new Thread(new Runnable() {
                public void run() {
                    try{
                        while (inputStream.available() != 0){
                            System.out.print((char)inputStream.read());
                        }
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
            thread1.start();
        }catch (IOException io){
            io.printStackTrace();
        }
    }

    public static void main(String[] args){

//        try{
//            Example();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
        File file = new File("dir" + File.separator + "test.txt");
//        FileOperate.WriteToFile(file, "hello world", true);
//        FileOperate.PrintFileContentByLine(file);
        CommunicateBetweenThreads();

    }


}
