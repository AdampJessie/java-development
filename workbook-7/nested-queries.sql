-- Question 1
-- SELECT ProductName, UnitPrice
-- FROM northwind.products
-- WHERE UnitPrice = (SELECT MAX(UnitPrice))

-- Question 2
-- SELECT OrderID, ShipName, ShipAddress
-- FROM northwind.orders
-- WHERE ShipVia = (SELECT ShipperID FROM northwind.shippers WHERE CompanyName LIKE "Federal Shipping")

-- Question 3
-- SELECT OrderID
-- FROM northwind.`order details`
-- WHERE ProductID = (SELECT ProductID FROM northwind.products WHERE ProductName LIKE "Sasquatch Ale")

-- Question 4
-- SELECT FirstName, LastName
-- FROM northwind.employees
-- WHERE EmployeeID = (SELECT EmployeeID FROM northwind.orders WHERE orderID = 10266)

-- Question 5
-- SELECT ContactName
-- FROM northwind.customers
-- WHERE CustomerID = (SELECT CustomerID FROM northwind.orders WHERE orderID = 10266)