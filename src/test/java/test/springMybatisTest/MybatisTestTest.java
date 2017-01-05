package test.springMybatisTest;

import com.alibaba.fastjson.JSON;
import com.cn.ssmtest.domain.User;
import com.cn.ssmtest.service.IUserService;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/** 
* MybatisTest Tester. 
* 
* @author <Authors name> 
* @since <pre>一月 4, 2017</pre> 
* @version 1.0 
*/


@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class MybatisTestTest { 

/*@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} */

/** 
* 
* Method: name() 
* 
*/

    private static Logger logger = Logger.getLogger(MybatisTestTest.class);
    @Resource
    private IUserService userService = null;
    @Test
    public void testName() throws Exception {
        User user = userService.getUserById(1);
        logger.info("值："+user.getUserName());
        logger.info(JSON.toJSONString(user));
    }


} 
