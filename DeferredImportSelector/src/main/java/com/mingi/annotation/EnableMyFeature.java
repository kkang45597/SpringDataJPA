package com.mingi.annotation;

import org.springframework.context.annotation.Import;
import com.mingi.selector.MyDeferredImportSelector;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(MyDeferredImportSelector.class)
public @interface EnableMyFeature {
}