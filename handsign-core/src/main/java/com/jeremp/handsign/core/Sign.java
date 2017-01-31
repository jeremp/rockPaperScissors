
package com.jeremp.handsign.core;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jpasseron
 */
public class Sign {

	private String name ;
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

	public List<Sign> getBeats() {
		return beats;
	}

	public void setBeats(List<Sign> beats) {
		this.beats = beats;
	}

	
}
