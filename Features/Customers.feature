Feature: Customers

Background: Steps for all common scenarios 
Given User Launch Chrome browser
When  User opens URL "https://admin-demo.nopcommerce.com/login"
And   User Enter Email as "admin@yourstore.com" and password as "admin"
And   Click on Login
Then  User can view Dashboard

@sanity
Scenario: Add new Customer
When User click on customers Menu
And  Click on customers Menu Item
And  Click on Add new button
Then User can view add new customers page
When User enter customer info
And  Click on saave button
Then User can view confirmation meassage "The new customer has been added successfully"
And  close browser

@sanity
Scenario: Search customer by email
When  User click on customers Menu
And  Click on customers Menu Item
And Enter Customer email
When Click on search button
Then User should found email in search table
And  close browser

@sanity
Scenario: Search customer by Name
When  User click on customers Menu
And  Click on customers Menu Item
And Enter Customer Firstname
And Enter Customer Lastname
When Click on search button
Then User should found name in search table
And  close browser
