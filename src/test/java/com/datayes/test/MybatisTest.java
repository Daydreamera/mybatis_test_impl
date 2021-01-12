package com.datayes.test;

import com.datayes.dao.UserDao;
import com.datayes.dao.impl.UserDaoImpl;
import com.datayes.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    public static void main(String[] args) throws IOException {
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SQLSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.使用工厂SQLSession对象
        UserDao userDao = new UserDaoImpl(factory);
        //4.使用代理对象执行方法
//        List<User> users = userDao.findAll();
//        for (User user : users) {
//            System.out.println(user);
//        }
        String userName = userDao.findName();
        System.out.println(userName);
        //6.释放资源
//        session.close();
        in.close();
    }
}
