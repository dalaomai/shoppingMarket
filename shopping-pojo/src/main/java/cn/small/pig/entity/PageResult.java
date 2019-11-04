package cn.small.pig.entity;

import java.io.Serializable;
import java.util.List;

public class PageResult implements Serializable{
	private long total;
	private long currentPage;
	private long pageSize;
	private List rows;
	
	public PageResult() {
		
	}

	public PageResult(long total, long currentPage, long pageSize, List rows) {
		super();
		this.total = total;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.rows = rows;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public long getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(long currentPage) {
		this.currentPage = currentPage;
	}

	public long getPageSize() {
		return pageSize;
	}

	public void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}


	
	
	
	

}
