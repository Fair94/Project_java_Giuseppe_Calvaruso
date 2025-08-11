package giuseppecalvaruso.domain;
/**
 * This is the file for the Customer.
 * The customer has a name , has a surname and an id (in order to avoid customer with same name and surname)
 * The customer has a slot, that is the max number of book he/she can rents
 * @param name The name of the customer
 * @param surname The surname of the customer
 * @param slot The number of book he/she has rented
 * @param ID The identification number of the customer (We use Tax id or italian "codice fiscale" )
 */
public class Customer {
    
    private final String name;
    private final String surname;
    private  int slot ;
    private  String  ID;

        
        /**This is the constructor for our new customer 
         */
        public Customer(String name, String surname, int slot, String ID){
            this.name = name;
            this.surname = surname;
            this.slot = 0; /*When we create a customer , he/she has 0 slot occupied */
            this.ID = ID;
        }
        /**Setter and getter for our customer
         * Setter only for slot and for ID
          */
         public String getName() {
         return name;
         }
         public String getSurname() {
         return surname;
         }
         public int getSlot() {
         return slot;
         }
         public String getID() {
         return ID;
         }
         public void setID(String iD) {
         ID = iD;
         }
         public void setSlot(int slot) {
         this.slot = slot;
         }
}
