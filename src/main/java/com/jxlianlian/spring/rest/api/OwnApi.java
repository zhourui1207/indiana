package com.jxlianlian.spring.rest.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;

import com.jxlianlian.common.Const;
import com.jxlianlian.spring.mybatis.model.MoneyDetail;
import com.jxlianlian.spring.mybatis.model.PointsDetail;
import com.jxlianlian.spring.mybatis.model.ShippingAddress;
import com.jxlianlian.spring.mybatis.model.User;
import com.jxlianlian.spring.rest.filter.Authorization;
import com.jxlianlian.spring.rest.message.ErrorInfo;
import com.jxlianlian.spring.rest.message.StatusCode;
import com.jxlianlian.spring.service.MoneyDetailService;
import com.jxlianlian.spring.service.PointsDetailService;
import com.jxlianlian.spring.service.ShippingAddressService;
import com.jxlianlian.spring.service.UserService;
import com.jxlianlian.util.JsonUtil;
import com.jxlianlian.util.RegexUtil;
import com.jxlianlian.util.ResponseUtil;

/**
 * 需要登录后才能调用的接口都通过这个 自己的一些信息，都通过该接口，从这个接口获取的信息都需要token来验证用户
 * 
 * @author zhourui
 *
 */

@Controller
@Path(Const.API_VERSION + "own")
@Produces(MediaType.APPLICATION_JSON)
@Authorization
public class OwnApi {
  private Logger logger = Logger.getLogger(OwnApi.class);

  @Autowired
  private UserService userService;

  @Autowired
  private MoneyDetailService moneyDetailService;

  @Autowired
  private PointsDetailService pointsDetailService;
  
  @Autowired
  private ShippingAddressService shippingAddressService;

  @Context
  private HttpServletRequest request;

  private long getCurrentUserId() {
    return (long) request.getAttribute(Const.CURRENT_USER_ID);
  }

  // 获取自己的用户信息
  @GET
  @Path("/userInfo")
  public Response getUserInfo() {
    long currentUserId = getCurrentUserId();
    if (currentUserId == 0) {
      return ResponseUtil.ResError(StatusCode.UNAUTHORIZED, ErrorInfo.NO_AUTHORIZED);
    }

    logger.info("getUserInfo(currentUserId=" + currentUserId + ")");

    User user = null;
    try {
      user = userService.queryUserByUserIdSelf(currentUserId);
    } catch (Exception e) {
      logger.error("查询用户失败，用户ID[" + currentUserId + "]", e);
      return ResponseUtil.ResError(StatusCode.INTERNAL_SERVER_ERROR, ErrorInfo.ACCESS_DB_FAILED);
    }

    if (user == null) {
      logger.info("用户不存在，用户ID[" + currentUserId + "]");
      return ResponseUtil.ResError(StatusCode.UNAUTHORIZED, ErrorInfo.USER_NO_EXISTED);
    }

    return ResponseUtil.ResGetOk(JsonUtil.toJSon(user));
  }

  // 获取账户明细 充值or消费
  @GET
  @Path("/moneyDetail")
  public Response getMoneyDetail(@QueryParam(Const.P_PAGE_NO) Integer pageNo,
      @QueryParam(Const.P_PAGE_SIZE) Integer pageSize) {
    long currentUserId = getCurrentUserId();
    if (currentUserId == 0) {
      return ResponseUtil.ResError(StatusCode.UNAUTHORIZED, ErrorInfo.NO_AUTHORIZED);
    }

    logger
        .info("getMoneyDetail(currentUserId=" + currentUserId + ", pageNo=" + pageNo + ", pageSize=" + pageSize + ")");

    List<MoneyDetail> moneyDetailList = null;
    try {
      moneyDetailList = moneyDetailService.queryMoneyDetailByPage(currentUserId, pageNo, pageSize);
    } catch (Exception e) {
      logger.error("查询用户账户明细失败，用户ID[" + currentUserId + "]", e);
      return ResponseUtil.ResError(StatusCode.INTERNAL_SERVER_ERROR, ErrorInfo.ACCESS_DB_FAILED);
    }

    return ResponseUtil.ResGetOk(JsonUtil.toJSon(moneyDetailList));
  }

  // 获取积分明细 积分是可以兑换余额的，也可以直接兑换余额使用，不想做红包，有满金限制，用户会觉得比较坑
  @GET
  @Path("/pointsDetail")
  public Response getPointsDetail(@QueryParam(Const.P_PAGE_NO) Integer pageNo,
      @QueryParam(Const.P_PAGE_SIZE) Integer pageSize) {
    long currentUserId = getCurrentUserId();
    if (currentUserId == 0) {
      return ResponseUtil.ResError(StatusCode.UNAUTHORIZED, ErrorInfo.NO_AUTHORIZED);
    }

    logger
        .info("getPointsDetail(currentUserId=" + currentUserId + ", pageNo=" + pageNo + ", pageSize=" + pageSize + ")");

    List<PointsDetail> pointsDetailList = null;
    try {
      pointsDetailList = pointsDetailService.queryPointsDetailByPage(currentUserId, pageNo, pageSize);
    } catch (Exception e) {
      logger.error("查询用户积分明细失败，用户ID[" + currentUserId + "]", e);
      return ResponseUtil.ResError(StatusCode.INTERNAL_SERVER_ERROR, ErrorInfo.ACCESS_DB_FAILED);
    }

    return ResponseUtil.ResGetOk(JsonUtil.toJSon(pointsDetailList));
  }

  // 增加收货地址 每个人有限制，最多五个地址
  @POST
  @Path("/shippingAddress")
  public Response addShippingAddress(@FormParam(Const.P_CONSIGNEE) String consignee,
      @FormParam(Const.P_PHONE) String phone, @FormParam(Const.P_AREA) String area,
      @FormParam(Const.P_ADDRESS) String address, @FormParam(Const.P_POST_CODE) String postcode) {

    long currentUserId = getCurrentUserId();
    if (currentUserId == 0) {
      return ResponseUtil.ResError(StatusCode.UNAUTHORIZED, ErrorInfo.NO_AUTHORIZED);
    }
    // 去除两边空格
    consignee = StringUtils.trimWhitespace(consignee);
    phone = StringUtils.trimWhitespace(phone);
    area = StringUtils.trimWhitespace(area);
    address = StringUtils.trimWhitespace(address);
    postcode = StringUtils.trimWhitespace(postcode);

    logger.info("addShippingAddress(currentUserId=" + currentUserId + ", consignee=" + consignee + ", phone=" + phone
        + ", area=" + area + ", address=" + address + ", postCode=" + postcode + ")");

    if (consignee == null || phone == null || area == null || address == null) {
      return ResponseUtil.ResError(StatusCode.INVALID_REQUEST, ErrorInfo.SUBMIT_INCORRECT);
    }
    
    // 增加前，先看看这个人有几个收货地址了
    int existCount = Const.SHIPPING_ADDRESS_COUNT;
    try {
      existCount = shippingAddressService.queryShippingAddressCountByUserId(currentUserId);
    } catch (Exception e) {
      logger.error("查询用户收货地址失败，用户ID[" + currentUserId + "]", e);
      return ResponseUtil.ResError(StatusCode.INTERNAL_SERVER_ERROR, ErrorInfo.ACCESS_DB_FAILED);
    }
    
    if (existCount >= Const.SHIPPING_ADDRESS_COUNT) {  // 收货数量已经达到上限
      return ResponseUtil.ResError(StatusCode.UNPROCESABLE_ENTITY, ErrorInfo.RECORD_NUMBER_TO_UPPER_LIMIT);
    }
    
    // 验证手机号
    if (!RegexUtil.isPhoneNo(phone)) { // 不是手机号码
      return ResponseUtil.ResError(StatusCode.INVALID_REQUEST, ErrorInfo.PHONE_INCORRECT);
    }
    
    ShippingAddress shippingAddress = new ShippingAddress();
    shippingAddress.initShippingAddress(currentUserId, consignee, phone, area, address, postcode);

    try {
      shippingAddressService.addShippingAddress(shippingAddress);
    } catch (Exception e) {
      logger.error("新增用户收货地址失败，用户ID[" + currentUserId + "]", e);
      return ResponseUtil.ResError(StatusCode.INTERNAL_SERVER_ERROR, ErrorInfo.ACCESS_DB_FAILED);
    }
    // 万一记录重复增加，这里是体现不了的
    
    return ResponseUtil.ResCreateOk(null);
  }

}
