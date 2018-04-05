package com.thread.example;

import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestMap {

	public static void main(String[] args) {
		
		Stream<String> anStream = Stream.of("a", "b", "c", "d", "e");
		 
	    Stream<String> newStream = Stream.concat(anStream, Stream.of("A"));
	 
	    List<String> resultList = newStream.collect(Collectors.toList());
	    
	    resultList.add(1, "testAddAtIndex");
	  
	    resultList.forEach(System.out::println);
	    
		ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<>();
		
		map.put(1, "one");
		map.put(2, "two");
		map.put(3, "three");
		map.put(4, "four");
		map.put(5, "five");
		map.put(6, "six");
		map.put(7, "seven");
		
		Runnable cons = new Runnable() {

			@Override
			public void run() {
				for(Entry<Integer, String> entry: map.entrySet()) {
						System.out.println("Read: "+entry.getKey()+","+entry.getValue());
				}
			}
			
		};
		
		Runnable prod = new Runnable() {

			@Override
			public void run() {
				for(Entry<Integer, String> entry: map.entrySet()) {
					System.out.println("Remove: "+entry.getKey()+","+entry.getValue());
					map.remove(entry.getKey());
			}
		}
			
		};
		
		Thread t1 = new Thread(prod);
		Thread t2 = new Thread(cons);
		
		t1.start();
		t2.start();
	}

}
