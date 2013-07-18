package org.penguin.motorindex.web;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Set;

import org.jboss.resteasy.annotations.StringParameterUnmarshallerBinder;
import org.jboss.resteasy.spi.StringParameterUnmarshaller;
import org.penguin.motorindex.web.EnumUnmarshaller.EnumSet;

import com.google.common.base.Strings;
import com.google.common.collect.Sets;

public class EnumUnmarshaller implements StringParameterUnmarshaller<EnumSet<Enum>> {
    
    @Retention(RetentionPolicy.RUNTIME)
    @StringParameterUnmarshallerBinder(EnumUnmarshaller.class)
    public @interface EnumParam {
        Class<?> value();
        
        boolean nullable() default false;
    }
    
    private EnumParam enumParam;
    
    @Override
    public void setAnnotations(Annotation[] annotations) {
        for (Annotation a : annotations) {
            if (a.annotationType() == EnumParam.class) {
                enumParam = (EnumParam) a;
            }
        }
    }
    
    @Override
    public EnumSet<Enum> fromString(String str) {
        String[] split = Strings.nullToEmpty(str).split(",");
        EnumSet<Enum> toReturn = new EnumSet<>();
        for (String s : split) {
            toReturn.add(enumValue(s));
        }
        return toReturn;
    }
    
    private Enum<?> enumValue(String str) {
        if (Enum.class.isAssignableFrom(enumParam.value())) {
            try {
                return Enum.valueOf((Class<Enum>) enumParam.value(), str);
            } catch (IllegalArgumentException e) {
                if (enumParam.nullable()) {
                    return null;
                } else {
                    throw e;
                }
            }
        } else {
            return null;
        }
    }
    
    public static class EnumSet<T> {
        private Set<T> internal = Sets.newHashSet();
        
        public void add(T e) {
            internal.add(e);
        }
        
        public Set<T> values() {
            return internal;
        }
    }
}