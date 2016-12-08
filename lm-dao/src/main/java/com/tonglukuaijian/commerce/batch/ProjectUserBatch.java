package com.tonglukuaijian.commerce.batch;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;

import com.tonglukuaijian.commerce.bean.ProjectUser;

public class ProjectUserBatch implements BatchPreparedStatementSetter{
	private List<ProjectUser> list=new ArrayList<>();
	@Override
	public int getBatchSize() {
		return 0;
	}
	
	@Override
	public void setValues(PreparedStatement ps, int i) throws SQLException {
        ps.setString(1, list.get(i).getProjectId());                   
        ps.setLong(2, list.get(i).getUserId());
        ps.setTimestamp(3, (Timestamp) list.get(i).getCreatedTime());
	}

	
	
	public ProjectUserBatch() {
		super();
	}

	public ProjectUserBatch(List<ProjectUser> list) {
		this.list = list;
	}

	public List<ProjectUser> getList() {
		return list;
	}

	public void setList(List<ProjectUser> list) {
		this.list = list;
	}
	
	

}
