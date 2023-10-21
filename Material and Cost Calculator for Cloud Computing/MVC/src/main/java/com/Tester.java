package com;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Inputs i = new Inputs(14.0, 14.0, 4.0, 50);
		
		
		System.out.println(i.getSlabWidth());
		System.out.println(i.getSlabHeight());
		System.out.println(i.getSlabThickness());
		System.out.println(i.getBagSize());
		System.out.println("--------------");
		//System.out.println(i.getRawSlabVolume());
		System.out.println(i.getSlabVolume());
		System.out.println("--------------");
		System.out.println(i.getBagsTotal());
		System.out.println("--------------");
		System.out.println(i.getTotalCost());
		System.out.println("--------------");
		System.out.println(i.getOutputHTML());
		
	}

}
