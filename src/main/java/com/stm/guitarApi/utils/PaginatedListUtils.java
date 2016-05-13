package com.stm.guitarApi.utils;

import java.util.ArrayList;
import java.util.List;

public class PaginatedListUtils {

	private static final int FIRST_PAGE = 0;
	
	
	public static boolean isPaginationRequired(Integer page, Integer count) {
		return (page != null) || (count != null);
	}
	
	public static int getLastPage(int sizeList, int count) {
		if (count <= 0) {
			return FIRST_PAGE;
		}
		
		int lastPage = (sizeList / count);
		if (sizeList % count == 0) {
			lastPage--;
		}
		
		return lastPage;
	}
	
	@SuppressWarnings("rawtypes")
	public static List getPaginatedList(List list, Integer page, Integer count) {
		int validPage = FIRST_PAGE;
		if (page != null) {
			validPage = page;
		}
		
		int sizeList = list.size();
		int validCount = sizeList;
		if (count != null) {
			validCount = count;
		}
		
		if (validCount <= 0) {
			return new ArrayList<Object>();
		}
		
		if (validPage < 0) {
			return new ArrayList<Object>();
		}
		
		if (validCount > sizeList) {
			validCount = sizeList;
		}
		
		int maxIndex = validCount * (validPage + 1) - 1;
		int firstPageIndex = maxIndex - validCount + 1;
		if (firstPageIndex >= sizeList) {
			return new ArrayList<Object>();
		}
		
		int fromIndex = validPage * validCount;
		int toIndex = fromIndex + validCount;
		if (toIndex >= sizeList) {
			toIndex = sizeList;
		}
		
		return list.subList(fromIndex, toIndex);
	}
	
}
