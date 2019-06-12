package com.neusoft.ssm.bean;

import java.util.ArrayList;
import java.util.List;

public class IcdExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public IcdExample() {
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

        public Criteria andIcdsecondnameIsNull() {
            addCriterion("ICDSecondName is null");
            return (Criteria) this;
        }

        public Criteria andIcdsecondnameIsNotNull() {
            addCriterion("ICDSecondName is not null");
            return (Criteria) this;
        }

        public Criteria andIcdsecondnameEqualTo(String value) {
            addCriterion("ICDSecondName =", value, "icdsecondname");
            return (Criteria) this;
        }

        public Criteria andIcdsecondnameNotEqualTo(String value) {
            addCriterion("ICDSecondName <>", value, "icdsecondname");
            return (Criteria) this;
        }

        public Criteria andIcdsecondnameGreaterThan(String value) {
            addCriterion("ICDSecondName >", value, "icdsecondname");
            return (Criteria) this;
        }

        public Criteria andIcdsecondnameGreaterThanOrEqualTo(String value) {
            addCriterion("ICDSecondName >=", value, "icdsecondname");
            return (Criteria) this;
        }

        public Criteria andIcdsecondnameLessThan(String value) {
            addCriterion("ICDSecondName <", value, "icdsecondname");
            return (Criteria) this;
        }

        public Criteria andIcdsecondnameLessThanOrEqualTo(String value) {
            addCriterion("ICDSecondName <=", value, "icdsecondname");
            return (Criteria) this;
        }

        public Criteria andIcdsecondnameLike(String value) {
            addCriterion("ICDSecondName like", value, "icdsecondname");
            return (Criteria) this;
        }

        public Criteria andIcdsecondnameNotLike(String value) {
            addCriterion("ICDSecondName not like", value, "icdsecondname");
            return (Criteria) this;
        }

        public Criteria andIcdsecondnameIn(List<String> values) {
            addCriterion("ICDSecondName in", values, "icdsecondname");
            return (Criteria) this;
        }

        public Criteria andIcdsecondnameNotIn(List<String> values) {
            addCriterion("ICDSecondName not in", values, "icdsecondname");
            return (Criteria) this;
        }

        public Criteria andIcdsecondnameBetween(String value1, String value2) {
            addCriterion("ICDSecondName between", value1, value2, "icdsecondname");
            return (Criteria) this;
        }

        public Criteria andIcdsecondnameNotBetween(String value1, String value2) {
            addCriterion("ICDSecondName not between", value1, value2, "icdsecondname");
            return (Criteria) this;
        }

        public Criteria andIcdfirstnameIsNull() {
            addCriterion("ICDFirstName is null");
            return (Criteria) this;
        }

        public Criteria andIcdfirstnameIsNotNull() {
            addCriterion("ICDFirstName is not null");
            return (Criteria) this;
        }

        public Criteria andIcdfirstnameEqualTo(String value) {
            addCriterion("ICDFirstName =", value, "icdfirstname");
            return (Criteria) this;
        }

        public Criteria andIcdfirstnameNotEqualTo(String value) {
            addCriterion("ICDFirstName <>", value, "icdfirstname");
            return (Criteria) this;
        }

        public Criteria andIcdfirstnameGreaterThan(String value) {
            addCriterion("ICDFirstName >", value, "icdfirstname");
            return (Criteria) this;
        }

        public Criteria andIcdfirstnameGreaterThanOrEqualTo(String value) {
            addCriterion("ICDFirstName >=", value, "icdfirstname");
            return (Criteria) this;
        }

        public Criteria andIcdfirstnameLessThan(String value) {
            addCriterion("ICDFirstName <", value, "icdfirstname");
            return (Criteria) this;
        }

        public Criteria andIcdfirstnameLessThanOrEqualTo(String value) {
            addCriterion("ICDFirstName <=", value, "icdfirstname");
            return (Criteria) this;
        }

        public Criteria andIcdfirstnameLike(String value) {
            addCriterion("ICDFirstName like", value, "icdfirstname");
            return (Criteria) this;
        }

        public Criteria andIcdfirstnameNotLike(String value) {
            addCriterion("ICDFirstName not like", value, "icdfirstname");
            return (Criteria) this;
        }

        public Criteria andIcdfirstnameIn(List<String> values) {
            addCriterion("ICDFirstName in", values, "icdfirstname");
            return (Criteria) this;
        }

        public Criteria andIcdfirstnameNotIn(List<String> values) {
            addCriterion("ICDFirstName not in", values, "icdfirstname");
            return (Criteria) this;
        }

        public Criteria andIcdfirstnameBetween(String value1, String value2) {
            addCriterion("ICDFirstName between", value1, value2, "icdfirstname");
            return (Criteria) this;
        }

        public Criteria andIcdfirstnameNotBetween(String value1, String value2) {
            addCriterion("ICDFirstName not between", value1, value2, "icdfirstname");
            return (Criteria) this;
        }

        public Criteria andAreaIsNull() {
            addCriterion("area is null");
            return (Criteria) this;
        }

        public Criteria andAreaIsNotNull() {
            addCriterion("area is not null");
            return (Criteria) this;
        }

        public Criteria andAreaEqualTo(String value) {
            addCriterion("area =", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotEqualTo(String value) {
            addCriterion("area <>", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThan(String value) {
            addCriterion("area >", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThanOrEqualTo(String value) {
            addCriterion("area >=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThan(String value) {
            addCriterion("area <", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThanOrEqualTo(String value) {
            addCriterion("area <=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLike(String value) {
            addCriterion("area like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotLike(String value) {
            addCriterion("area not like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaIn(List<String> values) {
            addCriterion("area in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotIn(List<String> values) {
            addCriterion("area not in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaBetween(String value1, String value2) {
            addCriterion("area between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotBetween(String value1, String value2) {
            addCriterion("area not between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andIcdidIsNull() {
            addCriterion("ICDid is null");
            return (Criteria) this;
        }

        public Criteria andIcdidIsNotNull() {
            addCriterion("ICDid is not null");
            return (Criteria) this;
        }

        public Criteria andIcdidEqualTo(String value) {
            addCriterion("ICDid =", value, "icdid");
            return (Criteria) this;
        }

        public Criteria andIcdidNotEqualTo(String value) {
            addCriterion("ICDid <>", value, "icdid");
            return (Criteria) this;
        }

        public Criteria andIcdidGreaterThan(String value) {
            addCriterion("ICDid >", value, "icdid");
            return (Criteria) this;
        }

        public Criteria andIcdidGreaterThanOrEqualTo(String value) {
            addCriterion("ICDid >=", value, "icdid");
            return (Criteria) this;
        }

        public Criteria andIcdidLessThan(String value) {
            addCriterion("ICDid <", value, "icdid");
            return (Criteria) this;
        }

        public Criteria andIcdidLessThanOrEqualTo(String value) {
            addCriterion("ICDid <=", value, "icdid");
            return (Criteria) this;
        }

        public Criteria andIcdidLike(String value) {
            addCriterion("ICDid like", value, "icdid");
            return (Criteria) this;
        }

        public Criteria andIcdidNotLike(String value) {
            addCriterion("ICDid not like", value, "icdid");
            return (Criteria) this;
        }

        public Criteria andIcdidIn(List<String> values) {
            addCriterion("ICDid in", values, "icdid");
            return (Criteria) this;
        }

        public Criteria andIcdidNotIn(List<String> values) {
            addCriterion("ICDid not in", values, "icdid");
            return (Criteria) this;
        }

        public Criteria andIcdidBetween(String value1, String value2) {
            addCriterion("ICDid between", value1, value2, "icdid");
            return (Criteria) this;
        }

        public Criteria andIcdidNotBetween(String value1, String value2) {
            addCriterion("ICDid not between", value1, value2, "icdid");
            return (Criteria) this;
        }

        public Criteria andF6IsNull() {
            addCriterion("f6 is null");
            return (Criteria) this;
        }

        public Criteria andF6IsNotNull() {
            addCriterion("f6 is not null");
            return (Criteria) this;
        }

        public Criteria andF6EqualTo(String value) {
            addCriterion("f6 =", value, "f6");
            return (Criteria) this;
        }

        public Criteria andF6NotEqualTo(String value) {
            addCriterion("f6 <>", value, "f6");
            return (Criteria) this;
        }

        public Criteria andF6GreaterThan(String value) {
            addCriterion("f6 >", value, "f6");
            return (Criteria) this;
        }

        public Criteria andF6GreaterThanOrEqualTo(String value) {
            addCriterion("f6 >=", value, "f6");
            return (Criteria) this;
        }

        public Criteria andF6LessThan(String value) {
            addCriterion("f6 <", value, "f6");
            return (Criteria) this;
        }

        public Criteria andF6LessThanOrEqualTo(String value) {
            addCriterion("f6 <=", value, "f6");
            return (Criteria) this;
        }

        public Criteria andF6Like(String value) {
            addCriterion("f6 like", value, "f6");
            return (Criteria) this;
        }

        public Criteria andF6NotLike(String value) {
            addCriterion("f6 not like", value, "f6");
            return (Criteria) this;
        }

        public Criteria andF6In(List<String> values) {
            addCriterion("f6 in", values, "f6");
            return (Criteria) this;
        }

        public Criteria andF6NotIn(List<String> values) {
            addCriterion("f6 not in", values, "f6");
            return (Criteria) this;
        }

        public Criteria andF6Between(String value1, String value2) {
            addCriterion("f6 between", value1, value2, "f6");
            return (Criteria) this;
        }

        public Criteria andF6NotBetween(String value1, String value2) {
            addCriterion("f6 not between", value1, value2, "f6");
            return (Criteria) this;
        }

        public Criteria andF7IsNull() {
            addCriterion("f7 is null");
            return (Criteria) this;
        }

        public Criteria andF7IsNotNull() {
            addCriterion("f7 is not null");
            return (Criteria) this;
        }

        public Criteria andF7EqualTo(String value) {
            addCriterion("f7 =", value, "f7");
            return (Criteria) this;
        }

        public Criteria andF7NotEqualTo(String value) {
            addCriterion("f7 <>", value, "f7");
            return (Criteria) this;
        }

        public Criteria andF7GreaterThan(String value) {
            addCriterion("f7 >", value, "f7");
            return (Criteria) this;
        }

        public Criteria andF7GreaterThanOrEqualTo(String value) {
            addCriterion("f7 >=", value, "f7");
            return (Criteria) this;
        }

        public Criteria andF7LessThan(String value) {
            addCriterion("f7 <", value, "f7");
            return (Criteria) this;
        }

        public Criteria andF7LessThanOrEqualTo(String value) {
            addCriterion("f7 <=", value, "f7");
            return (Criteria) this;
        }

        public Criteria andF7Like(String value) {
            addCriterion("f7 like", value, "f7");
            return (Criteria) this;
        }

        public Criteria andF7NotLike(String value) {
            addCriterion("f7 not like", value, "f7");
            return (Criteria) this;
        }

        public Criteria andF7In(List<String> values) {
            addCriterion("f7 in", values, "f7");
            return (Criteria) this;
        }

        public Criteria andF7NotIn(List<String> values) {
            addCriterion("f7 not in", values, "f7");
            return (Criteria) this;
        }

        public Criteria andF7Between(String value1, String value2) {
            addCriterion("f7 between", value1, value2, "f7");
            return (Criteria) this;
        }

        public Criteria andF7NotBetween(String value1, String value2) {
            addCriterion("f7 not between", value1, value2, "f7");
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