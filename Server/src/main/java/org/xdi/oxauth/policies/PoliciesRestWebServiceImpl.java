package org.xdi.oxauth.policies;

import com.wordnik.swagger.annotations.Api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Path("/")
@Api(value = "/oxauth/policies", description = "Policies Endpoint")
public class PoliciesRestWebServiceImpl implements PoliciesRestWebService{
    @Override
    public Response requestPoliciesGet(String scope, String customResponseHeaders, String claims,
                                       HttpServletRequest httpRequest, HttpServletResponse httpResponse,
                                       SecurityContext securityContext) {
         return Response.ok("hi", MediaType.TEXT_PLAIN).build();
    }

    @Override
    public Response requestPoliciesPost(String scope, String codeChallengeMethod, String customResponseHeaders,
                                        String claims, HttpServletRequest httpRequest, HttpServletResponse httpResponse,
                                        SecurityContext securityContext) {
        return Response.ok("hi", MediaType.TEXT_PLAIN).build();
    }
}
