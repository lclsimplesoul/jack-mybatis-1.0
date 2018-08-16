package cn.jack.mybatis;

import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Configuration {


    public <T> T getMapper(Class<?> clazz) {
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(),
                clazz.getInterfaces(),
                new MapperProxy(this));
    }

    static class xmlMapperMapping {

        public static final String namespace = "cn.jack.mybatis.mapper.TestMapper";

        public static final Map<String, String> MethodSqlMapping = new ConcurrentHashMap<>();

        static {

            MethodSqlMapping.put("selectUserNameByUserId", "SELECT NAME FROM TEST WHERE USERID = %d");

        }
    }

}
