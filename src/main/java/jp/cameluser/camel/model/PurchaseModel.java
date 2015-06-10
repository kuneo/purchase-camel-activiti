package jp.cameluser.camel.model;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

import java.io.Serializable;
import java.util.Date;

/**
 * mapping model of camel-bindy
 */
@CsvRecord(separator = ",", crlf = "\r\n")
public class PurchaseModel implements Serializable{

    /**
	 * serial
	 */
	private static final long serialVersionUID = 1L;

	/**
     * id
     */
    private int id;

    /**
     * status
     */
    private String status;

    @DataField(pos = 1)
    private String name;

    /**
     * price
     */
    @DataField(pos = 2)
    private int price;

    /**
     * date
     */
    @DataField(pos = 3, pattern = "yyyy/MM/dd")
    private Date buyingDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getBuyingDate() {
        return buyingDate;
    }

    public void setBuyingDate(Date buyingDate) {
        this.buyingDate = buyingDate;
    }
}
