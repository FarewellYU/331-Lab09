package se331.lab.dao;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import se331.lab.entity.Organizer;
import se331.lab.repository.EventRepository;
import se331.lab.repository.OrganizerRepository;

@Repository
@Profile("db")
@AllArgsConstructor
public class OrganizerDaoDbImpl implements OrganizerDao {

    final OrganizerRepository organizerRepository;

    @Override
    public Integer getOrganizerSize() {
        return Math.toIntExact(organizerRepository.count());
    }

    @Override
    public Page<Organizer> getOrganizers(Integer pageSize, Integer page) {
        pageSize = pageSize == null ? 10 : pageSize;
        page = page == null ? 1 : page;
        return organizerRepository.findAll(PageRequest.of(page - 1, pageSize));
    }

    @Override
    public Organizer getOrganizer(Long id) {
        return organizerRepository.findById(id).orElse(null);
    }

    @Override
    public Organizer save(Organizer organizer) {
        return organizerRepository.save(organizer);
    }
}
