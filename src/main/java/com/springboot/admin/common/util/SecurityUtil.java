//package com.springboot.admin.common.util;
//
//import com.springboot.admin.model.User;
//import com.zyjc.canine.pojo.domain.UserInfo;
//import com.zyjc.canine.security.service.UserInfoDetails;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//
///**
// * SecurityUtils 工具类
// *
// * @author Guo
// */
//public class SecurityUtil {
//
//    public static User getUserInfo() {
//        UserInfoDetails userInfoDetails = getUserInfoDetails();
//        return userInfoDetails == null ? null : userInfoDetails.getUserInfo();
//    }
//
//    public static String getUsername() {
//        UserInfoDetails userInfoDetails = getUserInfoDetails();
//        return userInfoDetails == null ? null : userInfoDetails.getUsername();
//    }
//
//    public static String getUserFullName() {
//        UserInfoDetails userInfoDetails = getUserInfoDetails();
//        if (userInfoDetails != null && userInfoDetails.getUserInfo() != null) {
//            return userInfoDetails.getUserInfo().getFullName();
//        }
//        return null;
//    }
//
////    //浙里办,浙政钉登录后，所对应的后台管理账号用户名
////    public static Long getSysUserId() {
////        UserInfoDetails userInfoDetails = getUserInfoDetails();
////        return userInfoDetails == null ? null : userInfoDetails.getUserInfo().getSysUserId();
////    }
////    public static String getSysUserName() {
////        UserInfoDetails userInfoDetails = getUserInfoDetails();
////        return userInfoDetails == null ? null : userInfoDetails.getUserInfo().getSysUserName();
////    }
////
////    public static Long getUserId() {
////        UserInfoDetails userInfoDetails = getUserInfoDetails();
////        return userInfoDetails == null ? null : userInfoDetails.getUserInfo().getUserId();
////    }
////
////    public static Long getDepartId() {
////        UserInfoDetails userInfo = getUserInfoDetails();
////        return userInfo == null ? null : userInfo.getUserInfo().getDepartId();
////    }
////
////    public static Long getRoleId() {
////        UserInfoDetails userInfo = getUserInfoDetails();
////        return userInfo == null ? null : userInfo.getUserInfo().getRoleId();
////    }
//
//    /**
//     * 管理员为null
//     * @return 角色类型
//     */
//    public static String getRoleType() {
//        UserInfoDetails userInfo = getUserInfoDetails();
//        return userInfo == null ? null : userInfo.getUserInfo().getRoleType();
//    }
//
//    public static Long getVillageId() {
//        UserInfoDetails userInfo = getUserInfoDetails();
//        return userInfo == null ? null : userInfo.getUserInfo().getVillageId();
//    }
//
//    public static Long getOwnId() {
//        UserInfoDetails userInfo = getUserInfoDetails();
//        return userInfo == null ? null : userInfo.getUserInfo().getOwnId();
//    }
//
//    public static UserInfoDetails getUserInfoDetails() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication != null) {
//            Object principal = authentication.getPrincipal();
//            if (principal instanceof UserInfoDetails) {
//                return (UserInfoDetails) principal;
//            }
//        }
//        return null;
//    }
//
//}
