package com.jxlianlian.spring.mongo.dao;

import java.util.List;

import com.jxlianlian.spring.mongo.model.MongoUser;
import com.jxlianlian.spring.mongo.util.Pagination;

public interface IMongoUserDao extends IBaseDao<MongoUser> {
  /**
   * 根据link属性获取一条数据 @Title: findOneByLink @Description: TODO @param @param
   * link @param @return @return Article @throws
   */
  public MongoUser findOneByLink(Integer link);

  /**
   * 根据link属性与title属性进行或运算获取一条数据 @Title: findOneByLinkOrTitle @Description:
   * TODO @param @param link @param @param title @param @return @return
   * Article @throws
   */
  public MongoUser findOneByLinkOrTitle(String link, String title);

  /**
   * 根据state属性获取createTime为最新的数据 @Title: findNewestByState @Description:
   * TODO @param @param state @param @return @return Article @throws
   */
  public MongoUser findNewestByState(Integer state);

  /**
   * 根据state属性获取数据的数量 @Title: findNewestByState @Description: TODO @param @param
   * state @param @return @return Article @throws
   */
  public Long findCount(Integer state);

  /**
   * 分页获取数据 @Title: findListByPage @Description: TODO @param @param
   * page @param @param state @param @return @return List<Article> @throws
   */
  public List<MongoUser> findListByPage(Pagination page, Integer state);
}
