package com.jeremp.handsign.core;

import java.util.ArrayList;
import java.util.List;

/**
 * This abstract class define what is a hand game
 * To implement a handGame you have to override it. 
 * @author jpasseron
 */
public abstract class RuleEngine {

    /**
     * The list of sign that players are allowed to use
     */
    protected List<Sign> allowedSigns = new ArrayList<>();

    /**
     * A RuleEngine MUST say if a Sign is stronger than another
     * @param a the first sign to compare
     * @param b the second sign to compare
     * @return the sign who beats the other, null if none of them beats the other
     */
    public abstract Sign beats(Sign a, Sign b);

    
    /**
     * Check if the givens signs belong to the allowedSigns
     * @param signs 
     */
    public void checkSigns(Sign... signs){
        if(signs.length>0){
            for(Sign sign : signs){
                check(sign);
            }
        }
    }
    
    /**
     * Check if the given sign belongs to the allowedSigns
     * @param sign
     */
    public void check(Sign sign){
        if(allowedSigns.isEmpty()==false && !allowedSigns.contains(sign)){
            throw new IllegalArgumentException(sign+" is not allowed in "+this.getClass().getName());
        }
    }

    /**
     * Retrieve the allowed signs
     * @return a list conaining all the signs you can use to play 
     */
    public List<Sign> getAllowedSigns() {
        return allowedSigns;
    }
    
}
