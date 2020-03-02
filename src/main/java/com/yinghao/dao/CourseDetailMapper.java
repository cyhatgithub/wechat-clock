package com.yinghao.dao;

import com.yinghao.domain.CourseDetail;
import com.yinghao.util.MyMapper;

import java.util.List;

public interface CourseDetailMapper extends MyMapper<CourseDetail> {
    void updateUserIdByTermId(String userId, Integer termId);

    List<CourseDetail> selectAllWithTerm();
}