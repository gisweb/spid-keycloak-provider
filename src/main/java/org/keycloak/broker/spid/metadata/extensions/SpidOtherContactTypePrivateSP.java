package org.keycloak.broker.spid.metadata.extensions;

import org.keycloak.broker.spid.SpidIdentityProviderConfig;
import org.keycloak.saml.common.exceptions.ConfigurationException;

class SpidOtherContactTypePrivateSP extends SpidOtherContactType {

    public SpidOtherContactTypePrivateSP(final SpidIdentityProviderConfig config) throws ConfigurationException {
        super(config);

        // VAT Number
        final String raw = config.getVatNumber();
        addExtensionElement("spid:VATNumber", "VAT" + raw.substring(0, 2) + "-" + raw.substring(2));
        // Fiscal Code
        addExtensionElement("spid:FiscalCode", config.getFiscalCode());

        addQualifier("spid:Private");
    }
}
