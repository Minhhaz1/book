package bookstore.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import bookstore.dto.UserDto;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private String phone;
    private String password;
    private String address;
    private String landmark;
    private String city;
    private String state;
    private String pincode;
    private String role = "ROLE_USER";
    @ManyToMany(targetEntity = Book.class, cascade = CascadeType.ALL)
    @JoinTable(name = "cart")
    private List<Book> books;
    public void addToCart(Book book){
        books.add(book);
    }
    public double totalCart(){
        double total = 0;
        for(Book book: books){
            total+= book.getPrice();
        }
        return total;
    }
    public User(UserDto userDto) {
        this.name = userDto.getName();
        this.email = userDto.getEmail();
        this.phone = userDto.getPhone();
        this.password = userDto.getPassword();
        this.books = userDto.getCart();
    }

    public void removeFromCart(Book book) {
        books.remove(book);
    }
}
