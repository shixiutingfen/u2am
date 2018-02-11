package com.jiuling.web.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PersonResultExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PersonResultExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSerialnumberIsNull() {
            addCriterion("serialnumber is null");
            return (Criteria) this;
        }

        public Criteria andSerialnumberIsNotNull() {
            addCriterion("serialnumber is not null");
            return (Criteria) this;
        }

        public Criteria andSerialnumberEqualTo(String value) {
            addCriterion("serialnumber =", value, "serialnumber");
            return (Criteria) this;
        }

        public Criteria andSerialnumberNotEqualTo(String value) {
            addCriterion("serialnumber <>", value, "serialnumber");
            return (Criteria) this;
        }

        public Criteria andSerialnumberGreaterThan(String value) {
            addCriterion("serialnumber >", value, "serialnumber");
            return (Criteria) this;
        }

        public Criteria andSerialnumberGreaterThanOrEqualTo(String value) {
            addCriterion("serialnumber >=", value, "serialnumber");
            return (Criteria) this;
        }

        public Criteria andSerialnumberLessThan(String value) {
            addCriterion("serialnumber <", value, "serialnumber");
            return (Criteria) this;
        }

        public Criteria andSerialnumberLessThanOrEqualTo(String value) {
            addCriterion("serialnumber <=", value, "serialnumber");
            return (Criteria) this;
        }

        public Criteria andSerialnumberLike(String value) {
            addCriterion("serialnumber like", value, "serialnumber");
            return (Criteria) this;
        }

        public Criteria andSerialnumberNotLike(String value) {
            addCriterion("serialnumber not like", value, "serialnumber");
            return (Criteria) this;
        }

        public Criteria andSerialnumberIn(List<String> values) {
            addCriterion("serialnumber in", values, "serialnumber");
            return (Criteria) this;
        }

        public Criteria andSerialnumberNotIn(List<String> values) {
            addCriterion("serialnumber not in", values, "serialnumber");
            return (Criteria) this;
        }

        public Criteria andSerialnumberBetween(String value1, String value2) {
            addCriterion("serialnumber between", value1, value2, "serialnumber");
            return (Criteria) this;
        }

        public Criteria andSerialnumberNotBetween(String value1, String value2) {
            addCriterion("serialnumber not between", value1, value2, "serialnumber");
            return (Criteria) this;
        }

        public Criteria andCameraidIsNull() {
            addCriterion("cameraid is null");
            return (Criteria) this;
        }

        public Criteria andCameraidIsNotNull() {
            addCriterion("cameraid is not null");
            return (Criteria) this;
        }

        public Criteria andCameraidEqualTo(Long value) {
            addCriterion("cameraid =", value, "cameraid");
            return (Criteria) this;
        }

        public Criteria andCameraidNotEqualTo(Long value) {
            addCriterion("cameraid <>", value, "cameraid");
            return (Criteria) this;
        }

        public Criteria andCameraidGreaterThan(Long value) {
            addCriterion("cameraid >", value, "cameraid");
            return (Criteria) this;
        }

        public Criteria andCameraidGreaterThanOrEqualTo(Long value) {
            addCriterion("cameraid >=", value, "cameraid");
            return (Criteria) this;
        }

        public Criteria andCameraidLessThan(Long value) {
            addCriterion("cameraid <", value, "cameraid");
            return (Criteria) this;
        }

        public Criteria andCameraidLessThanOrEqualTo(Long value) {
            addCriterion("cameraid <=", value, "cameraid");
            return (Criteria) this;
        }

        public Criteria andCameraidIn(List<Long> values) {
            addCriterion("cameraid in", values, "cameraid");
            return (Criteria) this;
        }

        public Criteria andCameraidNotIn(List<Long> values) {
            addCriterion("cameraid not in", values, "cameraid");
            return (Criteria) this;
        }

        public Criteria andCameraidBetween(Long value1, Long value2) {
            addCriterion("cameraid between", value1, value2, "cameraid");
            return (Criteria) this;
        }

        public Criteria andCameraidNotBetween(Long value1, Long value2) {
            addCriterion("cameraid not between", value1, value2, "cameraid");
            return (Criteria) this;
        }

        public Criteria andImgurlIsNull() {
            addCriterion("imgurl is null");
            return (Criteria) this;
        }

        public Criteria andImgurlIsNotNull() {
            addCriterion("imgurl is not null");
            return (Criteria) this;
        }

        public Criteria andImgurlEqualTo(String value) {
            addCriterion("imgurl =", value, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlNotEqualTo(String value) {
            addCriterion("imgurl <>", value, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlGreaterThan(String value) {
            addCriterion("imgurl >", value, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlGreaterThanOrEqualTo(String value) {
            addCriterion("imgurl >=", value, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlLessThan(String value) {
            addCriterion("imgurl <", value, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlLessThanOrEqualTo(String value) {
            addCriterion("imgurl <=", value, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlLike(String value) {
            addCriterion("imgurl like", value, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlNotLike(String value) {
            addCriterion("imgurl not like", value, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlIn(List<String> values) {
            addCriterion("imgurl in", values, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlNotIn(List<String> values) {
            addCriterion("imgurl not in", values, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlBetween(String value1, String value2) {
            addCriterion("imgurl between", value1, value2, "imgurl");
            return (Criteria) this;
        }

        public Criteria andImgurlNotBetween(String value1, String value2) {
            addCriterion("imgurl not between", value1, value2, "imgurl");
            return (Criteria) this;
        }

        public Criteria andBigimgurlIsNull() {
            addCriterion("bigimgurl is null");
            return (Criteria) this;
        }

        public Criteria andBigimgurlIsNotNull() {
            addCriterion("bigimgurl is not null");
            return (Criteria) this;
        }

        public Criteria andBigimgurlEqualTo(String value) {
            addCriterion("bigimgurl =", value, "bigimgurl");
            return (Criteria) this;
        }

        public Criteria andBigimgurlNotEqualTo(String value) {
            addCriterion("bigimgurl <>", value, "bigimgurl");
            return (Criteria) this;
        }

        public Criteria andBigimgurlGreaterThan(String value) {
            addCriterion("bigimgurl >", value, "bigimgurl");
            return (Criteria) this;
        }

        public Criteria andBigimgurlGreaterThanOrEqualTo(String value) {
            addCriterion("bigimgurl >=", value, "bigimgurl");
            return (Criteria) this;
        }

        public Criteria andBigimgurlLessThan(String value) {
            addCriterion("bigimgurl <", value, "bigimgurl");
            return (Criteria) this;
        }

        public Criteria andBigimgurlLessThanOrEqualTo(String value) {
            addCriterion("bigimgurl <=", value, "bigimgurl");
            return (Criteria) this;
        }

        public Criteria andBigimgurlLike(String value) {
            addCriterion("bigimgurl like", value, "bigimgurl");
            return (Criteria) this;
        }

        public Criteria andBigimgurlNotLike(String value) {
            addCriterion("bigimgurl not like", value, "bigimgurl");
            return (Criteria) this;
        }

        public Criteria andBigimgurlIn(List<String> values) {
            addCriterion("bigimgurl in", values, "bigimgurl");
            return (Criteria) this;
        }

        public Criteria andBigimgurlNotIn(List<String> values) {
            addCriterion("bigimgurl not in", values, "bigimgurl");
            return (Criteria) this;
        }

        public Criteria andBigimgurlBetween(String value1, String value2) {
            addCriterion("bigimgurl between", value1, value2, "bigimgurl");
            return (Criteria) this;
        }

        public Criteria andBigimgurlNotBetween(String value1, String value2) {
            addCriterion("bigimgurl not between", value1, value2, "bigimgurl");
            return (Criteria) this;
        }

        public Criteria andObjtypeIsNull() {
            addCriterion("objtype is null");
            return (Criteria) this;
        }

        public Criteria andObjtypeIsNotNull() {
            addCriterion("objtype is not null");
            return (Criteria) this;
        }

        public Criteria andObjtypeEqualTo(Short value) {
            addCriterion("objtype =", value, "objtype");
            return (Criteria) this;
        }

        public Criteria andObjtypeNotEqualTo(Short value) {
            addCriterion("objtype <>", value, "objtype");
            return (Criteria) this;
        }

        public Criteria andObjtypeGreaterThan(Short value) {
            addCriterion("objtype >", value, "objtype");
            return (Criteria) this;
        }

        public Criteria andObjtypeGreaterThanOrEqualTo(Short value) {
            addCriterion("objtype >=", value, "objtype");
            return (Criteria) this;
        }

        public Criteria andObjtypeLessThan(Short value) {
            addCriterion("objtype <", value, "objtype");
            return (Criteria) this;
        }

        public Criteria andObjtypeLessThanOrEqualTo(Short value) {
            addCriterion("objtype <=", value, "objtype");
            return (Criteria) this;
        }

        public Criteria andObjtypeIn(List<Short> values) {
            addCriterion("objtype in", values, "objtype");
            return (Criteria) this;
        }

        public Criteria andObjtypeNotIn(List<Short> values) {
            addCriterion("objtype not in", values, "objtype");
            return (Criteria) this;
        }

        public Criteria andObjtypeBetween(Short value1, Short value2) {
            addCriterion("objtype between", value1, value2, "objtype");
            return (Criteria) this;
        }

        public Criteria andObjtypeNotBetween(Short value1, Short value2) {
            addCriterion("objtype not between", value1, value2, "objtype");
            return (Criteria) this;
        }

        public Criteria andFrmidxIsNull() {
            addCriterion("frmidx is null");
            return (Criteria) this;
        }

        public Criteria andFrmidxIsNotNull() {
            addCriterion("frmidx is not null");
            return (Criteria) this;
        }

        public Criteria andFrmidxEqualTo(String value) {
            addCriterion("frmidx =", value, "frmidx");
            return (Criteria) this;
        }

        public Criteria andFrmidxNotEqualTo(String value) {
            addCriterion("frmidx <>", value, "frmidx");
            return (Criteria) this;
        }

        public Criteria andFrmidxGreaterThan(String value) {
            addCriterion("frmidx >", value, "frmidx");
            return (Criteria) this;
        }

        public Criteria andFrmidxGreaterThanOrEqualTo(String value) {
            addCriterion("frmidx >=", value, "frmidx");
            return (Criteria) this;
        }

        public Criteria andFrmidxLessThan(String value) {
            addCriterion("frmidx <", value, "frmidx");
            return (Criteria) this;
        }

        public Criteria andFrmidxLessThanOrEqualTo(String value) {
            addCriterion("frmidx <=", value, "frmidx");
            return (Criteria) this;
        }

        public Criteria andFrmidxLike(String value) {
            addCriterion("frmidx like", value, "frmidx");
            return (Criteria) this;
        }

        public Criteria andFrmidxNotLike(String value) {
            addCriterion("frmidx not like", value, "frmidx");
            return (Criteria) this;
        }

        public Criteria andFrmidxIn(List<String> values) {
            addCriterion("frmidx in", values, "frmidx");
            return (Criteria) this;
        }

        public Criteria andFrmidxNotIn(List<String> values) {
            addCriterion("frmidx not in", values, "frmidx");
            return (Criteria) this;
        }

        public Criteria andFrmidxBetween(String value1, String value2) {
            addCriterion("frmidx between", value1, value2, "frmidx");
            return (Criteria) this;
        }

        public Criteria andFrmidxNotBetween(String value1, String value2) {
            addCriterion("frmidx not between", value1, value2, "frmidx");
            return (Criteria) this;
        }

        public Criteria andPosIsNull() {
            addCriterion("pos is null");
            return (Criteria) this;
        }

        public Criteria andPosIsNotNull() {
            addCriterion("pos is not null");
            return (Criteria) this;
        }

        public Criteria andPosEqualTo(String value) {
            addCriterion("pos =", value, "pos");
            return (Criteria) this;
        }

        public Criteria andPosNotEqualTo(String value) {
            addCriterion("pos <>", value, "pos");
            return (Criteria) this;
        }

        public Criteria andPosGreaterThan(String value) {
            addCriterion("pos >", value, "pos");
            return (Criteria) this;
        }

        public Criteria andPosGreaterThanOrEqualTo(String value) {
            addCriterion("pos >=", value, "pos");
            return (Criteria) this;
        }

        public Criteria andPosLessThan(String value) {
            addCriterion("pos <", value, "pos");
            return (Criteria) this;
        }

        public Criteria andPosLessThanOrEqualTo(String value) {
            addCriterion("pos <=", value, "pos");
            return (Criteria) this;
        }

        public Criteria andPosLike(String value) {
            addCriterion("pos like", value, "pos");
            return (Criteria) this;
        }

        public Criteria andPosNotLike(String value) {
            addCriterion("pos not like", value, "pos");
            return (Criteria) this;
        }

        public Criteria andPosIn(List<String> values) {
            addCriterion("pos in", values, "pos");
            return (Criteria) this;
        }

        public Criteria andPosNotIn(List<String> values) {
            addCriterion("pos not in", values, "pos");
            return (Criteria) this;
        }

        public Criteria andPosBetween(String value1, String value2) {
            addCriterion("pos between", value1, value2, "pos");
            return (Criteria) this;
        }

        public Criteria andPosNotBetween(String value1, String value2) {
            addCriterion("pos not between", value1, value2, "pos");
            return (Criteria) this;
        }

        public Criteria andHeadPosIsNull() {
            addCriterion("head_pos is null");
            return (Criteria) this;
        }

        public Criteria andHeadPosIsNotNull() {
            addCriterion("head_pos is not null");
            return (Criteria) this;
        }

        public Criteria andHeadPosEqualTo(String value) {
            addCriterion("head_pos =", value, "headPos");
            return (Criteria) this;
        }

        public Criteria andHeadPosNotEqualTo(String value) {
            addCriterion("head_pos <>", value, "headPos");
            return (Criteria) this;
        }

        public Criteria andHeadPosGreaterThan(String value) {
            addCriterion("head_pos >", value, "headPos");
            return (Criteria) this;
        }

        public Criteria andHeadPosGreaterThanOrEqualTo(String value) {
            addCriterion("head_pos >=", value, "headPos");
            return (Criteria) this;
        }

        public Criteria andHeadPosLessThan(String value) {
            addCriterion("head_pos <", value, "headPos");
            return (Criteria) this;
        }

        public Criteria andHeadPosLessThanOrEqualTo(String value) {
            addCriterion("head_pos <=", value, "headPos");
            return (Criteria) this;
        }

        public Criteria andHeadPosLike(String value) {
            addCriterion("head_pos like", value, "headPos");
            return (Criteria) this;
        }

        public Criteria andHeadPosNotLike(String value) {
            addCriterion("head_pos not like", value, "headPos");
            return (Criteria) this;
        }

        public Criteria andHeadPosIn(List<String> values) {
            addCriterion("head_pos in", values, "headPos");
            return (Criteria) this;
        }

        public Criteria andHeadPosNotIn(List<String> values) {
            addCriterion("head_pos not in", values, "headPos");
            return (Criteria) this;
        }

        public Criteria andHeadPosBetween(String value1, String value2) {
            addCriterion("head_pos between", value1, value2, "headPos");
            return (Criteria) this;
        }

        public Criteria andHeadPosNotBetween(String value1, String value2) {
            addCriterion("head_pos not between", value1, value2, "headPos");
            return (Criteria) this;
        }

        public Criteria andUpperbodyPosIsNull() {
            addCriterion("upperbody_pos is null");
            return (Criteria) this;
        }

        public Criteria andUpperbodyPosIsNotNull() {
            addCriterion("upperbody_pos is not null");
            return (Criteria) this;
        }

        public Criteria andUpperbodyPosEqualTo(String value) {
            addCriterion("upperbody_pos =", value, "upperbodyPos");
            return (Criteria) this;
        }

        public Criteria andUpperbodyPosNotEqualTo(String value) {
            addCriterion("upperbody_pos <>", value, "upperbodyPos");
            return (Criteria) this;
        }

        public Criteria andUpperbodyPosGreaterThan(String value) {
            addCriterion("upperbody_pos >", value, "upperbodyPos");
            return (Criteria) this;
        }

        public Criteria andUpperbodyPosGreaterThanOrEqualTo(String value) {
            addCriterion("upperbody_pos >=", value, "upperbodyPos");
            return (Criteria) this;
        }

        public Criteria andUpperbodyPosLessThan(String value) {
            addCriterion("upperbody_pos <", value, "upperbodyPos");
            return (Criteria) this;
        }

        public Criteria andUpperbodyPosLessThanOrEqualTo(String value) {
            addCriterion("upperbody_pos <=", value, "upperbodyPos");
            return (Criteria) this;
        }

        public Criteria andUpperbodyPosLike(String value) {
            addCriterion("upperbody_pos like", value, "upperbodyPos");
            return (Criteria) this;
        }

        public Criteria andUpperbodyPosNotLike(String value) {
            addCriterion("upperbody_pos not like", value, "upperbodyPos");
            return (Criteria) this;
        }

        public Criteria andUpperbodyPosIn(List<String> values) {
            addCriterion("upperbody_pos in", values, "upperbodyPos");
            return (Criteria) this;
        }

        public Criteria andUpperbodyPosNotIn(List<String> values) {
            addCriterion("upperbody_pos not in", values, "upperbodyPos");
            return (Criteria) this;
        }

        public Criteria andUpperbodyPosBetween(String value1, String value2) {
            addCriterion("upperbody_pos between", value1, value2, "upperbodyPos");
            return (Criteria) this;
        }

        public Criteria andUpperbodyPosNotBetween(String value1, String value2) {
            addCriterion("upperbody_pos not between", value1, value2, "upperbodyPos");
            return (Criteria) this;
        }

        public Criteria andEnlargeposIsNull() {
            addCriterion("enlargePos is null");
            return (Criteria) this;
        }

        public Criteria andEnlargeposIsNotNull() {
            addCriterion("enlargePos is not null");
            return (Criteria) this;
        }

        public Criteria andEnlargeposEqualTo(String value) {
            addCriterion("enlargePos =", value, "enlargepos");
            return (Criteria) this;
        }

        public Criteria andEnlargeposNotEqualTo(String value) {
            addCriterion("enlargePos <>", value, "enlargepos");
            return (Criteria) this;
        }

        public Criteria andEnlargeposGreaterThan(String value) {
            addCriterion("enlargePos >", value, "enlargepos");
            return (Criteria) this;
        }

        public Criteria andEnlargeposGreaterThanOrEqualTo(String value) {
            addCriterion("enlargePos >=", value, "enlargepos");
            return (Criteria) this;
        }

        public Criteria andEnlargeposLessThan(String value) {
            addCriterion("enlargePos <", value, "enlargepos");
            return (Criteria) this;
        }

        public Criteria andEnlargeposLessThanOrEqualTo(String value) {
            addCriterion("enlargePos <=", value, "enlargepos");
            return (Criteria) this;
        }

        public Criteria andEnlargeposLike(String value) {
            addCriterion("enlargePos like", value, "enlargepos");
            return (Criteria) this;
        }

        public Criteria andEnlargeposNotLike(String value) {
            addCriterion("enlargePos not like", value, "enlargepos");
            return (Criteria) this;
        }

        public Criteria andEnlargeposIn(List<String> values) {
            addCriterion("enlargePos in", values, "enlargepos");
            return (Criteria) this;
        }

        public Criteria andEnlargeposNotIn(List<String> values) {
            addCriterion("enlargePos not in", values, "enlargepos");
            return (Criteria) this;
        }

        public Criteria andEnlargeposBetween(String value1, String value2) {
            addCriterion("enlargePos between", value1, value2, "enlargepos");
            return (Criteria) this;
        }

        public Criteria andEnlargeposNotBetween(String value1, String value2) {
            addCriterion("enlargePos not between", value1, value2, "enlargepos");
            return (Criteria) this;
        }

        public Criteria andUppercolorIsNull() {
            addCriterion("uppercolor is null");
            return (Criteria) this;
        }

        public Criteria andUppercolorIsNotNull() {
            addCriterion("uppercolor is not null");
            return (Criteria) this;
        }

        public Criteria andUppercolorEqualTo(String value) {
            addCriterion("uppercolor =", value, "uppercolor");
            return (Criteria) this;
        }

        public Criteria andUppercolorNotEqualTo(String value) {
            addCriterion("uppercolor <>", value, "uppercolor");
            return (Criteria) this;
        }

        public Criteria andUppercolorGreaterThan(String value) {
            addCriterion("uppercolor >", value, "uppercolor");
            return (Criteria) this;
        }

        public Criteria andUppercolorGreaterThanOrEqualTo(String value) {
            addCriterion("uppercolor >=", value, "uppercolor");
            return (Criteria) this;
        }

        public Criteria andUppercolorLessThan(String value) {
            addCriterion("uppercolor <", value, "uppercolor");
            return (Criteria) this;
        }

        public Criteria andUppercolorLessThanOrEqualTo(String value) {
            addCriterion("uppercolor <=", value, "uppercolor");
            return (Criteria) this;
        }

        public Criteria andUppercolorLike(String value) {
            addCriterion("uppercolor like", value, "uppercolor");
            return (Criteria) this;
        }

        public Criteria andUppercolorNotLike(String value) {
            addCriterion("uppercolor not like", value, "uppercolor");
            return (Criteria) this;
        }

        public Criteria andUppercolorIn(List<String> values) {
            addCriterion("uppercolor in", values, "uppercolor");
            return (Criteria) this;
        }

        public Criteria andUppercolorNotIn(List<String> values) {
            addCriterion("uppercolor not in", values, "uppercolor");
            return (Criteria) this;
        }

        public Criteria andUppercolorBetween(String value1, String value2) {
            addCriterion("uppercolor between", value1, value2, "uppercolor");
            return (Criteria) this;
        }

        public Criteria andUppercolorNotBetween(String value1, String value2) {
            addCriterion("uppercolor not between", value1, value2, "uppercolor");
            return (Criteria) this;
        }

        public Criteria andGenderIsNull() {
            addCriterion("gender is null");
            return (Criteria) this;
        }

        public Criteria andGenderIsNotNull() {
            addCriterion("gender is not null");
            return (Criteria) this;
        }

        public Criteria andGenderEqualTo(Byte value) {
            addCriterion("gender =", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotEqualTo(Byte value) {
            addCriterion("gender <>", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThan(Byte value) {
            addCriterion("gender >", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderGreaterThanOrEqualTo(Byte value) {
            addCriterion("gender >=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThan(Byte value) {
            addCriterion("gender <", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderLessThanOrEqualTo(Byte value) {
            addCriterion("gender <=", value, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderIn(List<Byte> values) {
            addCriterion("gender in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotIn(List<Byte> values) {
            addCriterion("gender not in", values, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderBetween(Byte value1, Byte value2) {
            addCriterion("gender between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andGenderNotBetween(Byte value1, Byte value2) {
            addCriterion("gender not between", value1, value2, "gender");
            return (Criteria) this;
        }

        public Criteria andAgeIsNull() {
            addCriterion("age is null");
            return (Criteria) this;
        }

        public Criteria andAgeIsNotNull() {
            addCriterion("age is not null");
            return (Criteria) this;
        }

        public Criteria andAgeEqualTo(Byte value) {
            addCriterion("age =", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotEqualTo(Byte value) {
            addCriterion("age <>", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThan(Byte value) {
            addCriterion("age >", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeGreaterThanOrEqualTo(Byte value) {
            addCriterion("age >=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThan(Byte value) {
            addCriterion("age <", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeLessThanOrEqualTo(Byte value) {
            addCriterion("age <=", value, "age");
            return (Criteria) this;
        }

        public Criteria andAgeIn(List<Byte> values) {
            addCriterion("age in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotIn(List<Byte> values) {
            addCriterion("age not in", values, "age");
            return (Criteria) this;
        }

        public Criteria andAgeBetween(Byte value1, Byte value2) {
            addCriterion("age between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andAgeNotBetween(Byte value1, Byte value2) {
            addCriterion("age not between", value1, value2, "age");
            return (Criteria) this;
        }

        public Criteria andWheelsIsNull() {
            addCriterion("wheels is null");
            return (Criteria) this;
        }

        public Criteria andWheelsIsNotNull() {
            addCriterion("wheels is not null");
            return (Criteria) this;
        }

        public Criteria andWheelsEqualTo(Byte value) {
            addCriterion("wheels =", value, "wheels");
            return (Criteria) this;
        }

        public Criteria andWheelsNotEqualTo(Byte value) {
            addCriterion("wheels <>", value, "wheels");
            return (Criteria) this;
        }

        public Criteria andWheelsGreaterThan(Byte value) {
            addCriterion("wheels >", value, "wheels");
            return (Criteria) this;
        }

        public Criteria andWheelsGreaterThanOrEqualTo(Byte value) {
            addCriterion("wheels >=", value, "wheels");
            return (Criteria) this;
        }

        public Criteria andWheelsLessThan(Byte value) {
            addCriterion("wheels <", value, "wheels");
            return (Criteria) this;
        }

        public Criteria andWheelsLessThanOrEqualTo(Byte value) {
            addCriterion("wheels <=", value, "wheels");
            return (Criteria) this;
        }

        public Criteria andWheelsIn(List<Byte> values) {
            addCriterion("wheels in", values, "wheels");
            return (Criteria) this;
        }

        public Criteria andWheelsNotIn(List<Byte> values) {
            addCriterion("wheels not in", values, "wheels");
            return (Criteria) this;
        }

        public Criteria andWheelsBetween(Byte value1, Byte value2) {
            addCriterion("wheels between", value1, value2, "wheels");
            return (Criteria) this;
        }

        public Criteria andWheelsNotBetween(Byte value1, Byte value2) {
            addCriterion("wheels not between", value1, value2, "wheels");
            return (Criteria) this;
        }

        public Criteria andBackpackIsNull() {
            addCriterion("backpack is null");
            return (Criteria) this;
        }

        public Criteria andBackpackIsNotNull() {
            addCriterion("backpack is not null");
            return (Criteria) this;
        }

        public Criteria andBackpackEqualTo(Byte value) {
            addCriterion("backpack =", value, "backpack");
            return (Criteria) this;
        }

        public Criteria andBackpackNotEqualTo(Byte value) {
            addCriterion("backpack <>", value, "backpack");
            return (Criteria) this;
        }

        public Criteria andBackpackGreaterThan(Byte value) {
            addCriterion("backpack >", value, "backpack");
            return (Criteria) this;
        }

        public Criteria andBackpackGreaterThanOrEqualTo(Byte value) {
            addCriterion("backpack >=", value, "backpack");
            return (Criteria) this;
        }

        public Criteria andBackpackLessThan(Byte value) {
            addCriterion("backpack <", value, "backpack");
            return (Criteria) this;
        }

        public Criteria andBackpackLessThanOrEqualTo(Byte value) {
            addCriterion("backpack <=", value, "backpack");
            return (Criteria) this;
        }

        public Criteria andBackpackIn(List<Byte> values) {
            addCriterion("backpack in", values, "backpack");
            return (Criteria) this;
        }

        public Criteria andBackpackNotIn(List<Byte> values) {
            addCriterion("backpack not in", values, "backpack");
            return (Criteria) this;
        }

        public Criteria andBackpackBetween(Byte value1, Byte value2) {
            addCriterion("backpack between", value1, value2, "backpack");
            return (Criteria) this;
        }

        public Criteria andBackpackNotBetween(Byte value1, Byte value2) {
            addCriterion("backpack not between", value1, value2, "backpack");
            return (Criteria) this;
        }

        public Criteria andGlassesIsNull() {
            addCriterion("glasses is null");
            return (Criteria) this;
        }

        public Criteria andGlassesIsNotNull() {
            addCriterion("glasses is not null");
            return (Criteria) this;
        }

        public Criteria andGlassesEqualTo(Byte value) {
            addCriterion("glasses =", value, "glasses");
            return (Criteria) this;
        }

        public Criteria andGlassesNotEqualTo(Byte value) {
            addCriterion("glasses <>", value, "glasses");
            return (Criteria) this;
        }

        public Criteria andGlassesGreaterThan(Byte value) {
            addCriterion("glasses >", value, "glasses");
            return (Criteria) this;
        }

        public Criteria andGlassesGreaterThanOrEqualTo(Byte value) {
            addCriterion("glasses >=", value, "glasses");
            return (Criteria) this;
        }

        public Criteria andGlassesLessThan(Byte value) {
            addCriterion("glasses <", value, "glasses");
            return (Criteria) this;
        }

        public Criteria andGlassesLessThanOrEqualTo(Byte value) {
            addCriterion("glasses <=", value, "glasses");
            return (Criteria) this;
        }

        public Criteria andGlassesIn(List<Byte> values) {
            addCriterion("glasses in", values, "glasses");
            return (Criteria) this;
        }

        public Criteria andGlassesNotIn(List<Byte> values) {
            addCriterion("glasses not in", values, "glasses");
            return (Criteria) this;
        }

        public Criteria andGlassesBetween(Byte value1, Byte value2) {
            addCriterion("glasses between", value1, value2, "glasses");
            return (Criteria) this;
        }

        public Criteria andGlassesNotBetween(Byte value1, Byte value2) {
            addCriterion("glasses not between", value1, value2, "glasses");
            return (Criteria) this;
        }

        public Criteria andUmbrellaIsNull() {
            addCriterion("umbrella is null");
            return (Criteria) this;
        }

        public Criteria andUmbrellaIsNotNull() {
            addCriterion("umbrella is not null");
            return (Criteria) this;
        }

        public Criteria andUmbrellaEqualTo(Byte value) {
            addCriterion("umbrella =", value, "umbrella");
            return (Criteria) this;
        }

        public Criteria andUmbrellaNotEqualTo(Byte value) {
            addCriterion("umbrella <>", value, "umbrella");
            return (Criteria) this;
        }

        public Criteria andUmbrellaGreaterThan(Byte value) {
            addCriterion("umbrella >", value, "umbrella");
            return (Criteria) this;
        }

        public Criteria andUmbrellaGreaterThanOrEqualTo(Byte value) {
            addCriterion("umbrella >=", value, "umbrella");
            return (Criteria) this;
        }

        public Criteria andUmbrellaLessThan(Byte value) {
            addCriterion("umbrella <", value, "umbrella");
            return (Criteria) this;
        }

        public Criteria andUmbrellaLessThanOrEqualTo(Byte value) {
            addCriterion("umbrella <=", value, "umbrella");
            return (Criteria) this;
        }

        public Criteria andUmbrellaIn(List<Byte> values) {
            addCriterion("umbrella in", values, "umbrella");
            return (Criteria) this;
        }

        public Criteria andUmbrellaNotIn(List<Byte> values) {
            addCriterion("umbrella not in", values, "umbrella");
            return (Criteria) this;
        }

        public Criteria andUmbrellaBetween(Byte value1, Byte value2) {
            addCriterion("umbrella between", value1, value2, "umbrella");
            return (Criteria) this;
        }

        public Criteria andUmbrellaNotBetween(Byte value1, Byte value2) {
            addCriterion("umbrella not between", value1, value2, "umbrella");
            return (Criteria) this;
        }

        public Criteria andAngleIsNull() {
            addCriterion("angle is null");
            return (Criteria) this;
        }

        public Criteria andAngleIsNotNull() {
            addCriterion("angle is not null");
            return (Criteria) this;
        }

        public Criteria andAngleEqualTo(Short value) {
            addCriterion("angle =", value, "angle");
            return (Criteria) this;
        }

        public Criteria andAngleNotEqualTo(Short value) {
            addCriterion("angle <>", value, "angle");
            return (Criteria) this;
        }

        public Criteria andAngleGreaterThan(Short value) {
            addCriterion("angle >", value, "angle");
            return (Criteria) this;
        }

        public Criteria andAngleGreaterThanOrEqualTo(Short value) {
            addCriterion("angle >=", value, "angle");
            return (Criteria) this;
        }

        public Criteria andAngleLessThan(Short value) {
            addCriterion("angle <", value, "angle");
            return (Criteria) this;
        }

        public Criteria andAngleLessThanOrEqualTo(Short value) {
            addCriterion("angle <=", value, "angle");
            return (Criteria) this;
        }

        public Criteria andAngleIn(List<Short> values) {
            addCriterion("angle in", values, "angle");
            return (Criteria) this;
        }

        public Criteria andAngleNotIn(List<Short> values) {
            addCriterion("angle not in", values, "angle");
            return (Criteria) this;
        }

        public Criteria andAngleBetween(Short value1, Short value2) {
            addCriterion("angle between", value1, value2, "angle");
            return (Criteria) this;
        }

        public Criteria andAngleNotBetween(Short value1, Short value2) {
            addCriterion("angle not between", value1, value2, "angle");
            return (Criteria) this;
        }

        public Criteria andCarryingbagIsNull() {
            addCriterion("carryingbag is null");
            return (Criteria) this;
        }

        public Criteria andCarryingbagIsNotNull() {
            addCriterion("carryingbag is not null");
            return (Criteria) this;
        }

        public Criteria andCarryingbagEqualTo(Byte value) {
            addCriterion("carryingbag =", value, "carryingbag");
            return (Criteria) this;
        }

        public Criteria andCarryingbagNotEqualTo(Byte value) {
            addCriterion("carryingbag <>", value, "carryingbag");
            return (Criteria) this;
        }

        public Criteria andCarryingbagGreaterThan(Byte value) {
            addCriterion("carryingbag >", value, "carryingbag");
            return (Criteria) this;
        }

        public Criteria andCarryingbagGreaterThanOrEqualTo(Byte value) {
            addCriterion("carryingbag >=", value, "carryingbag");
            return (Criteria) this;
        }

        public Criteria andCarryingbagLessThan(Byte value) {
            addCriterion("carryingbag <", value, "carryingbag");
            return (Criteria) this;
        }

        public Criteria andCarryingbagLessThanOrEqualTo(Byte value) {
            addCriterion("carryingbag <=", value, "carryingbag");
            return (Criteria) this;
        }

        public Criteria andCarryingbagIn(List<Byte> values) {
            addCriterion("carryingbag in", values, "carryingbag");
            return (Criteria) this;
        }

        public Criteria andCarryingbagNotIn(List<Byte> values) {
            addCriterion("carryingbag not in", values, "carryingbag");
            return (Criteria) this;
        }

        public Criteria andCarryingbagBetween(Byte value1, Byte value2) {
            addCriterion("carryingbag between", value1, value2, "carryingbag");
            return (Criteria) this;
        }

        public Criteria andCarryingbagNotBetween(Byte value1, Byte value2) {
            addCriterion("carryingbag not between", value1, value2, "carryingbag");
            return (Criteria) this;
        }

        public Criteria andDistanceIsNull() {
            addCriterion("distance is null");
            return (Criteria) this;
        }

        public Criteria andDistanceIsNotNull() {
            addCriterion("distance is not null");
            return (Criteria) this;
        }

        public Criteria andDistanceEqualTo(Float value) {
            addCriterion("distance =", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceNotEqualTo(Float value) {
            addCriterion("distance <>", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceGreaterThan(Float value) {
            addCriterion("distance >", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceGreaterThanOrEqualTo(Float value) {
            addCriterion("distance >=", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceLessThan(Float value) {
            addCriterion("distance <", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceLessThanOrEqualTo(Float value) {
            addCriterion("distance <=", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceIn(List<Float> values) {
            addCriterion("distance in", values, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceNotIn(List<Float> values) {
            addCriterion("distance not in", values, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceBetween(Float value1, Float value2) {
            addCriterion("distance between", value1, value2, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceNotBetween(Float value1, Float value2) {
            addCriterion("distance not between", value1, value2, "distance");
            return (Criteria) this;
        }

        public Criteria andLamShapeIsNull() {
            addCriterion("lam_shape is null");
            return (Criteria) this;
        }

        public Criteria andLamShapeIsNotNull() {
            addCriterion("lam_shape is not null");
            return (Criteria) this;
        }

        public Criteria andLamShapeEqualTo(Short value) {
            addCriterion("lam_shape =", value, "lamShape");
            return (Criteria) this;
        }

        public Criteria andLamShapeNotEqualTo(Short value) {
            addCriterion("lam_shape <>", value, "lamShape");
            return (Criteria) this;
        }

        public Criteria andLamShapeGreaterThan(Short value) {
            addCriterion("lam_shape >", value, "lamShape");
            return (Criteria) this;
        }

        public Criteria andLamShapeGreaterThanOrEqualTo(Short value) {
            addCriterion("lam_shape >=", value, "lamShape");
            return (Criteria) this;
        }

        public Criteria andLamShapeLessThan(Short value) {
            addCriterion("lam_shape <", value, "lamShape");
            return (Criteria) this;
        }

        public Criteria andLamShapeLessThanOrEqualTo(Short value) {
            addCriterion("lam_shape <=", value, "lamShape");
            return (Criteria) this;
        }

        public Criteria andLamShapeIn(List<Short> values) {
            addCriterion("lam_shape in", values, "lamShape");
            return (Criteria) this;
        }

        public Criteria andLamShapeNotIn(List<Short> values) {
            addCriterion("lam_shape not in", values, "lamShape");
            return (Criteria) this;
        }

        public Criteria andLamShapeBetween(Short value1, Short value2) {
            addCriterion("lam_shape between", value1, value2, "lamShape");
            return (Criteria) this;
        }

        public Criteria andLamShapeNotBetween(Short value1, Short value2) {
            addCriterion("lam_shape not between", value1, value2, "lamShape");
            return (Criteria) this;
        }

        public Criteria andBikeHasPlateIsNull() {
            addCriterion("bike_has_plate is null");
            return (Criteria) this;
        }

        public Criteria andBikeHasPlateIsNotNull() {
            addCriterion("bike_has_plate is not null");
            return (Criteria) this;
        }

        public Criteria andBikeHasPlateEqualTo(Byte value) {
            addCriterion("bike_has_plate =", value, "bikeHasPlate");
            return (Criteria) this;
        }

        public Criteria andBikeHasPlateNotEqualTo(Byte value) {
            addCriterion("bike_has_plate <>", value, "bikeHasPlate");
            return (Criteria) this;
        }

        public Criteria andBikeHasPlateGreaterThan(Byte value) {
            addCriterion("bike_has_plate >", value, "bikeHasPlate");
            return (Criteria) this;
        }

        public Criteria andBikeHasPlateGreaterThanOrEqualTo(Byte value) {
            addCriterion("bike_has_plate >=", value, "bikeHasPlate");
            return (Criteria) this;
        }

        public Criteria andBikeHasPlateLessThan(Byte value) {
            addCriterion("bike_has_plate <", value, "bikeHasPlate");
            return (Criteria) this;
        }

        public Criteria andBikeHasPlateLessThanOrEqualTo(Byte value) {
            addCriterion("bike_has_plate <=", value, "bikeHasPlate");
            return (Criteria) this;
        }

        public Criteria andBikeHasPlateIn(List<Byte> values) {
            addCriterion("bike_has_plate in", values, "bikeHasPlate");
            return (Criteria) this;
        }

        public Criteria andBikeHasPlateNotIn(List<Byte> values) {
            addCriterion("bike_has_plate not in", values, "bikeHasPlate");
            return (Criteria) this;
        }

        public Criteria andBikeHasPlateBetween(Byte value1, Byte value2) {
            addCriterion("bike_has_plate between", value1, value2, "bikeHasPlate");
            return (Criteria) this;
        }

        public Criteria andBikeHasPlateNotBetween(Byte value1, Byte value2) {
            addCriterion("bike_has_plate not between", value1, value2, "bikeHasPlate");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andInserttimeIsNull() {
            addCriterion("inserttime is null");
            return (Criteria) this;
        }

        public Criteria andInserttimeIsNotNull() {
            addCriterion("inserttime is not null");
            return (Criteria) this;
        }

        public Criteria andInserttimeEqualTo(Date value) {
            addCriterion("inserttime =", value, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeNotEqualTo(Date value) {
            addCriterion("inserttime <>", value, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeGreaterThan(Date value) {
            addCriterion("inserttime >", value, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeGreaterThanOrEqualTo(Date value) {
            addCriterion("inserttime >=", value, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeLessThan(Date value) {
            addCriterion("inserttime <", value, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeLessThanOrEqualTo(Date value) {
            addCriterion("inserttime <=", value, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeIn(List<Date> values) {
            addCriterion("inserttime in", values, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeNotIn(List<Date> values) {
            addCriterion("inserttime not in", values, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeBetween(Date value1, Date value2) {
            addCriterion("inserttime between", value1, value2, "inserttime");
            return (Criteria) this;
        }

        public Criteria andInserttimeNotBetween(Date value1, Date value2) {
            addCriterion("inserttime not between", value1, value2, "inserttime");
            return (Criteria) this;
        }

        public Criteria andUpperclothingIsNull() {
            addCriterion("upperclothing is null");
            return (Criteria) this;
        }

        public Criteria andUpperclothingIsNotNull() {
            addCriterion("upperclothing is not null");
            return (Criteria) this;
        }

        public Criteria andUpperclothingEqualTo(String value) {
            addCriterion("upperclothing =", value, "upperclothing");
            return (Criteria) this;
        }

        public Criteria andUpperclothingNotEqualTo(String value) {
            addCriterion("upperclothing <>", value, "upperclothing");
            return (Criteria) this;
        }

        public Criteria andUpperclothingGreaterThan(String value) {
            addCriterion("upperclothing >", value, "upperclothing");
            return (Criteria) this;
        }

        public Criteria andUpperclothingGreaterThanOrEqualTo(String value) {
            addCriterion("upperclothing >=", value, "upperclothing");
            return (Criteria) this;
        }

        public Criteria andUpperclothingLessThan(String value) {
            addCriterion("upperclothing <", value, "upperclothing");
            return (Criteria) this;
        }

        public Criteria andUpperclothingLessThanOrEqualTo(String value) {
            addCriterion("upperclothing <=", value, "upperclothing");
            return (Criteria) this;
        }

        public Criteria andUpperclothingLike(String value) {
            addCriterion("upperclothing like", value, "upperclothing");
            return (Criteria) this;
        }

        public Criteria andUpperclothingNotLike(String value) {
            addCriterion("upperclothing not like", value, "upperclothing");
            return (Criteria) this;
        }

        public Criteria andUpperclothingIn(List<String> values) {
            addCriterion("upperclothing in", values, "upperclothing");
            return (Criteria) this;
        }

        public Criteria andUpperclothingNotIn(List<String> values) {
            addCriterion("upperclothing not in", values, "upperclothing");
            return (Criteria) this;
        }

        public Criteria andUpperclothingBetween(String value1, String value2) {
            addCriterion("upperclothing between", value1, value2, "upperclothing");
            return (Criteria) this;
        }

        public Criteria andUpperclothingNotBetween(String value1, String value2) {
            addCriterion("upperclothing not between", value1, value2, "upperclothing");
            return (Criteria) this;
        }

        public Criteria andTrousersStyleIsNull() {
            addCriterion("trousers_style is null");
            return (Criteria) this;
        }

        public Criteria andTrousersStyleIsNotNull() {
            addCriterion("trousers_style is not null");
            return (Criteria) this;
        }

        public Criteria andTrousersStyleEqualTo(String value) {
            addCriterion("trousers_style =", value, "trousersStyle");
            return (Criteria) this;
        }

        public Criteria andTrousersStyleNotEqualTo(String value) {
            addCriterion("trousers_style <>", value, "trousersStyle");
            return (Criteria) this;
        }

        public Criteria andTrousersStyleGreaterThan(String value) {
            addCriterion("trousers_style >", value, "trousersStyle");
            return (Criteria) this;
        }

        public Criteria andTrousersStyleGreaterThanOrEqualTo(String value) {
            addCriterion("trousers_style >=", value, "trousersStyle");
            return (Criteria) this;
        }

        public Criteria andTrousersStyleLessThan(String value) {
            addCriterion("trousers_style <", value, "trousersStyle");
            return (Criteria) this;
        }

        public Criteria andTrousersStyleLessThanOrEqualTo(String value) {
            addCriterion("trousers_style <=", value, "trousersStyle");
            return (Criteria) this;
        }

        public Criteria andTrousersStyleLike(String value) {
            addCriterion("trousers_style like", value, "trousersStyle");
            return (Criteria) this;
        }

        public Criteria andTrousersStyleNotLike(String value) {
            addCriterion("trousers_style not like", value, "trousersStyle");
            return (Criteria) this;
        }

        public Criteria andTrousersStyleIn(List<String> values) {
            addCriterion("trousers_style in", values, "trousersStyle");
            return (Criteria) this;
        }

        public Criteria andTrousersStyleNotIn(List<String> values) {
            addCriterion("trousers_style not in", values, "trousersStyle");
            return (Criteria) this;
        }

        public Criteria andTrousersStyleBetween(String value1, String value2) {
            addCriterion("trousers_style between", value1, value2, "trousersStyle");
            return (Criteria) this;
        }

        public Criteria andTrousersStyleNotBetween(String value1, String value2) {
            addCriterion("trousers_style not between", value1, value2, "trousersStyle");
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