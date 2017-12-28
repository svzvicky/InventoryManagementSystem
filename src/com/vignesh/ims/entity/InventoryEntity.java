package com.vignesh.ims.entity;


public class InventoryEntity {
	
	private int _productid;
	private String _productName ;
	private String _makeModel ;
	private int _noOfItems ;
	private double _price ;
	
	
	public int GetProductId() {
		return this._productid;
	}
	public void SetProductId(int value) {
		 this._productid=value;
	}
	public String GetProductName() {
		return this._productName;
	}
	public void SetProductName(String value) {
		 this._productName=value;
	}
	
	public String GetMakeModel() {
		return this._makeModel;
	}
	public void SetMakeModel(String value) {
		 this._makeModel=value;
	}
	public int GetNoOfItems() {
		return this._noOfItems;
	}
	public void SetNoOfItems(int value) {
		 this._noOfItems=value;
	}
	public double GetPrice() {
		return this._price;
	}
	public void SetPrice(double value) {
		 this._price=value;
	}
	
	

}
