package one.learndb.main.link.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Link Not Found")
public class LinkNotFoundException extends RuntimeException {

    public LinkNotFoundException(Long id) {
        super("Could not find link " + id);
    }
}
