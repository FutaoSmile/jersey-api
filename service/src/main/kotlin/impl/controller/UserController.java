package impl.controller;

import entity.User;
import face.chain.UserChain;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

import static app.ConfigKt.TransactionTimeout;

/**
 * @author futao
 * Created on 2017/12/19 - 13:20.
 */
@Controller
@Transactional(timeout = TransactionTimeout, isolation = Isolation.REPEATABLE_READ, rollbackFor = Exception.class)
@Path("user")
public class UserController {
    @Resource
    private UserChain userChain;

    /**
     * 添加
     *
     * @param nickName 昵称
     * @param mobile   手机号
     * @return
     */
    @POST
    @Path("add")
    @Produces(MediaType.APPLICATION_JSON)
    public User add(
            @FormParam("nickName") @DefaultValue("") String nickName,
            @FormParam("mobile") @DefaultValue("") String mobile
    ) {
        return userChain.add(nickName, mobile);
    }

    /**
     * 查询
     *
     * @param nickname 昵称
     * @param mobile   手机号
     * @return List<User>
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("list")
    public List<User> list(
            @QueryParam("nickname") @DefaultValue("") String nickname,
            @QueryParam("mobile") @DefaultValue("") String mobile
    ) {
        return userChain.list(nickname, mobile);
    }
}
