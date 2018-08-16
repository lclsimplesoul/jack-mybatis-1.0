package cn.jack.mybatis;

import cn.jack.mybatis.Configuration.xmlMapperMapping;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * mapper代理类
 */
public class MapperProxy implements InvocationHandler {

    private Configuration configuration;

    private SimpleExecutor simpleExecutor = new SimpleExecutor();

    public MapperProxy(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getDeclaringClass().getName().equals(xmlMapperMapping.namespace)) {
            String sql = xmlMapperMapping.MethodSqlMapping.get(method.getName());
            return simpleExecutor.selectOne(sql, String.valueOf(args[0]));
        }

        return method.invoke(this, args);
    }
}
