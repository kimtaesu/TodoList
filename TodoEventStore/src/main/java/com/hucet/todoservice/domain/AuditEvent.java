package com.hucet.todoservice.domain;

import lombok.Data;
import org.joda.time.DateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Data
public class AuditEvent {
    //    @CreatedDate
//    private DateTime createAt;
    @LastModifiedDate
    private DateTime lastModifiedAt;
}
