package com.anshul.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.anshul.model.Blog;
import com.anshul.model.Comment;
import com.anshul.model.Services;

public class BlogDaoImpl implements BlogDao {
	
	@Autowired
	DataSource datasource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Blog> getBlogs(){
		List<Blog> list;
		String sql="select * from blog";
		list=(List<Blog>) jdbcTemplate.query(sql, new BeanPropertyRowMapper<Blog>(Blog.class));
		return list;
	}

	public Blog getBlogById(int blogid) {
		List<Blog> list;
		String sql="select * from blog where blog_id=\""+blogid+"\"";
		list=(List<Blog>) jdbcTemplate.query(sql, new BeanPropertyRowMapper<Blog>(Blog.class));
		return list.get(0);
	}

	public List<Comment> getCommentsByBlogId(int blogid) {
		List<Comment> list;
		String sql="select * from comment where blog_id=\""+blogid+"\"";
		list=(List<Comment>) jdbcTemplate.query(sql, new BeanPropertyRowMapper<Comment>(Comment.class));
		return list;
	}

	public void addComment(Comment comment) {
		String sql="insert into comment(blog_id,comment,date,time,username) values(?,?,?,?,?)";
		Object[] object= {comment.getBlog_id(),comment.getComment(),comment.getDate(),comment.getTime(),comment.getUsername()};
		jdbcTemplate.update(sql,object);
	}

}
