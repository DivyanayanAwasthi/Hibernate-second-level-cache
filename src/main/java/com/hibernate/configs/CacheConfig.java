package com.hibernate.configs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.config.CacheConfiguration;
import net.sf.ehcache.config.Configuration;


@Component
@EnableCaching
public class CacheConfig extends CachingConfigurerSupport {
	
	 private final Logger log = LoggerFactory.getLogger(CacheConfig.class);
	 
	 	@Bean
		public CacheManager ehCacheManager() {
			CacheConfiguration employess = new CacheConfiguration();
			employess.setName("employees");
			employess.setMemoryStoreEvictionPolicy("LRU");
			employess.setMaxEntriesLocalHeap(1000);
			employess.setTimeToLiveSeconds(10);

			Configuration config = new Configuration();
			config.addCache(employess);
			return net.sf.ehcache.CacheManager.newInstance(config);
		}

		@Bean
		public EhCacheCacheManager cacheManager() {
			return new EhCacheCacheManager(ehCacheManager());
		}

}
