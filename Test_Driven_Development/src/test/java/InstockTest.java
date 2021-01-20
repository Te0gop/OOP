import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class InstockTest {

    private ProductStock stock;
    private Product testProduct;
    private Product[] products;

    @Before
    public void setUp() {
        stock = new Instock();
        testProduct = new Product("Sugar", 15.5, 1);
    }

    @Test
    public void testAddShouldSaveProduct() {
        stock.add(testProduct);
        assertTrue(stock.contains(testProduct));
    }
    @Test
    public void testContainsReturnsTrueForPreviouslyAddedProduct() {
        assertFalse(stock.contains((testProduct)));
        stock.add(testProduct);
        assertTrue(stock.contains((testProduct)));
    }
    @Test
    public void testCountShouldReturnOneForSingleProduct() {
        stock.add(testProduct);
        assertEquals(1, stock.getCount());
    }
    @Test
    public void testCountShouldReturnTenForTenProduct() {
        addProductsToStock(10);
        assertEquals(10, stock.getCount());
    }
    @Test
    public void testCountShouldReturnZeroWhenIsEmpty() {
        assertEquals(0, stock.getCount());
    }

    // This test will work only if we add remove operation
    @Ignore
    @Test
    public void testCountShouldReturnFiveWhenWeFirstAddTenThenRemoveFiveProducts() {
        addProductsToStock(10);
        // TODO: add remove of five products here
        assertEquals(5, stock.getCount());
    }
    @Test
    public void testFindByIndexShouldReturnCorrectElementWhenOnlyOne() {
        stock.add(testProduct);
        assertProductsAreEqual(testProduct, stock.find(0));
    }
    @Test
    public void testFindByIndexShouldReturnCorrectElementWhenTenThenProductsAreAdded() {
        addProductsToStock(10);
        assertProductsAreEqual(products[products.length - 1], stock.find(products.length - 1));
    }
    @Test
    public void testFindByIndexShouldReturnCorrectProductWhenOnlyThenProductsAreAddedAndWeTakeProductInTheMiddle() {
        addProductsToStock(10);
        assertProductsAreEqual(products[(products.length - 1) / 2], stock.find((products.length - 1) / 2));
    }
    @Test
    public void testFindByIndexShouldReturnCorrectProductWhenAllIndexesAreFetched() {
        addProductsToStock(10);
        for (int i = 0; i < 10; i++) {
            assertProductsAreEqual(products[i], stock.find(i));
        }
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindByIndexWhenEmpty() {
        stock.find(0);
    }
    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindByNegativeIndex() {
        stock.find(-1);
    }
    @Test
    public void testChangeQuantityShouldSetNewValue() {
        int newQuantity = testProduct.getQuantity() + 10;
        stock.add(testProduct);
        stock.changeQuantity(testProduct.getLabel(), newQuantity);
        assertEquals(newQuantity, testProduct.getQuantity());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testChangeQuantityWithEmptyStock() {
        stock.changeQuantity(testProduct.getLabel(), 100);
    }
    @Test
    public void testFindByLabelShouldReturnSameProduct() {
        stock.add(testProduct);
        Product actual = stock.findByLabel(testProduct.getLabel());
        assertProductsAreEqual(testProduct, actual);

    }
    @Test(expected = IllegalArgumentException.class)
    public void testFindByLabelShouldFailWithFakeLabel() {
        addProductsToStock(10);
        stock.findByLabel("None-existing label");
    }
    @Test
    public void testFirstByAlphabeticalOrderShouldReturnCorrectElements() {
        addProductsToStock(10);

        List<Product> expected = Arrays.stream(products)
                .sorted(Comparator.comparing(Product::getLabel))
                .limit(5)
                .collect(Collectors.toList());

        Iterable<Product> iterable = stock.findFirstByAlphabeticalOrder(expected.size());
        assertNotNull(iterable);

        List<Product> actual = new ArrayList<>();
        iterable.forEach(actual::add);

        assertEquals(expected.size(), actual.size());

        for (int i = 0; i < expected.size(); i++) {
            assertProductsAreEqual(expected.get(i), actual.get(i));
        }

    }
    @Test
    public void testFirstByAlphabeticalOrderShouldReturnEmptyListWhenCountIsGreaterThanProducts() {
        addProductsToStock(10);
        Iterable<Product> iterable = stock.findFirstByAlphabeticalOrder(11);
        assertNotNull(iterable);

        AtomicInteger counter = new AtomicInteger();

        iterable.forEach(p -> counter.incrementAndGet());
        assertEquals(0, counter.get());
    }
    @Test
    public void testFindAllPriceRangeShouldReturnCorrectPriceRange() {
        addProductsToStock(10);
        Iterable<Product> iterable = stock.findAllInRange(13, 17);
        assertNotNull(iterable);

        List<Product> actual = new ArrayList<>();
        iterable.forEach(actual::add);

        assertEquals(4, actual.size());
        assertTrue(actual.stream().noneMatch(p -> p.getPrice() <= 13 || p.getPrice() > 17));
    }
    @Test
    public void testFindAllPriceRangeShouldReturnCorrectPriceRangeAndOrderedDescending() {
        addProductsToStock(10);
        Iterable<Product> iterable = stock.findAllInRange(13, 17);
        assertNotNull(iterable);

        List<Product> expected = Arrays.stream(products)
                .filter(p -> p.getPrice() > 13 && p.getPrice() <= 17)
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .collect(Collectors.toList());
        List<Product> actual = new ArrayList<>();
        iterable.forEach(actual::add);

        assertEquals(expected.size(), actual.size());

        for (int i = 0; i < expected.size(); i++) {
            assertProductsAreEqual(expected.get(i), actual.get(i));
        }
    }
    @Test
    public void testFindAllPriceRangeShouldReturnEmprtyCollectionWhenNoProductsInRange() {
        addProductsToStock(10);
        Iterable<Product> iterable = stock.findAllInRange(19, 100);

        assertNotNull(iterable);

        List<Product> actual = new ArrayList<>();
        iterable.forEach(actual::add);

        assertTrue(actual.isEmpty());
    }




    private void assertProductsAreEqual(Product expected, Product actual) {
        assertEquals(expected.getLabel(), actual.getLabel());
        assertEquals(expected.getPrice(), actual.getPrice(), 0.00);
        assertEquals(expected.getQuantity(), actual.getQuantity());
    }


    private void addProductsToStock(int count) {
        products = new Product[count];
        for (int i = 0; i < count; i++) {
            products[i] = new Product("" + i, i + 10, i);
            stock.add(products[i]);
        }
    }



}