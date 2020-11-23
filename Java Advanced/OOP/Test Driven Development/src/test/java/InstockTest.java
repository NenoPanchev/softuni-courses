import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class InstockTest {
    private Instock instock;

    @Before
    public void setup() {
        Product first = new Product("First", 1.5, 4);
        Product second = new Product("Second", 4.5, 2);
        Product third = new Product("Third", 1.5, 3);
        Product fourth = new Product("Fourth", 2.5, 4);
        instock = new Instock();
        instock.add(first);
        instock.add(second);
        instock.add(third);
        instock.add(fourth);
    }

    @Test
    public void constructorShouldCreateNewArrayList() {
        Instock instock = new Instock();
        List<Product> products = new ArrayList<>();
        assertEquals(products.size(), instock.getCount());
    }

    @Test
    public void addShouldAddANewProduct() {
        Product product = new Product("Fifth", 1., 1);
        instock.add(product);
        assertEquals(product, instock.getIterable().get(4));
    }

    @Test
    public void addShouldNotAddIfNewProductsLabelIsContained() {
        Product product = new Product("First", 4.5, 4);
        instock.add(product);
        assertEquals(instock.getIterable().get(3), instock.getIterable().get(instock.getIterable().size() - 1));
    }

    @Test
    public void containsShouldReturnTrueIfLabelContained() {
        Product product = new Product("First", 4.5, 4);
        assertTrue(instock.contains(product));
    }

    @Test
    public void containsShouldReturnFalseIfNewProductHasNewLabel() {
        Product product = new Product("Fifth", 1., 1);
        assertFalse(instock.contains(product));
    }

    @Test
    public void countShouldReturnCorrectSize() {
        assertEquals(4, instock.getCount());
    }

    @Test
    public void findShouldReturnNthProduct() {
        Product product = instock.find(4);
        assertEquals(instock.getIterable().get(3), product);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void findShouldThrowIfGivenBiggerIndex() {
        instock.find(5);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void findShouldThrowIfGivenZeroOrNegativeIndex() {
        instock.find(0);
    }

    @Test
    public void testChangeQuantityOfGivenProductByLabel() {
        instock.changeQuantity("First", 11);
        assertEquals(11, instock.getIterable().get(0).getQuantity());
    }

    @Test (expected = IllegalArgumentException.class)
    public void changeQuantityShouldThrowIfProductNotContained() {
        instock.changeQuantity("Alice", 50);
    }

    @Test
    public void findByLabelShouldReturnProductByLabel() {
        assertEquals(instock.getIterable().get(0), instock.findByLabel("First"));
    }

    @Test (expected = IllegalArgumentException.class)
    public void findByLabelShouldThrowIfProductNotFound() {
        instock.findByLabel("Alice");
    }

    @Test
    public void findFirstByAlphabeticalOrderReturnsListOfTheFirstNProducts() {
        List<Product> expected = new ArrayList<>();
        expected.add(instock.getIterable().get(0));
        expected.add(instock.getIterable().get(3));
        List<Product> actual = (List<Product>) instock.findFirstByAlphabeticalOrder(2);

        assertEquals(expected.get(0), actual.get(0));
        assertEquals(expected.get(1), actual.get(1));
    }

    @Test
    public void findFirstByAlphabeticalOrderShouldReturnEmptyListIfGivenNumberOutOfBounds() {
        List<Product> expected = new ArrayList<>();
        List<Product> actual = (List<Product>) instock.findFirstByAlphabeticalOrder(5);
        assertEquals(expected.size(), actual.size());
    }

    @Test
    public void findAllInPriceRangeShouldReturnListInDescendingOrder() {
        List<Product> expected = new ArrayList<>();
        expected.add(instock.getIterable().get(3));
        expected.add(instock.getIterable().get(1));
        List<Product> actual = (List<Product>) instock.findAllInRange(1.5, 4.5);
        assertEquals(expected.get(0), actual.get(0));
        assertEquals(expected.get(1), actual.get(1));
    }

    @Test
    public void findAllInPriceRangeShouldReturnEmptyCollectionIfNoProductsInRange() {
        List<Product> expected = new ArrayList<>();
        List<Product> actual = (List<Product>) instock.findAllInRange(0, 1.4);
        assertEquals(expected.size(), actual.size());
    }

    @Test
    public void testFindAllByPrice() {
        List<Product> expected = new ArrayList<>();
        expected.add(instock.getIterable().get(0));
        expected.add(instock.getIterable().get(2));
        List<Product> actual = (List<Product>) instock.findAllByPrice(1.5);
        assertEquals(expected.get(0), actual.get(0));
        assertEquals(expected.get(1), actual.get(1));
    }

    @Test
    public void findAllByPriceRangeShouldReturnEmptyCollectionIfNoProductsFound() {
        List<Product> expected = new ArrayList<>();
        List<Product> actual = (List<Product>) instock.findAllByPrice(2.8);
        assertEquals(expected.size(), actual.size());
    }

    @Test
    public void findFirstMostExpensiveProductsReturnsListOfNProducts() {
        List<Product> expected = new ArrayList<>();
        expected.add(instock.getIterable().get(1));
        expected.add(instock.getIterable().get(3));
        expected.add(instock.getIterable().get(0));
        List<Product> actual = (List<Product>) instock.findFirstMostExpensiveProducts(3);

        assertEquals(expected.get(0), actual.get(0));
        assertEquals(expected.get(1), actual.get(1));
        assertEquals(expected.get(2), actual.get(2));
    }

    @Test (expected = IllegalArgumentException.class)
    public void findFirstMostExpensiveProductsShouldThrowIfGivenNumberOutOfBounds() {
        instock.findFirstMostExpensiveProducts(5);
    }

    @Test
    public void testFindAllByQuantity() {
        List<Product> expected = new ArrayList<>();
        expected.add(instock.getIterable().get(0));
        expected.add(instock.getIterable().get(3));
        List<Product> actual = (List<Product>) instock.findAllByQuantity(4);
        assertEquals(expected.get(0), actual.get(0));
        assertEquals(expected.get(1), actual.get(1));
    }

    @Test
    public void findAllByQuantityShouldReturnEmptyCollectionIfNoProductsFound() {
        List<Product> expected = new ArrayList<>();
        List<Product> actual = (List<Product>) instock.findAllByPrice(8);
        assertEquals(expected.size(), actual.size());
    }

    @Test
    public void getIterableShouldReturnTheCollection() {
        List<Product> actual = instock.getIterable();

        assertEquals("First", actual.get(0).getLabel());
        assertEquals("Second", actual.get(1).getLabel());
        assertEquals("Third", actual.get(2).getLabel());
        assertEquals("Fourth", actual.get(3).getLabel());
    }
}
