import * as express from "express";
import {DatabaseHandler } from "../Helper/Database";
import { MachineInstance } from "../Machines/MachineInstance";

const router = express.Router();

// Array with all machines
let machines: Array<MachineInstance> = [];

/* GET home page. */
router.get("/", function(req, res, next) {
  res.json(DatabaseHandler.getDbInstance().getAll())
});

router.get("/new/:name", function(req, res, next){
  let machine: MachineInstance = new MachineInstance(req.params.name);
  machines.push(machine);
  res.json({id: machine.id});
});

router.get("/delete/:id", function(req, res, next){

    if(machines.find(item => item.id == req.params.id) != undefined){
        DatabaseHandler.getDbInstance().remove(req.params.id)
        machines = machines.filter(item => item.id != req.params.id);
        res.json("Successfully Deleted Machine with id: "+req.params.id);
    }else{
        res.json("No machine found!");
    }
});

export default router;