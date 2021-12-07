package com.springboot.admin.common.util;

import com.springboot.admin.common.code.MD5;
import com.springboot.admin.common.constant.UpmsConstant;
import lombok.extern.slf4j.Slf4j;

import java.text.DecimalFormat;
import java.util.Locale;

/**
 * @ClassName CodeUtil
 * @Description
 * @Author yinzx
 * @Date 2019/10/30 10:55
 * @Version 1.0
 **/
@Slf4j
public class CodeUtil {

    /**
     * 获取应用code
     *
     * @param Constant
     * @return
     */
    public static String getProductCode(String Constant, String time, String code) {

        if (code != null) {
            // 截取后的编码
            String subCode = code.split("_")[1].substring(4);
            int intCode = Integer.parseInt(subCode);
            String newCode = Constant + time + new DecimalFormat("0000").format(intCode + 1);
            return newCode;
        } else {
            String newCode = Constant + time + "0001";
            return newCode;
        }
    }

    /**
     * 返回最新的层级编码
     *
     * @param code
     * @param maxCode
     * @return
     */
    public static String getNewCode(String code, String maxCode) {
        String newCode = "";
        /*
         * 兄弟节点不为空
         */
        if (null != maxCode) {
            // 最后三位的编码为在同一父节点下兄弟节点中的顺序
            String childrenCode = "";
            // 子节点前段编码为父节点的层级编码
            String parentCode = "";

            /*
             * 拆分获取最大兄弟节点编码的两部分
             */
            if (maxCode.length() > 3) {
                childrenCode = maxCode.substring(maxCode.length() - 3, maxCode.length());
                parentCode = maxCode.substring(0, maxCode.length() - 3);
            } else {
                childrenCode = maxCode;
                parentCode = "";
            }

            //生成新编码的后三位(在兄弟节点中的顺位)
            // 在原有最大编码上增加
            // 如果编码中的零丢失,则补齐三位
            String newChildrenCode = String.format("%03d", Integer.parseInt(childrenCode) + 1);
            // 拼接生成新的编码
            newCode = parentCode + newChildrenCode;
        }

        //兄弟节点为空则为该父节点下第一个节点
        else {
            newCode = code + "001";
        }
        return newCode;
    }


    /**
     * 用户密码校验(使用MD5)
     * <p>传入明文的密码,对密码进行验证,返回验证是否通过的布尔值
     *
     * @param pwd       明文密码
     * @param db_pwd    数据库中的密文密码
     * @param loginName 用户登录名，用于MD5加密的随机参数
     * @return 是否验证通过的布尔值
     */
    public static Boolean pwdAuth(String pwd, String db_pwd, String loginName) {

        String de_db_pwd = MD5.getMD5(UpmsConstant.PREFIX_MD5 + loginName + pwd);
        //
        Locale.setDefault(Locale.ENGLISH);
        //如果密码相等
        return de_db_pwd.equals(db_pwd);
    }

}
