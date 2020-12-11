package store;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class StoreTests {
    private Store store;

    @Before
    public void setUp() {
        store = new Store();
        Product first = new Product("Bread", 1, 1.50);
        Product second = new Product("Beer", 6, 1.60);
        Product third = new Product("Chicken fillet", 2, 5.10);
        store.addProduct(first);
        store.addProduct(second);
        store.addProduct(third);
    }

    @Test
    public void constructorShouldBuildEmptyList() {
        assertNotNull(store.getProducts());
    }

    @Test
    public void testGetCount() {
        assertEquals(3, store.getCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void addProductShouldThrowIfGivenNull() {
        store.addProduct(null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void addProductShouldThrowIfGivenProductWithNegativeQuantity() {
        store.addProduct(new Product("Cake", 0, 6));
    }

    @Test
    public void testAddProduct() {
        store.addProduct(new Product("Cake", 7, 6));
        assertEquals(4, store.getCount());
        assertEquals(6, store.getProducts().get(store.getProducts().size() - 1).getPrice(), 0.1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void buyProductShouldThrowIfGivenWrongProduct() {
        store.buyProduct("Sweets", 1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void buyProductShouldThrowIfGivenBiggerQuantity() {
        store.buyProduct("Bread", 2);
    }

    @Test
    public void testBuyProduct() {
        assertEquals(3.2, store.buyProduct("Beer", 2), 0.001);
        assertEquals(4, store.getProducts().get(1).getQuantity());
    }

    @Test
    public void getMostExpensiveProductShouldReturnNullIfListEmpty() {
        Store store2 = new Store();
        assertNull(store2.getTheMostExpensiveProduct());
    }

    @Test
    public void testGetMostExpensiveProduct() {
        assertEquals("Chicken fillet", store.getTheMostExpensiveProduct().getName());
    }
}