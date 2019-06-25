package com.neusoft.ssm.util;

public class DBTool {

    //数据库转换星期
    public static String dbToWeek(String date) {
        if(date.equals("01"))
            return "星期一";
        else if(date.equals("02"))
            return "星期二";
        else if(date.equals("03"))
            return "星期三";
        else if(date.equals("04"))
            return "星期四";
        else if(date.equals("05"))
            return "星期五";
        else if(date.equals("06"))
            return "星期六";
        else if(date.equals("07"))
            return "星期日";
        else
            return "error";
    }

    //数据库转换号别
    public static String dbToRegister(String register) {
        if(register.equals("PT"))
            return "普通";
        else if(register.equals("ZM"))
            return "知名";
        else if(register.equals("JZH"))
            return "急诊";
        else if(register.equals("YY"))
            return "预约";
        else if(register.equals("TX"))
            return "特需";
        else if(register.equals("FG"))
            return "副高";
        else if(register.equals("ZG"))
            return "正高";
        else
            return "error";
    }

    //数据库转换午别
    public static String dbToNoon(String noon) {
        if(noon.equals("01"))
            return "全天";
        else if(noon.equals("02"))
            return "上午";
        else if(noon.equals("03"))
            return "下午";
        else if(noon.equals("04"))
            return "晚上";
        else
            return "error";
    }

    //数据库转换性别
    public static String dbToGender(String gender) {
        if(gender.equals("1"))
            return "男";
        else if(gender.equals("2"))
            return "女";
        else
            return "error";
    }

    //数据库转换医疗类别
    public static String dbToMedicalCategory(String category) {
        if(category.equals("01"))
            return "自付";
        else if(category.equals("02"))
            return "城镇职工";
        else if(category.equals("03"))
            return "城镇居民";
        else if(category.equals("04"))
            return "新农合";
        else
            return "error";
    }

    //数据库转换挂号来源
    public static String dbToRegisterSource(String source) {
        if(source.equals("01"))
            return "医院挂号";
        else if(source.equals("02"))
            return "预约挂号";
        else
            return "error";
    }

    //数据库转换挂号状态
    public static String dbToStatus(String status) {
        if(status.equals("01"))
            return "正常";
        else if(status.equals("02"))
            return "已退号";
        else if(status.equals("03"))
            return "无效";
        else
            return "error";
    }


    //数据库转换是否就诊
    public static String dbToSeen(String seen) {
        if(seen.equals("01"))
            return "否";
        else if(seen.equals("02"))
            return "是";
        else
            return "error";
    }

    //数据库转换支付方式
    public static String dbToPayCategory(String pay) {
        if(pay.equals("01"))
            return "现金";
        else if(pay.equals("02"))
            return "银行储蓄卡";
        else if(pay.equals("03"))
            return "银行信用卡";
        else if(pay.equals("04"))
            return "支付宝";
        else if(pay.equals("05"))
            return "微信支付";
        else if(pay.equals("06"))
            return "医保卡";
        else if(pay.equals("") || pay == null)
            return "未支付";
        else
            return "error";
    }

    //数据库转换付款标志
    public static String dbToPaySign(String pay) {
        if(pay.equals("0"))
            return "未付款";
        else if(pay.equals("1"))
            return "已付款";
        else if(pay.equals("2"))
            return "已退款";
        else if(pay.equals("3"))
            return "部分退款";
        else
            return "error";
    }

    //数据库转换日结状态
    public static String dbToDaySign(String day) {
        if(day.equals("0"))
            return "未日结";
        else if(day.equals("1"))
            return "已日结";
        else
            return "error";
    }

    //数据库转换是否已消费
    public static String dbToIsConsume(String is) {
        if(is.equals("0"))
            return "未消费";
        else if(is.equals("1"))
            return "已消费";
        else
            return "error";
    }

    //数据库转换财务核对状态
    public static String dbToCheck(String sign) {
        if(sign.equals("0"))
            return "未核对";
        else if(sign.equals("1"))
            return "已核对";
        else if(sign.equals("2"))
            return "异常";
        else
            return "error";
    }

}
