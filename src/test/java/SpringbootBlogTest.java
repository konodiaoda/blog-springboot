import com.wjh.blog.BlogApplication;
import com.wjh.blog.utils.JsonUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wujiahui
 * @description
 * @date 2021-09-11 21:41
 */


@SpringBootTest(properties = "application.yml",classes = BlogApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringbootBlogTest {



    @Test
    public void Test() throws IllegalAccessException, InstantiationException {
        IdentityCard identityCard = new IdentityCard();
        identityCard.setNum("111111");
        User user = User.builder().brith("2010").sex("男").name("张三").identityCard(identityCard).build();
        User user1 = User.builder().brith("2010").sex("男").name("张三").identityCard(identityCard).build();
        List<User> objects =new ArrayList<>();

        objects.add(user);
        objects.add(user1);

        System.out.println(JsonUtils.obj2String(objects));
    }
}
