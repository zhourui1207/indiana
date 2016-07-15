package com.jxlianlian.spring.test;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;

import com.jxlianlian.spring.mongo.dao.MongoUserDao;
import com.jxlianlian.spring.mongo.model.MongoUser;
import com.jxlianlian.spring.mybatis.model.User;
import com.jxlianlian.spring.service.UserService;
import com.jxlianlian.util.JsonUtil;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration(value = "src/main/webapp")
@ContextConfiguration(locations = { "classpath:applicationContext.xml", "classpath:applicationContext-mongo.xml" })
// 指定事务管理器 mongodb不支持回滚
@Transactional(transactionManager = "transactionManager")
public class MyTest extends AbstractTransactionalJUnit4SpringContextTests {
  // @Autowired
  Logger mLogger = Logger.getLogger(MyTest.class);

  @Autowired
  private MongoUserDao articleDao;

  @Autowired
  private UserService mUserService;

  @Test
  public void test() throws Exception {
    // String json = "{\"name\":113, \"id\":\"123477\", \"age\":36, \"time\":\""
    // + "1467614493000" + "\"}";
    // User user = JsonUtil.readValue(json, User.class);
    // mUserService.addUser(user);
    // List<User> userList = mUserService.queryUserlist();
    // for (int i = 0; i < userList.size(); ++i) {
    // mLogger.info(userList.get(i).toString());
    // }
    // MongoUser mongoUser = new MongoUser();
    // mongoUser.setName("zhouruiTest");
    // List<Integer> numbers = new ArrayList<>();
    // int index = 0;
    // numbers.add(index++, 100013);
    // numbers.add(index++, 100014);
    // numbers.add(index++, 100067);
    // numbers.add(index++, 103456);
    // numbers.add(index++, 107654);
    // numbers.add(index++, 108901);
    // mongoUser.setNumbers(numbers);
    // articleDao.insert(mongoUser);
    // List<MongoUser> user = articleDao.findList(0, 100);
    // for (int i = 0; i < user.size(); ++i) {
    // mLogger.error(user.get(i).toString());
    // }
    // MongoUser u = articleDao.findOneByLink(100067);
    // mLogger.error(u.toString());
    System.out.println("generateKey");
    Key key = MacProvider.generateKey();
    String encoded = new String(key.getEncoded(),"UTF-8");
    System.out
        .println("format=" + key.getFormat() + ", encoded=" + encoded + ", Algorithm=" + key.getAlgorithm());
    String compactJws = Jwts.builder().setSubject("Joe").signWith(SignatureAlgorithm.HS512, key).compact();
    System.out.println(compactJws);
  }
}
