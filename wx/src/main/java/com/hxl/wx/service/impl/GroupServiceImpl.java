package com.hxl.wx.service.impl;

import com.hxl.wx.entity.WXAccessToken;
import com.hxl.wx.entity.user.Group;
import com.hxl.wx.entity.user.GroupListResult;
import com.hxl.wx.entity.user.GroupResult;
import com.hxl.wx.service.GroupService;
import com.hxl.wx.service.HttpsService;
import com.hxl.wx.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by hxl on 2016/12/5.
 */
@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private HttpsService httpsService;

    private String createUrl = "https://api.weixin.qq.com/cgi-bin/groups/create?access_token=%s";
    private String createJson = "{\"group\":{\"name\":\"%s\"}}";

    private String getUrl = "https://api.weixin.qq.com/cgi-bin/groups/download?access_token=%s";

    private String getIdUrl = "https://api.weixin.qq.com/cgi-bin/groups/getid?access_token=%s";
    private String getIdJson = "{\"openid\":\"%s\"}";

    private String updateUrl = "https://api.weixin.qq.com/cgi-bin/groups/update?access_token=%s";

    private String moveUrl = "https://api.weixin.qq.com/cgi-bin/groups/members/update?access_token=%s";
    private String moveJson = "{\"openid\":\"%s\",\"to_groupid\":%s}";

    private String moveBatchUrl = "https://api.weixin.qq.com/cgi-bin/groups/members/batchupdate?access_token=%s";
    private String moveBatchJson = "{\"openid_list\":%s,\"to_groupid\":%s}";

    private String deleteUrl = "https://api.weixin.qq.com/cgi-bin/groups/delete?access_token=%s";
    private String deleteJson = "{\"group\":{\"id\":%s}}";

    @Override
    public Group create(String name) {
        String result = httpsService.post(String.format(createUrl, WXAccessToken.ACCESS_TOKEN), String.format(createJson, name));
        return JsonUtils.toBean(result, GroupResult.class).getGroup();
    }

    @Override
    public List<Group> get() {
        String result = httpsService.get(String.format(getUrl, WXAccessToken.ACCESS_TOKEN));
        return JsonUtils.toBean(result, GroupListResult.class).getGroups();
    }

    @Override
    public String getId(String openId) {
        String result = httpsService.post(String.format(getIdUrl, WXAccessToken.ACCESS_TOKEN), String.format(getIdJson, openId));
        return (String)JsonUtils.toBean(result, HashMap.class).get("groupid");
    }

    @Override
    public void update(Group group) {
        GroupResult groupResult = new GroupResult();
        groupResult.setGroup(group);
        httpsService.post(String.format(updateUrl, WXAccessToken.ACCESS_TOKEN), JsonUtils.toString(groupResult));
    }

    @Override
    public void move(String openId, String toGroupId) {
        httpsService.post(String.format(moveUrl, WXAccessToken.ACCESS_TOKEN), String.format(moveJson, openId, toGroupId));
    }

    @Override
    public void moveBatch(List<String> openIdList, String toGroupId) {
        httpsService.post(String.format(moveBatchUrl, WXAccessToken.ACCESS_TOKEN), String.format(moveBatchJson, JsonUtils.toString(openIdList), toGroupId));
    }

    @Override
    public void delete(String id) {
        httpsService.post(String.format(deleteUrl, WXAccessToken.ACCESS_TOKEN), String.format(deleteJson, id));
    }
}
