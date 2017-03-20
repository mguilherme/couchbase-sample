package com.guilherme.miguel.conf;

import com.guilherme.miguel.conf.converter.DateConverters;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.core.convert.CustomConversions;

import java.util.Arrays;
import java.util.List;

/**
 * @author Miguel Guilherme
 */
@Configuration
public class CouchbaseConf extends AbstractCouchbaseConfiguration {

    @Value("${spring.couchbase.bootstrap-hosts}")
    private List<String> bootstrapHosts;

    @Value("${spring.couchbase.bucket.name}")
    private String bucketName;

    @Value("${spring.couchbase.bucket.password:}")
    private String bucketPassword;

    @Override
    protected List<String> getBootstrapHosts() {
        return bootstrapHosts;
    }

    @Override
    protected String getBucketName() {
        return bucketName;
    }

    @Override
    protected String getBucketPassword() {
        return bucketPassword;
    }

    @Override
    public CustomConversions customConversions() {
        return new CustomConversions(Arrays.asList(DateConverters.LocalDateTimeToLong.INSTANCE,
                DateConverters.NumberToLocalDateTime.INSTANCE));
    }
}
