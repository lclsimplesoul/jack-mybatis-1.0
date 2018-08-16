package cn.jack.mybatis;


/**
 * sqlsession核心功能类
 * 用于和配置管理与jdbc交互Executor交互
 */
public class SqlSession {

    /**
     * 解析配置文件功能类，在1.0版本中仅用内部类模拟实现
     */
    private Configuration configuration;

    /**
     * 用于与jdbc交互，实现操作数据库的基本功能
     */
    private Executor executor;


    public SqlSession(Configuration configuration, Executor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    public <T> T getMapper(Class<?> clazz) {
        return configuration.getMapper(clazz);
    }

    public <T> T selectOne(String statement,String parameter) {
        return executor.selectOne(statement, parameter);
    }


}
