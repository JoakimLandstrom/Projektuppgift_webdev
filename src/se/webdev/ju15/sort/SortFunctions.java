package se.webdev.ju15.sort;

import java.util.ArrayList;
import java.util.Collections;

import se.webdev.ju15.bean.DataBean;

public class SortFunctions {

	
	static ArrayList<DataBean> list = new ArrayList<DataBean>();
	
	
	public ArrayList<DataBean> highestRating(ArrayList<DataBean> list) {

		Collections.sort(list, (o1, o2) -> o2.getVotes().compareTo(o1.getVotes()));
		return list;
	}
	
	public ArrayList<DataBean> newPosts(ArrayList<DataBean> list) {
		
		Collections.sort(list, (o1, o2) -> o1.getId().compareTo(o2.getId()));
		
		return list;
	}

	public ArrayList<DataBean> random(ArrayList<DataBean> list) {

		Collections.shuffle(list);

		return list;
	}
	
	public int newId(ArrayList<DataBean> list){
		
		Collections.sort(list, (o1,o2) -> o1.getId().compareTo(o2.getId()));
		
		int id = list.get(0).getId() +1;
		
		return id;
				
	}
}
