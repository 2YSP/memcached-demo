package cn.sp;

import net.spy.memcached.MemcachedClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MemcachedDemoApplicationTests {

	@Autowired
	private MemcachedClient client;


	@Test
	public void contextLoads() {
		client.set("testKey",1000,"testValue");
		System.out.println("============testKey的值为:"+client.get("testKey"));
	}

}
