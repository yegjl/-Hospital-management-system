package com.neusoft.ssm.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class DispenseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public DispenseExample() {
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

        public Criteria andPatientnameIsNull() {
            addCriterion("patientname is null");
            return (Criteria) this;
        }

        public Criteria andPatientnameIsNotNull() {
            addCriterion("patientname is not null");
            return (Criteria) this;
        }

        public Criteria andPatientnameEqualTo(String value) {
            addCriterion("patientname =", value, "patientname");
            return (Criteria) this;
        }

        public Criteria andPatientnameNotEqualTo(String value) {
            addCriterion("patientname <>", value, "patientname");
            return (Criteria) this;
        }

        public Criteria andPatientnameGreaterThan(String value) {
            addCriterion("patientname >", value, "patientname");
            return (Criteria) this;
        }

        public Criteria andPatientnameGreaterThanOrEqualTo(String value) {
            addCriterion("patientname >=", value, "patientname");
            return (Criteria) this;
        }

        public Criteria andPatientnameLessThan(String value) {
            addCriterion("patientname <", value, "patientname");
            return (Criteria) this;
        }

        public Criteria andPatientnameLessThanOrEqualTo(String value) {
            addCriterion("patientname <=", value, "patientname");
            return (Criteria) this;
        }

        public Criteria andPatientnameLike(String value) {
            addCriterion("patientname like", value, "patientname");
            return (Criteria) this;
        }

        public Criteria andPatientnameNotLike(String value) {
            addCriterion("patientname not like", value, "patientname");
            return (Criteria) this;
        }

        public Criteria andPatientnameIn(List<String> values) {
            addCriterion("patientname in", values, "patientname");
            return (Criteria) this;
        }

        public Criteria andPatientnameNotIn(List<String> values) {
            addCriterion("patientname not in", values, "patientname");
            return (Criteria) this;
        }

        public Criteria andPatientnameBetween(String value1, String value2) {
            addCriterion("patientname between", value1, value2, "patientname");
            return (Criteria) this;
        }

        public Criteria andPatientnameNotBetween(String value1, String value2) {
            addCriterion("patientname not between", value1, value2, "patientname");
            return (Criteria) this;
        }

        public Criteria andDispensestatusIsNull() {
            addCriterion("dispensestatus is null");
            return (Criteria) this;
        }

        public Criteria andDispensestatusIsNotNull() {
            addCriterion("dispensestatus is not null");
            return (Criteria) this;
        }

        public Criteria andDispensestatusEqualTo(Integer value) {
            addCriterion("dispensestatus =", value, "dispensestatus");
            return (Criteria) this;
        }

        public Criteria andDispensestatusNotEqualTo(Integer value) {
            addCriterion("dispensestatus <>", value, "dispensestatus");
            return (Criteria) this;
        }

        public Criteria andDispensestatusGreaterThan(Integer value) {
            addCriterion("dispensestatus >", value, "dispensestatus");
            return (Criteria) this;
        }

        public Criteria andDispensestatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("dispensestatus >=", value, "dispensestatus");
            return (Criteria) this;
        }

        public Criteria andDispensestatusLessThan(Integer value) {
            addCriterion("dispensestatus <", value, "dispensestatus");
            return (Criteria) this;
        }

        public Criteria andDispensestatusLessThanOrEqualTo(Integer value) {
            addCriterion("dispensestatus <=", value, "dispensestatus");
            return (Criteria) this;
        }

        public Criteria andDispensestatusIn(List<Integer> values) {
            addCriterion("dispensestatus in", values, "dispensestatus");
            return (Criteria) this;
        }

        public Criteria andDispensestatusNotIn(List<Integer> values) {
            addCriterion("dispensestatus not in", values, "dispensestatus");
            return (Criteria) this;
        }

        public Criteria andDispensestatusBetween(Integer value1, Integer value2) {
            addCriterion("dispensestatus between", value1, value2, "dispensestatus");
            return (Criteria) this;
        }

        public Criteria andDispensestatusNotBetween(Integer value1, Integer value2) {
            addCriterion("dispensestatus not between", value1, value2, "dispensestatus");
            return (Criteria) this;
        }

        public Criteria andDispensedateIsNull() {
            addCriterion("dispensedate is null");
            return (Criteria) this;
        }

        public Criteria andDispensedateIsNotNull() {
            addCriterion("dispensedate is not null");
            return (Criteria) this;
        }

        public Criteria andDispensedateEqualTo(Date value) {
            addCriterionForJDBCDate("dispensedate =", value, "dispensedate");
            return (Criteria) this;
        }

        public Criteria andDispensedateNotEqualTo(Date value) {
            addCriterionForJDBCDate("dispensedate <>", value, "dispensedate");
            return (Criteria) this;
        }

        public Criteria andDispensedateGreaterThan(Date value) {
            addCriterionForJDBCDate("dispensedate >", value, "dispensedate");
            return (Criteria) this;
        }

        public Criteria andDispensedateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dispensedate >=", value, "dispensedate");
            return (Criteria) this;
        }

        public Criteria andDispensedateLessThan(Date value) {
            addCriterionForJDBCDate("dispensedate <", value, "dispensedate");
            return (Criteria) this;
        }

        public Criteria andDispensedateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dispensedate <=", value, "dispensedate");
            return (Criteria) this;
        }

        public Criteria andDispensedateIn(List<Date> values) {
            addCriterionForJDBCDate("dispensedate in", values, "dispensedate");
            return (Criteria) this;
        }

        public Criteria andDispensedateNotIn(List<Date> values) {
            addCriterionForJDBCDate("dispensedate not in", values, "dispensedate");
            return (Criteria) this;
        }

        public Criteria andDispensedateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dispensedate between", value1, value2, "dispensedate");
            return (Criteria) this;
        }

        public Criteria andDispensedateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dispensedate not between", value1, value2, "dispensedate");
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