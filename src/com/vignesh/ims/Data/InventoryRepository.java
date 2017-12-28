package com.vignesh.ims.Data;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.vignesh.ims.UIModels.InventoryModel;

public class InventoryRepository {

	Connection connection = ConnectionString.getConnection();

	public boolean AddInventory(InventoryModel inventoryEntityModel) {
		boolean isInserted = false;

		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO inventorymaster VALUES (?, ?, ?, ?, ?)");
			ps.setInt(1, inventoryEntityModel.GetProductIdModel());
			ps.setString(2, inventoryEntityModel.GetProductNameModel());
			ps.setString(3, inventoryEntityModel.GetMakeModelModel());
			ps.setInt(4, inventoryEntityModel.GetNoOfItemsModel());
			ps.setDouble(5, inventoryEntityModel.GetPriceModel());

			int i = ps.executeUpdate();
			if (i == 1) {
				isInserted = true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		// return false;

		return isInserted;

	}

	private InventoryModel extractUserFromResultSet(ResultSet rs) throws SQLException {
		InventoryModel model = new InventoryModel();
		model.SetProductIdModel(rs.getInt("productid"));
		model.SetProductNameModel(rs.getString("productname"));
		model.SetMakeModelModel(rs.getString("productmodel"));
		model.SetPriceModel(rs.getInt("productprice"));
		model.SetNoOfItemsModel(rs.getInt("productnoofItems"));
		return model;
	}

	public ArrayList<InventoryModel> GetInventoryList() {

		ArrayList<InventoryModel> _inventoryList = new ArrayList<InventoryModel>();

		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM inventorymaster");

			while (rs.next()) {
				InventoryModel model = extractUserFromResultSet(rs);
				_inventoryList.add(model);
			}
			return _inventoryList;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return _inventoryList;
	}

	public boolean UpdateInventoryStock(InventoryModel inventoryEntityModel) {
		boolean isUpdated = false;
		try {
			Statement stmt = connection.createStatement();
			String sqlStmt = "Update inventorymaster set productnoofItems=" + inventoryEntityModel.GetNoOfItemsModel()
					+ " where productId=" + inventoryEntityModel.GetProductIdModel();
			int i = stmt.executeUpdate(sqlStmt);
			if (i == 1)
				isUpdated = true;

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return isUpdated;
	}
}
