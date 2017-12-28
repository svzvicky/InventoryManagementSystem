package com.vignesh.ims.UIModels;

public class ReceiptModel {

	private InventoryModel _purchaseProduct;
	private int _purchaseProductCount;
	private double _totalPrice;

	public InventoryModel GetPurchasedProduct() {
		return this._purchaseProduct;
	}

	public void SetPurchasedProduct(InventoryModel value) {
		this._purchaseProduct = value;
	}

	public int GetPurchasedProductCount() {
		return this._purchaseProductCount;
	}

	public void SetPurchasedProductCount(int value) {
		this._purchaseProductCount = value;
	}

	public double GetTotalPrice() {
		return this._totalPrice;
	}

	public void SetTotalPrice(double value) {
		this._totalPrice = value;
	}

}
