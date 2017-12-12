package org.xdi.oxauth.policies;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

public class PoliciesRestWebServiceImpl implements PoliciesRestWebService{
    @Override
    public Response requestPoliciesGet(String scope, String customResponseHeaders, String claims,
                                       HttpServletRequest httpRequest, HttpServletResponse httpResponse,
                                       SecurityContext securityContext) {
        return null;
    }

    @Override
    public Response requestPoliciesPost(String scope, String codeChallengeMethod, String customResponseHeaders,
                                        String claims, HttpServletRequest httpRequest, HttpServletResponse httpResponse,
                                        SecurityContext securityContext) {
        return null;
    }
}
