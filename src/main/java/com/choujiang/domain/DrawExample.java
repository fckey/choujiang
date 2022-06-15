package com.choujiang.domain;

import java.util.ArrayList;
import java.util.List;

public class DrawExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DrawExample() {
        oredCriteria = new ArrayList<>();
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

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
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

        public Criteria andDrawIdIsNull() {
            addCriterion("draw_id is null");
            return (Criteria) this;
        }

        public Criteria andDrawIdIsNotNull() {
            addCriterion("draw_id is not null");
            return (Criteria) this;
        }

        public Criteria andDrawIdEqualTo(Integer value) {
            addCriterion("draw_id =", value, "drawId");
            return (Criteria) this;
        }

        public Criteria andDrawIdNotEqualTo(Integer value) {
            addCriterion("draw_id <>", value, "drawId");
            return (Criteria) this;
        }

        public Criteria andDrawIdGreaterThan(Integer value) {
            addCriterion("draw_id >", value, "drawId");
            return (Criteria) this;
        }

        public Criteria andDrawIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("draw_id >=", value, "drawId");
            return (Criteria) this;
        }

        public Criteria andDrawIdLessThan(Integer value) {
            addCriterion("draw_id <", value, "drawId");
            return (Criteria) this;
        }

        public Criteria andDrawIdLessThanOrEqualTo(Integer value) {
            addCriterion("draw_id <=", value, "drawId");
            return (Criteria) this;
        }

        public Criteria andDrawIdIn(List<Integer> values) {
            addCriterion("draw_id in", values, "drawId");
            return (Criteria) this;
        }

        public Criteria andDrawIdNotIn(List<Integer> values) {
            addCriterion("draw_id not in", values, "drawId");
            return (Criteria) this;
        }

        public Criteria andDrawIdBetween(Integer value1, Integer value2) {
            addCriterion("draw_id between", value1, value2, "drawId");
            return (Criteria) this;
        }

        public Criteria andDrawIdNotBetween(Integer value1, Integer value2) {
            addCriterion("draw_id not between", value1, value2, "drawId");
            return (Criteria) this;
        }

        public Criteria andDrawDescIsNull() {
            addCriterion("draw_desc is null");
            return (Criteria) this;
        }

        public Criteria andDrawDescIsNotNull() {
            addCriterion("draw_desc is not null");
            return (Criteria) this;
        }

        public Criteria andDrawDescEqualTo(String value) {
            addCriterion("draw_desc =", value, "drawDesc");
            return (Criteria) this;
        }

        public Criteria andDrawDescNotEqualTo(String value) {
            addCriterion("draw_desc <>", value, "drawDesc");
            return (Criteria) this;
        }

        public Criteria andDrawDescGreaterThan(String value) {
            addCriterion("draw_desc >", value, "drawDesc");
            return (Criteria) this;
        }

        public Criteria andDrawDescGreaterThanOrEqualTo(String value) {
            addCriterion("draw_desc >=", value, "drawDesc");
            return (Criteria) this;
        }

        public Criteria andDrawDescLessThan(String value) {
            addCriterion("draw_desc <", value, "drawDesc");
            return (Criteria) this;
        }

        public Criteria andDrawDescLessThanOrEqualTo(String value) {
            addCriterion("draw_desc <=", value, "drawDesc");
            return (Criteria) this;
        }

        public Criteria andDrawDescLike(String value) {
            addCriterion("draw_desc like", value, "drawDesc");
            return (Criteria) this;
        }

        public Criteria andDrawDescNotLike(String value) {
            addCriterion("draw_desc not like", value, "drawDesc");
            return (Criteria) this;
        }

        public Criteria andDrawDescIn(List<String> values) {
            addCriterion("draw_desc in", values, "drawDesc");
            return (Criteria) this;
        }

        public Criteria andDrawDescNotIn(List<String> values) {
            addCriterion("draw_desc not in", values, "drawDesc");
            return (Criteria) this;
        }

        public Criteria andDrawDescBetween(String value1, String value2) {
            addCriterion("draw_desc between", value1, value2, "drawDesc");
            return (Criteria) this;
        }

        public Criteria andDrawDescNotBetween(String value1, String value2) {
            addCriterion("draw_desc not between", value1, value2, "drawDesc");
            return (Criteria) this;
        }

        public Criteria andDrawNumIsNull() {
            addCriterion("draw_num is null");
            return (Criteria) this;
        }

        public Criteria andDrawNumIsNotNull() {
            addCriterion("draw_num is not null");
            return (Criteria) this;
        }

        public Criteria andDrawNumEqualTo(Integer value) {
            addCriterion("draw_num =", value, "drawNum");
            return (Criteria) this;
        }

        public Criteria andDrawNumNotEqualTo(Integer value) {
            addCriterion("draw_num <>", value, "drawNum");
            return (Criteria) this;
        }

        public Criteria andDrawNumGreaterThan(Integer value) {
            addCriterion("draw_num >", value, "drawNum");
            return (Criteria) this;
        }

        public Criteria andDrawNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("draw_num >=", value, "drawNum");
            return (Criteria) this;
        }

        public Criteria andDrawNumLessThan(Integer value) {
            addCriterion("draw_num <", value, "drawNum");
            return (Criteria) this;
        }

        public Criteria andDrawNumLessThanOrEqualTo(Integer value) {
            addCriterion("draw_num <=", value, "drawNum");
            return (Criteria) this;
        }

        public Criteria andDrawNumIn(List<Integer> values) {
            addCriterion("draw_num in", values, "drawNum");
            return (Criteria) this;
        }

        public Criteria andDrawNumNotIn(List<Integer> values) {
            addCriterion("draw_num not in", values, "drawNum");
            return (Criteria) this;
        }

        public Criteria andDrawNumBetween(Integer value1, Integer value2) {
            addCriterion("draw_num between", value1, value2, "drawNum");
            return (Criteria) this;
        }

        public Criteria andDrawNumNotBetween(Integer value1, Integer value2) {
            addCriterion("draw_num not between", value1, value2, "drawNum");
            return (Criteria) this;
        }

        public Criteria andDrawLuckIsNull() {
            addCriterion("draw_luck is null");
            return (Criteria) this;
        }

        public Criteria andDrawLuckIsNotNull() {
            addCriterion("draw_luck is not null");
            return (Criteria) this;
        }

        public Criteria andDrawLuckEqualTo(Integer value) {
            addCriterion("draw_luck =", value, "drawLuck");
            return (Criteria) this;
        }

        public Criteria andDrawLuckNotEqualTo(Integer value) {
            addCriterion("draw_luck <>", value, "drawLuck");
            return (Criteria) this;
        }

        public Criteria andDrawLuckGreaterThan(Integer value) {
            addCriterion("draw_luck >", value, "drawLuck");
            return (Criteria) this;
        }

        public Criteria andDrawLuckGreaterThanOrEqualTo(Integer value) {
            addCriterion("draw_luck >=", value, "drawLuck");
            return (Criteria) this;
        }

        public Criteria andDrawLuckLessThan(Integer value) {
            addCriterion("draw_luck <", value, "drawLuck");
            return (Criteria) this;
        }

        public Criteria andDrawLuckLessThanOrEqualTo(Integer value) {
            addCriterion("draw_luck <=", value, "drawLuck");
            return (Criteria) this;
        }

        public Criteria andDrawLuckIn(List<Integer> values) {
            addCriterion("draw_luck in", values, "drawLuck");
            return (Criteria) this;
        }

        public Criteria andDrawLuckNotIn(List<Integer> values) {
            addCriterion("draw_luck not in", values, "drawLuck");
            return (Criteria) this;
        }

        public Criteria andDrawLuckBetween(Integer value1, Integer value2) {
            addCriterion("draw_luck between", value1, value2, "drawLuck");
            return (Criteria) this;
        }

        public Criteria andDrawLuckNotBetween(Integer value1, Integer value2) {
            addCriterion("draw_luck not between", value1, value2, "drawLuck");
            return (Criteria) this;
        }

        public Criteria andDrawValidIsNull() {
            addCriterion("draw_valid is null");
            return (Criteria) this;
        }

        public Criteria andDrawValidIsNotNull() {
            addCriterion("draw_valid is not null");
            return (Criteria) this;
        }

        public Criteria andDrawValidEqualTo(Integer value) {
            addCriterion("draw_valid =", value, "drawValid");
            return (Criteria) this;
        }

        public Criteria andDrawValidNotEqualTo(Integer value) {
            addCriterion("draw_valid <>", value, "drawValid");
            return (Criteria) this;
        }

        public Criteria andDrawValidGreaterThan(Integer value) {
            addCriterion("draw_valid >", value, "drawValid");
            return (Criteria) this;
        }

        public Criteria andDrawValidGreaterThanOrEqualTo(Integer value) {
            addCriterion("draw_valid >=", value, "drawValid");
            return (Criteria) this;
        }

        public Criteria andDrawValidLessThan(Integer value) {
            addCriterion("draw_valid <", value, "drawValid");
            return (Criteria) this;
        }

        public Criteria andDrawValidLessThanOrEqualTo(Integer value) {
            addCriterion("draw_valid <=", value, "drawValid");
            return (Criteria) this;
        }

        public Criteria andDrawValidIn(List<Integer> values) {
            addCriterion("draw_valid in", values, "drawValid");
            return (Criteria) this;
        }

        public Criteria andDrawValidNotIn(List<Integer> values) {
            addCriterion("draw_valid not in", values, "drawValid");
            return (Criteria) this;
        }

        public Criteria andDrawValidBetween(Integer value1, Integer value2) {
            addCriterion("draw_valid between", value1, value2, "drawValid");
            return (Criteria) this;
        }

        public Criteria andDrawValidNotBetween(Integer value1, Integer value2) {
            addCriterion("draw_valid not between", value1, value2, "drawValid");
            return (Criteria) this;
        }
    }

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