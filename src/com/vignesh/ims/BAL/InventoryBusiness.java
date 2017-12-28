package com.vignesh.ims.BAL;
import java.util.ArrayList;
import java.util.function.Predicate;

import com.vignesh.ims.UIModels.InventoryModel;
import com.vignesh.ims.entity.InventoryEntity;
import com.vignesh.ims.entity.Receipt;

public class InventoryBusiness {

	
	
	ArrayList<InventoryModel>  _inventoryList=new ArrayList<InventoryModel>();
	public InventoryBusiness()
	{
		//_inventoryList=new ArrayList<InventoryModel>();
		
	}
	
	InventoryModel _inventoryEntity= new InventoryModel();
	
	
	//1. Add inventory
	public boolean AddInventory(InventoryModel inventoryEntityModel)
	{
		_inventoryList.add(inventoryEntityModel);
		_inventoryList.retainAll(_inventoryList);
		return true;
		
	}
	
	//2.Display Inventory
	public ArrayList<InventoryModel> GetInventoryList()
	{
		return _inventoryList;
	}
	
	
	
	//3. Get Product Based on Product Id
	public InventoryModel GetProductById(int ProductId)
	{
		Predicate<InventoryModel> predicate = c-> c.GetProductIdModel()==ProductId;
		InventoryModel  obj = _inventoryList.stream().filter(predicate).findFirst().get();
		return obj;
	}
	
	//4. Purchase from inventory
	public Receipt PurchaseProduct(int productId, int noOfitems)
	{
		
		int stockToUpdate=0;
		InventoryModel inventoryEntity= GetProductById(productId);
		if(noOfitems>inventoryEntity.GetNoOfItemsModel())
			return new Receipt();
		else
		{
			stockToUpdate=inventoryEntity.GetNoOfItemsModel()-noOfitems;
			//TODO : Update stock count in the inventory list;
			//GenerateBill
		 return	GenerateBill(productId,noOfitems,inventoryEntity);
			
			
		}
		
		
	}
	
	
	
	// 5. Generate Bill
	public Receipt GenerateBill(int productId, int noOfitems,InventoryModel inventoryEntity)
	{
		
		//Calculate total price
		double totalPrice;
		totalPrice=noOfitems * inventoryEntity.GetPriceModel();
		
		//Set Receipt Values
		Receipt receipt= new Receipt();
		receipt.SetPurchasedProduct(inventoryEntity);
		receipt.SetPurchasedProductCount(noOfitems);
		receipt.SetTotalPrice(totalPrice);
		return receipt;

	}
	
	
	
	
	
	
	
}
