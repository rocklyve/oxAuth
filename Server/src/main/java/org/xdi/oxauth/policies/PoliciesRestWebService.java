package org.xdi.oxauth.policies;

import com.wordnik.swagger.annotations.*;
import org.xdi.oxauth.model.authorize.AuthorizeRequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@Api(value = "/", description = "The policies Endpoint performs the policies of the End-User.")
public interface PoliciesRestWebService {

        @GET
        @Path("/policies")
        @Produces({MediaType.TEXT_PLAIN})
        @ApiOperation(
                value = "Performs policies check.",
                notes = "The Policies Endpoint performs checking the policies of the End-User.",
                response = Response.class,
                responseContainer = "JSON"
        )
        @ApiResponses(value = {
                @ApiResponse(code = 302, message = "interaction_required\n" +
                        "    The policies Server requires End-User interaction of some form to proceed. This error MAY be returned when the prompt parameter value in the policies Request is none, but the policies Request cannot be completed without displaying a user interface for End-User interaction. "),
                @ApiResponse(code = 302, message = "login_required\n" +
                        "    The policies Server requires End-User policies. This error MAY be returned when the prompt parameter value in the policies Request is none, but the policies Request cannot be completed without displaying a user interface for End-User policies. "),
        })
        Response requestPoliciesGet(
                @QueryParam("scope")
                @ApiParam(value = "OpenID Connect requests MUST contain the openid scope value. If the openid scope value is not present, the behavior is entirely unspecified. Other scope values MAY be present. Scope values used that are not understood by an implementation SHOULD be ignored.", required = true)
                        String scope,
                @QueryParam(AuthorizeRequestParam.CUSTOM_RESPONSE_HEADERS)
                @ApiParam(value = "Custom Response Headers.", required = false)
                        String customResponseHeaders,
                @QueryParam("claims")
                @ApiParam(value = "Requested Claims.", required = false)
                        String claims,
                @Context HttpServletRequest httpRequest,
                @Context HttpServletResponse httpResponse,
                @Context SecurityContext securityContext);

        @POST
        @Path("/policies")
        @Produces({MediaType.TEXT_PLAIN})
        @ApiOperation(
                value = "Performs authorization.",
                notes = "The Authorization Endpoint performs Authentication of the End-User.",
                response = Response.class,
                responseContainer = "JSON"
        )
        @ApiResponses(value = {
                @ApiResponse(code = 302, message = "interaction_required\n" +
                        "    The Authorization Server requires End-User interaction of some form to proceed. This error MAY be returned when the prompt parameter value in the Authentication Request is none, but the Authentication Request cannot be completed without displaying a user interface for End-User interaction. "),
                @ApiResponse(code = 302, message = "login_required\n" +
                        "    The Authorization Server requires End-User authentication. This error MAY be returned when the prompt parameter value in the Authentication Request is none, but the Authentication Request cannot be completed without displaying a user interface for End-User authentication. "),
        })
        Response requestPoliciesPost(
                @FormParam("scope")
                @ApiParam(value = "OpenID Connect requests MUST contain the openid scope value. If the openid scope value is not present, the behavior is entirely unspecified. Other scope values MAY be present. Scope values used that are not understood by an implementation SHOULD be ignored.", required = true)
                        String scope,
                @QueryParam("code_challenge_method")
                @ApiParam(value = "PKCE code challenge method.", required = false)
                        String codeChallengeMethod,
                @QueryParam(AuthorizeRequestParam.CUSTOM_RESPONSE_HEADERS)
                @ApiParam(value = "Custom Response Headers.", required = false)
                        String customResponseHeaders,
                @QueryParam("claims")
                @ApiParam(value = "Requested Claims.", required = false)
                        String claims,
                @Context HttpServletRequest httpRequest,
                @Context HttpServletResponse httpResponse,
                @Context SecurityContext securityContext);
}
