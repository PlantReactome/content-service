package org.reactome.server.tools.exception;

import org.springframework.http.HttpStatus;

/**
 * @author Antonio Fabregat <fabregat@ebi.ac.uk>
 */
public class PsicquicContentError extends ContentServiceException {

    public PsicquicContentError(Throwable t) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, "Exception while querying PSICQUIC: " + t.getMessage());
    }
}
