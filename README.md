Here you go:

---

# 📚 Library Management System

A desktop-based Library Management System developed using Java Swing. The main purpose of this project is to provide librarians and members with a complete book management interface where they can manage the catalog, borrow and return books, track overdue fines, and communicate through an in-app messaging system.

The application includes user authentication, ISBN-based book tracking, automatic fine calculation, reservation queues, and an admin panel designed with Java Swing.

## Project Description

Library Management System is a Java desktop application that allows users to register, log in securely, and interact with a fully functional library system. The system keeps track of borrowed books, due dates, overdue fines, and reservation queues.

The project was developed to explore Java GUI development, file handling, object-oriented programming concepts, user authentication systems, and real-world library operations within a desktop environment.

---

## Features

- User registration system
- User login system
- ISBN-based book catalog
- Borrow and return books
- Book reservation queue
- Automatic overdue fine calculation (BDT 5.00/day)
- Fine payment tracking
- Loan renewal system
- In-app messaging and notifications
- Admin reminders panel
- Library reports and statistics
- Configurable settings (loan period, fine rate, borrow limit)
- Borrowing history per user
- File-based data storage

---

## Technologies Used

**Programming Language**
Java

**GUI Framework**
Java Swing

**Additional Technologies**
- Java File I/O
- Java Object Serialization
- SHA-256 Password Hashing
- Object-Oriented Programming (OOP)

---

## Installation

**Prerequisites**

Before running the project, make sure the following software is installed:

- Java JDK 8 or later

**Clone the Repository**

```bash
git clone https://github.com/Divya-Jyoti-Dev/Library-Management-System-GUI-.git
cd Library-Management-System-GUI-
```

**Compile the Project**

```bash
javac *.java
```

**Run the Application**

```bash
java LibraryManagementSystem
```

---

## Configuration

On the very first launch, the application will prompt you to create an **admin account**. After that, the catalog is automatically seeded from `books.csv` (30 preloaded books).

Admin can change these settings at runtime from the Settings panel — no restart required:

| Setting | Default |
|---|---|
| Loan Period | 14 days |
| Fine Per Day | BDT 5.00 |
| Borrow Limit | 3 books |

---

## Usage

**Step 1: Admin Setup**
On first launch, create an admin account with your email and password.

**Step 2: Login**
Log in using your registered credentials.

**Step 3: Browse Catalog**
Search for books by title, author, or filter by category.

**Step 4: Borrow a Book**
Select an available book and issue it to your account.

**Step 5: Reserve a Book**
If a book is unavailable, join the reservation queue and receive an in-app notification when it becomes available.

**Step 6: Return and Pay Fines**
Return books from your account panel. If overdue, the fine is calculated automatically and can be paid from the same panel.

---

## Project Structure

```
Library Management System
├── LibraryManagementSystem.java   # Entry point — loads data, launches UI
├── Library.java                   # Core library logic (add, issue, return, search, reserve)
├── Book.java                      # Book entity with copy tracking and reservation queue
├── User.java                      # User entity with issued books, fines, inbox, history
├── LibraryConfig.java             # Global config (loan days, fine rate, borrow limit)
├── AuthFrame.java                 # Login / registration / first-run admin setup screen
├── MainFrame.java                 # Main application window with navigation tabs
├── DashboardPanel.java            # Overview stats for the logged-in user
├── BookTableModel.java            # Table model for the book catalog view
├── BookDialog.java                # Add / edit book dialog
├── MyAccountPanel.java            # Member's borrowed books, history, and fines
├── MessagesPanel.java             # In-app inbox for members
├── AdminRemindersPanel.java       # Admin panel: send overdue/manual reminders
├── ReportsPanel.java              # Admin panel: library statistics
├── SettingsPanel.java             # Admin panel: configure loan period, fine, limits
├── ReminderHelper.java            # Logic for scheduling and sending reminders
├── Message.java                   # Message entity for the inbox system
├── TransactionToast.java          # Toast notification component
├── UITheme.java                   # Shared colors, fonts, and UI component builders
└── books.csv                      # Seed data — 30 books loaded on first launch
```

---

## Main Components

**Login System**
Handles user authentication and validates login credentials using SHA-256 password hashing.

**Registration System**
Allows new users to create a member account.

**Library Module**
Manages the book catalog — add, edit, remove, search, issue, return, and reserve books by ISBN.

**Fine Calculator**
Automatically calculates overdue fines based on the number of overdue days multiplied by the configured daily rate.

**Reservation Queue**
Tracks who is waiting for an unavailable book and notifies the first person in line when a copy is returned.

**Admin Panel**
Provides access to reminders, reports, user management, and system configuration.

---

## How Overdue Fines Work

Fines are calculated automatically each time a user's account is accessed:

```
Fine = Overdue Days × Fine Per Day Rate
```

Example: A book due on June 1, checked on June 6 = 5 days × BDT 5.00 = **BDT 25.00**

The system tracks partial payments so only the remaining unpaid balance is shown.

---

## Security Features

Current implementation includes:

- SHA-256 password hashing
- User authentication
- Input validation
- Session management

Possible future security improvements:

- Database storage
- Email verification
- Password recovery system
- Data encryption

---

## Future Improvements

Some planned enhancements include:

- MySQL database integration
- Email notifications for overdue reminders
- Forgot password feature
- User profile management
- Dark and light themes
- Export borrowing history to PDF
- Multi-language support
- Barcode scanner integration
- Cloud synchronization

---

## Screenshots

**[Login Window]**

![Login Screen](https://github.com/Divya-Jyoti-Dev/Library-Management-System-GUI-/blob/d4dabac7d4612be4e25ca4dd80995fa0bed745b7/Screenshot%202026-06-05%20120417.png)

**[Book Catalog Admin]**

![Catalog View](https://github.com/Divya-Jyoti-Dev/Library-Management-System-GUI-/blob/9213559eee4deef82146aef6fa1f389193fd16bc/Screenshot%202026-06-05%20120759.png)

**[Book Catalog Member]**

![Catalog View](https://github.com/Divya-Jyoti-Dev/Library-Management-System-GUI-/blob/9213559eee4deef82146aef6fa1f389193fd16bc/Screenshot%202026-06-05%20121008.png)

**[My Account Panel]**

![Account Panel](https://github.com/Divya-Jyoti-Dev/Library-Management-System-GUI-/blob/9213559eee4deef82146aef6fa1f389193fd16bc/Screenshot%202026-06-05%20121041.png)

---

## Contributing

Contributions are welcome.

To contribute:

1. Fork the repository
2. Create a new branch
3. Make your changes
4. Commit your changes
5. Push the branch
6. Submit a pull request

---

## License

This project is created for educational and learning purposes.

---

## Author

**[Divya Jyoti Dev]**

Computer Science and Engineering Student

GitHub: https://github.com/Divya-Jyoti-Dev

---

## Conclusion

This project helped improve understanding of Java Swing development, object-oriented programming, user authentication systems, file handling, and real-world library management operations. It serves as a practical example of building a fully functional desktop application with role-based access, automated business logic, and persistent data storage.
