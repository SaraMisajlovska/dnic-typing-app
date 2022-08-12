package mk.ukim.finki.dnic.typingapp.service.implementation;

import lombok.RequiredArgsConstructor;
import mk.ukim.finki.dnic.typingapp.domain.dto.BadgeDto;
import mk.ukim.finki.dnic.typingapp.domain.models.Badge;
import mk.ukim.finki.dnic.typingapp.repository.BadgeRepository;
import mk.ukim.finki.dnic.typingapp.service.BadgeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BadgeServiceImpl implements BadgeService {

    private final BadgeRepository badgeRepository;

    @Override
    public List<Badge> listBadges() {
        return badgeRepository.findAll();
    }

    @Override
    public Optional<Badge> save(BadgeDto badgeDto) {
        this.badgeRepository.deleteByBadgeName(badgeDto.getBadgeName());
        return Optional.of(
                this.badgeRepository.save(
                        new Badge(badgeDto.getBadgeName(),
                                badgeDto.getImageUrl(),
                                badgeDto.getDescription(),
                                badgeDto.getUsers())
                ));
    }
}
