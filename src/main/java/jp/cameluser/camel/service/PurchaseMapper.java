package jp.cameluser.camel.service;

import jp.cameluser.camel.model.PurchaseModel;

import java.util.List;

/**
 * MyBatis mapper interface
 */
public interface PurchaseMapper {

	/**
	 * select all purchases
	 */
    List<PurchaseModel> selectPurchaseAll();

	/**
	 * insert a purchase
	 */
    int insertPurchase(PurchaseModel model);

	/**
	 * update a purchase
	 */
    void updatePurchase(PurchaseModel model);
}
