package com.anshul.dao;

import java.util.List;

import com.anshul.model.Blog;
import com.anshul.model.Comment;
import com.anshul.model.Services;

public interface BlogDao {
	public List<Blog> getBlogs();

	public Blog getBlogById(int blogid);

	public List<Comment> getCommentsByBlogId(int blogid);

	public void addComment(Comment comment);

}
