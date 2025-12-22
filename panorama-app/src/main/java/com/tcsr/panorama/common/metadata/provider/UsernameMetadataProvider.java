package com.tcsr.panorama.common.metadata.provider;

import com.tcsr.framework.common.metadata.MetadataTypeConstants;
import com.tcsr.framework.common.metadata.provider.AbstractMetadataProvider;
import com.tcsr.framework.web.utils.SecurityUtils;
import org.springframework.stereotype.Component;

/**
 * 
 * @author tangzhong
 * @date   2025-10-24 11:30
 * @since  V1.0.0
 */
@Component
public class UsernameMetadataProvider extends AbstractMetadataProvider<String> {

    public UsernameMetadataProvider(){
        super(MetadataTypeConstants.USER_NAME, SecurityUtils::getUserName);
    }

}