package Basic.StreamOperate;

import java.io.*;
import java.util.Date;
import java.util.Scanner;

public class FileOperate {
    public static void test(){
        try{
            File file = new File("test.txt");
            boolean success = file.createNewFile();
            System.out.println(success);
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public static long GetFileLength(File file){
        return file.length();
    }

    public static Date GetFileLastModified(File file){
        return  new Date(file.lastModified());
    }

    public static void WriteToFile(File file, String content, boolean append){
        try {
            FileWriter writer = new FileWriter(file, append);
            writer.write(content);
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void PrintFileContentByBuf(File file){
        FileReader reader = null;
        try{
            reader = new FileReader(file);
            char[] buf = new char[1024];
            int len = 0;
            while((len = reader.read(buf)) != -1){
                System.out.print(new String(buf, 0 ,len));
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException ee){
            ee.printStackTrace();
        }finally {
            try{
                if(reader != null){
                    reader.close();
                }
            }catch (IOException closeException){
                closeException.printStackTrace();
            }
        }
    }

    public static void PrintFileContentByLine(File file){
        BufferedReader bufferedReader = null;
        try{
            bufferedReader = new BufferedReader(new FileReader(file));
            String content;
            while((content = bufferedReader.readLine()) != null){
                System.out.println(content);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException io){
            io.printStackTrace();
        }finally {
            try{
                bufferedReader.close();
            }catch (IOException close){
                close.printStackTrace();
            }
        }
    }

    public static void ChangeStream(File file){
    }




}
