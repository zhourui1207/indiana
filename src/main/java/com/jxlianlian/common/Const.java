package com.jxlianlian.common;

public final class Const {
  // 是否是测试环境
  public static final boolean IS_TEST = true;
  
  // 每个人收货地址最大数量
  public static final int SHIPPING_ADDRESS_COUNT = 5;
  
  // Spring定时任务执行计划
  public static final String TASK_NEW_DAY_BEGIN = "0 0 0 * * ?";  // 每天00：00执行一次
  public static final String TASK_CLENR_SMS_VERITY_CODE = "0/10 * *  * * ? ";  // 每10秒执行一次
  
  // JWT秘钥
  public static final String SECRET_KEY_STRING = "jxlianlian.zhourui";
  
  // JWT header
  public static final String TOKEN_HEADER = "auth_token";
  
  // JWT参数
  public static final String JWT_ISS = "jxlianlian.com";
  public static final long JWT_WEB_EXP = 21600000L;  // web 过期时间6小时
  public static final long JWT_WEB_RECREATE_TIME = 3600000L;  // web 当过期时间与当前时间小于1小时，那么就重新生成Token
  public static final long JWT_PHONE_EXP = 172800000L;  // phone 过期时间48小时
  public static final long JWT_PHONE_RECREATE_TIME = 43200000L;  // phone 过期时间12小时
  
  // JWT解析后加入的当前用户ID和用户类型
  public static final String CURRENT_USER_ID = "currentUserId";
  public static final String CURRENT_USER_TYPE = "currentUserType";
  
  // 与客户端统一的参数名
  public static final String P_USER_ACCOUNT = "userAccount";
  public static final String P_USER_PASSWORD = "userPassword";
  // 注册
  public static final String P_JCAPTCHA = "jcaptcha";
  public static final String P_SMS_VERITY_CODE = "smsVerityCode";
  // 登录
  public static final String P_USER_TYPE = "userType";
  public static final String P_IS_PHONE = "isPhone"; 
  // 分页参数
  public static final String P_PAGE_NO = "pageNo";  // 当前页码
  public static final String P_PAGE_SIZE = "pageSize";  // 一页显示大小
  // 收货地址
  public static final String P_CONSIGNEE = "consignee";  // 收货人
  public static final String P_PHONE = "phone";  // 手机号
  public static final String P_AREA = "area";  // 区域 省、市、区
  public static final String P_ADDRESS = "address";  // 详细地址 街道、小区、门牌号
  public static final String P_POST_CODE = "postcode";  // 邮编 可不填
  
  // 用户注册方式
  public static final Byte WAY_PHONE = 0;
  public static final Byte WAY_WX = 1;
  public static final Byte WAY_QQ = 2;
  
  // 短信模块，调用阿里大鱼接口
  public static final String SMS_URL = "http://gw.api.taobao.com/router/rest";
  public static final String SMS_APP_KEY = "23407772";
  public static final String SMS_SECRET = "0fcc51e262c2710b82004f49876705d1";
  public static final String SMS_TYPE = "normal";
  public static final String SMS_SIGN_NAME = "惊喜连连";
  public static final String SMS_PRODUCT = "惊喜连连";
  public static final int SMS_VERIFY_TIME = 10;
  public static final String SMS_TEMPLATE_CODE_VERIFY = "SMS_12335361";
  public static final String SMS_TEMPLATE_CODE_NOTIFY = "SMS_12335355";
  
  // 阿里滑动验证码模块，条用阿里云接口
  public static final String ALIYUN_ACCESS_KEY_ID = "1";
  public static final String ALIYUN_ACCESS_KEY_SECRET = "2";
  public static final String ALIYUN_APP_KEY = "1";
  public static final String ALIYUN_APP_ACCESS_KEY = "2";
  public static final String ALIYUN_TOKEN = "token";
  public static final String ALIYUN_SESSIONID = "csessionid";
  public static final String ALIYUN_SIG = "sig";
  public static final String ALIYUN_SCENE = "scene";
  
  // REST API 版本
  public static final String API_VERSION = "/1/";
  
  // 默认查询普通记录页面大小
  public static final int PAG_SIZE_DEFAULE_WEB = 50;
  public static final int PAG_SIZE_DEFAULE_PHONE = 10;
  
  // 查询计算详情页面大小
  public static final int PAG_SIZE_QUERY_CALC_DETAIL = 53;
  
  // 计算开奖前多少条购买记录总和
  public static final int CALC_SHOPPING_RECORD_COUNT = 50;
  
  // 号码需要加的固定值
  public static final long ADD_NUMBER = 10000001L;
}
