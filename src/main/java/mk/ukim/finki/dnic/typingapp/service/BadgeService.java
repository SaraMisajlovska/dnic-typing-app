package mk.ukim.finki.dnic.typingapp.service;


import mk.ukim.finki.dnic.typingapp.domain.dto.BadgeDto;
import mk.ukim.finki.dnic.typingapp.domain.models.Badge;

import java.util.List;
import java.util.Optional;

public interface BadgeService {

    List<Badge> listBadges();

    Optional<Badge> save(BadgeDto badgeDto);

}
