package com.guilherme.miguel.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.repository.auditing.EnableCouchbaseAuditing;

/**
 * @author Miguel Guilherme
 */
@Configuration
@EnableCouchbaseAuditing
public class AuditConfiguration {


}
