package com.choujiang.domain;

import java.util.ArrayList;
import java.util.List;

public class OrganizationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrganizationExample() {
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

        public Criteria andOrgCodeIsNull() {
            addCriterion("org_code is null");
            return (Criteria) this;
        }

        public Criteria andOrgCodeIsNotNull() {
            addCriterion("org_code is not null");
            return (Criteria) this;
        }

        public Criteria andOrgCodeEqualTo(Integer value) {
            addCriterion("org_code =", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeNotEqualTo(Integer value) {
            addCriterion("org_code <>", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeGreaterThan(Integer value) {
            addCriterion("org_code >", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("org_code >=", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeLessThan(Integer value) {
            addCriterion("org_code <", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeLessThanOrEqualTo(Integer value) {
            addCriterion("org_code <=", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeIn(List<Integer> values) {
            addCriterion("org_code in", values, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeNotIn(List<Integer> values) {
            addCriterion("org_code not in", values, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeBetween(Integer value1, Integer value2) {
            addCriterion("org_code between", value1, value2, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("org_code not between", value1, value2, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgNameIsNull() {
            addCriterion("org_name is null");
            return (Criteria) this;
        }

        public Criteria andOrgNameIsNotNull() {
            addCriterion("org_name is not null");
            return (Criteria) this;
        }

        public Criteria andOrgNameEqualTo(String value) {
            addCriterion("org_name =", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotEqualTo(String value) {
            addCriterion("org_name <>", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameGreaterThan(String value) {
            addCriterion("org_name >", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameGreaterThanOrEqualTo(String value) {
            addCriterion("org_name >=", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameLessThan(String value) {
            addCriterion("org_name <", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameLessThanOrEqualTo(String value) {
            addCriterion("org_name <=", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameLike(String value) {
            addCriterion("org_name like", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotLike(String value) {
            addCriterion("org_name not like", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameIn(List<String> values) {
            addCriterion("org_name in", values, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotIn(List<String> values) {
            addCriterion("org_name not in", values, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameBetween(String value1, String value2) {
            addCriterion("org_name between", value1, value2, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotBetween(String value1, String value2) {
            addCriterion("org_name not between", value1, value2, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgQuotaIsNull() {
            addCriterion("org_quota is null");
            return (Criteria) this;
        }

        public Criteria andOrgQuotaIsNotNull() {
            addCriterion("org_quota is not null");
            return (Criteria) this;
        }

        public Criteria andOrgQuotaEqualTo(Integer value) {
            addCriterion("org_quota =", value, "orgQuota");
            return (Criteria) this;
        }

        public Criteria andOrgQuotaNotEqualTo(Integer value) {
            addCriterion("org_quota <>", value, "orgQuota");
            return (Criteria) this;
        }

        public Criteria andOrgQuotaGreaterThan(Integer value) {
            addCriterion("org_quota >", value, "orgQuota");
            return (Criteria) this;
        }

        public Criteria andOrgQuotaGreaterThanOrEqualTo(Integer value) {
            addCriterion("org_quota >=", value, "orgQuota");
            return (Criteria) this;
        }

        public Criteria andOrgQuotaLessThan(Integer value) {
            addCriterion("org_quota <", value, "orgQuota");
            return (Criteria) this;
        }

        public Criteria andOrgQuotaLessThanOrEqualTo(Integer value) {
            addCriterion("org_quota <=", value, "orgQuota");
            return (Criteria) this;
        }

        public Criteria andOrgQuotaIn(List<Integer> values) {
            addCriterion("org_quota in", values, "orgQuota");
            return (Criteria) this;
        }

        public Criteria andOrgQuotaNotIn(List<Integer> values) {
            addCriterion("org_quota not in", values, "orgQuota");
            return (Criteria) this;
        }

        public Criteria andOrgQuotaBetween(Integer value1, Integer value2) {
            addCriterion("org_quota between", value1, value2, "orgQuota");
            return (Criteria) this;
        }

        public Criteria andOrgQuotaNotBetween(Integer value1, Integer value2) {
            addCriterion("org_quota not between", value1, value2, "orgQuota");
            return (Criteria) this;
        }

        public Criteria andOrgJoinedIsNull() {
            addCriterion("org_joined is null");
            return (Criteria) this;
        }

        public Criteria andOrgJoinedIsNotNull() {
            addCriterion("org_joined is not null");
            return (Criteria) this;
        }

        public Criteria andOrgJoinedEqualTo(Integer value) {
            addCriterion("org_joined =", value, "orgJoined");
            return (Criteria) this;
        }

        public Criteria andOrgJoinedNotEqualTo(Integer value) {
            addCriterion("org_joined <>", value, "orgJoined");
            return (Criteria) this;
        }

        public Criteria andOrgJoinedGreaterThan(Integer value) {
            addCriterion("org_joined >", value, "orgJoined");
            return (Criteria) this;
        }

        public Criteria andOrgJoinedGreaterThanOrEqualTo(Integer value) {
            addCriterion("org_joined >=", value, "orgJoined");
            return (Criteria) this;
        }

        public Criteria andOrgJoinedLessThan(Integer value) {
            addCriterion("org_joined <", value, "orgJoined");
            return (Criteria) this;
        }

        public Criteria andOrgJoinedLessThanOrEqualTo(Integer value) {
            addCriterion("org_joined <=", value, "orgJoined");
            return (Criteria) this;
        }

        public Criteria andOrgJoinedIn(List<Integer> values) {
            addCriterion("org_joined in", values, "orgJoined");
            return (Criteria) this;
        }

        public Criteria andOrgJoinedNotIn(List<Integer> values) {
            addCriterion("org_joined not in", values, "orgJoined");
            return (Criteria) this;
        }

        public Criteria andOrgJoinedBetween(Integer value1, Integer value2) {
            addCriterion("org_joined between", value1, value2, "orgJoined");
            return (Criteria) this;
        }

        public Criteria andOrgJoinedNotBetween(Integer value1, Integer value2) {
            addCriterion("org_joined not between", value1, value2, "orgJoined");
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