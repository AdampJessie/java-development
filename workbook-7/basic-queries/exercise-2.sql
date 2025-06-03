-- Question 1
SELECT * FROM northwind.products;

-- Question 2
SELECT productID, productName, unitPrice
FROM northwind.products;

-- Question 3
SELECT productID, productName, unitPrice
FROM northwind.products
ORDER BY UnitPrice;

-- Question 4
SELECT productID, productName, unitPrice
FROM northwind.products
WHERE unitPrice <= 7.50
ORDER BY UnitPrice;

-- Question 5
