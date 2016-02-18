package org.reactome.server.tools.exception;

import org.springframework.http.HttpStatus;

/**
 * @author Antonio Fabregat <fabregat@ebi.ac.uk>
 */
public class DiagramMissingStableIdentifiers extends ContentServiceException {

    public DiagramMissingStableIdentifiers(String message) {
        super(HttpStatus.PRECONDITION_FAILED, message);
    }
}
