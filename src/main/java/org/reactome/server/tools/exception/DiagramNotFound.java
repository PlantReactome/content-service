package org.reactome.server.tools.exception;

import org.springframework.http.HttpStatus;

/**
 * @author Antonio Fabregat <fabregat@ebi.ac.uk>
 */
public class DiagramNotFound extends ContentServiceException {

    public DiagramNotFound(String identifier) {
        super(HttpStatus.NOT_FOUND, "No pathway diagram found for " + identifier);
    }

}
