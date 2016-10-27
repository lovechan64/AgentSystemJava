package org.agent.common;

import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class PageSupport {
	private int totalCount=0 ;
	private int pageCount;
	private int pageSize=3;
	private int page=1;
	private int num=3 ;
	private List items=new ArrayList();
	
	
	public int getPrev(){
		return this.page-1;
	}
	public int getNext(){
		return this.page+1;
	}
	
	public int getLast(){
		return this.pageCount;
	}
	
	public boolean getIsPrev(){
		 if(page>1)
			 return true;
		 else
			 return false;
	}
	
	public boolean getIsNext(){
		 if(pageCount>page)
			 return true;
		 else
			 return false;
	}
	
	public List<Integer> getNextPages(){
		
		List<Integer> list=new ArrayList<Integer>();
		int end=num;
		
		
		
		
		if(pageCount>num&&(page+num)<pageCount){
		end=page+end;
		}else {
			end=pageCount;
		}
		
		for (int i=page+1;i<=end;i++ ) {
			list.add(i);
		}
		
				return list;
	}
	
	public List<Integer> getPrevPages(){
		List<Integer> list=new ArrayList<Integer>();
		int font=1;
		if(page>num)
		font=page-num;
		
		for (int i=font;i<page;i++ ) {
			list.add(i);
		}
		
				return list;
	
	}
	
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
	if(totalCount>0)
		this.totalCount = totalCount;
	this.pageCount=totalCount%pageSize>0?totalCount/pageSize+1:totalCount/pageSize;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public List getItems() {
		return items;
	}
	public void setItems(List items) {
		this.items = items;
	}
	
	
}
