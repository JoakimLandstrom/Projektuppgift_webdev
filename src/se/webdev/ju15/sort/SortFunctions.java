package se.webdev.ju15.sort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import se.webdev.ju15.bean.DataBean;

public class SortFunctions {

	
	static ArrayList<DataBean> list = new ArrayList<DataBean>();
	
//	public SortFunctions() throws IOException{
//		
//	}
	
//	public static ArrayList<DataBean> loadData() {
//		
//		String line = "";
//		String data[] = new String[3];
//		
//		String dir = System.getProperty("user.dir");
//		try (BufferedReader reader = new BufferedReader(new FileReader(dir + "/Post/post.csv"))) {
//			reader.readLine();
//
//			while ((line = reader.readLine()) != null) {
//
//				data = line.split(",");
//				DataBean dataBean = new DataBean(data[0],data[1],data[2], data[3]);
//				list.add(dataBean);
//			}
//		} catch (Exception e) {
//			System.out.println("Couldnt load text file!");
//			e.printStackTrace();
//		}
//		return list;
//	}
	
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

	
}
