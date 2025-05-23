
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner;

    public Main() {
    }

    public static void addBook() {
        System.out.println("Enter book details (title, author, publisher, year published):");
        String title = scanner.nextLine();
        String author = scanner.nextLine();
        String publisher = scanner.nextLine();
        int yearPublished = scanner.nextInt();
        scanner.nextLine();

        try {
            Connection conn = DBConnection.getConnection();

            try {
                String sql = "INSERT INTO books (title, author, publisher, year_published) VALUES (?, ?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(sql);

                try {
                    stmt.setString(1, title);
                    stmt.setString(2, author);
                    stmt.setString(3, publisher);
                    stmt.setInt(4, yearPublished);
                    stmt.executeUpdate();
                    System.out.println("Book added successfully.");
                } catch (Throwable var11) {
                    if (stmt != null) {
                        try {
                            stmt.close();
                        } catch (Throwable var10) {
                            var11.addSuppressed(var10);
                        }
                    }

                    throw var11;
                }

                if (stmt != null) {
                    stmt.close();
                }
            } catch (Throwable var12) {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (Throwable var9) {
                        var12.addSuppressed(var9);
                    }
                }

                throw var12;
            }

            if (conn != null) {
                conn.close();
            }
        } catch (SQLException var13) {
            SQLException e = var13;
            e.printStackTrace();
        }

    }

    public static void updateBook() {
        System.out.println("Enter book ID to update:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter new details (title, author, publisher, year published):");
        String title = scanner.nextLine();
        String author = scanner.nextLine();
        String publisher = scanner.nextLine();
        int yearPublished = scanner.nextInt();
        scanner.nextLine();

        try {
            Connection conn = DBConnection.getConnection();

            try {
                String sql = "UPDATE books SET title = ?, author = ?, publisher = ?, year_published = ? WHERE id = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);

                try {
                    stmt.setString(1, title);
                    stmt.setString(2, author);
                    stmt.setString(3, publisher);
                    stmt.setInt(4, yearPublished);
                    stmt.setInt(5, id);
                    stmt.executeUpdate();
                    System.out.println("Book updated successfully.");
                } catch (Throwable var12) {
                    if (stmt != null) {
                        try {
                            stmt.close();
                        } catch (Throwable var11) {
                            var12.addSuppressed(var11);
                        }
                    }

                    throw var12;
                }

                if (stmt != null) {
                    stmt.close();
                }
            } catch (Throwable var13) {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (Throwable var10) {
                        var13.addSuppressed(var10);
                    }
                }

                throw var13;
            }

            if (conn != null) {
                conn.close();
            }
        } catch (SQLException var14) {
            SQLException e = var14;
            e.printStackTrace();
        }

    }

    public static void deleteBook() {
        System.out.println("Enter book ID to delete:");
        int id = scanner.nextInt();
        scanner.nextLine();

        try {
            Connection conn = DBConnection.getConnection();

            try {
                String sql = "DELETE FROM books WHERE id = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);

                try {
                    stmt.setInt(1, id);
                    stmt.executeUpdate();
                    System.out.println("Book deleted successfully.");
                } catch (Throwable var8) {
                    if (stmt != null) {
                        try {
                            stmt.close();
                        } catch (Throwable var7) {
                            var8.addSuppressed(var7);
                        }
                    }

                    throw var8;
                }

                if (stmt != null) {
                    stmt.close();
                }
            } catch (Throwable var9) {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (Throwable var6) {
                        var9.addSuppressed(var6);
                    }
                }

                throw var9;
            }

            if (conn != null) {
                conn.close();
            }
        } catch (SQLException var10) {
            SQLException e = var10;
            e.printStackTrace();
        }

    }

    public static void searchBook() {
        System.out.println("Enter search criteria (title, author, or year published):");
        String criteria = scanner.nextLine();

        try {
            Connection conn = DBConnection.getConnection();

            try {
                String sql = "SELECT * FROM books WHERE title LIKE ? OR author LIKE ? OR year_published LIKE ?";
                PreparedStatement stmt = conn.prepareStatement(sql);

                try {
                    String likeCriteria = "%" + criteria + "%";
                    stmt.setString(1, likeCriteria);
                    stmt.setString(2, likeCriteria);
                    stmt.setString(3, likeCriteria);
                    ResultSet rs = stmt.executeQuery();

                    try {
                        while(rs.next()) {
                            System.out.printf("ID: %d, Title: %s, Author: %s, Publisher: %s, Year Published: %d%n", rs.getInt("id"), rs.getString("title"), rs.getString("author"), rs.getString("publisher"), rs.getInt("year_published"));
                        }
                    } catch (Throwable var11) {
                        if (rs != null) {
                            try {
                                rs.close();
                            } catch (Throwable var10) {
                                var11.addSuppressed(var10);
                            }
                        }

                        throw var11;
                    }

                    if (rs != null) {
                        rs.close();
                    }
                } catch (Throwable var12) {
                    if (stmt != null) {
                        try {
                            stmt.close();
                        } catch (Throwable var9) {
                            var12.addSuppressed(var9);
                        }
                    }

                    throw var12;
                }

                if (stmt != null) {
                    stmt.close();
                }
            } catch (Throwable var13) {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (Throwable var8) {
                        var13.addSuppressed(var8);
                    }
                }

                throw var13;
            }

            if (conn != null) {
                conn.close();
            }
        } catch (SQLException var14) {
            SQLException e = var14;
            e.printStackTrace();
        }

    }

    public static void addMember() {
        System.out.println("Enter member details (name, email, phone):");
        String name = scanner.nextLine();
        String email = scanner.nextLine();
        String phone = scanner.nextLine();

        try {
            Connection conn = DBConnection.getConnection();

            try {
                String sql = "INSERT INTO members (name, email, phone) VALUES (?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(sql);

                try {
                    stmt.setString(1, name);
                    stmt.setString(2, email);
                    stmt.setString(3, phone);
                    stmt.executeUpdate();
                    System.out.println("Member added successfully.");
                } catch (Throwable var10) {
                    if (stmt != null) {
                        try {
                            stmt.close();
                        } catch (Throwable var9) {
                            var10.addSuppressed(var9);
                        }
                    }

                    throw var10;
                }

                if (stmt != null) {
                    stmt.close();
                }
            } catch (Throwable var11) {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (Throwable var8) {
                        var11.addSuppressed(var8);
                    }
                }

                throw var11;
            }

            if (conn != null) {
                conn.close();
            }
        } catch (SQLException var12) {
            SQLException e = var12;
            e.printStackTrace();
        }

    }

    public static void loanBook() {
        System.out.println("Enter loan details (book ID, member ID, loan date (YYYY-MM-DD), due date (YYYY-MM-DD)):");
        int bookId = scanner.nextInt();
        int memberId = scanner.nextInt();
        String loanDate = scanner.next();
        String dueDate = scanner.next();
        scanner.nextLine();

        try {
            Connection conn = DBConnection.getConnection();

            try {
                String sql = "INSERT INTO loans (book_id, member_id, loan_date, due_date) VALUES (?, ?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(sql);

                try {
                    stmt.setInt(1, bookId);
                    stmt.setInt(2, memberId);
                    stmt.setDate(3, Date.valueOf(loanDate));
                    stmt.setDate(4, Date.valueOf(dueDate));
                    stmt.executeUpdate();
                    System.out.println("Book loaned successfully.");
                } catch (Throwable var11) {
                    if (stmt != null) {
                        try {
                            stmt.close();
                        } catch (Throwable var10) {
                            var11.addSuppressed(var10);
                        }
                    }

                    throw var11;
                }

                if (stmt != null) {
                    stmt.close();
                }
            } catch (Throwable var12) {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (Throwable var9) {
                        var12.addSuppressed(var9);
                    }
                }

                throw var12;
            }

            if (conn != null) {
                conn.close();
            }
        } catch (SQLException var13) {
            SQLException e = var13;
            e.printStackTrace();
        }

    }

    public static void returnBook() {
        System.out.println("Enter return details (loan ID, return date (YYYY-MM-DD)):");
        int loanId = scanner.nextInt();
        String returnDate = scanner.next();
        scanner.nextLine();

        try {
            Connection conn = DBConnection.getConnection();

            try {
                String sql = "UPDATE loans SET return_date = ? WHERE id = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);

                try {
                    stmt.setDate(1, Date.valueOf(returnDate));
                    stmt.setInt(2, loanId);
                    stmt.executeUpdate();
                    System.out.println("Book returned successfully.");
                } catch (Throwable var9) {
                    if (stmt != null) {
                        try {
                            stmt.close();
                        } catch (Throwable var8) {
                            var9.addSuppressed(var8);
                        }
                    }

                    throw var9;
                }

                if (stmt != null) {
                    stmt.close();
                }
            } catch (Throwable var10) {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (Throwable var7) {
                        var10.addSuppressed(var7);
                    }
                }

                throw var10;
            }

            if (conn != null) {
                conn.close();
            }
        } catch (SQLException var11) {
            SQLException e = var11;
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        while(true) {
            System.out.println("Library Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Update Book");
            System.out.println("3. Delete Book");
            System.out.println("4. Search Book");
            System.out.println("5. Add Member");
            System.out.println("6. Loan Book");
            System.out.println("7. Return Book");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    updateBook();
                    break;
                case 3:
                    deleteBook();
                    break;
                case 4:
                    searchBook();
                    break;
                case 5:
                    addMember();
                    break;
                case 6:
                    loanBook();
                    break;
                case 7:
                    returnBook();
                    break;
                case 8:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    static {
        scanner = new Scanner(System.in);
    }
}
