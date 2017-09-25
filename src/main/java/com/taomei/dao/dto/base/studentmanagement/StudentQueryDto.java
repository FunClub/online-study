package com.taomei.dao.dto.base.studentmanagement;

import com.taomei.dao.dto.base.PageRequestDto;

public class StudentQueryDto extends PageRequestDto{
    private Boolean showUnAudit;
    private Boolean showPage;

    public Boolean getShowPage() {
        return showPage;
    }

    public void setShowPage(Boolean showPage) {
        this.showPage = showPage;
    }

    public Boolean getShowUnAudit() {
        return showUnAudit;
    }

    public void setShowUnAudit(Boolean showUnAudit) {
        this.showUnAudit = showUnAudit;
    }
}
