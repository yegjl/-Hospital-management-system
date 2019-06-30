package com.neusoft.ssm.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PrescribeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public PrescribeExample() {
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

        public Criteria andMedicalrecordidIsNull() {
            addCriterion("medicalrecordid is null");
            return (Criteria) this;
        }

        public Criteria andMedicalrecordidIsNotNull() {
            addCriterion("medicalrecordid is not null");
            return (Criteria) this;
        }

        public Criteria andMedicalrecordidEqualTo(String value) {
            addCriterion("medicalrecordid =", value, "medicalrecordid");
            return (Criteria) this;
        }

        public Criteria andMedicalrecordidNotEqualTo(String value) {
            addCriterion("medicalrecordid <>", value, "medicalrecordid");
            return (Criteria) this;
        }

        public Criteria andMedicalrecordidGreaterThan(String value) {
            addCriterion("medicalrecordid >", value, "medicalrecordid");
            return (Criteria) this;
        }

        public Criteria andMedicalrecordidGreaterThanOrEqualTo(String value) {
            addCriterion("medicalrecordid >=", value, "medicalrecordid");
            return (Criteria) this;
        }

        public Criteria andMedicalrecordidLessThan(String value) {
            addCriterion("medicalrecordid <", value, "medicalrecordid");
            return (Criteria) this;
        }

        public Criteria andMedicalrecordidLessThanOrEqualTo(String value) {
            addCriterion("medicalrecordid <=", value, "medicalrecordid");
            return (Criteria) this;
        }

        public Criteria andMedicalrecordidLike(String value) {
            addCriterion("medicalrecordid like", value, "medicalrecordid");
            return (Criteria) this;
        }

        public Criteria andMedicalrecordidNotLike(String value) {
            addCriterion("medicalrecordid not like", value, "medicalrecordid");
            return (Criteria) this;
        }

        public Criteria andMedicalrecordidIn(List<String> values) {
            addCriterion("medicalrecordid in", values, "medicalrecordid");
            return (Criteria) this;
        }

        public Criteria andMedicalrecordidNotIn(List<String> values) {
            addCriterion("medicalrecordid not in", values, "medicalrecordid");
            return (Criteria) this;
        }

        public Criteria andMedicalrecordidBetween(String value1, String value2) {
            addCriterion("medicalrecordid between", value1, value2, "medicalrecordid");
            return (Criteria) this;
        }

        public Criteria andMedicalrecordidNotBetween(String value1, String value2) {
            addCriterion("medicalrecordid not between", value1, value2, "medicalrecordid");
            return (Criteria) this;
        }

        public Criteria andDoctoridIsNull() {
            addCriterion("doctorid is null");
            return (Criteria) this;
        }

        public Criteria andDoctoridIsNotNull() {
            addCriterion("doctorid is not null");
            return (Criteria) this;
        }

        public Criteria andDoctoridEqualTo(Integer value) {
            addCriterion("doctorid =", value, "doctorid");
            return (Criteria) this;
        }

        public Criteria andDoctoridNotEqualTo(Integer value) {
            addCriterion("doctorid <>", value, "doctorid");
            return (Criteria) this;
        }

        public Criteria andDoctoridGreaterThan(Integer value) {
            addCriterion("doctorid >", value, "doctorid");
            return (Criteria) this;
        }

        public Criteria andDoctoridGreaterThanOrEqualTo(Integer value) {
            addCriterion("doctorid >=", value, "doctorid");
            return (Criteria) this;
        }

        public Criteria andDoctoridLessThan(Integer value) {
            addCriterion("doctorid <", value, "doctorid");
            return (Criteria) this;
        }

        public Criteria andDoctoridLessThanOrEqualTo(Integer value) {
            addCriterion("doctorid <=", value, "doctorid");
            return (Criteria) this;
        }

        public Criteria andDoctoridIn(List<Integer> values) {
            addCriterion("doctorid in", values, "doctorid");
            return (Criteria) this;
        }

        public Criteria andDoctoridNotIn(List<Integer> values) {
            addCriterion("doctorid not in", values, "doctorid");
            return (Criteria) this;
        }

        public Criteria andDoctoridBetween(Integer value1, Integer value2) {
            addCriterion("doctorid between", value1, value2, "doctorid");
            return (Criteria) this;
        }

        public Criteria andDoctoridNotBetween(Integer value1, Integer value2) {
            addCriterion("doctorid not between", value1, value2, "doctorid");
            return (Criteria) this;
        }

        public Criteria andGetmedicalflagIsNull() {
            addCriterion("getmedicalflag is null");
            return (Criteria) this;
        }

        public Criteria andGetmedicalflagIsNotNull() {
            addCriterion("getmedicalflag is not null");
            return (Criteria) this;
        }

        public Criteria andGetmedicalflagEqualTo(Integer value) {
            addCriterion("getmedicalflag =", value, "getmedicalflag");
            return (Criteria) this;
        }

        public Criteria andGetmedicalflagNotEqualTo(Integer value) {
            addCriterion("getmedicalflag <>", value, "getmedicalflag");
            return (Criteria) this;
        }

        public Criteria andGetmedicalflagGreaterThan(Integer value) {
            addCriterion("getmedicalflag >", value, "getmedicalflag");
            return (Criteria) this;
        }

        public Criteria andGetmedicalflagGreaterThanOrEqualTo(Integer value) {
            addCriterion("getmedicalflag >=", value, "getmedicalflag");
            return (Criteria) this;
        }

        public Criteria andGetmedicalflagLessThan(Integer value) {
            addCriterion("getmedicalflag <", value, "getmedicalflag");
            return (Criteria) this;
        }

        public Criteria andGetmedicalflagLessThanOrEqualTo(Integer value) {
            addCriterion("getmedicalflag <=", value, "getmedicalflag");
            return (Criteria) this;
        }

        public Criteria andGetmedicalflagIn(List<Integer> values) {
            addCriterion("getmedicalflag in", values, "getmedicalflag");
            return (Criteria) this;
        }

        public Criteria andGetmedicalflagNotIn(List<Integer> values) {
            addCriterion("getmedicalflag not in", values, "getmedicalflag");
            return (Criteria) this;
        }

        public Criteria andGetmedicalflagBetween(Integer value1, Integer value2) {
            addCriterion("getmedicalflag between", value1, value2, "getmedicalflag");
            return (Criteria) this;
        }

        public Criteria andGetmedicalflagNotBetween(Integer value1, Integer value2) {
            addCriterion("getmedicalflag not between", value1, value2, "getmedicalflag");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("`type` is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("`type` is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("`type` =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("`type` <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("`type` >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("`type` >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("`type` <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("`type` <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("`type` like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("`type` not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("`type` in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("`type` not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("`type` between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("`type` not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andMedicaltypeIsNull() {
            addCriterion("medicaltype is null");
            return (Criteria) this;
        }

        public Criteria andMedicaltypeIsNotNull() {
            addCriterion("medicaltype is not null");
            return (Criteria) this;
        }

        public Criteria andMedicaltypeEqualTo(String value) {
            addCriterion("medicaltype =", value, "medicaltype");
            return (Criteria) this;
        }

        public Criteria andMedicaltypeNotEqualTo(String value) {
            addCriterion("medicaltype <>", value, "medicaltype");
            return (Criteria) this;
        }

        public Criteria andMedicaltypeGreaterThan(String value) {
            addCriterion("medicaltype >", value, "medicaltype");
            return (Criteria) this;
        }

        public Criteria andMedicaltypeGreaterThanOrEqualTo(String value) {
            addCriterion("medicaltype >=", value, "medicaltype");
            return (Criteria) this;
        }

        public Criteria andMedicaltypeLessThan(String value) {
            addCriterion("medicaltype <", value, "medicaltype");
            return (Criteria) this;
        }

        public Criteria andMedicaltypeLessThanOrEqualTo(String value) {
            addCriterion("medicaltype <=", value, "medicaltype");
            return (Criteria) this;
        }

        public Criteria andMedicaltypeLike(String value) {
            addCriterion("medicaltype like", value, "medicaltype");
            return (Criteria) this;
        }

        public Criteria andMedicaltypeNotLike(String value) {
            addCriterion("medicaltype not like", value, "medicaltype");
            return (Criteria) this;
        }

        public Criteria andMedicaltypeIn(List<String> values) {
            addCriterion("medicaltype in", values, "medicaltype");
            return (Criteria) this;
        }

        public Criteria andMedicaltypeNotIn(List<String> values) {
            addCriterion("medicaltype not in", values, "medicaltype");
            return (Criteria) this;
        }

        public Criteria andMedicaltypeBetween(String value1, String value2) {
            addCriterion("medicaltype between", value1, value2, "medicaltype");
            return (Criteria) this;
        }

        public Criteria andMedicaltypeNotBetween(String value1, String value2) {
            addCriterion("medicaltype not between", value1, value2, "medicaltype");
            return (Criteria) this;
        }

        public Criteria andIsdoneIsNull() {
            addCriterion("isdone is null");
            return (Criteria) this;
        }

        public Criteria andIsdoneIsNotNull() {
            addCriterion("isdone is not null");
            return (Criteria) this;
        }

        public Criteria andIsdoneEqualTo(Integer value) {
            addCriterion("isdone =", value, "isdone");
            return (Criteria) this;
        }

        public Criteria andIsdoneNotEqualTo(Integer value) {
            addCriterion("isdone <>", value, "isdone");
            return (Criteria) this;
        }

        public Criteria andIsdoneGreaterThan(Integer value) {
            addCriterion("isdone >", value, "isdone");
            return (Criteria) this;
        }

        public Criteria andIsdoneGreaterThanOrEqualTo(Integer value) {
            addCriterion("isdone >=", value, "isdone");
            return (Criteria) this;
        }

        public Criteria andIsdoneLessThan(Integer value) {
            addCriterion("isdone <", value, "isdone");
            return (Criteria) this;
        }

        public Criteria andIsdoneLessThanOrEqualTo(Integer value) {
            addCriterion("isdone <=", value, "isdone");
            return (Criteria) this;
        }

        public Criteria andIsdoneIn(List<Integer> values) {
            addCriterion("isdone in", values, "isdone");
            return (Criteria) this;
        }

        public Criteria andIsdoneNotIn(List<Integer> values) {
            addCriterion("isdone not in", values, "isdone");
            return (Criteria) this;
        }

        public Criteria andIsdoneBetween(Integer value1, Integer value2) {
            addCriterion("isdone between", value1, value2, "isdone");
            return (Criteria) this;
        }

        public Criteria andIsdoneNotBetween(Integer value1, Integer value2) {
            addCriterion("isdone not between", value1, value2, "isdone");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNull() {
            addCriterion("money is null");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNotNull() {
            addCriterion("money is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyEqualTo(BigDecimal value) {
            addCriterion("money =", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotEqualTo(BigDecimal value) {
            addCriterion("money <>", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThan(BigDecimal value) {
            addCriterion("money >", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("money >=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThan(BigDecimal value) {
            addCriterion("money <", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("money <=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyIn(List<BigDecimal> values) {
            addCriterion("money in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotIn(List<BigDecimal> values) {
            addCriterion("money not in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("money between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("money not between", value1, value2, "money");
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