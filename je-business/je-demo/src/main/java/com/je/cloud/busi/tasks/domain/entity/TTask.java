package com.je.cloud.busi.tasks.domain.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class TTask implements Serializable {
    /**
     * <pre>
     * 主键
     * 表字段 : t_tasks_task.id
     * </pre>
     */
    @ApiModelProperty(example = "id", value = "主键")
    private String id;

    /**
     * <pre>
     * 任务名称
     * 表字段 : t_tasks_task.name
     * </pre>
     */
    @ApiModelProperty(example = "name", value = "任务名称")
    private String name;

    /**
     * <pre>
     * 程序队列
     * 表字段 : t_tasks_task.process_list
     * </pre>
     */
    @ApiModelProperty(example = "processList", value = "程序队列")
    private String processList;

    /**
     * <pre>
     * 类型：1-即时任务 2-周期任务 3-定时任务
     * 表字段 : t_tasks_task.type
     * </pre>
     */
    @ApiModelProperty(example = "type", value = "类型：1-即时任务 2-周期任务 3-定时任务")
    private String type;

    /**
     * <pre>
     * 状态
     * 表字段 : t_tasks_task.status
     * </pre>
     */
    @ApiModelProperty(example = "status", value = "状态")
    private String status;

    /**
     * <pre>
     * 参数
     * 表字段 : t_tasks_task.param
     * </pre>
     */
    @ApiModelProperty(example = "param", value = "参数")
    private String param;

    /**
     * <pre>
     * 简介
     * 表字段 : t_tasks_task.info
     * </pre>
     */
    @ApiModelProperty(example = "info", value = "简介")
    private String info;

    /**
     * <pre>
     * 当前任务标号
     * 表字段 : t_tasks_task.current_task_order
     * </pre>
     */
    @ApiModelProperty(example = "currentTaskOrder", value = "当前任务标号")
    private Integer currentTaskOrder;

    /**
     * <pre>
     * 任务结束时间
     * 表字段 : t_tasks_task.end_time
     * </pre>
     */
    @ApiModelProperty(example = "endTime", value = "任务结束时间")
    private Date endTime;

    /**
     * <pre>
     * 任务开始时间
     * 表字段 : t_tasks_task.start_time
     * </pre>
     */
    @ApiModelProperty(example = "startTime", value = "任务开始时间")
    private Date startTime;

    /**
     * <pre>
     * 创建时间
     * 表字段 : t_tasks_task.create_time
     * </pre>
     */
    @ApiModelProperty(example = "createTime", value = "创建时间")
    private Date createTime;

    /**
     * <pre>
     * 更新时间
     * 表字段 : t_tasks_task.update_time
     * </pre>
     */
    @ApiModelProperty(example = "updateTime", value = "更新时间")
    private Date updateTime;

    /**
     * <pre>
     * 运行版本
     * 表字段 : t_tasks_task.run_version
     * </pre>
     */
    @ApiModelProperty(example = "runVersion", value = "运行版本")
    private String runVersion;

    private static final long serialVersionUID = 1L;

    /**
     * <pre>
     * 获取：主键
     * 表字段：t_tasks_task.id
     * </pre>
     *
     * @return t_tasks_task.id：主键
     */
    public String getId() {
        return id;
    }

    /**
     * <pre>
     * 设置：主键
     * 表字段：t_tasks_task.id
     * </pre>
     *
     * @param id
     *            t_tasks_task.id：主键
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * <pre>
     * 获取：任务名称
     * 表字段：t_tasks_task.name
     * </pre>
     *
     * @return t_tasks_task.name：任务名称
     */
    public String getName() {
        return name;
    }

    /**
     * <pre>
     * 设置：任务名称
     * 表字段：t_tasks_task.name
     * </pre>
     *
     * @param name
     *            t_tasks_task.name：任务名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * <pre>
     * 获取：程序队列
     * 表字段：t_tasks_task.process_list
     * </pre>
     *
     * @return t_tasks_task.process_list：程序队列
     */
    public String getProcessList() {
        return processList;
    }

    /**
     * <pre>
     * 设置：程序队列
     * 表字段：t_tasks_task.process_list
     * </pre>
     *
     * @param processList
     *            t_tasks_task.process_list：程序队列
     */
    public void setProcessList(String processList) {
        this.processList = processList == null ? null : processList.trim();
    }

    /**
     * <pre>
     * 获取：类型：1-即时任务 2-周期任务 3-定时任务
     * 表字段：t_tasks_task.type
     * </pre>
     *
     * @return t_tasks_task.type：类型：1-即时任务 2-周期任务 3-定时任务
     */
    public String getType() {
        return type;
    }

    /**
     * <pre>
     * 设置：类型：1-即时任务 2-周期任务 3-定时任务
     * 表字段：t_tasks_task.type
     * </pre>
     *
     * @param type
     *            t_tasks_task.type：类型：1-即时任务 2-周期任务 3-定时任务
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * <pre>
     * 获取：状态
     * 表字段：t_tasks_task.status
     * </pre>
     *
     * @return t_tasks_task.status：状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * <pre>
     * 设置：状态
     * 表字段：t_tasks_task.status
     * </pre>
     *
     * @param status
     *            t_tasks_task.status：状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * <pre>
     * 获取：参数
     * 表字段：t_tasks_task.param
     * </pre>
     *
     * @return t_tasks_task.param：参数
     */
    public String getParam() {
        return param;
    }

    /**
     * <pre>
     * 设置：参数
     * 表字段：t_tasks_task.param
     * </pre>
     *
     * @param param
     *            t_tasks_task.param：参数
     */
    public void setParam(String param) {
        this.param = param == null ? null : param.trim();
    }

    /**
     * <pre>
     * 获取：简介
     * 表字段：t_tasks_task.info
     * </pre>
     *
     * @return t_tasks_task.info：简介
     */
    public String getInfo() {
        return info;
    }

    /**
     * <pre>
     * 设置：简介
     * 表字段：t_tasks_task.info
     * </pre>
     *
     * @param info
     *            t_tasks_task.info：简介
     */
    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    /**
     * <pre>
     * 获取：当前任务标号
     * 表字段：t_tasks_task.current_task_order
     * </pre>
     *
     * @return t_tasks_task.current_task_order：当前任务标号
     */
    public Integer getCurrentTaskOrder() {
        return currentTaskOrder;
    }

    /**
     * <pre>
     * 设置：当前任务标号
     * 表字段：t_tasks_task.current_task_order
     * </pre>
     *
     * @param currentTaskOrder
     *            t_tasks_task.current_task_order：当前任务标号
     */
    public void setCurrentTaskOrder(Integer currentTaskOrder) {
        this.currentTaskOrder = currentTaskOrder;
    }

    /**
     * <pre>
     * 获取：任务结束时间
     * 表字段：t_tasks_task.end_time
     * </pre>
     *
     * @return t_tasks_task.end_time：任务结束时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * <pre>
     * 设置：任务结束时间
     * 表字段：t_tasks_task.end_time
     * </pre>
     *
     * @param endTime
     *            t_tasks_task.end_time：任务结束时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * <pre>
     * 获取：任务开始时间
     * 表字段：t_tasks_task.start_time
     * </pre>
     *
     * @return t_tasks_task.start_time：任务开始时间
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * <pre>
     * 设置：任务开始时间
     * 表字段：t_tasks_task.start_time
     * </pre>
     *
     * @param startTime
     *            t_tasks_task.start_time：任务开始时间
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * <pre>
     * 获取：创建时间
     * 表字段：t_tasks_task.create_time
     * </pre>
     *
     * @return t_tasks_task.create_time：创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * <pre>
     * 设置：创建时间
     * 表字段：t_tasks_task.create_time
     * </pre>
     *
     * @param createTime
     *            t_tasks_task.create_time：创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * <pre>
     * 获取：更新时间
     * 表字段：t_tasks_task.update_time
     * </pre>
     *
     * @return t_tasks_task.update_time：更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * <pre>
     * 设置：更新时间
     * 表字段：t_tasks_task.update_time
     * </pre>
     *
     * @param updateTime
     *            t_tasks_task.update_time：更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * <pre>
     * 获取：运行版本
     * 表字段：t_tasks_task.run_version
     * </pre>
     *
     * @return t_tasks_task.run_version：运行版本
     */
    public String getRunVersion() {
        return runVersion;
    }

    /**
     * <pre>
     * 设置：运行版本
     * 表字段：t_tasks_task.run_version
     * </pre>
     *
     * @param runVersion
     *            t_tasks_task.run_version：运行版本
     */
    public void setRunVersion(String runVersion) {
        this.runVersion = runVersion == null ? null : runVersion.trim();
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
        TTask other = (TTask) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getProcessList() == null ? other.getProcessList() == null : this.getProcessList().equals(other.getProcessList()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getParam() == null ? other.getParam() == null : this.getParam().equals(other.getParam()))
            && (this.getInfo() == null ? other.getInfo() == null : this.getInfo().equals(other.getInfo()))
            && (this.getCurrentTaskOrder() == null ? other.getCurrentTaskOrder() == null : this.getCurrentTaskOrder().equals(other.getCurrentTaskOrder()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getRunVersion() == null ? other.getRunVersion() == null : this.getRunVersion().equals(other.getRunVersion()));
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
        result = prime * result + ((getProcessList() == null) ? 0 : getProcessList().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getParam() == null) ? 0 : getParam().hashCode());
        result = prime * result + ((getInfo() == null) ? 0 : getInfo().hashCode());
        result = prime * result + ((getCurrentTaskOrder() == null) ? 0 : getCurrentTaskOrder().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getRunVersion() == null) ? 0 : getRunVersion().hashCode());
        return result;
    }
}