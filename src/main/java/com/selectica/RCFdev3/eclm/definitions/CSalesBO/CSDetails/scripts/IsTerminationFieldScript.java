package com.selectica.RCFdev3.eclm.definitions.CSalesBO.CSDetails.scripts;

import com.selectica.RCFdev3.stubs.CSDetails;
import com.selectica.rcfscripts.AbstractDataReadScript;

/**
 * Created by vshilkin on 08/01/2015.
 */
public class IsTerminationFieldScript extends AbstractDataReadScript<Boolean> {
    /*
            result = thisComponent.getParameterValueObject("termwoCause") == 'yes';
     */
    @Override
    public Boolean process() throws Exception {
        CSDetails details = getHelper().getCurrentComponentStub();
        return details.getTermwoCause().equals("yes");
    }
}

