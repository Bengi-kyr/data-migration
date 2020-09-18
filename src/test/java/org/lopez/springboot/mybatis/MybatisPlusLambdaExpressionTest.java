package org.lopez.springboot.mybatis;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.lopez.springboot.mybatis.mapper.JyBondBaseInfoMapper;
import org.lopez.springboot.mybatis.model.JyBondBaseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisPlusLambdaExpressionTest {

    @Autowired
    private JyBondBaseInfoMapper jyBondBaseInfoMapper;

    @Test
    public void QueryTest() {
        List<JyBondBaseInfo> bondBaseInfoList = jyBondBaseInfoMapper.selectList(
                new QueryWrapper<JyBondBaseInfo>().lambda().eq(JyBondBaseInfo::getBondCode, "100920"));
        Assert.notNull(bondBaseInfoList, "未查询到对应的债券信息");
        bondBaseInfoList.forEach(p -> System.out.println(p.getBondFullName()));
    }
}
