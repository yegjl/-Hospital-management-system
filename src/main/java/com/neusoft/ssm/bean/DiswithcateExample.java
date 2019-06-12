package com.neusoft.ssm.bean;

import java.util.ArrayList;
import java.util.List;

public class DiswithcateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public DiswithcateExample() {
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

        public Criteria andDiseaseicdIsNull() {
            addCriterion("DiseaseICD is null");
            return (Criteria) this;
        }

        public Criteria andDiseaseicdIsNotNull() {
            addCriterion("DiseaseICD is not null");
            return (Criteria) this;
        }

        public Criteria andDiseaseicdEqualTo(String value) {
            addCriterion("DiseaseICD =", value, "diseaseicd");
            return (Criteria) this;
        }

        public Criteria andDiseaseicdNotEqualTo(String value) {
            addCriterion("DiseaseICD <>", value, "diseaseicd");
            return (Criteria) this;
        }

        public Criteria andDiseaseicdGreaterThan(String value) {
            addCriterion("DiseaseICD >", value, "diseaseicd");
            return (Criteria) this;
        }

        public Criteria andDiseaseicdGreaterThanOrEqualTo(String value) {
            addCriterion("DiseaseICD >=", value, "diseaseicd");
            return (Criteria) this;
        }

        public Criteria andDiseaseicdLessThan(String value) {
            addCriterion("DiseaseICD <", value, "diseaseicd");
            return (Criteria) this;
        }

        public Criteria andDiseaseicdLessThanOrEqualTo(String value) {
            addCriterion("DiseaseICD <=", value, "diseaseicd");
            return (Criteria) this;
        }

        public Criteria andDiseaseicdLike(String value) {
            addCriterion("DiseaseICD like", value, "diseaseicd");
            return (Criteria) this;
        }

        public Criteria andDiseaseicdNotLike(String value) {
            addCriterion("DiseaseICD not like", value, "diseaseicd");
            return (Criteria) this;
        }

        public Criteria andDiseaseicdIn(List<String> values) {
            addCriterion("DiseaseICD in", values, "diseaseicd");
            return (Criteria) this;
        }

        public Criteria andDiseaseicdNotIn(List<String> values) {
            addCriterion("DiseaseICD not in", values, "diseaseicd");
            return (Criteria) this;
        }

        public Criteria andDiseaseicdBetween(String value1, String value2) {
            addCriterion("DiseaseICD between", value1, value2, "diseaseicd");
            return (Criteria) this;
        }

        public Criteria andDiseaseicdNotBetween(String value1, String value2) {
            addCriterion("DiseaseICD not between", value1, value2, "diseaseicd");
            return (Criteria) this;
        }

        public Criteria andDiseasenameIsNull() {
            addCriterion("DiseaseName is null");
            return (Criteria) this;
        }

        public Criteria andDiseasenameIsNotNull() {
            addCriterion("DiseaseName is not null");
            return (Criteria) this;
        }

        public Criteria andDiseasenameEqualTo(String value) {
            addCriterion("DiseaseName =", value, "diseasename");
            return (Criteria) this;
        }

        public Criteria andDiseasenameNotEqualTo(String value) {
            addCriterion("DiseaseName <>", value, "diseasename");
            return (Criteria) this;
        }

        public Criteria andDiseasenameGreaterThan(String value) {
            addCriterion("DiseaseName >", value, "diseasename");
            return (Criteria) this;
        }

        public Criteria andDiseasenameGreaterThanOrEqualTo(String value) {
            addCriterion("DiseaseName >=", value, "diseasename");
            return (Criteria) this;
        }

        public Criteria andDiseasenameLessThan(String value) {
            addCriterion("DiseaseName <", value, "diseasename");
            return (Criteria) this;
        }

        public Criteria andDiseasenameLessThanOrEqualTo(String value) {
            addCriterion("DiseaseName <=", value, "diseasename");
            return (Criteria) this;
        }

        public Criteria andDiseasenameLike(String value) {
            addCriterion("DiseaseName like", value, "diseasename");
            return (Criteria) this;
        }

        public Criteria andDiseasenameNotLike(String value) {
            addCriterion("DiseaseName not like", value, "diseasename");
            return (Criteria) this;
        }

        public Criteria andDiseasenameIn(List<String> values) {
            addCriterion("DiseaseName in", values, "diseasename");
            return (Criteria) this;
        }

        public Criteria andDiseasenameNotIn(List<String> values) {
            addCriterion("DiseaseName not in", values, "diseasename");
            return (Criteria) this;
        }

        public Criteria andDiseasenameBetween(String value1, String value2) {
            addCriterion("DiseaseName between", value1, value2, "diseasename");
            return (Criteria) this;
        }

        public Criteria andDiseasenameNotBetween(String value1, String value2) {
            addCriterion("DiseaseName not between", value1, value2, "diseasename");
            return (Criteria) this;
        }

        public Criteria andDiseasecodeIsNull() {
            addCriterion("DiseaseCode is null");
            return (Criteria) this;
        }

        public Criteria andDiseasecodeIsNotNull() {
            addCriterion("DiseaseCode is not null");
            return (Criteria) this;
        }

        public Criteria andDiseasecodeEqualTo(String value) {
            addCriterion("DiseaseCode =", value, "diseasecode");
            return (Criteria) this;
        }

        public Criteria andDiseasecodeNotEqualTo(String value) {
            addCriterion("DiseaseCode <>", value, "diseasecode");
            return (Criteria) this;
        }

        public Criteria andDiseasecodeGreaterThan(String value) {
            addCriterion("DiseaseCode >", value, "diseasecode");
            return (Criteria) this;
        }

        public Criteria andDiseasecodeGreaterThanOrEqualTo(String value) {
            addCriterion("DiseaseCode >=", value, "diseasecode");
            return (Criteria) this;
        }

        public Criteria andDiseasecodeLessThan(String value) {
            addCriterion("DiseaseCode <", value, "diseasecode");
            return (Criteria) this;
        }

        public Criteria andDiseasecodeLessThanOrEqualTo(String value) {
            addCriterion("DiseaseCode <=", value, "diseasecode");
            return (Criteria) this;
        }

        public Criteria andDiseasecodeLike(String value) {
            addCriterion("DiseaseCode like", value, "diseasecode");
            return (Criteria) this;
        }

        public Criteria andDiseasecodeNotLike(String value) {
            addCriterion("DiseaseCode not like", value, "diseasecode");
            return (Criteria) this;
        }

        public Criteria andDiseasecodeIn(List<String> values) {
            addCriterion("DiseaseCode in", values, "diseasecode");
            return (Criteria) this;
        }

        public Criteria andDiseasecodeNotIn(List<String> values) {
            addCriterion("DiseaseCode not in", values, "diseasecode");
            return (Criteria) this;
        }

        public Criteria andDiseasecodeBetween(String value1, String value2) {
            addCriterion("DiseaseCode between", value1, value2, "diseasecode");
            return (Criteria) this;
        }

        public Criteria andDiseasecodeNotBetween(String value1, String value2) {
            addCriterion("DiseaseCode not between", value1, value2, "diseasecode");
            return (Criteria) this;
        }

        public Criteria andDicanameIsNull() {
            addCriterion("DicaName is null");
            return (Criteria) this;
        }

        public Criteria andDicanameIsNotNull() {
            addCriterion("DicaName is not null");
            return (Criteria) this;
        }

        public Criteria andDicanameEqualTo(String value) {
            addCriterion("DicaName =", value, "dicaname");
            return (Criteria) this;
        }

        public Criteria andDicanameNotEqualTo(String value) {
            addCriterion("DicaName <>", value, "dicaname");
            return (Criteria) this;
        }

        public Criteria andDicanameGreaterThan(String value) {
            addCriterion("DicaName >", value, "dicaname");
            return (Criteria) this;
        }

        public Criteria andDicanameGreaterThanOrEqualTo(String value) {
            addCriterion("DicaName >=", value, "dicaname");
            return (Criteria) this;
        }

        public Criteria andDicanameLessThan(String value) {
            addCriterion("DicaName <", value, "dicaname");
            return (Criteria) this;
        }

        public Criteria andDicanameLessThanOrEqualTo(String value) {
            addCriterion("DicaName <=", value, "dicaname");
            return (Criteria) this;
        }

        public Criteria andDicanameLike(String value) {
            addCriterion("DicaName like", value, "dicaname");
            return (Criteria) this;
        }

        public Criteria andDicanameNotLike(String value) {
            addCriterion("DicaName not like", value, "dicaname");
            return (Criteria) this;
        }

        public Criteria andDicanameIn(List<String> values) {
            addCriterion("DicaName in", values, "dicaname");
            return (Criteria) this;
        }

        public Criteria andDicanameNotIn(List<String> values) {
            addCriterion("DicaName not in", values, "dicaname");
            return (Criteria) this;
        }

        public Criteria andDicanameBetween(String value1, String value2) {
            addCriterion("DicaName between", value1, value2, "dicaname");
            return (Criteria) this;
        }

        public Criteria andDicanameNotBetween(String value1, String value2) {
            addCriterion("DicaName not between", value1, value2, "dicaname");
            return (Criteria) this;
        }

        public Criteria andIcdidIsNull() {
            addCriterion("ICDID is null");
            return (Criteria) this;
        }

        public Criteria andIcdidIsNotNull() {
            addCriterion("ICDID is not null");
            return (Criteria) this;
        }

        public Criteria andIcdidEqualTo(String value) {
            addCriterion("ICDID =", value, "icdid");
            return (Criteria) this;
        }

        public Criteria andIcdidNotEqualTo(String value) {
            addCriterion("ICDID <>", value, "icdid");
            return (Criteria) this;
        }

        public Criteria andIcdidGreaterThan(String value) {
            addCriterion("ICDID >", value, "icdid");
            return (Criteria) this;
        }

        public Criteria andIcdidGreaterThanOrEqualTo(String value) {
            addCriterion("ICDID >=", value, "icdid");
            return (Criteria) this;
        }

        public Criteria andIcdidLessThan(String value) {
            addCriterion("ICDID <", value, "icdid");
            return (Criteria) this;
        }

        public Criteria andIcdidLessThanOrEqualTo(String value) {
            addCriterion("ICDID <=", value, "icdid");
            return (Criteria) this;
        }

        public Criteria andIcdidLike(String value) {
            addCriterion("ICDID like", value, "icdid");
            return (Criteria) this;
        }

        public Criteria andIcdidNotLike(String value) {
            addCriterion("ICDID not like", value, "icdid");
            return (Criteria) this;
        }

        public Criteria andIcdidIn(List<String> values) {
            addCriterion("ICDID in", values, "icdid");
            return (Criteria) this;
        }

        public Criteria andIcdidNotIn(List<String> values) {
            addCriterion("ICDID not in", values, "icdid");
            return (Criteria) this;
        }

        public Criteria andIcdidBetween(String value1, String value2) {
            addCriterion("ICDID between", value1, value2, "icdid");
            return (Criteria) this;
        }

        public Criteria andIcdidNotBetween(String value1, String value2) {
            addCriterion("ICDID not between", value1, value2, "icdid");
            return (Criteria) this;
        }

        public Criteria andDisecategoryidIsNull() {
            addCriterion("DiseCategoryID is null");
            return (Criteria) this;
        }

        public Criteria andDisecategoryidIsNotNull() {
            addCriterion("DiseCategoryID is not null");
            return (Criteria) this;
        }

        public Criteria andDisecategoryidEqualTo(String value) {
            addCriterion("DiseCategoryID =", value, "disecategoryid");
            return (Criteria) this;
        }

        public Criteria andDisecategoryidNotEqualTo(String value) {
            addCriterion("DiseCategoryID <>", value, "disecategoryid");
            return (Criteria) this;
        }

        public Criteria andDisecategoryidGreaterThan(String value) {
            addCriterion("DiseCategoryID >", value, "disecategoryid");
            return (Criteria) this;
        }

        public Criteria andDisecategoryidGreaterThanOrEqualTo(String value) {
            addCriterion("DiseCategoryID >=", value, "disecategoryid");
            return (Criteria) this;
        }

        public Criteria andDisecategoryidLessThan(String value) {
            addCriterion("DiseCategoryID <", value, "disecategoryid");
            return (Criteria) this;
        }

        public Criteria andDisecategoryidLessThanOrEqualTo(String value) {
            addCriterion("DiseCategoryID <=", value, "disecategoryid");
            return (Criteria) this;
        }

        public Criteria andDisecategoryidLike(String value) {
            addCriterion("DiseCategoryID like", value, "disecategoryid");
            return (Criteria) this;
        }

        public Criteria andDisecategoryidNotLike(String value) {
            addCriterion("DiseCategoryID not like", value, "disecategoryid");
            return (Criteria) this;
        }

        public Criteria andDisecategoryidIn(List<String> values) {
            addCriterion("DiseCategoryID in", values, "disecategoryid");
            return (Criteria) this;
        }

        public Criteria andDisecategoryidNotIn(List<String> values) {
            addCriterion("DiseCategoryID not in", values, "disecategoryid");
            return (Criteria) this;
        }

        public Criteria andDisecategoryidBetween(String value1, String value2) {
            addCriterion("DiseCategoryID between", value1, value2, "disecategoryid");
            return (Criteria) this;
        }

        public Criteria andDisecategoryidNotBetween(String value1, String value2) {
            addCriterion("DiseCategoryID not between", value1, value2, "disecategoryid");
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