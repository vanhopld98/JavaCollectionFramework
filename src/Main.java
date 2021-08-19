import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            Menu();
            System.out.println("Chọn gì đó đê:");
            choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    addProduct(productManager, scanner);
                    break;
                }
                case 2: {
                    updateProductById(productManager, scanner);
                    break;
                }
                case 3: {
                    removeProductById(productManager, scanner);
                    break;
                }
                case 4: {
                    productManager.showProduct();
                    break;
                }
                case 5: {
                    findProductByName(productManager, scanner);
                    break;
                }
                case 6: {
                    productManager.sortUp();
                    break;
                }
                case 7: {
                    Collections.sort(productManager.getProductsList());
                    productManager.showProduct();
                    break;
                }
                case 8: {
                    System.exit(0);
                }
            }
        } while (choice >= 1 && choice < 8);
    }

    private static void addProduct(ProductManager productManager, Scanner scanner) {
        System.out.println("Bạn cần nhập thông tin sản phẩm !!");
        System.out.println("1. Tên sản phẩm :");
        scanner.nextLine();
        String nameProduct;
        nameProduct = scanner.nextLine();
        System.out.println("2. id sản phẩm :");
        int id;
        id = scanner.nextInt();
        System.out.println("3. Giá tiền :");
        int price;
        price = scanner.nextInt();
        Product product = new Product(nameProduct, id, price);
        productManager.addProduct(product);
    }

    private static void updateProductById(ProductManager productManager, Scanner scanner) {
        System.out.println("Bạn cần nhập id sản phẩm !!");
        int id;
        id = scanner.nextInt();
        int index;
        index = productManager.findProduct(id);
        if (index == -1) {
            System.out.println("Không tìm thấy sản phẩm");
        } else {
            System.out.println("1. Tên sản phẩm :");
            scanner.nextLine();
            String nameProduct;
            nameProduct = scanner.nextLine();
            System.out.println("2. Id sản phẩm :");
            int idUpdate2;
            idUpdate2 = scanner.nextInt();
            System.out.println("3. Giá tiền :");
            int price;
            price = scanner.nextInt();
            Product product = new Product(nameProduct, idUpdate2, price);
            productManager.updateProduct(index, product);
        }
    }

    private static void removeProductById(ProductManager productManager, Scanner scanner) {
        System.out.println("Bạn cần nhập id sản phẩm !!");
        int id;
        id = scanner.nextInt();
        int index;
        index = productManager.findProduct(id);
        if (index == -1) {
            System.out.println("Không tìm thấy sản phẩm !!");
        } else {
            System.out.println("Đã xóa sản phẩm có id = " + id + " !!");
            productManager.removeProduct(index);
        }
    }

    private static void findProductByName(ProductManager productManager, Scanner scanner) {
        System.out.println("Bạn cần nhập tên sản phẩm !!");
        String name;
        scanner.nextLine();
        name = scanner.nextLine();
        int index;
        index = productManager.findProductByName(name);
        if (index == -1) {
            System.out.println("Không tìm thấy tên sản phẩm !!");
        } else {
            System.out.println(productManager.getProductsList().get(index));
        }
    }

    private static void Menu() {
        System.out.println("*----------------------MENU----------------------*");
        System.out.println("*   1 ->  Thêm sản phẩm.                         *");
        System.out.println("*   2 ->  Sửa sản phẩm theo id.                  *");
        System.out.println("*   3 ->  Xóa sản phẩm theo id.                  *");
        System.out.println("*   4 ->  Hiển thị danh sách sản phẩm.           *");
        System.out.println("*   5 ->  Tìm kiếm sản phẩm theo tên.            *");
        System.out.println("*   6 ->  Sắp xếp sản phẩm theo giá tăng dần.    *");
        System.out.println("*   7 ->  Sắp xếp sản phẩm theo giá giảm dần.    *");
        System.out.println("*   8 ->  Exit.                                  *");
        System.out.println("*------------------------------------------------*");
    }
}