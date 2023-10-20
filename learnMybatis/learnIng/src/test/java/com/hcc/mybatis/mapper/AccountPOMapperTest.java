package com.hcc.mybatis.mapper;

import com.hcc.mybatis.pojo.AccountPO;
import com.hcc.mybatis.pojo.AccountPOExample;
import com.hcc.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AccountPOMapperTest {
    @Test
    public void testInsert() {
        SqlSession session = SqlSessionUtil.getSqlSession();
        AccountPOMapper mapper = session.getMapper(AccountPOMapper.class);
        AccountPO accountPO = new AccountPO();
        accountPO.setName("Mary");
        accountPO.setUseAge(19);
        accountPO.setMoney(1234567L);
        int count = mapper.insert(accountPO);
        System.out.println("插入数据" + count + "条");

        session.commit();
        session.close();
    }

    @Test
    public void testInsertSelective() {
        SqlSession session = SqlSessionUtil.getSqlSession();
        AccountPOMapper mapper = session.getMapper(AccountPOMapper.class);
        AccountPO accountPO = new AccountPO();
        accountPO.setName("Mary2");
        accountPO.setUseAge(19);
        accountPO.setMoney(123L);
        int count = mapper.insertSelective(accountPO);
        System.out.println("插入数据" + count + "条");

        session.commit();
        session.close();
    }

    @Test
    public void testUpdatePrimaryKeySelective() {
        SqlSession session = SqlSessionUtil.getSqlSession();
        AccountPOMapper mapper = session.getMapper(AccountPOMapper.class);
        AccountPO accountPO = new AccountPO();
        accountPO.setId(1);
        accountPO.setMoney(12115L);
        int count = mapper.updateByPrimaryKeySelective(accountPO);
        System.out.println("更新数据" + count + "条");

        session.commit();
        session.close();
    }

    @Test
    public void testUpdateByPrimaryKey() {
        SqlSession session = SqlSessionUtil.getSqlSession();
        AccountPOMapper mapper = session.getMapper(AccountPOMapper.class);
        AccountPO accountPO = new AccountPO();
        accountPO.setId(2);
        accountPO.setMoney(125L);
        accountPO.setGender(1);
        accountPO.setStatus(1);
        accountPO.setUseAge(11);
        accountPO.setName("李四");
        int count = mapper.updateByPrimaryKey(accountPO);
        System.out.println("更新数据" + count + "条");

        session.commit();
        session.close();
    }

    @Test
    public void testDeleteByPrimaryKey() {
        SqlSession session = SqlSessionUtil.getSqlSession();
        AccountPOMapper mapper = session.getMapper(AccountPOMapper.class);


        int count = mapper.deleteByPrimaryKey(18);
        System.out.println("更新数据" + count + "条");

        session.commit();
        session.close();
    }

    @Test
    public void testSelectQbc() {
        SqlSession session = SqlSessionUtil.getSqlSession();
        AccountPOMapper mapper = session.getMapper(AccountPOMapper.class);
        // 第一步： 创建example 和 criteria
        AccountPOExample example = new AccountPOExample();
        AccountPOExample.Criteria criteria = example.createCriteria();
        // 第二步： 设置查询条件
        criteria.andStatusEqualTo(1)
                .andUseAgeEqualTo(15)
                .andGenderEqualTo(1);

        // 第三步：执行查询
        List<AccountPO> accountPOList = mapper.selectByExample(example);
        System.out.println("数据总条数" + accountPOList.size() + "条");
        for (AccountPO data : accountPOList) {
            System.out.println(data);
        }
    }

    public List<AccountPO> testSelectByALlUtils(AccountPO accountPO) {
        // 年龄非空，根据年龄查；年龄为空，性别非空，根据性别查；年龄、性别都为空，查询所有余额大于1000的账号
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        AccountPOMapper mapper = sqlSession.getMapper(AccountPOMapper.class);

        // 1. 创建criteria
        AccountPOExample example = new AccountPOExample();
        AccountPOExample.Criteria criteria = example.createCriteria();

        // 2. 编写查询条件
        if (accountPO.getUseAge() != null) {
            criteria.andUseAgeGreaterThanOrEqualTo(accountPO.getUseAge());
        } else if (accountPO.getGender() != null) {
            criteria.andGenderEqualTo(accountPO.getGender());
        } else {
            criteria.andMoneyGreaterThan(100L);
        }

        example.setOrderByClause("money desc");
        return mapper.selectByExample(example);
    }

    @Test
    public void testSelectByALl() {
        AccountPO accountPO = new AccountPO();
        accountPO.setUseAge(12);
        List<AccountPO> list = testSelectByALlUtils(accountPO);
        System.out.println("根据年龄查询");
        for (AccountPO data : list) {
            System.out.println(data);
        }
    }

    public List<AccountPO> getOffsetAndLimitList(int pageNO, int pageSize) {
        // 测试分页
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        AccountPOMapper mapper = sqlSession.getMapper(AccountPOMapper.class);

        // 1. 创建criteria
        AccountPOExample example = new AccountPOExample();
        AccountPOExample.Criteria criteria = example.createCriteria();

        // 2. 设置查询条件
        criteria.andStatusEqualTo(1);
        // 按照money排序
        example.setOrderByClause("money desc");

        // 设置分页信息
        int offset = (pageNO - 1) * pageSize;
        RowBounds rowBounds = new RowBounds(offset, pageSize);
        // 执行查询
         return mapper.selectByExampleWithRowbounds(example, rowBounds);

    }

    @Test
    public void testOffset() {
        List<AccountPO> list = getOffsetAndLimitList(1, 2);
        System.out.println("查询的页码" + 1);
        for (AccountPO data: list) {
            System.out.println(data);
        }

        list = getOffsetAndLimitList(2, 2);
        System.out.println("查询的页码" + 2);
        for (AccountPO data: list) {
            System.out.println(data);
        }

        list = getOffsetAndLimitList(3, 2);
        System.out.println("查询的页码" + 3);
        for (AccountPO data: list) {
            System.out.println(data);
        }
    }
}
