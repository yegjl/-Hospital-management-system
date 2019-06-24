package com.neusoft.ssm.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PrescribemodellogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public PrescribemodellogExample() {
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

        public Criteria andPrescribemodelidIsNull() {
            addCriterion("prescribemodelid is null");
            return (Criteria) this;
        }

        public Criteria andPrescribemodelidIsNotNull() {
            addCriterion("prescribemodelid is not null");
            return (Criteria) this;
        }

        public Criteria andPrescribemodelidEqualTo(Integer value) {
            addCriterion("prescribemodelid =", value, "prescribemodelid");
            return (Criteria) this;
        }

        public Criteria andPrescribemodelidNotEqualTo(Integer value) {
            addCriterion("prescribemodelid <>", value, "prescribemodelid");
            return (Criteria) this;
        }

        public Criteria andPrescribemodelidGreaterThan(Integer value) {
            addCriterion("prescribemodelid >", value, "prescribemodelid");
            return (Criteria) this;
        }

        public Criteria andPrescribemodelidGreaterThanOrEqualTo(Integer value) {
            addCriterion("prescribemodelid >=", value, "prescribemodelid");
            return (Criteria) this;
        }

        public Criteria andPrescribemodelidLessThan(Integer value) {
            addCriterion("prescribemodelid <", value, "prescribemodelid");
            return (Criteria) this;
        }

        public Criteria andPrescribemodelidLessThanOrEqualTo(Integer value) {
            addCriterion("prescribemodelid <=", value, "prescribemodelid");
            return (Criteria) this;
        }

        public Criteria andPrescribemodelidIn(List<Integer> values) {
            addCriterion("prescribemodelid in", values, "prescribemodelid");
            return (Criteria) this;
        }

        public Criteria andPrescribemodelidNotIn(List<Integer> values) {
            addCriterion("prescribemodelid not in", values, "prescribemodelid");
            return (Criteria) this;
        }

        public Criteria andPrescribemodelidBetween(Integer value1, Integer value2) {
            addCriterion("prescribemodelid between", value1, value2, "prescribemodelid");
            return (Criteria) this;
        }

        public Criteria andPrescribemodelidNotBetween(Integer value1, Integer value2) {
            addCriterion("prescribemodelid not between", value1, value2, "prescribemodelid");
            return (Criteria) this;
        }

        public Criteria andMedicalnameIsNull() {
            addCriterion("medicalname is null");
            return (Criteria) this;
        }

        public Criteria andMedicalnameIsNotNull() {
            addCriterion("medicalname is not null");
            return (Criteria) this;
        }

        public Criteria andMedicalnameEqualTo(String value) {
            addCriterion("medicalname =", value, "medicalname");
            return (Criteria) this;
        }

        public Criteria andMedicalnameNotEqualTo(String value) {
            addCriterion("medicalname <>", value, "medicalname");
            return (Criteria) this;
        }

        public Criteria andMedicalnameGreaterThan(String value) {
            addCriterion("medicalname >", value, "medicalname");
            return (Criteria) this;
        }

        public Criteria andMedicalnameGreaterThanOrEqualTo(String value) {
            addCriterion("medicalname >=", value, "medicalname");
            return (Criteria) this;
        }

        public Criteria andMedicalnameLessThan(String value) {
            addCriterion("medicalname <", value, "medicalname");
            return (Criteria) this;
        }

        public Criteria andMedicalnameLessThanOrEqualTo(String value) {
            addCriterion("medicalname <=", value, "medicalname");
            return (Criteria) this;
        }

        public Criteria andMedicalnameLike(String value) {
            addCriterion("medicalname like", value, "medicalname");
            return (Criteria) this;
        }

        public Criteria andMedicalnameNotLike(String value) {
            addCriterion("medicalname not like", value, "medicalname");
            return (Criteria) this;
        }

        public Criteria andMedicalnameIn(List<String> values) {
            addCriterion("medicalname in", values, "medicalname");
            return (Criteria) this;
        }

        public Criteria andMedicalnameNotIn(List<String> values) {
            addCriterion("medicalname not in", values, "medicalname");
            return (Criteria) this;
        }

        public Criteria andMedicalnameBetween(String value1, String value2) {
            addCriterion("medicalname between", value1, value2, "medicalname");
            return (Criteria) this;
        }

        public Criteria andMedicalnameNotBetween(String value1, String value2) {
            addCriterion("medicalname not between", value1, value2, "medicalname");
            return (Criteria) this;
        }

        public Criteria andFormatIsNull() {
            addCriterion("format is null");
            return (Criteria) this;
        }

        public Criteria andFormatIsNotNull() {
            addCriterion("format is not null");
            return (Criteria) this;
        }

        public Criteria andFormatEqualTo(String value) {
            addCriterion("format =", value, "format");
            return (Criteria) this;
        }

        public Criteria andFormatNotEqualTo(String value) {
            addCriterion("format <>", value, "format");
            return (Criteria) this;
        }

        public Criteria andFormatGreaterThan(String value) {
            addCriterion("format >", value, "format");
            return (Criteria) this;
        }

        public Criteria andFormatGreaterThanOrEqualTo(String value) {
            addCriterion("format >=", value, "format");
            return (Criteria) this;
        }

        public Criteria andFormatLessThan(String value) {
            addCriterion("format <", value, "format");
            return (Criteria) this;
        }

        public Criteria andFormatLessThanOrEqualTo(String value) {
            addCriterion("format <=", value, "format");
            return (Criteria) this;
        }

        public Criteria andFormatLike(String value) {
            addCriterion("format like", value, "format");
            return (Criteria) this;
        }

        public Criteria andFormatNotLike(String value) {
            addCriterion("format not like", value, "format");
            return (Criteria) this;
        }

        public Criteria andFormatIn(List<String> values) {
            addCriterion("format in", values, "format");
            return (Criteria) this;
        }

        public Criteria andFormatNotIn(List<String> values) {
            addCriterion("format not in", values, "format");
            return (Criteria) this;
        }

        public Criteria andFormatBetween(String value1, String value2) {
            addCriterion("format between", value1, value2, "format");
            return (Criteria) this;
        }

        public Criteria andFormatNotBetween(String value1, String value2) {
            addCriterion("format not between", value1, value2, "format");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
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

        public Criteria andDosageIsNull() {
            addCriterion("dosage is null");
            return (Criteria) this;
        }

        public Criteria andDosageIsNotNull() {
            addCriterion("dosage is not null");
            return (Criteria) this;
        }

        public Criteria andDosageEqualTo(String value) {
            addCriterion("dosage =", value, "dosage");
            return (Criteria) this;
        }

        public Criteria andDosageNotEqualTo(String value) {
            addCriterion("dosage <>", value, "dosage");
            return (Criteria) this;
        }

        public Criteria andDosageGreaterThan(String value) {
            addCriterion("dosage >", value, "dosage");
            return (Criteria) this;
        }

        public Criteria andDosageGreaterThanOrEqualTo(String value) {
            addCriterion("dosage >=", value, "dosage");
            return (Criteria) this;
        }

        public Criteria andDosageLessThan(String value) {
            addCriterion("dosage <", value, "dosage");
            return (Criteria) this;
        }

        public Criteria andDosageLessThanOrEqualTo(String value) {
            addCriterion("dosage <=", value, "dosage");
            return (Criteria) this;
        }

        public Criteria andDosageLike(String value) {
            addCriterion("dosage like", value, "dosage");
            return (Criteria) this;
        }

        public Criteria andDosageNotLike(String value) {
            addCriterion("dosage not like", value, "dosage");
            return (Criteria) this;
        }

        public Criteria andDosageIn(List<String> values) {
            addCriterion("dosage in", values, "dosage");
            return (Criteria) this;
        }

        public Criteria andDosageNotIn(List<String> values) {
            addCriterion("dosage not in", values, "dosage");
            return (Criteria) this;
        }

        public Criteria andDosageBetween(String value1, String value2) {
            addCriterion("dosage between", value1, value2, "dosage");
            return (Criteria) this;
        }

        public Criteria andDosageNotBetween(String value1, String value2) {
            addCriterion("dosage not between", value1, value2, "dosage");
            return (Criteria) this;
        }

        public Criteria andUnitIsNull() {
            addCriterion("unit is null");
            return (Criteria) this;
        }

        public Criteria andUnitIsNotNull() {
            addCriterion("unit is not null");
            return (Criteria) this;
        }

        public Criteria andUnitEqualTo(String value) {
            addCriterion("unit =", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotEqualTo(String value) {
            addCriterion("unit <>", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThan(String value) {
            addCriterion("unit >", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThanOrEqualTo(String value) {
            addCriterion("unit >=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThan(String value) {
            addCriterion("unit <", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThanOrEqualTo(String value) {
            addCriterion("unit <=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLike(String value) {
            addCriterion("unit like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotLike(String value) {
            addCriterion("unit not like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitIn(List<String> values) {
            addCriterion("unit in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotIn(List<String> values) {
            addCriterion("unit not in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitBetween(String value1, String value2) {
            addCriterion("unit between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotBetween(String value1, String value2) {
            addCriterion("unit not between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andTimesIsNull() {
            addCriterion("times is null");
            return (Criteria) this;
        }

        public Criteria andTimesIsNotNull() {
            addCriterion("times is not null");
            return (Criteria) this;
        }

        public Criteria andTimesEqualTo(String value) {
            addCriterion("times =", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesNotEqualTo(String value) {
            addCriterion("times <>", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesGreaterThan(String value) {
            addCriterion("times >", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesGreaterThanOrEqualTo(String value) {
            addCriterion("times >=", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesLessThan(String value) {
            addCriterion("times <", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesLessThanOrEqualTo(String value) {
            addCriterion("times <=", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesLike(String value) {
            addCriterion("times like", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesNotLike(String value) {
            addCriterion("times not like", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesIn(List<String> values) {
            addCriterion("times in", values, "times");
            return (Criteria) this;
        }

        public Criteria andTimesNotIn(List<String> values) {
            addCriterion("times not in", values, "times");
            return (Criteria) this;
        }

        public Criteria andTimesBetween(String value1, String value2) {
            addCriterion("times between", value1, value2, "times");
            return (Criteria) this;
        }

        public Criteria andTimesNotBetween(String value1, String value2) {
            addCriterion("times not between", value1, value2, "times");
            return (Criteria) this;
        }

        public Criteria andEntrustIsNull() {
            addCriterion("entrust is null");
            return (Criteria) this;
        }

        public Criteria andEntrustIsNotNull() {
            addCriterion("entrust is not null");
            return (Criteria) this;
        }

        public Criteria andEntrustEqualTo(String value) {
            addCriterion("entrust =", value, "entrust");
            return (Criteria) this;
        }

        public Criteria andEntrustNotEqualTo(String value) {
            addCriterion("entrust <>", value, "entrust");
            return (Criteria) this;
        }

        public Criteria andEntrustGreaterThan(String value) {
            addCriterion("entrust >", value, "entrust");
            return (Criteria) this;
        }

        public Criteria andEntrustGreaterThanOrEqualTo(String value) {
            addCriterion("entrust >=", value, "entrust");
            return (Criteria) this;
        }

        public Criteria andEntrustLessThan(String value) {
            addCriterion("entrust <", value, "entrust");
            return (Criteria) this;
        }

        public Criteria andEntrustLessThanOrEqualTo(String value) {
            addCriterion("entrust <=", value, "entrust");
            return (Criteria) this;
        }

        public Criteria andEntrustLike(String value) {
            addCriterion("entrust like", value, "entrust");
            return (Criteria) this;
        }

        public Criteria andEntrustNotLike(String value) {
            addCriterion("entrust not like", value, "entrust");
            return (Criteria) this;
        }

        public Criteria andEntrustIn(List<String> values) {
            addCriterion("entrust in", values, "entrust");
            return (Criteria) this;
        }

        public Criteria andEntrustNotIn(List<String> values) {
            addCriterion("entrust not in", values, "entrust");
            return (Criteria) this;
        }

        public Criteria andEntrustBetween(String value1, String value2) {
            addCriterion("entrust between", value1, value2, "entrust");
            return (Criteria) this;
        }

        public Criteria andEntrustNotBetween(String value1, String value2) {
            addCriterion("entrust not between", value1, value2, "entrust");
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