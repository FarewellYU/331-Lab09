package se331.lab.dao;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import se331.lab.entity.Organizer;

import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("manual")
public class OrganizerDaoImpl implements OrganizerDao {
    List<Organizer> organizers;

    @PostConstruct
    public void init() {
        organizers = new ArrayList<>();

        organizers.add(Organizer.builder()
                .id(1L)
                .name("The Rocker")
                .organization("Rock")
                .address("Moon Hill")
                .build());

        organizers.add(Organizer.builder()
                .id(2L)
                .name("The Shark")
                .organization("Shark")
                .address("Ocean")
                .build());

        organizers.add(Organizer.builder()
                .id(3L)
                .name("The Runner")
                .organization("Runner")
                .address("Jungle")
                .build());

        organizers.add(Organizer.builder()
                .id(4L)
                .name("The Biker")
                .organization("Biker")
                .address("Mountain")
                .build());

        organizers.add(Organizer.builder()
                .id(5L)
                .name("The Climber")
                .organization("Climber")
                .address("Mountain")
                .build());

        organizers.add(Organizer.builder()
                .id(6L)
                .name("The Diver")
                .organization("Diver")
                .address("Ocean")
                .build());
    }

    @Override
    public Integer getOrganizerSize() {
        return organizers.size();
    }

    @Override
    public Page<Organizer> getOrganizers(Integer pageSize, Integer page) {
        pageSize = pageSize == null ? organizers.size() : pageSize;
        page = page == null ? 1 : page;

        int firstIndex = (page - 1) * pageSize;

        return new PageImpl<>(organizers.subList(firstIndex, Math.min(firstIndex + pageSize, organizers.size())), PageRequest.of(page - 1, pageSize), organizers.size());
    }

    @Override
    public Organizer getOrganizer(Long id) {
        return organizers.stream().filter(organizer -> organizer.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Organizer save(Organizer organizer) {
        organizers.add(organizer);
        organizer.setId((long) organizers.size());
        return organizer;
    }
}
