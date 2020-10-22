import * as express from "express";
import {DatabaseHandler } from "../Helper/Database";
import { LogHandler } from "../Helper/Log";
import { MachineInstance } from "../Machines/MachineInstance";
import { OperationMode } from "../models/Machine";

const router = express.Router();

/* GET home page. */
router.get("/", function(req, res, next) {

  let machine: MachineInstance = new MachineInstance("Machine1");

  res.json(DatabaseHandler.getDbInstance().getAll())
});

export default router;