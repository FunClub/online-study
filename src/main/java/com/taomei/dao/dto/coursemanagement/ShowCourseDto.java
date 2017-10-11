package com.taomei.dao.dto.coursemanagement;

import com.taomei.dao.docment.Course;

public class ShowCourseDto extends Course{
    private String batch;

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }
}
