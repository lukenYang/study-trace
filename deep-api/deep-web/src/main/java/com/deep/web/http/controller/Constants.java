package com.deep.web.http.controller;


public final class Constants {
	public static final String CODE_SUCCESS = "success";
	public static final String CODE_SYS_ERROR = "system.error";
	public static final String DRAW_TIMES_ERROR = "draw.times.error";
	
	public static final String CODE_CAPTCHA_EXPIRE="captcha.expired";
	public static final String CODE_CAPTCHA_FAILT="captcha.failt";
	public static final String CODE_CMS_SEND_ERROR = "cms.captcha.send.err";
	public static final String CODE_CMS_CAPTCHA_CONTENT = "cms.captcha.content";
	/** 缺少请求参数 **/
	public static final String CODE_REQUEST_MISS_PARAM = "request.missing.param";
    public static final String CODE_NOT_SUPPORTED_CHAR = "not.supported.char";
	public static final String CODE_INVALID_PHONE_NUMBER = "invalid.phoneNumber";
    public static final String CODE_NOT_BIND_PHONE_NUMBER = "not.bind.phoneNumber";
    public static final String CODE_INVALID_ACTION_TYPE  = "invalid.actionType";
	/** 无效的请求参数 **/
	public static final String CODE_REQUEST_INVALID_PARAM = "request.invalid.param";
	public static final String CODE_AUTHEN_ERROR = "authen.error";
	public static final String CODE_REDIRECT = "redirect";
	public static final String CODE_ACCOUNT_BINDING = "account.banding";
    public static final String CODE_PHONE_BINDING = "phone.banding";

    /** 访问太频繁 **/
    public static final String CODE_ACCESS_TOO_OFTEN = "access.too.often";

	public static final String CODE_EIDT_ACCOUNT = "account.edit";
	public static final String UNREGISTERED_ACCOUNT = "unregistered.account";
	public static final String ARGUMENTS_ERROR = "arguments.error";
	public static final String WITHDRAW_MONEY_LESS = "withdraw.money.less";

	public static final String DETAILS_STYLE_ERROR = "details.style.error";
	public static final String POINT_TYPE_ERROR = "point.type.error";
	public static final String USER_ERROR = "user.error";
    /** 用户别处登录被踢下线 **/
    public static final String USER_KICK_OUT = "user.kick.out";
    /** 刷分用户登录被踢下线 **/
    public static final String SF_KICK_OUT = "sf.kick.out";
    /** 刷分用户登录被踢下线for login **/
    public static final String SF_KICK_OUT_FOR_LOGIN = "sf.kick.out.for.login";
    /** 用户版本太低 **/
    public static final String VERSION_TOO_LOWER = "version.too.lower";
	public static final int DEFAULT_CAPTCHA_EXPIRES_SECOND = 60;
	public static final  String CMS_CAPTCHA_PREFIX = "CMS_CAPTCHA_";
	public static final String USER_NOT_EXIST = "user.not.exist";
	
	public static final String USER_INVALID_STATUS = "user.invalid.status";
	
	public static final String APPLIST_UPDATE_NONE = "no.data.updated";
	
	public static final String USER_NICKNAME_NOT_ASSIGN = "nickName.not.assign";
	public static final String USER_SEX_NOT_ASSIGN = "sex.not.assign";
	public static final String USER_NICKNAME_LENGTH_INVALID = "user.nickName.length.invalid";
    public static final String USER_NICKNAME_INVALID_CHARACTER = "user.nickName.invalid.character";
	
	public static final String USER_NICKNAME_EXIST = "user.nickName.exist";

    public static final String LOGIN_PASSWORD_NOT_MATCH = "password.not.match";

    public static final String PHONE_NUMBER_EXIST = "phone.number.exist";
    public static final String PHONE_NUMBER_NOT_EXIST = "phone.number.not.exist";

    public static final String USER_IMG_NOT_ASSIGN = "image.not.assign";

    public static final String USER_IMG_INVALID_FORMAT = "image.format.not.allow";

    public static final String USER_IMG_OVERSIZE = "image.oversize";

    public static final String USER_BANNED_COMMENT = "user.banned.comment";
    /**永久禁言消息KEY*/
    public static final String USER_BANNED_COMMENT_FOREVER = "user.banned.comment.forever";

    public static final String USER_BANNED_COMMENT_DEFAULT = "user.banned.comment.default";

    public static  final  String API_REQUEST_TIMESTAMP_VALIDATION_KEY_PREFIX = "api_request_timestamp_validation:";

    public static final String PASSWORD_REQUIRED = "password.required";
    
    public static final String LOGIN_FAIL_LIMIT = "login.fail.limit";

    public static final String USER_NOT_LOGIN = "user.not.login";
    
    public static final String ACCOUNT_ALREADY_BINDED = "account.already.binded";
    
    public static final String RECOMMEND_CODE_NOT_EXIST = "recommend.code.not.exist";
    public static final String RECOMMEND_CODE_NOT_SELF = "recommend.code.not.self";
    public static final String ACCOUNT_NOT_EXIST = "account.not.exist";
    public static final  String ACTIVITYID_NOT_EXIST = "activityid.not.exist";
    public static final  String USERID_NOT_EXIST = "uid.not.exist";
    public static final  String APPSTORE_NOT_EXIST = "appstore.not.exist";
    public static final  String DRAW_ACCOUNT_NOT_APPROVED = "draw.account.not.approved";//=这个应用商店的好评正在审核中，请选择其他应用商店吧~
    public static final  String DRAW_ACCOUNT_USED = "draw.account.used";//=你已在这个应用商店好评并获得抽奖机会了，请选择其他应用商店吧~
    public static final  String DRAW_RESULT_NOT_EXIST = "draw.result.not.exist";
    public static final  String OVER_COMMENT_FREQUENCY = "over.comment.frequency";

    public static final String HEADER_APP_KEY = "appKey";
    public static final String HEADER_DEVICE_ID = "deviceId";
    public static final String HEADER_DEVICE_NAME = "deviceName";
    public static final String APP_KEY_ANDROID = "1000001";
    public static final String APP_KEY_IOS = "1000002";
    
    public static final String CODE_SENSITIVE_NICKNAME = "user.nickName.sensitive";

    public static final  String PHONE_NOT_VERIFY = "phone.not.verify";
    
    public static final String VERIFY_FAIL_LIMIT = "verify.fail.limit";
    
    public static final String DUPLICATE_DEVICE = "duplicate.device";




    /**提现模块*/
    /**没有免费提现次数*/
    public static final String WITHDRAW_NO_FREE = "withdraw.free.error";
    public static final String WITHDRAW_PERSONAL_FREE = "withdraw.personal.free.error";
    /**提现余额不足*/
    public static final String WITHDRAW_INSUFFICIENT_BALANCE = "withdraw.balance.error";

    public static final String WITHDRAW_TIPS = "withdraw.tips";

    public static final String ACCOUNT_EXIST = "account.exist";
    
    /**无效的兑换商品记录*/
    public static final String CODE_INVALID_EXCHANGE_GOODS = "invalid.exchange.goods";
    
    /**无效的提现记录*/
    public static final String CODE_INVALID_WITHDRAW_RECORD = "invalid.withdraw.record";
    
    /**无效的商品*/
    public static final String CODE_INVALID_GOODS = "invalid.goods";

    //============================= version_1.5 add =======================================
    /** 暂无订阅相关订阅号信息 **/
    public static final String CODE_NO_SUB_MSG = "no.subscribe.msg";

    /** 指定订阅记录不存在 **/
    public static final String CODE_SUB_RECORD_NONEXISTENCE = "subscribe.record.nonexistence";
    /**支付账户包含非法字符*/
    public static final String PAY_ACCOUNT_INVALID_CHARACTER = "pay.account.invalid.character";
    /**支付姓名包含非法字符*/
    public static final String PAY_NAME_INVALID_CHARACTER = "pay.account.invalid.character";
    /**用户身份证绑定失败*/
    public static final String WITHDRAW_USER_BINGING_ERROR = "binding.error";

    public static final  String LIFESTYLE_KEYWORD_PREFIX = "lifestyle:keword:prefix:";

    public static final  String ALREADY_SIGN = "1";
    /**画像渠道标识*/
    public static final  String PERSONAS= "personas";

    /**订阅号下线 */
    public static final String ACCOUNT_STATUS_OFFLINE = "account.status.offline";

}