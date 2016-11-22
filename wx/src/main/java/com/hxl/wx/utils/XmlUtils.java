package com.hxl.wx.utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.xml.transform.StringResult;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hxl on 2016/11/21.
 * xml工具类,使用Jaxb2Marshaller实现
 */
public class XmlUtils {

    private static Jaxb2Marshaller marshaller;

    static {
        marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan("com.hxl.wx.entity");
    }

    /**
     * 将RequestBody的XML转成Map
     * @param request HttpServletRequest
     * @return map
     */
    public static Map<String, String> parseRequestBody(HttpServletRequest request) {
        Map<String, String> map = new HashMap<>();
        try {
            request.setCharacterEncoding("utf-8");
            ServletInputStream inputStream = request.getInputStream();
            SAXReader reader = new SAXReader();
            Document document = reader.read(inputStream);
            Element root = document.getRootElement();
            List<Element> elements = root.elements();
            elements.parallelStream().forEach(element -> map.put(element.getName(), element.getText()));
            inputStream.close();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * 将实体转成XML
     * @param obj com.hxl.wx.entity.*
     * @return xml
     */
    public static String marshal(Object obj) {
        StringResult result = new StringResult();
        marshaller.marshal(obj, result);
        return result.toString();
    }

}
