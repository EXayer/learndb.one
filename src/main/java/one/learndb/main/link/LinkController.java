package one.learndb.main.link;

import one.learndb.main.link.exceptions.CouldNotStoreException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/v1/link")
public class LinkController {

    private final LinkService service;

    @Autowired
    public LinkController(LinkService service) {
        this.service = service;
    }

    @GetMapping
    public List<Link> all() {
        return service.all();
    }

    @PostMapping
    public void create(@RequestBody Link link) {
        try {
            service.create(link);
        } catch (CouldNotStoreException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage(), ex);
        }
    }

    @PutMapping(path = "{linkId}")
    public void update(
            @PathVariable("linkId") Long id,
            @RequestParam(required = true) String url
    ) {
        service.update(id, url);
    }

    @DeleteMapping(path = "{linkId}")
    public void delete(@PathVariable("linkId") Long id) {
        service.delete(id);
    }
}
