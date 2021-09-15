package com.mercadolibre.api.dtos;

import java.io.Serializable;

public class UserItemDTOCompositeKey  implements Serializable{
    
    private Long user;
    private String item;
    
    public Long getUser() {
        return user;
    }
    public String getItem() {
        return item;
    }
    public void setItem(String item) {
        this.item = item;
    }
    public void setUser(Long user) {
        this.user = user;
    }

    @Override
    public int hashCode(){
        return this.item.hashCode() * this.user.hashCode();
    }

    @Override
    public boolean equals(Object o) {
 
        // If the object is compared with itself then return true 
        if (o == this) {
            return true;
        }
 
        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof UserItemDTOCompositeKey)) {
            return false;
        }
         
        // typecast o to Complex so that we can compare data members
        UserItemDTOCompositeKey c = (UserItemDTOCompositeKey) o;
         
        // Compare the data members and return accordingly
        return this.item.compareToIgnoreCase(c.getItem()) == 0
                && Long.compare(this.user, c.getUser()) == 0;
    }
}
