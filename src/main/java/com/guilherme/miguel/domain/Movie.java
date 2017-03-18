package com.guilherme.miguel.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

/**
 * @author Miguel Guilherme
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Movie {

    @Id
    private String id;
    private String title;
}
