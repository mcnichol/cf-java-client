package com.mcnichol.cf;

import org.cloudfoundry.operations.CloudFoundryOperations;
import org.cloudfoundry.operations.organizations.OrganizationSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CfService {
    private CloudFoundryOperations cloudFoundryOperations;

    @Autowired
    CfService(CloudFoundryOperations cloudFoundryOperations) {
        this.cloudFoundryOperations = cloudFoundryOperations;
    }

    public List<String> listOrganizations() {
        return cloudFoundryOperations.organizations()
                .list()
                .map(OrganizationSummary::getName)
                .collectList()
                .block();
    }
}
