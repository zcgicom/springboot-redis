###SpringBoot整合Redis  
整合过程：  
1.导入redis依赖：  
    dependency>  
        <groupId>org.springframework.boot</groupId>  
        <artifactId>spring-boot-starter-data-redis</artifactId>  
    /dependency>   
2.配置连接：  
    #配置Redis  
    spring.redis.host=127.0.0.1  
    spring.redis.port=6379  
    #SpringBoot2.x版本推荐使用lettuce连接池  
3.测试！  
RedisUtils -- Redis自定义封装工具类  
config -- 配置项，用于自定义RedisTemplate，实现数据序列化,默认的序列化方式是JDK序列化(会是字符串转义)，但我们通常使用JSON进行序列化  