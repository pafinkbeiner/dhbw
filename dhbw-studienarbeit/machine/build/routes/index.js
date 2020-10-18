"use strict";
var __createBinding = (this && this.__createBinding) || (Object.create ? (function(o, m, k, k2) {
    if (k2 === undefined) k2 = k;
    Object.defineProperty(o, k2, { enumerable: true, get: function() { return m[k]; } });
}) : (function(o, m, k, k2) {
    if (k2 === undefined) k2 = k;
    o[k2] = m[k];
}));
var __setModuleDefault = (this && this.__setModuleDefault) || (Object.create ? (function(o, v) {
    Object.defineProperty(o, "default", { enumerable: true, value: v });
}) : function(o, v) {
    o["default"] = v;
});
var __importStar = (this && this.__importStar) || function (mod) {
    if (mod && mod.__esModule) return mod;
    var result = {};
    if (mod != null) for (var k in mod) if (k !== "default" && Object.prototype.hasOwnProperty.call(mod, k)) __createBinding(result, mod, k);
    __setModuleDefault(result, mod);
    return result;
};
Object.defineProperty(exports, "__esModule", { value: true });
var express = __importStar(require("express"));
var PubSub_1 = require("../Helper/PubSub");
var MachineInstance_1 = require("../Machines/MachineInstance");
var router = express.Router();
/* GET home page. */
router.get("/", function (req, res, next) {
    var machine1 = new MachineInstance_1.MachineInstance("machine1", "payload1");
    var machine2 = new MachineInstance_1.MachineInstance("machine2", "payload2");
    PubSub_1.PubSub.subscribe("Event1", function (str) { console.log(str); });
    PubSub_1.PubSub.subscribe("Event2", function (machine2) { machine2.action(); });
    console.log("Subscribed successfully");
    PubSub_1.PubSub.emit("Event1", "Data1");
    PubSub_1.PubSub.emit("Event2", "Data2");
    res.send("Hey");
});
exports.default = router;
