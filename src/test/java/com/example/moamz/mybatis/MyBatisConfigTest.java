package com.example.moamz.mybatis;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class MyBatisConfigTest {
    //
    //  Mybatis 연결 테스트
    //

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Autowired
    private DataSource dataSource;

    MyBatisConfigTest() throws SQLException {}

    @Test
    public void dataSourceTest(){
        try {
            Connection connection = dataSource.getConnection();
            log.info("*****dataSoucre connection : " + connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void sqlSessionTest(){
        try {
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            Connection connection = sqlSession.getConnection();

            log.info("sqlSession Connection : " + connection);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}