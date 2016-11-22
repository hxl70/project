package com.hxl.wx.filter;

import com.hxl.wx.entity.WXInfo;
import com.hxl.wx.utils.EncryptUtils;
import com.hxl.wx.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by hxl on 2016/11/22.
 */
public class WXFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(WXFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("WXFilter init");
    }

    /**
     * 加密/校验流程如下：
     * 1. 将token、timestamp、nonce三个参数进行字典序排序
     * 2. 将三个参数字符串拼接成一个字符串进行sha1加密
     * 3. 开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
     * 原样返回echostr参数内容，则接入生效，成为开发者成功，否则接入失败。
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.info("WXFilter doFilter");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String signature = request.getParameter("signature");
        if (StringUtils.isEmpty(timestamp) || StringUtils.isEmpty(nonce) || StringUtils.isEmpty(signature)) {
            logger.error("timestamp, nonce, signature can not be empty");
            throw new ServletException("timestamp, nonce, signature can not be empty");
        }
        String sort = sort(WXInfo.TOKEN, timestamp, nonce);
        if (EncryptUtils.sha1(sort).equals(signature)) {
            logger.info("check success");
        } else {
            logger.error("check error");
            throw new ServletException("illegal request");
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        logger.info("WXFilter destroy");
    }

    private String sort(String... array) {
        Arrays.sort(array);
        StringBuffer sb = new StringBuffer(200);
        Arrays.asList(array).stream().forEach(sb::append);
        return sb.toString();
    }

}