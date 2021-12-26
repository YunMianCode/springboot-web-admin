package com.springboot.admin.common.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.Enumeration;

/**
 * 获取客户端真实IP
 *
 * @author zhangshichang
 * @date 19-7-2 下午4:58
 */
public class IpUtil {

    private static final Logger log = LoggerFactory.getLogger(IpUtil.class);

    /**
     * 获取客户端真实IP地址
     *
     * @param request 请求体
     * @return String
     * @author zhangshichang
     * @date 19-7-2 下午5:11
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Real-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip.equals("127.0.0.1") || ip.equals("0:0:0:0:0:0:0:1")) {
            String localIpAddress = getLocalIpAddress();
            if (StringUtils.isNotBlank(localIpAddress)) {
                ip = localIpAddress;
            }
        }
        // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        int indexOf = ip.indexOf(",");
        if (indexOf > 0) {
            ip = ip.substring(0, indexOf);
        }

        return ip;
    }

    public static String getLocalIpAddress() {
        try {
            Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();
            InetAddress ip;
            while (allNetInterfaces.hasMoreElements()) {
                NetworkInterface netInterface = allNetInterfaces.nextElement();
                if (!netInterface.isLoopback() && !netInterface.isVirtual() && netInterface.isUp()) {
                    Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
                    while (addresses.hasMoreElements()) {
                        ip = addresses.nextElement();
                        if (ip instanceof Inet4Address) {
                            return ip.getHostAddress();
                        }
                    }
                }
            }
        } catch (Exception e) {
            //e.printStackTrace();
            log.error("IP地址获取失败" + e.toString(), e);
            try {
                // 根据网卡取本机配置的IP linux时可能会获取到127.0.0.1
                return InetAddress.getLocalHost().getHostAddress();
            } catch (UnknownHostException e2) {
                log.error("IP地址获取失败" + e2.toString(), e2);
            }

        }
        return "";
    }

}
