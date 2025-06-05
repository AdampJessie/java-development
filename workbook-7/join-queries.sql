-- Question 1
SELECT ProductID, ProductName, UnitPrice, CategoryName
FROM northwind.products p
JOIN northwind.categories c
ON p.CategoryID = c.CategoryID
ORDER BY CategoryName, ProductName;

-- Question 2
-- SELECT ProductID, ProductName, UnitPrice, CompanyName
-- FROM northwind.products p
-- JOIN northwind.suppliers s
-- ON p.SupplierID = s.SupplierID
-- WHERE UnitPrice > 75
-- ORDER BY ProductName

-- Question 3
-- SELECT ProductID, ProductName, UnitPrice, CategoryName, CompanyName
-- FROM northwind.products p
-- JOIN northwind.categories c
-- ON p.CategoryID = c.CategoryID
-- JOIN northwind.suppliers s
-- ON p.SupplierID = s.SupplierID
-- ORDER BY ProductName;

-- Question 4
-- SELECT ProductName, CategoryName
-- FROM northwind.products p
-- JOIN northwind.categories c
-- ON p.CategoryID = c.CategoryID
-- WHERE p.UnitPrice = (SELECT MAX(UnitPrice) FROM northwind.products)
-- ORDER BY ProductName;

-- Question 5
-- SELECT OrderID, ShipName, ShipAddress, CompanyName
-- FROM northwind.orders o
-- JOIN northwind.shippers s ON o.ShipVia = s.ShipperID
-- WHERE ShipCountry = "Germany";

-- Question 6