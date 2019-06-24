package com.neusoft.ssm.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PrescribemodelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public PrescribemodelExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
        return offset;
    }

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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andPrescribemodelidIsNull() {
            addCriterion("prescribemodelid is null");
            return (Criteria) this;
        }

        public Criteria andPrescribemodelidIsNotNull() {
            addCriterion("prescribemodelid is not null");
            return (Criteria) this;
        }

        public Criteria andPrescribemodelidEqualTo(String value) {
            addCriterion("prescribemodelid =", value, "prescribemodelid");
            return (Criteria) this;
        }

        public Criteria andPrescribemodelidNotEqualTo(String value) {
            addCriterion("prescribemodelid <>", value, "prescribemodelid");
            return (Criteria) this;
        }

        public Criteria andPrescribemodelidGreaterThan(String value) {
            addCriterion("prescribemodelid >", value, "prescribemodelid");
            return (Criteria) this;
        }

        public Criteria andPrescribemodelidGreaterThanOrEqualTo(String value) {
            addCriterion("prescribemodelid >=", value, "prescribemodelid");
            return (Criteria) this;
        }

        public Criteria andPrescribemodelidLessThan(String value) {
            addCriterion("prescribemodelid <", value, "prescribemodelid");
            return (Criteria) this;
        }

        public Criteria andPrescribemodelidLessThanOrEqualTo(String value) {
            addCriterion("prescribemodelid <=", value, "prescribemodelid");
            return (Criteria) this;
        }

        public Criteria andPrescribemodelidLike(String value) {
            addCriterion("prescribemodelid like", value, "prescribemodelid");
            return (Criteria) this;
        }

        public Criteria andPrescribemodelidNotLike(String value) {
            addCriterion("prescribemodelid not like", value, "prescribemodelid");
            return (Criteria) this;
        }

        public Criteria andPrescribemodelidIn(List<String> values) {
            addCriterion("prescribemodelid in", values, "prescribemodelid");
            return (Criteria) this;
        }

        public Criteria andPrescribemodelidNotIn(List<String> values) {
            addCriterion("prescribemodelid not in", values, "prescribemodelid");
            return (Criteria) this;
        }

        public Criteria andPrescribemodelidBetween(String value1, String value2) {
            addCriterion("prescribemodelid between", value1, value2, "prescribemodelid");
            return (Criteria) this;
        }

        public Criteria andPrescribemodelidNotBetween(String value1, String value2) {
            addCriterion("prescribemodelid not between", value1, value2, "prescribemodelid");
            return (Criteria) this;
        }

        public Criteria andPrescribemodelnameIsNull() {
            addCriterion("prescribemodelname is null");
            return (Criteria) this;
        }

        public Criteria andPrescribemodelnameIsNotNull() {
            addCriterion("prescribemodelname is not null");
            return (Criteria) this;
        }

        public Criteria andPrescribemodelnameEqualTo(String value) {
            addCriterion("prescribemodelname =", value, "prescribemodelname");
            return (Criteria) this;
        }

        public Criteria andPrescribemodelnameNotEqualTo(String value) {
            addCriterion("prescribemodelname <>", value, "prescribemodelname");
            return (Criteria) this;
        }

        public Criteria andPrescribemodelnameGreaterThan(String value) {
            addCriterion("prescribemodelname >", value, "prescribemodelname");
            return (Criteria) this;
        }

        public Criteria andPrescribemodelnameGreaterThanOrEqualTo(String value) {
            addCriterion("prescribemodelname >=", value, "prescribemodelname");
            return (Criteria) this;
        }

        public Criteria andPrescribemodelnameLessThan(String value) {
            addCriterion("prescribemodelname <", value, "prescribemodelname");
            return (Criteria) this;
        }

        public Criteria andPrescribemodelnameLessThanOrEqualTo(String value) {
            addCriterion("prescribemodelname <=", value, "prescribemodelname");
            return (Criteria) this;
        }

        public Criteria andPrescribemodelnameLike(String value) {
            addCriterion("prescribemodelname like", value, "prescribemodelname");
            return (Criteria) this;
        }

        public Criteria andPrescribemodelnameNotLike(String value) {
            addCriterion("prescribemodelname not like", value, "prescribemodelname");
            return (Criteria) this;
        }

        public Criteria andPrescribemodelnameIn(List<String> values) {
            addCriterion("prescribemodelname in", values, "prescribemodelname");
            return (Criteria) this;
        }

        public Criteria andPrescribemodelnameNotIn(List<String> values) {
            addCriterion("prescribemodelname not in", values, "prescribemodelname");
            return (Criteria) this;
        }

        public Criteria andPrescribemodelnameBetween(String value1, String value2) {
            addCriterion("prescribemodelname between", value1, value2, "prescribemodelname");
            return (Criteria) this;
        }

        public Criteria andPrescribemodelnameNotBetween(String value1, String value2) {
            addCriterion("prescribemodelname not between", value1, value2, "prescribemodelname");
            return (Criteria) this;
        }

        public Criteria andPrescribeusageIsNull() {
            addCriterion("prescribeusage is null");
            return (Criteria) this;
        }

        public Criteria andPrescribeusageIsNotNull() {
            addCriterion("prescribeusage is not null");
            return (Criteria) this;
        }

        public Criteria andPrescribeusageEqualTo(String value) {
            addCriterion("prescribeusage =", value, "prescribeusage");
            return (Criteria) this;
        }

        public Criteria andPrescribeusageNotEqualTo(String value) {
            addCriterion("prescribeusage <>", value, "prescribeusage");
            return (Criteria) this;
        }

        public Criteria andPrescribeusageGreaterThan(String value) {
            addCriterion("prescribeusage >", value, "prescribeusage");
            return (Criteria) this;
        }

        public Criteria andPrescribeusageGreaterThanOrEqualTo(String value) {
            addCriterion("prescribeusage >=", value, "prescribeusage");
            return (Criteria) this;
        }

        public Criteria andPrescribeusageLessThan(String value) {
            addCriterion("prescribeusage <", value, "prescribeusage");
            return (Criteria) this;
        }

        public Criteria andPrescribeusageLessThanOrEqualTo(String value) {
            addCriterion("prescribeusage <=", value, "prescribeusage");
            return (Criteria) this;
        }

        public Criteria andPrescribeusageLike(String value) {
            addCriterion("prescribeusage like", value, "prescribeusage");
            return (Criteria) this;
        }

        public Criteria andPrescribeusageNotLike(String value) {
            addCriterion("prescribeusage not like", value, "prescribeusage");
            return (Criteria) this;
        }

        public Criteria andPrescribeusageIn(List<String> values) {
            addCriterion("prescribeusage in", values, "prescribeusage");
            return (Criteria) this;
        }

        public Criteria andPrescribeusageNotIn(List<String> values) {
            addCriterion("prescribeusage not in", values, "prescribeusage");
            return (Criteria) this;
        }

        public Criteria andPrescribeusageBetween(String value1, String value2) {
            addCriterion("prescribeusage between", value1, value2, "prescribeusage");
            return (Criteria) this;
        }

        public Criteria andPrescribeusageNotBetween(String value1, String value2) {
            addCriterion("prescribeusage not between", value1, value2, "prescribeusage");
            return (Criteria) this;
        }

        public Criteria andPrescribetypeIsNull() {
            addCriterion("prescribetype is null");
            return (Criteria) this;
        }

        public Criteria andPrescribetypeIsNotNull() {
            addCriterion("prescribetype is not null");
            return (Criteria) this;
        }

        public Criteria andPrescribetypeEqualTo(String value) {
            addCriterion("prescribetype =", value, "prescribetype");
            return (Criteria) this;
        }

        public Criteria andPrescribetypeNotEqualTo(String value) {
            addCriterion("prescribetype <>", value, "prescribetype");
            return (Criteria) this;
        }

        public Criteria andPrescribetypeGreaterThan(String value) {
            addCriterion("prescribetype >", value, "prescribetype");
            return (Criteria) this;
        }

        public Criteria andPrescribetypeGreaterThanOrEqualTo(String value) {
            addCriterion("prescribetype >=", value, "prescribetype");
            return (Criteria) this;
        }

        public Criteria andPrescribetypeLessThan(String value) {
            addCriterion("prescribetype <", value, "prescribetype");
            return (Criteria) this;
        }

        public Criteria andPrescribetypeLessThanOrEqualTo(String value) {
            addCriterion("prescribetype <=", value, "prescribetype");
            return (Criteria) this;
        }

        public Criteria andPrescribetypeLike(String value) {
            addCriterion("prescribetype like", value, "prescribetype");
            return (Criteria) this;
        }

        public Criteria andPrescribetypeNotLike(String value) {
            addCriterion("prescribetype not like", value, "prescribetype");
            return (Criteria) this;
        }

        public Criteria andPrescribetypeIn(List<String> values) {
            addCriterion("prescribetype in", values, "prescribetype");
            return (Criteria) this;
        }

        public Criteria andPrescribetypeNotIn(List<String> values) {
            addCriterion("prescribetype not in", values, "prescribetype");
            return (Criteria) this;
        }

        public Criteria andPrescribetypeBetween(String value1, String value2) {
            addCriterion("prescribetype between", value1, value2, "prescribetype");
            return (Criteria) this;
        }

        public Criteria andPrescribetypeNotBetween(String value1, String value2) {
            addCriterion("prescribetype not between", value1, value2, "prescribetype");
            return (Criteria) this;
        }

        public Criteria andServerIsNull() {
            addCriterion("server is null");
            return (Criteria) this;
        }

        public Criteria andServerIsNotNull() {
            addCriterion("server is not null");
            return (Criteria) this;
        }

        public Criteria andServerEqualTo(String value) {
            addCriterion("server =", value, "server");
            return (Criteria) this;
        }

        public Criteria andServerNotEqualTo(String value) {
            addCriterion("server <>", value, "server");
            return (Criteria) this;
        }

        public Criteria andServerGreaterThan(String value) {
            addCriterion("server >", value, "server");
            return (Criteria) this;
        }

        public Criteria andServerGreaterThanOrEqualTo(String value) {
            addCriterion("server >=", value, "server");
            return (Criteria) this;
        }

        public Criteria andServerLessThan(String value) {
            addCriterion("server <", value, "server");
            return (Criteria) this;
        }

        public Criteria andServerLessThanOrEqualTo(String value) {
            addCriterion("server <=", value, "server");
            return (Criteria) this;
        }

        public Criteria andServerLike(String value) {
            addCriterion("server like", value, "server");
            return (Criteria) this;
        }

        public Criteria andServerNotLike(String value) {
            addCriterion("server not like", value, "server");
            return (Criteria) this;
        }

        public Criteria andServerIn(List<String> values) {
            addCriterion("server in", values, "server");
            return (Criteria) this;
        }

        public Criteria andServerNotIn(List<String> values) {
            addCriterion("server not in", values, "server");
            return (Criteria) this;
        }

        public Criteria andServerBetween(String value1, String value2) {
            addCriterion("server between", value1, value2, "server");
            return (Criteria) this;
        }

        public Criteria andServerNotBetween(String value1, String value2) {
            addCriterion("server not between", value1, value2, "server");
            return (Criteria) this;
        }

        public Criteria andUsageIsNull() {
            addCriterion("`usage` is null");
            return (Criteria) this;
        }

        public Criteria andUsageIsNotNull() {
            addCriterion("`usage` is not null");
            return (Criteria) this;
        }

        public Criteria andUsageEqualTo(String value) {
            addCriterion("`usage` =", value, "usage");
            return (Criteria) this;
        }

        public Criteria andUsageNotEqualTo(String value) {
            addCriterion("`usage` <>", value, "usage");
            return (Criteria) this;
        }

        public Criteria andUsageGreaterThan(String value) {
            addCriterion("`usage` >", value, "usage");
            return (Criteria) this;
        }

        public Criteria andUsageGreaterThanOrEqualTo(String value) {
            addCriterion("`usage` >=", value, "usage");
            return (Criteria) this;
        }

        public Criteria andUsageLessThan(String value) {
            addCriterion("`usage` <", value, "usage");
            return (Criteria) this;
        }

        public Criteria andUsageLessThanOrEqualTo(String value) {
            addCriterion("`usage` <=", value, "usage");
            return (Criteria) this;
        }

        public Criteria andUsageLike(String value) {
            addCriterion("`usage` like", value, "usage");
            return (Criteria) this;
        }

        public Criteria andUsageNotLike(String value) {
            addCriterion("`usage` not like", value, "usage");
            return (Criteria) this;
        }

        public Criteria andUsageIn(List<String> values) {
            addCriterion("`usage` in", values, "usage");
            return (Criteria) this;
        }

        public Criteria andUsageNotIn(List<String> values) {
            addCriterion("`usage` not in", values, "usage");
            return (Criteria) this;
        }

        public Criteria andUsageBetween(String value1, String value2) {
            addCriterion("`usage` between", value1, value2, "usage");
            return (Criteria) this;
        }

        public Criteria andUsageNotBetween(String value1, String value2) {
            addCriterion("`usage` not between", value1, value2, "usage");
            return (Criteria) this;
        }

        public Criteria andCreatemanIsNull() {
            addCriterion("createman is null");
            return (Criteria) this;
        }

        public Criteria andCreatemanIsNotNull() {
            addCriterion("createman is not null");
            return (Criteria) this;
        }

        public Criteria andCreatemanEqualTo(String value) {
            addCriterion("createman =", value, "createman");
            return (Criteria) this;
        }

        public Criteria andCreatemanNotEqualTo(String value) {
            addCriterion("createman <>", value, "createman");
            return (Criteria) this;
        }

        public Criteria andCreatemanGreaterThan(String value) {
            addCriterion("createman >", value, "createman");
            return (Criteria) this;
        }

        public Criteria andCreatemanGreaterThanOrEqualTo(String value) {
            addCriterion("createman >=", value, "createman");
            return (Criteria) this;
        }

        public Criteria andCreatemanLessThan(String value) {
            addCriterion("createman <", value, "createman");
            return (Criteria) this;
        }

        public Criteria andCreatemanLessThanOrEqualTo(String value) {
            addCriterion("createman <=", value, "createman");
            return (Criteria) this;
        }

        public Criteria andCreatemanLike(String value) {
            addCriterion("createman like", value, "createman");
            return (Criteria) this;
        }

        public Criteria andCreatemanNotLike(String value) {
            addCriterion("createman not like", value, "createman");
            return (Criteria) this;
        }

        public Criteria andCreatemanIn(List<String> values) {
            addCriterion("createman in", values, "createman");
            return (Criteria) this;
        }

        public Criteria andCreatemanNotIn(List<String> values) {
            addCriterion("createman not in", values, "createman");
            return (Criteria) this;
        }

        public Criteria andCreatemanBetween(String value1, String value2) {
            addCriterion("createman between", value1, value2, "createman");
            return (Criteria) this;
        }

        public Criteria andCreatemanNotBetween(String value1, String value2) {
            addCriterion("createman not between", value1, value2, "createman");
            return (Criteria) this;
        }

        public Criteria andCreatedeptIsNull() {
            addCriterion("createdept is null");
            return (Criteria) this;
        }

        public Criteria andCreatedeptIsNotNull() {
            addCriterion("createdept is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedeptEqualTo(String value) {
            addCriterion("createdept =", value, "createdept");
            return (Criteria) this;
        }

        public Criteria andCreatedeptNotEqualTo(String value) {
            addCriterion("createdept <>", value, "createdept");
            return (Criteria) this;
        }

        public Criteria andCreatedeptGreaterThan(String value) {
            addCriterion("createdept >", value, "createdept");
            return (Criteria) this;
        }

        public Criteria andCreatedeptGreaterThanOrEqualTo(String value) {
            addCriterion("createdept >=", value, "createdept");
            return (Criteria) this;
        }

        public Criteria andCreatedeptLessThan(String value) {
            addCriterion("createdept <", value, "createdept");
            return (Criteria) this;
        }

        public Criteria andCreatedeptLessThanOrEqualTo(String value) {
            addCriterion("createdept <=", value, "createdept");
            return (Criteria) this;
        }

        public Criteria andCreatedeptLike(String value) {
            addCriterion("createdept like", value, "createdept");
            return (Criteria) this;
        }

        public Criteria andCreatedeptNotLike(String value) {
            addCriterion("createdept not like", value, "createdept");
            return (Criteria) this;
        }

        public Criteria andCreatedeptIn(List<String> values) {
            addCriterion("createdept in", values, "createdept");
            return (Criteria) this;
        }

        public Criteria andCreatedeptNotIn(List<String> values) {
            addCriterion("createdept not in", values, "createdept");
            return (Criteria) this;
        }

        public Criteria andCreatedeptBetween(String value1, String value2) {
            addCriterion("createdept between", value1, value2, "createdept");
            return (Criteria) this;
        }

        public Criteria andCreatedeptNotBetween(String value1, String value2) {
            addCriterion("createdept not between", value1, value2, "createdept");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterionForJDBCDate("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterionForJDBCDate("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterionForJDBCDate("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterionForJDBCDate("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }
    }

    /**
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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