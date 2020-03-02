package com.yinghao.domain;

import java.util.Date;
import javax.persistence.*;

@Table(name = "term")
public class Term {
    /**
     * 主键id自增
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 学期开始时间
     */
    @Column(name = "term_begin_time")
    private Date termBeginTime;

    /**
     * 学期结束时间
     */
    @Column(name = "term_end_time")
    private Date termEndTime;

    /**
     * 学校名称
     */
    @Column(name = "school_name")
    private String schoolName;

    /**
     * 获取主键id自增
     *
     * @return id - 主键id自增
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键id自增
     *
     * @param id 主键id自增
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取学期开始时间
     *
     * @return term_begin_time - 学期开始时间
     */
    public Date getTermBeginTime() {
        return termBeginTime;
    }

    /**
     * 设置学期开始时间
     *
     * @param termBeginTime 学期开始时间
     */
    public void setTermBeginTime(Date termBeginTime) {
        this.termBeginTime = termBeginTime;
    }

    /**
     * 获取学期结束时间
     *
     * @return term_end_time - 学期结束时间
     */
    public Date getTermEndTime() {
        return termEndTime;
    }

    /**
     * 设置学期结束时间
     *
     * @param termEndTime 学期结束时间
     */
    public void setTermEndTime(Date termEndTime) {
        this.termEndTime = termEndTime;
    }

    /**
     * 获取学校名称
     *
     * @return school_name - 学校名称
     */
    public String getSchoolName() {
        return schoolName;
    }

    /**
     * 设置学校名称
     *
     * @param schoolName 学校名称
     */
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName == null ? null : schoolName.trim();
    }
}