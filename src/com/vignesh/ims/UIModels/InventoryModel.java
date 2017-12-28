package com.vignesh.ims.UIModels;



public class InventoryModel {

	
	private int _productidModel;
	private String _productNameModel ;
	private String _makeModelModel ;
	private int _noOfItemsModel ;
	private double _priceModel ;
	
	
	
	public int GetProductIdModel() {
		return this._productidModel;
	}
	public void SetProductIdModel(int value) {
		 this._productidModel=value;
	}
	public String GetProductNameModel() {
		return this._productNameModel;
	}
	public void SetProductNameModel(String value) {
		 this._productNameModel=value;
	}
	
	public String GetMakeModelModel() {
		return this._makeModelModel;
	}
	public void SetMakeModelModel(String value) {
		 this._makeModelModel=value;
	}
	public int GetNoOfItemsModel() {
		return this._noOfItemsModel;
	}
	public void SetNoOfItemsModel(int value) {
		 this._noOfItemsModel=value;
	}
	public double GetPriceModel() {
		return this._priceModel;
	}
	public void SetPriceModel(double value) {
		 this._priceModel=value;
	}
}