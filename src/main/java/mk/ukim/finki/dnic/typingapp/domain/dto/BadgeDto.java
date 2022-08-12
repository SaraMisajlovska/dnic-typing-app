package mk.ukim.finki.dnic.typingapp.domain.dto;

import lombok.Data;
import mk.ukim.finki.dnic.typingapp.domain.identity.User;

import java.util.List;

@Data
public class BadgeDto {

    private String badgeName;

    private String imageUrl;

    private String description;

    private List<User> users;

    public BadgeDto(String badgeName, String imageUrl, String description, List<User> users) {
        this.badgeName = badgeName;
        this.imageUrl = imageUrl;
        this.description = description;
        this.users = users;
    }
}
