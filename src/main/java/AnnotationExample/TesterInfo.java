package AnnotationExample;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * User: maksmac
 */
@Retention(value = RetentionPolicy.RUNTIME)
@Target(value = ElementType.TYPE)
public @interface TesterInfo {

    public enum Priority {
        LOW, MEDIUM, HIGH
    }
    Priority priority() default Priority.MEDIUM;
    String[] tags() default "";
    String createdBy() default "The Great Mak";
    String lastModified() default "03/01/2014";
}
