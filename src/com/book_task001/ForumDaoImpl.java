package com.book_task001;

import cn.dao.ForumDAO;
import cn.domain.Forum;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ForumDao")
public class ForumDaoImpl implements ForumDAO {
    SqlSession sqlSession;

    @Override
    public int insertForum(Forum forum){
        sqlSession = MybatisUtils.getSession();
        int num = sqlSession.insert("insertForum",forum);
        sqlSession.commit();
        sqlSession.close();
        return num;
    }

    @Override
    public List<Forum> getAllForums(){
        sqlSession = MybatisUtils.getSession();
        List<Forum> forums = sqlSession.selectList("getAllForums");
        return forums;
    }

    @Override
    public void batchInsert(List<Forum> forums){
        sqlSession = MybatisUtils.getSession();
        sqlSession.insert("batchInsert", forums);
        sqlSession.commit();
        sqlSession.close();
        System.out.println("批量添加完成");
    }
}
