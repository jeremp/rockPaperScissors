
package com.jeremp.handsign.core;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jpasseron
 */
public abstract class RuleEngine {
	
	protected List<Sign> allowedSigns = new ArrayList<>();
	
	public abstract Sign beats(Sign a, Sign b);

	public List<Sign> getAllowedSigns() {
		return allowedSigns;
	}

	public void setAllowedSigns(List<Sign> allowedSigns) {
		this.allowedSigns = allowedSigns;
	}
	
	
	
}
