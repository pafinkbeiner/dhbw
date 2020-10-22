"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.MachineInstance = void 0;
var MachineInstance = /** @class */ (function () {
    function MachineInstance(name, data) {
        this.name = name;
        this.data = data;
    }
    MachineInstance.prototype.action = function () {
        console.log("This is a message from : " + this.name + " with message: " + this.data);
    };
    return MachineInstance;
}());
exports.MachineInstance = MachineInstance;
