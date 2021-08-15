package one.learndb.main.link;

import one.learndb.main.link.exceptions.CouldNotStoreException;
import one.learndb.main.link.exceptions.LinkNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class LinkService {

    private final LinkRepository repository;

    @Autowired
    public LinkService(LinkRepository linkRepository) {
        this.repository = linkRepository;
    }

    public List<Link> all() {
        return repository.findAll();
    }

    public void create(Link link) {
        Optional<Link> optionalLink = repository.findLinkByUrl(link.getUrl());

        if (optionalLink.isPresent()) {
           throw CouldNotStoreException.linkAlreadyExists();
        }

        repository.save(link);
    }

    @Transactional
    public void update(Long id, String url) {
        Link link = repository.findById(id)
                .orElseThrow(() -> new LinkNotFoundException(id));

        if (url != null && url.length() > 0) {
            Optional<Link> optionalLink = repository.findLinkByUrl(url);

            if (optionalLink.isPresent()) {
                throw CouldNotStoreException.linkAlreadyExists();
            }

            link.setUrl(url);
        }
    }

    public void delete(Long id) {
        boolean exists = repository.existsById(id);

        if (!exists) {
            throw new LinkNotFoundException(id);
        }

        repository.deleteById(id);
    }
}
