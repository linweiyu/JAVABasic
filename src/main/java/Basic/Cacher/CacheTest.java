package Basic.Cacher;

public class CacheTest {
    public static void main(String[] args){
        MemoryCache memoryCache = new MemoryCache(3);
        Element element1 = new Element("hello", "world");
        Element element2 = new Element("hello2", "world");
        Element element3 = new Element("hello3", "world");
        Element element4 = new Element("hello4", "world");

        memoryCache.put(element1);
        memoryCache.put(element2);
        memoryCache.put(element3);
        System.out.println(memoryCache.get("hello3").getValue());
        memoryCache.put(element4);
    }
}
