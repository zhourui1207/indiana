package com.jxlianlian.rest.api;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.jxlianlian.common.Const;
import com.jxlianlian.spring.mybatis.model.User;
import com.jxlianlian.spring.context.SpringContext;
import com.jxlianlian.spring.mongo.dao.MongoUserDao;
import com.jxlianlian.spring.mongo.model.MongoUser;
import com.jxlianlian.spring.service.UserService;
import com.jxlianlian.util.DateUtil;
import com.jxlianlian.util.JsonUtil;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

import javax.ws.rs.core.Response;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;

@Path("/" + Const.API_VERSION + "/users")
public class UsersApi {
  private Logger logger = Logger.getLogger(UsersApi.class);

  private MongoUserDao articleDao;

  private MongoUserDao getMongoUserDao() {
    if (articleDao == null) {
      articleDao = SpringContext.getBean("MongoUserDao");
    }
    return articleDao;
  }

  private UserService mUserService = null;

  private UserService getUserService() {
    if (mUserService == null) {
      mUserService = SpringContext.getBean("UserService");
    }
    return mUserService;
  }

  @GET
  @Path("/{id}")
  // @Produces("/users")
  public Response queryUserById(@PathParam("id") Long id) {
    
    String url = "http://gw.api.taobao.com/router/rest";
    String appkey = "23407772";
    String secret = "0fcc51e262c2710b82004f49876705d1";
    TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
    AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
    req.setExtend("123456");
    req.setSmsType("normal");
    req.setSmsFreeSignName("");
    req.setSmsParamString("{\"code\":\"1234\",\"product\":\"惊喜连连\"}");
    req.setRecNum("17006421542");
    req.setSmsTemplateCode("SMS_12400448");
    AlibabaAliqinFcSmsNumSendResponse rsp = null;
    try {
      rsp = client.execute(req);
    } catch (ApiException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
    System.out.println(rsp.getBody());
    
    UserService userService = SpringContext.getBean("UserService");

    
    
    int ret = 404;
    User user = null;

    try {
      user = userService.queryUserById(id);
    } catch (Exception e) {
      logger.error("", e);
    }

    if (user == null) {
      ret = 404;
    } else {
      ret = 200;
    }

    return Response.status(ret).entity(JsonUtil.toJSon(user)).build();
  }

  @GET
  @Path("/")
  public Response queryUserList() {
    logger.info("queryUserList");

    int ret = 404;
    List<User> userList = null;

    try {
      userList = getUserService().queryUserlist();
    } catch (Exception e) {
      logger.error("", e);
    }

    if (userList == null) {
      ret = 404;
    } else {
      ret = 200;
    }

    String json = "{\"name\":113, \"id\":\"12345\", \"age\":36, \"time\":\"" + "1467614493000" + "\"}";
    User user = JsonUtil.readValue(json, User.class);
    try {
      MongoUser article = new MongoUser();
      article.setName("zhourui123");
      getMongoUserDao().insert(article);
      List<MongoUser> aa = articleDao.findList(0, 100);
      for (int i = 0; i < aa.size(); ++i) {
        logger.error(aa.get(i).getId() + "; " + aa.get(i).getName());
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return Response.status(ret).entity(JsonUtil.toJSon(userList)).build();
  }

  @PUT
  @Path("/users/{isbn}")
  public void addBook(@PathParam("isbn") String id, @QueryParam("name") String name) {
    logger.info("addBook");
  }

  @DELETE
  @Path("/users/{id}")
  public void removeBook(@PathParam("id") String id) {
    logger.info("getAllUsers");
  }

}
