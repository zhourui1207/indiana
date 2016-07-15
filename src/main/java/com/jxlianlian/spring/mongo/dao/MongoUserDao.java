package com.jxlianlian.spring.mongo.dao;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.jxlianlian.spring.mongo.model.MongoUser;
import com.jxlianlian.spring.mongo.util.Pagination;

@Repository("MongoUserDao")
public class MongoUserDao extends BaseDao<MongoUser> implements IMongoUserDao {

  public MongoUser findOneByLink(Integer link) {
    Query query = new Query(Criteria.where("numbers").is(link));

    return getMongoTemplate().findOne(query, MongoUser.class);
  }

  public MongoUser findNewestByState(Integer state) {
    Query query = createQuery(state);
    query.limit(1).with(new Sort(new Sort.Order(Sort.Direction.DESC, "createTime")));

    List<MongoUser> list = this.find(query);

    if (list.size() > 0) {
      return list.get(0);
    }

    return null;
  }

  public List<MongoUser> findListByPage(Pagination page, Integer state) {
    Query query = createQuery(state);
    query.with(page.getSort());
    query.skip(page.getSkip()).limit(page.getPageSize());// 从skip开始,取多少条记录

    return this.find(query);
  }

  public Long findCount(Integer state) {
    Query query = createQuery(state);
    return this.findCount(query);
  }

  private Query createQuery(Integer state) {
    Query query = new Query();
    query.addCriteria(Criteria.where("state").is(state));
    return query;
  }

  public MongoUser findOneByLinkOrTitle(String link, String title) {
    Query query = new Query(
        new Criteria().orOperator(Criteria.where("title").is(title), Criteria.where("link").is(link)));
    return getMongoTemplate().findOne(query, MongoUser.class);
  }

}
