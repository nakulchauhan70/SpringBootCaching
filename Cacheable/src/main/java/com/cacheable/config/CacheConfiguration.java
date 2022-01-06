//package com.cacheable.config;//package com.cache.employee.config;
//
//import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
//import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.Arrays;
//
//@Configuration
//public class CacheConfiguration {
//
//    @Bean
//    CacheManagerCustomizer<ConcurrentMapCacheManager> customizer(){
//        return new ConcurrentCustomizer();
//    }
//
//    class ConcurrentCustomizer implements CacheManagerCustomizer<ConcurrentMapCacheManager>{
//
//        @Override
//        public void customize(ConcurrentMapCacheManager cacheManager) {
//            cacheManager.setAllowNullValues(false);
//            cacheManager.
//                //cacheManager.setStoreByValue(true);     //store value in serializable format, default is false
//            System.out.println("customizer invoked!!");
//        }
//    }
//}
