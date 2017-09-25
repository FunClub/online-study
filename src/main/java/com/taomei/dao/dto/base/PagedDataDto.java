package com.taomei.dao.dto.base;

import java.util.List;

public class PagedDataDto<T> {
    private Long totalElements;
    private List<T> content;

    public Long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }
}
