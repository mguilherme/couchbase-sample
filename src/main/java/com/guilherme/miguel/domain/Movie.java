package com.guilherme.miguel.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.couchbase.core.mapping.Document;

import java.util.Date;

/**
 * @author Miguel Guilherme
 */
@RequiredArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Document
public class Movie {

    @Id
    @NonNull
    @Getter
    private String id;

    @Getter
    @Setter
    @NonNull
    private String title;

    @Getter
    @LastModifiedDate
    private Date lastModifiedDate;

    @Getter
    @CreatedDate
    private Date createdDate;
}
