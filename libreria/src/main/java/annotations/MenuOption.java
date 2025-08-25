package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/**Annotations for Facade Menu */
public @interface MenuOption {

    /**
     * Label for menu choice
     */

     String label() ;

     /**
      * Index for the choice
      */

      int index();

      boolean enabled() default true;

}
