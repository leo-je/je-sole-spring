package com.je.cloud.busi.projectManager.domain.entity;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;


/**
 * @date: 2021-01-20
 * TPmDemand
 * 数据库表：t_pm_demand
 */
public class TPmDemand implements Serializable {
    /**
     * <pre>
     * id
     * 表字段 : t_pm_demand.id
     * </pre>
     */
    @ApiModelProperty(example = "id", value = "id")
    private String id;

    /**
     * <pre>
     * 
     * 表字段 : t_pm_demand.name
     * </pre>
     */
    @ApiModelProperty(example = "name", value = "")
    private String name;

    /**
     * <pre>
     * 
     * 表字段 : t_pm_demand.project_Name
     * </pre>
     */
    @ApiModelProperty(example = "projectName", value = "")
    private String projectName;

    /**
     * <pre>
     * 
     * 表字段 : t_pm_demand.project_Id
     * </pre>
     */
    @ApiModelProperty(example = "projectId", value = "")
    private String projectId;

    /**
     * <pre>
     * 
     * 表字段 : t_pm_demand.scheduled_On_Line_Time
     * </pre>
     */
    @ApiModelProperty(example = "scheduledOnLineTime", value = "")
    private Date scheduledOnLineTime;

    /**
     * <pre>
     * 
     * 表字段 : t_pm_demand.scheduled_Finish_Time
     * </pre>
     */
    @ApiModelProperty(example = "scheduledFinishTime", value = "")
    private Date scheduledFinishTime;

    /**
     * <pre>
     * 
     * 表字段 : t_pm_demand.status
     * </pre>
     */
    @ApiModelProperty(example = "status", value = "")
    private String status;

    /**
     * <pre>
     * 
     * 表字段 : t_pm_demand.version
     * </pre>
     */
    @ApiModelProperty(example = "version", value = "")
    private String version;

    /**
     * <pre>
     * 
     * 表字段 : t_pm_demand.sort
     * </pre>
     */
    @ApiModelProperty(example = "sort", value = "")
    private Integer sort;

    /**
     * <pre>
     * 
     * 表字段 : t_pm_demand.programs
     * </pre>
     */
    @ApiModelProperty(example = "programs", value = "")
    private String programs;

    /**
     * <pre>
     * 
     * 表字段 : t_pm_demand.log
     * </pre>
     */
    @ApiModelProperty(example = "log", value = "")
    private String log;

    /**
     * <pre>
     * 
     * 表字段 : t_pm_demand.jira_code
     * </pre>
     */
    @ApiModelProperty(example = "jiraCode", value = "")
    private String jiraCode;

    /**
     * <pre>
     * 
     * 表字段 : t_pm_demand.info
     * </pre>
     */
    @ApiModelProperty(example = "info", value = "")
    private String info;

    private static final long serialVersionUID = 1L;

    /**
     * <pre>
     * 获取：id
     * 表字段：t_pm_demand.id
     * </pre>
     *
     * @return t_pm_demand.id：id
     */
    public String getId() {
        return id;
    }

    /**
     * <pre>
     * 设置：id
     * 表字段：t_pm_demand.id
     * </pre>
     *
     * @param id
     *            t_pm_demand.id：id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * <pre>
     * 获取：
     * 表字段：t_pm_demand.name
     * </pre>
     *
     * @return t_pm_demand.name：
     */
    public String getName() {
        return name;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：t_pm_demand.name
     * </pre>
     *
     * @param name
     *            t_pm_demand.name：
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * <pre>
     * 获取：
     * 表字段：t_pm_demand.project_Name
     * </pre>
     *
     * @return t_pm_demand.project_Name：
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：t_pm_demand.project_Name
     * </pre>
     *
     * @param projectName
     *            t_pm_demand.project_Name：
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }

    /**
     * <pre>
     * 获取：
     * 表字段：t_pm_demand.project_Id
     * </pre>
     *
     * @return t_pm_demand.project_Id：
     */
    public String getProjectId() {
        return projectId;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：t_pm_demand.project_Id
     * </pre>
     *
     * @param projectId
     *            t_pm_demand.project_Id：
     */
    public void setProjectId(String projectId) {
        this.projectId = projectId == null ? null : projectId.trim();
    }

    /**
     * <pre>
     * 获取：
     * 表字段：t_pm_demand.scheduled_On_Line_Time
     * </pre>
     *
     * @return t_pm_demand.scheduled_On_Line_Time：
     */
    public Date getScheduledOnLineTime() {
        return scheduledOnLineTime;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：t_pm_demand.scheduled_On_Line_Time
     * </pre>
     *
     * @param scheduledOnLineTime
     *            t_pm_demand.scheduled_On_Line_Time：
     */
    public void setScheduledOnLineTime(Date scheduledOnLineTime) {
        this.scheduledOnLineTime = scheduledOnLineTime;
    }

    /**
     * <pre>
     * 获取：
     * 表字段：t_pm_demand.scheduled_Finish_Time
     * </pre>
     *
     * @return t_pm_demand.scheduled_Finish_Time：
     */
    public Date getScheduledFinishTime() {
        return scheduledFinishTime;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：t_pm_demand.scheduled_Finish_Time
     * </pre>
     *
     * @param scheduledFinishTime
     *            t_pm_demand.scheduled_Finish_Time：
     */
    public void setScheduledFinishTime(Date scheduledFinishTime) {
        this.scheduledFinishTime = scheduledFinishTime;
    }

    /**
     * <pre>
     * 获取：
     * 表字段：t_pm_demand.status
     * </pre>
     *
     * @return t_pm_demand.status：
     */
    public String getStatus() {
        return status;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：t_pm_demand.status
     * </pre>
     *
     * @param status
     *            t_pm_demand.status：
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * <pre>
     * 获取：
     * 表字段：t_pm_demand.version
     * </pre>
     *
     * @return t_pm_demand.version：
     */
    public String getVersion() {
        return version;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：t_pm_demand.version
     * </pre>
     *
     * @param version
     *            t_pm_demand.version：
     */
    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    /**
     * <pre>
     * 获取：
     * 表字段：t_pm_demand.sort
     * </pre>
     *
     * @return t_pm_demand.sort：
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：t_pm_demand.sort
     * </pre>
     *
     * @param sort
     *            t_pm_demand.sort：
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * <pre>
     * 获取：
     * 表字段：t_pm_demand.programs
     * </pre>
     *
     * @return t_pm_demand.programs：
     */
    public String getPrograms() {
        return programs;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：t_pm_demand.programs
     * </pre>
     *
     * @param programs
     *            t_pm_demand.programs：
     */
    public void setPrograms(String programs) {
        this.programs = programs == null ? null : programs.trim();
    }

    /**
     * <pre>
     * 获取：
     * 表字段：t_pm_demand.log
     * </pre>
     *
     * @return t_pm_demand.log：
     */
    public String getLog() {
        return log;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：t_pm_demand.log
     * </pre>
     *
     * @param log
     *            t_pm_demand.log：
     */
    public void setLog(String log) {
        this.log = log == null ? null : log.trim();
    }

    /**
     * <pre>
     * 获取：
     * 表字段：t_pm_demand.jira_code
     * </pre>
     *
     * @return t_pm_demand.jira_code：
     */
    public String getJiraCode() {
        return jiraCode;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：t_pm_demand.jira_code
     * </pre>
     *
     * @param jiraCode
     *            t_pm_demand.jira_code：
     */
    public void setJiraCode(String jiraCode) {
        this.jiraCode = jiraCode == null ? null : jiraCode.trim();
    }

    /**
     * <pre>
     * 获取：
     * 表字段：t_pm_demand.info
     * </pre>
     *
     * @return t_pm_demand.info：
     */
    public String getInfo() {
        return info;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：t_pm_demand.info
     * </pre>
     *
     * @param info
     *            t_pm_demand.info：
     */
    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
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
        TPmDemand other = (TPmDemand) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getProjectName() == null ? other.getProjectName() == null : this.getProjectName().equals(other.getProjectName()))
            && (this.getProjectId() == null ? other.getProjectId() == null : this.getProjectId().equals(other.getProjectId()))
            && (this.getScheduledOnLineTime() == null ? other.getScheduledOnLineTime() == null : this.getScheduledOnLineTime().equals(other.getScheduledOnLineTime()))
            && (this.getScheduledFinishTime() == null ? other.getScheduledFinishTime() == null : this.getScheduledFinishTime().equals(other.getScheduledFinishTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()))
            && (this.getSort() == null ? other.getSort() == null : this.getSort().equals(other.getSort()))
            && (this.getPrograms() == null ? other.getPrograms() == null : this.getPrograms().equals(other.getPrograms()))
            && (this.getLog() == null ? other.getLog() == null : this.getLog().equals(other.getLog()))
            && (this.getJiraCode() == null ? other.getJiraCode() == null : this.getJiraCode().equals(other.getJiraCode()))
            && (this.getInfo() == null ? other.getInfo() == null : this.getInfo().equals(other.getInfo()));
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
        result = prime * result + ((getProjectName() == null) ? 0 : getProjectName().hashCode());
        result = prime * result + ((getProjectId() == null) ? 0 : getProjectId().hashCode());
        result = prime * result + ((getScheduledOnLineTime() == null) ? 0 : getScheduledOnLineTime().hashCode());
        result = prime * result + ((getScheduledFinishTime() == null) ? 0 : getScheduledFinishTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        result = prime * result + ((getSort() == null) ? 0 : getSort().hashCode());
        result = prime * result + ((getPrograms() == null) ? 0 : getPrograms().hashCode());
        result = prime * result + ((getLog() == null) ? 0 : getLog().hashCode());
        result = prime * result + ((getJiraCode() == null) ? 0 : getJiraCode().hashCode());
        result = prime * result + ((getInfo() == null) ? 0 : getInfo().hashCode());
        return result;
    }
}