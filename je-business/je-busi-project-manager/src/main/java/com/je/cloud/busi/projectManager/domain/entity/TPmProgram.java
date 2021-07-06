package com.je.cloud.busi.projectManager.domain.entity;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;


/**
 * @date: 2021-01-19
 * TPmProgram
 * 数据库表：t_pm_program
 */
public class TPmProgram implements Serializable {
    /**
     * <pre>
     * id
     * 表字段 : t_pm_program.id
     * </pre>
     */
    @ApiModelProperty(example = "id", value = "id")
    private String id;

    /**
     * <pre>
     * 
     * 表字段 : t_pm_program.name
     * </pre>
     */
    @ApiModelProperty(example = "name", value = "")
    private String name;

    /**
     * <pre>
     * 
     * 表字段 : t_pm_program.project_Id
     * </pre>
     */
    @ApiModelProperty(example = "projectId", value = "")
    private String projectId;

    /**
     * <pre>
     * 
     * 表字段 : t_pm_program.project_name
     * </pre>
     */
    @ApiModelProperty(example = "projectName", value = "")
    private String projectName;

    /**
     * <pre>
     * 
     * 表字段 : t_pm_program.info
     * </pre>
     */
    @ApiModelProperty(example = "info", value = "")
    private String info;

    /**
     * <pre>
     * 
     * 表字段 : t_pm_program.sort
     * </pre>
     */
    @ApiModelProperty(example = "sort", value = "")
    private Integer sort;

    private static final long serialVersionUID = 1L;

    /**
     * <pre>
     * 获取：id
     * 表字段：t_pm_program.id
     * </pre>
     *
     * @return t_pm_program.id：id
     */
    public String getId() {
        return id;
    }

    /**
     * <pre>
     * 设置：id
     * 表字段：t_pm_program.id
     * </pre>
     *
     * @param id
     *            t_pm_program.id：id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * <pre>
     * 获取：
     * 表字段：t_pm_program.name
     * </pre>
     *
     * @return t_pm_program.name：
     */
    public String getName() {
        return name;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：t_pm_program.name
     * </pre>
     *
     * @param name
     *            t_pm_program.name：
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * <pre>
     * 获取：
     * 表字段：t_pm_program.project_Id
     * </pre>
     *
     * @return t_pm_program.project_Id：
     */
    public String getProjectId() {
        return projectId;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：t_pm_program.project_Id
     * </pre>
     *
     * @param projectId
     *            t_pm_program.project_Id：
     */
    public void setProjectId(String projectId) {
        this.projectId = projectId == null ? null : projectId.trim();
    }

    /**
     * <pre>
     * 获取：
     * 表字段：t_pm_program.project_name
     * </pre>
     *
     * @return t_pm_program.project_name：
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：t_pm_program.project_name
     * </pre>
     *
     * @param projectName
     *            t_pm_program.project_name：
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    /**
     * <pre>
     * 获取：
     * 表字段：t_pm_program.info
     * </pre>
     *
     * @return t_pm_program.info：
     */
    public String getInfo() {
        return info;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：t_pm_program.info
     * </pre>
     *
     * @param info
     *            t_pm_program.info：
     */
    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    /**
     * <pre>
     * 获取：
     * 表字段：t_pm_program.sort
     * </pre>
     *
     * @return t_pm_program.sort：
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：t_pm_program.sort
     * </pre>
     *
     * @param sort
     *            t_pm_program.sort：
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
        TPmProgram other = (TPmProgram) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getProjectId() == null ? other.getProjectId() == null : this.getProjectId().equals(other.getProjectId()))
            && (this.getProjectName() == null ? other.getProjectName() == null : this.getProjectName().equals(other.getProjectName()))
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
        result = prime * result + ((getProjectId() == null) ? 0 : getProjectId().hashCode());
        result = prime * result + ((getProjectName() == null) ? 0 : getProjectName().hashCode());
        result = prime * result + ((getInfo() == null) ? 0 : getInfo().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        return result;
    }
}