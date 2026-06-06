# 📚 Library System (Java)

A console-based Library Management System built in Java using HashMap for data storage.
Developed as part of the Programming 1 course at University of the People.

## 📋 Features

- Add books with title and author
- Borrow books (tracks quantity)
- Return books
- Console-based interface — runs directly in the terminal

## 🛠️ Technologies Used

- Java (JDK 17+)
- HashMap for in-memory data storage
- Console I/O (Scanner class)

## 🚀 How to Run

1. Make sure you have Java installed on your computer
2. Clone this repository:

## 📸 Sample Output

``
========================================
       Welcome to the Library System    
========================================
--- Library Menu ---
1. Add Books
2. Borrow Books
3. Return Books
4. Exit
Enter your choice: 1
--- Add Books ---
Enter book title: Introduction to programming
Enter author name: David J.Eck
Enter quantity: 6
[SUCCESS] Added "Introduction to programming" by David J.Eck ? Quantity: 6

--- Library Menu ---
1. Add Books
2. Borrow Books
3. Return Books
4. Exit
Enter your choice: 2
--- Borrow Books ---
Enter book title: Introduction to programming
Enter number of books to borrow: 2
[SUCCESS] You borrowed 2 copy/copies of "Introduction to programming". Remaining: 4

--- Library Menu ---
1. Add Books
2. Borrow Books
3. Return Books
4. Exit
Enter your choice: 3
--- Return Books ---
Enter book title: Introduction to programming
Enter number of books to return: 1
[SUCCESS] Returned 1 copy/copies of "Introduction to programming". New quantity: 5

--- Library Menu ---
1. Add Books
2. Borrow Books
3. Return Books
4. Exit
Enter your choice: 4
Thank you for using the Library System. Goodbye!

## 💡 What I Learned

- Using HashMap to store and retrieve data efficiently
- Object-oriented programming concepts in Java
- Building menu-driven console applications
- Handling user input with the Scanner class

## 👤 Author

**Innocent Kileo**  
Computer Science Student — University of the People  
GitHub: [SWE-Kileo](https://github.com/SWE-Kileo)

## 📄 License

This project is licensed under the MIT License.
```
