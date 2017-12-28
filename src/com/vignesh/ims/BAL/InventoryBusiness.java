package com.vignesh.ims.BAL;

import java.util.ArrayList;
import java.util.function.Predicate;

import com.vignesh.ims.Data.InventoryRepository;
import com.vignesh.ims.UIModels.InventoryModel;
import com.vignesh.ims.UIModels.ReceiptModel;

public class InventoryBusiness {

	ArrayList<InventoryModel> _inventoryList = new ArrayList<InventoryModel>();
	InventoryRepository _irepository = new InventoryRepository();

	public InventoryBusiness() {
		_inventoryList = new ArrayList<InventoryModel>();

	}

	InventoryModel _inventoryEntity = new InventoryModel();

	// 1. Add inventory
	public boolean AddInventory(InventoryModel inventoryEntityModel) {

		return _irepository.AddInventory(inventoryEntityModel);

		// Without Database
		// _inventoryList.add(inventoryEntityModel);
		// _inventoryList.retainAll(_inventoryList);

	}

	// 2.Display Inventory
	public ArrayList<InventoryModel> GetInventoryList() {
		return _irepository.GetInventoryList();
		// Without DB
		// return _inventoryList;
	}

	// 3. Get Product Based on Product Id
	public InventoryModel GetProductById(int ProductId) {
		Predicate<InventoryModel> predicate = c -> c.GetProductIdModel() == ProductId;
		InventoryModel obj = GetInventoryList().stream().filter(predicate).findFirst().get();
		// Without DB
		// InventoryModel obj =
		// _inventoryList.stream().filter(predicate).findFirst().get();
		return obj;
	}

	// 4. Purchase from inventory
	public ReceiptModel PurchaseProduct(int productId, int noOfitems) {

		int stockToUpdate = 0;
		InventoryModel inventoryEntity = GetProductById(productId);
		if (noOfitems > inventoryEntity.GetNoOfItemsModel())
			return new ReceiptModel();
		else {

			stockToUpdate = inventoryEntity.GetNoOfItemsModel() - noOfitems;
			// Create Update Model
			InventoryModel UpdateModel = new InventoryModel();
			UpdateModel.SetNoOfItemsModel(stockToUpdate);
			UpdateModel.SetProductIdModel(productId);
			// Update stock count in the inventory list/DB;
			_irepository.UpdateInventoryStock(UpdateModel);

			// GenerateBill
			return GenerateBill(productId, noOfitems, inventoryEntity);

		}

	}

	// 5. Generate Bill
	public ReceiptModel GenerateBill(int productId, int noOfitems, InventoryModel inventoryEntity) {
		// Calculate total price
		double totalPrice;
		totalPrice = noOfitems * inventoryEntity.GetPriceModel();

		// Set Receipt Values
		ReceiptModel receipt = new ReceiptModel();
		receipt.SetPurchasedProduct(inventoryEntity);
		receipt.SetPurchasedProductCount(noOfitems);
		receipt.SetTotalPrice(totalPrice);
		return receipt;

	}

}
