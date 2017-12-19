package impl.controller;

import entity.User;
import face.chain.UserChain;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * @author futao
 * Created on 2017/12/19 - 13:20.
 */
@Controller
@Path("user")

public class UserController {
    @Resource
    private UserChain userChain;

    @GET
    @Path("add")
    @Produces(MediaType.APPLICATION_JSON)
    public User add(
            @QueryParam("nickName") @DefaultValue("") String nickName,
            @QueryParam("mobile") @DefaultValue("") String mobile
    ) {
        return userChain.add(nickName, mobile);
    }
}
