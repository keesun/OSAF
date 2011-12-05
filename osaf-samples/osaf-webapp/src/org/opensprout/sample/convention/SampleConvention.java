package org.opensprout.sample.convention;

import org.opensprout.osaf.convention.DefaultConvention;
import org.springframework.stereotype.Component;

@Component
public class SampleConvention extends DefaultConvention {

	public SampleConvention() {
		this.domainPackageName = "org.opensprout.sample.model";
	}
	
}
