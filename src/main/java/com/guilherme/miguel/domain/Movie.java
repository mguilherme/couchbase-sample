package com.guilherme.miguel.domain;

import lombok.*;
import org.springframework.data.annotation.*;
import org.springframework.data.couchbase.core.mapping.Document;

import java.time.LocalDateTime;

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
    @Setter
    @NonNull
    private String director;

    @Getter
    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    @Getter
    @CreatedDate
    private LocalDateTime createdDate;

    @Version
    private long version;
}
