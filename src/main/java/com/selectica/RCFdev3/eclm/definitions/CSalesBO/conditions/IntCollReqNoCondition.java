package com.selectica.RCFdev3.eclm.definitions.CSalesBO.conditions;

import com.selectica.RCFdev3.stubs.CSDetails;
import com.selectica.rcfscripts.AbstractBOReadScript;

/**
 * Created by vshilkin on 08/01/2015.
 */
public class IntCollReqNoCondition extends AbstractBOReadScript<Boolean> {
    /*
                <![CDATA[
					result  = thisBundle.getInfoValueObject("intCollReq") == 'no'
				]]>
     */
    @Override
    public Boolean process() throws Exception {
        CSDetails info = getHelper().getInfoComponentStub();
        return info.getIntCollReq() != null && info.getIntCollReq().equals("no");
    }
}

