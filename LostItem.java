
package cite_lostandfounddepartment_system;


public class LostItem {

    private int lostId;
    private String itemName;
    private String category;
    private String dateLost;
    private String locationLost;
    private String reportedBy;
    private String status;
    private byte[] imageData;

    public LostItem(int lostId,
                    String itemName,
                    String category,
                    String dateLost,
                    String locationLost,
                    String reportedBy,
                    String status,
                    byte[] imageData) {

        this.lostId = lostId;
        this.itemName = itemName;
        this.category = category;
        this.dateLost = dateLost;
        this.locationLost = locationLost;
        this.reportedBy = reportedBy;
        this.status = status;
        this.imageData = imageData;
    }

    public int getLostId() {
        return lostId;
    }

    public String getItemName() {
        return itemName;
    }

    public String getCategory() {
        return category;
    }

    public String getDateLost() {
        return dateLost;
    }

    public String getLocationLost() {
        return locationLost;
    }

    public String getReportedBy() {
        return reportedBy;
    }

    public String getStatus() {
        return status;
    }

    public byte[] getImageData() {
        return imageData;
    }
}
    

