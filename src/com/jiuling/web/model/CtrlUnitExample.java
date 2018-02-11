package com.jiuling.web.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CtrlUnitExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CtrlUnitExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUnitStateIsNull() {
            addCriterion("unit_state is null");
            return (Criteria) this;
        }

        public Criteria andUnitStateIsNotNull() {
            addCriterion("unit_state is not null");
            return (Criteria) this;
        }

        public Criteria andUnitStateEqualTo(Long value) {
            addCriterion("unit_state =", value, "unitState");
            return (Criteria) this;
        }

        public Criteria andUnitStateNotEqualTo(Long value) {
            addCriterion("unit_state <>", value, "unitState");
            return (Criteria) this;
        }

        public Criteria andUnitStateGreaterThan(Long value) {
            addCriterion("unit_state >", value, "unitState");
            return (Criteria) this;
        }

        public Criteria andUnitStateGreaterThanOrEqualTo(Long value) {
            addCriterion("unit_state >=", value, "unitState");
            return (Criteria) this;
        }

        public Criteria andUnitStateLessThan(Long value) {
            addCriterion("unit_state <", value, "unitState");
            return (Criteria) this;
        }

        public Criteria andUnitStateLessThanOrEqualTo(Long value) {
            addCriterion("unit_state <=", value, "unitState");
            return (Criteria) this;
        }

        public Criteria andUnitStateIn(List<Long> values) {
            addCriterion("unit_state in", values, "unitState");
            return (Criteria) this;
        }

        public Criteria andUnitStateNotIn(List<Long> values) {
            addCriterion("unit_state not in", values, "unitState");
            return (Criteria) this;
        }

        public Criteria andUnitStateBetween(Long value1, Long value2) {
            addCriterion("unit_state between", value1, value2, "unitState");
            return (Criteria) this;
        }

        public Criteria andUnitStateNotBetween(Long value1, Long value2) {
            addCriterion("unit_state not between", value1, value2, "unitState");
            return (Criteria) this;
        }

        public Criteria andUnitIdentityIsNull() {
            addCriterion("unit_identity is null");
            return (Criteria) this;
        }

        public Criteria andUnitIdentityIsNotNull() {
            addCriterion("unit_identity is not null");
            return (Criteria) this;
        }

        public Criteria andUnitIdentityEqualTo(String value) {
            addCriterion("unit_identity =", value, "unitIdentity");
            return (Criteria) this;
        }

        public Criteria andUnitIdentityNotEqualTo(String value) {
            addCriterion("unit_identity <>", value, "unitIdentity");
            return (Criteria) this;
        }

        public Criteria andUnitIdentityGreaterThan(String value) {
            addCriterion("unit_identity >", value, "unitIdentity");
            return (Criteria) this;
        }

        public Criteria andUnitIdentityGreaterThanOrEqualTo(String value) {
            addCriterion("unit_identity >=", value, "unitIdentity");
            return (Criteria) this;
        }

        public Criteria andUnitIdentityLessThan(String value) {
            addCriterion("unit_identity <", value, "unitIdentity");
            return (Criteria) this;
        }

        public Criteria andUnitIdentityLessThanOrEqualTo(String value) {
            addCriterion("unit_identity <=", value, "unitIdentity");
            return (Criteria) this;
        }

        public Criteria andUnitIdentityLike(String value) {
            addCriterion("unit_identity like", value, "unitIdentity");
            return (Criteria) this;
        }

        public Criteria andUnitIdentityNotLike(String value) {
            addCriterion("unit_identity not like", value, "unitIdentity");
            return (Criteria) this;
        }

        public Criteria andUnitIdentityIn(List<String> values) {
            addCriterion("unit_identity in", values, "unitIdentity");
            return (Criteria) this;
        }

        public Criteria andUnitIdentityNotIn(List<String> values) {
            addCriterion("unit_identity not in", values, "unitIdentity");
            return (Criteria) this;
        }

        public Criteria andUnitIdentityBetween(String value1, String value2) {
            addCriterion("unit_identity between", value1, value2, "unitIdentity");
            return (Criteria) this;
        }

        public Criteria andUnitIdentityNotBetween(String value1, String value2) {
            addCriterion("unit_identity not between", value1, value2, "unitIdentity");
            return (Criteria) this;
        }

        public Criteria andOrgTypeIsNull() {
            addCriterion("org_type is null");
            return (Criteria) this;
        }

        public Criteria andOrgTypeIsNotNull() {
            addCriterion("org_type is not null");
            return (Criteria) this;
        }

        public Criteria andOrgTypeEqualTo(String value) {
            addCriterion("org_type =", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeNotEqualTo(String value) {
            addCriterion("org_type <>", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeGreaterThan(String value) {
            addCriterion("org_type >", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeGreaterThanOrEqualTo(String value) {
            addCriterion("org_type >=", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeLessThan(String value) {
            addCriterion("org_type <", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeLessThanOrEqualTo(String value) {
            addCriterion("org_type <=", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeLike(String value) {
            addCriterion("org_type like", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeNotLike(String value) {
            addCriterion("org_type not like", value, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeIn(List<String> values) {
            addCriterion("org_type in", values, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeNotIn(List<String> values) {
            addCriterion("org_type not in", values, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeBetween(String value1, String value2) {
            addCriterion("org_type between", value1, value2, "orgType");
            return (Criteria) this;
        }

        public Criteria andOrgTypeNotBetween(String value1, String value2) {
            addCriterion("org_type not between", value1, value2, "orgType");
            return (Criteria) this;
        }

        public Criteria andShareUnitIdIsNull() {
            addCriterion("share_unit_id is null");
            return (Criteria) this;
        }

        public Criteria andShareUnitIdIsNotNull() {
            addCriterion("share_unit_id is not null");
            return (Criteria) this;
        }

        public Criteria andShareUnitIdEqualTo(Long value) {
            addCriterion("share_unit_id =", value, "shareUnitId");
            return (Criteria) this;
        }

        public Criteria andShareUnitIdNotEqualTo(Long value) {
            addCriterion("share_unit_id <>", value, "shareUnitId");
            return (Criteria) this;
        }

        public Criteria andShareUnitIdGreaterThan(Long value) {
            addCriterion("share_unit_id >", value, "shareUnitId");
            return (Criteria) this;
        }

        public Criteria andShareUnitIdGreaterThanOrEqualTo(Long value) {
            addCriterion("share_unit_id >=", value, "shareUnitId");
            return (Criteria) this;
        }

        public Criteria andShareUnitIdLessThan(Long value) {
            addCriterion("share_unit_id <", value, "shareUnitId");
            return (Criteria) this;
        }

        public Criteria andShareUnitIdLessThanOrEqualTo(Long value) {
            addCriterion("share_unit_id <=", value, "shareUnitId");
            return (Criteria) this;
        }

        public Criteria andShareUnitIdIn(List<Long> values) {
            addCriterion("share_unit_id in", values, "shareUnitId");
            return (Criteria) this;
        }

        public Criteria andShareUnitIdNotIn(List<Long> values) {
            addCriterion("share_unit_id not in", values, "shareUnitId");
            return (Criteria) this;
        }

        public Criteria andShareUnitIdBetween(Long value1, Long value2) {
            addCriterion("share_unit_id between", value1, value2, "shareUnitId");
            return (Criteria) this;
        }

        public Criteria andShareUnitIdNotBetween(Long value1, Long value2) {
            addCriterion("share_unit_id not between", value1, value2, "shareUnitId");
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

        public Criteria andUnitLevelIsNull() {
            addCriterion("unit_level is null");
            return (Criteria) this;
        }

        public Criteria andUnitLevelIsNotNull() {
            addCriterion("unit_level is not null");
            return (Criteria) this;
        }

        public Criteria andUnitLevelEqualTo(Integer value) {
            addCriterion("unit_level =", value, "unitLevel");
            return (Criteria) this;
        }

        public Criteria andUnitLevelNotEqualTo(Integer value) {
            addCriterion("unit_level <>", value, "unitLevel");
            return (Criteria) this;
        }

        public Criteria andUnitLevelGreaterThan(Integer value) {
            addCriterion("unit_level >", value, "unitLevel");
            return (Criteria) this;
        }

        public Criteria andUnitLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("unit_level >=", value, "unitLevel");
            return (Criteria) this;
        }

        public Criteria andUnitLevelLessThan(Integer value) {
            addCriterion("unit_level <", value, "unitLevel");
            return (Criteria) this;
        }

        public Criteria andUnitLevelLessThanOrEqualTo(Integer value) {
            addCriterion("unit_level <=", value, "unitLevel");
            return (Criteria) this;
        }

        public Criteria andUnitLevelIn(List<Integer> values) {
            addCriterion("unit_level in", values, "unitLevel");
            return (Criteria) this;
        }

        public Criteria andUnitLevelNotIn(List<Integer> values) {
            addCriterion("unit_level not in", values, "unitLevel");
            return (Criteria) this;
        }

        public Criteria andUnitLevelBetween(Integer value1, Integer value2) {
            addCriterion("unit_level between", value1, value2, "unitLevel");
            return (Criteria) this;
        }

        public Criteria andUnitLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("unit_level not between", value1, value2, "unitLevel");
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

        public Criteria andIsLeafIsNull() {
            addCriterion("is_leaf is null");
            return (Criteria) this;
        }

        public Criteria andIsLeafIsNotNull() {
            addCriterion("is_leaf is not null");
            return (Criteria) this;
        }

        public Criteria andIsLeafEqualTo(Long value) {
            addCriterion("is_leaf =", value, "isLeaf");
            return (Criteria) this;
        }

        public Criteria andIsLeafNotEqualTo(Long value) {
            addCriterion("is_leaf <>", value, "isLeaf");
            return (Criteria) this;
        }

        public Criteria andIsLeafGreaterThan(Long value) {
            addCriterion("is_leaf >", value, "isLeaf");
            return (Criteria) this;
        }

        public Criteria andIsLeafGreaterThanOrEqualTo(Long value) {
            addCriterion("is_leaf >=", value, "isLeaf");
            return (Criteria) this;
        }

        public Criteria andIsLeafLessThan(Long value) {
            addCriterion("is_leaf <", value, "isLeaf");
            return (Criteria) this;
        }

        public Criteria andIsLeafLessThanOrEqualTo(Long value) {
            addCriterion("is_leaf <=", value, "isLeaf");
            return (Criteria) this;
        }

        public Criteria andIsLeafIn(List<Long> values) {
            addCriterion("is_leaf in", values, "isLeaf");
            return (Criteria) this;
        }

        public Criteria andIsLeafNotIn(List<Long> values) {
            addCriterion("is_leaf not in", values, "isLeaf");
            return (Criteria) this;
        }

        public Criteria andIsLeafBetween(Long value1, Long value2) {
            addCriterion("is_leaf between", value1, value2, "isLeaf");
            return (Criteria) this;
        }

        public Criteria andIsLeafNotBetween(Long value1, Long value2) {
            addCriterion("is_leaf not between", value1, value2, "isLeaf");
            return (Criteria) this;
        }

        public Criteria andSeqNumIsNull() {
            addCriterion("seq_num is null");
            return (Criteria) this;
        }

        public Criteria andSeqNumIsNotNull() {
            addCriterion("seq_num is not null");
            return (Criteria) this;
        }

        public Criteria andSeqNumEqualTo(Long value) {
            addCriterion("seq_num =", value, "seqNum");
            return (Criteria) this;
        }

        public Criteria andSeqNumNotEqualTo(Long value) {
            addCriterion("seq_num <>", value, "seqNum");
            return (Criteria) this;
        }

        public Criteria andSeqNumGreaterThan(Long value) {
            addCriterion("seq_num >", value, "seqNum");
            return (Criteria) this;
        }

        public Criteria andSeqNumGreaterThanOrEqualTo(Long value) {
            addCriterion("seq_num >=", value, "seqNum");
            return (Criteria) this;
        }

        public Criteria andSeqNumLessThan(Long value) {
            addCriterion("seq_num <", value, "seqNum");
            return (Criteria) this;
        }

        public Criteria andSeqNumLessThanOrEqualTo(Long value) {
            addCriterion("seq_num <=", value, "seqNum");
            return (Criteria) this;
        }

        public Criteria andSeqNumIn(List<Long> values) {
            addCriterion("seq_num in", values, "seqNum");
            return (Criteria) this;
        }

        public Criteria andSeqNumNotIn(List<Long> values) {
            addCriterion("seq_num not in", values, "seqNum");
            return (Criteria) this;
        }

        public Criteria andSeqNumBetween(Long value1, Long value2) {
            addCriterion("seq_num between", value1, value2, "seqNum");
            return (Criteria) this;
        }

        public Criteria andSeqNumNotBetween(Long value1, Long value2) {
            addCriterion("seq_num not between", value1, value2, "seqNum");
            return (Criteria) this;
        }

        public Criteria andUnitNameIsNull() {
            addCriterion("unit_name is null");
            return (Criteria) this;
        }

        public Criteria andUnitNameIsNotNull() {
            addCriterion("unit_name is not null");
            return (Criteria) this;
        }

        public Criteria andUnitNameEqualTo(String value) {
            addCriterion("unit_name =", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameNotEqualTo(String value) {
            addCriterion("unit_name <>", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameGreaterThan(String value) {
            addCriterion("unit_name >", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameGreaterThanOrEqualTo(String value) {
            addCriterion("unit_name >=", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameLessThan(String value) {
            addCriterion("unit_name <", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameLessThanOrEqualTo(String value) {
            addCriterion("unit_name <=", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameLike(String value) {
            addCriterion("unit_name like", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameNotLike(String value) {
            addCriterion("unit_name not like", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameIn(List<String> values) {
            addCriterion("unit_name in", values, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameNotIn(List<String> values) {
            addCriterion("unit_name not in", values, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameBetween(String value1, String value2) {
            addCriterion("unit_name between", value1, value2, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameNotBetween(String value1, String value2) {
            addCriterion("unit_name not between", value1, value2, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNumberIsNull() {
            addCriterion("unit_number is null");
            return (Criteria) this;
        }

        public Criteria andUnitNumberIsNotNull() {
            addCriterion("unit_number is not null");
            return (Criteria) this;
        }

        public Criteria andUnitNumberEqualTo(String value) {
            addCriterion("unit_number =", value, "unitNumber");
            return (Criteria) this;
        }

        public Criteria andUnitNumberNotEqualTo(String value) {
            addCriterion("unit_number <>", value, "unitNumber");
            return (Criteria) this;
        }

        public Criteria andUnitNumberGreaterThan(String value) {
            addCriterion("unit_number >", value, "unitNumber");
            return (Criteria) this;
        }

        public Criteria andUnitNumberGreaterThanOrEqualTo(String value) {
            addCriterion("unit_number >=", value, "unitNumber");
            return (Criteria) this;
        }

        public Criteria andUnitNumberLessThan(String value) {
            addCriterion("unit_number <", value, "unitNumber");
            return (Criteria) this;
        }

        public Criteria andUnitNumberLessThanOrEqualTo(String value) {
            addCriterion("unit_number <=", value, "unitNumber");
            return (Criteria) this;
        }

        public Criteria andUnitNumberLike(String value) {
            addCriterion("unit_number like", value, "unitNumber");
            return (Criteria) this;
        }

        public Criteria andUnitNumberNotLike(String value) {
            addCriterion("unit_number not like", value, "unitNumber");
            return (Criteria) this;
        }

        public Criteria andUnitNumberIn(List<String> values) {
            addCriterion("unit_number in", values, "unitNumber");
            return (Criteria) this;
        }

        public Criteria andUnitNumberNotIn(List<String> values) {
            addCriterion("unit_number not in", values, "unitNumber");
            return (Criteria) this;
        }

        public Criteria andUnitNumberBetween(String value1, String value2) {
            addCriterion("unit_number between", value1, value2, "unitNumber");
            return (Criteria) this;
        }

        public Criteria andUnitNumberNotBetween(String value1, String value2) {
            addCriterion("unit_number not between", value1, value2, "unitNumber");
            return (Criteria) this;
        }

        public Criteria andUnitDescriptionIsNull() {
            addCriterion("unit_description is null");
            return (Criteria) this;
        }

        public Criteria andUnitDescriptionIsNotNull() {
            addCriterion("unit_description is not null");
            return (Criteria) this;
        }

        public Criteria andUnitDescriptionEqualTo(String value) {
            addCriterion("unit_description =", value, "unitDescription");
            return (Criteria) this;
        }

        public Criteria andUnitDescriptionNotEqualTo(String value) {
            addCriterion("unit_description <>", value, "unitDescription");
            return (Criteria) this;
        }

        public Criteria andUnitDescriptionGreaterThan(String value) {
            addCriterion("unit_description >", value, "unitDescription");
            return (Criteria) this;
        }

        public Criteria andUnitDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("unit_description >=", value, "unitDescription");
            return (Criteria) this;
        }

        public Criteria andUnitDescriptionLessThan(String value) {
            addCriterion("unit_description <", value, "unitDescription");
            return (Criteria) this;
        }

        public Criteria andUnitDescriptionLessThanOrEqualTo(String value) {
            addCriterion("unit_description <=", value, "unitDescription");
            return (Criteria) this;
        }

        public Criteria andUnitDescriptionLike(String value) {
            addCriterion("unit_description like", value, "unitDescription");
            return (Criteria) this;
        }

        public Criteria andUnitDescriptionNotLike(String value) {
            addCriterion("unit_description not like", value, "unitDescription");
            return (Criteria) this;
        }

        public Criteria andUnitDescriptionIn(List<String> values) {
            addCriterion("unit_description in", values, "unitDescription");
            return (Criteria) this;
        }

        public Criteria andUnitDescriptionNotIn(List<String> values) {
            addCriterion("unit_description not in", values, "unitDescription");
            return (Criteria) this;
        }

        public Criteria andUnitDescriptionBetween(String value1, String value2) {
            addCriterion("unit_description between", value1, value2, "unitDescription");
            return (Criteria) this;
        }

        public Criteria andUnitDescriptionNotBetween(String value1, String value2) {
            addCriterion("unit_description not between", value1, value2, "unitDescription");
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

        public Criteria andUnitParentIdIsNull() {
            addCriterion("unit_parent_id is null");
            return (Criteria) this;
        }

        public Criteria andUnitParentIdIsNotNull() {
            addCriterion("unit_parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andUnitParentIdEqualTo(String value) {
            addCriterion("unit_parent_id =", value, "unitParentId");
            return (Criteria) this;
        }

        public Criteria andUnitParentIdNotEqualTo(String value) {
            addCriterion("unit_parent_id <>", value, "unitParentId");
            return (Criteria) this;
        }

        public Criteria andUnitParentIdGreaterThan(String value) {
            addCriterion("unit_parent_id >", value, "unitParentId");
            return (Criteria) this;
        }

        public Criteria andUnitParentIdGreaterThanOrEqualTo(String value) {
            addCriterion("unit_parent_id >=", value, "unitParentId");
            return (Criteria) this;
        }

        public Criteria andUnitParentIdLessThan(String value) {
            addCriterion("unit_parent_id <", value, "unitParentId");
            return (Criteria) this;
        }

        public Criteria andUnitParentIdLessThanOrEqualTo(String value) {
            addCriterion("unit_parent_id <=", value, "unitParentId");
            return (Criteria) this;
        }

        public Criteria andUnitParentIdLike(String value) {
            addCriterion("unit_parent_id like", value, "unitParentId");
            return (Criteria) this;
        }

        public Criteria andUnitParentIdNotLike(String value) {
            addCriterion("unit_parent_id not like", value, "unitParentId");
            return (Criteria) this;
        }

        public Criteria andUnitParentIdIn(List<String> values) {
            addCriterion("unit_parent_id in", values, "unitParentId");
            return (Criteria) this;
        }

        public Criteria andUnitParentIdNotIn(List<String> values) {
            addCriterion("unit_parent_id not in", values, "unitParentId");
            return (Criteria) this;
        }

        public Criteria andUnitParentIdBetween(String value1, String value2) {
            addCriterion("unit_parent_id between", value1, value2, "unitParentId");
            return (Criteria) this;
        }

        public Criteria andUnitParentIdNotBetween(String value1, String value2) {
            addCriterion("unit_parent_id not between", value1, value2, "unitParentId");
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