import * as express from "express";
import {DatabaseHandler } from "../Helper/Database";
import { LogHandler } from "../Helper/Log";
import { MachineInstance } from "../Machines/MachineInstance";
import { OperationMode } from "../models/Machine";

const router = express.Router();

/* GET home page. */
router.get("/", function(req, res, next) {

  let machine: MachineInstance = new MachineInstance();
  machine.operation.operationMode = OperationMode.automatic;
  machine.startAutomatedWorkflow();


  res.json(DatabaseHandler.getDbInstance().getAll())
});

export default router;