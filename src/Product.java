public class Product implements Comparable<Product> {
    private String nameProduct;
    private int id;
    private int price;

    public Product() {
    }

    public Product(String nameProduct, int id, int price) {
        this.nameProduct = nameProduct;
        this.id = id;
        this.price = price;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product {" +
                " nameProduct = '" + nameProduct + '\'' +
                ", id = " + id +
                ", price = " + price +
                " }";
    }

    @Override
    public int compareTo(Product o) {
        return o.getPrice()-this.price;
    }
}