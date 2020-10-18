import { LogHandler } from "../Helper/Log";
import { Machine, OperationMode, Position } from "../models/Machine";

export class MachineInstance implements Machine {

    machineDetails: { model: string; serialNumber: number; sparDistance: number; };
    operation: { power: boolean; statusLED: { green: boolean; yellow: boolean; red: boolean; }; running: boolean; operationMode: OperationMode; };
    injectionUnit: { position: Position; };
    savetyDoor: { position: Position; locked: boolean; };
    lockingUnit: { locked: boolean; position: Position; };
    materialInfo: { temp: number; material: string; }

    constructor() {
        this.machineDetails = { model: "Allrounder", serialNumber: 123456, sparDistance: 500 };
        this.operation = { power: false, statusLED: { green: false, yellow: false, red: false, }, running: false, operationMode: OperationMode.semiAutomatic };
        this.injectionUnit = { position: { max: 500, min: 0, x: 500 } };
        this.savetyDoor = { position: { max: 500, min: 0, x: 500 }, locked: false };
        this.lockingUnit = { locked: false, position: { max: 500, min: 0, x: 500 }, };
        this.materialInfo = { temp: 0, material: "pp" };
    }

    powerOn() {
        this.operation.power = true;
        this.operation.statusLED.red = true;
    };

    resetToDefault() {
        this.machineDetails = { model: "Allrounder", serialNumber: 123456, sparDistance: 500 };
        this.operation = { power: false, statusLED: { green: false, yellow: false, red: false, }, running: false, operationMode: OperationMode.semiAutomatic };
        this.injectionUnit = { position: { max: 500, min: 0, x: 500 } };
        this.savetyDoor = { position: { max: 500, min: 0, x: 500 }, locked: false };
        this.lockingUnit = { locked: false, position: { max: 500, min: 0, x: 500 }, };
        this.materialInfo = { temp: 0, material: "pp" };
    };

    setMachineMode(data: OperationMode) {
        if (data == OperationMode.automatic || data == OperationMode.semiAutomatic) {
            this.operation.operationMode = data;
        } else {
            LogHandler.getLogInstance().log("error while setting machine mode");
        }
    }

    // Automated Workflow

    startAutomatedWorkflow() {
        if (this.operation.operationMode == OperationMode.automatic) {
            console.log("Workflow started!");
            this.closeLockingUnit(this.mountInjectionUnit);
        } else {
            console.log("Worklow could not get started");
        }
    }

    closeLockingUnit = (next: Function) => {

        console.log("Workflow operation1");

        if(this.operation.operationMode == OperationMode.automatic) setTimeout(() => { next(this.injectMaterial); }, 1000);
    }

    mountInjectionUnit = (next: Function) => {

        console.log("Workflow operation2");

        if(this.operation.operationMode == OperationMode.automatic) setTimeout(() => { next(this.unmountInjectionUnit); }, 1000);
    }

    injectMaterial = (next: Function) => {

        console.log("Workflow operation3");

        if(this.operation.operationMode == OperationMode.automatic) setTimeout(() => { next(this.wait);}, 1000);
    }

    unmountInjectionUnit = (next: Function) => {

        console.log("Workflow operation4");

        if(this.operation.operationMode == OperationMode.automatic) setTimeout(() => { next(this.openLockingUnit);}, 1000);
    }

    wait = (next: Function) => {

        console.log("Workflow operation5");

        if(this.operation.operationMode == OperationMode.automatic) setTimeout(() => { next(this.closeLockingUnit);}, 1000);
    }

    openLockingUnit = (next: Function) => {

        console.log("Workflow operation6");

        if(this.operation.operationMode == OperationMode.automatic) setTimeout(() => { next(this.mountInjectionUnit);}, 1000);
    }
}