package com.itcat.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
//在企业，我们所有的entity都需要进行序列化！
//默认的序列化采用JDK序列化(implements Serializable)，我们通常需要自定义序列化方法
public class User implements Serializable {
    private String name;
    private Integer age;
}
