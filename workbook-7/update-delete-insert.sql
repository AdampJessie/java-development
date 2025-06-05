-- Question 1
-- INSERT INTO `northwind`.`suppliers`
-- (`CompanyName`,
-- `ContactName`,
-- `ContactTitle`,
-- `Address`,
-- `City`,
-- `Region`,
-- `PostalCode`,
-- `Country`,
-- `Phone`,
-- `Fax`,
-- `HomePage`)
-- VALUES
-- ("Terpoise",
-- "Jeb",
-- "President",
-- "324 Jeffrey Ln",
-- "Englewood",
-- "NA",
-- "45302",
-- "United States",
-- "937-521-2304",
-- "NULL",
-- "NULL");

-- Question 2
-- INSERT INTO `northwind`.`products`
-- (`ProductName`,
-- `SupplierID`,
-- `CategoryID`,
-- `QuantityPerUnit`,
-- `UnitPrice`,
-- `UnitsInStock`,
-- `UnitsOnOrder`,
-- `ReorderLevel`,
-- `Discontinued`)
-- VALUES
-- ("Soo Sauce",
-- 30,
-- 2,
-- 10,
-- 10,
-- 0,
-- 5,
-- 0,
-- 0);

-- Question 2.goof
-- UPDATE northwind.products
-- SET SupplierID = 30
-- WHERE ProductName = 'Soo Sauce';


-- Question 3
-- SELECT ProductID, ProductName, CompanyName
-- FROM northwind.products p
-- LEFT JOIN northwind.suppliers s ON p.SupplierID = s.SupplierID;

-- Question 4
-- UPDATE northwind.products
-- SET UnitPrice = UnitPrice * 1.15
-- WHERE ProductName = 'Soo Sauce';

-- Question 5
-- SELECT ProductName, UnitPrice
-- FROM northwind.products
-- WHERE SupplierID = 30

-- Question 6
DELETE FROM northwind.`products`
WHERE SupplierID = 30;

-- Question 7
DELETE FROM northwind.suppliers
WHERE SupplierID = 30;

-- Question 8
SELECT ProductID, ProductName, CompanyName
FROM northwind.products p
LEFT JOIN northwind.suppliers s ON p.SupplierID = s.SupplierID;
