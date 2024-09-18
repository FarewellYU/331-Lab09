package se331.lab.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se331.lab.entity.Event;
import se331.lab.entity.Organizer;
import se331.lab.repository.EventRepository;
import se331.lab.repository.OrganizerRepository;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {

    final EventRepository eventRepository;
    final OrganizerRepository organizerRepository;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        eventRepository.save(Event.builder()
                .category("Academic")
                .title("Midterm Exam")
                .description("A time for taking the exam")
                .location("CAMT Building")
                .date("3rd Sept")
                .time("3.00-4.00 pm")
                .petAllowed(false)
                .organizer("CAMT")
                .build());


        eventRepository.save(Event.builder()
                .category("Academic")
                .title("Commencement Day")
                .description("A time for celebration")
                .location("CMU Convention Hall")
                .date("21st Jan")
                .time("8.00-4.00 pm")
                .petAllowed(false)
                .organizer("CMU")
                .build());

        eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Loy Krathong")
                .description("A time for Krathong")
                .location("Ping River")
                .date("21st Nov")
                .time("8.00-10.00 pm.")
                .petAllowed(false)
                .organizer("CAMT")
                .build());

        eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Songkran")
                .description("Let's Play Water")
                .location("Chiang Mai Moat")
                .date("13th April")
                .time("10.00-6.00 pm.")
                .petAllowed(true)
                .organizer("Chiang Mai Municipality")
                .build());

        organizerRepository.save(Organizer.builder()
                .name("CAMT")
                .organization("CMU")
                .address("CAMT Building")
                .build());

        organizerRepository.save(Organizer.builder()
                .name("CMU")
                .organization("CMU")
                .address("CMU Convention Hall")
                .build());

        organizerRepository.save(Organizer.builder()
                .name("Chiang Mai Municipality")
                .organization("Chiang Mai Municipality")
                .address("Chiang Mai Moat")
                .build());

        organizerRepository.save(Organizer.builder()
                .name("Chiang Mai Municipality")
                .organization("Chiang Mai Municipality")
                .address("Chiang Mai Moat")
                .build());

    }
}
