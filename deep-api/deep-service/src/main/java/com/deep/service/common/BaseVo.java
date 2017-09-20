package com.deep.service.common;

import com.google.common.collect.Maps;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * 基类vo
 *
 * @author fb
 * @version 2.0.1, 2016-05-13
 * @since 2.0.1
 */
public abstract class BaseVo<T> implements Serializable {

    protected transient Map<String, Object> beanToMapInstance;

    private transient BeanUtilsBean beanUtilsBean = new BeanUtilsBean(){
        @Override
        public void copyProperty(Object dest, String name, Object value)
                throws IllegalAccessException, InvocationTargetException {

            try {
                // 为空或是类型不匹配的属性都不作任务拷贝动作
                if(value == null || getPropertyUtils().getPropertyType(dest, name) != value.getClass()) {
                    return;
                }
            } catch (NoSuchMethodException e) {
                logger.error(e.getMessage());
            }

            super.copyProperty(dest, name, value);
        }
    };

    protected transient Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * java对象属性值拷贝，不对null进行处理
     *
     * @param dest
     * @param orig
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public void copyProperties(Object dest, Object orig) throws InvocationTargetException, IllegalAccessException {
        beanUtilsBean.copyProperties(dest, orig);
    }


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    /**
     * 当前bean转成对应的map
     */
    public Map<String, Object> toMap() {
        if (beanToMapInstance == null) {
            try {
                beanToMapInstance = Maps.newHashMap();
                // 这里不用BeanUtils.describe(this)，是因为转换成map的值只能是字符串
                Field[] fields =  this.getClass().getDeclaredFields();

                for (Field field : fields) {
                    if (field.getName().equals("serialVersionUID")
                            || field.getName().equals("logger")
                            || field.getName().equals("beanToMapInstance")) {
                        continue;
                    }

                    field.setAccessible(true);
                    beanToMapInstance.put(field.getName(), field.get(this));
                }

            } catch (Exception e) {
                logger.warn("bean转换成map异常：e", e);
            }
        }

        return beanToMapInstance;
    }
}
