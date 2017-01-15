package ehcacheTest;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.cn.ssmtest.domain.User;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class EhcacheDemo {
	public static void main(String[] args) {
		 // Create a cache manager
        final CacheManager cacheManager = new CacheManager();

        // create the cache called "helloworld"
        final Cache cache = cacheManager.getCache("helloworld");
        Logger logger = Logger.getLogger(EhcacheDemo.class);
        // create a key to map the data to
        final String key = "greeting";

        User u=new User();
        u.setAge(10);
        u.setPassword("123456");
        u.setUserName("Young");
        
        // Create a data element
        final Element putGreeting = new Element(key, u);

        // Put the element into the data store
        cache.put(putGreeting);

        // Retrieve the data element
        final Element getGreeting = cache.get(key);
        logger.info(JSON.toJSONString(getGreeting.getObjectValue()));
        //cache.remove(key);
        //Element e = cache.get(key);
        //logger.info(JSON.toJSONString(e.getObjectValue()));
        // Print the value
        System.out.println(getGreeting.getObjectValue());
        //=======================================================================
        
     // 使用Ehcache默认配置获取单例的CacheManager实例
        /*CacheManager.create();
        String[] cacheNames = CacheManager.getInstance().getCacheNames();*/

        // 使用Ehcache默认配置新建一个CacheManager实例
        /*CacheManager manager = CacheManager.newInstance();
        String[] cacheNames = manager.getCacheNames();*/

        // 使用不同的配置文件分别创建一个CacheManager实例
        /*CacheManager manager1 = CacheManager.newInstance("src/config/ehcache1.xml");
        CacheManager manager2 = CacheManager.newInstance("src/config/ehcache2.xml");
        String[] cacheNamesForManager1 = manager1.getCacheNames();
        String[] cacheNamesForManager2 = manager2.getCacheNames();*/

        // 基于classpath下的配置文件创建CacheManager实例
        /*URL url = getClass().getResource("/anotherconfigurationname.xml");
        CacheManager manager = CacheManager.newInstance(url);*/

        // 基于文件流得到配置文件，并创建CacheManager实例
        /*InputStream fis = new FileInputStream(new File
        ("src/config/ehcache.xml").getAbsolutePath());
        try {
         CacheManager manager = CacheManager.newInstance(fis);
        } finally {
         fis.close();
        }*/
	}

}
