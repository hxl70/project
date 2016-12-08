package com.hxl.wx.enumerate;

/**
 * Created by hxl on 2016/12/7.
 */
public enum Industry {

    Industry1("IT科技", "互联网/电子商务", 1),
    Industry2("IT科技", "IT软件与服务", 2),
    Industry3("IT科技", "IT硬件与设备", 3),
    Industry4("IT科技", "电子技术", 4),
    Industry5("IT科技", "通信与运营商", 5),
    Industry6("IT科技", "网络游戏", 6),
    Industry7("金融业", "银行", 7),
    Industry8("金融业", "基金|理财|信托", 8),
    Industry9("金融业", "保险", 9),
    Industry10("餐饮", "餐饮", 10),
    Industry11("酒店旅游", "酒店", 11),
    Industry12("酒店旅游", "旅游", 12),
    Industry13("运输与仓储", "快递", 13),
    Industry14("运输与仓储", "物流", 14),
    Industry15("运输与仓储", "仓储", 15),
    Industry16("教育", "培训", 16),
    Industry17("教育", "院校", 17),
    Industry18("政府与公共事业", "学术科研", 18),
    Industry19("政府与公共事业", "交警", 19),
    Industry20("政府与公共事业", "博物馆", 20),
    Industry21("政府与公共事业", "公共事业|非盈利机构", 21),
    Industry22("医药护理", "医药医疗", 22),
    Industry23("医药护理", "护理美容", 23),
    Industry24("医药护理", "保健与卫生", 24),
    Industry25("交通工具", "汽车相关", 25),
    Industry26("交通工具", "摩托车相关", 26),
    Industry27("交通工具", "火车相关", 27),
    Industry28("交通工具", "飞机相关", 28),
    Industry29("房地产", "建筑", 29),
    Industry30("房地产", "物业", 30),
    Industry31("消费品", "消费品", 31),
    Industry32("商业服务", "法律", 32),
    Industry33("商业服务", "会展", 33),
    Industry34("商业服务", "中介服务", 34),
    Industry35("商业服务", "认证", 35),
    Industry36("商业服务", "审计", 36),
    Industry37("文体娱乐", "传媒", 37),
    Industry38("文体娱乐", "体育", 38),
    Industry39("文体娱乐", "娱乐休闲", 39),
    Industry40("印刷", "印刷", 40),
    Industry41("其它", "其它", 41)
    ;

    private String firstClass;
    private String secondClass;
    private Integer code;

    Industry(String firstClass, String secondClass, Integer code) {
        this.firstClass = firstClass;
        this.secondClass = secondClass;
        this.code = code;
    }

    public String getFirstClass() {
        return firstClass;
    }

    public void setFirstClass(String firstClass) {
        this.firstClass = firstClass;
    }

    public String getSecondClass() {
        return secondClass;
    }

    public void setSecondClass(String secondClass) {
        this.secondClass = secondClass;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
