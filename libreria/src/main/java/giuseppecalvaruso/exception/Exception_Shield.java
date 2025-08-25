package giuseppecalvaruso.exception;

import java.util.logging.Logger;

import java.util.logging.Level;
/**
 * Exception Shielding: replacing exception with safe message
 */
public final class Exception_Shield {
        private Exception_Shield(){}

        /**
         * 
         * @param action    the operation executed
         * @param log       logging
         * @param operation operation being executed
         * @return          returning null or safe message
         */
        public static String thePolice(Runnable action, Logger log, String operation){

            try{
                action.run();
                return null;
            } catch (InputError error ){
                log.log(Level.WARNING, operation + "Invalid Input"+ safe(error.getMessage()));
                return "Invalid choice, try again";
            } catch(Exception expt){
                log.log(Level.SEVERE,operation + "Error", expt);
                return "Alert, error, retry";
            }
        }
        /**
         * 
         * @param s string to check
         * @return empty if s is null
         */
       private static String safe(String s) { 
            return s == null ? "" : s; 
        }

        
    
}
