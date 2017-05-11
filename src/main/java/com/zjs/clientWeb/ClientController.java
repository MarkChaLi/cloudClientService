package com.zjs.clientWeb;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zjs.dto.User;
/**
 * 获取服务器连接等业务处理
 * @author yangshenggang
 *
 */
@RestController
public class ClientController {

    private final Logger    logger = LoggerFactory.getLogger(ClientController.class);

    @Autowired
    private DiscoveryClient client; //获取服务器信息

    @RequestMapping(value = "/info", method = RequestMethod.POST)
    public String info() {
        return "success";
    }

    @RequestMapping(value = "/getuser", method = RequestMethod.POST)
    public User add() {
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("/getuser, host:" + instance.getHost() + ", service_id:" + instance.getServiceId());
        User usr = new User();
        usr.setName("yangshenggang");
        usr.setSex(26);
        return usr;
    }
    
    @RequestMapping(value = "/selectUserlist", method = RequestMethod.POST)
    public List<User> selectUserlist() {
    	List<User> userlist = new ArrayList<User>();
    	for (int i = 0; i < 10; i++) {
			
    		User usr = new User();
    		usr.setName("yangshenggang");
    		usr.setSex(26);
    		userlist.add(usr);
		}
        return userlist;
    }

}
