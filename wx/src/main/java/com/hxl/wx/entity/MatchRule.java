package com.hxl.wx.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by hxl on 2016/11/22.
 * 菜单匹配规则
 * matchrule共六个字段，均可为空，但不能全部为空，至少要有一个匹配信息是不为空的。
 */
public class MatchRule {

    /**
     * 用户分组id，可通过用户分组管理接口获取
     */
    @JsonProperty("group_id")
    private String groupId;
    /**
     * 性别：男（1）女（2），不填则不做匹配
     */
    private String sex;
    /**
     * 客户端版本，当前只具体到系统型号：IOS(1), Android(2),Others(3)，不填则不做匹配
     */
    @JsonProperty("client_platform_type")
    private String clientPlatformType;
    /**
     * 	国家信息，是用户在微信中设置的地区，具体请参考地区信息表
     */
    private String country;
    /**
     * 	省份信息，是用户在微信中设置的地区，具体请参考地区信息表
     */
    private String province;
    /**
     * 城市信息，是用户在微信中设置的地区，具体请参考地区信息表
     */
    private String city;
    /**
     * 语言信息，是用户在微信中设置的语言，具体请参考语言表：
     1、简体中文 "zh_CN"
     2、繁体中文TW "zh_TW"
     3、繁体中文HK "zh_HK"
     4、英文 "en"
     5、印尼 "id"
     6、马来 "ms"
     7、西班牙 "es"
     8、韩国 "ko"
     9、意大利 "it"
     10、日本 "ja"
     11、波兰 "pl"
     12、葡萄牙 "pt"
     13、俄国 "ru"
     14、泰文 "th"
     15、越南 "vi"
     16、阿拉伯语 "ar"
     17、北印度 "hi"
     18、希伯来 "he"
     19、土耳其 "tr"
     20、德语 "de"
     21、法语 "fr"
     */
    private String language;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getClientPlatformType() {
        return clientPlatformType;
    }

    public void setClientPlatformType(String clientPlatformType) {
        this.clientPlatformType = clientPlatformType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
