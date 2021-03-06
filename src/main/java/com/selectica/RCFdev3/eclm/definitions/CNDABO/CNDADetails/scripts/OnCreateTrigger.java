package com.selectica.RCFdev3.eclm.definitions.CNDABO.CNDADetails.scripts;

import com.selectica.RCFdev3.eclm.definitions.ContractStatus;
import com.selectica.RCFdev3.eclm.definitions.DirectoryStatus;
import com.selectica.RCFdev3.stubs.CNDADetails;
import com.selectica.RCFdev3.stubs.DirectoryInfoComponent;
import com.selectica.rcfscripts.AbstractDataWriteScript;

/**
 * Created by vshilkin on 26/12/2014.
 */
public class OnCreateTrigger extends AbstractDataWriteScript<Boolean> {
    /*
            <![CDATA[
            if (typeof relatedBundle != 'undefined') {
                var dirStatus = relatedBundle.getInfoValueObject("dirStatus").toString();
                if (dirStatus.equals("Active")) {
                    var a1 = relatedBundle.getInfoValueObject("dirAdr1");
                    var a2 = relatedBundle.getInfoValueObject("dirAdr2");
                    var c = relatedBundle.getInfoValueObject("dirCity");
                    var s = relatedBundle.getValueFromInfo("dirState").getDisplayValue();
                    var z = relatedBundle.getInfoValueObject("dirZip");
                    var ct = relatedBundle.getValueFromInfo("dirCountry").getDisplayValue();
                    thisComponent.setValue("/cpAdr1", a1, false);
                    thisComponent.setValue("/cpAdr2", a2, false);
                    thisComponent.setValue("/cpCity", c, false);
                    thisComponent.setValue("/cpState", s, false);
                    thisComponent.setValue("/cpCtry", ct, false);
                    thisComponent.setValue("/cpZip", z, false);
                    thisComponent.setValue("/cpName", relatedBundle.getValue("trackingNumber"), false);
                }
            }
            thisComponent.setValue("/contractStatus", "Draft", false);
            ]]>
     */
    @Override
    public Boolean process() throws Exception {
        CNDADetails details = getHelper().getCurrentComponentStub();
        DirectoryInfoComponent directoryInfo = getHelper().getInfoComponentStubForRelatedDirectoryBundle();
        if (directoryInfo != null) {
            String status = directoryInfo.getDirStatus();
            if (DirectoryStatus.ACTIVE.getStatus().equals(status)) {
                details.setCpAdr1(directoryInfo.getDirAdr1());
                details.setCpAdr2(directoryInfo.getDirAdr2());
                details.setCpCity(directoryInfo.getDirCity());
                details.setCpState(directoryInfo.getDirState());
                details.setCpZip(directoryInfo.getDirZip());
                details.setCpCtry(directoryInfo.getDirCountry());
                details.setCpName(String.valueOf(directoryInfo.getTrackingNumber()));
            }
        }
        details.setContractStatus(ContractStatus.DRAFT.getStatus());
        return true;
    }
}

