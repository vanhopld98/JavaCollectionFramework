import java.util.ArrayList;
import java.util.Collections;

public class ProductManager {
    private ArrayList<Product> productsList = new ArrayList<>();

    public ArrayList<Product> getProductsList() {
        return productsList;
    }

    //hiển thị sản phẩm
    public void showProduct() {
        for (Product product : productsList) {
            System.out.println(product);
        }
    }

    //thêm sản phẩm
    public void addProduct(Product product) {
        productsList.add(product);
    }

    //sửa sản phẩm
    public void updateProduct(int idex, Product product) {
        productsList.set(idex, product);

    }

    // tìm kiếm sản phẩm theo id
    public int findProduct(int id) {
        int index = -1;
        for (int i = 0; i < productsList.size(); i++) {
            if (productsList.get(i).getId() == id) {
                index = i;
                break;
            }
        }
        return index;
    }

    //tìm sản phảm theo tên
    public int findProductByName(String name) {
        int index = -1;
        for (int i = 0; i < productsList.size(); i++) {
            if (productsList.get(i).getNameProduct().equals(name)) {
                index = i;
                break;
            }
        }
        return index;
    }


    //xóa sản phẩm
    public void removeProduct(int idex) {
        productsList.remove(idex);
    }

    //sắp xếp theo giá tăng dần
    public void sortUp() {
        PriceComparator priceComparator = new PriceComparator();
        Collections.sort(productsList, priceComparator);
        for (Product product : productsList) {
            System.out.println(product);
        }
    }

}