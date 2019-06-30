package com.neusoft.ssm.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ExpenseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public ExpenseExample() {
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

        public Criteria andMedicalRecordNoIsNull() {
            addCriterion("medical_record_no is null");
            return (Criteria) this;
        }

        public Criteria andMedicalRecordNoIsNotNull() {
            addCriterion("medical_record_no is not null");
            return (Criteria) this;
        }

        public Criteria andMedicalRecordNoEqualTo(String value) {
            addCriterion("medical_record_no =", value, "medicalRecordNo");
            return (Criteria) this;
        }

        public Criteria andMedicalRecordNoNotEqualTo(String value) {
            addCriterion("medical_record_no <>", value, "medicalRecordNo");
            return (Criteria) this;
        }

        public Criteria andMedicalRecordNoGreaterThan(String value) {
            addCriterion("medical_record_no >", value, "medicalRecordNo");
            return (Criteria) this;
        }

        public Criteria andMedicalRecordNoGreaterThanOrEqualTo(String value) {
            addCriterion("medical_record_no >=", value, "medicalRecordNo");
            return (Criteria) this;
        }

        public Criteria andMedicalRecordNoLessThan(String value) {
            addCriterion("medical_record_no <", value, "medicalRecordNo");
            return (Criteria) this;
        }

        public Criteria andMedicalRecordNoLessThanOrEqualTo(String value) {
            addCriterion("medical_record_no <=", value, "medicalRecordNo");
            return (Criteria) this;
        }

        public Criteria andMedicalRecordNoLike(String value) {
            addCriterion("medical_record_no like", value, "medicalRecordNo");
            return (Criteria) this;
        }

        public Criteria andMedicalRecordNoNotLike(String value) {
            addCriterion("medical_record_no not like", value, "medicalRecordNo");
            return (Criteria) this;
        }

        public Criteria andMedicalRecordNoIn(List<String> values) {
            addCriterion("medical_record_no in", values, "medicalRecordNo");
            return (Criteria) this;
        }

        public Criteria andMedicalRecordNoNotIn(List<String> values) {
            addCriterion("medical_record_no not in", values, "medicalRecordNo");
            return (Criteria) this;
        }

        public Criteria andMedicalRecordNoBetween(String value1, String value2) {
            addCriterion("medical_record_no between", value1, value2, "medicalRecordNo");
            return (Criteria) this;
        }

        public Criteria andMedicalRecordNoNotBetween(String value1, String value2) {
            addCriterion("medical_record_no not between", value1, value2, "medicalRecordNo");
            return (Criteria) this;
        }

        public Criteria andExpenseCategoryIsNull() {
            addCriterion("expense_category is null");
            return (Criteria) this;
        }

        public Criteria andExpenseCategoryIsNotNull() {
            addCriterion("expense_category is not null");
            return (Criteria) this;
        }

        public Criteria andExpenseCategoryEqualTo(String value) {
            addCriterion("expense_category =", value, "expenseCategory");
            return (Criteria) this;
        }

        public Criteria andExpenseCategoryNotEqualTo(String value) {
            addCriterion("expense_category <>", value, "expenseCategory");
            return (Criteria) this;
        }

        public Criteria andExpenseCategoryGreaterThan(String value) {
            addCriterion("expense_category >", value, "expenseCategory");
            return (Criteria) this;
        }

        public Criteria andExpenseCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("expense_category >=", value, "expenseCategory");
            return (Criteria) this;
        }

        public Criteria andExpenseCategoryLessThan(String value) {
            addCriterion("expense_category <", value, "expenseCategory");
            return (Criteria) this;
        }

        public Criteria andExpenseCategoryLessThanOrEqualTo(String value) {
            addCriterion("expense_category <=", value, "expenseCategory");
            return (Criteria) this;
        }

        public Criteria andExpenseCategoryLike(String value) {
            addCriterion("expense_category like", value, "expenseCategory");
            return (Criteria) this;
        }

        public Criteria andExpenseCategoryNotLike(String value) {
            addCriterion("expense_category not like", value, "expenseCategory");
            return (Criteria) this;
        }

        public Criteria andExpenseCategoryIn(List<String> values) {
            addCriterion("expense_category in", values, "expenseCategory");
            return (Criteria) this;
        }

        public Criteria andExpenseCategoryNotIn(List<String> values) {
            addCriterion("expense_category not in", values, "expenseCategory");
            return (Criteria) this;
        }

        public Criteria andExpenseCategoryBetween(String value1, String value2) {
            addCriterion("expense_category between", value1, value2, "expenseCategory");
            return (Criteria) this;
        }

        public Criteria andExpenseCategoryNotBetween(String value1, String value2) {
            addCriterion("expense_category not between", value1, value2, "expenseCategory");
            return (Criteria) this;
        }

        public Criteria andExpenseIdIsNull() {
            addCriterion("expense_id is null");
            return (Criteria) this;
        }

        public Criteria andExpenseIdIsNotNull() {
            addCriterion("expense_id is not null");
            return (Criteria) this;
        }

        public Criteria andExpenseIdEqualTo(String value) {
            addCriterion("expense_id =", value, "expenseId");
            return (Criteria) this;
        }

        public Criteria andExpenseIdNotEqualTo(String value) {
            addCriterion("expense_id <>", value, "expenseId");
            return (Criteria) this;
        }

        public Criteria andExpenseIdGreaterThan(String value) {
            addCriterion("expense_id >", value, "expenseId");
            return (Criteria) this;
        }

        public Criteria andExpenseIdGreaterThanOrEqualTo(String value) {
            addCriterion("expense_id >=", value, "expenseId");
            return (Criteria) this;
        }

        public Criteria andExpenseIdLessThan(String value) {
            addCriterion("expense_id <", value, "expenseId");
            return (Criteria) this;
        }

        public Criteria andExpenseIdLessThanOrEqualTo(String value) {
            addCriterion("expense_id <=", value, "expenseId");
            return (Criteria) this;
        }

        public Criteria andExpenseIdLike(String value) {
            addCriterion("expense_id like", value, "expenseId");
            return (Criteria) this;
        }

        public Criteria andExpenseIdNotLike(String value) {
            addCriterion("expense_id not like", value, "expenseId");
            return (Criteria) this;
        }

        public Criteria andExpenseIdIn(List<String> values) {
            addCriterion("expense_id in", values, "expenseId");
            return (Criteria) this;
        }

        public Criteria andExpenseIdNotIn(List<String> values) {
            addCriterion("expense_id not in", values, "expenseId");
            return (Criteria) this;
        }

        public Criteria andExpenseIdBetween(String value1, String value2) {
            addCriterion("expense_id between", value1, value2, "expenseId");
            return (Criteria) this;
        }

        public Criteria andExpenseIdNotBetween(String value1, String value2) {
            addCriterion("expense_id not between", value1, value2, "expenseId");
            return (Criteria) this;
        }

        public Criteria andPrescribeIdIsNull() {
            addCriterion("prescribe_id is null");
            return (Criteria) this;
        }

        public Criteria andPrescribeIdIsNotNull() {
            addCriterion("prescribe_id is not null");
            return (Criteria) this;
        }

        public Criteria andPrescribeIdEqualTo(Integer value) {
            addCriterion("prescribe_id =", value, "prescribeId");
            return (Criteria) this;
        }

        public Criteria andPrescribeIdNotEqualTo(Integer value) {
            addCriterion("prescribe_id <>", value, "prescribeId");
            return (Criteria) this;
        }

        public Criteria andPrescribeIdGreaterThan(Integer value) {
            addCriterion("prescribe_id >", value, "prescribeId");
            return (Criteria) this;
        }

        public Criteria andPrescribeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("prescribe_id >=", value, "prescribeId");
            return (Criteria) this;
        }

        public Criteria andPrescribeIdLessThan(Integer value) {
            addCriterion("prescribe_id <", value, "prescribeId");
            return (Criteria) this;
        }

        public Criteria andPrescribeIdLessThanOrEqualTo(Integer value) {
            addCriterion("prescribe_id <=", value, "prescribeId");
            return (Criteria) this;
        }

        public Criteria andPrescribeIdIn(List<Integer> values) {
            addCriterion("prescribe_id in", values, "prescribeId");
            return (Criteria) this;
        }

        public Criteria andPrescribeIdNotIn(List<Integer> values) {
            addCriterion("prescribe_id not in", values, "prescribeId");
            return (Criteria) this;
        }

        public Criteria andPrescribeIdBetween(Integer value1, Integer value2) {
            addCriterion("prescribe_id between", value1, value2, "prescribeId");
            return (Criteria) this;
        }

        public Criteria andPrescribeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("prescribe_id not between", value1, value2, "prescribeId");
            return (Criteria) this;
        }

        public Criteria andNumberIsNull() {
            addCriterion("`number` is null");
            return (Criteria) this;
        }

        public Criteria andNumberIsNotNull() {
            addCriterion("`number` is not null");
            return (Criteria) this;
        }

        public Criteria andNumberEqualTo(Long value) {
            addCriterion("`number` =", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotEqualTo(Long value) {
            addCriterion("`number` <>", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThan(Long value) {
            addCriterion("`number` >", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThanOrEqualTo(Long value) {
            addCriterion("`number` >=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThan(Long value) {
            addCriterion("`number` <", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThanOrEqualTo(Long value) {
            addCriterion("`number` <=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberIn(List<Long> values) {
            addCriterion("`number` in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotIn(List<Long> values) {
            addCriterion("`number` not in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberBetween(Long value1, Long value2) {
            addCriterion("`number` between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotBetween(Long value1, Long value2) {
            addCriterion("`number` not between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andExpenseIsNull() {
            addCriterion("expense is null");
            return (Criteria) this;
        }

        public Criteria andExpenseIsNotNull() {
            addCriterion("expense is not null");
            return (Criteria) this;
        }

        public Criteria andExpenseEqualTo(BigDecimal value) {
            addCriterion("expense =", value, "expense");
            return (Criteria) this;
        }

        public Criteria andExpenseNotEqualTo(BigDecimal value) {
            addCriterion("expense <>", value, "expense");
            return (Criteria) this;
        }

        public Criteria andExpenseGreaterThan(BigDecimal value) {
            addCriterion("expense >", value, "expense");
            return (Criteria) this;
        }

        public Criteria andExpenseGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("expense >=", value, "expense");
            return (Criteria) this;
        }

        public Criteria andExpenseLessThan(BigDecimal value) {
            addCriterion("expense <", value, "expense");
            return (Criteria) this;
        }

        public Criteria andExpenseLessThanOrEqualTo(BigDecimal value) {
            addCriterion("expense <=", value, "expense");
            return (Criteria) this;
        }

        public Criteria andExpenseIn(List<BigDecimal> values) {
            addCriterion("expense in", values, "expense");
            return (Criteria) this;
        }

        public Criteria andExpenseNotIn(List<BigDecimal> values) {
            addCriterion("expense not in", values, "expense");
            return (Criteria) this;
        }

        public Criteria andExpenseBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("expense between", value1, value2, "expense");
            return (Criteria) this;
        }

        public Criteria andExpenseNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("expense not between", value1, value2, "expense");
            return (Criteria) this;
        }

        public Criteria andRealExpenseIsNull() {
            addCriterion("real_expense is null");
            return (Criteria) this;
        }

        public Criteria andRealExpenseIsNotNull() {
            addCriterion("real_expense is not null");
            return (Criteria) this;
        }

        public Criteria andRealExpenseEqualTo(BigDecimal value) {
            addCriterion("real_expense =", value, "realExpense");
            return (Criteria) this;
        }

        public Criteria andRealExpenseNotEqualTo(BigDecimal value) {
            addCriterion("real_expense <>", value, "realExpense");
            return (Criteria) this;
        }

        public Criteria andRealExpenseGreaterThan(BigDecimal value) {
            addCriterion("real_expense >", value, "realExpense");
            return (Criteria) this;
        }

        public Criteria andRealExpenseGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("real_expense >=", value, "realExpense");
            return (Criteria) this;
        }

        public Criteria andRealExpenseLessThan(BigDecimal value) {
            addCriterion("real_expense <", value, "realExpense");
            return (Criteria) this;
        }

        public Criteria andRealExpenseLessThanOrEqualTo(BigDecimal value) {
            addCriterion("real_expense <=", value, "realExpense");
            return (Criteria) this;
        }

        public Criteria andRealExpenseIn(List<BigDecimal> values) {
            addCriterion("real_expense in", values, "realExpense");
            return (Criteria) this;
        }

        public Criteria andRealExpenseNotIn(List<BigDecimal> values) {
            addCriterion("real_expense not in", values, "realExpense");
            return (Criteria) this;
        }

        public Criteria andRealExpenseBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("real_expense between", value1, value2, "realExpense");
            return (Criteria) this;
        }

        public Criteria andRealExpenseNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("real_expense not between", value1, value2, "realExpense");
            return (Criteria) this;
        }

        public Criteria andPayCategoryIsNull() {
            addCriterion("pay_category is null");
            return (Criteria) this;
        }

        public Criteria andPayCategoryIsNotNull() {
            addCriterion("pay_category is not null");
            return (Criteria) this;
        }

        public Criteria andPayCategoryEqualTo(String value) {
            addCriterion("pay_category =", value, "payCategory");
            return (Criteria) this;
        }

        public Criteria andPayCategoryNotEqualTo(String value) {
            addCriterion("pay_category <>", value, "payCategory");
            return (Criteria) this;
        }

        public Criteria andPayCategoryGreaterThan(String value) {
            addCriterion("pay_category >", value, "payCategory");
            return (Criteria) this;
        }

        public Criteria andPayCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("pay_category >=", value, "payCategory");
            return (Criteria) this;
        }

        public Criteria andPayCategoryLessThan(String value) {
            addCriterion("pay_category <", value, "payCategory");
            return (Criteria) this;
        }

        public Criteria andPayCategoryLessThanOrEqualTo(String value) {
            addCriterion("pay_category <=", value, "payCategory");
            return (Criteria) this;
        }

        public Criteria andPayCategoryLike(String value) {
            addCriterion("pay_category like", value, "payCategory");
            return (Criteria) this;
        }

        public Criteria andPayCategoryNotLike(String value) {
            addCriterion("pay_category not like", value, "payCategory");
            return (Criteria) this;
        }

        public Criteria andPayCategoryIn(List<String> values) {
            addCriterion("pay_category in", values, "payCategory");
            return (Criteria) this;
        }

        public Criteria andPayCategoryNotIn(List<String> values) {
            addCriterion("pay_category not in", values, "payCategory");
            return (Criteria) this;
        }

        public Criteria andPayCategoryBetween(String value1, String value2) {
            addCriterion("pay_category between", value1, value2, "payCategory");
            return (Criteria) this;
        }

        public Criteria andPayCategoryNotBetween(String value1, String value2) {
            addCriterion("pay_category not between", value1, value2, "payCategory");
            return (Criteria) this;
        }

        public Criteria andPaySignIsNull() {
            addCriterion("pay_sign is null");
            return (Criteria) this;
        }

        public Criteria andPaySignIsNotNull() {
            addCriterion("pay_sign is not null");
            return (Criteria) this;
        }

        public Criteria andPaySignEqualTo(String value) {
            addCriterion("pay_sign =", value, "paySign");
            return (Criteria) this;
        }

        public Criteria andPaySignNotEqualTo(String value) {
            addCriterion("pay_sign <>", value, "paySign");
            return (Criteria) this;
        }

        public Criteria andPaySignGreaterThan(String value) {
            addCriterion("pay_sign >", value, "paySign");
            return (Criteria) this;
        }

        public Criteria andPaySignGreaterThanOrEqualTo(String value) {
            addCriterion("pay_sign >=", value, "paySign");
            return (Criteria) this;
        }

        public Criteria andPaySignLessThan(String value) {
            addCriterion("pay_sign <", value, "paySign");
            return (Criteria) this;
        }

        public Criteria andPaySignLessThanOrEqualTo(String value) {
            addCriterion("pay_sign <=", value, "paySign");
            return (Criteria) this;
        }

        public Criteria andPaySignLike(String value) {
            addCriterion("pay_sign like", value, "paySign");
            return (Criteria) this;
        }

        public Criteria andPaySignNotLike(String value) {
            addCriterion("pay_sign not like", value, "paySign");
            return (Criteria) this;
        }

        public Criteria andPaySignIn(List<String> values) {
            addCriterion("pay_sign in", values, "paySign");
            return (Criteria) this;
        }

        public Criteria andPaySignNotIn(List<String> values) {
            addCriterion("pay_sign not in", values, "paySign");
            return (Criteria) this;
        }

        public Criteria andPaySignBetween(String value1, String value2) {
            addCriterion("pay_sign between", value1, value2, "paySign");
            return (Criteria) this;
        }

        public Criteria andPaySignNotBetween(String value1, String value2) {
            addCriterion("pay_sign not between", value1, value2, "paySign");
            return (Criteria) this;
        }

        public Criteria andDaySettleSignIsNull() {
            addCriterion("day_settle_sign is null");
            return (Criteria) this;
        }

        public Criteria andDaySettleSignIsNotNull() {
            addCriterion("day_settle_sign is not null");
            return (Criteria) this;
        }

        public Criteria andDaySettleSignEqualTo(String value) {
            addCriterion("day_settle_sign =", value, "daySettleSign");
            return (Criteria) this;
        }

        public Criteria andDaySettleSignNotEqualTo(String value) {
            addCriterion("day_settle_sign <>", value, "daySettleSign");
            return (Criteria) this;
        }

        public Criteria andDaySettleSignGreaterThan(String value) {
            addCriterion("day_settle_sign >", value, "daySettleSign");
            return (Criteria) this;
        }

        public Criteria andDaySettleSignGreaterThanOrEqualTo(String value) {
            addCriterion("day_settle_sign >=", value, "daySettleSign");
            return (Criteria) this;
        }

        public Criteria andDaySettleSignLessThan(String value) {
            addCriterion("day_settle_sign <", value, "daySettleSign");
            return (Criteria) this;
        }

        public Criteria andDaySettleSignLessThanOrEqualTo(String value) {
            addCriterion("day_settle_sign <=", value, "daySettleSign");
            return (Criteria) this;
        }

        public Criteria andDaySettleSignLike(String value) {
            addCriterion("day_settle_sign like", value, "daySettleSign");
            return (Criteria) this;
        }

        public Criteria andDaySettleSignNotLike(String value) {
            addCriterion("day_settle_sign not like", value, "daySettleSign");
            return (Criteria) this;
        }

        public Criteria andDaySettleSignIn(List<String> values) {
            addCriterion("day_settle_sign in", values, "daySettleSign");
            return (Criteria) this;
        }

        public Criteria andDaySettleSignNotIn(List<String> values) {
            addCriterion("day_settle_sign not in", values, "daySettleSign");
            return (Criteria) this;
        }

        public Criteria andDaySettleSignBetween(String value1, String value2) {
            addCriterion("day_settle_sign between", value1, value2, "daySettleSign");
            return (Criteria) this;
        }

        public Criteria andDaySettleSignNotBetween(String value1, String value2) {
            addCriterion("day_settle_sign not between", value1, value2, "daySettleSign");
            return (Criteria) this;
        }

        public Criteria andExpenseDateIsNull() {
            addCriterion("expense_date is null");
            return (Criteria) this;
        }

        public Criteria andExpenseDateIsNotNull() {
            addCriterion("expense_date is not null");
            return (Criteria) this;
        }

        public Criteria andExpenseDateEqualTo(Date value) {
            addCriterionForJDBCDate("expense_date =", value, "expenseDate");
            return (Criteria) this;
        }

        public Criteria andExpenseDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("expense_date <>", value, "expenseDate");
            return (Criteria) this;
        }

        public Criteria andExpenseDateGreaterThan(Date value) {
            addCriterionForJDBCDate("expense_date >", value, "expenseDate");
            return (Criteria) this;
        }

        public Criteria andExpenseDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("expense_date >=", value, "expenseDate");
            return (Criteria) this;
        }

        public Criteria andExpenseDateLessThan(Date value) {
            addCriterionForJDBCDate("expense_date <", value, "expenseDate");
            return (Criteria) this;
        }

        public Criteria andExpenseDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("expense_date <=", value, "expenseDate");
            return (Criteria) this;
        }

        public Criteria andExpenseDateIn(List<Date> values) {
            addCriterionForJDBCDate("expense_date in", values, "expenseDate");
            return (Criteria) this;
        }

        public Criteria andExpenseDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("expense_date not in", values, "expenseDate");
            return (Criteria) this;
        }

        public Criteria andExpenseDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("expense_date between", value1, value2, "expenseDate");
            return (Criteria) this;
        }

        public Criteria andExpenseDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("expense_date not between", value1, value2, "expenseDate");
            return (Criteria) this;
        }

        public Criteria andIsConsumeIsNull() {
            addCriterion("is_consume is null");
            return (Criteria) this;
        }

        public Criteria andIsConsumeIsNotNull() {
            addCriterion("is_consume is not null");
            return (Criteria) this;
        }

        public Criteria andIsConsumeEqualTo(String value) {
            addCriterion("is_consume =", value, "isConsume");
            return (Criteria) this;
        }

        public Criteria andIsConsumeNotEqualTo(String value) {
            addCriterion("is_consume <>", value, "isConsume");
            return (Criteria) this;
        }

        public Criteria andIsConsumeGreaterThan(String value) {
            addCriterion("is_consume >", value, "isConsume");
            return (Criteria) this;
        }

        public Criteria andIsConsumeGreaterThanOrEqualTo(String value) {
            addCriterion("is_consume >=", value, "isConsume");
            return (Criteria) this;
        }

        public Criteria andIsConsumeLessThan(String value) {
            addCriterion("is_consume <", value, "isConsume");
            return (Criteria) this;
        }

        public Criteria andIsConsumeLessThanOrEqualTo(String value) {
            addCriterion("is_consume <=", value, "isConsume");
            return (Criteria) this;
        }

        public Criteria andIsConsumeLike(String value) {
            addCriterion("is_consume like", value, "isConsume");
            return (Criteria) this;
        }

        public Criteria andIsConsumeNotLike(String value) {
            addCriterion("is_consume not like", value, "isConsume");
            return (Criteria) this;
        }

        public Criteria andIsConsumeIn(List<String> values) {
            addCriterion("is_consume in", values, "isConsume");
            return (Criteria) this;
        }

        public Criteria andIsConsumeNotIn(List<String> values) {
            addCriterion("is_consume not in", values, "isConsume");
            return (Criteria) this;
        }

        public Criteria andIsConsumeBetween(String value1, String value2) {
            addCriterion("is_consume between", value1, value2, "isConsume");
            return (Criteria) this;
        }

        public Criteria andIsConsumeNotBetween(String value1, String value2) {
            addCriterion("is_consume not between", value1, value2, "isConsume");
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