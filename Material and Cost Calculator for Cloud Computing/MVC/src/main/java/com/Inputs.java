package com;

import java.text.NumberFormat;

public class Inputs {
	
	private double slabWidth;
	private double slabHeight;
	private double slabThickness;
	private int bagSize;
	
	private int bagsTotal;

	public Inputs() {
        slabWidth = 0.0;
        slabHeight = 0.0;
        slabThickness = 0.0;
        bagSize = 0;
        
	}
	
	
	public double getSlabWidth() {
		return slabWidth;
	}
	/**
	 * @param slabWidth the slabWidth to set
	 */
	public void setSlabWidth(double slabWidth) {
		this.slabWidth = slabWidth;
	}
	/**
	 * @return the slabHeight
	 */
	public double getSlabHeight() {
		return slabHeight;
	}
	/**
	 * @param slabHeight the slabHeight to set
	 */
	public void setSlabHeight(double slabHeight) {
		this.slabHeight = slabHeight;
	}
	/**
	 * @return the slabThickness
	 */
	public double getSlabThickness() {
		return slabThickness;
	}
	/**
	 * @param slabThickness the slabThickness to set
	 */
	public void setSlabThickness(double slabThickness) {
		this.slabThickness = slabThickness;
	}
	
	
	
	/**
	 * @return the bagSize
	 */
	public int getBagSize() {
		return bagSize;
	}
	/**
	 * @param bagSize the bagSize to set
	 */
	public void setBagSize(int bagSize) {
		this.bagSize = bagSize;
	}
	
	

	
	public Inputs(double slabWidth, double slabHeight, double slabThickness, 
			int bagSize) {
		
	       if (slabWidth <= 0 || slabHeight <= 0 || slabThickness <= 0 || bagSize <= 0) {
	            throw new IllegalArgumentException("Arguments must be greater than zero.");
	        }
	
		
		this.slabWidth = slabWidth;
		this.slabHeight = slabHeight;
		this.slabThickness = slabThickness;
		this.bagSize = bagSize;
		
		
	}
	//total cubic yards
	public double getRawSlabVolume() {
		double slabVolume = 0;
		/**
		 * 	 this will return the total cubic yards
		 * slabWidth; in feet need to divide by 3
	 			slabHeight; in feet need to divide by 3
				slabThickness; is in inches need to divide by 12 then 3
		 */
		
		slabVolume = (slabWidth / 3) * (slabHeight / 3) * (slabThickness / 12 / 3);
		return slabVolume;
	}
	
	//rounds raw slab volume to 2 decimals
    public String getSlabVolume() {
        return String.format("%.2f", getRawSlabVolume());
    }
	
	public void setSlabVolume(double slabVolume) {
	}
	
	//total number of bags
    public int getBagsTotal() {
        if (bagSize == 80) {
        	bagsTotal = (int) Math.ceil(getRawSlabVolume() / 0.022);
        	return bagsTotal;
        } else if (bagSize == 60) {
        	bagsTotal =  (int) Math.ceil(getRawSlabVolume() / 0.0167);
        	return bagsTotal;
        } else if (bagSize == 50) {
            bagsTotal = (int) Math.ceil(getRawSlabVolume() / 0.0138);
            
            return bagsTotal;
        } else {
            return 0;
        }
    }
	
	// return the total estimated cost
	//need to do currency format?
    public String getTotalCost() {
    	
		NumberFormat cf = NumberFormat.getCurrencyInstance();
		NumberFormat pf = NumberFormat.getPercentInstance();
		cf.setMaximumFractionDigits(2);
		pf.setMaximumFractionDigits(4);
		
        if (bagSize == 80) {
            return cf.format(3.75 * getBagsTotal());
        } else if (bagSize == 60) {
            return cf.format(2.83 * getBagsTotal());
        } else if (bagSize == 50) {
            return cf.format(2.45 * getBagsTotal());
        } else {
            return cf.format(0.0);
        }
    }
	
    public String getOutputHTML() {
    	String OutputHTML = "";
    	
    	
    	OutputHTML += "<p>Here are your slab input values:</p>";
    	OutputHTML += "<p>Width: " + getSlabWidth() + "</p>";
    	OutputHTML += "<p>Length: " + getSlabHeight() + "</p>";
    	OutputHTML += "<p>Thickness: " + getSlabThickness() + "</p>";
    	OutputHTML += "<p>Bag Size: " + getBagSize() + "</p>";
    	
    	OutputHTML += "<br>";
    	
    	OutputHTML += "<p>This will require the following:</p>";
    	OutputHTML += "<p>Total Cubic Yards: " + getSlabVolume() + "</p>";
    	OutputHTML += "<p>Total Number of Bags: " + getBagsTotal() + "</p>";
    	OutputHTML += "<p>Estimated Cost: " + getTotalCost() + "</p>";
    	
    	return OutputHTML;
    }
	

}
