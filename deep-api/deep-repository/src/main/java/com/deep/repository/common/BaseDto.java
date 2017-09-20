package com.deep.repository.common;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Objects;

/**
 * 基础dto，提供基本的方法操作如hash, toString compare等
 *
 * @author fb
 * @version 2.1.5, 2016-09-20
 * @since 2.1.8
 */
public class BaseDto implements Serializable{
//    protected static final String IMG_PREFIX = Environment.get(Environment.KEY_USER_AVATAR_DOMAIN);
//
//    protected static final String STATIC_PREFIX = Environment.get(Environment.KEY_SERVER_DOMAIN_STATIC);

    protected String getUrl(String prefix, String url) {
        if (Objects.nonNull(url) && !url.toLowerCase().startsWith("http")) {
            return prefix + url;
        }

        return url;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
