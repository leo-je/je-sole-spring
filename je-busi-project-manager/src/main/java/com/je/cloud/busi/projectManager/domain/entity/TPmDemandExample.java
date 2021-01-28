package com.je.cloud.busi.projectManager.domain.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TPmDemandExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    /**
     *
     */
    public TPmDemandExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *
     * @param orderByClause
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *
     * @param distinct
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     *
     * @param criteria
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     *
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     *
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * 类注释
     * GeneratedCriteria
     * 数据库表：t_pm_demand
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNull() {
            addCriterion("project_Name is null");
            return (Criteria) this;
        }

        public Criteria andProjectNameIsNotNull() {
            addCriterion("project_Name is not null");
            return (Criteria) this;
        }

        public Criteria andProjectNameEqualTo(String value) {
            addCriterion("project_Name =", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotEqualTo(String value) {
            addCriterion("project_Name <>", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThan(String value) {
            addCriterion("project_Name >", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameGreaterThanOrEqualTo(String value) {
            addCriterion("project_Name >=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThan(String value) {
            addCriterion("project_Name <", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLessThanOrEqualTo(String value) {
            addCriterion("project_Name <=", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameLike(String value) {
            addCriterion("project_Name like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotLike(String value) {
            addCriterion("project_Name not like", value, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameIn(List<String> values) {
            addCriterion("project_Name in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotIn(List<String> values) {
            addCriterion("project_Name not in", values, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameBetween(String value1, String value2) {
            addCriterion("project_Name between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectNameNotBetween(String value1, String value2) {
            addCriterion("project_Name not between", value1, value2, "projectName");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNull() {
            addCriterion("project_Id is null");
            return (Criteria) this;
        }

        public Criteria andProjectIdIsNotNull() {
            addCriterion("project_Id is not null");
            return (Criteria) this;
        }

        public Criteria andProjectIdEqualTo(String value) {
            addCriterion("project_Id =", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotEqualTo(String value) {
            addCriterion("project_Id <>", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThan(String value) {
            addCriterion("project_Id >", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdGreaterThanOrEqualTo(String value) {
            addCriterion("project_Id >=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThan(String value) {
            addCriterion("project_Id <", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLessThanOrEqualTo(String value) {
            addCriterion("project_Id <=", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdLike(String value) {
            addCriterion("project_Id like", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotLike(String value) {
            addCriterion("project_Id not like", value, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdIn(List<String> values) {
            addCriterion("project_Id in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotIn(List<String> values) {
            addCriterion("project_Id not in", values, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdBetween(String value1, String value2) {
            addCriterion("project_Id between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andProjectIdNotBetween(String value1, String value2) {
            addCriterion("project_Id not between", value1, value2, "projectId");
            return (Criteria) this;
        }

        public Criteria andScheduledOnLineTimeIsNull() {
            addCriterion("scheduled_On_Line_Time is null");
            return (Criteria) this;
        }

        public Criteria andScheduledOnLineTimeIsNotNull() {
            addCriterion("scheduled_On_Line_Time is not null");
            return (Criteria) this;
        }

        public Criteria andScheduledOnLineTimeEqualTo(Date value) {
            addCriterion("scheduled_On_Line_Time =", value, "scheduledOnLineTime");
            return (Criteria) this;
        }

        public Criteria andScheduledOnLineTimeNotEqualTo(Date value) {
            addCriterion("scheduled_On_Line_Time <>", value, "scheduledOnLineTime");
            return (Criteria) this;
        }

        public Criteria andScheduledOnLineTimeGreaterThan(Date value) {
            addCriterion("scheduled_On_Line_Time >", value, "scheduledOnLineTime");
            return (Criteria) this;
        }

        public Criteria andScheduledOnLineTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("scheduled_On_Line_Time >=", value, "scheduledOnLineTime");
            return (Criteria) this;
        }

        public Criteria andScheduledOnLineTimeLessThan(Date value) {
            addCriterion("scheduled_On_Line_Time <", value, "scheduledOnLineTime");
            return (Criteria) this;
        }

        public Criteria andScheduledOnLineTimeLessThanOrEqualTo(Date value) {
            addCriterion("scheduled_On_Line_Time <=", value, "scheduledOnLineTime");
            return (Criteria) this;
        }

        public Criteria andScheduledOnLineTimeIn(List<Date> values) {
            addCriterion("scheduled_On_Line_Time in", values, "scheduledOnLineTime");
            return (Criteria) this;
        }

        public Criteria andScheduledOnLineTimeNotIn(List<Date> values) {
            addCriterion("scheduled_On_Line_Time not in", values, "scheduledOnLineTime");
            return (Criteria) this;
        }

        public Criteria andScheduledOnLineTimeBetween(Date value1, Date value2) {
            addCriterion("scheduled_On_Line_Time between", value1, value2, "scheduledOnLineTime");
            return (Criteria) this;
        }

        public Criteria andScheduledOnLineTimeNotBetween(Date value1, Date value2) {
            addCriterion("scheduled_On_Line_Time not between", value1, value2, "scheduledOnLineTime");
            return (Criteria) this;
        }

        public Criteria andScheduledFinishTimeIsNull() {
            addCriterion("scheduled_Finish_Time is null");
            return (Criteria) this;
        }

        public Criteria andScheduledFinishTimeIsNotNull() {
            addCriterion("scheduled_Finish_Time is not null");
            return (Criteria) this;
        }

        public Criteria andScheduledFinishTimeEqualTo(Date value) {
            addCriterion("scheduled_Finish_Time =", value, "scheduledFinishTime");
            return (Criteria) this;
        }

        public Criteria andScheduledFinishTimeNotEqualTo(Date value) {
            addCriterion("scheduled_Finish_Time <>", value, "scheduledFinishTime");
            return (Criteria) this;
        }

        public Criteria andScheduledFinishTimeGreaterThan(Date value) {
            addCriterion("scheduled_Finish_Time >", value, "scheduledFinishTime");
            return (Criteria) this;
        }

        public Criteria andScheduledFinishTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("scheduled_Finish_Time >=", value, "scheduledFinishTime");
            return (Criteria) this;
        }

        public Criteria andScheduledFinishTimeLessThan(Date value) {
            addCriterion("scheduled_Finish_Time <", value, "scheduledFinishTime");
            return (Criteria) this;
        }

        public Criteria andScheduledFinishTimeLessThanOrEqualTo(Date value) {
            addCriterion("scheduled_Finish_Time <=", value, "scheduledFinishTime");
            return (Criteria) this;
        }

        public Criteria andScheduledFinishTimeIn(List<Date> values) {
            addCriterion("scheduled_Finish_Time in", values, "scheduledFinishTime");
            return (Criteria) this;
        }

        public Criteria andScheduledFinishTimeNotIn(List<Date> values) {
            addCriterion("scheduled_Finish_Time not in", values, "scheduledFinishTime");
            return (Criteria) this;
        }

        public Criteria andScheduledFinishTimeBetween(Date value1, Date value2) {
            addCriterion("scheduled_Finish_Time between", value1, value2, "scheduledFinishTime");
            return (Criteria) this;
        }

        public Criteria andScheduledFinishTimeNotBetween(Date value1, Date value2) {
            addCriterion("scheduled_Finish_Time not between", value1, value2, "scheduledFinishTime");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(String value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(String value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(String value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(String value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(String value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(String value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLike(String value) {
            addCriterion("version like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotLike(String value) {
            addCriterion("version not like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<String> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<String> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(String value1, String value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(String value1, String value2) {
            addCriterion("version not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("sort is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("sort is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Integer> values) {
            addCriterion("sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Integer> values) {
            addCriterion("sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("sort not between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andProgramsIsNull() {
            addCriterion("programs is null");
            return (Criteria) this;
        }

        public Criteria andProgramsIsNotNull() {
            addCriterion("programs is not null");
            return (Criteria) this;
        }

        public Criteria andProgramsEqualTo(String value) {
            addCriterion("programs =", value, "programs");
            return (Criteria) this;
        }

        public Criteria andProgramsNotEqualTo(String value) {
            addCriterion("programs <>", value, "programs");
            return (Criteria) this;
        }

        public Criteria andProgramsGreaterThan(String value) {
            addCriterion("programs >", value, "programs");
            return (Criteria) this;
        }

        public Criteria andProgramsGreaterThanOrEqualTo(String value) {
            addCriterion("programs >=", value, "programs");
            return (Criteria) this;
        }

        public Criteria andProgramsLessThan(String value) {
            addCriterion("programs <", value, "programs");
            return (Criteria) this;
        }

        public Criteria andProgramsLessThanOrEqualTo(String value) {
            addCriterion("programs <=", value, "programs");
            return (Criteria) this;
        }

        public Criteria andProgramsLike(String value) {
            addCriterion("programs like", value, "programs");
            return (Criteria) this;
        }

        public Criteria andProgramsNotLike(String value) {
            addCriterion("programs not like", value, "programs");
            return (Criteria) this;
        }

        public Criteria andProgramsIn(List<String> values) {
            addCriterion("programs in", values, "programs");
            return (Criteria) this;
        }

        public Criteria andProgramsNotIn(List<String> values) {
            addCriterion("programs not in", values, "programs");
            return (Criteria) this;
        }

        public Criteria andProgramsBetween(String value1, String value2) {
            addCriterion("programs between", value1, value2, "programs");
            return (Criteria) this;
        }

        public Criteria andProgramsNotBetween(String value1, String value2) {
            addCriterion("programs not between", value1, value2, "programs");
            return (Criteria) this;
        }

        public Criteria andLogIsNull() {
            addCriterion("log is null");
            return (Criteria) this;
        }

        public Criteria andLogIsNotNull() {
            addCriterion("log is not null");
            return (Criteria) this;
        }

        public Criteria andLogEqualTo(String value) {
            addCriterion("log =", value, "log");
            return (Criteria) this;
        }

        public Criteria andLogNotEqualTo(String value) {
            addCriterion("log <>", value, "log");
            return (Criteria) this;
        }

        public Criteria andLogGreaterThan(String value) {
            addCriterion("log >", value, "log");
            return (Criteria) this;
        }

        public Criteria andLogGreaterThanOrEqualTo(String value) {
            addCriterion("log >=", value, "log");
            return (Criteria) this;
        }

        public Criteria andLogLessThan(String value) {
            addCriterion("log <", value, "log");
            return (Criteria) this;
        }

        public Criteria andLogLessThanOrEqualTo(String value) {
            addCriterion("log <=", value, "log");
            return (Criteria) this;
        }

        public Criteria andLogLike(String value) {
            addCriterion("log like", value, "log");
            return (Criteria) this;
        }

        public Criteria andLogNotLike(String value) {
            addCriterion("log not like", value, "log");
            return (Criteria) this;
        }

        public Criteria andLogIn(List<String> values) {
            addCriterion("log in", values, "log");
            return (Criteria) this;
        }

        public Criteria andLogNotIn(List<String> values) {
            addCriterion("log not in", values, "log");
            return (Criteria) this;
        }

        public Criteria andLogBetween(String value1, String value2) {
            addCriterion("log between", value1, value2, "log");
            return (Criteria) this;
        }

        public Criteria andLogNotBetween(String value1, String value2) {
            addCriterion("log not between", value1, value2, "log");
            return (Criteria) this;
        }

        public Criteria andJiraCodeIsNull() {
            addCriterion("jira_code is null");
            return (Criteria) this;
        }

        public Criteria andJiraCodeIsNotNull() {
            addCriterion("jira_code is not null");
            return (Criteria) this;
        }

        public Criteria andJiraCodeEqualTo(String value) {
            addCriterion("jira_code =", value, "jiraCode");
            return (Criteria) this;
        }

        public Criteria andJiraCodeNotEqualTo(String value) {
            addCriterion("jira_code <>", value, "jiraCode");
            return (Criteria) this;
        }

        public Criteria andJiraCodeGreaterThan(String value) {
            addCriterion("jira_code >", value, "jiraCode");
            return (Criteria) this;
        }

        public Criteria andJiraCodeGreaterThanOrEqualTo(String value) {
            addCriterion("jira_code >=", value, "jiraCode");
            return (Criteria) this;
        }

        public Criteria andJiraCodeLessThan(String value) {
            addCriterion("jira_code <", value, "jiraCode");
            return (Criteria) this;
        }

        public Criteria andJiraCodeLessThanOrEqualTo(String value) {
            addCriterion("jira_code <=", value, "jiraCode");
            return (Criteria) this;
        }

        public Criteria andJiraCodeLike(String value) {
            addCriterion("jira_code like", value, "jiraCode");
            return (Criteria) this;
        }

        public Criteria andJiraCodeNotLike(String value) {
            addCriterion("jira_code not like", value, "jiraCode");
            return (Criteria) this;
        }

        public Criteria andJiraCodeIn(List<String> values) {
            addCriterion("jira_code in", values, "jiraCode");
            return (Criteria) this;
        }

        public Criteria andJiraCodeNotIn(List<String> values) {
            addCriterion("jira_code not in", values, "jiraCode");
            return (Criteria) this;
        }

        public Criteria andJiraCodeBetween(String value1, String value2) {
            addCriterion("jira_code between", value1, value2, "jiraCode");
            return (Criteria) this;
        }

        public Criteria andJiraCodeNotBetween(String value1, String value2) {
            addCriterion("jira_code not between", value1, value2, "jiraCode");
            return (Criteria) this;
        }
    }

    /**
     * 类注释
     * Criteria
     * 数据库表：t_pm_demand
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 类注释
     * Criterion
     * 数据库表：t_pm_demand
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}