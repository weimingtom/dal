package com.iteye.weimingtom.dal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.ctrip.platform.dal.dao.annotation.Database;
import com.ctrip.platform.dal.dao.annotation.Sensitive;
import com.ctrip.platform.dal.dao.annotation.Type;
import java.sql.Types;

import com.ctrip.platform.dal.dao.DalPojo;

@Entity
@Database(name="apkver")
@Table(name="photo")
public class PhotoGen implements DalPojo {
	
	@Id
	@Column(name="pid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Type(value=Types.INTEGER)
	private Integer pid;
	
	@Column(name="path")
	@Type(value=Types.VARCHAR)
	private String path;
	
	@Column(name="gallery")
	@Type(value=Types.INTEGER)
	private Integer gallery;

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Integer getGallery() {
		return gallery;
	}

	public void setGallery(Integer gallery) {
		this.gallery = gallery;
	}

}