package org.reactome.server.tools.exception;

import org.springframework.http.HttpStatus;

/**
 * @author Antonio Fabregat <fabregat@ebi.ac.uk>
 */
public class DiagramNotFoundException extends ContentServiceException {

    public DiagramNotFoundException(String identifier) {
        super(HttpStatus.NOT_FOUND, "No pathway diagram found for " + identifier);
    }

}
