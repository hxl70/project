package test;

import com.hxl.Application;
import com.hxl.mvc.entity.Constant;
import com.hxl.mvc.query.ConstantQuery;
import com.hxl.mvc.service.ConstantService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by hxl on 2016/8/25.
 * TestConstantService
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class TestConstantService {

    @Autowired
    private ConstantService constantService;

    private String id;

    @Test
    public void test() {
        Assert.assertNotNull(constantService);
    }

    @Test
    public void testSave() {
        Constant constant = new Constant();
        constant.setCode("code");
        constant.setName("name");
        constant.setNum(1);
        constantService.save(constant);
        Assert.assertNotNull(constant.getId());
        id = constant.getId();
    }

    @Test
    public void testUpdate() {
        Constant constant = constantService.findById(id);
        constant.setCode("code2");
        constant.setNum(2);
        constant.setName("name2");
        constantService.update(constant);
    }

    @Test
    public void testSaveChildren() {
        Constant parent = constantService.findById(id);
        Constant constant = new Constant();
        constant.setCode("code3");
        constant.setNum(3);
        constant.setName("name3");
        constant.setParent(parent);
        constantService.save(constant);
        Assert.assertNotNull(parent.getChildren());
    }

    @Test
    public void testFindByParentCode() {
        List<Constant> children = constantService.findByParentCode("code2");
        Assert.assertNotNull(children);
    }

    @Test
    public void testPage() {
        ConstantQuery query = new ConstantQuery();
        Page<Constant> page = constantService.page(query);
        Assert.assertNotNull(page.getContent());
    }

    @Test
    public void testAll() {
        testSave();
        testUpdate();
        testFindByParentCode();
        testFindByParentCode();
        constantService.delete(id);
        testFindByParentCode();
    }

}
