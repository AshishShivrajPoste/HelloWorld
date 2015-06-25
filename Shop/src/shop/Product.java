package shop;

public class Product {
    public String PID;
    public String artist;
    public String title;
    public String description;
    public double price;
    public String thumbnail;
    public String fullimage;

    public Product(
            String PID, String artist, String title,
            String description, double price, String thumbnail, String fullimage) {
        this.PID = PID;
        this.artist = artist;
        this.title = title;
        this.description = description;
        this.price = price;
        this.thumbnail = thumbnail;
        this.fullimage = fullimage;
    }

    public String toString() {
        return title + "\t " + price;
    }

}
