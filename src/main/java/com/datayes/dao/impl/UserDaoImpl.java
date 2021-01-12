package com.datayes.dao.impl;

import com.datayes.dao.UserDao;
import com.datayes.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements UserDao {

    SqlSessionFactory factory;

    public UserDaoImpl(SqlSessionFactory factory) {
        this.factory = factory;
    }

    public List<User> findAll() {
        SqlSession session = factory.openSession();
        List<User> users = session.selectList("com.datayes.dao.UserDao.findAll");
        session.close();
        return users;
    }

    public String findName() {
        SqlSession session = factory.openSession();
        String userName = session.selectOne("com.datayes.dao.UserDao.findName");
        session.close();
        return userName;
    }
}
