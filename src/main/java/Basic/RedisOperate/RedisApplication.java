package Basic.RedisOperate;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RedisApplication {
    private static Jedis jedis;
    public static void SetUp(){
        jedis = new Jedis("121.42.158.62",6379);
        jedis.auth("123456");
    }

    public static void Close(){
        jedis.close();
    }

    public static void Ping(){
        System.out.println(jedis.ping());
    }

    public static void HelloWorld(){
        SetUp();
        Ping();
        Close();
    }

    public static String GetStrValue(String key){
        return jedis.get(key);
    }

    public static String SetValue(String key, String value){
        return jedis.set(key, value);
    }

    public static boolean isExists(String key){
        return jedis.exists(key);
    }

    public static Long RemoveKey(String... key){
        return jedis.del(key);
    }

    public static String HashSetValue(String key, Map<String, String> value){
        return jedis.hmset(key, value);
    }

    public static void main(String[] args){
        SetUp();
//        System.out.println(GetStrValue("foo"));
//        System.out.println(SetValue("Hello", "World"));
//        SetValue("love", "tolerant");
//        SetValue("peace", "love");
//        System.out.println(RemoveKey("foo","love"));
//        System.out.println(isExists("peace"));

//        Map<String, String> value = new HashMap<String, String>();
//        value.put("name","linweiyu");
//        value.put("school", "Northeastern University");
//        value.put("habbit", "Computer Games");
//        System.out.println(HashSetValue("Me", value));


        List<String> result = jedis.hvals("Me");
        Close();
    }


}
