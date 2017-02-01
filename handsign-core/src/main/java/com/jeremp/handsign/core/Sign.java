package com.jeremp.handsign.core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.List;

/**
 * HandSign
 * @author jpasseron
 */
public class Sign {

    /**
     * A Sign a the name of a real-world Object or Animal
     */
    private String name;
    
    /**
     * A Sign should beats some other signs
     */
    private List<Sign> beats = new ArrayList<>();

    public Sign(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	@JsonIgnore
    public List<Sign> getBeats() {
        return beats;
    }

    public void setBeats(List<Sign> beats) {
        this.beats = beats;
    }

    @Override
    public String toString() {
        return "Sign{" + "name=" + name + "}'";
    }
    
}
