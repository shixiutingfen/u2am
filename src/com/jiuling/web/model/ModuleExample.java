package com.jiuling.web.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ModuleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ModuleExample() {
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

        public Criteria andModuleIdIsNull() {
            addCriterion("module_id is null");
            return (Criteria) this;
        }

        public Criteria andModuleIdIsNotNull() {
            addCriterion("module_id is not null");
            return (Criteria) this;
        }

        public Criteria andModuleIdEqualTo(Long value) {
            addCriterion("module_id =", value, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdNotEqualTo(Long value) {
            addCriterion("module_id <>", value, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdGreaterThan(Long value) {
            addCriterion("module_id >", value, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdGreaterThanOrEqualTo(Long value) {
            addCriterion("module_id >=", value, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdLessThan(Long value) {
            addCriterion("module_id <", value, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdLessThanOrEqualTo(Long value) {
            addCriterion("module_id <=", value, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdIn(List<Long> values) {
            addCriterion("module_id in", values, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdNotIn(List<Long> values) {
            addCriterion("module_id not in", values, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdBetween(Long value1, Long value2) {
            addCriterion("module_id between", value1, value2, "moduleId");
            return (Criteria) this;
        }

        public Criteria andModuleIdNotBetween(Long value1, Long value2) {
            addCriterion("module_id not between", value1, value2, "moduleId");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("parent_id is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(Long value) {
            addCriterion("parent_id =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(Long value) {
            addCriterion("parent_id <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(Long value) {
            addCriterion("parent_id >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("parent_id >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(Long value) {
            addCriterion("parent_id <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(Long value) {
            addCriterion("parent_id <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<Long> values) {
            addCriterion("parent_id in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<Long> values) {
            addCriterion("parent_id not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(Long value1, Long value2) {
            addCriterion("parent_id between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(Long value1, Long value2) {
            addCriterion("parent_id not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andModuleUrlIsNull() {
            addCriterion("module_url is null");
            return (Criteria) this;
        }

        public Criteria andModuleUrlIsNotNull() {
            addCriterion("module_url is not null");
            return (Criteria) this;
        }

        public Criteria andModuleUrlEqualTo(String value) {
            addCriterion("module_url =", value, "moduleUrl");
            return (Criteria) this;
        }

        public Criteria andModuleUrlNotEqualTo(String value) {
            addCriterion("module_url <>", value, "moduleUrl");
            return (Criteria) this;
        }

        public Criteria andModuleUrlGreaterThan(String value) {
            addCriterion("module_url >", value, "moduleUrl");
            return (Criteria) this;
        }

        public Criteria andModuleUrlGreaterThanOrEqualTo(String value) {
            addCriterion("module_url >=", value, "moduleUrl");
            return (Criteria) this;
        }

        public Criteria andModuleUrlLessThan(String value) {
            addCriterion("module_url <", value, "moduleUrl");
            return (Criteria) this;
        }

        public Criteria andModuleUrlLessThanOrEqualTo(String value) {
            addCriterion("module_url <=", value, "moduleUrl");
            return (Criteria) this;
        }

        public Criteria andModuleUrlLike(String value) {
            addCriterion("module_url like", value, "moduleUrl");
            return (Criteria) this;
        }

        public Criteria andModuleUrlNotLike(String value) {
            addCriterion("module_url not like", value, "moduleUrl");
            return (Criteria) this;
        }

        public Criteria andModuleUrlIn(List<String> values) {
            addCriterion("module_url in", values, "moduleUrl");
            return (Criteria) this;
        }

        public Criteria andModuleUrlNotIn(List<String> values) {
            addCriterion("module_url not in", values, "moduleUrl");
            return (Criteria) this;
        }

        public Criteria andModuleUrlBetween(String value1, String value2) {
            addCriterion("module_url between", value1, value2, "moduleUrl");
            return (Criteria) this;
        }

        public Criteria andModuleUrlNotBetween(String value1, String value2) {
            addCriterion("module_url not between", value1, value2, "moduleUrl");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andIsVisibleIsNull() {
            addCriterion("is_visible is null");
            return (Criteria) this;
        }

        public Criteria andIsVisibleIsNotNull() {
            addCriterion("is_visible is not null");
            return (Criteria) this;
        }

        public Criteria andIsVisibleEqualTo(String value) {
            addCriterion("is_visible =", value, "isVisible");
            return (Criteria) this;
        }

        public Criteria andIsVisibleNotEqualTo(String value) {
            addCriterion("is_visible <>", value, "isVisible");
            return (Criteria) this;
        }

        public Criteria andIsVisibleGreaterThan(String value) {
            addCriterion("is_visible >", value, "isVisible");
            return (Criteria) this;
        }

        public Criteria andIsVisibleGreaterThanOrEqualTo(String value) {
            addCriterion("is_visible >=", value, "isVisible");
            return (Criteria) this;
        }

        public Criteria andIsVisibleLessThan(String value) {
            addCriterion("is_visible <", value, "isVisible");
            return (Criteria) this;
        }

        public Criteria andIsVisibleLessThanOrEqualTo(String value) {
            addCriterion("is_visible <=", value, "isVisible");
            return (Criteria) this;
        }

        public Criteria andIsVisibleLike(String value) {
            addCriterion("is_visible like", value, "isVisible");
            return (Criteria) this;
        }

        public Criteria andIsVisibleNotLike(String value) {
            addCriterion("is_visible not like", value, "isVisible");
            return (Criteria) this;
        }

        public Criteria andIsVisibleIn(List<String> values) {
            addCriterion("is_visible in", values, "isVisible");
            return (Criteria) this;
        }

        public Criteria andIsVisibleNotIn(List<String> values) {
            addCriterion("is_visible not in", values, "isVisible");
            return (Criteria) this;
        }

        public Criteria andIsVisibleBetween(String value1, String value2) {
            addCriterion("is_visible between", value1, value2, "isVisible");
            return (Criteria) this;
        }

        public Criteria andIsVisibleNotBetween(String value1, String value2) {
            addCriterion("is_visible not between", value1, value2, "isVisible");
            return (Criteria) this;
        }

        public Criteria andActionsIsNull() {
            addCriterion("actions is null");
            return (Criteria) this;
        }

        public Criteria andActionsIsNotNull() {
            addCriterion("actions is not null");
            return (Criteria) this;
        }

        public Criteria andActionsEqualTo(String value) {
            addCriterion("actions =", value, "actions");
            return (Criteria) this;
        }

        public Criteria andActionsNotEqualTo(String value) {
            addCriterion("actions <>", value, "actions");
            return (Criteria) this;
        }

        public Criteria andActionsGreaterThan(String value) {
            addCriterion("actions >", value, "actions");
            return (Criteria) this;
        }

        public Criteria andActionsGreaterThanOrEqualTo(String value) {
            addCriterion("actions >=", value, "actions");
            return (Criteria) this;
        }

        public Criteria andActionsLessThan(String value) {
            addCriterion("actions <", value, "actions");
            return (Criteria) this;
        }

        public Criteria andActionsLessThanOrEqualTo(String value) {
            addCriterion("actions <=", value, "actions");
            return (Criteria) this;
        }

        public Criteria andActionsLike(String value) {
            addCriterion("actions like", value, "actions");
            return (Criteria) this;
        }

        public Criteria andActionsNotLike(String value) {
            addCriterion("actions not like", value, "actions");
            return (Criteria) this;
        }

        public Criteria andActionsIn(List<String> values) {
            addCriterion("actions in", values, "actions");
            return (Criteria) this;
        }

        public Criteria andActionsNotIn(List<String> values) {
            addCriterion("actions not in", values, "actions");
            return (Criteria) this;
        }

        public Criteria andActionsBetween(String value1, String value2) {
            addCriterion("actions between", value1, value2, "actions");
            return (Criteria) this;
        }

        public Criteria andActionsNotBetween(String value1, String value2) {
            addCriterion("actions not between", value1, value2, "actions");
            return (Criteria) this;
        }

        public Criteria andLongNumberIsNull() {
            addCriterion("long_number is null");
            return (Criteria) this;
        }

        public Criteria andLongNumberIsNotNull() {
            addCriterion("long_number is not null");
            return (Criteria) this;
        }

        public Criteria andLongNumberEqualTo(String value) {
            addCriterion("long_number =", value, "longNumber");
            return (Criteria) this;
        }

        public Criteria andLongNumberNotEqualTo(String value) {
            addCriterion("long_number <>", value, "longNumber");
            return (Criteria) this;
        }

        public Criteria andLongNumberGreaterThan(String value) {
            addCriterion("long_number >", value, "longNumber");
            return (Criteria) this;
        }

        public Criteria andLongNumberGreaterThanOrEqualTo(String value) {
            addCriterion("long_number >=", value, "longNumber");
            return (Criteria) this;
        }

        public Criteria andLongNumberLessThan(String value) {
            addCriterion("long_number <", value, "longNumber");
            return (Criteria) this;
        }

        public Criteria andLongNumberLessThanOrEqualTo(String value) {
            addCriterion("long_number <=", value, "longNumber");
            return (Criteria) this;
        }

        public Criteria andLongNumberLike(String value) {
            addCriterion("long_number like", value, "longNumber");
            return (Criteria) this;
        }

        public Criteria andLongNumberNotLike(String value) {
            addCriterion("long_number not like", value, "longNumber");
            return (Criteria) this;
        }

        public Criteria andLongNumberIn(List<String> values) {
            addCriterion("long_number in", values, "longNumber");
            return (Criteria) this;
        }

        public Criteria andLongNumberNotIn(List<String> values) {
            addCriterion("long_number not in", values, "longNumber");
            return (Criteria) this;
        }

        public Criteria andLongNumberBetween(String value1, String value2) {
            addCriterion("long_number between", value1, value2, "longNumber");
            return (Criteria) this;
        }

        public Criteria andLongNumberNotBetween(String value1, String value2) {
            addCriterion("long_number not between", value1, value2, "longNumber");
            return (Criteria) this;
        }

        public Criteria andModuleLevelIsNull() {
            addCriterion("module_level is null");
            return (Criteria) this;
        }

        public Criteria andModuleLevelIsNotNull() {
            addCriterion("module_level is not null");
            return (Criteria) this;
        }

        public Criteria andModuleLevelEqualTo(Long value) {
            addCriterion("module_level =", value, "moduleLevel");
            return (Criteria) this;
        }

        public Criteria andModuleLevelNotEqualTo(Long value) {
            addCriterion("module_level <>", value, "moduleLevel");
            return (Criteria) this;
        }

        public Criteria andModuleLevelGreaterThan(Long value) {
            addCriterion("module_level >", value, "moduleLevel");
            return (Criteria) this;
        }

        public Criteria andModuleLevelGreaterThanOrEqualTo(Long value) {
            addCriterion("module_level >=", value, "moduleLevel");
            return (Criteria) this;
        }

        public Criteria andModuleLevelLessThan(Long value) {
            addCriterion("module_level <", value, "moduleLevel");
            return (Criteria) this;
        }

        public Criteria andModuleLevelLessThanOrEqualTo(Long value) {
            addCriterion("module_level <=", value, "moduleLevel");
            return (Criteria) this;
        }

        public Criteria andModuleLevelIn(List<Long> values) {
            addCriterion("module_level in", values, "moduleLevel");
            return (Criteria) this;
        }

        public Criteria andModuleLevelNotIn(List<Long> values) {
            addCriterion("module_level not in", values, "moduleLevel");
            return (Criteria) this;
        }

        public Criteria andModuleLevelBetween(Long value1, Long value2) {
            addCriterion("module_level between", value1, value2, "moduleLevel");
            return (Criteria) this;
        }

        public Criteria andModuleLevelNotBetween(Long value1, Long value2) {
            addCriterion("module_level not between", value1, value2, "moduleLevel");
            return (Criteria) this;
        }

        public Criteria andDisplayNameIsNull() {
            addCriterion("display_name is null");
            return (Criteria) this;
        }

        public Criteria andDisplayNameIsNotNull() {
            addCriterion("display_name is not null");
            return (Criteria) this;
        }

        public Criteria andDisplayNameEqualTo(String value) {
            addCriterion("display_name =", value, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameNotEqualTo(String value) {
            addCriterion("display_name <>", value, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameGreaterThan(String value) {
            addCriterion("display_name >", value, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameGreaterThanOrEqualTo(String value) {
            addCriterion("display_name >=", value, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameLessThan(String value) {
            addCriterion("display_name <", value, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameLessThanOrEqualTo(String value) {
            addCriterion("display_name <=", value, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameLike(String value) {
            addCriterion("display_name like", value, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameNotLike(String value) {
            addCriterion("display_name not like", value, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameIn(List<String> values) {
            addCriterion("display_name in", values, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameNotIn(List<String> values) {
            addCriterion("display_name not in", values, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameBetween(String value1, String value2) {
            addCriterion("display_name between", value1, value2, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameNotBetween(String value1, String value2) {
            addCriterion("display_name not between", value1, value2, "displayName");
            return (Criteria) this;
        }

        public Criteria andLeafIsNull() {
            addCriterion("leaf is null");
            return (Criteria) this;
        }

        public Criteria andLeafIsNotNull() {
            addCriterion("leaf is not null");
            return (Criteria) this;
        }

        public Criteria andLeafEqualTo(Long value) {
            addCriterion("leaf =", value, "leaf");
            return (Criteria) this;
        }

        public Criteria andLeafNotEqualTo(Long value) {
            addCriterion("leaf <>", value, "leaf");
            return (Criteria) this;
        }

        public Criteria andLeafGreaterThan(Long value) {
            addCriterion("leaf >", value, "leaf");
            return (Criteria) this;
        }

        public Criteria andLeafGreaterThanOrEqualTo(Long value) {
            addCriterion("leaf >=", value, "leaf");
            return (Criteria) this;
        }

        public Criteria andLeafLessThan(Long value) {
            addCriterion("leaf <", value, "leaf");
            return (Criteria) this;
        }

        public Criteria andLeafLessThanOrEqualTo(Long value) {
            addCriterion("leaf <=", value, "leaf");
            return (Criteria) this;
        }

        public Criteria andLeafIn(List<Long> values) {
            addCriterion("leaf in", values, "leaf");
            return (Criteria) this;
        }

        public Criteria andLeafNotIn(List<Long> values) {
            addCriterion("leaf not in", values, "leaf");
            return (Criteria) this;
        }

        public Criteria andLeafBetween(Long value1, Long value2) {
            addCriterion("leaf between", value1, value2, "leaf");
            return (Criteria) this;
        }

        public Criteria andLeafNotBetween(Long value1, Long value2) {
            addCriterion("leaf not between", value1, value2, "leaf");
            return (Criteria) this;
        }

        public Criteria andSeqIsNull() {
            addCriterion("seq is null");
            return (Criteria) this;
        }

        public Criteria andSeqIsNotNull() {
            addCriterion("seq is not null");
            return (Criteria) this;
        }

        public Criteria andSeqEqualTo(Long value) {
            addCriterion("seq =", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqNotEqualTo(Long value) {
            addCriterion("seq <>", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqGreaterThan(Long value) {
            addCriterion("seq >", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqGreaterThanOrEqualTo(Long value) {
            addCriterion("seq >=", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqLessThan(Long value) {
            addCriterion("seq <", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqLessThanOrEqualTo(Long value) {
            addCriterion("seq <=", value, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqIn(List<Long> values) {
            addCriterion("seq in", values, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqNotIn(List<Long> values) {
            addCriterion("seq not in", values, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqBetween(Long value1, Long value2) {
            addCriterion("seq between", value1, value2, "seq");
            return (Criteria) this;
        }

        public Criteria andSeqNotBetween(Long value1, Long value2) {
            addCriterion("seq not between", value1, value2, "seq");
            return (Criteria) this;
        }

        public Criteria andModuleNameIsNull() {
            addCriterion("module_name is null");
            return (Criteria) this;
        }

        public Criteria andModuleNameIsNotNull() {
            addCriterion("module_name is not null");
            return (Criteria) this;
        }

        public Criteria andModuleNameEqualTo(String value) {
            addCriterion("module_name =", value, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleNameNotEqualTo(String value) {
            addCriterion("module_name <>", value, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleNameGreaterThan(String value) {
            addCriterion("module_name >", value, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleNameGreaterThanOrEqualTo(String value) {
            addCriterion("module_name >=", value, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleNameLessThan(String value) {
            addCriterion("module_name <", value, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleNameLessThanOrEqualTo(String value) {
            addCriterion("module_name <=", value, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleNameLike(String value) {
            addCriterion("module_name like", value, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleNameNotLike(String value) {
            addCriterion("module_name not like", value, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleNameIn(List<String> values) {
            addCriterion("module_name in", values, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleNameNotIn(List<String> values) {
            addCriterion("module_name not in", values, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleNameBetween(String value1, String value2) {
            addCriterion("module_name between", value1, value2, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleNameNotBetween(String value1, String value2) {
            addCriterion("module_name not between", value1, value2, "moduleName");
            return (Criteria) this;
        }

        public Criteria andModuleNumberIsNull() {
            addCriterion("module_number is null");
            return (Criteria) this;
        }

        public Criteria andModuleNumberIsNotNull() {
            addCriterion("module_number is not null");
            return (Criteria) this;
        }

        public Criteria andModuleNumberEqualTo(String value) {
            addCriterion("module_number =", value, "moduleNumber");
            return (Criteria) this;
        }

        public Criteria andModuleNumberNotEqualTo(String value) {
            addCriterion("module_number <>", value, "moduleNumber");
            return (Criteria) this;
        }

        public Criteria andModuleNumberGreaterThan(String value) {
            addCriterion("module_number >", value, "moduleNumber");
            return (Criteria) this;
        }

        public Criteria andModuleNumberGreaterThanOrEqualTo(String value) {
            addCriterion("module_number >=", value, "moduleNumber");
            return (Criteria) this;
        }

        public Criteria andModuleNumberLessThan(String value) {
            addCriterion("module_number <", value, "moduleNumber");
            return (Criteria) this;
        }

        public Criteria andModuleNumberLessThanOrEqualTo(String value) {
            addCriterion("module_number <=", value, "moduleNumber");
            return (Criteria) this;
        }

        public Criteria andModuleNumberLike(String value) {
            addCriterion("module_number like", value, "moduleNumber");
            return (Criteria) this;
        }

        public Criteria andModuleNumberNotLike(String value) {
            addCriterion("module_number not like", value, "moduleNumber");
            return (Criteria) this;
        }

        public Criteria andModuleNumberIn(List<String> values) {
            addCriterion("module_number in", values, "moduleNumber");
            return (Criteria) this;
        }

        public Criteria andModuleNumberNotIn(List<String> values) {
            addCriterion("module_number not in", values, "moduleNumber");
            return (Criteria) this;
        }

        public Criteria andModuleNumberBetween(String value1, String value2) {
            addCriterion("module_number between", value1, value2, "moduleNumber");
            return (Criteria) this;
        }

        public Criteria andModuleNumberNotBetween(String value1, String value2) {
            addCriterion("module_number not between", value1, value2, "moduleNumber");
            return (Criteria) this;
        }

        public Criteria andModuleDescriptionIsNull() {
            addCriterion("module_description is null");
            return (Criteria) this;
        }

        public Criteria andModuleDescriptionIsNotNull() {
            addCriterion("module_description is not null");
            return (Criteria) this;
        }

        public Criteria andModuleDescriptionEqualTo(String value) {
            addCriterion("module_description =", value, "moduleDescription");
            return (Criteria) this;
        }

        public Criteria andModuleDescriptionNotEqualTo(String value) {
            addCriterion("module_description <>", value, "moduleDescription");
            return (Criteria) this;
        }

        public Criteria andModuleDescriptionGreaterThan(String value) {
            addCriterion("module_description >", value, "moduleDescription");
            return (Criteria) this;
        }

        public Criteria andModuleDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("module_description >=", value, "moduleDescription");
            return (Criteria) this;
        }

        public Criteria andModuleDescriptionLessThan(String value) {
            addCriterion("module_description <", value, "moduleDescription");
            return (Criteria) this;
        }

        public Criteria andModuleDescriptionLessThanOrEqualTo(String value) {
            addCriterion("module_description <=", value, "moduleDescription");
            return (Criteria) this;
        }

        public Criteria andModuleDescriptionLike(String value) {
            addCriterion("module_description like", value, "moduleDescription");
            return (Criteria) this;
        }

        public Criteria andModuleDescriptionNotLike(String value) {
            addCriterion("module_description not like", value, "moduleDescription");
            return (Criteria) this;
        }

        public Criteria andModuleDescriptionIn(List<String> values) {
            addCriterion("module_description in", values, "moduleDescription");
            return (Criteria) this;
        }

        public Criteria andModuleDescriptionNotIn(List<String> values) {
            addCriterion("module_description not in", values, "moduleDescription");
            return (Criteria) this;
        }

        public Criteria andModuleDescriptionBetween(String value1, String value2) {
            addCriterion("module_description between", value1, value2, "moduleDescription");
            return (Criteria) this;
        }

        public Criteria andModuleDescriptionNotBetween(String value1, String value2) {
            addCriterion("module_description not between", value1, value2, "moduleDescription");
            return (Criteria) this;
        }

        public Criteria andCreatorIdIsNull() {
            addCriterion("creator_id is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIdIsNotNull() {
            addCriterion("creator_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorIdEqualTo(Long value) {
            addCriterion("creator_id =", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdNotEqualTo(Long value) {
            addCriterion("creator_id <>", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdGreaterThan(Long value) {
            addCriterion("creator_id >", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdGreaterThanOrEqualTo(Long value) {
            addCriterion("creator_id >=", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdLessThan(Long value) {
            addCriterion("creator_id <", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdLessThanOrEqualTo(Long value) {
            addCriterion("creator_id <=", value, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdIn(List<Long> values) {
            addCriterion("creator_id in", values, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdNotIn(List<Long> values) {
            addCriterion("creator_id not in", values, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdBetween(Long value1, Long value2) {
            addCriterion("creator_id between", value1, value2, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreatorIdNotBetween(Long value1, Long value2) {
            addCriterion("creator_id not between", value1, value2, "creatorId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserIdIsNull() {
            addCriterion("last_update_user_id is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserIdIsNotNull() {
            addCriterion("last_update_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserIdEqualTo(Long value) {
            addCriterion("last_update_user_id =", value, "lastUpdateUserId");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserIdNotEqualTo(Long value) {
            addCriterion("last_update_user_id <>", value, "lastUpdateUserId");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserIdGreaterThan(Long value) {
            addCriterion("last_update_user_id >", value, "lastUpdateUserId");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("last_update_user_id >=", value, "lastUpdateUserId");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserIdLessThan(Long value) {
            addCriterion("last_update_user_id <", value, "lastUpdateUserId");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserIdLessThanOrEqualTo(Long value) {
            addCriterion("last_update_user_id <=", value, "lastUpdateUserId");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserIdIn(List<Long> values) {
            addCriterion("last_update_user_id in", values, "lastUpdateUserId");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserIdNotIn(List<Long> values) {
            addCriterion("last_update_user_id not in", values, "lastUpdateUserId");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserIdBetween(Long value1, Long value2) {
            addCriterion("last_update_user_id between", value1, value2, "lastUpdateUserId");
            return (Criteria) this;
        }

        public Criteria andLastUpdateUserIdNotBetween(Long value1, Long value2) {
            addCriterion("last_update_user_id not between", value1, value2, "lastUpdateUserId");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedTimeIsNull() {
            addCriterion("last_updated_time is null");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedTimeIsNotNull() {
            addCriterion("last_updated_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedTimeEqualTo(Date value) {
            addCriterion("last_updated_time =", value, "lastUpdatedTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedTimeNotEqualTo(Date value) {
            addCriterion("last_updated_time <>", value, "lastUpdatedTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedTimeGreaterThan(Date value) {
            addCriterion("last_updated_time >", value, "lastUpdatedTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_updated_time >=", value, "lastUpdatedTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedTimeLessThan(Date value) {
            addCriterion("last_updated_time <", value, "lastUpdatedTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_updated_time <=", value, "lastUpdatedTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedTimeIn(List<Date> values) {
            addCriterion("last_updated_time in", values, "lastUpdatedTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedTimeNotIn(List<Date> values) {
            addCriterion("last_updated_time not in", values, "lastUpdatedTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedTimeBetween(Date value1, Date value2) {
            addCriterion("last_updated_time between", value1, value2, "lastUpdatedTime");
            return (Criteria) this;
        }

        public Criteria andLastUpdatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_updated_time not between", value1, value2, "lastUpdatedTime");
            return (Criteria) this;
        }

        public Criteria andCtrlUnitIdIsNull() {
            addCriterion("ctrl_unit_id is null");
            return (Criteria) this;
        }

        public Criteria andCtrlUnitIdIsNotNull() {
            addCriterion("ctrl_unit_id is not null");
            return (Criteria) this;
        }

        public Criteria andCtrlUnitIdEqualTo(String value) {
            addCriterion("ctrl_unit_id =", value, "ctrlUnitId");
            return (Criteria) this;
        }

        public Criteria andCtrlUnitIdNotEqualTo(String value) {
            addCriterion("ctrl_unit_id <>", value, "ctrlUnitId");
            return (Criteria) this;
        }

        public Criteria andCtrlUnitIdGreaterThan(String value) {
            addCriterion("ctrl_unit_id >", value, "ctrlUnitId");
            return (Criteria) this;
        }

        public Criteria andCtrlUnitIdGreaterThanOrEqualTo(String value) {
            addCriterion("ctrl_unit_id >=", value, "ctrlUnitId");
            return (Criteria) this;
        }

        public Criteria andCtrlUnitIdLessThan(String value) {
            addCriterion("ctrl_unit_id <", value, "ctrlUnitId");
            return (Criteria) this;
        }

        public Criteria andCtrlUnitIdLessThanOrEqualTo(String value) {
            addCriterion("ctrl_unit_id <=", value, "ctrlUnitId");
            return (Criteria) this;
        }

        public Criteria andCtrlUnitIdLike(String value) {
            addCriterion("ctrl_unit_id like", value, "ctrlUnitId");
            return (Criteria) this;
        }

        public Criteria andCtrlUnitIdNotLike(String value) {
            addCriterion("ctrl_unit_id not like", value, "ctrlUnitId");
            return (Criteria) this;
        }

        public Criteria andCtrlUnitIdIn(List<String> values) {
            addCriterion("ctrl_unit_id in", values, "ctrlUnitId");
            return (Criteria) this;
        }

        public Criteria andCtrlUnitIdNotIn(List<String> values) {
            addCriterion("ctrl_unit_id not in", values, "ctrlUnitId");
            return (Criteria) this;
        }

        public Criteria andCtrlUnitIdBetween(String value1, String value2) {
            addCriterion("ctrl_unit_id between", value1, value2, "ctrlUnitId");
            return (Criteria) this;
        }

        public Criteria andCtrlUnitIdNotBetween(String value1, String value2) {
            addCriterion("ctrl_unit_id not between", value1, value2, "ctrlUnitId");
            return (Criteria) this;
        }

        public Criteria andModuleIconIsNull() {
            addCriterion("module_icon is null");
            return (Criteria) this;
        }

        public Criteria andModuleIconIsNotNull() {
            addCriterion("module_icon is not null");
            return (Criteria) this;
        }

        public Criteria andModuleIconEqualTo(String value) {
            addCriterion("module_icon =", value, "moduleIcon");
            return (Criteria) this;
        }

        public Criteria andModuleIconNotEqualTo(String value) {
            addCriterion("module_icon <>", value, "moduleIcon");
            return (Criteria) this;
        }

        public Criteria andModuleIconGreaterThan(String value) {
            addCriterion("module_icon >", value, "moduleIcon");
            return (Criteria) this;
        }

        public Criteria andModuleIconGreaterThanOrEqualTo(String value) {
            addCriterion("module_icon >=", value, "moduleIcon");
            return (Criteria) this;
        }

        public Criteria andModuleIconLessThan(String value) {
            addCriterion("module_icon <", value, "moduleIcon");
            return (Criteria) this;
        }

        public Criteria andModuleIconLessThanOrEqualTo(String value) {
            addCriterion("module_icon <=", value, "moduleIcon");
            return (Criteria) this;
        }

        public Criteria andModuleIconLike(String value) {
            addCriterion("module_icon like", value, "moduleIcon");
            return (Criteria) this;
        }

        public Criteria andModuleIconNotLike(String value) {
            addCriterion("module_icon not like", value, "moduleIcon");
            return (Criteria) this;
        }

        public Criteria andModuleIconIn(List<String> values) {
            addCriterion("module_icon in", values, "moduleIcon");
            return (Criteria) this;
        }

        public Criteria andModuleIconNotIn(List<String> values) {
            addCriterion("module_icon not in", values, "moduleIcon");
            return (Criteria) this;
        }

        public Criteria andModuleIconBetween(String value1, String value2) {
            addCriterion("module_icon between", value1, value2, "moduleIcon");
            return (Criteria) this;
        }

        public Criteria andModuleIconNotBetween(String value1, String value2) {
            addCriterion("module_icon not between", value1, value2, "moduleIcon");
            return (Criteria) this;
        }

        public Criteria andIsDsiplayIsNull() {
            addCriterion("is_dsiplay is null");
            return (Criteria) this;
        }

        public Criteria andIsDsiplayIsNotNull() {
            addCriterion("is_dsiplay is not null");
            return (Criteria) this;
        }

        public Criteria andIsDsiplayEqualTo(String value) {
            addCriterion("is_dsiplay =", value, "isDsiplay");
            return (Criteria) this;
        }

        public Criteria andIsDsiplayNotEqualTo(String value) {
            addCriterion("is_dsiplay <>", value, "isDsiplay");
            return (Criteria) this;
        }

        public Criteria andIsDsiplayGreaterThan(String value) {
            addCriterion("is_dsiplay >", value, "isDsiplay");
            return (Criteria) this;
        }

        public Criteria andIsDsiplayGreaterThanOrEqualTo(String value) {
            addCriterion("is_dsiplay >=", value, "isDsiplay");
            return (Criteria) this;
        }

        public Criteria andIsDsiplayLessThan(String value) {
            addCriterion("is_dsiplay <", value, "isDsiplay");
            return (Criteria) this;
        }

        public Criteria andIsDsiplayLessThanOrEqualTo(String value) {
            addCriterion("is_dsiplay <=", value, "isDsiplay");
            return (Criteria) this;
        }

        public Criteria andIsDsiplayLike(String value) {
            addCriterion("is_dsiplay like", value, "isDsiplay");
            return (Criteria) this;
        }

        public Criteria andIsDsiplayNotLike(String value) {
            addCriterion("is_dsiplay not like", value, "isDsiplay");
            return (Criteria) this;
        }

        public Criteria andIsDsiplayIn(List<String> values) {
            addCriterion("is_dsiplay in", values, "isDsiplay");
            return (Criteria) this;
        }

        public Criteria andIsDsiplayNotIn(List<String> values) {
            addCriterion("is_dsiplay not in", values, "isDsiplay");
            return (Criteria) this;
        }

        public Criteria andIsDsiplayBetween(String value1, String value2) {
            addCriterion("is_dsiplay between", value1, value2, "isDsiplay");
            return (Criteria) this;
        }

        public Criteria andIsDsiplayNotBetween(String value1, String value2) {
            addCriterion("is_dsiplay not between", value1, value2, "isDsiplay");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderIsNull() {
            addCriterion("display_order is null");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderIsNotNull() {
            addCriterion("display_order is not null");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderEqualTo(Long value) {
            addCriterion("display_order =", value, "displayOrder");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderNotEqualTo(Long value) {
            addCriterion("display_order <>", value, "displayOrder");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderGreaterThan(Long value) {
            addCriterion("display_order >", value, "displayOrder");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderGreaterThanOrEqualTo(Long value) {
            addCriterion("display_order >=", value, "displayOrder");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderLessThan(Long value) {
            addCriterion("display_order <", value, "displayOrder");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderLessThanOrEqualTo(Long value) {
            addCriterion("display_order <=", value, "displayOrder");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderIn(List<Long> values) {
            addCriterion("display_order in", values, "displayOrder");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderNotIn(List<Long> values) {
            addCriterion("display_order not in", values, "displayOrder");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderBetween(Long value1, Long value2) {
            addCriterion("display_order between", value1, value2, "displayOrder");
            return (Criteria) this;
        }

        public Criteria andDisplayOrderNotBetween(Long value1, Long value2) {
            addCriterion("display_order not between", value1, value2, "displayOrder");
            return (Criteria) this;
        }

        public Criteria andInfo1IsNull() {
            addCriterion("info1 is null");
            return (Criteria) this;
        }

        public Criteria andInfo1IsNotNull() {
            addCriterion("info1 is not null");
            return (Criteria) this;
        }

        public Criteria andInfo1EqualTo(String value) {
            addCriterion("info1 =", value, "info1");
            return (Criteria) this;
        }

        public Criteria andInfo1NotEqualTo(String value) {
            addCriterion("info1 <>", value, "info1");
            return (Criteria) this;
        }

        public Criteria andInfo1GreaterThan(String value) {
            addCriterion("info1 >", value, "info1");
            return (Criteria) this;
        }

        public Criteria andInfo1GreaterThanOrEqualTo(String value) {
            addCriterion("info1 >=", value, "info1");
            return (Criteria) this;
        }

        public Criteria andInfo1LessThan(String value) {
            addCriterion("info1 <", value, "info1");
            return (Criteria) this;
        }

        public Criteria andInfo1LessThanOrEqualTo(String value) {
            addCriterion("info1 <=", value, "info1");
            return (Criteria) this;
        }

        public Criteria andInfo1Like(String value) {
            addCriterion("info1 like", value, "info1");
            return (Criteria) this;
        }

        public Criteria andInfo1NotLike(String value) {
            addCriterion("info1 not like", value, "info1");
            return (Criteria) this;
        }

        public Criteria andInfo1In(List<String> values) {
            addCriterion("info1 in", values, "info1");
            return (Criteria) this;
        }

        public Criteria andInfo1NotIn(List<String> values) {
            addCriterion("info1 not in", values, "info1");
            return (Criteria) this;
        }

        public Criteria andInfo1Between(String value1, String value2) {
            addCriterion("info1 between", value1, value2, "info1");
            return (Criteria) this;
        }

        public Criteria andInfo1NotBetween(String value1, String value2) {
            addCriterion("info1 not between", value1, value2, "info1");
            return (Criteria) this;
        }

        public Criteria andInfo2IsNull() {
            addCriterion("info2 is null");
            return (Criteria) this;
        }

        public Criteria andInfo2IsNotNull() {
            addCriterion("info2 is not null");
            return (Criteria) this;
        }

        public Criteria andInfo2EqualTo(String value) {
            addCriterion("info2 =", value, "info2");
            return (Criteria) this;
        }

        public Criteria andInfo2NotEqualTo(String value) {
            addCriterion("info2 <>", value, "info2");
            return (Criteria) this;
        }

        public Criteria andInfo2GreaterThan(String value) {
            addCriterion("info2 >", value, "info2");
            return (Criteria) this;
        }

        public Criteria andInfo2GreaterThanOrEqualTo(String value) {
            addCriterion("info2 >=", value, "info2");
            return (Criteria) this;
        }

        public Criteria andInfo2LessThan(String value) {
            addCriterion("info2 <", value, "info2");
            return (Criteria) this;
        }

        public Criteria andInfo2LessThanOrEqualTo(String value) {
            addCriterion("info2 <=", value, "info2");
            return (Criteria) this;
        }

        public Criteria andInfo2Like(String value) {
            addCriterion("info2 like", value, "info2");
            return (Criteria) this;
        }

        public Criteria andInfo2NotLike(String value) {
            addCriterion("info2 not like", value, "info2");
            return (Criteria) this;
        }

        public Criteria andInfo2In(List<String> values) {
            addCriterion("info2 in", values, "info2");
            return (Criteria) this;
        }

        public Criteria andInfo2NotIn(List<String> values) {
            addCriterion("info2 not in", values, "info2");
            return (Criteria) this;
        }

        public Criteria andInfo2Between(String value1, String value2) {
            addCriterion("info2 between", value1, value2, "info2");
            return (Criteria) this;
        }

        public Criteria andInfo2NotBetween(String value1, String value2) {
            addCriterion("info2 not between", value1, value2, "info2");
            return (Criteria) this;
        }

        public Criteria andInfo3IsNull() {
            addCriterion("info3 is null");
            return (Criteria) this;
        }

        public Criteria andInfo3IsNotNull() {
            addCriterion("info3 is not null");
            return (Criteria) this;
        }

        public Criteria andInfo3EqualTo(String value) {
            addCriterion("info3 =", value, "info3");
            return (Criteria) this;
        }

        public Criteria andInfo3NotEqualTo(String value) {
            addCriterion("info3 <>", value, "info3");
            return (Criteria) this;
        }

        public Criteria andInfo3GreaterThan(String value) {
            addCriterion("info3 >", value, "info3");
            return (Criteria) this;
        }

        public Criteria andInfo3GreaterThanOrEqualTo(String value) {
            addCriterion("info3 >=", value, "info3");
            return (Criteria) this;
        }

        public Criteria andInfo3LessThan(String value) {
            addCriterion("info3 <", value, "info3");
            return (Criteria) this;
        }

        public Criteria andInfo3LessThanOrEqualTo(String value) {
            addCriterion("info3 <=", value, "info3");
            return (Criteria) this;
        }

        public Criteria andInfo3Like(String value) {
            addCriterion("info3 like", value, "info3");
            return (Criteria) this;
        }

        public Criteria andInfo3NotLike(String value) {
            addCriterion("info3 not like", value, "info3");
            return (Criteria) this;
        }

        public Criteria andInfo3In(List<String> values) {
            addCriterion("info3 in", values, "info3");
            return (Criteria) this;
        }

        public Criteria andInfo3NotIn(List<String> values) {
            addCriterion("info3 not in", values, "info3");
            return (Criteria) this;
        }

        public Criteria andInfo3Between(String value1, String value2) {
            addCriterion("info3 between", value1, value2, "info3");
            return (Criteria) this;
        }

        public Criteria andInfo3NotBetween(String value1, String value2) {
            addCriterion("info3 not between", value1, value2, "info3");
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