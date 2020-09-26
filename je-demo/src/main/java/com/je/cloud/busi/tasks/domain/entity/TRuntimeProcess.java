package com.je.cloud.busi.tasks.domain.entity;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class TRuntimeProcess implements Serializable {
    /**
     * <pre>
     * 
     * 表字段 : t_tasks_runtime_process.id
     * </pre>
     */
    @ApiModelProperty(example = "id", value = "")
    private String id;

    /**
     * <pre>
     * 任务id
     * 表字段 : t_tasks_runtime_process.task_id
     * </pre>
     */
    @ApiModelProperty(example = "taskId", value = "任务id")
    private String taskId;

    /**
     * <pre>
     * 任务名称
     * 表字段 : t_tasks_runtime_process.task_name
     * </pre>
     */
    @ApiModelProperty(example = "taskName", value = "任务名称")
    private String taskName;

    /**
     * <pre>
     * 运行类型
     * 表字段 : t_tasks_runtime_process.run_type
     * </pre>
     */
    @ApiModelProperty(example = "runType", value = "运行类型")
    private String runType;

    /**
     * <pre>
     * 程序名称
     * 表字段 : t_tasks_runtime_process.process_name
     * </pre>
     */
    @ApiModelProperty(example = "processName", value = "程序名称")
    private String processName;

    /**
     * <pre>
     * 程序id
     * 表字段 : t_tasks_runtime_process.process_id
     * </pre>
     */
    @ApiModelProperty(example = "processId", value = "程序id")
    private String processId;

    /**
     * <pre>
     * 开始时间
     * 表字段 : t_tasks_runtime_process.start_time
     * </pre>
     */
    @ApiModelProperty(example = "startTime", value = "开始时间")
    private Date startTime;

    /**
     * <pre>
     * 结束时间
     * 表字段 : t_tasks_runtime_process.end_time
     * </pre>
     */
    @ApiModelProperty(example = "endTime", value = "结束时间")
    private Date endTime;

    /**
     * <pre>
     * 状态：1-运行中 2-结束 3-失败
     * 表字段 : t_tasks_runtime_process.status
     * </pre>
     */
    @ApiModelProperty(example = "status", value = "状态：1-运行中 2-结束 3-失败")
    private String status;

    /**
     * <pre>
     * 
     * 表字段 : t_tasks_runtime_process.param
     * </pre>
     */
    @ApiModelProperty(example = "param", value = "")
    private String param;

    /**
     * <pre>
     * 信息
     * 表字段 : t_tasks_runtime_process.info
     * </pre>
     */
    @ApiModelProperty(example = "info", value = "信息")
    private String info;

    /**
     * <pre>
     * 创建时间
     * 表字段 : t_tasks_runtime_process.create_time
     * </pre>
     */
    @ApiModelProperty(example = "createTime", value = "创建时间")
    private Date createTime;

    /**
     * <pre>
     * 最近更新时间
     * 表字段 : t_tasks_runtime_process.update_time
     * </pre>
     */
    @ApiModelProperty(example = "updateTime", value = "最近更新时间")
    private Date updateTime;

    /**
     * <pre>
     * 运行版本
     * 表字段 : t_tasks_runtime_process.run_version
     * </pre>
     */
    @ApiModelProperty(example = "runVersion", value = "运行版本")
    private String runVersion;

    private static final long serialVersionUID = 1L;

    /**
     * <pre>
     * 获取：
     * 表字段：t_tasks_runtime_process.id
     * </pre>
     *
     * @return t_tasks_runtime_process.id：
     */
    public String getId() {
        return id;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：t_tasks_runtime_process.id
     * </pre>
     *
     * @param id
     *            t_tasks_runtime_process.id：
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * <pre>
     * 获取：任务id
     * 表字段：t_tasks_runtime_process.task_id
     * </pre>
     *
     * @return t_tasks_runtime_process.task_id：任务id
     */
    public String getTaskId() {
        return taskId;
    }

    /**
     * <pre>
     * 设置：任务id
     * 表字段：t_tasks_runtime_process.task_id
     * </pre>
     *
     * @param taskId
     *            t_tasks_runtime_process.task_id：任务id
     */
    public void setTaskId(String taskId) {
        this.taskId = taskId == null ? null : taskId.trim();
    }

    /**
     * <pre>
     * 获取：任务名称
     * 表字段：t_tasks_runtime_process.task_name
     * </pre>
     *
     * @return t_tasks_runtime_process.task_name：任务名称
     */
    public String getTaskName() {
        return taskName;
    }

    /**
     * <pre>
     * 设置：任务名称
     * 表字段：t_tasks_runtime_process.task_name
     * </pre>
     *
     * @param taskName
     *            t_tasks_runtime_process.task_name：任务名称
     */
    public void setTaskName(String taskName) {
        this.taskName = taskName == null ? null : taskName.trim();
    }

    /**
     * <pre>
     * 获取：运行类型
     * 表字段：t_tasks_runtime_process.run_type
     * </pre>
     *
     * @return t_tasks_runtime_process.run_type：运行类型
     */
    public String getRunType() {
        return runType;
    }

    /**
     * <pre>
     * 设置：运行类型
     * 表字段：t_tasks_runtime_process.run_type
     * </pre>
     *
     * @param runType
     *            t_tasks_runtime_process.run_type：运行类型
     */
    public void setRunType(String runType) {
        this.runType = runType == null ? null : runType.trim();
    }

    /**
     * <pre>
     * 获取：程序名称
     * 表字段：t_tasks_runtime_process.process_name
     * </pre>
     *
     * @return t_tasks_runtime_process.process_name：程序名称
     */
    public String getProcessName() {
        return processName;
    }

    /**
     * <pre>
     * 设置：程序名称
     * 表字段：t_tasks_runtime_process.process_name
     * </pre>
     *
     * @param processName
     *            t_tasks_runtime_process.process_name：程序名称
     */
    public void setProcessName(String processName) {
        this.processName = processName == null ? null : processName.trim();
    }

    /**
     * <pre>
     * 获取：程序id
     * 表字段：t_tasks_runtime_process.process_id
     * </pre>
     *
     * @return t_tasks_runtime_process.process_id：程序id
     */
    public String getProcessId() {
        return processId;
    }

    /**
     * <pre>
     * 设置：程序id
     * 表字段：t_tasks_runtime_process.process_id
     * </pre>
     *
     * @param processId
     *            t_tasks_runtime_process.process_id：程序id
     */
    public void setProcessId(String processId) {
        this.processId = processId == null ? null : processId.trim();
    }

    /**
     * <pre>
     * 获取：开始时间
     * 表字段：t_tasks_runtime_process.start_time
     * </pre>
     *
     * @return t_tasks_runtime_process.start_time：开始时间
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * <pre>
     * 设置：开始时间
     * 表字段：t_tasks_runtime_process.start_time
     * </pre>
     *
     * @param startTime
     *            t_tasks_runtime_process.start_time：开始时间
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * <pre>
     * 获取：结束时间
     * 表字段：t_tasks_runtime_process.end_time
     * </pre>
     *
     * @return t_tasks_runtime_process.end_time：结束时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * <pre>
     * 设置：结束时间
     * 表字段：t_tasks_runtime_process.end_time
     * </pre>
     *
     * @param endTime
     *            t_tasks_runtime_process.end_time：结束时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * <pre>
     * 获取：状态：1-运行中 2-结束 3-失败
     * 表字段：t_tasks_runtime_process.status
     * </pre>
     *
     * @return t_tasks_runtime_process.status：状态：1-运行中 2-结束 3-失败
     */
    public String getStatus() {
        return status;
    }

    /**
     * <pre>
     * 设置：状态：1-运行中 2-结束 3-失败
     * 表字段：t_tasks_runtime_process.status
     * </pre>
     *
     * @param status
     *            t_tasks_runtime_process.status：状态：1-运行中 2-结束 3-失败
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * <pre>
     * 获取：
     * 表字段：t_tasks_runtime_process.param
     * </pre>
     *
     * @return t_tasks_runtime_process.param：
     */
    public String getParam() {
        return param;
    }

    /**
     * <pre>
     * 设置：
     * 表字段：t_tasks_runtime_process.param
     * </pre>
     *
     * @param param
     *            t_tasks_runtime_process.param：
     */
    public void setParam(String param) {
        this.param = param == null ? null : param.trim();
    }

    /**
     * <pre>
     * 获取：信息
     * 表字段：t_tasks_runtime_process.info
     * </pre>
     *
     * @return t_tasks_runtime_process.info：信息
     */
    public String getInfo() {
        return info;
    }

    /**
     * <pre>
     * 设置：信息
     * 表字段：t_tasks_runtime_process.info
     * </pre>
     *
     * @param info
     *            t_tasks_runtime_process.info：信息
     */
    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    /**
     * <pre>
     * 获取：创建时间
     * 表字段：t_tasks_runtime_process.create_time
     * </pre>
     *
     * @return t_tasks_runtime_process.create_time：创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * <pre>
     * 设置：创建时间
     * 表字段：t_tasks_runtime_process.create_time
     * </pre>
     *
     * @param createTime
     *            t_tasks_runtime_process.create_time：创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * <pre>
     * 获取：最近更新时间
     * 表字段：t_tasks_runtime_process.update_time
     * </pre>
     *
     * @return t_tasks_runtime_process.update_time：最近更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * <pre>
     * 设置：最近更新时间
     * 表字段：t_tasks_runtime_process.update_time
     * </pre>
     *
     * @param updateTime
     *            t_tasks_runtime_process.update_time：最近更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * <pre>
     * 获取：运行版本
     * 表字段：t_tasks_runtime_process.run_version
     * </pre>
     *
     * @return t_tasks_runtime_process.run_version：运行版本
     */
    public String getRunVersion() {
        return runVersion;
    }

    /**
     * <pre>
     * 设置：运行版本
     * 表字段：t_tasks_runtime_process.run_version
     * </pre>
     *
     * @param runVersion
     *            t_tasks_runtime_process.run_version：运行版本
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
        TRuntimeProcess other = (TRuntimeProcess) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTaskId() == null ? other.getTaskId() == null : this.getTaskId().equals(other.getTaskId()))
            && (this.getTaskName() == null ? other.getTaskName() == null : this.getTaskName().equals(other.getTaskName()))
            && (this.getRunType() == null ? other.getRunType() == null : this.getRunType().equals(other.getRunType()))
            && (this.getProcessName() == null ? other.getProcessName() == null : this.getProcessName().equals(other.getProcessName()))
            && (this.getProcessId() == null ? other.getProcessId() == null : this.getProcessId().equals(other.getProcessId()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getParam() == null ? other.getParam() == null : this.getParam().equals(other.getParam()))
            && (this.getInfo() == null ? other.getInfo() == null : this.getInfo().equals(other.getInfo()))
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
        result = prime * result + ((getTaskId() == null) ? 0 : getTaskId().hashCode());
        result = prime * result + ((getTaskName() == null) ? 0 : getTaskName().hashCode());
        result = prime * result + ((getRunType() == null) ? 0 : getRunType().hashCode());
        result = prime * result + ((getProcessName() == null) ? 0 : getProcessName().hashCode());
        result = prime * result + ((getProcessId() == null) ? 0 : getProcessId().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getParam() == null) ? 0 : getParam().hashCode());
        result = prime * result + ((getInfo() == null) ? 0 : getInfo().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getRunVersion() == null) ? 0 : getRunVersion().hashCode());
        return result;
    }
}