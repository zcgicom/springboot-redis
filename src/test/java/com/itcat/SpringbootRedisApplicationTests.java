package com.itcat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.itcat.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class SpringbootRedisApplicationTests {

    @Autowired
//    private RedisTemplate redisTemplate;//原生redisTemplate
    private RedisTemplate<String, Object> redisTemplate;//自定义redisTemplate(redisConfig中)
    @Test
    void contextLoads() {
        //在企业中，80%的情况下都不会使用原生的方式编写代码！通常定义一个工具类(如RedisUtils)
        //RedisTemplate 操作不同的数据类型 api和我们的指令是相同的
        //opsForValue 操作字符串 类似于String
        //opsForList 操作List 类似List
        redisTemplate.opsForValue().set("mykey","top");
        System.out.println(redisTemplate.opsForValue().get("mykey"));
        //处理基本的操作，我们常用的方法可直接通过redistemplate操作，如事务和基本的crud

        //获取redis的连接对象，一般不经常用
//        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
//        connection.flushDb();
//        connection.flushAll();

    }

    @Test
    void test() throws JsonProcessingException {
        //真实开发都使用json传递对象
        User user = new User("john", 32);
        //jkson对象进行序列化,不进行序列化会不报Cannot Serialize错误
//        String jsonuser = new ObjectMapper().writeValueAsString(user);
        redisTemplate.opsForValue().set("user",user);
        System.out.println(redisTemplate.opsForValue().get("user"));
    }
}
