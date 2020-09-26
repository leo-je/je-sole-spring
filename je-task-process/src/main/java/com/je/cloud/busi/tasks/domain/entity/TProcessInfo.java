package com.je.cloud.busi.tasks.domain.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class TProcessInfo implements Serializable {
    /**
     * <pre>
     * 
     * 表字段 : t_tasks_process_info.id
     * </pre>
     */
    @ApiModelProperty(example = "id", value = "")
    private String id;

    /**
     * <pre>
     * 
     * 表字段 : t_tasks_process_info.name
     * </pre>
     */
    @ApiModelProperty(example = "name", value = "")
    private String name;

    /**
     * <pre>
     * 
     * 表字段 : t_tasks_process_info.process_name
     * </pre>
     */
    @ApiModelProperty(example = "processName", value = "")
    private String processName;

    /**
     * <pre>
     * 
     * 表字段 : t_tasks_process_info.param
     * </pre>
     */
    @ApiModelProperty(example = "param", value = "")
    private String param;

    /**
     * <pre>
     * 
     * 表字段 : t_tasks_process_info.info
     * </pre>
     */
    @ApiModelProperty(example = "info", value = "")
    private String info;

    /**
     * <pre>
     * 
     * 表字段 : t_tasks_process_info.create_time
     * </pre>
     */
    @ApiModelProperty(example = "createTime", value = "")
    private Date createTime;

    /**
     * <pre>
     * 
     * 表字段 : t_tasks_process_info.update_time
     * </pre>
     */
    @ApiModelProperty(example = "updateTime", value = "")
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    /**
     * <pre>
     * 获取：
     * 表字段：t_tasks_process_info.id
     * </pre>
     *
     * @return t_tasks_process_info.id：
     */
    public String getId() {
        return id;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：t_tasks_process_info.id
     * </pre>
     *
     * @param id
     *            t_tasks_process_info.id：
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * <pre>
     * 获取：
     * 表字段：t_tasks_process_info.name
     * </pre>
     *
     * @return t_tasks_process_info.name：
     */
    public String getName() {
        return name;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：t_tasks_process_info.name
     * </pre>
     *
     * @param name
     *            t_tasks_process_info.name：
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * <pre>
     * 获取：
     * 表字段：t_tasks_process_info.process_name
     * </pre>
     *
     * @return t_tasks_process_info.process_name：
     */
    public String getProcessName() {
        return processName;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：t_tasks_process_info.process_name
     * </pre>
     *
     * @param processName
     *            t_tasks_process_info.process_name：
     */
    public void setProcessName(String processName) {
        this.processName = processName == null ? null : processName.trim();
    }

    /**
     * <pre>
     * 获取：
     * 表字段：t_tasks_process_info.param
     * </pre>
     *
     * @return t_tasks_process_info.param：
     */
    public String getParam() {
        return param;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：t_tasks_process_info.param
     * </pre>
     *
     * @param param
     *            t_tasks_process_info.param：
     */
    public void setParam(String param) {
        this.param = param == null ? null : param.trim();
    }

    /**
     * <pre>
     * 获取：
     * 表字段：t_tasks_process_info.info
     * </pre>
     *
     * @return t_tasks_process_info.info：
     */
    public String getInfo() {
        return info;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：t_tasks_process_info.info
     * </pre>
     *
     * @param info
     *            t_tasks_process_info.info：
     */
    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    /**
     * <pre>
     * 获取：
     * 表字段：t_tasks_process_info.create_time
     * </pre>
     *
     * @return t_tasks_process_info.create_time：
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：t_tasks_process_info.create_time
     * </pre>
     *
     * @param createTime
     *            t_tasks_process_info.create_time：
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * <pre>
     * 获取：
     * 表字段：t_tasks_process_info.update_time
     * </pre>
     *
     * @return t_tasks_process_info.update_time：
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：t_tasks_process_info.update_time
     * </pre>
     *
     * @param updateTime
     *            t_tasks_process_info.update_time：
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
        TProcessInfo other = (TProcessInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getProcessName() == null ? other.getProcessName() == null : this.getProcessName().equals(other.getProcessName()))
            && (this.getParam() == null ? other.getParam() == null : this.getParam().equals(other.getParam()))
            && (this.getInfo() == null ? other.getInfo() == null : this.getInfo().equals(other.getInfo()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
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
        result = prime * result + ((getProcessName() == null) ? 0 : getProcessName().hashCode());
        result = prime * result + ((getParam() == null) ? 0 : getParam().hashCode());
        result = prime * result + ((getInfo() == null) ? 0 : getInfo().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}