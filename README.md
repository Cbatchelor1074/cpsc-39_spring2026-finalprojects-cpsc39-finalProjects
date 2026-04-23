# cpsc39-finalProjects

Upload your final project to this github repo.

Make a README file for your project and put the infor about your project in it - your name, date and what your program does.

# Chase Batchelor
# April 22, 2026
# CPSC-39
# This program is a restaurant ordering system which handles orders, and feedback.

This project is a console-based restaurant ordering system which allows users to browse a menu, add and modify items in an order, and receive a final receipt with total cost and estimated preparation time. The project demonstrates core data structures and algorithms including linked lists, hash maps, and array lists.

# Features
Order System:
    - Add items to an order
    - Remove items from an order
    - Edit item quantities
    - View current order
    - Generate final receipt

Menu System:
    - Menu stored using a HashMap
    - Fast O(1) lookup for items
    - Predefined menu items

Order Processing
    - Custom linked list implementation for order storage
    - Calculates:
        - Total cost
        - Estimated preparation time

Order History:
    - Stores completed orders in an ArrayList
    - Displays past orders with totals and prep times

Feedback System: 
    - Collects rating (1-5)
    - Calculates:
        - Total number of reviews
        - Average rating

Data Structures Used:
    - HashMap: Menu storage and fast item lookup
    - Linked List: Order item storage
    - ArrayList: Order history and feedback storage

Algorithms Used
    - Linked list traversal: O(n)
    - Item Insertion: O(n)
    - Item Removal: O(n)
    - HashMap looku: O(1)
    - Feedback averaging: O(n)

Project Structure
    Main.java - Handles user interaction and program flow
    Order.java - Manages order logic and history
    OrderLinkedList.jav - Custom lined list implementation
    Node.java - Node structure for linked list
    MenuItem.java - Data model for menu items
    Receipt.java - Formats and displays final order summary
    FeedbackManager.java - Handles rating storage and statistics