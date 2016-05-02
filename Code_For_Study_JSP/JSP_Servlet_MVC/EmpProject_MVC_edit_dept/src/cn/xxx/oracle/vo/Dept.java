package cn.mldn.oracle.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@SuppressWarnings("serial")
public class Dept implements Serializable {
	private Map<String,Object> stat ;	// 保存所有的统计信息
	private Integer deptno ;
	private String dname ;
	private String loc ;
	private List<Emp> emps ;	// 多个雇员
	public void setStat(Map<String, Object> stat) {
		this.stat = stat;
	}
	public Map<String, Object> getStat() {
		return stat;
	}
	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}
	public List<Emp> getEmps() {
		return emps;
	}
	public Integer getDeptno() {
		return deptno;
	}
	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
}
