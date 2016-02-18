package org.reactome.server.tools.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.reactome.server.diagram.converter.exception.DiagramNotFoundException;
import org.reactome.server.diagram.converter.exception.MissingStableIdentifierException;
import org.reactome.server.diagram.converter.graph.output.Graph;
import org.reactome.server.diagram.converter.layout.output.Diagram;
import org.reactome.server.diagram.converter.tools.DiagramConverter;
import org.reactome.server.tools.exception.DiagramMissingStableIdentifiers;
import org.reactome.server.tools.exception.DiagramNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Antonio Fabregat <fabregat@ebi.ac.uk>
 */
@RestController
@Api(value = "/diagram", description = "Pathway diagrams")
@RequestMapping("/diagram")
public class DiagramController {

    @Autowired
    private DiagramConverter diagramConverter;

    @ApiOperation(value = "Retrieve the pathway diagram in a JSON format", response = Diagram.class, produces = "application/json")
    @RequestMapping(value = "/layout/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Diagram getDiagramLayout(@ApiParam(value="Pathway identifier [StId or DbId]",required = true) @PathVariable String id)  {
        try {
            return diagramConverter.getDiagram(id);
        } catch (DiagramNotFoundException diagramNotFound) {
            throw new DiagramNotFound(id);
        } catch (MissingStableIdentifierException e) {
            throw new DiagramMissingStableIdentifiers(e.getMessage());
        }
    }

    @ApiOperation(value = "Retrieve the pathway diagram in a JSON format", response = Graph.class, produces = "application/json")
    @RequestMapping(value = "/graph/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Graph getDiagramGraph(@ApiParam(value="Pathway identifier [StId or DbId]",required = true) @PathVariable String id)  {
        try {
            return diagramConverter.getGraph(id);
        } catch (Exception e) {
            throw new DiagramNotFound(id);
        }
    }
}
