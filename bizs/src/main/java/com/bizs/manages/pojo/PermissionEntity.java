package com.bizs.manages.pojo;

import java.util.Date;

public class PermissionEntity {
	private String id;
	private String pid;
	private String depth_path;
	private String name;
	private String url;
	private String identification;
	private String remark;
	private String sort_num;
	private String create_user_id;
	private Date create_time;
	private String update_user_id;
	private Date update_time;
	private String is_delete;
	private String type;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getDepth_path() {
		return depth_path;
	}
	public void setDepth_path(String depth_path) {
		this.depth_path = depth_path;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getIdentification() {
		return identification;
	}
	public void setIdentification(String identification) {
		this.identification = identification;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getSort_num() {
		return sort_num;
	}
	public void setSort_num(String sort_num) {
		this.sort_num = sort_num;
	}
	public String getCreate_user_id() {
		return create_user_id;
	}
	public void setCreate_user_id(String create_user_id) {
		this.create_user_id = create_user_id;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public String getUpdate_user_id() {
		return update_user_id;
	}
	public void setUpdate_user_id(String update_user_id) {
		this.update_user_id = update_user_id;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	public String getIs_delete() {
		return is_delete;
	}
	public void setIs_delete(String is_delete) {
		this.is_delete = is_delete;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((create_time == null) ? 0 : create_time.hashCode());
		result = prime * result + ((create_user_id == null) ? 0 : create_user_id.hashCode());
		result = prime * result + ((depth_path == null) ? 0 : depth_path.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((identification == null) ? 0 : identification.hashCode());
		result = prime * result + ((is_delete == null) ? 0 : is_delete.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pid == null) ? 0 : pid.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((sort_num == null) ? 0 : sort_num.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((update_time == null) ? 0 : update_time.hashCode());
		result = prime * result + ((update_user_id == null) ? 0 : update_user_id.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PermissionEntity other = (PermissionEntity) obj;
		if (create_time == null) {
			if (other.create_time != null)
				return false;
		} else if (!create_time.equals(other.create_time))
			return false;
		if (create_user_id == null) {
			if (other.create_user_id != null)
				return false;
		} else if (!create_user_id.equals(other.create_user_id))
			return false;
		if (depth_path == null) {
			if (other.depth_path != null)
				return false;
		} else if (!depth_path.equals(other.depth_path))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (identification == null) {
			if (other.identification != null)
				return false;
		} else if (!identification.equals(other.identification))
			return false;
		if (is_delete == null) {
			if (other.is_delete != null)
				return false;
		} else if (!is_delete.equals(other.is_delete))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (pid == null) {
			if (other.pid != null)
				return false;
		} else if (!pid.equals(other.pid))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (sort_num == null) {
			if (other.sort_num != null)
				return false;
		} else if (!sort_num.equals(other.sort_num))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (update_time == null) {
			if (other.update_time != null)
				return false;
		} else if (!update_time.equals(other.update_time))
			return false;
		if (update_user_id == null) {
			if (other.update_user_id != null)
				return false;
		} else if (!update_user_id.equals(other.update_user_id))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}
	
}
