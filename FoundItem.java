
package cite_lostandfounddepartment_system;


public class FoundItem {
    
        private int foundId;
    private String itemName;
    private String category;
    private String dateFound;
    private String locationFound;
    private String reportedBy;
    private String status;
    private byte[] imageData;

    public FoundItem(
            int foundId,
            String itemName,
            String category,
            String dateFound,
            String locationFound,
            String reportedBy,
            String status,
            byte[] imageData) {

        this.foundId = foundId;
        this.itemName = itemName;
        this.category = category;
        this.dateFound = dateFound;
        this.locationFound = locationFound;
        this.reportedBy = reportedBy;
        this.status = status;
        this.imageData = imageData;
    }

    public int getFoundId() {
        return foundId;
    }

    public String getItemName() {
        return itemName;
    }

    public String getCategory() {
        return category;
    }

    public String getDateFound() {
        return dateFound;
    }

    public String getLocationFound() {
        return locationFound;
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
