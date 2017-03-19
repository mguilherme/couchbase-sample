package com.guilherme.miguel.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Miguel Guilherme
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActorKey implements Serializable {

    private String key;

}
