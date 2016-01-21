package se.webdev.ju15.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.ThreadLocalRandom;

import se.webdev.ju15.bean.DataBean;

public class SortFunctions {

//	public static void main(String[] args) {
//		ArrayList<DataBean> list = new ArrayList<DataBean>();
//		DataBean db = new DataBean("1", "Rodrigo 11inch", "asdsadsad", "2", "");
//		DataBean db1 = new DataBean("2", "Rikard", "asddas", "3", "");
//		DataBean db2 = new DataBean("3", "Alex", "asdsad", "1", "");
//		DataBean db3 = new DataBean("6", "Daniel", "adsdasd", "10", "");
//		DataBean db4 = new DataBean("15", "Johan", "adsada", "6", "");
//		DataBean db5 = new DataBean("4", "Joakim", "adsadasdsa", "2", "");
//
//		list.add(db);
//		list.add(db1);
//		list.add(db2);
//		list.add(db3);
//		list.add(db4);
//		list.add(db5);
//
//		random(list);
//
//	}
	
	public ArrayList<DataBean> highestRating(ArrayList<DataBean> list) {

		Collections.sort(list, (o1, o2) -> o2.getVotes().compareTo(o1.getVotes()));
		return list;
	}
	
	public ArrayList<DataBean> newPosts(ArrayList<DataBean> list) {
		
		Collections.sort(list, (o1, o2) -> o1.getId().compareTo(o2.getId()));
		
		return list;
	}

	public static ArrayList<DataBean> random(ArrayList<DataBean> list) {

		Collections.shuffle(list);

		return list;
	}

	
}
