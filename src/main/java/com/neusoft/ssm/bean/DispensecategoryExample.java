package com.neusoft.ssm.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DispensecategoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public DispensecategoryExample() {
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

        public Criteria andMedicalrecordnoIsNull() {
            addCriterion("medicalrecordno is null");
            return (Criteria) this;
        }

        public Criteria andMedicalrecordnoIsNotNull() {
            addCriterion("medicalrecordno is not null");
            return (Criteria) this;
        }

        public Criteria andMedicalrecordnoEqualTo(String value) {
            addCriterion("medicalrecordno =", value, "medicalrecordno");
            return (Criteria) this;
        }

        public Criteria andMedicalrecordnoNotEqualTo(String value) {
            addCriterion("medicalrecordno <>", value, "medicalrecordno");
            return (Criteria) this;
        }

        public Criteria andMedicalrecordnoGreaterThan(String value) {
            addCriterion("medicalrecordno >", value, "medicalrecordno");
            return (Criteria) this;
        }

        public Criteria andMedicalrecordnoGreaterThanOrEqualTo(String value) {
            addCriterion("medicalrecordno >=", value, "medicalrecordno");
            return (Criteria) this;
        }

        public Criteria andMedicalrecordnoLessThan(String value) {
            addCriterion("medicalrecordno <", value, "medicalrecordno");
            return (Criteria) this;
        }

        public Criteria andMedicalrecordnoLessThanOrEqualTo(String value) {
            addCriterion("medicalrecordno <=", value, "medicalrecordno");
            return (Criteria) this;
        }

        public Criteria andMedicalrecordnoLike(String value) {
            addCriterion("medicalrecordno like", value, "medicalrecordno");
            return (Criteria) this;
        }

        public Criteria andMedicalrecordnoNotLike(String value) {
            addCriterion("medicalrecordno not like", value, "medicalrecordno");
            return (Criteria) this;
        }

        public Criteria andMedicalrecordnoIn(List<String> values) {
            addCriterion("medicalrecordno in", values, "medicalrecordno");
            return (Criteria) this;
        }

        public Criteria andMedicalrecordnoNotIn(List<String> values) {
            addCriterion("medicalrecordno not in", values, "medicalrecordno");
            return (Criteria) this;
        }

        public Criteria andMedicalrecordnoBetween(String value1, String value2) {
            addCriterion("medicalrecordno between", value1, value2, "medicalrecordno");
            return (Criteria) this;
        }

        public Criteria andMedicalrecordnoNotBetween(String value1, String value2) {
            addCriterion("medicalrecordno not between", value1, value2, "medicalrecordno");
            return (Criteria) this;
        }

        public Criteria andMedicineidIsNull() {
            addCriterion("medicineid is null");
            return (Criteria) this;
        }

        public Criteria andMedicineidIsNotNull() {
            addCriterion("medicineid is not null");
            return (Criteria) this;
        }

        public Criteria andMedicineidEqualTo(Integer value) {
            addCriterion("medicineid =", value, "medicineid");
            return (Criteria) this;
        }

        public Criteria andMedicineidNotEqualTo(Integer value) {
            addCriterion("medicineid <>", value, "medicineid");
            return (Criteria) this;
        }

        public Criteria andMedicineidGreaterThan(Integer value) {
            addCriterion("medicineid >", value, "medicineid");
            return (Criteria) this;
        }

        public Criteria andMedicineidGreaterThanOrEqualTo(Integer value) {
            addCriterion("medicineid >=", value, "medicineid");
            return (Criteria) this;
        }

        public Criteria andMedicineidLessThan(Integer value) {
            addCriterion("medicineid <", value, "medicineid");
            return (Criteria) this;
        }

        public Criteria andMedicineidLessThanOrEqualTo(Integer value) {
            addCriterion("medicineid <=", value, "medicineid");
            return (Criteria) this;
        }

        public Criteria andMedicineidIn(List<Integer> values) {
            addCriterion("medicineid in", values, "medicineid");
            return (Criteria) this;
        }

        public Criteria andMedicineidNotIn(List<Integer> values) {
            addCriterion("medicineid not in", values, "medicineid");
            return (Criteria) this;
        }

        public Criteria andMedicineidBetween(Integer value1, Integer value2) {
            addCriterion("medicineid between", value1, value2, "medicineid");
            return (Criteria) this;
        }

        public Criteria andMedicineidNotBetween(Integer value1, Integer value2) {
            addCriterion("medicineid not between", value1, value2, "medicineid");
            return (Criteria) this;
        }

        public Criteria andMedicinenameIsNull() {
            addCriterion("medicinename is null");
            return (Criteria) this;
        }

        public Criteria andMedicinenameIsNotNull() {
            addCriterion("medicinename is not null");
            return (Criteria) this;
        }

        public Criteria andMedicinenameEqualTo(String value) {
            addCriterion("medicinename =", value, "medicinename");
            return (Criteria) this;
        }

        public Criteria andMedicinenameNotEqualTo(String value) {
            addCriterion("medicinename <>", value, "medicinename");
            return (Criteria) this;
        }

        public Criteria andMedicinenameGreaterThan(String value) {
            addCriterion("medicinename >", value, "medicinename");
            return (Criteria) this;
        }

        public Criteria andMedicinenameGreaterThanOrEqualTo(String value) {
            addCriterion("medicinename >=", value, "medicinename");
            return (Criteria) this;
        }

        public Criteria andMedicinenameLessThan(String value) {
            addCriterion("medicinename <", value, "medicinename");
            return (Criteria) this;
        }

        public Criteria andMedicinenameLessThanOrEqualTo(String value) {
            addCriterion("medicinename <=", value, "medicinename");
            return (Criteria) this;
        }

        public Criteria andMedicinenameLike(String value) {
            addCriterion("medicinename like", value, "medicinename");
            return (Criteria) this;
        }

        public Criteria andMedicinenameNotLike(String value) {
            addCriterion("medicinename not like", value, "medicinename");
            return (Criteria) this;
        }

        public Criteria andMedicinenameIn(List<String> values) {
            addCriterion("medicinename in", values, "medicinename");
            return (Criteria) this;
        }

        public Criteria andMedicinenameNotIn(List<String> values) {
            addCriterion("medicinename not in", values, "medicinename");
            return (Criteria) this;
        }

        public Criteria andMedicinenameBetween(String value1, String value2) {
            addCriterion("medicinename between", value1, value2, "medicinename");
            return (Criteria) this;
        }

        public Criteria andMedicinenameNotBetween(String value1, String value2) {
            addCriterion("medicinename not between", value1, value2, "medicinename");
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

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(Integer value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(Integer value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(Integer value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(Integer value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(Integer value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<Integer> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<Integer> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(Integer value1, Integer value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("amount not between", value1, value2, "amount");
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

        public Criteria andManufacturerIsNull() {
            addCriterion("manufacturer is null");
            return (Criteria) this;
        }

        public Criteria andManufacturerIsNotNull() {
            addCriterion("manufacturer is not null");
            return (Criteria) this;
        }

        public Criteria andManufacturerEqualTo(String value) {
            addCriterion("manufacturer =", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotEqualTo(String value) {
            addCriterion("manufacturer <>", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerGreaterThan(String value) {
            addCriterion("manufacturer >", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerGreaterThanOrEqualTo(String value) {
            addCriterion("manufacturer >=", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerLessThan(String value) {
            addCriterion("manufacturer <", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerLessThanOrEqualTo(String value) {
            addCriterion("manufacturer <=", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerLike(String value) {
            addCriterion("manufacturer like", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotLike(String value) {
            addCriterion("manufacturer not like", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerIn(List<String> values) {
            addCriterion("manufacturer in", values, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotIn(List<String> values) {
            addCriterion("manufacturer not in", values, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerBetween(String value1, String value2) {
            addCriterion("manufacturer between", value1, value2, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotBetween(String value1, String value2) {
            addCriterion("manufacturer not between", value1, value2, "manufacturer");
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