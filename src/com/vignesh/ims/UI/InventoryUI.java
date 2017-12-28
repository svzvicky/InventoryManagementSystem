package com.vignesh.ims.UI;

import java.util.ArrayList;
import java.util.Scanner;

import com.vignesh.ims.BAL.InventoryBusiness;
import com.vignesh.ims.UIModels.InventoryModel;
import com.vignesh.ims.UIModels.ReceiptModel;

public class InventoryUI {

	public static void main(String[] args) {

		boolean count = true;
		while (count) {
			InventoryBusiness _businessObject = new InventoryBusiness();
			InventoryModel _inventoryUI = new InventoryModel();
			ArrayList<InventoryModel> arrList = new ArrayList<InventoryModel>();
			Scanner in = new Scanner(System.in);
			System.out.println("Menu..");
			System.out.println(
					"1 - to add to inventory\n 2 - to display inventory\n 3 - to make purchase\n 4 - exit from the program");

			int m = in.nextInt();

			switch (m) {
			case 1:
				System.out.println("Enter Product ID:");
				_inventoryUI.SetProductIdModel(in.nextInt());
				System.out.println("Enter Product name:");
				_inventoryUI.SetProductNameModel(in.next());
				System.out.println("Enter Make and Model:");
				_inventoryUI.SetMakeModelModel(in.next());
				System.out.println("Enter Number of items:");
				_inventoryUI.SetNoOfItemsModel(in.nextInt());
				System.out.println("Enter Price:");
				_inventoryUI.SetPriceModel(in.nextDouble());
				if (_businessObject.AddInventory(_inventoryUI))
					System.out.println("Inventory Added Successfully");
				else
					System.out.println("Inventory Addition Failed");

				break;

			case 2:
				arrList = _businessObject.GetInventoryList();
				// Display the inventory
				for (InventoryModel inventoryModel : arrList) {

					System.out.println("-------------------------------");
					System.out.println(" Product ID:" + inventoryModel.GetProductIdModel());

					System.out.println(" Product name:" + inventoryModel.GetProductNameModel());
					System.out.println(" Make and Model:" + inventoryModel.GetMakeModelModel());

					System.out.println(" Number of items:" + inventoryModel.GetNoOfItemsModel());

					System.out.println(" Price:" + inventoryModel.GetPriceModel());
					System.out.println("-------------------------------");

				}

				break;
				
			case 3:
				arrList = _businessObject.GetInventoryList();
				System.out.println("Select Item");
				for (InventoryModel inventoryModel : arrList) {

					System.out.println("-------------------------------");
					System.out.println(" Product ID:" + inventoryModel.GetProductIdModel());
					System.out.println(" Product name:" + inventoryModel.GetProductNameModel());

					System.out.println("-------------------------------");

				}
				System.out.println("Enter Product ID:");
				int productId = in.nextInt();

				System.out.println("Enter No Of Items to purchase:");
				int noOfItems = in.nextInt();
				ReceiptModel receipt = _businessObject.PurchaseProduct(productId, noOfItems);
				if (receipt.GetPurchasedProductCount() == 0) {
					System.out.println("Issue with purchase OR No stock in the inventory");
				} else {
					System.out.println("---------Receipt------------");
					System.out.println("Product ID:" + receipt.GetPurchasedProduct().GetProductIdModel());
					System.out.println("Product Name:" + receipt.GetPurchasedProduct().GetProductNameModel());
					System.out.println("Product Qty:" + receipt.GetPurchasedProductCount());
					System.out.println("Product Price:" + receipt.GetPurchasedProduct().GetPriceModel());
					System.out.println("------------------------------------------------------");
					System.out.println("Total Price:" + receipt.GetTotalPrice());
				}

				break;

			case 4:
				System.exit(0);
				System.out.println("System Exited");

			default:
				System.exit(0);
			}

		}

	}

}
