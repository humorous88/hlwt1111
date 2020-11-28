package com.Dao.impl;

import com.Dao.QuestionDao;
import com.Entity.single;
import com.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class QuestionDaoImpl implements QuestionDao {
    //使用Jdbc链接数据库，并获取数据库资源
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<single> queryPaperSingle(String paper) {
        String sql="SELECT * from single where paper= ? ";
        //template.query(sql语句,如果结果集不是基本类型就使用BeanPropertyRowMapper转换结果集为指定对象，
        // ? 表示占位符，即将我们的参数传递入？中)
        return template.query(sql,new BeanPropertyRowMapper<>(single.class),paper);
    }

    @Override
    public List<String> queryPaperList() {
        String sql = "SELECT DISTINCT paper FROM single";
        List<String> list = template.queryForList(sql,String.class);
        return list;
    }
}
