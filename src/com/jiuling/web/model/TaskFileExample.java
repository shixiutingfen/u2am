package com.jiuling.web.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskFileExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TaskFileExample() {
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

        public Criteria andTaskIdIsNull() {
            addCriterion("task_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNotNull() {
            addCriterion("task_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIdEqualTo(Long value) {
            addCriterion("task_id =", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotEqualTo(Long value) {
            addCriterion("task_id <>", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThan(Long value) {
            addCriterion("task_id >", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThanOrEqualTo(Long value) {
            addCriterion("task_id >=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThan(Long value) {
            addCriterion("task_id <", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThanOrEqualTo(Long value) {
            addCriterion("task_id <=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIn(List<Long> values) {
            addCriterion("task_id in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotIn(List<Long> values) {
            addCriterion("task_id not in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdBetween(Long value1, Long value2) {
            addCriterion("task_id between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotBetween(Long value1, Long value2) {
            addCriterion("task_id not between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andFileTypeIsNull() {
            addCriterion("file_type is null");
            return (Criteria) this;
        }

        public Criteria andFileTypeIsNotNull() {
            addCriterion("file_type is not null");
            return (Criteria) this;
        }

        public Criteria andFileTypeEqualTo(String value) {
            addCriterion("file_type =", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotEqualTo(String value) {
            addCriterion("file_type <>", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeGreaterThan(String value) {
            addCriterion("file_type >", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeGreaterThanOrEqualTo(String value) {
            addCriterion("file_type >=", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeLessThan(String value) {
            addCriterion("file_type <", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeLessThanOrEqualTo(String value) {
            addCriterion("file_type <=", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeLike(String value) {
            addCriterion("file_type like", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotLike(String value) {
            addCriterion("file_type not like", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeIn(List<String> values) {
            addCriterion("file_type in", values, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotIn(List<String> values) {
            addCriterion("file_type not in", values, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeBetween(String value1, String value2) {
            addCriterion("file_type between", value1, value2, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotBetween(String value1, String value2) {
            addCriterion("file_type not between", value1, value2, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileSuffixIsNull() {
            addCriterion("file_suffix is null");
            return (Criteria) this;
        }

        public Criteria andFileSuffixIsNotNull() {
            addCriterion("file_suffix is not null");
            return (Criteria) this;
        }

        public Criteria andFileSuffixEqualTo(String value) {
            addCriterion("file_suffix =", value, "fileSuffix");
            return (Criteria) this;
        }

        public Criteria andFileSuffixNotEqualTo(String value) {
            addCriterion("file_suffix <>", value, "fileSuffix");
            return (Criteria) this;
        }

        public Criteria andFileSuffixGreaterThan(String value) {
            addCriterion("file_suffix >", value, "fileSuffix");
            return (Criteria) this;
        }

        public Criteria andFileSuffixGreaterThanOrEqualTo(String value) {
            addCriterion("file_suffix >=", value, "fileSuffix");
            return (Criteria) this;
        }

        public Criteria andFileSuffixLessThan(String value) {
            addCriterion("file_suffix <", value, "fileSuffix");
            return (Criteria) this;
        }

        public Criteria andFileSuffixLessThanOrEqualTo(String value) {
            addCriterion("file_suffix <=", value, "fileSuffix");
            return (Criteria) this;
        }

        public Criteria andFileSuffixLike(String value) {
            addCriterion("file_suffix like", value, "fileSuffix");
            return (Criteria) this;
        }

        public Criteria andFileSuffixNotLike(String value) {
            addCriterion("file_suffix not like", value, "fileSuffix");
            return (Criteria) this;
        }

        public Criteria andFileSuffixIn(List<String> values) {
            addCriterion("file_suffix in", values, "fileSuffix");
            return (Criteria) this;
        }

        public Criteria andFileSuffixNotIn(List<String> values) {
            addCriterion("file_suffix not in", values, "fileSuffix");
            return (Criteria) this;
        }

        public Criteria andFileSuffixBetween(String value1, String value2) {
            addCriterion("file_suffix between", value1, value2, "fileSuffix");
            return (Criteria) this;
        }

        public Criteria andFileSuffixNotBetween(String value1, String value2) {
            addCriterion("file_suffix not between", value1, value2, "fileSuffix");
            return (Criteria) this;
        }

        public Criteria andFileNameIsNull() {
            addCriterion("file_name is null");
            return (Criteria) this;
        }

        public Criteria andFileNameIsNotNull() {
            addCriterion("file_name is not null");
            return (Criteria) this;
        }

        public Criteria andFileNameEqualTo(String value) {
            addCriterion("file_name =", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotEqualTo(String value) {
            addCriterion("file_name <>", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThan(String value) {
            addCriterion("file_name >", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("file_name >=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThan(String value) {
            addCriterion("file_name <", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThanOrEqualTo(String value) {
            addCriterion("file_name <=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLike(String value) {
            addCriterion("file_name like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotLike(String value) {
            addCriterion("file_name not like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameIn(List<String> values) {
            addCriterion("file_name in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotIn(List<String> values) {
            addCriterion("file_name not in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameBetween(String value1, String value2) {
            addCriterion("file_name between", value1, value2, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotBetween(String value1, String value2) {
            addCriterion("file_name not between", value1, value2, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameafteruploadIsNull() {
            addCriterion("file_nameafterupload is null");
            return (Criteria) this;
        }

        public Criteria andFileNameafteruploadIsNotNull() {
            addCriterion("file_nameafterupload is not null");
            return (Criteria) this;
        }

        public Criteria andFileNameafteruploadEqualTo(String value) {
            addCriterion("file_nameafterupload =", value, "fileNameafterupload");
            return (Criteria) this;
        }

        public Criteria andFileNameafteruploadNotEqualTo(String value) {
            addCriterion("file_nameafterupload <>", value, "fileNameafterupload");
            return (Criteria) this;
        }

        public Criteria andFileNameafteruploadGreaterThan(String value) {
            addCriterion("file_nameafterupload >", value, "fileNameafterupload");
            return (Criteria) this;
        }

        public Criteria andFileNameafteruploadGreaterThanOrEqualTo(String value) {
            addCriterion("file_nameafterupload >=", value, "fileNameafterupload");
            return (Criteria) this;
        }

        public Criteria andFileNameafteruploadLessThan(String value) {
            addCriterion("file_nameafterupload <", value, "fileNameafterupload");
            return (Criteria) this;
        }

        public Criteria andFileNameafteruploadLessThanOrEqualTo(String value) {
            addCriterion("file_nameafterupload <=", value, "fileNameafterupload");
            return (Criteria) this;
        }

        public Criteria andFileNameafteruploadLike(String value) {
            addCriterion("file_nameafterupload like", value, "fileNameafterupload");
            return (Criteria) this;
        }

        public Criteria andFileNameafteruploadNotLike(String value) {
            addCriterion("file_nameafterupload not like", value, "fileNameafterupload");
            return (Criteria) this;
        }

        public Criteria andFileNameafteruploadIn(List<String> values) {
            addCriterion("file_nameafterupload in", values, "fileNameafterupload");
            return (Criteria) this;
        }

        public Criteria andFileNameafteruploadNotIn(List<String> values) {
            addCriterion("file_nameafterupload not in", values, "fileNameafterupload");
            return (Criteria) this;
        }

        public Criteria andFileNameafteruploadBetween(String value1, String value2) {
            addCriterion("file_nameafterupload between", value1, value2, "fileNameafterupload");
            return (Criteria) this;
        }

        public Criteria andFileNameafteruploadNotBetween(String value1, String value2) {
            addCriterion("file_nameafterupload not between", value1, value2, "fileNameafterupload");
            return (Criteria) this;
        }

        public Criteria andFilePathafteruploadIsNull() {
            addCriterion("file_pathafterupload is null");
            return (Criteria) this;
        }

        public Criteria andFilePathafteruploadIsNotNull() {
            addCriterion("file_pathafterupload is not null");
            return (Criteria) this;
        }

        public Criteria andFilePathafteruploadEqualTo(String value) {
            addCriterion("file_pathafterupload =", value, "filePathafterupload");
            return (Criteria) this;
        }

        public Criteria andFilePathafteruploadNotEqualTo(String value) {
            addCriterion("file_pathafterupload <>", value, "filePathafterupload");
            return (Criteria) this;
        }

        public Criteria andFilePathafteruploadGreaterThan(String value) {
            addCriterion("file_pathafterupload >", value, "filePathafterupload");
            return (Criteria) this;
        }

        public Criteria andFilePathafteruploadGreaterThanOrEqualTo(String value) {
            addCriterion("file_pathafterupload >=", value, "filePathafterupload");
            return (Criteria) this;
        }

        public Criteria andFilePathafteruploadLessThan(String value) {
            addCriterion("file_pathafterupload <", value, "filePathafterupload");
            return (Criteria) this;
        }

        public Criteria andFilePathafteruploadLessThanOrEqualTo(String value) {
            addCriterion("file_pathafterupload <=", value, "filePathafterupload");
            return (Criteria) this;
        }

        public Criteria andFilePathafteruploadLike(String value) {
            addCriterion("file_pathafterupload like", value, "filePathafterupload");
            return (Criteria) this;
        }

        public Criteria andFilePathafteruploadNotLike(String value) {
            addCriterion("file_pathafterupload not like", value, "filePathafterupload");
            return (Criteria) this;
        }

        public Criteria andFilePathafteruploadIn(List<String> values) {
            addCriterion("file_pathafterupload in", values, "filePathafterupload");
            return (Criteria) this;
        }

        public Criteria andFilePathafteruploadNotIn(List<String> values) {
            addCriterion("file_pathafterupload not in", values, "filePathafterupload");
            return (Criteria) this;
        }

        public Criteria andFilePathafteruploadBetween(String value1, String value2) {
            addCriterion("file_pathafterupload between", value1, value2, "filePathafterupload");
            return (Criteria) this;
        }

        public Criteria andFilePathafteruploadNotBetween(String value1, String value2) {
            addCriterion("file_pathafterupload not between", value1, value2, "filePathafterupload");
            return (Criteria) this;
        }

        public Criteria andFileLocalPathIsNull() {
            addCriterion("file_local_path is null");
            return (Criteria) this;
        }

        public Criteria andFileLocalPathIsNotNull() {
            addCriterion("file_local_path is not null");
            return (Criteria) this;
        }

        public Criteria andFileLocalPathEqualTo(String value) {
            addCriterion("file_local_path =", value, "fileLocalPath");
            return (Criteria) this;
        }

        public Criteria andFileLocalPathNotEqualTo(String value) {
            addCriterion("file_local_path <>", value, "fileLocalPath");
            return (Criteria) this;
        }

        public Criteria andFileLocalPathGreaterThan(String value) {
            addCriterion("file_local_path >", value, "fileLocalPath");
            return (Criteria) this;
        }

        public Criteria andFileLocalPathGreaterThanOrEqualTo(String value) {
            addCriterion("file_local_path >=", value, "fileLocalPath");
            return (Criteria) this;
        }

        public Criteria andFileLocalPathLessThan(String value) {
            addCriterion("file_local_path <", value, "fileLocalPath");
            return (Criteria) this;
        }

        public Criteria andFileLocalPathLessThanOrEqualTo(String value) {
            addCriterion("file_local_path <=", value, "fileLocalPath");
            return (Criteria) this;
        }

        public Criteria andFileLocalPathLike(String value) {
            addCriterion("file_local_path like", value, "fileLocalPath");
            return (Criteria) this;
        }

        public Criteria andFileLocalPathNotLike(String value) {
            addCriterion("file_local_path not like", value, "fileLocalPath");
            return (Criteria) this;
        }

        public Criteria andFileLocalPathIn(List<String> values) {
            addCriterion("file_local_path in", values, "fileLocalPath");
            return (Criteria) this;
        }

        public Criteria andFileLocalPathNotIn(List<String> values) {
            addCriterion("file_local_path not in", values, "fileLocalPath");
            return (Criteria) this;
        }

        public Criteria andFileLocalPathBetween(String value1, String value2) {
            addCriterion("file_local_path between", value1, value2, "fileLocalPath");
            return (Criteria) this;
        }

        public Criteria andFileLocalPathNotBetween(String value1, String value2) {
            addCriterion("file_local_path not between", value1, value2, "fileLocalPath");
            return (Criteria) this;
        }

        public Criteria andFileDescriptionIsNull() {
            addCriterion("file_description is null");
            return (Criteria) this;
        }

        public Criteria andFileDescriptionIsNotNull() {
            addCriterion("file_description is not null");
            return (Criteria) this;
        }

        public Criteria andFileDescriptionEqualTo(String value) {
            addCriterion("file_description =", value, "fileDescription");
            return (Criteria) this;
        }

        public Criteria andFileDescriptionNotEqualTo(String value) {
            addCriterion("file_description <>", value, "fileDescription");
            return (Criteria) this;
        }

        public Criteria andFileDescriptionGreaterThan(String value) {
            addCriterion("file_description >", value, "fileDescription");
            return (Criteria) this;
        }

        public Criteria andFileDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("file_description >=", value, "fileDescription");
            return (Criteria) this;
        }

        public Criteria andFileDescriptionLessThan(String value) {
            addCriterion("file_description <", value, "fileDescription");
            return (Criteria) this;
        }

        public Criteria andFileDescriptionLessThanOrEqualTo(String value) {
            addCriterion("file_description <=", value, "fileDescription");
            return (Criteria) this;
        }

        public Criteria andFileDescriptionLike(String value) {
            addCriterion("file_description like", value, "fileDescription");
            return (Criteria) this;
        }

        public Criteria andFileDescriptionNotLike(String value) {
            addCriterion("file_description not like", value, "fileDescription");
            return (Criteria) this;
        }

        public Criteria andFileDescriptionIn(List<String> values) {
            addCriterion("file_description in", values, "fileDescription");
            return (Criteria) this;
        }

        public Criteria andFileDescriptionNotIn(List<String> values) {
            addCriterion("file_description not in", values, "fileDescription");
            return (Criteria) this;
        }

        public Criteria andFileDescriptionBetween(String value1, String value2) {
            addCriterion("file_description between", value1, value2, "fileDescription");
            return (Criteria) this;
        }

        public Criteria andFileDescriptionNotBetween(String value1, String value2) {
            addCriterion("file_description not between", value1, value2, "fileDescription");
            return (Criteria) this;
        }

        public Criteria andThumbNailIsNull() {
            addCriterion("thumb_nail is null");
            return (Criteria) this;
        }

        public Criteria andThumbNailIsNotNull() {
            addCriterion("thumb_nail is not null");
            return (Criteria) this;
        }

        public Criteria andThumbNailEqualTo(String value) {
            addCriterion("thumb_nail =", value, "thumbNail");
            return (Criteria) this;
        }

        public Criteria andThumbNailNotEqualTo(String value) {
            addCriterion("thumb_nail <>", value, "thumbNail");
            return (Criteria) this;
        }

        public Criteria andThumbNailGreaterThan(String value) {
            addCriterion("thumb_nail >", value, "thumbNail");
            return (Criteria) this;
        }

        public Criteria andThumbNailGreaterThanOrEqualTo(String value) {
            addCriterion("thumb_nail >=", value, "thumbNail");
            return (Criteria) this;
        }

        public Criteria andThumbNailLessThan(String value) {
            addCriterion("thumb_nail <", value, "thumbNail");
            return (Criteria) this;
        }

        public Criteria andThumbNailLessThanOrEqualTo(String value) {
            addCriterion("thumb_nail <=", value, "thumbNail");
            return (Criteria) this;
        }

        public Criteria andThumbNailLike(String value) {
            addCriterion("thumb_nail like", value, "thumbNail");
            return (Criteria) this;
        }

        public Criteria andThumbNailNotLike(String value) {
            addCriterion("thumb_nail not like", value, "thumbNail");
            return (Criteria) this;
        }

        public Criteria andThumbNailIn(List<String> values) {
            addCriterion("thumb_nail in", values, "thumbNail");
            return (Criteria) this;
        }

        public Criteria andThumbNailNotIn(List<String> values) {
            addCriterion("thumb_nail not in", values, "thumbNail");
            return (Criteria) this;
        }

        public Criteria andThumbNailBetween(String value1, String value2) {
            addCriterion("thumb_nail between", value1, value2, "thumbNail");
            return (Criteria) this;
        }

        public Criteria andThumbNailNotBetween(String value1, String value2) {
            addCriterion("thumb_nail not between", value1, value2, "thumbNail");
            return (Criteria) this;
        }

        public Criteria andFileSizeIsNull() {
            addCriterion("file_size is null");
            return (Criteria) this;
        }

        public Criteria andFileSizeIsNotNull() {
            addCriterion("file_size is not null");
            return (Criteria) this;
        }

        public Criteria andFileSizeEqualTo(String value) {
            addCriterion("file_size =", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeNotEqualTo(String value) {
            addCriterion("file_size <>", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeGreaterThan(String value) {
            addCriterion("file_size >", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeGreaterThanOrEqualTo(String value) {
            addCriterion("file_size >=", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeLessThan(String value) {
            addCriterion("file_size <", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeLessThanOrEqualTo(String value) {
            addCriterion("file_size <=", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeLike(String value) {
            addCriterion("file_size like", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeNotLike(String value) {
            addCriterion("file_size not like", value, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeIn(List<String> values) {
            addCriterion("file_size in", values, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeNotIn(List<String> values) {
            addCriterion("file_size not in", values, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeBetween(String value1, String value2) {
            addCriterion("file_size between", value1, value2, "fileSize");
            return (Criteria) this;
        }

        public Criteria andFileSizeNotBetween(String value1, String value2) {
            addCriterion("file_size not between", value1, value2, "fileSize");
            return (Criteria) this;
        }

        public Criteria andCreateUeridIsNull() {
            addCriterion("create_uerid is null");
            return (Criteria) this;
        }

        public Criteria andCreateUeridIsNotNull() {
            addCriterion("create_uerid is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUeridEqualTo(Long value) {
            addCriterion("create_uerid =", value, "createUerid");
            return (Criteria) this;
        }

        public Criteria andCreateUeridNotEqualTo(Long value) {
            addCriterion("create_uerid <>", value, "createUerid");
            return (Criteria) this;
        }

        public Criteria andCreateUeridGreaterThan(Long value) {
            addCriterion("create_uerid >", value, "createUerid");
            return (Criteria) this;
        }

        public Criteria andCreateUeridGreaterThanOrEqualTo(Long value) {
            addCriterion("create_uerid >=", value, "createUerid");
            return (Criteria) this;
        }

        public Criteria andCreateUeridLessThan(Long value) {
            addCriterion("create_uerid <", value, "createUerid");
            return (Criteria) this;
        }

        public Criteria andCreateUeridLessThanOrEqualTo(Long value) {
            addCriterion("create_uerid <=", value, "createUerid");
            return (Criteria) this;
        }

        public Criteria andCreateUeridIn(List<Long> values) {
            addCriterion("create_uerid in", values, "createUerid");
            return (Criteria) this;
        }

        public Criteria andCreateUeridNotIn(List<Long> values) {
            addCriterion("create_uerid not in", values, "createUerid");
            return (Criteria) this;
        }

        public Criteria andCreateUeridBetween(Long value1, Long value2) {
            addCriterion("create_uerid between", value1, value2, "createUerid");
            return (Criteria) this;
        }

        public Criteria andCreateUeridNotBetween(Long value1, Long value2) {
            addCriterion("create_uerid not between", value1, value2, "createUerid");
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

        public Criteria andSlaveIpIsNull() {
            addCriterion("slave_ip is null");
            return (Criteria) this;
        }

        public Criteria andSlaveIpIsNotNull() {
            addCriterion("slave_ip is not null");
            return (Criteria) this;
        }

        public Criteria andSlaveIpEqualTo(String value) {
            addCriterion("slave_ip =", value, "slaveIp");
            return (Criteria) this;
        }

        public Criteria andSlaveIpNotEqualTo(String value) {
            addCriterion("slave_ip <>", value, "slaveIp");
            return (Criteria) this;
        }

        public Criteria andSlaveIpGreaterThan(String value) {
            addCriterion("slave_ip >", value, "slaveIp");
            return (Criteria) this;
        }

        public Criteria andSlaveIpGreaterThanOrEqualTo(String value) {
            addCriterion("slave_ip >=", value, "slaveIp");
            return (Criteria) this;
        }

        public Criteria andSlaveIpLessThan(String value) {
            addCriterion("slave_ip <", value, "slaveIp");
            return (Criteria) this;
        }

        public Criteria andSlaveIpLessThanOrEqualTo(String value) {
            addCriterion("slave_ip <=", value, "slaveIp");
            return (Criteria) this;
        }

        public Criteria andSlaveIpLike(String value) {
            addCriterion("slave_ip like", value, "slaveIp");
            return (Criteria) this;
        }

        public Criteria andSlaveIpNotLike(String value) {
            addCriterion("slave_ip not like", value, "slaveIp");
            return (Criteria) this;
        }

        public Criteria andSlaveIpIn(List<String> values) {
            addCriterion("slave_ip in", values, "slaveIp");
            return (Criteria) this;
        }

        public Criteria andSlaveIpNotIn(List<String> values) {
            addCriterion("slave_ip not in", values, "slaveIp");
            return (Criteria) this;
        }

        public Criteria andSlaveIpBetween(String value1, String value2) {
            addCriterion("slave_ip between", value1, value2, "slaveIp");
            return (Criteria) this;
        }

        public Criteria andSlaveIpNotBetween(String value1, String value2) {
            addCriterion("slave_ip not between", value1, value2, "slaveIp");
            return (Criteria) this;
        }

        public Criteria andC1IsNull() {
            addCriterion("c1 is null");
            return (Criteria) this;
        }

        public Criteria andC1IsNotNull() {
            addCriterion("c1 is not null");
            return (Criteria) this;
        }

        public Criteria andC1EqualTo(Long value) {
            addCriterion("c1 =", value, "c1");
            return (Criteria) this;
        }

        public Criteria andC1NotEqualTo(Long value) {
            addCriterion("c1 <>", value, "c1");
            return (Criteria) this;
        }

        public Criteria andC1GreaterThan(Long value) {
            addCriterion("c1 >", value, "c1");
            return (Criteria) this;
        }

        public Criteria andC1GreaterThanOrEqualTo(Long value) {
            addCriterion("c1 >=", value, "c1");
            return (Criteria) this;
        }

        public Criteria andC1LessThan(Long value) {
            addCriterion("c1 <", value, "c1");
            return (Criteria) this;
        }

        public Criteria andC1LessThanOrEqualTo(Long value) {
            addCriterion("c1 <=", value, "c1");
            return (Criteria) this;
        }

        public Criteria andC1In(List<Long> values) {
            addCriterion("c1 in", values, "c1");
            return (Criteria) this;
        }

        public Criteria andC1NotIn(List<Long> values) {
            addCriterion("c1 not in", values, "c1");
            return (Criteria) this;
        }

        public Criteria andC1Between(Long value1, Long value2) {
            addCriterion("c1 between", value1, value2, "c1");
            return (Criteria) this;
        }

        public Criteria andC1NotBetween(Long value1, Long value2) {
            addCriterion("c1 not between", value1, value2, "c1");
            return (Criteria) this;
        }

        public Criteria andC2IsNull() {
            addCriterion("c2 is null");
            return (Criteria) this;
        }

        public Criteria andC2IsNotNull() {
            addCriterion("c2 is not null");
            return (Criteria) this;
        }

        public Criteria andC2EqualTo(Long value) {
            addCriterion("c2 =", value, "c2");
            return (Criteria) this;
        }

        public Criteria andC2NotEqualTo(Long value) {
            addCriterion("c2 <>", value, "c2");
            return (Criteria) this;
        }

        public Criteria andC2GreaterThan(Long value) {
            addCriterion("c2 >", value, "c2");
            return (Criteria) this;
        }

        public Criteria andC2GreaterThanOrEqualTo(Long value) {
            addCriterion("c2 >=", value, "c2");
            return (Criteria) this;
        }

        public Criteria andC2LessThan(Long value) {
            addCriterion("c2 <", value, "c2");
            return (Criteria) this;
        }

        public Criteria andC2LessThanOrEqualTo(Long value) {
            addCriterion("c2 <=", value, "c2");
            return (Criteria) this;
        }

        public Criteria andC2In(List<Long> values) {
            addCriterion("c2 in", values, "c2");
            return (Criteria) this;
        }

        public Criteria andC2NotIn(List<Long> values) {
            addCriterion("c2 not in", values, "c2");
            return (Criteria) this;
        }

        public Criteria andC2Between(Long value1, Long value2) {
            addCriterion("c2 between", value1, value2, "c2");
            return (Criteria) this;
        }

        public Criteria andC2NotBetween(Long value1, Long value2) {
            addCriterion("c2 not between", value1, value2, "c2");
            return (Criteria) this;
        }

        public Criteria andC3IsNull() {
            addCriterion("c3 is null");
            return (Criteria) this;
        }

        public Criteria andC3IsNotNull() {
            addCriterion("c3 is not null");
            return (Criteria) this;
        }

        public Criteria andC3EqualTo(Long value) {
            addCriterion("c3 =", value, "c3");
            return (Criteria) this;
        }

        public Criteria andC3NotEqualTo(Long value) {
            addCriterion("c3 <>", value, "c3");
            return (Criteria) this;
        }

        public Criteria andC3GreaterThan(Long value) {
            addCriterion("c3 >", value, "c3");
            return (Criteria) this;
        }

        public Criteria andC3GreaterThanOrEqualTo(Long value) {
            addCriterion("c3 >=", value, "c3");
            return (Criteria) this;
        }

        public Criteria andC3LessThan(Long value) {
            addCriterion("c3 <", value, "c3");
            return (Criteria) this;
        }

        public Criteria andC3LessThanOrEqualTo(Long value) {
            addCriterion("c3 <=", value, "c3");
            return (Criteria) this;
        }

        public Criteria andC3In(List<Long> values) {
            addCriterion("c3 in", values, "c3");
            return (Criteria) this;
        }

        public Criteria andC3NotIn(List<Long> values) {
            addCriterion("c3 not in", values, "c3");
            return (Criteria) this;
        }

        public Criteria andC3Between(Long value1, Long value2) {
            addCriterion("c3 between", value1, value2, "c3");
            return (Criteria) this;
        }

        public Criteria andC3NotBetween(Long value1, Long value2) {
            addCriterion("c3 not between", value1, value2, "c3");
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