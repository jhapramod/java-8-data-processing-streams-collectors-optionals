package com.pramod.java8.garbagecollection;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;

public class GCDemo {

	public static void main(String[] args) {
		List<GarbageCollectorMXBean> list = ManagementFactory.getGarbageCollectorMXBeans();
		for (GarbageCollectorMXBean bean : list) {
			System.out.println("Names: " + bean.getName());
			System.out.println("No of collections: " + bean.getCollectionCount());
			System.out.println("Collection Time: " + bean.getCollectionTime());
			
			System.out.println("Pool name: ");
			
			for(String name: bean.getMemoryPoolNames()) {
				System.out.println("\t" + name);
			}
			System.out.println();
		}

	}

}
