package se.webdev.ju15.sort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import se.webdev.ju15.model.DataBean;

public class SortFunctions {
	Random rm = new Random();

	
	static ArrayList<DataBean> list = new ArrayList<DataBean>();
	

	
	public ArrayList<DataBean> highestRating(ArrayList<DataBean> list) {
		Collections.sort(list);
		return list;
	}
	
	public ArrayList<DataBean> newPosts(ArrayList<DataBean> list) {
		ArrayList<DataBean> al = new ArrayList<DataBean>();
		al.add(list.get(list.size()-1));
		al.add(list.get(list.size()-2));
		al.add(list.get(list.size()-3));
		al.add(list.get(list.size()-4));
		al.trimToSize();
		return al;
	}

	public ArrayList<DataBean> random(ArrayList<DataBean> list) {
		ArrayList<DataBean> al = new ArrayList<DataBean>();
		al.add(list.get(rm.nextInt(list.size())));
		al.add(list.get(rm.nextInt(list.size())));
		al.add(list.get(rm.nextInt(list.size())));
		al.add(list.get(rm.nextInt(list.size())));
		al.trimToSize();
		return al;
	}
	
	public int newId(ArrayList<DataBean> list){
		
		Collections.sort(list, (o1,o2) -> o1.getId().compareTo(o2.getId()));
		
		int id = list.get(0).getId() +1;
		
		return id;
				
	}

	
}
