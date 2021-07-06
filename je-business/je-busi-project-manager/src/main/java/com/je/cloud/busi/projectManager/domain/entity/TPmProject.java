package com.je.cloud.busi.projectManager.domain.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;


/**
 * @date: 2021-01-18
 * TPmProject
 * 数据库表：t_pm_project
 */
public class TPmProject implements Serializable {
    /**
     * <pre>
     * id
     * 表字段 : t_pm_project.id
     * </pre>
     */
    @ApiModelProperty(example = "id", value = "id")
    private String id;

    /**
     * <pre>
     * 
     * 表字段 : t_pm_project.name
     * </pre>
     */
    @ApiModelProperty(example = "name", value = "")
    private String name;

    /**
     * <pre>
     * 
     * 表字段 : t_pm_project.info
     * </pre>
     */
    @ApiModelProperty(example = "info", value = "")
    private String info;

    /**
     * <pre>
     * 
     * 表字段 : t_pm_project.sort
     * </pre>
     */
    @ApiModelProperty(example = "sort", value = "")
    private Integer sort;

    private static final long serialVersionUID = 1L;

    /**
     * <pre>
     * 获取：id
     * 表字段：t_pm_project.id
     * </pre>
     *
     * @return t_pm_project.id：id
     */
    public String getId() {
        return id;
    }

    /**
     * <pre>
     * 设置：id
     * 表字段：t_pm_project.id
     * </pre>
     *
     * @param id
     *            t_pm_project.id：id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * <pre>
     * 获取：
     * 表字段：t_pm_project.name
     * </pre>
     *
     * @return t_pm_project.name：
     */
    public String getName() {
        return name;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：t_pm_project.name
     * </pre>
     *
     * @param name
     *            t_pm_project.name：
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * <pre>
     * 获取：
     * 表字段：t_pm_project.info
     * </pre>
     *
     * @return t_pm_project.info：
     */
    public String getInfo() {
        return info;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：t_pm_project.info
     * </pre>
     *
     * @param info
     *            t_pm_project.info：
     */
    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    /**
     * <pre>
     * 获取：
     * 表字段：t_pm_project.sort
     * </pre>
     *
     * @return t_pm_project.sort：
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：t_pm_project.sort
     * </pre>
     *
     * @param sort
     *            t_pm_project.sort：
     */
    public void setSort(Integer sort) {
        this.sort = sort;
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
        TPmProject other = (TPmProject) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getInfo() == null ? other.getInfo() == null : this.getInfo().equals(other.getInfo()))
            && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()));
    }

    /**
     *
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getInfo() == null) ? 0 : getInfo().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        return result;
    }
}