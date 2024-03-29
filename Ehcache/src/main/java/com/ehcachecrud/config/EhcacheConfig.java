package com.ehcachecrud.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class EhcacheConfig {

    @Bean
    CacheManager cacheManager(){
        return new EhCacheCacheManager(ehCacheManager());
    }

    private net.sf.ehcache.CacheManager ehCacheManager() {
        EhCacheManagerFactoryBean factoryBean = new EhCacheManagerFactoryBean();    //used to create bean for ehcache or redis cache manager
        factoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
        factoryBean.setShared(true);
        return factoryBean.getObject();
    }

}
