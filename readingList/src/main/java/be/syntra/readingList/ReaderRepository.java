package be.syntra.readingList;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ReaderRepository
         extends JpaRepository<Reader, String> {
}