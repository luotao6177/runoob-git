package com.note.Model;

/**
 * @author lt
 * @create 2020-05-12 23:58
 */
public class Gonggao {
    private Integer gonggaoId;//公告Id
    private String gonggaoTitle;//公告标题
    private String gonggaoTime;//公告发布时间
    private String gonggaoContent;//公告内容
    private String gonggaoAuthor;//公告发布人
    private String gonggaoStatus;//公告状态

    public Integer getGonggaoId() {
        return gonggaoId;
    }

    public void setGonggaoId(Integer gonggaoId) {
        this.gonggaoId = gonggaoId;
    }

    public String getGonggaoTitle() {
        return gonggaoTitle;
    }

    public void setGonggaoTitle(String gonggaoTitle) {
        this.gonggaoTitle = gonggaoTitle;
    }

    public String getGonggaoTime() {
        return gonggaoTime;
    }

    public void setGonggaoTime(String gonggaoTime) {
        this.gonggaoTime = gonggaoTime;
    }

    public String getGonggaoContent() {
        return gonggaoContent;
    }

    public void setGonggaoContent(String gonggaoContent) {
        this.gonggaoContent = gonggaoContent;
    }

    public String getGonggaoAuthor() {
        return gonggaoAuthor;
    }

    public void setGonggaoAuthor(String gonggaoAuthor) {
        this.gonggaoAuthor = gonggaoAuthor;
    }


    public String getGonggaoStatus() {
        return gonggaoStatus;
    }

    public void setGonggaoStatus(String gonggaoStatus) {
        this.gonggaoStatus = gonggaoStatus;
    }

}
