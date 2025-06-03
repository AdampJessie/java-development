-- Question 1
-- SELECT * FROM northwind.products;

-- Question 2
-- SELECT productID, productName, unitPrice
-- FROM northwind.products;

-- Question 3
-- SELECT productID, productName, unitPrice
-- FROM northwind.products
-- ORDER BY UnitPrice;

-- Question 4
-- SELECT productID, productName, unitPrice
-- FROM northwind.products
-- WHERE unitPrice <= 7.50
-- ORDER BY UnitPrice;

-- Question 5
-- SELECT productID, productName, unitPrice
-- FROM northwind.products
-- WHERE UnitsInStock >= 100
-- ORDER BY UnitPrice DESC;

-- Question 6
-- SELECT productID, productName, unitPrice
-- FROM northwind.products
-- WHERE UnitsInStock >= 100
-- ORDER BY UnitPrice DESC, productName;

-- Question 7
-- SELECT *
-- FROM northwind.products
-- WHERE UnitsInStock = 0 AND UnitsOnOrder >= 1
-- ORDER BY productName;

-- Question 8
-- SELECT * FROM northwind.categories;

-- Question 9
-- SELECT * FROM northwind.categories
-- WHERE CategoryName = "Seafood"; CategoryID: 8

-- Question 10
SELECT * FROM northwind.products
WHERE CategoryID = 8;


-- Question 11
SELECT firstName, lastName 
FROM northwind.employees;


-- Question 12

