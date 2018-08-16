package cn.jack.mybatis;

public interface Executor {
    <T> T selectOne(String statement, String parameter);
}
