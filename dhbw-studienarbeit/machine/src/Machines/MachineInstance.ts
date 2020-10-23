import { DatabaseHandler } from "../Helper/Database";
import { LogHandler } from "../Helper/Log";
import { Machine, OperationMode } from "../models/Machine";
import { MachineTemplate } from "../models/MachineTemplate";

export class MachineInstance implements MachineTemplate{

    private _machineData: Machine;
    
    get machineData(){
        return this._machineData;
    }
    set machineData(machine: Machine){
        this._machineData = machine;
        this.persistData();
    }

    constructor(name: string){
        this._machineData = 
            {
                name: name,
                machineDetails : { model: "Allrounder", serialNumber: 123456, sparDistance: 500 , maxClosingForce: 1000},
                operation : { power: false, statusLED: { green: false, yellow: false, red: false, }, running: false, operationMode: OperationMode.semiAutomatic },
                injectionUnit : { position: { max: 500, min: 0, x: 500 }, fillingLevel: { level: 0, minLevel: 0, maxLevel: 100 }, windowLocked: true},
                savetyDoor : { position: { max: 500, min: 0, x: 500 }, locked: false },
                lockingUnit : { locked: false, position: { max: 500, min: 0, x: 500 }, closingForce: {force: 0, maxForce: 1000, minForce: 0}},
                materialInfo : { temp: 0, material: "pp" , pressure: {force: 0, maxForce: 1000, minForce: 0}},
            };
        this.persistData();
    }

    // Function to check if the value change of property machineData is valid
    checkConstraints(){
        return true;
    }

    powerOn() {
        this.machineData.operation.power = true;
        this.machineData.operation.statusLED.red = true;
    };

    resetToDefault() {
        this.machineData.machineDetails = { model: "Allrounder", serialNumber: 123456, sparDistance: 500 , maxClosingForce: 1000};
        this.machineData.operation = { power: false, statusLED: { green: false, yellow: false, red: false, }, running: false, operationMode: OperationMode.semiAutomatic };
        this.machineData.injectionUnit = { position: { max: 500, min: 0, x: 500 }, fillingLevel: { level: 0, minLevel: 0, maxLevel: 100 }, windowLocked: true};
        this.machineData.savetyDoor = { position: { max: 500, min: 0, x: 500 }, locked: false };
        this.machineData.lockingUnit = { locked: false, position: { max: 500, min: 0, x: 500 }, closingForce: {force: 0, maxForce: 1000, minForce: 0}};
        this.machineData.materialInfo = { temp: 0, material: "pp" , pressure: {force: 0, maxForce: 1000, minForce: 0}};
    };

    setMachineMode(data: OperationMode) {
        if (data == OperationMode.automatic || data == OperationMode.semiAutomatic) {
            this.machineData.operation.operationMode = data;
        } else {
            LogHandler.getLogInstance().log("error while setting machine mode");
        }
    }

    // Automated Workflow

    startAutomatedWorkflow() {
        if (this.machineData.operation.operationMode == OperationMode.automatic && this.machineData.operation.power == true) {
            console.log("Workflow started!");
            this.closeLockingUnit(this.mountInjectionUnit);
        } else {
            console.log("Worklow could not get started");
        }
    }

    closeLockingUnit = (next: Function) => {

        
        if(this.machineData.operation.operationMode == OperationMode.automatic) setTimeout(() => { next(this.injectMaterial); }, 1000);
    }

    mountInjectionUnit = (next: Function) => {

        console.log("Workflow operation2");

        if(this.machineData.operation.operationMode == OperationMode.automatic) setTimeout(() => { next(this.unmountInjectionUnit); }, 1000);
    }

    injectMaterial = (next: Function) => {

        console.log("Workflow operation3");

        if(this.machineData.operation.operationMode == OperationMode.automatic) setTimeout(() => { next(this.wait);}, 1000);
    }

    unmountInjectionUnit = (next: Function) => {

        console.log("Workflow operation4");

        if(this.machineData.operation.operationMode == OperationMode.automatic) setTimeout(() => { next(this.openLockingUnit);}, 1000);
    }

    wait = (next: Function) => {

        console.log("Workflow operation5");

        if(this.machineData.operation.operationMode == OperationMode.automatic) setTimeout(() => { next(this.closeLockingUnit);}, 1000);
    }

    openLockingUnit = (next: Function) => {

        console.log("Workflow operation6");

        if(this.machineData.operation.operationMode == OperationMode.automatic) setTimeout(() => { next(this.mountInjectionUnit);}, 1000);
    }

    persistData(){
        setInterval(() => {
            DatabaseHandler.getDbInstance().set(this.machineData.name, this);
        }, 1000);
    }

}