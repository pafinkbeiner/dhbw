import * as express from "express";
import {DatabaseHandler } from "../Helper/Database";
import { LogHandler } from "../Helper/Log";
import { MachineInstance } from "../Machines/MachineInstance";
import { OperationMode } from "../models/Machine";

const router = express.Router();

/* GET home page. */
router.get("/", function(req, res, next) {
  res.json(DatabaseHandler.getDbInstance().getAll())
});

router.get("/new/:id", function(req, res, next){
  let machine: MachineInstance = new MachineInstance(req.params.id || "Machine");
  machine.machineData.savetyDoor.locked = true;
  machine.powerOn();
  machine.setMachineMode(OperationMode.automatic);
  res.send(machine.startAutomatedWorkflow());
});

export default router;