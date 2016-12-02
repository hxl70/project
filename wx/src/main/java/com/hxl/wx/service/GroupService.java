package com.hxl.wx.service;

import com.hxl.wx.entity.Group;

import java.util.List;

/**
 * Created by hxl on 2016/12/1.
 * 用户分组管理
 */
public interface GroupService {

    /**
     * 创建分组
     * @param name 分组名字（30个字符以内）
     * @return
     */
    Group create(String name);

    /**
     * 查询所有分组
     * @return
     */
    List<Group> get();

    /**
     * 查询用户所在分组
     * @param openId 用户的OpenID
     * @return 用户所属的groupid
     */
    String getId(String openId);

    /**
     * 修改分组名
     * @param group
     */
    void update(Group group);

    /**
     * 移动用户分组
     * @param openId 用户唯一标识符
     * @param toGroupId 分组id
     */
    void move(String openId, String toGroupId);

    /**
     *
     * @param openIdList 用户唯一标识符openid的列表（size不能超过50）
     * @param toGroupId 分组id
     */
    void moveBatch(List<String> openIdList, String toGroupId);

    /**
     * 删除分组
     * @param id 分组的id
     */
    void delete(String id);

}
