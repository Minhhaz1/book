package bookstore.dto;


import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import bookstore.entity.Book;
import bookstore.entity.User;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
//    @NotBlank(message = "Your name is required")
    private String name;
//    @Email(message = "Please enter true email! ")
    private String email;
//    @Digits(integer = 10, fraction = 0, message = "Invalid Phone Number")
    private String phone;
//    @NotBlank(message = "Your password is required")
    private String password;
    private List<Book> cart;

    public UserDto(User  user){
        this.name = user.getName();
        this.email = user.getEmail();
        this.phone = user.getPhone();
        this.password = user.getPassword();
        this.cart = user.getBooks();
    }

}
