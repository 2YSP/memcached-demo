package cn.sp;

import cn.sp.conf.MemcachedConfig;
import net.spy.memcached.MemcachedClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.net.InetSocketAddress;

@SpringBootApplication
public class MemcachedDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemcachedDemoApplication.class, args);
	}

	final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private MemcachedConfig memcachedConfig;

	@Bean(name = "memcachedClient")
	public MemcachedClient getMemcachedClient(){
		try {
			MemcachedClient client = new MemcachedClient(new InetSocketAddress(memcachedConfig.getIp(), memcachedConfig.getPort()));
			return client;
		} catch (IOException e) {
			logger.error("初始化MemcachedClient失败,{}",e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
}
