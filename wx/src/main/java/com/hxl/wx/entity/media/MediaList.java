package com.hxl.wx.entity.media;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hxl on 2016/12/6.
 */
public class MediaList {

    //该类型的素材的总数
    @JsonProperty("total_count")
    private Integer totalCount;
    //本次调用获取的素材的数量
    @JsonProperty("item_count")
    private Integer itemCount;
    //素材列表
    private List<MediaItem> item = new ArrayList<>();

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getItemCount() {
        return itemCount;
    }

    public void setItemCount(Integer itemCount) {
        this.itemCount = itemCount;
    }

    public List<MediaItem> getItem() {
        return item;
    }

    public void setItem(List<MediaItem> item) {
        this.item = item;
    }
}
