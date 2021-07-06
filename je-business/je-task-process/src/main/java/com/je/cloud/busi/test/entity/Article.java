package com.je.cloud.busi.test.entity;

import java.io.Serializable;
import java.util.Date;

public class Article implements Serializable {
    /**
     * <pre>
     * 
     * 表字段 : article.id
     * </pre>
     */
    private String id;

    /**
     * <pre>
     * 
     * 表字段 : article.title
     * </pre>
     */
    private String title;

    /**
     * <pre>
     * 
     * 表字段 : article.context
     * </pre>
     */
    private String context;

    /**
     * <pre>
     * 
     * 表字段 : article.category_id
     * </pre>
     */
    private String categoryId;

    /**
     * <pre>
     * 
     * 表字段 : article.create_date
     * </pre>
     */
    private Date createDate;

    /**
     * <pre>
     * 状态:1上线2下线3删除
     * 表字段 : article.status
     * </pre>
     */
    private String status;

    private static final long serialVersionUID = 1L;

    /**
     * <pre>
     * 获取：
     * 表字段：article.id
     * </pre>
     *
     * @return article.id：
     */
    public String getId() {
        return id;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：article.id
     * </pre>
     *
     * @param id
     *            article.id：
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * <pre>
     * 获取：
     * 表字段：article.title
     * </pre>
     *
     * @return article.title：
     */
    public String getTitle() {
        return title;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：article.title
     * </pre>
     *
     * @param title
     *            article.title：
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * <pre>
     * 获取：
     * 表字段：article.context
     * </pre>
     *
     * @return article.context：
     */
    public String getContext() {
        return context;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：article.context
     * </pre>
     *
     * @param context
     *            article.context：
     */
    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }

    /**
     * <pre>
     * 获取：
     * 表字段：article.category_id
     * </pre>
     *
     * @return article.category_id：
     */
    public String getCategoryId() {
        return categoryId;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：article.category_id
     * </pre>
     *
     * @param categoryId
     *            article.category_id：
     */
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId == null ? null : categoryId.trim();
    }

    /**
     * <pre>
     * 获取：
     * 表字段：article.create_date
     * </pre>
     *
     * @return article.create_date：
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：article.create_date
     * </pre>
     *
     * @param createDate
     *            article.create_date：
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * <pre>
     * 获取：状态:1上线2下线3删除
     * 表字段：article.status
     * </pre>
     *
     * @return article.status：状态:1上线2下线3删除
     */
    public String getStatus() {
        return status;
    }

    /**
     * <pre>
     * 设置：状态:1上线2下线3删除
     * 表字段：article.status
     * </pre>
     *
     * @param status
     *            article.status：状态:1上线2下线3删除
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     *
     * @param that
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Article other = (Article) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getContext() == null ? other.getContext() == null : this.getContext().equals(other.getContext()))
            && (this.getCategoryId() == null ? other.getCategoryId() == null : this.getCategoryId().equals(other.getCategoryId()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    /**
     *
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getContext() == null) ? 0 : getContext().hashCode());
        result = prime * result + ((getCategoryId() == null) ? 0 : getCategoryId().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }
}