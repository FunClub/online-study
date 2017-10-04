package com.taomei.dao.dto.studentmanagement;

import com.taomei.dao.dto.base.PagedDataDto;

public class StudentsDto extends PagedDataDto{
    private Long unAuditCount;

    public Long getUnAuditCount() {
        return unAuditCount;
    }

    public void setUnAuditCount(Long unAuditCount) {
        this.unAuditCount = unAuditCount;
    }
}
