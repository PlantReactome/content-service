package org.reactome.server.service.controller.graph;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.reactome.server.graph.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Florian Korninger (florian.korninger@ebi.ac.uk)
 * @author Antonio Fabregat (fabregat@ebi.ac.uk)
 */
@RestController
@Api(tags = "database", description = "Reactome Data: Database info queries")
@RequestMapping("/data")
public class GeneralController {

    @Autowired
    private GeneralService generalService;

    @ApiOperation(value = "The name of current database")
    @RequestMapping(value = "/database/name", method = RequestMethod.GET, produces = "text/plain")
    @ResponseBody
    public String getDBName()  {
        return generalService.getDBName();
    }

    @ApiOperation(value = "The version number of current database")
    @RequestMapping(value = "/database/version", method = RequestMethod.GET, produces = "text/plain")
    @ResponseBody
    public String getDBVersion()  {
        return "" + generalService.getDBVersion();
    }
}
