package giuseppecalvaruso.strategy;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Annotation for sorting strategy
 */

 @Retention (RetentionPolicy.RUNTIME)
public @interface Strategy {
    String value();

}
