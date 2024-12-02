package com.mingi.selector;

import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import com.mingi.config.DeferredConfig;
import com.mingi.config.DelayedConfig;

public class MyDeferredImportSelector implements DeferredImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[] {
        	"com.mingi.config.DeferredConfig"
        };
    }
    
    @Override
    public Class<? extends Group> getImportGroup() {
        return MyDeferredImportGroup.class;
    }

    public static class MyDeferredImportGroup implements Group {
        @Override
        public void process(AnnotationMetadata metadata, DeferredImportSelector selector) {
            // 필요한 로직을 여기에 처리
        }

        @Override
        public Iterable<Entry> selectImports() {
            // 로드할 설정 클래스를 반환
//            return List.of(new Entry(AnnotationMetadata.introspect(DelayedConfig.class), "delayedService"));
        	return Collections.emptyList();
        }
    }
}