package Basic.Socket;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.UnknownHostException;

public class SocketDemo {
    public static void main(String[] args){
        try {
            //byte[] ip = {182,254,212,251};
            InetAddress address = InetAddress.getByName("www.soldo.com.cn");
            byte[] result = address.getAddress();
        }catch (UnknownHostException e){
            e.printStackTrace();
        }
    }
}
