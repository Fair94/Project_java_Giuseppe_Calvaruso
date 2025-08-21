package giuseppecalvaruso.exception;

import java.util.logging.Logger;

import java.util.logging.Level;

public final class Exception_Shield {
        private Exception_Shield(){}
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
       private static String safe(String s) { 
            return s == null ? "" : s; 
        }

        
    
}
